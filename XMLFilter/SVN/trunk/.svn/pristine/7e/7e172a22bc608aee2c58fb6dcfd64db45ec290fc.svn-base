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
package jasdl.util.owlapi.rendering;

import jasdl.bridge.JASDLOntologyManager;
import jasdl.bridge.mapping.aliasing.Alias;
import jasdl.util.exception.JASDLException;

import org.semanticweb.owl.model.OWLEntity;

/**
 * Renders entity in JASDL's ns prefix format, e.g.
 * http://.../travel.owl#Hotel  ->  travel:hotel  (assuming travel is Hotel's ontology label and hotel is Hotel's alias).
 *
 *
 * Extends NormalisingOWLObjectShortForm provider to ensure run-time defined classes are normalised.
 * @author tom
 *
 */
public class NsPrefixOWLObjectShortFormProvider extends NormalisingOWLObjectShortFormProvider {

    public NsPrefixOWLObjectShortFormProvider(JASDLOntologyManager jom) {
        super(jom);     
    }

    public void dispose() {
    }

    public String getShortForm(OWLEntity entity) {
        String shortForm = super.getShortForm(entity);
        if(shortForm != null){
            // run-time defined class, has been normalised
            return shortForm;
        }else{
            try {           
                Alias alias = jom.getAliasManager().getLeft(entity);
                return alias.getLabel() + ":" + alias.getFunctor();
            } catch (JASDLException e) {
                throw new RuntimeException("Exception caught attempting to render " + entity, e);
            }
        }
    }
        
}
