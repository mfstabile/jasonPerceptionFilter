package gui;

import jason.asSemantics.DefaultInternalAction;
import jason.asSemantics.TransitionSystem;
import jason.asSemantics.Unifier;
import jason.asSyntax.Term;

public class list_bels extends DefaultInternalAction {

    @Override
    public Object execute(TransitionSystem ts, Unifier un, Term[] args) throws Exception {
        OrgAgentGUI arch = (OrgAgentGUI)ts.getUserAgArch();
        arch.listBels();
        arch.listGoals();
        return true;
    }
}
