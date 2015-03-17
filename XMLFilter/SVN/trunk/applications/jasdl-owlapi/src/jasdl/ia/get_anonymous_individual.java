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
import jasdl.asSemantics.JASDLAgent;
import jasdl.bridge.mapping.aliasing.Alias;
import jason.asSemantics.DefaultInternalAction;
import jason.asSemantics.TransitionSystem;
import jason.asSemantics.Unifier;
import jason.asSyntax.Atom;
import jason.asSyntax.Term;

import java.util.HashSet;
import java.util.Set;
import java.util.logging.Logger;

import org.semanticweb.owl.model.OWLIndividual;
import org.semanticweb.owl.model.OWLOntology;

/**
 * Generates a anonymous, guaranteed unique individual.
 * Prefixed with agent name to guarantee uniqueness within entire agent society.
 * 
 * Usage:
 *      jasdl.ia.get_individual(ID) unifies ID with an atomic unique individual name.
 * 
 * @author Tom Klapiscak
 * 
 * TODO: Add all corresponding different assertions to individual?
 */
public class get_anonymous_individual extends DefaultInternalAction {

    private Logger logger = Logger.getLogger("jasdl." + get_anonymous_individual.class.getName());

    @Override
    public Object execute(TransitionSystem ts, Unifier un, Term[] args) throws Exception {
        try {

            if (args[0].isGround()) {
                throw new Exception(get_anonymous_individual.class.getName() + " must be supplied a single unground variable argument");
            }

            JASDLAgent agent = (JASDLAgent) ts.getAg();
            
            String prefix = agent.getAgentName() + "_" + JASDLParams.ANONYMOUS_INDIVIDUAL_PREFIX;

            // collate all known anonymous individuals
            Set<Atom> anonymousIndividualFunctors = new HashSet<Atom>();
            for (OWLOntology ontology : agent.getOntologyManager().getOntologies()) {
                for (OWLIndividual i : ontology.getReferencedIndividuals()) {
                    Alias alias = agent.getAliasManager().getLeft(i);
                    Atom functor = alias.getFunctor();
                    if (functor.toString().startsWith(prefix)) {
                        anonymousIndividualFunctors.add(functor);
                    }
                }
            }

            un.unifies(args[0], new Atom(prefix + anonymousIndividualFunctors.size()));
            return true;

        } catch (Exception e) {
            logger.warning("Error in internal action '" + get_anonymous_individual.class.getName() + "'! Reason:");
            e.printStackTrace();
            return false;
        }
    }

}
