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
package jasdl.bridge.factory;

import jasdl.JASDLParams;
import jasdl.bridge.mapping.aliasing.Alias;
import jasdl.bridge.seliteral.SELiteral;
import jasdl.util.exception.JASDLInvalidSELiteralException;
import jasdl.util.exception.JASDLUnknownMappingException;
import jason.asSyntax.Atom;

/**
 * A convenient singleton factory providing methods to create JASDL alias objects.
 * 
 * @author Tom Klapiscak
 *
 */
public class AliasFactory {

    /**
     * Singleton instance we should use.
     */
    public static AliasFactory INSTANCE = new AliasFactory();

    private AliasFactory() {
    }

    /**
     * Create an alias to represent an SELiteral. Literal functor becomes alias functor.
     * Literal ontology label becomes alias label;
     * If l is negated (and a unary class assertion) then functor is prefixed with "~".
     * @param sl    the SELiteral the alias will represent
     * @return      an alias representing the supplied SELiteral
     */
    public Alias create(SELiteral sl) throws JASDLInvalidSELiteralException, JASDLUnknownMappingException {
        return new Alias((sl.getLiteral().negated() ? "~" : "") + sl.getLiteral().getFunctor(), sl.getOntologyLabel());
    }

    /**
     * Create an alias from an atomic functor and label
     * @param functor
     * @param label
     * @return
     */
    public Alias create(Atom functor, Atom label) {
        return new Alias(functor, label);
    }

    public Alias all_different(Atom label) {
        return new Alias(JASDLParams.OWL_ALL_DIFFERENT_FUNCTOR, label);
    }
}
