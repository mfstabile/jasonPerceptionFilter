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
package jasdl.ia;

import jasdl.JASDLParams;
import jason.asSemantics.DefaultInternalAction;
import jason.asSemantics.IntendedMeans;
import jason.asSemantics.TransitionSystem;
import jason.asSemantics.Unifier;
import jason.asSyntax.Atom;
import jason.asSyntax.Literal;
import jason.asSyntax.Structure;
import jason.asSyntax.Term;
import jason.asSyntax.Trigger;

import java.util.logging.Logger;

/**
 * @author Tom Klapiscak
 * 
 * Note: Retrieving from context and retrieving from plan body MAY result in different annotations on cause
 *
 */
public class get_tg_cause extends DefaultInternalAction {

    private Logger logger = Logger.getLogger("jasdl." + get_tg_cause.class.getName());

    @Override
    public Object execute(TransitionSystem ts, Unifier un, Term[] args) throws Exception {
        try {           
            
            Trigger te;
            try{
                IntendedMeans cause = ts.getC().getSelectedIntention().peek();     
                te = cause.getPlan().getTrigger();  // Test within plan body, use intended means
            }catch(NullPointerException noIM){
                te = ts.getC().getSelectedEvent().getTrigger(); // Test within context, no intended means, use event instead
            }
            if(!te.getLiteral().hasSource()){
                te.getLiteral().addSource(new Atom("self"));
            }
            Literal l = (Literal)te.getLiteral().clone();
            
            // do not retain annotations (except ontology annotation)
            if(args[1].equals(Literal.LFalse)){
                for(Term annot : l.getAnnots()){
                    if(!((annot instanceof Structure) && ((Structure)annot).getFunctor().equals(JASDLParams.ONTOLOGY_ANNOTATION_FUNCTOR))){
                        l.delAnnot(annot);
                    }
                }
            }
            
            return un.unifies(args[0], l);
        } catch (Exception e) {
            logger.warning("Error in internal action 'jasdl.ia.set_contraction_enabled'! Reason:");
            e.printStackTrace();
            return false;
        }
    }

}
