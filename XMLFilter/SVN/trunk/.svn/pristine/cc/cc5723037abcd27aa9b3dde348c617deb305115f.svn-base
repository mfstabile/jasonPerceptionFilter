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
package jasdl.bb;

import jasdl.asSemantics.JASDLAgent;
import jasdl.bb.bebops.JASDLIncisionFunction;
import jasdl.bb.bebops.JASDLKernelsetFilter;
import jasdl.bb.bebops.JASDLReasonerFactory;
import jasdl.bridge.seliteral.SELiteral;
import jasdl.bridge.seliteral.SELiteralAllDifferentAssertion;
import jasdl.util.exception.JASDLException;
import jasdl.util.exception.JASDLNotEnrichedException;
import jason.asSemantics.Agent;
import jason.asSemantics.Unifier;
import jason.asSyntax.Atom;
import jason.asSyntax.Literal;
import jason.asSyntax.Term;
import jason.bb.BeliefBase;
import jason.bb.DefaultBeliefBase;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.Vector;
import java.util.logging.Logger;

import org.semanticweb.owl.model.AddAxiom;
import org.semanticweb.owl.model.OWLAnnotation;
import org.semanticweb.owl.model.OWLAxiom;
import org.semanticweb.owl.model.OWLAxiomAnnotationAxiom;
import org.semanticweb.owl.model.OWLDifferentIndividualsAxiom;
import org.semanticweb.owl.model.OWLIndividual;
import org.semanticweb.owl.model.OWLIndividualAxiom;
import org.semanticweb.owl.model.OWLOntology;
import org.semanticweb.owl.model.RemoveAxiom;

import bebops.contraction.BeliefBaseContractor;

public class JASDLBeliefBase extends DefaultBeliefBase {

    private JASDLAgent agent;

    //private List<Literal> sePercepts;

    @Override
    public void init(Agent ag, String[] args) {
        super.init(ag, args);
        //sePercepts = new Vector<Literal>();
    }

    @Override
    public boolean add(Literal l) {
        getLogger().fine("Adding " + l);
        
        try {

            SELiteral sl = agent.getSELiteralFactory().construct(l);
            OWLIndividualAxiom axiom = agent.getSELiteralToAxiomConverter().create(sl);
            OWLOntology ontology = sl.getOntology();

            boolean containsAxiom = ontology.containsAxiom(axiom);
            if (!containsAxiom) {
                agent.getOntologyManager().applyChange(new AddAxiom(ontology, axiom));
                agent.getJom().refreshReasoner();
            }

            boolean containsAllAnnots = true;
            for (Term _annot : sl.getSemanticallyNaiveAnnotations()) {
                OWLAnnotation annot = agent.getOntologyManager().getOWLDataFactory().getOWLLabelAnnotation(_annot.toString());
                OWLAxiomAnnotationAxiom annotAxiom = agent.getOntologyManager().getOWLDataFactory().getOWLAxiomAnnotationAxiom(axiom, annot);
                if (!ontology.containsAxiom(annotAxiom)) {
                    containsAllAnnots = false;
                    agent.getOntologyManager().applyChange(new AddAxiom(ontology, annotAxiom));
                    agent.getJom().refreshReasoner();
                }
            }

            if (!containsAxiom || !containsAllAnnots) {
                
            // 13-06-2008: Moved to brf
            //  if (!agent.getConfig().isBeliefRevisionEnabled()) { // if brf disabled, resort to legacy consistency maintenance mechanism                  
            //      if (!agent.getJom().areOntologiesConsistent()) {
            //          getLogger().info("legacy consistency assurance: rejected " + axiom);
            //          RemoveAxiom rem = new RemoveAxiom(ontology, axiom);
            //          agent.getOntologyManager().applyChange(rem);
            //          agent.getJom().refreshReasoner();
            //          return false;
            //      }
            //  }

                if (l.hasAnnot(TPercept)) {
                    percepts.add(l);
                }

                return true;
            } else {
                return false;
            }
        } catch (JASDLNotEnrichedException e) {
            getLogger().fine("... semantically-naive");
            return super.add(l); // semantically-naive, use standard Jason mechanisms
        } catch (Exception e) {
            getLogger().info("Exception caught adding SELiteral " + l + " to belief base: ");
            e.printStackTrace();
            return false;
        }
    }

    /**
     * Removal is equivalent to contraction!
     */
    @Override
    public boolean remove(Literal l) {  
        
        try {
            SELiteral sl = agent.getSELiteralFactory().construct(l);
            OWLOntology ontology = sl.getOntology();
            OWLAxiom axiom = agent.getSELiteralToAxiomConverter().create(sl);

            boolean result = false; // -> at least *something* must be removed for this to be true!
            
            List<OWLAxiom> removeList;
            
            if(agent.getConfig().isContractionEnabled()){
                getLogger().fine("Contracting " + l);
                BeliefBaseContractor contractor = new BeliefBaseContractor(agent.getOntologyManager(), new JASDLReasonerFactory(), agent.getLogger());
                removeList = contractor.contract(axiom, new JASDLKernelsetFilter(), new JASDLIncisionFunction(agent, sl));
            }else{
                getLogger().fine("Removing " + l);
                removeList = (List<OWLAxiom>)Collections.singletonList(axiom);
                
                
            }
            

            // NOTE: this technique only really makes sense with annotation gathering!
            for (OWLAxiom remove : removeList) { // removals correspond to l and all assertions whose removal will undermine l

                // fail if axiom not contained in ontology
                if (!ontology.containsAxiom(remove)) {
                    continue;
                }

                // construct annot axiom->term map (avoids unecessary parsing of terms)
                HashMap<OWLAxiomAnnotationAxiom, Term> annotAxiomToTermMap = new HashMap<OWLAxiomAnnotationAxiom, Term>();
                for (OWLAxiomAnnotationAxiom annotAxiom : remove.getAnnotationAxioms(ontology)) {
                    Term annotTerm = Literal.parse(annotAxiom.getAnnotation().getAnnotationValueAsConstant().getLiteral());
                    annotAxiomToTermMap.put(annotAxiom, annotTerm);
                }

                // if l only has "o" annotations. Remember, "o" isn't stored in ontology
                // note: literals without "o" are semantically-naive and so will be caught below
                if (sl.getSemanticallyNaiveAnnotations().isEmpty()) {
                    // remove axiom and all annotations
                    for (OWLAxiomAnnotationAxiom annotAxiom : annotAxiomToTermMap.keySet()) {
                        agent.getOntologyManager().applyChange(new RemoveAxiom(ontology, annotAxiom));
                    }
                    agent.getOntologyManager().applyChange(new RemoveAxiom(ontology, remove));
                    result = true;
                    continue;
                }

                // first check axiom has all annotations of l except for "o" (otherwise fail)
                if (!annotAxiomToTermMap.values().containsAll(sl.getSemanticallyNaiveAnnotations())) {
                    continue;
                }

                result = true;

                // remove all axiom annotations (implicitly possessed also by l)
                for (OWLAxiomAnnotationAxiom annotAxiom : annotAxiomToTermMap.keySet()) {
                    agent.getOntologyManager().applyChange(new RemoveAxiom(ontology, annotAxiom));
                }

                // remove source(self) and source(percept). TODO: right thing to do?        

                // if no annotation axioms left, remove assertion       
                Set<OWLAxiomAnnotationAxiom> remaining = remove.getAnnotationAxioms(ontology);
                if (remaining.isEmpty()) {
                    agent.getOntologyManager().applyChange(new RemoveAxiom(ontology, remove));
                }

                if (l.hasAnnot(TPercept)) {
                    SELiteral sePercept = agent.getAxiomToSELiteralConverter().convert((OWLIndividualAxiom)axiom);                  
                    percepts.remove(sePercept);
                }

            }
            agent.getJom().refreshReasoner();
            return result;
        } catch (JASDLNotEnrichedException e) {
            getLogger().fine("Removing " + l);
            return super.remove(l); // semantically-naive, use standard Jason mechanisms
        } catch (Exception e) {
            getLogger().warning("Error removing " + l + " from belief base:");
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Iterator<Literal> getPercepts() {
        final Iterator<Literal> resultIt = percepts.iterator();
        final JASDLBeliefBase parent = this;
        return new Iterator<Literal>() {
            Literal current = null;

            public boolean hasNext() {
                return resultIt.hasNext();
            }

            public Literal next() {
                current = resultIt.next();
                return current;
            }

            public void remove() {
                if (current == null) {
                    getLogger().warning("Trying to remove a perception, but the the next() from the iterator is not called before!");
                }
                // remove from percepts
                resultIt.remove();

                // remove the percept annot
                current.delAnnot(BeliefBase.TPercept);

                // and also remove from the BB
                parent.remove(current); // <- JASDL extension ensuring SE-percepts are properly removed. TODO: performance hit? use removeFromEntry for SN-percepts?
            }
        };
    }

    @Override
    public Literal contains(Literal l) {
        agent.getLogger().fine("Contains: " + l);
        try {
            SELiteral sl = agent.getSELiteralFactory().construct(l);
            OWLIndividualAxiom axiom = agent.getSELiteralToAxiomConverter().create(sl);
            if (sl.getOntology().containsAxiom(axiom)) {
                Iterator<Literal> it = getCandidateBeliefs(l, null);
                if (it.hasNext()) {
                    return it.next();
                }
            }
            return null;
        } catch (JASDLNotEnrichedException e) {
            return super.contains(l); // semantically-naive, use standard Jason mechanisms
        } catch (Exception e) {
            getLogger().warning("Exception caught while checking if bb contains SELiteral " + l + ". Reason: " + e);
            return null;
        }
    }

    @Override
    public Iterator<Literal> getCandidateBeliefs(Literal l, Unifier un) {
        l = (Literal) l.clone();
        l.apply(un);

        getLogger().fine("Getting candidate beliefs for " + l);

        Set<Literal> relevant = new HashSet<Literal>();
        try {
            SELiteral sl = agent.getSELiteralFactory().construct(l);
            Set<OWLIndividualAxiom> axioms = agent.getSELiteralToAxiomConverter().retrieve(sl);
            for (OWLIndividualAxiom axiom : axioms) {
                SELiteral found = agent.getAxiomToSELiteralConverter().convert(axiom);

                // hack, gets around non-consistent ordering of OWLDifferentIndividualAxiom individuals
                // -- just check list membership is equivalent (i.e. treat as sets)
                if (found instanceof SELiteralAllDifferentAssertion) {
                    SELiteralAllDifferentAssertion diff = (SELiteralAllDifferentAssertion) found;
                    Set<OWLIndividual> is = diff.getOWLIndividuals();
                    Set<OWLIndividual> js = ((OWLDifferentIndividualsAxiom) axiom).getIndividuals();
                    if (is.containsAll(js)) {
                        found.getLiteral().setTerm(0, l.getTerm(0)); // Sets are equivalent, change to original ordering
                    }
                }

                relevant.add(found.getLiteral());

            }
            getLogger().fine("... found: " + relevant);
            if (relevant.isEmpty()) {
                return null;
            }

        } catch (JASDLNotEnrichedException e) {

            // TODO: Somehow Check for nested SE-Literals. Remember, SE-Literals cannot be nested within other SE-Literals
            // TODO: Also check lists?

            // Get direct candidate
            Iterator<Literal> direct = super.getCandidateBeliefs(l, un);
            if (direct != null) {
                while (direct.hasNext()) {
                    Literal sn = direct.next();
                    relevant.add(sn);
                }
            }

            // Get indirect candidates (through application of ontological reasoning to nested SE-Literals)
            //List<Literal> indirect = getIndirectCandidateBeliefs(l, un);
            //relevant.addAll(indirect);

            return relevant.iterator(); // semantically-naive, use standard Jason mechanisms
        } catch (Exception e) {
            //getLogger().warning("Exception caught getting candidate beliefs for SELiteral " + l + " from belief base: ");
            //e.printStackTrace();
            // failed, allow a complex test goal to be generated without printing an exception TODO: is this wise?
        }
        return relevant.iterator();
    }

    /**
     * TODO: Currently only returns asserted ABox axioms. Include option to also show inferences?
     * Doesn't return beliefs in same order as Jason (could sort stricly alphabetically - but this would be costly
     * isn't even exactly identical to Jason's behaviour - does it really matter anyway?)
     */
    @Override
    public Iterator<Literal> iterator() {
        List<Literal> bels = new Vector<Literal>();

        // add all SN-Literals
        Iterator it = super.iterator();
        while (it.hasNext()) {
            bels.add((Literal) it.next());
        }

        // add all SE-Literals (asserted)
        try {
            bels.addAll(agent.getJom().getAllSELiterals());
        } catch (JASDLException e) {
            getLogger().warning("Exception caught while retrieving ABox state: " + e);
        }

        //Collections.sort(bels);

        return bels.iterator();
    }

    public void setAgent(JASDLAgent agent) {
        this.agent = agent;
    }

    private Logger getLogger() {
        return agent.getLogger();
    }
    
    

}


/*
private List<Literal> getIndirectCandidateBeliefs(Literal l, Unifier un) {
    l = (Literal) l.clone();
    l.apply(un);

    getLogger().info("Getting indirect candidate beliefs for " + l);

    List<Literal> candidates = new Vector<Literal>();

    try {
        List<Term> terms = l.getTerms();
        for (int i = 0; i < terms.size(); i++) {
            Term _nested = terms.get(i);
            getLogger().info("...checking " + _nested);
            if (_nested.isLiteral()) {
                Literal nested = (Literal) _nested;
                try {
                    SELiteral nestedCandidate = agent.getSELiteralFactory().construct(nested);
                    getLogger().info("Nested candidate: " + nestedCandidate);

                    Literal forGettingNestedAssertions = (Literal) l.clone();
                    forGettingNestedAssertions.setTerm(i, new VarTerm("X"));

                    getLogger().info("For getting nested assertions: " + forGettingNestedAssertions);

                    Iterator<Literal> nestedAssertions = getCandidateBeliefs(forGettingNestedAssertions, un);

                    // check if each nested assertion is a sub class/property of nested candidate, if so add all individuals of nested assertion in as relevant
                    while (nestedAssertions.hasNext()) {
                        Literal _nestedAssertion = nestedAssertions.next();
                        try {
                            SELiteral nestedAssertion = agent.getSELiteralFactory().construct(l);
                            getLogger().info("Checking nested assertions: " + nestedAssertion);
                            if (nestedAssertion instanceof SELiteralClassAssertion && nestedCandidate instanceof SELiteralClassAssertion) {
                                if (agent.getReasoner().isSubClassOf(nestedAssertion.asClassAssertion().getOWLDescription(), nestedCandidate.asClassAssertion().getOWLDescription())) {

                                    Set<OWLIndividualAxiom> axioms = agent.getSELiteralToAxiomConverter().retrieve(nestedAssertion.asClassAssertion());
                                    for (OWLIndividualAxiom _axiom : axioms) {
                                        OWLClassAssertionAxiom axiom = (OWLClassAssertionAxiom) _axiom;
                                        OWLIndividual individual = axiom.getIndividual();
                                        getLogger().info("Found relevant individual: " + individual);
                                    }

                                }
                            }
                        } catch (JASDLNotEnrichedException e1) {
                            // do nothing, SN-nesting - can't be a subclass of nested candidate
                        }
                    }

                } catch (JASDLNotEnrichedException e1) {
                    // do nothing, SN-nesting
                }
            }
        }
    } catch (Exception e) {
        getLogger().warning("Exception caught getting indirect canididate beliefs for " + l + " from belief base: ");
        e.printStackTrace();
    }
    return candidates;
}
*/

/*  RESTRICTED TO SUB CLASS/PROPERTY CHECKING - CORRECT ASSUMPTION TO MAKE?
 *                  Iterator<Literal> nestedCandidates = getCandidateBeliefs(nestedsl.getLiteral(), un);
 *                  
 *                  // check 
 *                  Literal blank = (Literal)nested.clone();
 *                  blank.setTerm(i, new VarTerm("_"));
 *                  
 *                  Iterator<Literal> nestedAssertions = getCandidateBeliefs(nested, un);
 *                  for(Literal nestedAssertion = nestedAssertions.next(); nestedAssertions.hasNext();){
 *                      Iterator<Literal> nestedAssertionCandidates = getCandidateBeliefs(nestedAssertion, un);
 *                      
 *                      // are all nestedAssertionCandidates
 *                      
 *                  }
 */

