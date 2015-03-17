// this agent waits for the group creation and then
// adopts the role write and
// commits to the missions mColaborator and mBib

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
+!wsecs <- .print("writing sections...").
+!wrefs <- .print("organising bibliography...").

+goal_state(Scheme,wsecs,_,_,satisfied)
    : .my_name(Me) & commitment(Me,mColaborator,Scheme)
   <- .print("sections are ok, leaving my mission....");
      leave_mission(mColaborator,Scheme).
+goal_state(Scheme,wrefs,_,_,satisfied)
    : .my_name(Me) & commitment(Me,mBib,Scheme)
   <- .print("references are ok, leaving my mission....");
      leave_mission(mBib,Scheme).

// plans to react to normative events like obligation created

+obligation(Ag,Norm,committed(Ag,Mission,Scheme),DeadLine)
    : .my_name(Ag)
   <- .print("I am obliged to commit to ",Mission);
      commit_mission(Mission,Scheme).
      
+obligation(Ag,Norm,achieved(Scheme,Goal,Ag),DeadLine)
    : .my_name(Ag)
   <- .print("I am obliged to achieve goal ",Goal);
      !Goal;
      goal_achieved(Goal,Scheme).
      
+obligation(Ag,Norm,What,DeadLine)  
   : .my_name(Ag)
   <- .print("I am obliged to ",What,", but I don't know what to do!").

