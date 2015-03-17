package jmoise;

import jason.asSyntax.Pred;
import moise.common.MoiseException;
import moise.oe.OE;
import moise.oe.OEAgent;

/** 
 * Interface for commands executed by OrgManager (like adopt_role, create_group, ...).
 * The code that executes these commands must implement this interface.
 *
 * @author jomi
 */
public interface OrgManagerCommand {
    public String getId();
    public void process(OE currentOE, Pred command, OEAgent sender, String mId) throws MoiseException;
}
