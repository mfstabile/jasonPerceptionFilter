// common plans for participants

/* Initial goals */

!start.
!join.

/* Plans */

+!start 
   <- lookup_artifact("auction",_); 
      adopt_role(participant,auction).
-!start
   <- .wait(100);
      !start.
     
+!join 
   <- .my_name(Me); join_workspace(ora4mas,"",user_id(Me)).
         
/*
   plans to react to normative events like obligation created
*/

+obligation(Ag,Norm,committed(Ag,Mission,Scheme),DeadLine)
    : .my_name(Ag)
   <- .print("I am obliged to commit to ",Mission);
      commit_mission(Mission,Scheme).
      
+obligation(Ag,Norm,achieved(Scheme,Goal,Ag),DeadLine)
    : .my_name(Ag)
   <- .print("I am obliged to achieve goal ",Goal);
      !Goal[scheme(Scheme)];
      goal_achieved(Goal,Scheme).
