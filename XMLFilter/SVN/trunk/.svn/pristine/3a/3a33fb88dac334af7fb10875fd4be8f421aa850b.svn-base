/* Beliefs */

refs([boissier04,sichman03]). // refs used in the paper

// I want to play "writer" in "wpgroups"
desired_role(wpgroup,writer).

// I want to commit to "mColaborator" and "mBib" missions
// in "writePaperSch" schemes
desired_mission(writePaperSch,mColaborator).
desired_mission(writePaperSch,mBib).



// include common plans for MOISE+ agents
{ include("moise-common.asl") }

/* Organisational Goals' plans */

// a generic plan for organisational goals (they have scheme(_) annotation)
+!X[scheme(Sch)] : true 
   <- .print("Doing organisational goal ",X, " in scheme ",Sch);
      jmoise.set_goal_state(Sch,X,satisfied).

// when I receive a tell message from S and
// S plays writer in a scheme, change the belief of
// used refs
+use_ref(NewRef)[source(S)] 
   :  play(S, writer, _) & refs(R)
   <- .print("adding ref ",NewRef, " to ", R);
      -refs(R); +refs([NewRef|R]).
      
+play(Me,R,GrInst)
   : .my_name(Me) & group(GrSpec,GrInst)
  <- jmoise.group_specification(GrSpec,Roles);
     .member(role(R,Min,Max,Compat,Links),Roles);
     .print("I am starting playing ",R);
     .print(" -- cardinality of my role (Min,Max): (",Min,",",Max,")");
     .print(" -- roles compatible with mine: ", Compat);
     .print(" -- all roles of the group are ",Roles).
     

      
