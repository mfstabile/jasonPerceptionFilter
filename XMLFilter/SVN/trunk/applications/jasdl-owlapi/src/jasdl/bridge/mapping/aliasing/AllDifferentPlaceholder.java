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

import jason.asSyntax.Atom;

import java.net.URI;
import java.util.Set;

import org.semanticweb.owl.model.OWLAnnotation;
import org.semanticweb.owl.model.OWLAnnotationAxiom;
import org.semanticweb.owl.model.OWLClass;
import org.semanticweb.owl.model.OWLDataProperty;
import org.semanticweb.owl.model.OWLDataType;
import org.semanticweb.owl.model.OWLEntity;
import org.semanticweb.owl.model.OWLEntityVisitor;
import org.semanticweb.owl.model.OWLIndividual;
import org.semanticweb.owl.model.OWLNamedObjectVisitor;
import org.semanticweb.owl.model.OWLObject;
import org.semanticweb.owl.model.OWLObjectProperty;
import org.semanticweb.owl.model.OWLObjectVisitor;
import org.semanticweb.owl.model.OWLOntology;

/**
 * Since all_different has no concrete entity associated with it, we create a "placeholder" so that it remains consistent with
 * JASDL's mapping mechanisms. Entities of this type will be intercepted and dealt with differently.
 * Associated with an ontology label which determines hash-code - required since each ontology must have its own placeholder to reference
 * @author Tom Klapiscak
 *
 */
public class AllDifferentPlaceholder implements OWLEntity {
    public static URI ALL_DIFFERENT_PLACEHOLDER_URI = URI.create("http://all/different.owl#placeholder");

    private Atom label;

    public AllDifferentPlaceholder(Atom label) {
        this.label = label;
    }

    public void accept(OWLEntityVisitor visitor) {
    }

    public Set<OWLAnnotationAxiom> getAnnotationAxioms(OWLOntology ontology) {
        return null;
    }

    public Set<OWLAnnotation> getAnnotations(OWLOntology ontology) {
        return null;
    }

    public Set<OWLAnnotation> getAnnotations(OWLOntology ontology, URI annotationURI) {
        return null;
    }

    public void accept(OWLObjectVisitor visitor) {

    }

    public void accept(OWLNamedObjectVisitor visitor) {
    }

    public URI getURI() {
        return ALL_DIFFERENT_PLACEHOLDER_URI;
    }

    public boolean equals(Object other) {
        if (!(other instanceof AllDifferentPlaceholder)) {
            return false;
        }
        return label.equals(((AllDifferentPlaceholder) other).label);
    }

    public int hashCode() {
        return label.hashCode();
    }

    public OWLClass asOWLClass() {
        return null;
    }

    public OWLDataProperty asOWLDataProperty() {
        return null;
    }

    public OWLDataType asOWLDataType() {
        return null;
    }

    public OWLIndividual asOWLIndividual() {
        return null;
    }

    public OWLObjectProperty asOWLObjectProperty() {
        return null;
    }

    public boolean isOWLClass() {
        return false;
    }

    public boolean isOWLDataProperty() {
        return false;
    }

    public boolean isOWLDataType() {
        return false;
    }

    public boolean isOWLIndividual() {
        return false;
    }

    public boolean isOWLObjectProperty() {
        return false;
    }

    public int compareTo(OWLObject arg0) {
        return 0;
    }

}
