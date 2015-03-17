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
package jasdl.util.owlapi.xsd;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import org.semanticweb.owl.vocab.XSDVocabulary;

/**
 * Provides utility functions relating to AgentSpeak representation of XSD datatypes
 * @author Tom Klapiscak
 *
 */
public class XSDVocabularyUtils {

    /**
     * Maps toString names of OWLTypeConstants to XSDVocabulary values. TODO: Request as built-in OWL-API feature.
     * toString representation is simply path of listed URI
     */
    private static HashMap<String, XSDVocabulary> nameToEnumMap = new HashMap<String, XSDVocabulary>();
    static {
        for (XSDVocabulary typ : XSDVocabulary.values()) {
            String name = typ.getURI().getFragment().toString();
            nameToEnumMap.put(name, typ);
        }
    }

    /**
     * All XSD Datatypes requiring string term representations in AgentSpeak
     * TODO: Complete this list
     */
    private static List<XSDVocabulary> requiresStringTermRepresentation = Arrays.asList(new XSDVocabulary[] { XSDVocabulary.TIME, XSDVocabulary.STRING, XSDVocabulary.DATE, XSDVocabulary.DATE_TIME });

    /**
     * Returns true if datatype literals of this type require packaging within a StringTerm for representation in Agentspeak
     * @param typ
     * @return
     */
    public static boolean requiresStringTermRepresentation(XSDVocabulary typ) {
        return requiresStringTermRepresentation.contains(typ);
    }

    /**
     * Returns true if datatype literals of this type require representation as true or false in AgentSpeak
     * @param typ
     * @return
     */
    public static boolean requiresBooleanRepresentation(XSDVocabulary typ) {
        return typ == XSDVocabulary.BOOLEAN;
    }

    public static XSDVocabulary getByName(String name) {
        return nameToEnumMap.get(name);
    }

}
