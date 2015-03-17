package jason.asSyntax;

import java.io.Serializable;

/**
 * Represents the "type" of a predicate based on the functor and the arity, e.g.: ask/4
 * 
 * @author jomi
 */
public final class PredicateIndicator implements Comparable<PredicateIndicator>, Serializable {

    private final String functor;
    private final int    arity;
    private final int    hash;
    
    public PredicateIndicator(String functor, int arity) {
        this.functor = functor;
        this.arity   = arity;
        hash         = calcHash();
    }
    public PredicateIndicator(String prefix, PredicateIndicator pi) {
        this.functor = prefix + pi.functor;
        this.arity   = pi.arity;
        hash         = calcHash();
    }

    public String getFunctor() {
        return functor;
    }
    
    public int getArity() {
        return arity;
    }
        
    @Override
    public boolean equals(Object o) {
        if (o == this) return true;
        if (o != null && o instanceof PredicateIndicator && o.hashCode() == this.hashCode()) {
            final PredicateIndicator pi = (PredicateIndicator)o;
            return arity == pi.arity && functor.equals(pi.functor);
        } 
        return false;
    }

    @Override
    public int hashCode() {
        return hash;
    }
    
    @Override
    public int compareTo(PredicateIndicator pi) {
        int c = this.functor.compareTo(pi.functor);
        if (c != 0) return c;
        if (pi.arity > this.arity) return -1;
        if (this.arity > pi.arity) return 1;
        return 0;
    }
    
    private int calcHash() {
        int t  = 31 * arity;
        if (functor != null) t = 31 * t + functor.hashCode();
        return t;
    }
      
    public String toString() {
        return functor + "/" + arity;
    }
}
