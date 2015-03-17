package jmoise;

import jason.JasonException;
import jason.asSemantics.DefaultInternalAction;
import jason.asSemantics.Message;
import jason.asSemantics.TransitionSystem;
import jason.asSemantics.Unifier;
import jason.asSyntax.Term;
import moise.oe.GroupInstance;
import moise.oe.OEAgent;
import moise.oe.SchemeInstance;

/** 

<p>Organisational action: <b><code>jmoise.broadcast(GrId/SchId, P, C)</code></b>: 
   broadcast a message with content C and performative P to all
   agents of a group or scheme.

<p>Examples:
<ul>
<li> <code>jmoise.broadcast(wpgroup_0, tell, vl(10))</code>: tell "vl(10)" to
     all agents of group wp_group_0.</li>
<li> <code>jmoise.broadcast(sch_wpPaper_0, tell, vl(10))</code>: tell "vl(10)" to
     all agents of scheme sch_wpPaper_0.</li>
</ul>
 
 
@author Jomi 

*/
public class broadcast extends DefaultInternalAction {

    @Override
    public Object execute(TransitionSystem ts, Unifier un, Term[] args) throws Exception {
        Term target = null;
        Term ilf = null;
        Term pcnt = null;

        try {
            target = args[0];
            if (!target.isAtom())
                throw new JasonException("The target (group or scheme) parameter ('"+target+"') of the internal action 'jmoise.broadcast' is not an atom!");
            
            ilf = args[1];
            if (!ilf.isAtom())
                throw new JasonException("The illocutionary force parameter of the internal action 'jmoise.broadcast' is not an atom!");

            pcnt = args[2];
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new JasonException("The internal action 'jmoise.broadcast' has not received three arguments.");
        }
        
        

        try {
            OrgAgent oag = (OrgAgent)ts.getUserAgArch();

            // try group
            GroupInstance gi = oag.getOE().findGroup(target.toString());
            if (gi != null) {
                for (OEAgent ag: gi.getAgents(true)) {
                    if (!ag.getId().equals(oag.getAgName()) && !oag.getAgName().startsWith("someone")) {
                        oag.sendMsg(new Message(ilf.toString(), null, ag.getId(), pcnt));
                    }
                }
            } else {
                // try scheme
                SchemeInstance sch = oag.getOE().findScheme(target.toString());
                if (sch != null) {
                    for (OEAgent ag: sch.getAgents()) {
                        if (!ag.getId().equals(oag.getAgName()) && !oag.getAgName().startsWith("someone")) {
                            oag.sendMsg(new Message(ilf.toString(), null, ag.getId(), pcnt));
                        }
                    }                    
                } else {
                    throw new JasonException("The target (group or scheme) parameter ('"+target+"') of the internal action 'jmoise.broadcast' is not a known group or scheme!");
                }
            }
            return true;
        } catch (JasonException e) {
            throw e;
        } catch (Exception e) {
            throw new JasonException("Error broadcasting message " + pcnt, e);
        }
    }
}
