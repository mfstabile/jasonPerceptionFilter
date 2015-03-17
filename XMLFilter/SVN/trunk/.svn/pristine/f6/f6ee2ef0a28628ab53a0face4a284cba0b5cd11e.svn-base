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
import jasdl.bridge.seliteral.SELiteral;
import jason.asSemantics.DefaultInternalAction;
import jason.asSemantics.TransitionSystem;
import jason.asSemantics.Unifier;
import jason.asSyntax.Literal;
import jason.asSyntax.StringTermImpl;
import jason.asSyntax.Term;

import java.util.logging.Logger;

import org.semanticweb.owl.model.OWLAxiom;
import org.semanticweb.owl.model.OWLClass;
import org.semanticweb.owl.model.OWLDescription;
import org.semanticweb.owl.model.OWLObject;

import bebops.common.IndividualAxiomToDescriptionConverter;

/**
 * @author Tom Klapiscak
 * 
 * Produces a rendering in Manchester OWL syntax (in JASDL's Namespace prefix form) of the assertion made by any valid SE-Literal.
 * 
 * For example: jasdl.ia.get_class_definition(bread(hovis)[o(c)], Rendering), unifies Rendering with "c:bread and {c:hovis}".
 * 
 * Usage: jasdl.ia.get_class_definition(Assertion, Rendering), where Assertion is any valid SE-Literal.
 * 
 */
public class get_class_definition extends DefaultInternalAction {

    private Logger logger = Logger.getLogger("jasdl." + get_class_definition.class.getName());

    @Override
    public Object execute(TransitionSystem ts, Unifier un, Term[] args) throws Exception {
        try {
            if (!args[0].isLiteral()) {
                throw new Exception(get_class_definition.class.getName() + "'s first argument must be a literal");
            }
            Literal l = (Literal) args[0];

            JASDLAgent agent = (JASDLAgent) ts.getAg();

            SELiteral sl = agent.getSELiteralFactory().construct(l);

            String expression = "";
            if (sl.getLiteral().isGround()) {
                IndividualAxiomToDescriptionConverter conv = new IndividualAxiomToDescriptionConverter(agent.getOWLDataFactory(), agent.getReasoner());
                //for(OWLAxiom axiom : ){
                OWLAxiom axiom = agent.getSELiteralToAxiomConverter().create(sl);
                agent.getLogger().finest("Rendering axiom " + axiom);

                OWLDescription desc = conv.performDirectConversion(axiom);
                expression += agent.getJom().getManchesterNsPrefixOWLObjectRenderer().render(desc);
                //}
            } else {
                // TODO: Extract to SELiteral class (e.g. getDescription)? 
                OWLObject o = sl.toOWLObject();
                if (o instanceof OWLClass) {
                    expression += agent.getJom().getManchesterNsPrefixOWLObjectRenderer().render((OWLClass) o);
                } else {
                    throw new Exception("Not yet implemented for properties");
                }

            }

            expression = expression.replace("\n", " ");
            
            return un.unifies(args[1], new StringTermImpl(expression));

        } catch (Exception e) {
            logger.warning("Error in internal action '" + get_class_definition.class.getName() + "'! Reason:");
            e.printStackTrace();
            return false;
        }
    }

}
