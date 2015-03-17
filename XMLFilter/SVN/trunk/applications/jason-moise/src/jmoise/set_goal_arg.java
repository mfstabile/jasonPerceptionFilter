package jmoise;

import jason.asSemantics.TransitionSystem;
import jason.asSemantics.Unifier;
import jason.asSyntax.Term;

/** 

<p>Organisational action: <b><code>jmoise.set_goal_arg( SchId, GoalId, ArgId, Value)</code></b>: 
   used by an agent to set the value of a goal's argument. 
   GoalId is the name of the goal in the specification,
   SchId is the identification of a scheme instance, 
   ArgId is the name of the argument, and
   Value the new value of the argument.

<p>In the scheme specification, goals with arguments can be defined by means of the "argument" element. The
auction example (file auction-os.xml) uses goals with arguments.

<p>Conditions to succeed:
<ul>
<li>the agent is committed to a mission that contains the GoalId;</li>
<li>the goal has an argument identified by ArgId.</li>
</ul>

<p>Examples:
<ul>
<li> <code>jmoise.set_goal_arg(wp_0, g1, "X", 10)</code>: 
     set the argument X of goal g1 as 10.</li>
<li> <code>jmoise.set_goal_arg(wp_0, g1, "X", "some thing")</code>: 
     set the argument X of goal g1 as "some thing".</li>
</ul>
 
@see jmoise.commit_mission
@see jmoise.remove_mission
@see jmoise.set_goal_state
@see <a href="http://moise.sourceforge.net/doc/tutorial.pdf">Moise+ Tutorial, chapter for J-Moise+</a> 
 
@author Jomi 

*/
public class set_goal_arg extends MoiseBaseIA {

    @Override
    public Object execute(TransitionSystem ts, Unifier un, Term[] args) throws Exception {
    	return super.execute(ts,un,args);
    }
}
