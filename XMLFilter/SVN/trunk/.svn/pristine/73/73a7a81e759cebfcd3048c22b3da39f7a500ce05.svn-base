/* 
 *  Copyright (C) 2008 Thomas Klapiscak (t.g.klapiscak@durham.ac.uk)
 *  
 *  This file is part of JMCA.
 *
 *  JMCA is free software: you can redistribute it and/or modify
 *  it under the terms of the Lesser GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *
 *  JMCA is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  Lesser GNU General Public License for more details.
 *
 *  You should have received a copy of the Lesser GNU General Public License
 *  along with JMCA.  If not, see <http://www.gnu.org/licenses/>.
 *  
 */
 
/**
 * An example demonstrating the workings of a simple JMCA composition chain
 
 * Result: will always print "b".
 
 * Reasoning is as follows:
 * 1. AlphaOptionModule chooses {a, b}
 * 2. ElbppOptionModule chooses {b, c}
 * 3. intersection({a, b}, {b, c}) = {b}
 */ 

!begin.
    
@a[pl(0)]
+!begin
    <-
    .print("a").
    
@b[pl(1)]
+!begin
    <-
    .print("b").
    
@c[pl(1)]
+!begin
    <-
    .print("c").
    
@d[pl(0)]
+!begin
    <-
    .print("d").

