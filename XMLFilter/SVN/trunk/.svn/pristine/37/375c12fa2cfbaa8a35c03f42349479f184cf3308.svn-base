// This agent creates the group/scheme to write a paper
// and adopts the role "editor" in the group

/* Initial goals */

!start.

/* Plans */

+!start : true 
  <- .my_name(Me);
     join_workspace(ora4mas,"",user_id(Me)); 
     .wait(300);
     
     //make_artifact("mypaper", "ora4mas.nopl.GroupBoard", [mypaper, "wp-os.xml", wpgroup, false, false ]); 
     create_group(mypaper, "wp-os.xml", wpgroup, false, true);
     .print("group created");
     
     //ora4mas.adopt_role(editor,mypaper);
     adopt_role(editor,mypaper);
     
     // wait for alice
     ?play(A,writer,mypaper);
     
     // wait for carol
     ?play(C,writer,mypaper);
     
     .print("roles adopted, writers are ",A," and ",C);
     !run_scheme(sch1).

// general error handler for goal start 
-!start[error(I),error_msg(M)] <- .print("failure in starting! ",I,": ",M).
     
 +!run_scheme(S)
   <- create_scheme(S, "wp-os.xml", writePaperSch, false, true);
      .print("scheme ",S," created");
      add_responsible_group(S,mypaper); 
      .print("scheme is linked to responsible group");   
      commit_mission(mManager, S).
     
// when the root goal of the scheme is statisfied, remove the scheme     
+goal_state(sch1,wp,_,_,satisfied)
   <- .print("all finished... removing artifact for sch1");
      .wait(1000);
      remove_scheme(sch1);
      .print("starting a new scheme...");
      !run_scheme(sch2).
      

+?play(A,R,G) <- .wait({+play(A,R,G)}).

// signals
+norm_failure(N) <- .print("norm failure event: ", N).
+destroyed(Art)  <- .print("Artifact ",Art," destroyed").      

// plans to react to normative events like obligation created
      
+obligation(Ag,Norm,achieved(Scheme,Goal,Ag),DeadLine)
    : .my_name(Ag)
   <- .print("I am obliged to achieve goal ",Goal);
      goal_achieved(Goal,Scheme).
      
+obligation(Ag,Norm,What,DeadLine)  
   : .my_name(Ag)
   <- .print("I am obliged to ",What,", but I don't know what to do!").

// for debug (prints out the new states of goals)
+goal_state(Sch,Goal,CommittedAgs,AchievedBy,State)
   <- .print("                         goal changed: ", goal_state(Sch,Goal,CommittedAgs,AchievedBy,State)).
   
