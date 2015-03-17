// Common plans for organised agents based on MOISE+ model.
//
// These plans use the beliefs:
//     . desired_role(<GrSpec>,<Role>) and
//     . desired_mission(<SchSpec>,<Mission>).

/* 
   Organisational Events
   ---------------------
*/

/* Structural events */
// when a group is created and I desire to play in it,
// adopts a role  
+group(GrSpec,Id) 
   :  desired_role(GrSpec,Role)
   <- jmoise.adopt_role(Role,Id).

   
/* Functional events */

// finish the scheme if it has no more players
// and it was created by me
/*
+sch_players(Sch,0) 
   :  .my_name(Me) & scheme(_, Sch)[owner(Me)]
   <- jmoise.remove_scheme(Sch).
*/
   
/* Deontic events */

// when I have an obligation or permission to a mission 
// and I desire it, commit
+obligation(Sch, Mission) 
   :  scheme(SchSpec,Sch) & desired_mission(SchSpec, Mission)
   <- jmoise.commit_mission(Mission,Sch).
+permission(Sch, Mission)
   :  scheme(SchSpec,Sch) & desired_mission(SchSpec, Mission)
   <- jmoise.commit_mission(Mission,Sch).

// when the root goal of the scheme is achieved, 
// remove my missions and the scheme
+goal_state(Sch, _[root], achieved) 
   <- jmoise.remove_mission(Sch);
      .my_name(Me);
      if (scheme(_,Sch)[owner(Me)]) {
         if (not sch_players(Sch,0)) {
            .wait( { +sch_players(Sch,0)} , 1000, _)
         };
         jmoise.remove_scheme(Sch)
      }.

// if some scheme is finished, drop all intentions related to it.
-scheme(_Spec,Id)
   <- .drop_desire(_[scheme(Id)]).

+error(M)[source(orgManager)] 
   <- .print("Error in organisational action: ",M); -error(M)[source(orgManager)].
   
