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

import jasdl.JASDLParams;
import jason.asSyntax.Atom;

/**
 * A JASDL alias is a (functor,label) pair used for mapping between SE-Literals and their equivalent axiomatic representation.
 * The functor corresponds to the aliased name of an OWLEntity. The label corresponds to the OWLOntology this entity resides within.
 * For example ("hotel", "travel") might correspond to the OWLEntity with the URI http://www.owl.com/travel.owl#Hotel.
 * Here the mapping can be thought of as: "hotel" -> "Hotel" and "travel" -> the namespace "http://www.owl.com/travel.owl".
 * An alias referring to a negated OWLClass is identified and kept unique by a "~" prefix, inline with AgentSpeak syntax.
 * A special case is made for aliases referring to OWLDifferentIndividualsAxioms, for these the functor is always "all_different".
 * 
 * @author Tom Klapiscak
 *
 */
public class Alias {
    private Atom functor;

    private Atom label;

    public Alias(String functor, Atom label) {
        this(new Atom(functor), label);
    }

    public Alias(Atom functor, Atom label) {
        super();
        this.functor = functor;
        this.label = label;
    }

    /**
     * Matches functor and label
     */
    @Override
    public boolean equals(Object _other) {
        if (!(_other instanceof Alias)) {
            return false;
        }
        Alias other = (Alias) _other;
        return functor.equals(other.functor) && label.equals(other.label);
    }

    /**
     * Hash-code equivalent to hash-code of functor concatenated with label
     */
    @Override
    public int hashCode() {
        return (functor.getFunctor() + label.getFunctor()).hashCode();
    }

    @Override
    public String toString() {
        return functor + "[" + label + "]";
    }

    public boolean isAllDifferent() {
        return functor.equals(JASDLParams.OWL_ALL_DIFFERENT_FUNCTOR);
    }

    public Atom getFunctor() {
        return functor;
    }

    public Atom getLabel() {
        return label;
    }

}
