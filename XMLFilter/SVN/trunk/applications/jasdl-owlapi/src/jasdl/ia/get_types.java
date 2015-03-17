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
import jasdl.bridge.factory.AliasFactory;
import jasdl.bridge.mapping.aliasing.Alias;
import jason.asSemantics.DefaultInternalAction;
import jason.asSemantics.TransitionSystem;
import jason.asSemantics.Unifier;
import jason.asSyntax.Atom;
import jason.asSyntax.ListTerm;
import jason.asSyntax.ListTermImpl;
import jason.asSyntax.Literal;
import jason.asSyntax.Term;
import jason.asSyntax.VarTerm;

import java.util.Set;
import java.util.logging.Logger;

import org.semanticweb.owl.inference.OWLReasonerAdapter;
import org.semanticweb.owl.model.OWLClass;
import org.semanticweb.owl.model.OWLIndividual;

/**
 * Gets all the asserted or inferred class memberships of an individual wrt a particular ontology.
 * 
 * Usage:
 *  jasdl.ia.get_types(Individual, OntologyLabel, Direct, Types)
 *      where Individual is any known individual referenced within the ontology instance referred to by OntologyLabel. If direct is
 *      set, only asserted types are returned, otherwise ALL inferred types are returned.
 * 
 * Example:
 *  jasdl.ia.get_types(hovis, c, true, Types), unifies Types with [bread]
 *  jasdl.ia.get_types(hovis, c, false, Types), unifies Types with [bread, grocery, product, thing ...]
 * 
 * @author Tom Klapiscak
 *
 */
public class get_types extends DefaultInternalAction {

    private static final long serialVersionUID = -1089323500956321327L;

    private Logger logger = Logger.getLogger("jasdl." + get_types.class.getName());

    @Override
    public Object execute(TransitionSystem ts, Unifier un, Term[] args) throws Exception {
        try {
            JASDLAgent agent = (JASDLAgent) ts.getAg();

            // Resolve ground variables (TODO: should Jason do this implicitly?) 
            for (int i = 0; i < args.length; i++) {
                if (args[i] instanceof VarTerm && args[i].isGround()) {
                    args[i] = (Atom) (((VarTerm) args[i]).getValue());
                }
            }

            // Validate arguments
            if (!(args[0].isAtom())) {
                throw new Exception("First argument must be an atomic individual alias");
            }

            if (!(args[1].isAtom())) {
                throw new Exception("Second argument must be atomic ontology label");
            }
            boolean direct;
            if (args[2].equals(Literal.LTrue)) {
                direct = true;
            } else if (args[2].equals(Literal.LFalse)) {
                direct = false;
            } else {
                throw new Exception("Third argument must be boolean");
            }
            if (!(args[3].isVar() || args[3].isGround())) {
                throw new Exception("Fourth argument must be an unground variable");
            }

            Alias alias = AliasFactory.INSTANCE.create((Atom) args[0], (Atom) args[1]);
            OWLIndividual i;
            try {
                i = (OWLIndividual) agent.getAliasManager().getRight(alias);
            } catch (ClassCastException e) {
                throw new Exception(alias + " does not correspond to a known individual");
            }

            Set<OWLClass> _types = OWLReasonerAdapter.flattenSetOfSets(agent.getReasoner().getTypes(i, direct));

            ListTerm types = new ListTermImpl();
            for (OWLClass _type : _types) {
                Alias typeAlias = agent.getAliasManager().getLeft(_type);
                types.add(typeAlias.getFunctor());
            }

            un.unifies(args[3], types);

            return true;
        } catch (Exception e) {
            logger.warning("Error in internal action 'jasdl.ia.get_types'! Reason:");
            e.printStackTrace();
            return false;
        }
    }

}
