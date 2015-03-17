/* 
 *  Copyright (C) 2008 Thomas Klapiscak (t.g.klapiscak@durham.ac.uk)
 *  
 *  This file is part of JASDL.
 *
 *  JASDL is free software: you can redistribute it and/or modify
 *  it under the terms of the Lesser GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *
 *  JASDL is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  Lesser GNU General Public License for more details.
 *
 *  You should have received a copy of the Lesser GNU General Public License
 *  along with JASDL.  If not, see <http://www.gnu.org/licenses/>.
 *  
 */
package jasdl.bridge.protocol;

import static jasdl.util.JASDLCommon.strip;
import jasdl.JASDLParams;
import jasdl.bridge.JASDLOntologyManager;
import jasdl.bridge.mapping.aliasing.Alias;
import jasdl.bridge.mapping.aliasing.MappingStrategy;
import jasdl.bridge.seliteral.SELiteral;
import jasdl.util.exception.JASDLException;
import jasdl.util.exception.JASDLMessageContentException;
import jasdl.util.exception.JASDLNotEnrichedException;
import jasdl.util.exception.JASDLUnknownMappingException;
import jason.asSyntax.Atom;
import jason.asSyntax.ListTerm;
import jason.asSyntax.ListTermImpl;
import jason.asSyntax.Literal;
import jason.asSyntax.StringTerm;
import jason.asSyntax.Structure;
import jason.asSyntax.Term;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import org.semanticweb.owl.model.OWLEntity;
import org.semanticweb.owl.model.OWLException;
import org.semanticweb.owl.model.OWLOntology;

public class IncomingProtocolProcessingStrategy implements ProtocolProcessingStrategy {

    private List<MappingStrategy> mappingStrategies;

    public IncomingProtocolProcessingStrategy(List<MappingStrategy> mappingStrategies) {
        this.mappingStrategies = mappingStrategies;
    }

    public Literal process(Literal l, JASDLOntologyManager jasdlOntologyManager) throws JASDLException {
        try {
            jasdlOntologyManager.getLogger().fine("Processing incoming " + l);

            SELiteral sl = new SELiteral(l, jasdlOntologyManager); // <- NOTE: might not actually be an SE-Literal!
            processAllDifferent(sl, jasdlOntologyManager);
            processNamed(sl, jasdlOntologyManager);
            processAnon(sl, jasdlOntologyManager);
            processIndividuals(sl, jasdlOntologyManager); // <- MUST be performed last (since we need o annotation to be added)

            return sl.getLiteral();
        } catch (JASDLNotEnrichedException e) {
            // do nothing
        }
        return l;

    }

    private void processAllDifferent(SELiteral sl, JASDLOntologyManager jasdlOntologyManager) throws JASDLMessageContentException {
        List<Term> allDifferentAnnots = sl.getLiteral().getAnnots(JASDLParams.ALL_DIFFERENT_ANNOTATION_FUNCTOR).getAsList();
        if (allDifferentAnnots.size() > 1) {
            throw new JASDLMessageContentException("Multiple " + JASDLParams.ALL_DIFFERENT_ANNOTATION_FUNCTOR + " annotations preset");
        } else if (allDifferentAnnots.size() == 1) {
            Term _allDifferentAnnot = allDifferentAnnots.get(0);
            if (!_allDifferentAnnot.isStructure())
                throw new JASDLMessageContentException(_allDifferentAnnot + " must be a structure");
            Structure allDifferentAnnot = (Structure) _allDifferentAnnot;

            // get ontology
            Term ontologyTerm = allDifferentAnnot.getTerm(0);
            if (!(ontologyTerm instanceof StringTerm))
                throw new JASDLMessageContentException("second term of " + JASDLParams.NAMED_ANNOTATION_FUNCTOR + " must be a string");
            String _uri = ontologyTerm.toString();

            // try loading the ontology, if fails create it (we don't know whether this ontology is personal or not here!)
            OWLOntology ontology;
            try {
                ontology = jasdlOntologyManager.loadOntology(_uri, mappingStrategies);
            } catch (JASDLException e) {
                try {
                    ontology = jasdlOntologyManager.createOntology(_uri, true);
                } catch (JASDLException e1) {
                    throw new JASDLMessageContentException("Unable to create ontology", e);
                }
            }
            // add "o" annotation with label (may be anonymous if ontology was novel or personal)
            Structure o = new Structure(JASDLParams.ONTOLOGY_ANNOTATION_FUNCTOR);
            try {
                o.addTerm(jasdlOntologyManager.getLabelManager().getLeft(ontology));
            } catch (JASDLUnknownMappingException e) {
                throw new JASDLMessageContentException("Ontology creation failed", e);
            }
            sl.getLiteral().addAnnot(o);

            sl.getLiteral().delAnnot(allDifferentAnnot);

        }
    }

    private void processIndividuals(SELiteral sl, JASDLOntologyManager jasdlOntologyManager) throws JASDLMessageContentException {
        List<Term> iAnnots = sl.getLiteral().getAnnots(JASDLParams.I_ANNOTATION_FUNCTOR).getAsList();
        if (iAnnots.size() > 1) {
            throw new JASDLMessageContentException("Multiple " + JASDLParams.I_ANNOTATION_FUNCTOR + " annotations present");
        } else if (iAnnots.size() == 1) {
            try {
                Term _iAnnot = iAnnots.get(0);
                if (!_iAnnot.isStructure())
                    throw new JASDLMessageContentException(_iAnnot + " must be a structure");
                Structure iAnnot = (Structure) _iAnnot;

                if (sl.getLiteral().getFunctor().equals(JASDLParams.OWL_ALL_DIFFERENT_FUNCTOR.toString())) { // for all_different assertions
                    ListTerm uris = (ListTerm) iAnnot.getTerm(0);
                    ListTerm originals = (ListTerm) sl.getLiteral().getTerm(0); // must be a list term
                    ListTerm translations = new ListTermImpl();
                    int i = 0;
                    for (Term uriTerm : uris) {
                        try {
                            translations.add(translateIndividualURIStringTerm(uriTerm, jasdlOntologyManager));
                        } catch (JASDLUnknownMappingException e) {
                            // individual is not known, leave it as it is
                            translations.add(originals.get(i));
                        }
                        i++;
                    }
                    sl.getLiteral().setTerm(0, translations);
                } else { // for class and property assertions   
                    for (int i = 0; i < sl.getLiteral().getArity(); i++) { // for each ground atomic term - handles classes and object properies. terms of i annotation are relative to literal terms
                        Term term = sl.getLiteral().getTerm(i);
                        if (term.isGround() && term.isAtom()) {
                            // get the URI relative to this term
                            if (iAnnot.getArity() - 1 < i)
                                throw new JASDLMessageContentException("Insufficient arity");
                            try {
                                sl.getLiteral().setTerm(i, translateIndividualURIStringTerm(iAnnot.getTerm(i), jasdlOntologyManager));
                            } catch (JASDLUnknownMappingException e) {
                                // individual is not known, leave it as it is
                            }
                        }
                    }
                }
                sl.getLiteral().delAnnot(iAnnot); // drop i, no longer needed   
            } catch (JASDLMessageContentException e) {
                throw new JASDLMessageContentException("Unable to translate individuals for " + sl, e);
            }
        }
    }

    private Atom translateIndividualURIStringTerm(Term _uriTerm, JASDLOntologyManager jasdlOntologyManager) throws JASDLMessageContentException, JASDLUnknownMappingException {
        if (!_uriTerm.isString())
            throw new JASDLMessageContentException(_uriTerm + " does not have a single string term");
        StringTerm uriTerm = (StringTerm) _uriTerm;
        URI uri;
        try {
            uri = new URI(strip(uriTerm.toString(), "\"")); // Quotes stripped
		} catch (URISyntaxException e) {
			throw new JASDLMessageContentException("Invalid URI supplied", e);
		}

		// if this agent is aware of an individual known by this uri, translate atom to local mapping (otherwise UnknownMappingException will be thrown)
		OWLEntity entity = jasdlOntologyManager.toEntity(uri);
		if (!entity.isOWLIndividual())
			throw new JASDLMessageContentException(uri + " is not an individual");
		Alias alias = jasdlOntologyManager.getAliasManager().getLeft(entity);
		// replace the atom functor with that of local alias
		return alias.getFunctor();
	}

	/**
	 * Applies processing to incoming SE-Literals possessing the "named" annotation, i.e. they refer to a class defined in the ontology schema.
	 * @param sl
	 * @param agent
	 * @return
	 * @throws JASDLException
	 */
	private void processNamed(SELiteral sl, JASDLOntologyManager jasdlOntologyManager) throws JASDLException {
		ListTerm nameds = sl.getLiteral().getAnnots(JASDLParams.NAMED_ANNOTATION_FUNCTOR);
		if (nameds.size() == 1) {

			// get named annotation
			Term _named = nameds.get(0);
			if (!(_named instanceof Structure)) {
				throw new JASDLException("Invalid " + JASDLParams.NAMED_ANNOTATION_FUNCTOR + " annotation: " + _named);
			}
			Structure named = (Structure) _named;
			if (named.getArity() != 2) {
				throw new JASDLException("Invalid " + JASDLParams.NAMED_ANNOTATION_FUNCTOR + " annotation arity: " + _named);
			}

			// get ontology
			Term ontologyTerm = named.getTerm(1);
			if (!(ontologyTerm instanceof StringTerm))
				throw new JASDLMessageContentException("second term of " + JASDLParams.NAMED_ANNOTATION_FUNCTOR + " must be a string");
			String _uri = named.getTerm(1).toString();
			OWLOntology ontology = jasdlOntologyManager.loadOntology(_uri, mappingStrategies); // may instantiate a new ontology with anonymous label

			// add "o" annotation with label (may be anonymous if ontology was novel)
			Structure o = new Structure(JASDLParams.ONTOLOGY_ANNOTATION_FUNCTOR);
			o.addTerm(jasdlOntologyManager.getLabelManager().getLeft(ontology));
			sl.getLiteral().addAnnot(o);

			// get entity URI
			Term expressionTerm = named.getTerm(0);
			if (!(expressionTerm instanceof StringTerm)) {
				throw new JASDLException("Invalid " + JASDLParams.NAMED_ANNOTATION_FUNCTOR + " annotation term: " + expressionTerm);
			}
			String expression = strip(expressionTerm.toString(), "\""); // quotes stripped

            URI uri;
            try {
                uri = new URI(expression);
            } catch (URISyntaxException e) {
                throw new JASDLException("Invalid entity URI in " + expression);
            }
            Alias local = jasdlOntologyManager.getAliasManager().getLeft(jasdlOntologyManager.toEntity(uri)); // will already be present by definition  

            // create new (SE) Literal
            sl.mutateFunctor(local.getFunctor().toString());

            sl.getLiteral().delAnnot(named); // drop named, no longer needed
        }
    }

    private void processAnon(SELiteral sl, JASDLOntologyManager jasdlOntologyManager) throws JASDLException {
        ListTerm anons = sl.getLiteral().getAnnots(JASDLParams.ANON_ANNOTATION_FUNCTOR);
        if (anons.size() == 1) {
            // Get Anon annotation
            Term _anon = anons.get(0);
            if (!(_anon instanceof Structure)) {
                throw new JASDLException("Invalid " + JASDLParams.ANON_ANNOTATION_FUNCTOR + " annotation: " + _anon);
            }
            Structure anon = (Structure) _anon;
            if (anon.getArity() != 3) {
                throw new JASDLException("Invalid " + JASDLParams.ANON_ANNOTATION_FUNCTOR + " annotation arity: " + _anon);
            }

            // Get expression
            Term expressionTerm = anon.getTerm(0);
            if (!(expressionTerm instanceof StringTerm)) {
                throw new JASDLException("Invalid " + JASDLParams.ANON_ANNOTATION_FUNCTOR + " annotation expression term: " + expressionTerm);
            }
            String expression = strip(expressionTerm.toString(), "\""); // quotes stripped

			// Parse prequisite ontology URIs
			Term prereqsTerm = anon.getTerm(1);
			if (!(prereqsTerm instanceof ListTerm)) {
				throw new JASDLException("Invalid " + JASDLParams.ANON_ANNOTATION_FUNCTOR + " annotation prereqs term: " + expressionTerm);
			}
			ListTerm prereqs = (ListTerm) prereqsTerm;
			for (Term _prereqTerm : prereqs) {
				if (!(_prereqTerm instanceof StringTerm)) {
					throw new JASDLException("Invalid " + JASDLParams.ANON_ANNOTATION_FUNCTOR + " prereq: " + _prereqTerm);
				}
				StringTerm prereqTerm = (StringTerm) _prereqTerm;
				String prereq = strip(prereqTerm.toString(), "\""); // quotes stripped                              
                jasdlOntologyManager.loadOntology(prereq, mappingStrategies); // <- may instantiate a new ontology
            }

            // Get (possibly instantiate) a personal ontology for this agent
            Term personalURITerm = anon.getTerm(2);
            if (!personalURITerm.isString())
                throw new JASDLMessageContentException("third term of " + JASDLParams.ANON_ANNOTATION_FUNCTOR + " must be a string");
            OWLOntology ontology;
            try {
                ontology = jasdlOntologyManager.getOntology(personalURITerm.toString());
            } catch (JASDLUnknownMappingException e) {
                // we have not recieved an anonymous class definition from this agent before, instantiate a personal placeholder ontology for them
                ontology = jasdlOntologyManager.createOntology(personalURITerm.toString(), true);
            }
            // add "o" annotation
            Structure o = new Structure(JASDLParams.ONTOLOGY_ANNOTATION_FUNCTOR);
            o.addTerm(jasdlOntologyManager.getLabelManager().getLeft(ontology));
            sl.getLiteral().addAnnot(o);

            // do we already know this expression?          
            Atom functor = new Atom(sl.getLiteral().getFunctor());
            try {
                jasdlOntologyManager.defineClass(functor, sl.getOntologyLabel(), expression, jasdlOntologyManager.getManchesterURIDescriptionParser()); // Instantiate defined expression
            } catch (OWLException e) {
                // do nothing
                throw new JASDLException("Error defining new class " + functor, e);
            }

            // drop anon annotation, no longer needed
            sl.getLiteral().delAnnot(anon);
        }

    }

}
