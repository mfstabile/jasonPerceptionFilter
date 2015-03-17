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

import jasdl.asSemantics.JASDLAgent;
import jason.asSemantics.DefaultInternalAction;
import jason.asSemantics.TransitionSystem;
import jason.asSemantics.Unifier;
import jason.asSyntax.Literal;
import jason.asSyntax.Term;

import java.util.logging.Logger;

/**
 * @author Tom Klapiscak
 * 
 * Configures the agent to use the experimental annotation gathering feature according to the truth value of the supplied parameter.
 *
 */
public class set_annotation_gathering_enabled extends DefaultInternalAction {

    private Logger logger = Logger.getLogger("jasdl." + set_annotation_gathering_enabled.class.getName());

    @Override
    public Object execute(TransitionSystem ts, Unifier un, Term[] args) throws Exception {
        try {
            JASDLAgent agent = (JASDLAgent) ts.getAg();
            if (args[0].equals(Literal.LTrue)) {
                agent.getConfig().setAnnotationGatheringEnabled((true));
            } else if (args[0].equals(Literal.LFalse)) {
                agent.getConfig().setAnnotationGatheringEnabled(false);
            } else {
                throw new Exception("Argument must be boolean");
            }
            return true;
        } catch (Exception e) {
            logger.warning("Error in internal action 'jasdl.ia.set_annotation_gathering_enabled'! Reason:");
            e.printStackTrace();
            return false;
        }
    }

}
