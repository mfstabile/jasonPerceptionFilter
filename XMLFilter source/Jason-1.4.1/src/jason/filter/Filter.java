/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jason.filter;

import java.util.LinkedList;

/**
 *
 * @author Márcio F. Stabile Jr.
 */
public class Filter {

    private String predicate;
    private LinkedList<Parameter> parameters;
    private LinkedList<Annotation> anotations;

    public String getPredicate() {
        return predicate;
    }

    public void setPredicate(String predicate) {
        this.predicate = predicate;
    }

    public LinkedList<Parameter> getParameters() {
        return parameters;
    }

    public void setParameters(LinkedList<Parameter> parameters) {
        this.parameters = parameters;
    }

    public LinkedList<Annotation> getAnotations() {
        return anotations;
    }

    public void setAnotations(LinkedList<Annotation> anotations) {
        this.anotations = anotations;
    }

    public void addParameter(Parameter p) {
        parameters.add(p);
    }
    
    public void addAnotation(Annotation a){
        anotations.add(a);
    }

    public Filter() {
        parameters = new LinkedList<Parameter>();
        anotations = new LinkedList<Annotation>();
    }

}
