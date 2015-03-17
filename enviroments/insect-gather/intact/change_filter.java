// Internal action code for project mars.mas2j

package intact;

import jason.*;
import jason.asSemantics.*;
import jason.asSyntax.*;

public class change_filter extends DefaultInternalAction {

    @Override
    public Object execute(TransitionSystem ts, Unifier un, Term[] args) throws Exception {
        String tag = args[0].toString();
        ts.getAg().changeFilter(tag);        
        return true;
    }
}

