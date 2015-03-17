package jmoise;

import jason.asSemantics.TransitionSystem;
import jason.asSemantics.Unifier;
import jason.asSyntax.Term;

/** 

<p>Organisational action: <b><code>jmoise.adopt_role(RoleId, GrId)</code></b>: 
   used by an agent to adopt the role RoleId in the group GrId. RoleId is the 
   name of the role in the specification and GrId is the identification of a
   group instance.

<p>Conditions to succeed:
<ul>
<li>the RoleId must belong to the specification of GrId;</li>
<li>the number of RoleId players in GrId must be lesser than the
  maximum number of RoleId players defined in the GrId compositional
  specification  (i.e., cardinality check);</li>
<li>for all roles r that the agent already plays, the roles
  r and RoleId must be intra-group compatible in the GrId 
  specification;</li>  
<li>for all roles r that the agent already plays in groups
  other than GrId, the roles r and RoleId must be inter-group
  compatible.</li>
</ul>

<p>Consequences:
<ul>
<li>status of the GrId may become "well-formed";</li>
<li>the agent receives all information of the group (related schemes, players, ...);</li>
<li>the agent receives its obligations/permissions.</li>
</ul>

<p>Examples:
<ul>
<li> <code>jmoise.adopt_role(writer,wpgroup_0)</code>: adopts the role writer in the
group wpgroup_0.</li>
</ul>
 
@see jmoise.remove_role
@see <a href="http://moise.sourceforge.net/doc/tutorial.pdf">Moise+ Tutorial, chapter for J-Moise+</a> 
 
@author Jomi 

*/
public class adopt_role extends MoiseBaseIA {

    @Override
    public Object execute(TransitionSystem ts, Unifier un, Term[] args) throws Exception {
        return super.execute(ts,un,args);
    }    
}
