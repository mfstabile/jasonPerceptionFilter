package jmoise;

import jason.JasonException;
import jason.asSemantics.DefaultInternalAction;
import jason.asSemantics.TransitionSystem;
import jason.asSemantics.Unifier;
import jason.asSyntax.ASSyntax;
import jason.asSyntax.StringTerm;
import jason.asSyntax.Structure;
import jason.asSyntax.Term;
import moise.os.ss.Group;


/**
 
 <p><b><code>jmoise.group_specification( GrSpecId [, Roles [, Sub-groups [, Properties ]]] )</code></b>: 
 Obtains a representation (as a term) of a group specification.
 
 Roles is a list with all roles of the group. Each role is a structure like 
 <code>role(RoleId,MinPlayers,MaxPlayers,CompatibleRoles,Links)</code>

 Example:
 
 <pre>
 +play(Me,R,GrInst)                                      // when I adopted a new role ...
   : .my_name(Me) & group(GrSpec,GrInst)
  <- jmoise.group_specification(GrSpec,Roles,SubGroups); // the group's properties are not obtained
     .member(role(R,Min,Max,Compat,Links),Roles);        // find details of my role
     .print("I am starting playing ",R," in ",GrInst);
     .print(" -- cardinality of my role (Min,Max): (",Min,",",Max,")");
     .print(" -- roles compatible with mine: ", Compat);
     .print(" -- links of my role: ",Links);
     .print(" -- all roles of the group are ",Roles);
     .print(" -- sub-groups are ",SubGroups).
 </pre>
 
 @author Jomi Hubner
*/
public class group_specification extends DefaultInternalAction  {

    @Override public int getMaxArgs() { return 4; }
    @Override public int getMinArgs() { return 1; }
    
    @Override protected void checkArguments(Term[] args) throws JasonException {
        super.checkArguments(args);
        if (!args[0].isAtom() && !args[0].isString()) 
            throw JasonException.createWrongArgument(this,"first argument must be an atom or string identifying the group specification");
    }
    
    @Override
    public Object execute(TransitionSystem ts, Unifier un, Term[] args) throws Exception {
        checkArguments(args);
        
        String grId = "";
        if (args[0].isString())
            grId = ((StringTerm)args[0]).getString();
        else
            grId = args[0].toString();
        
        OrgAgent oag = (OrgAgent)ts.getUserAgArch();
        Group g = oag.getOE().getOS().getSS().getRootGrSpec().findSubGroup(grId);
        if (g == null)
            throw new JasonException("the group with id '"+grId+"' does not exists in the OS.");
        
        Structure gstructure = ASSyntax.parseStructure(g.getAsProlog());
        
        int i = 1;
        while (i < args.length && i < gstructure.getArity()) {
            if (! un.unifies(args[i], gstructure.getTerm(i)))
                return false;
            i++;
        }
        return true;
    }   
}
