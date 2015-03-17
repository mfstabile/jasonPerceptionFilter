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
package jasdl.bridge.mapping.label;

import jasdl.bridge.mapping.MappingManager;
import jasdl.util.exception.JASDLDuplicateMappingException;
import jason.asSyntax.Atom;

import java.util.HashSet;
import java.util.Set;

import org.semanticweb.owl.model.OWLOntology;

/**
 * Maintains a bi-directional link between atomic ontology label and the corresponding ontology object.
 * Each JasdlAgent has one LabelManager.
 * @author Tom Klapiscak
 *
 */
public class LabelManager extends MappingManager<Atom, OWLOntology> {

    /**
     * Members of this set are defined as "personal" ontology instances used for storing axioms
     * about run-time defined classes and individuals. This information is needed, for example, when preparing
     * outgoing message content (named or anon?).
     */
    private Set<OWLOntology> personals;

    public LabelManager() {
        super();
        personals = new HashSet<OWLOntology>();
    }

    public boolean isPersonal(OWLOntology y) {
        return personals.contains(y);
    }

    public void put(Atom x, OWLOntology y, boolean isPersonal) throws JASDLDuplicateMappingException {
        if (isPersonal)
            personals.add(y);
        super.put(x, y);
    }

}
