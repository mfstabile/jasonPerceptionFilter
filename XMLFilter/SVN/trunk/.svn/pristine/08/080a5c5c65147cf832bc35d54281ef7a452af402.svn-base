// This agent usually bids 4, 
// when it has an alliance with ag3, it bids 0

default_bid_value(4).
ally(ag3).
 
desired_role(auctionGroup,participant).
desired_mission(doAuction,mParticipant).

{ include("moise-common.asl") }

// plan for the bid organisational goal
+!bid[scheme(Sch)] 
   :  goal_state(Sch, auction(N), _) & // get the auction number
      commitment(Ag, mAuctioneer, Sch) & // get the agent committed to mAuctineer
      not alliance
   <- ?default_bid_value(B);
      .send(Ag, tell, place_bid(N,B));
      jmoise.set_goal_state(Sch,bid,satisfied).

+!bid[scheme(Sch)] 
   :  goal_state(Sch, auction(N), _) & 
      commitment(Ag, mAuctioneer, Sch) & // get the agent committed to mAuctineer
      alliance
   <- .send(Ag, tell, place_bid(N,0));
      jmoise.set_goal_state(Sch,bid,satisfied).

// alliance proposal from another agent
+alliance[source(A)] 
   :  .my_name(I) & ally(A)
   <- .print("Alliance proposed by ", A);
      ?default_bid_value(B);
      .send(A,tell,bid(I,B));
      .send(A,tell,alliance(A,I)).

+alliance[source(A)] <- .print("----",A). 
      
