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
package jasdl.bridge.mapping;

import jasdl.util.exception.JASDLDuplicateMappingException;
import jasdl.util.exception.JASDLUnknownMappingException;

import java.util.HashMap;
import java.util.Set;
import java.util.logging.Logger;

/**
 * A bi-directional hash map that enforces 1 to 1 mappings.
 * 
 * @author Tom Klapiscak
 *
 * @param <X>
 * @param <Y>
 */
public class MappingManager<X extends Object, Y extends Object> {
    protected Logger logger = Logger.getLogger(this.getClass().toString());

    protected HashMap<X, Y> xToYMap;

    protected HashMap<Y, X> yToXMap;

    public MappingManager() {
        xToYMap = new HashMap<X, Y>();
        yToXMap = new HashMap<Y, X>();
    }

    /**
     * Maps an x to a y and visa-versa.
     * 1 <-> 1 relationships enforced to prevent ambiguous mapping.
     * @param alias
     * @param entity
     * @throws JASDLDuplicateMappingException   if either alias or entity is already mapped (thus breaking 1 <-> 1 constraint)
     */
    public void put(X x, Y y) throws JASDLDuplicateMappingException {
        logger.finest("mapping " + x + " <-> " + y);

        if (isKnownLeft(x)) {
            throw new JASDLDuplicateMappingException("Duplicate mapping on " + x);
        }
        if (isKnownRight(y)) {
            throw new JASDLDuplicateMappingException("Duplicate mapping on " + y);
        }

        xToYMap.put(x, y);
        yToXMap.put(y, x);
    }

    /**
     * Gets the alias associated with an entity
     * @param entity
     * @return
     * @throws JASDLUnknownMappingException if entity is unknown (not mapped)
     */
    public X getLeft(Y y) throws JASDLUnknownMappingException {
        X x = yToXMap.get(y);
        if (x == null) {
            throw new JASDLUnknownMappingException("Unknown mapping " + y);
        }
        return x;
    }

    /**
     * Gets the entity associated with an alias
     * @param alias
     * @return
     * @throws JASDLUnknownMappingException if alias is unknown (not mapped)
     */
    public Y getRight(X x) throws JASDLUnknownMappingException {
        Y y = xToYMap.get(x);
        if (y == null) {
            throw new JASDLUnknownMappingException("Unknown mapping " + x);
        }
        return y;
    }

    public boolean isKnownLeft(X x) {
        return xToYMap.containsKey(x);
    }

    public boolean isKnownRight(Y y) {
        return yToXMap.containsKey(y);
    }

    public Set<X> getLefts() {
        return xToYMap.keySet();
    }

    public Set<Y> getRights() {
        return yToXMap.keySet();
    }

    public void removeByLeft(X x) {
        Y y = xToYMap.remove(x);
        yToXMap.remove(y);
    }

    public void removeByRight(Y y) {
        X x = yToXMap.remove(y);
        xToYMap.remove(x);
    }
}
