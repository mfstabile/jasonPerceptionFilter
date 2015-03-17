package jmoise;

import jason.asSemantics.TransitionSystem;
import jason.asSemantics.Unifier;
import jason.asSyntax.Term;

/** 

<p>Organisational action: <b><code>jmoise.commit_mission(MissionId, SchId)</code></b>: 
   used by an agent to commit to the mission MissionId in the scheme instance SchId. 
   MissionId is the 
   name of the mission in the specification and SchId is the identification of a
   scheme instance.

<p>Conditions to succeed:
<ul>
<li>the MissionId must belong to the specification of SchId;</li>
<li>the number of MissionId players in SchId must be lesser than the
    maximum number of MissionId players defined in the SchId compositional
    specification  (i.e., cardinality check);</li>
<li>the SchId is not finished;</li>
<li>the agent plays a role in a SchId's responsible group that permits or obliges it 
    to commit to the mission (this 
    permission/obligation is specified in the deontic specification).</li>
</ul>

<p>Consequences:
<ul>
<li>status of the SchId may become "well-formed";</li>
<li>the agent receives all information of the scheme (responsible groups, players, goal state, ...).</li>
</ul>

<p>Examples:
<ul>
<li> <code>jmoise.commit_mission(manager,wp_0)</code>: commits to the mission manager in the
scheme wp_0.</li>
</ul>
 
@see jmoise.remove_mission
@see jmoise.set_goal_state
@see jmoise.set_goal_arg
@see <a href="http://moise.sourceforge.net/doc/tutorial.pdf">Moise+ Tutorial, chapter for J-Moise+</a> 
 
@author Jomi 

*/
public class commit_mission extends MoiseBaseIA {

    @Override
    public Object execute(TransitionSystem ts, Unifier un, Term[] args) throws Exception {
    	return super.execute(ts,un,args);
    }
}
