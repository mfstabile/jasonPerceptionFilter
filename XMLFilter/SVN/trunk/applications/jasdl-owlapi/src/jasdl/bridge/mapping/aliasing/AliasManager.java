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

import org.semanticweb.owl.model.OWLObject;

/**
 * Maintains a bi-directional link between JASDL aliases (functor+ontology label) and the corresponding ontology resource (OWLObject).
 * Each JasdlAgent has one AliasManager.
 * @author Tom Klapiscak
 *
 */
public class AliasManager extends MappingManager<Alias, OWLObject> {
}
