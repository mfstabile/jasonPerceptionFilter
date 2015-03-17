package net.sourceforge.jasonide.editors.cbg.rules;

import net.sourceforge.jasonide.editors.cbg.jedit.Type;

import org.eclipse.jface.text.rules.Token;

public class CToken extends Token {
    protected Type type;
    
    public CToken(Type type) {
        super(type.getType());
        this.type = type;
    }

    public String getColor() {
        return type.getColor();
    }

    public Object getData() {
        return type.getContentType();
    }
}
