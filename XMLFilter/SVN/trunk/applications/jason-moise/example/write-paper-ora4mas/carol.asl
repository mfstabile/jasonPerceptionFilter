// this agent waits for the group creation and then
// adopts the role write and
// commits to the mission mColaborator

/* Initial goals */

!start.
!join.

/* Plans */

+!start 
  <- lookup_artifact("mypaper",_); 
     adopt_role(writer,mypaper).
-!start
  <- .wait(100);
     !start.
     
+!join <- .my_name(Me); join_workspace(ora4mas,"",user_id(Me)).
         
// application domain goals
+!wsecs[scheme(S)]
   <- .print("writing sections for scheme ",S,"...").

// when my goal in the scheme is satisfied, leave my mission 
+goal_state(Scheme,wsecs,_,_,satisfied)
    : .my_name(Me) & commitment(Me,mColaborator,Scheme)
   <- .print("sections are ok, leaving my mission....");
      !quit(Scheme).
      
+!quit(Scheme)       
   <- leave_mission(mColaborator,Scheme);
      .print("I succeeded leaving ", Scheme).
-!quit(Scheme)[error_msg(M)]
   <- .print("Error leaving mission ", M).

// plans to react to normative events like obligation created

+obligation(Ag,Norm,committed(Ag,mColaborator,Scheme),DeadLine)
    : .my_name(Ag)
   <- .print("I am obliged to commit to the scheme as a colaborator, so doing that...");
      commit_mission(mColaborator,Scheme).
      
+obligation(Ag,Norm,achieved(Scheme,Goal,Ag),DeadLine)
    : .my_name(Ag)
   <- .print("I am obliged to achieve goal ",Goal);
      !Goal[scheme(Scheme)];
      goal_achieved(Goal,Scheme).
      
+obligation(Ag,Norm,What,DeadLine)  
   : .my_name(Ag)
   <- .print("I am obliged to ",What,", but I don't know what to do!").

// signals
+norm_failure(N) <- .print("norm failure event: ", N).
   
