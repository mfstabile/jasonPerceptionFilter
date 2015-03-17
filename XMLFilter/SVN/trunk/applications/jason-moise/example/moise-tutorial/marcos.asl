// the agent is controled by GUI

+!do(X) <- .print("doing ",X); X; gui.list_bels.
-!do(X)[code(C)] <- .print("error in ",C).

+play(Me,R,GrInst)
   : .my_name(Me) & group(GrSpec,GrInst)
  <- jmoise.group_specification(GrSpec,Roles);
    .member(role(R,Min,Max,Compat,Links),Roles);
    .print("I am starting playing ",R);
    .print(" -- cardinality of my role (Min,Max): (",Min,",",Max,")");
    .print(" -- roles compatible with mine: ", Compat);
    .print(" -- all roles of the group are ",Roles);
    .print(" -- sub-groups are ",SubGroups).     

