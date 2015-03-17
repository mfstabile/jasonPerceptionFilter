package jmoise;

import jason.asSemantics.TransitionSystem;
import jason.asSemantics.Unifier;
import jason.asSyntax.Term;

/** 

<p>Organisational action: <b><code>jmoise.abort_scheme( SchId )</code></b>: 
   used by an agent to abort the execution of a scheme. 
   SchId is the identification of the scheme instance.
   This organisational action does not require that no agent is committed to 
   the scheme, as does .jmoise.remove_scheme.
   
<p>Conditions to succeed:
<ul>
<li>the agent performing the action is the owner of the scheme;</li>
</ul>

<p>Consequences:
<ul>
<li>there is no more responsible groups for the scheme;</li>
<li>the agents of the scheme are no more obligated to achieve the scheme's goals.</li>
</ul>

<p>Examples:
<ul>
<li> <code>jmoise.abort_scheme(wp0)</code>: 
     removes the scheme identified by wp0 form the organisational entity.</li>
</ul>
 
@see jmoise.create_scheme 
@see jmoise.commit_mission
@see jmoise.remove_mission
@see jmoise.set_goal_arg
@see jmoise.set_goal_state
@see jmoise.add_responsible_group
@see jmoise.remove_scheme
@see <a href="http://moise.sourceforge.net/doc/tutorial.pdf">Moise+ Tutorial, chapter for J-Moise+</a> 
 
@author Jomi 

*/
public class abort_scheme extends MoiseBaseIA {

    @Override
    public Object execute(TransitionSystem ts, Unifier un, Term[] args) throws Exception {
    	return super.execute(ts,un,args);
    }
}
