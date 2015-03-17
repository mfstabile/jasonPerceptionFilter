package net.sourceforge.jasonide.editors.cbg.rules;

import net.sourceforge.jasonide.editors.cbg.jedit.Rule;
import net.sourceforge.jasonide.editors.cbg.jedit.Type;

public class DelegateToken extends CToken {
    protected Rule delegate;
    protected String end;
    protected boolean consumed; 
    public DelegateToken(Type type, Rule delegate, String end) {
        super(type);
        this.delegate = delegate;
        this.end = end;
        consumed = false;
    }
    public Object getData() {
        return delegate.getName() + super.getData();
    }

    public String getEnd() {
        return end;
    }
}
