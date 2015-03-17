/* 
 *  Copyright (C) 2008 Thomas Klapiscak (t.g.klapiscak@durham.ac.uk)
 *  
 *  This file is part of JMCA.
 *
 *  JMCA is free software: you can redistribute it and/or modify
 *  it under the terms of the Lesser GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *
 *  JMCA is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  Lesser GNU General Public License for more details.
 *
 *  You should have received a copy of the Lesser GNU General Public License
 *  along with JMCA.  If not, see <http://www.gnu.org/licenses/>.
 *  
 */
package elbpp.selection;

import jason.asSemantics.Agent;
import jason.asSemantics.Option;
import jason.asSyntax.Literal;
import jason.asSyntax.NumberTerm;
import jason.asSyntax.Pred;
import jason.asSyntax.Term;

import java.util.List;
import java.util.Vector;
import java.util.logging.Logger;

import jmca.selection.SelectionStrategy;

/**
 * "Explicit Level-Based Plan Prioritisation". Orders options into levels according to X in "pl(X)" plan
 * label annotation. All plans from the highest level are chosen.
 * 
 * @author Tom Klapiscak
 *
 */
public class ElbppOptionSelectionStrategy extends SelectionStrategy<Option>{
    private Logger logger = Logger.getLogger(this.getClass().getName());
    
    public static String PRIORITY_LEVEL_ANNOT = "pl";
    public static int DEFAULT_PRIORITY_LEVEL = 0;
    
    public ElbppOptionSelectionStrategy(Agent master){
        super(master);
    }

    
    public List<Option> select(List<Option> options, List<Option> intersection){
        List<Option> chosen = new Vector<Option>();
        
        // get highest priority in list:
        int max = 0;
        for(Option option : options){
            int pl = getPriorityLevel(option.getPlan().getLabel());
            if(pl>max){
                max=pl;
            }
        }
        
        // retain only those that have a priority of max        
        for(Option option : options){
            int pl = getPriorityLevel(option.getPlan().getLabel());
            if(pl==max){
                chosen.add(option);
            }
        }
        
        logger.fine("Chosen: "+chosen);
        
        return chosen;
    }
    
    private int getPriorityLevel(Pred pred){
        for(Term _annot : pred.getAnnots()){
            if(_annot.isLiteral()){
                Literal annot = (Literal)_annot;
                if(annot.getFunctor().equals(PRIORITY_LEVEL_ANNOT)){
                    Term _l = annot.getTerm(0);
                    if(_l.isNumeric()){
                        NumberTerm l = (NumberTerm)_l;
                        try{
                            return (int)l.solve();
                        }catch(Exception e){
                            logger.warning("Exception caught calculating priority level of "+pred+". Reason: "+e);
                        }
                    }
                }
            }
        }
        return DEFAULT_PRIORITY_LEVEL;
    }   
    
    
}
