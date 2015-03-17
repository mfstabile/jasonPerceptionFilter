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

import static jasdl.util.JASDLCommon.strip;
import static jasdl.util.JASDLCommon.surroundedBy;
import jasdl.JASDLParams;
import jasdl.bridge.JASDLOntologyManager;
import jasdl.util.exception.JASDLException;
import jasdl.util.exception.JASDLInvalidSELiteralException;
import jasdl.util.owlapi.xsd.XSDVocabularyUtils;
import jason.asSyntax.Literal;
import jason.asSyntax.Term;

import org.semanticweb.owl.model.OWLDataProperty;
import org.semanticweb.owl.model.OWLDataType;
import org.semanticweb.owl.model.OWLOntology;
import org.semanticweb.owl.model.OWLTypedConstant;
import org.semanticweb.owl.vocab.XSDVocabulary;

public class SELiteralDataPropertyAssertion extends SELiteralPropertyAssertion {

    public SELiteralDataPropertyAssertion(Literal l, JASDLOntologyManager jasdlOntologyManager) {
        super(l, jasdlOntologyManager);
    }

    public OWLDataProperty getPredicate() throws JASDLException {
        return (OWLDataProperty) toOWLObject();
    }

    public OWLTypedConstant getObject() throws JASDLException {
        OWLOntology ontology = getOntology();
        OWLDataType typ = (OWLDataType) getPredicate().getRanges(ontology).toArray()[0];// will this always return exactly 1 range? If not, how should I deal with it
        XSDVocabulary wrapper = XSDVocabularyUtils.getByName(typ.toString());
        Term o = literal.getTerm(JASDLParams.RANGE);
        if (XSDVocabularyUtils.requiresStringTermRepresentation(wrapper)) {
            if (!surroundedBy(o.toString(), "\"")) {
				throw new JASDLInvalidSELiteralException("Data type mismatch on " + this);
			}
		}
		return jom.getOntologyManager().getOWLDataFactory().getOWLTypedConstant(strip(o.toString().replace("\\\"", "\""), "\""), typ); // quotes stripped
    }

}
