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
package jasdl.env;

import jasdl.JASDLParams;
import jasdl.bridge.JASDLOntologyManager;
import jasdl.bridge.factory.SELiteralFactory;
import jasdl.bridge.protocol.ProtocolProcessor;
import jasdl.util.exception.JASDLException;
import jason.asSyntax.Literal;
import jason.environment.Environment;

import java.util.logging.Logger;

import org.mindswap.pellet.owlapi.Reasoner;
import org.semanticweb.owl.model.OWLException;

/**
 * Has its own JasdlOntologyManager which is used to maintain its own set of mappings which SE-percepts should be defined in terms of. 
 * This allows SE-Percepts to be communicated unambiguously to agents (note that environments should not have direct access to actual Agent
 * objects - consider distributed environments).
 * <ul>
 * <li>Provides methods for construction of unambiguous SE-percepts</li>
 * </ul>
 * @author Tom Klapiscak
 *
 */
public class JASDLEnvironment extends Environment {
    private ProtocolProcessor processor;

    private JASDLOntologyManager jom;


    @Override
    public void init(String[] args){
        super.init(args);
        try {
            jom = new JASDLOntologyManager(Logger.getLogger(this.getClass().getName()));
        } catch (OWLException e) {
            throw new RuntimeException(e);
        }
        jom.setReasoner(new Reasoner(jom.getOntologyManager()));
        processor = new ProtocolProcessor(jom, JASDLParams.DEFAULT_MAPPING_STRATEGIES);
    }

    public JASDLOntologyManager getJom() {
        return jom;
    }

    public SELiteralFactory getSELiteralFactory() {
        return jom.getSELiteralFactory();
    }

    public void addPercept(Literal per) {
        try {
            super.addPercept((Literal) processor.processOutgoingStructure(per));
        } catch (JASDLException e) {
            e.printStackTrace();
        }
    }

    public void addPercept(String agName, Literal per) {
        try {
            super.addPercept(agName, (Literal) processor.processOutgoingStructure(per));
        } catch (JASDLException e) {
            e.printStackTrace();
        }
    }

    public boolean containsPercept(Literal per) {
        try {
            return super.containsPercept((Literal) processor.processOutgoingStructure(per));
        } catch (JASDLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean containsPercept(String agName, Literal per) {
        try {
            return super.containsPercept(agName, (Literal) processor.processOutgoingStructure(per));
        } catch (JASDLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean removePercept(Literal per) {
        try {
            return super.removePercept((Literal) processor.processOutgoingStructure(per));
        } catch (JASDLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean removePercept(String agName, Literal per) {
        try {
            return super.removePercept(agName, (Literal) processor.processOutgoingStructure(per));
        } catch (JASDLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public int removePerceptsByUnif(Literal per) {
        try {
            return super.removePerceptsByUnif((Literal) processor.processOutgoingStructure(per));
        } catch (JASDLException e) {
            e.printStackTrace();
            return 0;
        }
    }

    public int removePerceptsByUnif(String agName, Literal per) {
        try {
            return super.removePerceptsByUnif(agName, (Literal) processor.processOutgoingStructure(per));
        } catch (JASDLException e) {
            e.printStackTrace();
            return 0;
        }
    }

}
