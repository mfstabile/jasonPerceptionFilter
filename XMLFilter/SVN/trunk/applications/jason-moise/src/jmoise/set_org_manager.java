package jmoise;

import jason.asSemantics.DefaultInternalAction;
import jason.asSemantics.TransitionSystem;
import jason.asSemantics.Unifier;
import jason.asSyntax.Term;

import java.util.logging.Level;
import java.util.logging.Logger;

/** Changes the name of the OrgManager agent, the default name is "orgManager" */
public class set_org_manager extends DefaultInternalAction {

    private static Logger logger = Logger.getLogger(set_org_manager.class.getName());

    @Override
    public Object execute(TransitionSystem ts, Unifier un, Term[] args) throws Exception {
        try {
            OrgAgent oag = (OrgAgent)ts.getUserAgArch();
            oag.setOrgManagerName(args[0].toString());
            return true;
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Error in set_org_manager.",e);
        }
        return false;
    }
}
