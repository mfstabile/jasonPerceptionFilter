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
package jasdl.util.owlapi.parsing;

import jasdl.bridge.JASDLOntologyManager;
import jasdl.bridge.mapping.aliasing.Alias;
import jasdl.util.exception.JASDLException;

import java.net.URI;

import org.semanticweb.owl.model.OWLClass;
import org.semanticweb.owl.model.OWLDataProperty;
import org.semanticweb.owl.model.OWLEntity;
import org.semanticweb.owl.model.OWLIndividual;
import org.semanticweb.owl.model.OWLObjectProperty;

/**
 * For parsing class-expressions where entities are defined by their fully-qualified URIs.
 * E.g. "http://www.dur.ac.uk.t.g.klapiscak/travel.owl#Hotel and http://www.dur.ac.uk.t.g.klapiscak/travel.owl#Accommodation".
 * @author tom
 *
 */
public class URIOWLEntityChecker extends XSDDatatypeChecker {

    private JASDLOntologyManager jom;

    public URIOWLEntityChecker(JASDLOntologyManager jom) {
        super(jom.getOntologyManager().getOWLDataFactory());
        this.jom = jom;
    }

    public OWLClass getOWLClass(String uri) {
        OWLEntity entity = convert(uri);
        if (entity == null) {
            return null;
        }
        if (entity.isOWLClass()) {
            return entity.asOWLClass();
        } else {
            return null;
        }
    }

    public OWLDataProperty getOWLDataProperty(String uri) {
        OWLEntity entity = convert(uri);
        if (entity == null) {
            return null;
        }
        if (entity.isOWLDataProperty()) {
            return entity.asOWLDataProperty();
        } else {
            return null;
        }
    }

    /**
     * Will look across all known ontologies for individual. If not found, will instantiate according to alias generated from URI.
     * @see JASDLOntologyManager#toAlias(URI)
     * @see JASDLOntologyManager#getOWLIndividual(Alias)
     */
    public OWLIndividual getOWLIndividual(String uri) {
        OWLEntity entity = convert(uri);
        if (entity == null) {
            try {
                return jom.getOWLIndividual(URI.create(uri));
            } catch (JASDLException e) {
                throw new RuntimeException(e);
            }
        }
        if (entity.isOWLIndividual()) {
            return entity.asOWLIndividual();
        } else {
            return null;
        }
    }

    public OWLObjectProperty getOWLObjectProperty(String uri) {
        OWLEntity entity = convert(uri);
        if (entity == null) {
            return null;
        }
        if (entity.isOWLObjectProperty()) {
            return entity.asOWLObjectProperty();
        } else {
            return null;
        }
    }

    private OWLEntity convert(String _uri) {
        try {
            URI uri = new URI(_uri);
            return jom.toEntity(uri);
        } catch (Exception e) {
            return null;
        }
    }

}
