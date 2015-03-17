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

import jasdl.JASDLParams;
import jasdl.asSemantics.JASDLAgent;
import jasdl.util.JASDLCommon;
import jason.asSemantics.Unifier;
import jason.asSyntax.Literal;
import jason.asSyntax.LiteralImpl;
import jason.asSyntax.Plan;
import jason.asSyntax.Structure;
import jason.asSyntax.Term;
import jason.asSyntax.Trigger;

/**
 * <p>A plan whose trigger is associated with a semantically-enriched literal.</p>
 * <p>Jason's definition of relevancy for this type of plan is overloaded to additionally include unification with subsuming triggers</p>
 * 
 * @author Tom Klapiscak
 *
 */
public class SEPlan extends Plan{
	private static final long serialVersionUID = 1L;

	private JASDLAgent agent;

	public SEPlan(JASDLAgent agent, Plan p) {
		super(p.getLabel(), p.getTrigger(), p.getContext(), p.getBody());
		this.agent = agent;
	}



	@Override
	public Unifier isRelevant(Trigger te) {	
		// TODO: this needs to be tidied up
		Unifier un = super.isRelevant(te);
		if(un == null){
			try {
				if(JASDLCommon.isMoreSpecific(te.getLiteral(), this.getTrigger().getLiteral(), agent.getJom())){						
					
					Literal trigger = te.getLiteral();
					Literal oldLiteral = getTrigger().getLiteral();
					
					Structure triggerO = (Structure)trigger.getAnnots(JASDLParams.ONTOLOGY_ANNOTATION_FUNCTOR).get(0);
					Structure oldO = (Structure)oldLiteral.getAnnots(JASDLParams.ONTOLOGY_ANNOTATION_FUNCTOR).get(0);
					
					
					// create a new literal with functor of trigger
					Literal newLiteral = new LiteralImpl( !oldLiteral.negated(), trigger.getFunctor());
					
					// add the terms from the old literal
					newLiteral.addTerms(oldLiteral.getTerms());
					
					// add the annots from the old literal
					newLiteral.addAnnots(oldLiteral.getAnnots());
					
					// change the o annotation to that of the trigger (o is always ground, so not an issue - no unification need be performed against the IM)
					newLiteral.delAnnot(oldO);
					newLiteral.addAnnot(triggerO);
					
					getTrigger().setLiteral(newLiteral);	
					
					un = new Unifier();					
					
					if(un.unifiesNoUndo(getTrigger(), te)){
						return un;
					}else{
						return null;
					}
					
				}
				return null;
			} catch (Exception e) {
				return null;
			}
		}else{
			return un;
		}
	}

	@Override
	public Term clone() {
		return new SEPlan(agent, (Plan) super.clone());
	}

}
