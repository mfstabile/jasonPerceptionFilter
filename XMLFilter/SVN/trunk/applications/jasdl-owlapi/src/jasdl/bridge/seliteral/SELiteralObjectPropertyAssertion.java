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
package jasdl.bridge.seliteral;

import jasdl.JASDLParams;
import jasdl.bridge.JASDLOntologyManager;
import jasdl.util.exception.JASDLException;
import jason.asSyntax.Literal;

import org.semanticweb.owl.model.OWLIndividual;
import org.semanticweb.owl.model.OWLObjectProperty;

public class SELiteralObjectPropertyAssertion extends SELiteralPropertyAssertion {

    public SELiteralObjectPropertyAssertion(Literal l, JASDLOntologyManager jasdlOntologyManager) {
        super(l, jasdlOntologyManager);
    }

    public OWLIndividual getSubject() throws JASDLException {
        return getOWLIndividual(JASDLParams.DOMAIN);
    }

    public OWLObjectProperty getPredicate() throws JASDLException {
        return (OWLObjectProperty) toOWLObject();
    }

    public OWLIndividual getObject() throws JASDLException {
        return getOWLIndividual(JASDLParams.RANGE);
    }

}
