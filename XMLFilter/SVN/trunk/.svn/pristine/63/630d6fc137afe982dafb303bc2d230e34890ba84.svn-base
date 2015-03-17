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
package jasdl.util;

import jasdl.bridge.JASDLOntologyManager;
import jasdl.bridge.seliteral.SELiteral;
import jasdl.util.exception.JASDLException;
import jasdl.util.exception.JASDLInvalidSELiteralException;
import jasdl.util.exception.JASDLUnknownMappingException;
import jason.asSyntax.Literal;
import jason.asSyntax.Structure;
import jason.asSyntax.Term;
import jason.asSyntax.Trigger;

import java.io.File;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Set;

import org.semanticweb.owl.inference.OWLReasonerAdapter;
import org.semanticweb.owl.model.OWLDataProperty;
import org.semanticweb.owl.model.OWLDescription;
import org.semanticweb.owl.model.OWLEntity;
import org.semanticweb.owl.model.OWLException;
import org.semanticweb.owl.model.OWLObject;
import org.semanticweb.owl.model.OWLObjectProperty;

public class JASDLCommon {

    public static boolean surroundedBy(String text, String match) {
        return text.startsWith(match) && text.endsWith(match);
    }

    public static String strip(String text, String remove) {
        if (text == null) {
            return null;
        }
        if (surroundedBy(text, remove)) {
            return text.substring(remove.length(), text.length() - remove.length());
        } else {
            return text;
        }
    }

    /**
     * TODO: Probably should be a part of jason's Trigger class?
     * @param trigger
     * @return
     */
    public static Trigger.TEOperator getTEOp(Trigger trigger) {
        if (trigger.isAddition()) {
            return Trigger.TEOperator.add;
        } else {
            return Trigger.TEOperator.del;
        }
    }

    public static String getCurrentDir() {
        File dir1 = new File(".");
        String strCurrentDir = "";
        try {
            strCurrentDir = dir1.getCanonicalPath();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return strCurrentDir;
    }
    
    
    /**
     * Semantically naive literals are always considered more specific than semantically enriched.
     * Do not need to consider incomparable literals (those with different arities or those with different semantic enrichment state)
     * since one can never generalise to the other.
     * 
     * Algorithm functions as follows:
     * 
     * Terminal cases:
     * if either x or y is not a structure, they are incomparable (different arities (at least one has no terms))
     * If arity(x)!=arity(y) then they are considered incomparable and we (arbitrarily) return arity(x)<arity(y)
     * If SN(x) and SE(y) then we return true
     * if SE(x) and SN(y) then we return false
     * if SE(x) and SE(y) then we return subsumes(y, x) (i.e. true if x is more specific)
     * 
     * Recursive case:
     * score=0
     * if SN(x) and SN(y) then
     *      for each term of x and y in parallel
     *          if isMoreSpecific(x, y) then score++ else score--
     * 
     * if score>=0 then we return true (i.e. x has a greater number of more specific terms than y) else false
     * 
     * TODO: have a unifier "collect" unifications on all variables?
     *
     */
    public static boolean isMoreSpecific(Term _x, Term _y, JASDLOntologyManager jom) throws JASDLException, OWLException{
        if(!_x.isStructure() || !_y.isStructure()) return false;        
        Structure x = (Structure)_x;
        Structure y = (Structure)_y;
        
        if(x.getArity() != y.getArity()) return false;
        SELiteral sx = null;
        SELiteral sy = null;
        
        try {
            if(x.isLiteral()) sx = jom.getSELiteralFactory().construct((Literal)x);
        } catch (JASDLInvalidSELiteralException e) {
        }
        
        try {
            if(y.isLiteral()) sy = jom.getSELiteralFactory().construct((Literal)y);
        } catch (JASDLInvalidSELiteralException e) {
        }
        
        if((sx == null && sy != null) || (sx != null && sy == null)) return false;
        
        if(sx != null && sy != null) return JASDLCommon.subsumes(jom, sy.toOWLObject(), sx.toOWLObject());
        
        // both sx and sy are semantically-naive and have equivalent arities
        int score = 0;
        for(int i=0; i<x.getArity(); i++){
            Term xt = x.getTerm(i);
            Term yt = y.getTerm(i);
            
            if(isMoreSpecific(xt, yt, jom)) score++; else score--;
            
        }
        
        if(score>=0) return true; else return false;
    }   
    
    
    
    /**
     * Convenience method that returns true if o1 subsumes o2. Behaves polymorphically dependant on types of the supplied objects
     * (classes or object/data properties).
     * @param agent
     * @param o1
     * @param o2
     * @return
     * @throws OWLException
     * @throws JASDLException
     */
    public static boolean subsumes(JASDLOntologyManager jom, OWLObject o1, OWLObject o2) throws OWLException, JASDLException {

        if (o1 instanceof OWLDescription && o2 instanceof OWLDescription) {
            OWLDescription d1 = (OWLDescription) o1;
            OWLDescription d2 = (OWLDescription) o2;

            if (jom.getReasoner().isEquivalentClass(d1, d2) || jom.getReasoner().isSubClassOf(d2, d1)) {
                return true;
            }

        } else if (o1 instanceof OWLObjectProperty && o2 instanceof OWLObjectProperty) {
            OWLObjectProperty p1 = (OWLObjectProperty) o1;
            OWLObjectProperty p2 = (OWLObjectProperty) o1;

            if (p1.equals(p2)) {
                return true;
            }

            Set<OWLObjectProperty> subProperties = OWLReasonerAdapter.flattenSetOfSets(jom.getReasoner().getAncestorProperties(p1));
            if (subProperties.contains(p2)) {
                return true;
            }

        } else if (o1 instanceof OWLDataProperty && o2 instanceof OWLDataProperty) {
            OWLDataProperty p1 = (OWLDataProperty) o1;
            OWLDataProperty p2 = (OWLDataProperty) o1;

            if (p1.equals(p2)) {
                return true;
            }

            Set<OWLDataProperty> subProperties = OWLReasonerAdapter.flattenSetOfSets(jom.getReasoner().getAncestorProperties(p1));
            if (subProperties.contains(p2)) {
                return true;
            }
        }
        return false;
    }
    
    
    
    /**
     * Returns an expression in which all references to run-time defined classes have been (recursuvely) replaced 
     * with the rendering of their anonymous descriptions, thus ensuring this rendering only refers to predefined classes. 
     * @param expression        expression to normalise
     * @param agent
     * @return                  normalised form of expression
     * @deprecated  renderers now inherently normalise expressions
     * @throws JASDLException
     */
    public static String normaliseExpression(String expression, JASDLOntologyManager jasdlOntologyManager) throws JASDLException {
        String[] tokens = expression.toString().split("[ |\n]");
        String newExpression = "";
        for (String token : tokens) {
            try {
                URI entityURI = new URI(token);
                OWLEntity entity = jasdlOntologyManager.toEntity(entityURI);
                if (entity.isOWLClass()) {
                    try {
                        OWLDescription desc = jasdlOntologyManager.getDefinitionManager().getRight(entity.asOWLClass());
                        String rendering = jasdlOntologyManager.getManchesterURIOWLObjectRenderer().render(desc);
                        newExpression += "(" + normaliseExpression(rendering, jasdlOntologyManager) + ")";
                    } catch (JASDLUnknownMappingException e1) {
                        // this is a predefined class
                        newExpression += token;
                    }
                } else {
                    // this is a predefined non-class entity (property, individual, etc)
                    newExpression += token;
                }
            } catch (URISyntaxException e) {
                // this is (probably) a keyword
                newExpression += " " + token + " ";
            } catch (JASDLUnknownMappingException e2) {
                // this is (probably) a keyword
                newExpression += " " + token + " ";
            }

        }
        return newExpression;
    }
    
    
    /**
     * Now works for both linux and windows
     * @param suffix
     * @return
     */
    public static URI getRelativeLocalURI(String suffix){
        return URI.create("file:///" + getCurrentDir().replace("\\", "/") + suffix);
    }
    
    /**
     * Currently used only by owl2mas object property handlers
     * @param string
     * @return
     */
    public static String dropLast(String string){
        return string.substring(0, string.length()-1);
    }

}
