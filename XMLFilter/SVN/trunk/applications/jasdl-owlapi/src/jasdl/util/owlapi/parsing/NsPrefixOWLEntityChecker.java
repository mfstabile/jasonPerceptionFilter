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

import jasdl.bridge.JASDLOntologyManager;
import jasdl.bridge.factory.AliasFactory;
import jasdl.bridge.mapping.aliasing.Alias;
import jasdl.util.exception.JASDLException;
import jason.asSyntax.Atom;

import org.semanticweb.owl.model.OWLClass;
import org.semanticweb.owl.model.OWLDataProperty;
import org.semanticweb.owl.model.OWLEntity;
import org.semanticweb.owl.model.OWLIndividual;
import org.semanticweb.owl.model.OWLObjectProperty;

/**
 * For parsing class-expressions defined with entities in the alias label:functor format.
 * E.g. "(travel:hotel and travel:hasActivity some travel:museums) and owl:thing"
 * @author Tom Klapiscak
 *
 */
public class NsPrefixOWLEntityChecker extends XSDDatatypeChecker {

    private JASDLOntologyManager jom;

    public NsPrefixOWLEntityChecker(JASDLOntologyManager jasdlOntologyManager) {
        super(jasdlOntologyManager.getOntologyManager().getOWLDataFactory());
        this.jom = jasdlOntologyManager;
    }

    public OWLClass getOWLClass(String name) {
        OWLEntity entity = convert(name);
        if (entity == null) {
            return null;
        }
        if (entity.isOWLClass()) {
            return entity.asOWLClass();
        } else {
            return null;
        }
    }

    public OWLDataProperty getOWLDataProperty(String name) {
        OWLEntity entity = convert(name);
        if (entity == null) {
            return null;
        }
        if (entity.isOWLDataProperty()) {
            return entity.asOWLDataProperty();
        } else {
            return null;
        }
    }

    public OWLIndividual getOWLIndividual(String name) {
        OWLEntity entity = convert(name);
        if (entity == null) {
            try {
                // TODO: tidy this up
                String[] tokens = name.split(":");
                Atom functor = new Atom(tokens[1]);
                Atom label = new Atom(tokens[0]);
                Alias alias = AliasFactory.INSTANCE.create(functor, label);
                return jom.getOWLIndividual(alias);
            } catch (JASDLException e) {
                throw new RuntimeException(e);
            }
        }
        if (entity.isOWLIndividual()) {
            return entity.asOWLIndividual();
        } else {
            return null;
        }
    }

    public OWLObjectProperty getOWLObjectProperty(String name) {
        OWLEntity entity = convert(name);
        if (entity == null) {
            return null;
        }
        if (entity.isOWLObjectProperty()) {
            return entity.asOWLObjectProperty();
        } else {
            return null;
        }
    }

    private OWLEntity convert(String name) {
        String[] tokens = name.split(":");
        try {
            Atom functor = new Atom(tokens[1]);
            Atom label = new Atom(tokens[0]);
            Alias alias = AliasFactory.INSTANCE.create(functor, label);
            return (OWLEntity) jom.getAliasManager().getRight(alias); // guaranteed to be an entity? Not for anonymous classes!
        } catch (ClassCastException e) {
            // we are dealing with an anonymous class description
            return null;
        } catch (Exception e) {
            return null;
        }
    }

}
