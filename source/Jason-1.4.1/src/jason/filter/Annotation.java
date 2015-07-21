/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jason.filter;

/**
 *
 * @author Márcio F. Stabile Jr.
 */
public class Annotation {

    private String predicate;
    private String value;
    private Operator operator;

    public Annotation(String predicate, String value, Operator operator) {
        this.predicate = predicate;
        this.value = value;
        this.operator = operator;
    }

    public Annotation() {
    }

    public Operator getOperator() {
        return operator;
    }

    public void setOperator(Operator operator) {
        this.operator = operator;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getPredicate() {
        return predicate;
    }

    public void setPredicate(String predicate) {
        this.predicate = predicate;
    }
}
