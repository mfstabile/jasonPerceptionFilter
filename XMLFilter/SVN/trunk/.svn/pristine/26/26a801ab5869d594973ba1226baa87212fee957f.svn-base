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
package jasdl.bridge.mapping.aliasing;

import jasdl.bridge.mapping.MappingManager;
import jasdl.util.exception.JASDLDuplicateMappingException;

import org.semanticweb.owl.model.OWLClass;
import org.semanticweb.owl.model.OWLDescription;

/**
 * Maintains mappings between run-time defined classes and their anonymous descriptions.
 * Required for recursive rendering of run-time defined classes in terms of predefined.
 * @author Tom Klapiscak
 *
 */
public class DefinitionManager extends MappingManager<OWLClass, OWLDescription> {

    /**
     * Extended to permit a definition to be mapped to many aliases
     * (i.e. may be defined in many personal ontologies)
     * @param x
     * @param y
     * @throws JASDLDuplicateMappingException
     */
    @Override
    public void put(OWLClass x, OWLDescription y) throws JASDLDuplicateMappingException {
        logger.finest("mapping " + x + " <-> " + y);

        if (isKnownLeft(x)) {
            throw new JASDLDuplicateMappingException("Duplicate mapping on " + x);
        }

        xToYMap.put(x, y);
        yToXMap.put(y, x);
    }
}
