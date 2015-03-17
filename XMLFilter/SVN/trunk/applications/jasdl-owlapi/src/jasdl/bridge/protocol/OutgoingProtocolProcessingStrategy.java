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

import jasdl.JASDLParams;
import jasdl.bridge.JASDLOntologyManager;
import jasdl.bridge.factory.SELiteralFactory;
import jasdl.bridge.seliteral.SELiteral;
import jasdl.bridge.seliteral.SELiteralAllDifferentAssertion;
import jasdl.util.exception.JASDLException;
import jasdl.util.exception.JASDLNotEnrichedException;
import jasdl.util.exception.JASDLUnknownMappingException;
import jason.asSyntax.ListTerm;
import jason.asSyntax.ListTermImpl;
import jason.asSyntax.Literal;
import jason.asSyntax.StringTerm;
import jason.asSyntax.StringTermImpl;
import jason.asSyntax.Structure;
import jason.asSyntax.Term;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashSet;
import java.util.Set;

import org.semanticweb.owl.model.OWLEntity;
import org.semanticweb.owl.model.OWLIndividual;
import org.semanticweb.owl.model.OWLOntology;

public class OutgoingProtocolProcessingStrategy implements ProtocolProcessingStrategy {

    private SELiteralFactory SELiteralFactory;

    public OutgoingProtocolProcessingStrategy(SELiteralFactory SELiteralFactory) {
        this.SELiteralFactory = SELiteralFactory;
    }

    /**
     * Only applies processing if l is SE-Literal, otherwise l is returned as is
     * Replaces ontology label with physical uri
     * Adds expr annotation unambiguously describing what is meant by alias
     * Adds origin annotation if literal refers to defined class
     * @param l
     * @throws JASDLException
     */
    public Literal process(Literal l, JASDLOntologyManager jom) throws JASDLException {
        jom.getLogger().fine("Processing outgoing " + l);

        Literal result = l;
        try {
            SELiteral sl = SELiteralFactory.construct(l);

            OWLEntity entity = (OWLEntity) sl.toOWLObject();
            String expression = jom.getManchesterURIOWLObjectRenderer().render(entity);

            StringTerm expressionTerm = new StringTermImpl(expression);

            if (entity.isOWLClass() && jom.getDefinitionManager().isKnownLeft(entity.asOWLClass())) { // we have an anonymous run-time defined class

                // construct anon annotation
                Structure anon = new Structure(JASDLParams.ANON_ANNOTATION_FUNCTOR);

                // add the class expression
                anon.addTerm(expressionTerm);

                // add set of prerequisite ontologies
                Set<OWLOntology> prereqs = new HashSet<OWLOntology>();
                String[] tokens = expression.toString().split("[ |\n]");
                for (String token : tokens) {
                    try {
                        URI entityURI = new URI(token);
                        URI ontologyURI = new URI(entityURI.getScheme(), entityURI.getSchemeSpecificPart(), null);
                        prereqs.add(jom.getLogicalURIManager().getLeft(ontologyURI));
                    } catch (URISyntaxException e) {
                        // do nothing, probably a keyword
                    } catch (JASDLUnknownMappingException e) {
                        // do nothing, probably a keyword
                    }
                }
                ListTerm list = new ListTermImpl();
                for (OWLOntology prereq : prereqs) {
                    list.add(new StringTermImpl(jom.getPhysicalURIManager().getRight(prereq).toString()));
                }
                anon.addTerm(list);

                // add the (personal) ontology this is from
                StringTerm personalURI = new StringTermImpl(jom.getPhysicalURIManager().getRight(sl.getOntology()).toString());
                anon.addTerm(personalURI);

                sl.getLiteral().addAnnot(anon);
                
                jom.getLogger().fine("Sending anonymous "+sl);

            } else {

                // unambiguously refer to named entity  
                StringTerm ontologyURITerm = new StringTermImpl(jom.getPhysicalURIManager().getRight(sl.getOntology()).toString());
                if ((sl instanceof SELiteralAllDifferentAssertion)) {// special case for all_different
                    Structure all_different = new Structure(JASDLParams.ALL_DIFFERENT_ANNOTATION_FUNCTOR);
                    all_different.addTerm(ontologyURITerm);
                    sl.getLiteral().addAnnot(all_different);
                } else {
                    Structure named = new Structure(JASDLParams.NAMED_ANNOTATION_FUNCTOR);
                    named.addTerm(expressionTerm);
                    // add ontology this naming is from
                    named.addTerm(ontologyURITerm);
                    sl.getLiteral().addAnnot(named);
                }

            }

            // unambiguously refer to any nested individuals ("i" annotation). terms of "i" are relative to terms of literal
            Structure iAnnot = new Structure(JASDLParams.I_ANNOTATION_FUNCTOR);
            if (sl instanceof SELiteralAllDifferentAssertion) { // for all_different assertions
                ListTerm translations = new ListTermImpl();
                SELiteralAllDifferentAssertion ad = sl.asAllDifferentAssertion();
                //Set<OWLIndividual> is = ad.getOWLIndividuals(); <- can't use this! We need to impose an ordering
                ListTerm originals = (ListTerm) ad.getLiteral().getTerm(0);
                for (Term original : originals) {
                    OWLIndividual i = sl.getOWLIndividual(original);
                    URI uri = i.getURI();
                    translations.add(new StringTermImpl(uri.toString()));
                }
                iAnnot.addTerm(translations);
            } else { // for class and property assertions
                for (int i = 0; i < sl.getLiteral().getArity(); i++) { // for each ground atomic term of literal
                    Term term = sl.getLiteral().getTerm(i);
                    if (term.isGround() && term.isAtom()) {
                        URI uri = sl.getOWLIndividual(i).getURI();
                        iAnnot.addTerm(new StringTermImpl(uri.toString()));
                    } else {
                        iAnnot.addTerm(JASDLParams.NO_INDIVIDUAL_MAPPING); // <- added so subject / objects mappings can be easily distinguished by maintenance of relative positions for object properties
                    }
                }
            }
            sl.getLiteral().addAnnot(iAnnot);

            sl.getLiteral().delAnnot(sl.getOntologyAnnotation()); // drop "o" before sending

            result = sl.getLiteral();
        } catch (JASDLNotEnrichedException e) {
            // do nothing
            //e.printStackTrace();
        }
        return result;
    }



}
