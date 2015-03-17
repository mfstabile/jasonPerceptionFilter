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
package jmca.mediation;

import jason.runtime.Settings;

import java.util.List;
import java.util.Vector;

import jmca.selection.SelectionStrategy;
import jmca.util.JmcaException;

/**
 * The default (and currently only) mediation strategy bundled with
 * JMCA.  <p> Ultimately results in the intersection of the acceptable
 * sets chosen by each selection strategy being returned to the
 * JmcaAgent.<p> If at any point in the composition chain, this
 * intersection is empty (i.e. no agreement exists between this, and
 * previous strategies) then this module's whole acceptable set is
 * passed on to subsequent strategies. In this way, later strategies
 * take precedence over earlier ones under circumstances where no
 * mutually-agreed upon decision can be made.<p>
 * @author Tom Klapiscak
 *
 * @param <T>   The type of aspect this instance of OverrulingIntersection deals with
 */
public class OverrulingIntersection<T> implements MediationStrategy<T>{
    public void init(Settings stts){
        // do nothing
    }
    
    @SuppressWarnings("unchecked")
    public List<T> apply(List<SelectionStrategy<T>> selectionStrategies, List<T> elements) throws JmcaException{
        List<T> intersection = new Vector<T>();
        intersection.addAll(elements);
        for(SelectionStrategy selectionStrategy : selectionStrategies){
            List<T> chosen = selectionStrategy.select(elements, intersection);      
            intersection.retainAll(chosen);
            if(intersection.isEmpty()){ // no agreement, override earlier selections
                intersection = chosen;
            }
        }
        return intersection;
    }
}
