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

import jasdl.bridge.JASDLOntologyManager;
import jasdl.util.exception.JASDLException;
import jasdl.util.exception.JASDLInvalidSELiteralException;
import jason.asSyntax.ListTerm;
import jason.asSyntax.Literal;
import jason.asSyntax.Term;

import java.util.HashSet;
import java.util.Set;

import org.semanticweb.owl.model.OWLIndividual;

public class SELiteralAllDifferentAssertion extends SELiteral {

    public SELiteralAllDifferentAssertion(Literal l, JASDLOntologyManager jasdlOntologyManager) {
        super(l, jasdlOntologyManager);
    }

    @Override
    public OWLIndividual getOWLIndividual(int i) throws JASDLException {
        throw new JASDLException("Cannot be used on all_different assertions");
    }

    /**
     * Validates since terms are mutable
     * @return
     */
    public Set<OWLIndividual> getOWLIndividuals() throws JASDLException {
        if (!literal.getTerm(0).isList())
            throw new JASDLInvalidSELiteralException("The first term of an all_different assertion must be a list");
        ListTerm list = (ListTerm) literal.getTerm(0);
        Set<OWLIndividual> is = new HashSet<OWLIndividual>();
        for (Term i : list) {
            is.add(getOWLIndividual(i));
        }
        return is;
    }

}
