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

import jmca.selection.SelectionStrategy;
import jmca.util.JmcaException;

/**
 * Implementations of this are responsible for mediating the selection process between selection strategies
 *  
 * @author Tom Klapiscak
 *
 * @param <T> The type of aspect this mediation strategy instance deals with
 */
public interface MediationStrategy<T> {
    
    /**
     * Initialisation specific to this mediation strategy must be performed here.
     * Passed the entire .mas2j settings instance, allowing for the specification
     * of mediation strategy specific parameters in the .mas2j file
     * @param stts      the mas2j settings object for the agent this mediation strategy instance applies to
     */
    public void init(Settings stts);
    
    /**
     * Implementations of this method must apply the select method of each selection strategy in the composition chain in turn,
     * mediating between each. It must ultimately arrive upon an "agreed" set of aspect instances.
     * 
     * @param selectionStrategies           a composition chain of selection strategies dealing with the same aspect as this mediation strategy
     * @param elements          the list of aspect instances that each selection strategy must choose from
     * @return                  the "agreed" set, influenced by each selection strategy, mediated by this mediation strategy
     * @throws JmcaException
     */
    public List<T> apply(List<SelectionStrategy<T>> selectionStrategies, List<T> elements) throws JmcaException;
}
