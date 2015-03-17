package jmoise;

import jason.asSemantics.TransitionSystem;
import jason.asSemantics.Unifier;
import jason.asSyntax.Term;

/** 

<p>Organisational action: <b><code>jmoise.remove_role(RoleId, GrId)</code></b>: 
   used by an agent to give up the role RoleId in the group GrId. RoleId is the 
   name of the role in the specification and GrId is the identification of a
   group instance.

<p>Conditions to succeed:
<ul>
<li>the agent is playing the RoleId in GrId;</li>
<li>the agent has no committed mission assigned to this role. Note that this requirement is for
    removing the role in an expected way, of course, the agent can stop pursuing the organisational
    goals when it wants since it is autonomous.
</li>
</ul>


<p>Consequences:
<ul>
<li>the GrId may loose the status "well-formed";</li>
<li>the agent stops receiving informations related to the group.</li>
</ul>

<p>Examples:
<ul>
<li> <code>jmoise.remove_role(writer,wpgroup_0)</code>: gives the role writer up in the
group wpgroup_0.</li>
</ul>
 
@see jmoise.adopt_role
@see <a href="http://moise.sourceforge.net/doc/tutorial.pdf">Moise+ Tutorial, chapter for J-Moise+</a> 
 
@author Jomi 

*/
public class remove_role extends MoiseBaseIA {

    @Override
    public Object execute(TransitionSystem ts, Unifier un, Term[] args) throws Exception {
        return super.execute(ts,un,args);
    }
}
