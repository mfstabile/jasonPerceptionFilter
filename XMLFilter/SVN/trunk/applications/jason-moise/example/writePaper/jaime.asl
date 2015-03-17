/*  Beliefs */

// I want to play "editor" in "wpgroups"
// (this belief is used by the moise common plans included below) 
desired_role(wpgroup,editor).

// I want to commit to "mManager" mission in "writePaperSch" schemes
desired_mission(writePaperSch,mManager).


/* Initial goals */

!create_group. // initial goal

// create a group to write a paper
+!create_group : true 
   <- //.send(orgManager, achieve, create_group(wpgroup)).
      jmoise.create_group(wpgroup,G);
      .print("Group ",G," created").
-!create_group[error_msg(M),code(C),code_line(L)]
   <- .print("Error creating group, command: ",C,", line ",L,", message: ",M).


/* Organisational Events  */

/* Structural events */

// when I start playing the role "editor",
// create a writePaper scheme
+play(Me,editor,GId) 
   :  .my_name(Me) 
   <- jmoise.create_scheme(writePaperSch, [GId]).

      
/* Functional events */

// when a scheme has finished, start another
-scheme(writePaperSch,_)
   :  group(wpgroup,GId)
   <- jmoise.create_scheme(writePaperSch, [GId], SchId);
      .print("Scheme ",SchId," created").

// include common plans for MOISE+ agents
{ include("moise-common.asl") }


/* Organisational Goals' plans */

+!wtitle[scheme(Sch)] : true 
   <- .print("Writing title!");
      jmoise.set_goal_state(Sch,wtitle,satisfied).

+!wabs[scheme(Sch)] : true 
   <- .print("Writing abstract!");
      jmoise.set_goal_state(Sch,wabs,satisfied).

+!wsectitles[scheme(Sch)] : true 
   <- .print("Writing section titles!");
      jmoise.set_goal_state(Sch,wsectitles,satisfied).

+!wconc[scheme(Sch)] : true 
   <- .print("Writing conclusion!");
      jmoise.set_goal_state(Sch,wconc,satisfied).

+!wp[scheme(Sch)] : true 
   <- .print("***** FINISH! *****");
      jmoise.set_goal_state(Sch,wp,satisfied).
      
