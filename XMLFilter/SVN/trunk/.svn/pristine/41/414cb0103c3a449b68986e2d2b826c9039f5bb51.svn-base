package jmoise;

import jason.asSemantics.TransitionSystem;
import jason.asSemantics.Unifier;
import jason.asSyntax.Term;

/** 

<p>Organisational action: <b><code>jmoise.remove_mission( [MissionId, ] SchId)</code></b>: 
   used by an agent to remove a commitment to a mission in the scheme instance SchId. 
   MissionId is the 
   name of the mission in the specification and SchId is the identification of a
   scheme instance.
   In case the first parameter is omitted, all missions in the scheme will be removed. 

<p>Conditions to succeed:
<ul>
<li>the agent is committed to MissionId in SchId;</li>
<li>all achievement goals of the mission are satisfied; if a super goal of a mission's goal is
    satisfied, the goal is also considered as satisfied.</li>
</ul>

<p>Consequences:
<ul>
<li>the SchId may loose the status "well-formed";</li>
<li>the agent stops receiving informations related to the scheme.</li>
</ul>

<p>Examples:
<ul>
<li> <code>jmoise.remove_mission(manager,wp_0)</code>: removes the commitment to the mission manager in the
scheme wp_0.</li>
<li> <code>jmoise.remove_mission(wp_0)</code>: removes all commitments in the scheme wp_0.</li>
</ul>
 
@see jmoise.commit_mission
@see jmoise.set_goal_state
@see jmoise.set_goal_arg
@see <a href="http://moise.sourceforge.net/doc/tutorial.pdf">Moise+ Tutorial, chapter for J-Moise+</a> 
 
@author Jomi 

*/
public class remove_mission extends MoiseBaseIA {

    @Override
    public Object execute(TransitionSystem ts, Unifier un, Term[] args) throws Exception {
    	return super.execute(ts,un,args);
    }
}
