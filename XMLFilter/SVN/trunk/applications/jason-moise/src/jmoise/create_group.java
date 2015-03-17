package jmoise;

import jason.asSemantics.TransitionSystem;
import jason.asSemantics.Unifier;
import jason.asSyntax.Term;

/** 

<p>Organisational action: <b><code>jmoise.create_group( [gr_name(GrName),] GrSpecId [,
   SuperGrId] [, newGroupId] )</code></b>: used by an agent to create
   a new group instance based on GrSpecId specification. If the first parameter
   is a structure with functor gr_name, the term of this structure will be
   the name of the new group.  GrSpecId is the name
   of the group in the structural specification, and SuperGrId is the
   identification of the super group instance. The SuperGrId parameter is
   used in case a sub-group is being created. If the last argument is
   a variable, it unifies with the unique identification given to the
   new group.
   
<p>Conditions to succeed (just in case of creation of sub-groups):
<ul>
<li>the group GrSpecId must be a sub-group of the SuperGrId's type in the specification;</li>
<li>the number of GrSpecId sub-groups of SuperGrId must be lesser than the
  maximum number of GrSpecId sub-groups defined in the SuperGrId compositional
  specification (i.e., cardinality check).</li>
</ul>

<p>Consequences:
<ul>
<li>the agent that performs the creation becomes the owner of the group.</li>
</ul>

<p>Examples:
<ul>
<li> <code>jmoise.create_group(team)</code>: 
     creates a new root group based on specification of a team.</li>
<li> <code>jmoise.create_group(gr_name(g1), team)</code>: 
     creates a new root group named g1 based on specification of a team.</li>
<li> <code>jmoise.create_group(team,G)</code>: 
     creates a new root group based on specification of a team and unifies in G the identification of the new group.</li>
<li> <code>jmoise.create_group(defence, team0)</code>: 
     creates a sub-group of group team0 based on specification defence.</li>
<li> <code>jmoise.create_group(defence, team0, G)</code>: 
     creates a sub-group of group team0 based on specification defence and unifies in G the identification of the new group.</li>
</ul>
 
@see jmoise.remove_group
@see jmoise.adopt_role
@see jmoise.remove_role
@see jmoise.add_responsible_group
@see <a href="http://moise.sourceforge.net/doc/tutorial.pdf">Moise+ Tutorial, chapter for J-Moise+</a> 
 
@author Jomi 

*/
public class create_group extends MoiseBaseIA {

    @Override
    public Object execute(TransitionSystem ts, Unifier un, Term[] args) throws Exception {
       return super.execute(ts,un,args);
    }    
}
