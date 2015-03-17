package jmoise;

import jason.asSemantics.TransitionSystem;
import jason.asSemantics.Unifier;
import jason.asSyntax.Term;

/** 

<p>Organisational action: <b><code>jmoise.set_goal_state( SchId, GoalId, State)</code></b>: 
   used by an agent to inform the organisation that some goal becomes satisfied (State=satisfied)
   of impossible (State=impossible). 
   GoalId is the name of the goal in the specification,
   SchId is the identification of a scheme instance, and
   State is either satisfied or impossible.

<p>Conditions to succeed:
<ul>
<li>the agent is committed to a mission that contains the GoalId;</li>
<li>the goal is possible (see the tutorial/doc for a definition of possible goal).</li>
</ul>

<p>Consequences:
<ul>
<li>other goals becomes possible.</li>
</ul>

<p>Examples:
<ul>
<li> <code>jmoise.set_goal_state(wp_0, wsecs, satisfied)</code>: 
     set the goal wsec as satisfied in the scheme wp_0.</li>
<li> <code>jmoise.set_goal_state(wp_0, wsecs, impossible)</code>: 
     set the goal wsec as impossible in the scheme wp_0.</li>
</ul>
 
@see jmoise.commit_mission
@see jmoise.remove_mission
@see jmoise.set_goal_arg
@see <a href="http://moise.sourceforge.net/doc/tutorial.pdf">Moise+ Tutorial, chapter for J-Moise+</a> 
 
@author Jomi 

*/
public class set_goal_state extends MoiseBaseIA {

    @Override
    public Object execute(TransitionSystem ts, Unifier un, Term[] args) throws Exception {
        return super.execute(ts,un,args);
    }
}
