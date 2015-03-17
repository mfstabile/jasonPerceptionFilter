/* 
 *  Copyright (C) 2008 Thomas Klapiscak (t.g.klapiscak@durham.ac.uk)
 *  
 *  This file is part of JMCA.
 *
 *  JMCA is free software: you can redistribute it and/or modify
 *  it under the terms of the Lesser GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *
 *  JMCA is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  Lesser GNU General Public License for more details.
 *
 *  You should have received a copy of the Lesser GNU General Public License
 *  along with JMCA.  If not, see <http://www.gnu.org/licenses/>.
 *  
 */
package jmca.util;

/**
 * Some common operations bundled here for convenience
 * 
 * @author Tom Klapiscak
 *
 */
public class Common {
    /**
     * The delimiter used for JMCA .mas2j properties
     */
    public static String DELIM=",";
    
    /**
     * Strips all prefixes and suffixes from text that match remove 
     * @param text      the text to strip
     * @param remove    the prefix/suffix to match
     * @return          the stripped text
     */
    public static String strip(String text, String remove){
        if(text == null){ return null; }
        if(surroundedBy(text, remove)){
            return text.substring(remove.length(), text.length() - remove.length());
        }else{
            return text;
        }
    }
    
    /**
     * Returns true if text starts and ends with match
     * @param text  the text to check
     * @param match the string to look for
     * @return true if text starts and ends with match
     */
    public static boolean surroundedBy(String text, String match){
        return text.startsWith(match) && text.endsWith(match);
    }
}
