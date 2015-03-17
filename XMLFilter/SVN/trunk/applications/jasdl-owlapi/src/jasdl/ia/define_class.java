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

import static jasdl.util.JASDLCommon.strip;
import jasdl.asSemantics.JASDLAgent;
import jasdl.util.exception.JASDLException;
import jason.asSemantics.DefaultInternalAction;
import jason.asSemantics.TransitionSystem;
import jason.asSemantics.Unifier;
import jason.asSyntax.Atom;
import jason.asSyntax.Term;

import java.util.logging.Logger;

/**
 * @author Tom Klapiscak
 * 
 * Defines a new class in the personal ontology instance (label "self") of a JASDL agent.
 * 
 * For example: jasdl.ia.define_class(cheapBread, "c:bread and s:hasPrice some double [<= 0.5]") defines the class of individuals
 * who are a member of bread that have a price of less than £0.5 in the ontology referred to by the label "c". This can then
 * be used like any other SE-Literal. For instance:
 * 
 * ?cheapBread(X)[o(self)], will unify X with such an individual (if known).
 * 
 * Usage jasdl.ia.define_class(classname, expr_1...expr_n), where:
 *  - classname is an atomic name used to refer to this class in future. Must begin with a lowercase letter and not clash with any AgentSpeak keyword
 *  - the concatenation of expr_1...expr_n is a valid Manchester OWL syntax class expression (in JASDL's namespace prefix form)
 *  
 *
 */
public class define_class extends DefaultInternalAction {

    private Logger logger = Logger.getLogger("jasdl." + define_class.class.getName());

    @Override
    public Object execute(TransitionSystem ts, Unifier un, Term[] args) throws Exception {
        try {
            // class name ATOM
            Term _classname = args[0];
            if (!_classname.isAtom()) {
                throw new JASDLException("first argument must be a Atom containing a valid class name");
            }
            Atom classname = (Atom) _classname;

            // concat expression strings / atoms, with limited validity checks
            String expr = "";
            for (int i = 1; i < args.length; i++) {
                if (args[i].isString()) {
                    expr += strip(args[i].toString(), "\"");
				} else {
					expr += args[i].toString();
				}
			}

			JASDLAgent agent = (JASDLAgent) ts.getAg();

			agent.getJom().defineClass(classname, expr, agent.getJom().getManchesterNsPrefixDescriptionParser());

			return true;
		} catch (Exception e) {
			logger.warning("Error in internal action 'jasdl.ia.define_class'! Reason:");
			e.printStackTrace();

			return false;
		}
	}

}
