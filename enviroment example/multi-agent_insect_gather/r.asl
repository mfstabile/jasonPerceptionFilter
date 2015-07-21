// mars robot 1\

/* Initial beliefs */
at(P) :- .my_name(Ag) & pos(P,X,Y) & pos(Ag,X,Y).

/* Initial goal */

!check(slots). 

/* Plans */

+pos(P,X,Y,S) <- +at(P,X,Y,S).

+step(S) : not .desire(_) <- N = S-2;
							.abolish(at(_,_,_,N,_));
							!!check(slots).

+step(S) <- N = S-2;
			.abolish(at(_,_,_,N)).

+!check(slots) : .my_name(Ag) & not garbage(Ag)
   <- intact.change_filter(busca);
   	  .my_name(Ag);
      path.best_direction(X,Y,Ag);
   	  move_towards(X,Y);
      !!check(slots).
+!check(slots) : not .desire(carry_to(burner)) <- !carry_to(burner).
+!check(slots) .//<- .abolish(garbage(_));.my_name(Ag);.desire(D);.print(Ag," desiring ",D).

+garbage(Ag) : .my_name(Ag) & not .desire(carry_to(burner))
   <- !carry_to(burner).

+!carry_to(R)
   <- intact.change_filter(retorno);
   	  !take(garb,R);
      !!check(slots).

+!take(S,L) : true
   <- !ensure_pick(S); 
      !at(L);
      drop(S);
	  .my_name(Ag);
	  path.bestDirection(X,Y,Ag);
   	  move_towards(X,Y).

+!ensure_pick(S) : .my_name(Ag) & garbage(Ag)
   <- pick(garb);
      !ensure_pick(S).
+!ensure_pick(_).

-!ensure_pick(_) <- !!check(slots).

+!at(L) : at(L).
+!at(L) <- ?pos(L,X,Y);
           move_towards(X,Y);
           !at(L).
