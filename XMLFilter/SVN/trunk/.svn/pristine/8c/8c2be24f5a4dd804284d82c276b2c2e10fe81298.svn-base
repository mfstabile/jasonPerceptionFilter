// this agent always bids 6

{ include("participant.asl") }

// plan for the bid organisational goal
+!bid[scheme(Sch)] 
   :  goal_state(Sch, auction(N), _, _, _) &   // get the auction number
      commitment(Ag, mAuctioneer, Sch)   // get the agent committed to mAuctineer
   <- .send(Ag, tell, place_bid(N,6)).
