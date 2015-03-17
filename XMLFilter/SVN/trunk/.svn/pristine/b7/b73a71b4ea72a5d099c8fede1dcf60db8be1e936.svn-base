/* Beliefs */

// I want to play "writer" in "wpgroups"
desired_role(wpgroup,writer).

// I want to commit to "mColaborator" mission in "writePaperSch" schemes
desired_mission(writePaperSch,mColaborator).

// include common plans for MOISE+ agents
{ include("moise-common.asl") }


/* Organisational Goals' plans */

+!wsecs[scheme(Sch)] 
   :   commitment(Ag, mBib, Sch) 
   <- // send a message to the agent committed to mission mBib
      .send(Ag, tell, use_ref(bordini05));
      .print("Writing sections!");
      jmoise.set_goal_state(Sch, wsecs, satisfied).

// the plan to achieve the goal failed
-!wsecs[scheme(Sch)] : true 
   <- jmoise.set_goal_state(Sch, wsecs, impossible).
