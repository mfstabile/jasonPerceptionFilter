// mars robot 1

/* Initial beliefs */
at(P) :- pos(P,X,Y,S) & pos(r1,X,Y,S).

/* Initial goal */

!check(slots).

/* Plans */

+pos(P,X,Y,S)[distance(D)] <- +at(P,X,Y,S,D)[distance(D)];
							  -at(P,_,_,S-2,_);
							  !calculateMovement(P,D,S).
							  
+!calculateMovement(P,D,S) : at(P,_,_,S-1,_)[distance(D2)] <-
							  -closer(P);
							  -further(P);
							  -same(P);
							  if (D>D2) {
							  	+closer(P);
							  } else {
							  	if (D<D2) {
							  		+further(P);
								} else {
							  	+same(P);
							  }}.

+!calculateMovement(P,D,S) : not at(P,_,_,S-1,_)[distance(D2)] <- true.

+!check(slots): not garbage(r1)
   <- intact.best_action2(X,Y);
   		intact.change_filter(busca);
   		move_towards(X,Y);
   		//next(slot);
      !!check(slots).

+!check(slots): garbage(r1) & not .desire(carry_to(r2))
   <- intact.change_filter(retorno);
   		!carry_to(r2).

+!check(slots).

//+garbage(r1) : not .desire(carry_to(r2))
//   <- !carry_to(r2).
   
+!carry_to(R)   
   <- // remember where to go back
      // carry garbage to r2
      !take(garb,R);
	  -garbage(r1);
	  //next(slot);
      !!check(slots).

+!take(S,L) : true
   <- !ensure_pick(S);
      !at(L);
      drop(S).
	  //-garbage(r1).
//	  .print("derrubou").

+!ensure_pick(S) : garbage(r1)
   <- pick(garb);
      !ensure_pick(S).
+!ensure_pick(_).

+!at(L) : at(L).
+!at(L) <- ?step(S);
			?pos(L,X,Y,S);
		   move_towards(X,Y);
           !at(L).
		   
+!check(slots).
