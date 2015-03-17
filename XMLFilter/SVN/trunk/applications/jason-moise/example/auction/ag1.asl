// this agent always bids 6

// I want to play role "participant" in "auctionGroup"
// (this belief is used by the moise common plans included below) 
desired_role(auctionGroup,participant).

// I want to commit to "mAuctionner" mission in "doAuction" schemes
desired_mission(doAuction,mParticipant).

// include common plans for MOISE+ agents
{ include("moise-common.asl") }

// plan for the bid organisational goal
+!bid[scheme(Sch)] 
   :  goal_state(Sch, auction(N), _) &   // get the auction number
      commitment(Ag, mAuctioneer, Sch)   // get the agent committed to mAuctineer
   <- .send(Ag, tell, place_bid(N,6));
      jmoise.set_goal_state(Sch,bid,satisfied).

