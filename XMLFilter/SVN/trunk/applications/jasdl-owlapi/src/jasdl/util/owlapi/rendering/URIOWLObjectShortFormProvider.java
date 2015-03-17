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

import org.semanticweb.owl.model.OWLEntity;

public class URIOWLObjectShortFormProvider extends NormalisingOWLObjectShortFormProvider {
    
    public URIOWLObjectShortFormProvider(JASDLOntologyManager jom) {
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
            return entity.getURI().toString();
        }
    }
}
