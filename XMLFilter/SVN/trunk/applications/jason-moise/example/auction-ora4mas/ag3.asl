// this agent bids 3,
// if it looses 3 auctions, it proposes an alliance to
// ag2 and therefore it bids 7 (3 from itself + 4 from ag2)

{ include("participant.asl") }


default_bid_value(3).
ally(ag2).
threshold(3).

// plan for the bid organisational goal
+!bid[scheme(Sch)] 
   :  goal_state(Sch, auction(N), _, _, _) & // get the auction number
      (threshold(T) & N < T) 
      |
      (.my_name(I) & winner(_,I) & ally(A) & not alliance(I,A))
   <- !bid_normally.

+!bid[scheme(_)] 
   : .my_name(I) & not winner(_,I) & ally(A) & not alliance(I,A)
   <- !alliance(A);
      !bid_normally.

+!bid[scheme(Sch)] 
   :  goal_state(Sch, auction(N), _, _, _) &    // get the auction number
      commitment(Ag, mAuctioneer, Sch) &  // get the agent committed to mAuctineer
      alliance(_,A)
   <- ?default_bid_value(B);
      ?bid(A,C);
      .send(Ag, tell, place_bid(N,B+C)).

+!bid_normally 
   :  goal_state(Sch, auction(N), _, _, _) &  // get the auction number
      commitment(Ag, mAuctioneer, Sch)  // get the agent committed to mAuctineer
   <- ?default_bid_value(B);
      .send(Ag, tell, place_bid(N,B)).

+!alliance(A) 
   <- .print("Proposing alliance to ",A);
      .send(A,tell,alliance).
   
// remember the winners
+goal_state(Sch, winner(W), _, _, satisfied) 
   :  goal_state(Sch, auction(N), _, _, _)
   <- +winner(N,W).

