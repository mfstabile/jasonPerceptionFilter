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
package jasdl.bb.bebops;

import org.mindswap.pellet.owlapi.Reasoner;
import org.semanticweb.owl.inference.OWLReasoner;
import org.semanticweb.owl.model.OWLOntologyManager;

import com.clarkparsia.explanation.ReasonerFactory;

public class JASDLReasonerFactory implements ReasonerFactory {

    public JASDLReasonerFactory() {
        super();
    }

    public boolean requiresExplicitClassification() {
        return false;
    }

    public OWLReasoner createReasoner(OWLOntologyManager manager) {
        Reasoner pellet = new Reasoner(manager);
        return pellet;
    }

    public String getReasonerName() {
        return "reasoner";
    }

}
