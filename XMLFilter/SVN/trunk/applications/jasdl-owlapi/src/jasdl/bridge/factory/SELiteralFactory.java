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
package jasdl.bridge.factory;

import jasdl.JASDLParams;
import jasdl.bridge.JASDLOntologyManager;
import jasdl.bridge.mapping.aliasing.Alias;
import jasdl.bridge.mapping.aliasing.AllDifferentPlaceholder;
import jasdl.bridge.seliteral.SELiteral;
import jasdl.util.exception.JASDLException;
import jasdl.util.exception.JASDLInvalidSELiteralException;
import jasdl.util.exception.JASDLNotEnrichedException;
import jason.asSyntax.Atom;
import jason.asSyntax.ListTerm;
import jason.asSyntax.ListTermImpl;
import jason.asSyntax.Literal;
import jason.asSyntax.LiteralImpl;
import jason.asSyntax.Structure;
import jason.asSyntax.Term;

import java.util.Arrays;

import org.semanticweb.owl.model.OWLDataProperty;
import org.semanticweb.owl.model.OWLDescription;
import org.semanticweb.owl.model.OWLObject;
import org.semanticweb.owl.model.OWLObjectProperty;

/**
 * Factory class providing a set of utility methods that allow SE-Literals to be constructed from various sets of basic building blocks.
 * @author Tom Klapiscak
 *
 */
public class SELiteralFactory {

    /**
     * Reference to the JasdlOntologyManager this is acting on behalf of, required for access to other factories
     */
    private JASDLOntologyManager jom;

    public SELiteralFactory(JASDLOntologyManager jasdlOntologyManager) {
        this.jom = jasdlOntologyManager;
    }

    /**
     * Polymorphically creates a specific type of SELiteral based on the properties of the supplied literal.
     */
    public SELiteral construct(Literal l) throws JASDLInvalidSELiteralException {
        try {
            SELiteral sl = new SELiteral(l, jom); // so we can use convenience methods on a processed seliteral
            OWLObject entity = sl.toOWLObject();
            if (sl.getLiteral().getArity() == 1) {
                if (entity instanceof OWLDescription) {
                    return sl.asClassAssertion();
                } else if (entity instanceof AllDifferentPlaceholder) {
                    //if(!l.isGround()) throw new JasdlException("JASDL does not currently support unground all_different assertions such as "+l);
                    // TODO: can ensure this here (due to unground TG all_different literals), where should I? axiom converter?
                    if (l.negated())
                        throw new JASDLInvalidSELiteralException("JASDL does not currently support negated all_different assertions, since OWL makes the UNA by default and JASDL doesn't allow this to be overridden");
                    return sl.asAllDifferentAssertion();
                } else {
                    throw new JASDLInvalidSELiteralException("Does not refer to a known class or an all_different assertion");
                }
            } else if (sl.getLiteral().getArity() == 2) {
                if (sl.getLiteral().negated())
                    throw new JASDLInvalidSELiteralException("JASDL does not currently support negated property assertions such as " + sl);
                //if(!sl.getLiteral().getTerm(DOMAIN).isGround()) throw new InvalidSELiteralException("JASDL cannot handle left-unground property assertions such as "+sl);
                //TODO: ensure domain-unground property assertions cannot be converted to axioms
                if (entity instanceof OWLObjectProperty) {
                    return sl.asObjectPropertyAssertion();
                } else if (entity instanceof OWLDataProperty) {
                    return sl.asDataPropertyAssertion();
                } else {
                    throw new JASDLInvalidSELiteralException("Does not refer to a known object or data property");
                }
            } else {
                throw new JASDLInvalidSELiteralException("Must be either unary or binary");
            }
        } catch (JASDLNotEnrichedException e) {
            throw new JASDLNotEnrichedException("Cannot construct an SE-Literal from " + l, e); // <- need this specifically
        } catch (JASDLException e) {
            throw new JASDLInvalidSELiteralException("Cannot construct an SE-Literal from " + l, e);
        }
    }

    /**
     * Utility method to construct a SE-Literal from a sign, atomic functor, array of terms, array of (non-JASDL) annotations and an atomic ontology label.
     * Certain special cases are rejected because, although they are valid AgentSpeak syntax, their axiomatic representation is currently unsupported by JASDL.
     * Special cases:
     * <ul>
     * <li>sign=false, functor="thing" | "nothing", redundant since ~thing <-> nothing</li>
     * <li>sign=false, arity(terms)=2, since JASDL does not support negated properties</li>
     * <li>sign=false, functor="all_different", since JASDL does not assume UNA and so all_same ( <-> ~all_different) makes no sense</li>
     * </ul>
     */
    public SELiteral construct(boolean sign, Atom functor, Term[] terms, Term[] annots, Atom label) throws JASDLInvalidSELiteralException {
        Literal l = new LiteralImpl(sign, functor);

        // add "o"
        Structure o = new Structure(JASDLParams.ONTOLOGY_ANNOTATION_FUNCTOR);
        o.addTerm(label);
        l.addAnnot(o);

        l.addTerms(Arrays.asList(terms));
        if (annots != null) {
            l.addAnnots(Arrays.asList(annots));
        }
        if (l.negated()) {
            if ((l.getFunctor().equals("thing") || l.getFunctor().equals("nothing")) || // special case: reject ~thing and ~nothing
                    (l.getArity() == 2) || //special case: reject negated property assertions
                    (l.getFunctor().equals(JASDLParams.OWL_ALL_DIFFERENT_FUNCTOR.getFunctor())) // special case: reject ~all_different assertions
            ) {
                throw new JASDLInvalidSELiteralException(l + " is invalid");
            }
        }
        return construct(l);
    }

    /**
     * Convenience method for specifically creating unary SE-Literals corresponding to <code>OWLClassAssertionAxiom</code>s with a single, atomic term.
     * @param functor and label correspond to an alias and in turn an OWLClass
     * @see SELiteralFactory#construct(boolean, Atom, Term[], Term[], Atom)
     */
    public SELiteral construct(boolean sign, Atom functor, Atom individual, Term[] annots, Atom label) throws JASDLInvalidSELiteralException {
        return construct(sign, functor, new Term[] { individual }, annots, label);
    }

    /**
     * Convenience method for specifically creating binary SE-Literals corresponding to <code>OWLPropertyAssertionAxiom</code>s (object or data) with a subject and object.
     * @param functor and label correspond to an alias and in turn an OWLProperty
     * @see SELiteralFactory#construct(boolean, Atom, Term[], Term[], Atom)
     */
    public SELiteral construct(boolean sign, Atom functor, Atom subject, Term object, Term[] annots, Atom label) throws JASDLInvalidSELiteralException {
        return construct(sign, functor, new Term[] { subject, object }, annots, label);
    }

    /**
     * Convenience method for specifically SE-Literals with a single list term corresponding to <code>OWLDifferentIndividualsAssertionAxiom</code>s with a set of individuals.
     * Functor is set of all_different.
     * @see SELiteralFactory#construct(boolean, Atom, Term[], Term[], Atom)
     */
    public SELiteral construct(boolean sign, Atom[] _is, Term[] annots, Atom label) throws JASDLInvalidSELiteralException {
        ListTerm is = new ListTermImpl();// TODO: override this object's unify method to perform set, not list, unification + equality? 
        for (Atom i : _is) {
            is.add(i);
        }
        return construct(sign, JASDLParams.OWL_ALL_DIFFERENT_FUNCTOR, new Term[] { is }, annots, label);
    }

    /**
     * Utility method to construct an SE-Literal from an alias, a list of terms and a list of (non-JASDL) annotations.
     * functor, negation (based on presence of "~" prefix) and ontology annotation set based on alias.
     * Results in a SELiteral with no arguments.
     * @param alias     the alias from which to construct this SELiteral
     * @return          an SELiteral corresponding to alias with no arguments
     * @see Alias
     */
    public SELiteral construct(Alias alias, Term[] terms, Term[] annots) throws JASDLInvalidSELiteralException {
        // construct a new literal (with no terms) based on alias
        boolean sign = true;
        String functor = alias.getFunctor().toString();
        //~ might be present
        if (functor.startsWith("~")) {
            functor = functor.substring(1);
            sign = false;
        }
        return construct(sign, new Atom(functor), terms, annots, alias.getLabel());
    }

    /**
     * Convenience method for specifically creating unary SE-Literals corresponding to <code>OWLClassAssertionAxiom</code>s with a single, atomic term.
     * @param alias corresponds to an OWLClass
     * @see SELiteralFactory#construct(Alias, Term[], Term[])
     */
    public SELiteral construct(Alias alias, Atom individual, Term[] annots) throws JASDLInvalidSELiteralException {
        return construct(alias, new Term[] { individual }, annots);
    }

    /**
     * Convenience method for specifically creating binary SE-Literals corresponding to <code>OWLPropertyAssertionAxiom</code>s (object or data) with a subject and object.
     * @param alias corresponds to an OWLProperty
     * @see SELiteralFactory#construct(Alias, Term[], Term[])
     */
    public SELiteral construct(Alias alias, Atom subject, Term object, Term[] annots) throws JASDLInvalidSELiteralException {
        return construct(alias, new Term[] { subject, object }, annots);
    }

    /** 
     * Convenience method for specifically SE-Literals with a single list term corresponding to <code>OWLDifferentIndividualsAssertionAxiom</code>s with a set of individuals.
     * @see SELiteralFactory#construct(Alias, Term[], Term[])
     */
    public SELiteral construct(Alias alias, Atom[] _is, Term[] annots) throws JASDLInvalidSELiteralException {
        ListTerm is = new ListTermImpl();// TODO: override this object's unify method to perform set, not list, unification + equality? 
        for (Atom i : _is) {
            is.add(i);
        }
        return construct(alias, new Term[] { is }, annots);
    }
}
