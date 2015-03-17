/* 
 *  Copyright (C) 2008 Thomas Klapiscak (t.g.klapiscak@durham.ac.uk)
 *  
 *  This file is part of JASDL.
 *
 *  JASDL is free software: you can redistribute it and/or modify
 *  it under the terms of the Lesser GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *
 *  JASDL is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  Lesser GNU General Public License for more details.
 *
 *  You should have received a copy of the Lesser GNU General Public License
 *  along with JASDL.  If not, see <http://www.gnu.org/licenses/>.
 *  
 */
{include("common/society.asl")}
{include("common/commerce.asl")}

/**
 * The code for this agent doesn't make particularily intersting use of JASDL features,
 * so don't worry about it too much.
 */

!init.

/**
 * All delivery vans are available at the start of the simulation.
 */
+!init
    <-
    .my_name(Me);
    ?isEmployedBy(Me, Employer)[o(s)];
    .send(Employer, tell, available).


+!hasPosition(Me, X, Y)[source(Employer)] : .my_name(Me) & hasPosition(Me, X, Y) & isEmployedBy(Employer)
    <-
    .send(Employer, tell, hasPosition(Me, X, Y)).

+!hasPosition(Me, X, Y)[source(Employer)] :
    .my_name(Me) &
    not hasPosition(Me, X, Y) &                 // Destination must be specified
    isEmployedBy(Employer)
    <-
    move_towards(X, Y);
    .wait(5); // <- simulate movement speed
    !!hasPosition(Me, X, Y)[source(Employer)].

@load_all_2[atomic] 
+!load([])[source(Employer)]
    <-
    .send(Employer, tell, loading_complete).

@load_all_1[atomic]
+!load([Purchase|Purchases])[source(Employer)] :
    isEmployedBy(Employer)
    <-
    load(Purchase);                                     // Load purchase
    !!load(Purchases)[source(Employer)].

@unload_all_2[atomic]
+!unload([])[source(Employer)]
    <-
    .send(Employer, tell, unloading_complete).

@unload_all_1[atomic]
+!unload([Purchase|Purchases])[source(Employer)] :
    isEmployedBy(Employer)
    <-
    unload(Purchase);                                               // Unload purchase
    !!unload(Purchases)[source(Employer)].                      // Unload remaining purchases
    
+?~cargo(Purchase) : not cargo(Purchase).   // (not cargo) implies ~cargo for the delivery van (i.e. we make CWA for this belief)
    
    
