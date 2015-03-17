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
package jasdl.asSyntax;

import jasdl.asSemantics.JASDLAgent;
import jasdl.bridge.seliteral.SELiteral;
import jasdl.util.JASDLCommon;
import jasdl.util.exception.JASDLException;
import jasdl.util.exception.JASDLNotEnrichedException;
import jason.JasonException;
import jason.asSyntax.Literal;
import jason.asSyntax.Plan;
import jason.asSyntax.PlanLibrary;
import jason.asSyntax.Term;
import jason.asSyntax.Trigger;

import java.util.LinkedList;
import java.util.List;
import java.util.Vector;
import java.util.logging.Logger;

import org.semanticweb.owl.model.OWLException;

/**
 * 
 * SE-Plans are ordered most specific -> most general, ensuring the most specific option is generalised to.
 * TODO: write tests
 * 
 * @author Tom Klapiscak
 *
 */
public class JASDLPlanLibrary extends PlanLibrary {

    private JASDLAgent agent;

    /**
     * Keep track of SE Plans for generating candidate relevances for incoming triggers containing SE-Literals
     */
    private LinkedList<SEPlan> sePlans;

    public JASDLPlanLibrary(JASDLAgent agent) {
        this.agent = agent;
        sePlans = new LinkedList<SEPlan>();
    }


    @Override
    public void add(Plan p) throws JasonException {
        // All plan who's trigger contains a SE-Literal is added as an SE-Plan so DL-unification can be performed when checking its relevance
        if (containsSELiteral(p.getTrigger().getLiteral())) {
            SEPlan sePlan = new SEPlan(agent, p);
            
            /*
            try {
                insertSEPlan(sePlan);
            } catch (OWLException e) {
                throw new JasonException("Error placing SE-Plan "+p, e);
            }
            */
            sePlans.add(sePlan);
            
            super.add(sePlan);
        } else {
            super.add(p);
        }
    }
    
    /**
     * Inserts an SE-Plan according to its specificity (most specific first).
     * TODO: Is this not better placed within a JMCA option selection strategy?
     */ 
    private void insertSEPlan(SEPlan unplaced) throws JASDLException, OWLException{
        int i = 0;
        for(SEPlan placed : sePlans){           
            Literal x = unplaced.getTrigger().getLiteral();
            Literal y = placed.getTrigger().getLiteral();
            boolean xIsMoreSpecific = JASDLCommon.isMoreSpecific(x, y, agent.getJom());
            getLogger().finest("Is "+x+" more specific than "+y+"? "+xIsMoreSpecific);
            if(xIsMoreSpecific) break;
            i++;
        }
        sePlans.add(i, unplaced);
    }
    
    
    public List<SEPlan> getSEPlans(){
        return sePlans;
    }
    

    

    @Override
    public List<Plan> getCandidatePlans(Trigger te) {
        //TODO: We are duplicating work here (performing full unification on SE-candidates here and when transition system calls
        // SEPlan#isRelevant. More efficient means for determining candidates? - or perhaps storing these unifications for re-use by TS
        List<Plan> candidates = super.getCandidatePlans(te);
        if(candidates == null){
            candidates = new Vector<Plan>();
            for(Plan candidate : sePlans){              
                if(candidate instanceof SEPlan){
                    candidate = (SEPlan)candidate.clone();
                    SEPlan seCandidate = (SEPlan)candidate;
                    if(seCandidate.isRelevant(te) != null){                     
                        candidates.add(candidate);
                    }
                }
            }
            
        }
        return candidates;

    }

    private Logger getLogger() {
        return agent.getLogger();
    }

    /**
     * Returns true if l or any of its nested terms are SE-Literals
     * @param l
     * @return
     */
    private boolean containsSELiteral(Literal l) throws JASDLException {
        try {
            SELiteral sl = new SELiteral(l, agent.getJom());
            // Be tolerant of literals with "self" since this ontology has not yet been instantiated (and can't be till agent name has been AFTER init agent). 
            if (sl.getOntologyAnnotation().getTerm(0).equals(agent.getJom().getPersonalOntologyLabel())) {
                return true;
            }
            sl = agent.getSELiteralFactory().construct(l);
            return true;
        } catch (JASDLNotEnrichedException e) {
            if (l.getArity() > 0) {
                for (Term nested : l.getTerms()) {
                    if (nested.isLiteral()) {
                        if (containsSELiteral((Literal) nested)) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

}
