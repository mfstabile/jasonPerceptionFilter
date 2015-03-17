/* 
   Beliefs
*/

// I want to play role "auctioneer" in "auctiongroup"
// (this belief is used by the moise common plans included below) 
desired_role(auctionGroup,auctioneer).

// I want to commit to "mAuctioneer" mission in "doAuction" schemes
desired_mission(doAuction,mAuctioneer).

auction_id(0).

/*
   Initial goals
*/

!create_group. // initial goal

// create a group to execute the auction
+!create_group <- jmoise.create_group(auctionGroup).


/* 
   Organisational Events
   ---------------------
*/

// when I start playing the role "auctioneer",
// create a doAuction scheme.
// My group will be the responsible group for the scheme
+play(Me,auctioneer,GId) 
   :  .my_name(Me) 
   <- jmoise.create_scheme(doAuction, [GId]).

// when a scheme has finished, start another
-scheme(doAuction,_) 
   :  auction_id(N) & N < 7 & group(auctionGroup,GId)
   <- jmoise.create_scheme(doAuction, [GId]).
//-scheme(doAuction,SId)
//   <- .stopMAS.

// include common plans for MOISE+ agents
{ include("moise-common.asl") }


/*   
   Organisational Goals' plans
   ---------------------------
*/

+!start[scheme(Sch)] 
   :  auction_id(N)
   <- .print("Start scheme for ",auction_id(N+1));
      -+auction_id(N+1); 
      -+winner(N+1,no,0);
      jmoise.set_goal_arg(Sch,auction,"N",N+1);
      jmoise.set_goal_state(Sch,start,satisfied).
      
+!winner(W)[scheme(Sch)] 
   :  auction_id(N) & winner(N,W,_) 
   <- jmoise.set_goal_arg(Sch,winner,"W",W); 
      jmoise.set_goal_state(Sch,winner,satisfied).

// the root goal is permitted (it means that all sub-goals were achieved)
+!auction(N)[scheme(Sch)] 
   :  auction_id(N) & winner(N,W,Vl) 
   <- .print("***** Auction ", N," is finished. The winner is ",W,", value is ",Vl," *****");
      jmoise.set_goal_state(Sch,auction,satisfied).
      
/*
   Communication protocol for bids
*/

// receive bid and check for new winner
@pb1[atomic]
+place_bid(N,V)[source(S)] 
   :  auction_id(N) & winner(N,_,CurVl) & V > CurVl
   <- .print("Bid from ", S, " is ", V);
      -+winner(N,S,V).
+place_bid(_,V)[source(S)] 
   <- .print("Bid from ", S, " is ", V).

