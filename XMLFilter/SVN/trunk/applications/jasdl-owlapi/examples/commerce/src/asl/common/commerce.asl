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
+!abolish_order(Order)  :
    order(Order)[o(c)]  // must be a known order
    <-
        // Abolish beliefs about purchases included in this order, we no longer need them
        .findall(Purchase, includes(Order, Purchase)[o(c)], Purchases);
        !abolish_purchases(Purchases);  
    
        -order(Order)[o(c), source(_)];
        // note: inverse of hasOrder
        -hasCustomer(Order, Customer)[o(c), source(_)]. 

/*
 * Terminal case
 */ 
+!abolish_purchases([]).

/*
 * Recursive case
 */
+!abolish_purchases([Purchase|Purchases])
    <-
    !abolish_purchase(Purchase);
    !abolish_purchases(Purchases).
    
    
+!abolish_purchase(ID) :
    purchase(ID)[o(c)]
    <-      
        -hasProductDescription(ID, _)[o(c), source(_)];
        .abolish(includedIn(ID, _)[o(c), source(_)]);
        -hasQuantity(ID, _)[o(c), source(_)];
        -purchase(ID)[o(c), source(_)];
        -hasShop(ID, _)[o(c), source(_)].
    
