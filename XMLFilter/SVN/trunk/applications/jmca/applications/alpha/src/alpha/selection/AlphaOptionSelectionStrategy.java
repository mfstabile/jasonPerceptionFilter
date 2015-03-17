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
package alpha.selection;

import jason.asSemantics.Agent;
import jason.asSemantics.Option;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Vector;

import jmca.selection.SelectionStrategy;

/**
 * Orders options in ascending alphabetical order according to functor of the plan label predicate
 * and chooses first two from the head of the resulting list
 * 
 * @author Tom Klapiscak
 *
 */
public class AlphaOptionSelectionStrategy extends SelectionStrategy<Option>{
    
    /**
     * How many Options should be taken from head of (ordered) Option list
     */
    private static int choose = 2;
    
    public AlphaOptionSelectionStrategy(Agent master){
        super(master);
    }
    
    public List<Option> select(List<Option> options, List<Option> intersection){
        Comparator<Option> comp = new Comparator<Option>(){
            public int compare(Option a, Option b) {
                String af = a.getPlan().getLabel().getFunctor();
                String bf = b.getPlan().getLabel().getFunctor();
                return af.compareTo(bf);
            }           
        };      
        Collections.sort(options, comp);        
        Vector<Option> chosen = new Vector<Option>();
        for(int i=0; i<choose; i++){
            if(i>(options.size()-1)){
                break;
            }
            chosen.add(options.get(i));
        }
        return chosen;
    }
}
