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

/* 
 * PA is employed by a single customer (enforced by the fact that employs is inverse functional - and isEmployedBy is functional)
 * Unfortunately, since employs has an inverse property, it cannot also be transitive.
 */
 
 // Using SE-Literals in rules.
 // In this case essentially grounding the domain of an object property with a commonly used value (i.e. my name)
isEmployedBy(Employer) :- .my_name(Me) & isEmployedBy(Me, Employer)[o(s)].

employs(Employee) :- .my_name(Me) & employs(Me, Employee)[o(s)].
