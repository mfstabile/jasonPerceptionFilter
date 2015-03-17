package jmoise;

import jason.asSemantics.TransitionSystem;
import jason.asSemantics.Unifier;
import jason.asSyntax.Term;

/** 

<p>Organisational action: <b><code>jmoise.remove_group( GrId )</code></b>: 
   used by an agent to remove a group. 
   GrId is the identification of the group instance.
   
<p>Conditions to succeed:
<ul>
<li>the agent performing the action is the owner of the group;</li>
<li>the group has no players;</li>
<li>the group has no sub-groups.</li>
</ul>

<p>Examples:
<ul>
<li> <code>jmoise.remove_group(team0)</code>: 
     removes the group identified by team0 form the organisational entity.</li>
</ul>
 
@see jmoise.create_group
@see jmoise.adopt_role
@see jmoise.remove_role
@see jmoise.add_responsible_group
@see <a href="http://moise.sourceforge.net/doc/tutorial.pdf">Moise+ Tutorial, chapter for J-Moise+</a> 
 
@author Jomi 

*/
public class remove_group extends MoiseBaseIA {

    @Override
    public Object execute(TransitionSystem ts, Unifier un, Term[] args) throws Exception {
        return super.execute(ts,un,args);
    }
}
