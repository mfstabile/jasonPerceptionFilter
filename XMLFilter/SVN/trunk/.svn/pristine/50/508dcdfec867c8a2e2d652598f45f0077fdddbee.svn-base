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

import java.util.HashMap;
import java.util.Map;

import org.semanticweb.owl.expression.OWLEntityChecker;
import org.semanticweb.owl.model.OWLDataFactory;
import org.semanticweb.owl.model.OWLDataType;
import org.semanticweb.owl.vocab.XSDVocabulary;

/**
 * Implements xsd datatype recognition common to entity checkers used by JASDL. TODO: Request ManchesterOWLSyntaxEditorParser#DefaultEntityChecker is
 * made visible to avoid code duplication seen here.
 * 
 * @author Tom Klapiscak
 *
 */
public abstract class XSDDatatypeChecker implements OWLEntityChecker {
    private Map<String, OWLDataType> dataTypeNameMap;

    public XSDDatatypeChecker(OWLDataFactory dataFactory) {
        dataTypeNameMap = new HashMap<String, OWLDataType>();
        for (XSDVocabulary v : XSDVocabulary.values()) {
            //  System.out.println(v);
            dataTypeNameMap.put(v.getURI().getFragment(), dataFactory.getOWLDataType(v.getURI()));
            dataTypeNameMap.put("xsd:" + v.getURI().getFragment(), dataFactory.getOWLDataType(v.getURI()));
        }
    }

    public OWLDataType getOWLDataType(String name) {
        return dataTypeNameMap.get(name);
    }

}
