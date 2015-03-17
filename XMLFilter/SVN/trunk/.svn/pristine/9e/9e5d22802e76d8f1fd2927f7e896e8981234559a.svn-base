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
package jasdl.bb.bebops;

import jasdl.asSemantics.JASDLAgent;
import jasdl.bridge.seliteral.SELiteral;
import jasdl.util.exception.JASDLException;
import jason.asSyntax.Atom;
import jason.asSyntax.ListTerm;
import jason.asSyntax.Term;

import java.util.HashSet;
import java.util.Set;

import org.semanticweb.owl.model.OWLAxiom;
import org.semanticweb.owl.model.OWLIndividualAxiom;

import bebops.common.IncisionFunction;

public class JASDLIncisionFunction extends IncisionFunction{    
    

    private JASDLAgent agent;
    private SELiteral toAddLiteral;

    /**
     * The SELiteral to be added is required for a particularly inelegant hack that allows us
     * to retrieve the annotations of the NOT YET ADDED axiom.
     * 
     * @param agent     required for getting trust ratings
     * @param toAdd
     * @param toAddAnnotations
     */
    public JASDLIncisionFunction(JASDLAgent agent, SELiteral toAddLiteral){
        this.agent = agent;
        this.toAddLiteral = toAddLiteral;
    }
    
    /**
     * Chooses from each akernel axiom with lowest trust associated with it.
     * Currently calculated using ASSERTED source annotations only.
     * No source annotation is taken as trust = 0;
     */
    public Set<OWLAxiom> applyToOne(Set<OWLAxiom> akernel){
        try{
            Set<OWLAxiom> chosen = new HashSet<OWLAxiom>();
            if(!akernel.isEmpty()){
                OWLAxiom leastTrusted = null; // guaranteed to take a value 
                float minTrustRating = 1f;                  
                for(OWLAxiom axiom : akernel){
                    float trustRating = getTrustRating(axiom);
                    agent.getLogger().finest("Trust rating of "+axiom+"="+trustRating);
                    if(trustRating <= minTrustRating){
                        minTrustRating = trustRating;
                        leastTrusted = axiom;
                    }
                }
                chosen.add(leastTrusted);
            }
            return chosen;
        }catch(Exception e){
            e.printStackTrace(); // TODO: introduce a seperate exception hierarchy once this package has been seperated from JASDL
            return null;
        }
    }
    
    /**
     * Currently returns the trust rating of the most trusted source. Future work will look at better ways of calculating this.
     * TODO: Essentially duplicating work here. Annotation gathering (performed by AxiomToSELiteralConverter) requires axiom-pinponting - so does contraction.
     * @param axiom
     * @return
     * @throws JASDLException
     */
    private float getTrustRating(OWLAxiom axiom) throws JASDLException{
        ListTerm sources;
        if(axiom.equals(agent.getSELiteralToAxiomConverter().create(toAddLiteral))){ // hack to get the annotations of the NOT YET ADDED toAdd axiom
            sources = toAddLiteral.getLiteral().getSources();
        }else{
            SELiteral sl = agent.getAxiomToSELiteralConverter().convert((OWLIndividualAxiom)axiom); // kernel filter ensures axiom is an OWLIndividualAxiom
            sources = sl.getLiteral().getSources();
        }       
        agent.getLogger().finest("Sources of "+axiom+"="+sources);
        float maxTrustRating = 0f; // if no sources available, trust is 0
        for(Term source : sources){
            if(!source.isAtom()){
                throw new JASDLException("Invalid source annotation "+source);
            }
            Atom name = (Atom)source;
            float trustRating = agent.getConfig().getTrustRating(name);
            if(trustRating > maxTrustRating){
                maxTrustRating = trustRating;
            }
        }       
        return maxTrustRating;
    }

    
}
