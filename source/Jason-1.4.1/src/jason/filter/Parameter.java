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
public class Parameter {

    private int index;
    private String value;
    private Operator operator;

    public Parameter(int index, String value, Operator operator) {
        this.index = index;
        this.value = value;
        this.operator = operator;
    }

    public Parameter() {
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

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }
}
