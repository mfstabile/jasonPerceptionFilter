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

import jason.asSemantics.DefaultInternalAction;
import jason.asSemantics.TransitionSystem;
import jason.asSemantics.Unifier;
import jason.asSyntax.Atom;
import jason.asSyntax.Structure;
import jason.asSyntax.Term;

import java.util.logging.Logger;

/**
 * Gets the functor of any Jason literal. Not currently used.
 * jasdl.ia.get_functor(Literal, Functor), where Literal is any valid Jason Literal.
 * @author Tom Klapiscak
 */
public class get_functor extends DefaultInternalAction {

    private Logger logger = Logger.getLogger("jasdl." + get_functor.class.getName());

    @Override
    public Object execute(TransitionSystem ts, Unifier un, Term[] args) throws Exception {
        try {
            if (!args[0].isStructure()) {
                throw new Exception("The first argument of get_functor must be a structure");
            }
            Structure s = (Structure) args[0];

            return un.unifies(args[1], new Atom(s.getFunctor()));
        } catch (Exception e) {
            logger.warning("Error in internal action 'jasdl.ia.get_functor'! Reason:");
            e.printStackTrace();
            return false;
        }
    }

}
