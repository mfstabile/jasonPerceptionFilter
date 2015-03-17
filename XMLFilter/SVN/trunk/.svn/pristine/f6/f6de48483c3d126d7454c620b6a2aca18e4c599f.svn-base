package jmoise;

import jason.asSemantics.DefaultInternalAction;
import jason.asSemantics.Intention;
import jason.asSemantics.Message;
import jason.asSemantics.TransitionSystem;
import jason.asSemantics.Unifier;
import jason.asSyntax.Structure;
import jason.asSyntax.Term;

import java.util.logging.Level;
import java.util.logging.Logger;


/**
 * Common base code for all JMoise+ internal actions.
 * 
 * @author hubner
 */
public abstract class MoiseBaseIA extends DefaultInternalAction  {

    private static Logger logger = Logger.getLogger(MoiseBaseIA.class.getName());

    /** executes the jmoise internal actions by communication with OrgManager */
    @Override
    public Object execute(TransitionSystem ts, Unifier un, Term[] args) throws Exception {
        String    acName = this.getClass().getSimpleName(); // remove the package name "jmoise"
        Structure acTerm = new Structure(acName);
        acTerm.addTerms(args);
        // remove the last arg if unground (the return of the IA)
        if (!acTerm.getTerm(args.length-1).isGround()) {
            acTerm.delTerm(args.length-1);
        }
        if (logger.isLoggable(Level.FINE)) logger.fine("sending: "+acTerm);
        
        // send acTerm as message to OrgManager
        OrgAgent oag = (OrgAgent)ts.getUserAgArch();
        Message m = new Message("achieve", null, oag.getOrgManagerName(), acTerm);
        oag.sendMsg(m);
        
        if (suspendIntention()) {
            Intention i = ts.getC().getSelectedIntention();
            i.setSuspended(true);
            ts.getC().addPendingIntention("om/"+m.getMsgId(), i);
        }
        return true;
    }
    
    @Override
    public boolean suspendIntention() {
        return true;
    }
    
}
