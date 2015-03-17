package jmoise;

import jason.asSemantics.TransitionSystem;
import jason.asSemantics.Unifier;
import jason.asSyntax.Term;

/** 

<p>Organisational action: <b><code>jmoise.create_scheme( [sch_name(SchId), ] SchSpecId [, ListOfRespGrs] [, newSchId] )</code></b>: 
   used by an agent to create a new scheme. 
   The first optional parameter is the name of the new scheme.
   The third optional parameter is a list of initial responsible groups.
   SchSpecId is the name of the scheme specification and
   ListOfRespGrs is a list of group's identifications.
   
<p>Consequences:
<ul>
<li>the agent that performs the creation becomes the owner of the scheme;</li>
<li>see consequences of {@link jmoise.add_responsible_group add responsible group}.</li>
</ul>

<p>Examples:
<ul>
<li> <code>jmoise.create_scheme(wp)</code>: 
     creates new scheme based on specification wp.</li>
<li> <code>jmoise.create_scheme(sch_name(s1), wp)</code>: 
     creates new scheme identified by s1 based on specification wp.</li>
<li> <code>jmoise.create_scheme(wp, [g1, g2])</code>: 
     creates new scheme based on specification wp and set g1 and g2 as responsible
     groups.</li>
<li> <code>jmoise.create_scheme(wp, [g1, g2], S)</code>: 
     creates new scheme based on specification wp and set g1 and g2 as responsible
     groups. The identification of the new scheme will be unified with S.</li>
</ul>
 
@see jmoise.remove_scheme 
@see jmoise.commit_mission
@see jmoise.remove_mission
@see jmoise.set_goal_arg
@see jmoise.set_goal_state
@see jmoise.add_responsible_group
@see <a href="http://moise.sourceforge.net/doc/tutorial.pdf">Moise+ Tutorial, chapter for J-Moise+</a> 
 
@author Jomi 
*/
public class create_scheme extends MoiseBaseIA {

    @Override
    public Object execute(TransitionSystem ts, Unifier un, Term[] args) throws Exception {
    	return super.execute(ts,un,args);
    }
}
