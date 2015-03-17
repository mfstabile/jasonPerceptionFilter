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
package jasdl.bridge.factory;

import jasdl.bb.bebops.JASDLKernelsetFilter;
import jasdl.bb.bebops.JASDLReasonerFactory;
import jasdl.bridge.JASDLOntologyManager;
import jasdl.bridge.mapping.aliasing.Alias;
import jasdl.bridge.mapping.aliasing.AllDifferentPlaceholder;
import jasdl.bridge.seliteral.SELiteral;
import jasdl.util.exception.JASDLException;
import jasdl.util.exception.JASDLInvalidSELiteralException;
import jasdl.util.owlapi.xsd.XSDVocabularyUtils;
import jason.asSyntax.Atom;
import jason.asSyntax.DefaultTerm;
import jason.asSyntax.Literal;
import jason.asSyntax.Term;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Vector;
import java.util.logging.Logger;

import org.mindswap.pellet.owlapi.Reasoner;
import org.semanticweb.owl.model.AddAxiom;
import org.semanticweb.owl.model.OWLAxiom;
import org.semanticweb.owl.model.OWLAxiomAnnotationAxiom;
import org.semanticweb.owl.model.OWLClassAssertionAxiom;
import org.semanticweb.owl.model.OWLConstant;
import org.semanticweb.owl.model.OWLDataPropertyAssertionAxiom;
import org.semanticweb.owl.model.OWLDifferentIndividualsAxiom;
import org.semanticweb.owl.model.OWLException;
import org.semanticweb.owl.model.OWLIndividual;
import org.semanticweb.owl.model.OWLIndividualAxiom;
import org.semanticweb.owl.model.OWLObjectPropertyAssertionAxiom;
import org.semanticweb.owl.model.OWLOntology;
import org.semanticweb.owl.model.OWLTypedConstant;
import org.semanticweb.owl.model.RemoveAxiom;
import org.semanticweb.owl.vocab.XSDVocabulary;

import bebops.pinpointing.KernelOperator;

/**
 * Accepts an arbitrary OWLIndividualAxiom and, depending on its type, creates a SE-Literal encoding of it.
 * Will always result in a ground SELiteral (since <code>OWLIndividualAxiom</code>s must always be ground)<p>
 * For example:
 * <ul>
 *  <li>ClassAssertion(Hotel hilton) -> hotel(hilton)[o(travel)]</li>
 *  <li>ObjectPropertyAssertion(hasRating hilton ThreeStarRating) -> hasRating(hilton,threeStarRating)[o(travel)]</li>
 *  <li>DifferentIndividuals( fourSeasons hilton ) -> all_different([hilton,fourSeasons])[o(travel)]</li>  
 * </ul>
 * Testing implicit in JasdlBeliefBaseTest.testGetCandidateBeliefs.
 * Asserted (and inferred if annotation gathering is enabled) annotations (stored as <code>OWLAxiomAnnotationAxiom</code>s) are fetched and added to any
 * constructed SE-Literals.
 * @author Tom Klapiscak
 *
 */
public class AxiomToSELiteralConverter {

    /**
     * The jom this converter is working on behalf of. Required for access to managers.
     */
    private JASDLOntologyManager jom;

    public AxiomToSELiteralConverter(JASDLOntologyManager jom){
        this.jom = jom;
    }

    /**
     * Fetches and deseralises and returns all ASSERTED annotations of the supplied axiom.
     * TODO: Shift to a factory?
     * @param sl
     */
    public List<Term> getAssertedAnnotations(OWLAxiom axiom) {
        List<Term> result = new Vector<Term>();
        // get annotations from all known ontologies
        for (OWLOntology ontology : jom.getOntologyManager().getOntologies()) {
            Set<OWLAxiomAnnotationAxiom> annotAxioms = axiom.getAnnotationAxioms(ontology);
            for (OWLAxiomAnnotationAxiom annotAxiom : annotAxioms) { // remember, possibly semantically-naive payload!
                Term annot = Literal.parse(annotAxiom.getAnnotation().getAnnotationValueAsConstant().getLiteral());
                result.add(annot);
            }
        }
        return result;
    }

    /**
     * Makes use of Bebops library to establish all axioms that in some way contribute to the entailement of this axiom 
     * and gathers their (asserted) annotations.
     */
    public List<Term> getInferredAnnotations(OWLAxiom axiom) throws JASDLException {
        try {
            List<Term> annots = new Vector<Term>();
            KernelOperator kernelOperator = new KernelOperator(jom.getOntologyManager(), new JASDLReasonerFactory(), jom.getLogger());
            //Set<OWLAxiom> supportingAxioms = OWLReasonerAdapter.flattenSetOfSets((kernelOperator.getKernelSet(axiom, true)));
            Set<OWLAxiom> supportingAxioms = (new JASDLKernelsetFilter()).filterSingleKernel((kernelOperator.getAllSupports(axiom)));
            getLogger().fine("Explanation for " + axiom + ": " + supportingAxioms);
            for (OWLAxiom supportingAxiom : supportingAxioms) {
                annots.addAll(getAssertedAnnotations(supportingAxiom));
            }
            getLogger().fine("Annotations: " + annots);
            return annots;
        } catch (OWLException e) {
            throw new JASDLException("Annotation gathering failed for " + axiom, e);
        }
    }

    /**
     * Utility method to get the annotations of an axiom as an array of terms within the ontology referenced by alias.
     * @see AxiomToSELiteralConverter#getAssertedAnnotations(OWLAxiom)
     * @see AxiomToSELiteralConverter#getInferredAnnotations(OWLAxiom)
     */
    private Term[] getAnnots(Alias alias, OWLAxiom axiom) throws JASDLException {
        List<Term> annots = getAssertedAnnotations(axiom);
        if (jom.isAnnotationGatheringEnabled())
            annots.addAll(getInferredAnnotations(axiom)); // optional, experimental feature
        return (Term[]) annots.toArray(new Term[annots.size()]);
    }

    /**
     * Polymorphically applies appropriate factory method depending on specialisation of axiom
     * @param axiom
     * @return
     * @throws JASDLException   if specialisation of axiom is not of an appropriate type for conversion to a SELiteral
     */
    public SELiteral convert(OWLIndividualAxiom axiom) throws JASDLException {
        if (axiom instanceof OWLClassAssertionAxiom) {
            return convert((OWLClassAssertionAxiom) axiom);
        } else if (axiom instanceof OWLObjectPropertyAssertionAxiom) {
            return convert((OWLObjectPropertyAssertionAxiom) axiom);
        } else if (axiom instanceof OWLDataPropertyAssertionAxiom) {
            return convert((OWLDataPropertyAssertionAxiom) axiom);
        } else if (axiom instanceof OWLDifferentIndividualsAxiom) {
            return convert((OWLDifferentIndividualsAxiom) axiom);
        } else {
            throw new JASDLException(axiom + " is not of an appropriate type for conversion to a SELiteral");
        }
    }

    /**
     * Convert an axiom asserting class membership to a unary SELiteral
     * @param axiom     the axiom to convert
     * @return          a unary SELiteral encoding of axiom
     * @throws JASDLException
     */
    public SELiteral convert(OWLClassAssertionAxiom axiom) throws JASDLException {
        Alias alias = jom.getAliasManager().getLeft(axiom.getDescription());
        Atom individual = jom.getAliasManager().getLeft(axiom.getIndividual()).getFunctor(); // TODO: what if individual is previously undefined? possible?     
        return jom.getSELiteralFactory().construct(alias, individual, getAnnots(alias, axiom));
    }

    /**
     * Convert an axiom asserting that two individuals are related by an object property to a binary SELiteral
     * @param axiom     the axiom to convert
     * @return          an binary SELiteral encoding of axiom
     * @throws JASDLException
     */
    public SELiteral convert(OWLObjectPropertyAssertionAxiom axiom) throws JASDLException {
        Alias alias = jom.getAliasManager().getLeft(axiom.getProperty().asOWLObjectProperty());
        Atom subject = jom.getAliasManager().getLeft(axiom.getSubject()).getFunctor();
        Atom object = jom.getAliasManager().getLeft(axiom.getObject()).getFunctor();
        return jom.getSELiteralFactory().construct(alias, subject, object, getAnnots(alias, axiom));
    }

    /**
     * Convert an axiom asserting that two individuals are related by a data property to a binary SELiteral
     * @param axiom     the axiom to convert
     * @return          a binary SELiteral encoding of axiom
     * @throws JASDLException
     */
    public SELiteral convert(OWLDataPropertyAssertionAxiom axiom) throws JASDLException {
        Alias alias = jom.getAliasManager().getLeft(axiom.getProperty().asOWLDataProperty());
        Atom subject = jom.getAliasManager().getLeft(axiom.getSubject()).getFunctor();
        Term object;
        OWLConstant constant = axiom.getObject();
        if (constant.isTyped()) {
            OWLTypedConstant ot = constant.asOWLTypedConstant();

            XSDVocabulary xsd = XSDVocabularyUtils.getByName(ot.getDataType().toString());//XSDDataTypeUtils.get(ot.getDataType().toString());
            // surround with quotes if necessary for representation in AgentSpeak syntax
            if (XSDVocabularyUtils.requiresStringTermRepresentation(xsd)) {
                object = DefaultTerm.parse("\"" + constant.getLiteral().toString() + "\"");
            } else if (XSDVocabularyUtils.requiresBooleanRepresentation(xsd)) {
                if (Boolean.parseBoolean(ot.getLiteral().toString())) {
                    object = Literal.LTrue;
                } else {
                    object = Literal.LFalse;
                }
            } else {
                object = DefaultTerm.parse(constant.getLiteral().toString());
            }
        } else {
            // Untyped, assume string to be on the safe side
            object = DefaultTerm.parse("\"" + constant.getLiteral().toString() + "\"");
            //throw new JASDLException("JASDL does not support untyped data ranges such as: " + axiom);
        }
        return jom.getSELiteralFactory().construct(alias, subject, object, getAnnots(alias, axiom));
    }

    /**
     * Convert an axiom asserting that a set of individuals are distinct to a unary SELiteral (whose term is a list and functor is "all_different")
     * @param axiom     the axiom to convert
     * @return          a unary SELiteral (whose term is a list and functor is "all_different") encoding of axiom
     * @throws JASDLException
     */
    public SELiteral convert(OWLDifferentIndividualsAxiom axiom) throws JASDLException {
        Set<OWLIndividual> _is = axiom.getIndividuals();
        if (_is.size() == 0) {
            throw new JASDLInvalidSELiteralException("All different assertion must contain some individuals! " + axiom);
        }
        Atom[] is = new Atom[_is.size()];
        Atom label = null;
        int j = 0;
        for (OWLIndividual i : _is) {
            Alias iAlias = jom.getAliasManager().getLeft(i);
            if (label == null) {
                // hack, get a reference back to ontology by examining one of the individuals
                label = iAlias.getLabel();
            }
            is[j] = iAlias.getFunctor();
            j++;
        }
        Alias alias = jom.getAliasManager().getLeft(new AllDifferentPlaceholder(label));
        return jom.getSELiteralFactory().construct(alias, is, getAnnots(alias, axiom));
    }

    public Logger getLogger() {
        return jom.getLogger();
    }

    /**
     * Uses Pellet's axiom tracing functionality to serve the same purpose as getInferredAnnotations. Deprecated because
     * of apparent bugs. 
     * @see AxiomToSELiteralConverter#getInferredAnnotations(OWLAxiom)
     * @deprecated
     */
    public List<Term> getInferredAnnotationsUsingPelletTracing(OWLAxiom _axiom, OWLOntology ontology) throws JASDLException {
        /*
         VERY BUGGY. For example, won't generate explanation for:
         +urbanArea(x)[o(travel), source(tom)];
         +ruralArea(y)[o(travel), source(ben)];
         // because knowledge from tom and ben contributed to the inference that x and y are distinct
         ?all_different([x,y])[o(self), source(tom), source(ben)]; <- THIS       
         */
        if (!(jom.getReasoner() instanceof org.mindswap.pellet.owlapi.Reasoner)) {
            throw new JASDLException("This feature requires the Pellet reasoner");
        }

        try {
            if (!(_axiom instanceof OWLIndividualAxiom)) {
                throw new JASDLException("Can only gather annotations for axioms about individuals");
            }
            OWLIndividualAxiom axiom = (OWLIndividualAxiom) _axiom;

            List<Term> annots = new Vector<Term>();

            Reasoner pellet = (org.mindswap.pellet.owlapi.Reasoner) jom.getReasoner();
            pellet.refresh();

            pellet.getKB().setDoExplanation(true);
            HashMap<OWLAxiom, Set<OWLOntology>> supports = new HashMap<OWLAxiom, Set<OWLOntology>>();
            while (pellet.isEntailed(axiom)) {

                //SatisfiabilityConverter conv = new SatisfiabilityConverter(jom.getOWLDataFactory());              
                //pellet.getKB().setDoExplanation( true );  
                //pellet.isSatisfiable(conv.convert(axiom));    // lets see if this is less buggy than generating explanations using isEntailed. NO!

                Set<OWLAxiom> explanation = pellet.getExplanation();
                explanation = new JASDLKernelsetFilter().filterSingleKernel(explanation); // TODO: faster without this (yet)
                getLogger().info("explanation: " + explanation);

                for (OWLAxiom support : explanation) {
                    for (OWLOntology o : pellet.getLoadedOntologies()) {
                        if (o.containsAxiom(support)) {
                            Set<OWLOntology> os = supports.get(support);
                            if (os == null) {
                                os = new HashSet<OWLOntology>();
                            }
                            supports.put(support, os);
                            os.add(o);
                            jom.getOntologyManager().applyChange(new RemoveAxiom(o, support));
                        }
                    }
                }
                pellet.refresh();
                pellet.getKB().setDoExplanation(true);
            }
            for (OWLAxiom support : supports.keySet()) {
                // gather annotations of this support
                annots.addAll(getAssertedAnnotations(support));
                // add it back to all necessary ontologies
                for (OWLOntology o : supports.get(support)) {
                    jom.getOntologyManager().applyChange(new AddAxiom(o, support));
                }
            }
            pellet.refresh();
            return annots;
        } catch (Exception e) {
            throw new JASDLException("Unable to gather annotations for " + _axiom, e);
        }
    }

}
