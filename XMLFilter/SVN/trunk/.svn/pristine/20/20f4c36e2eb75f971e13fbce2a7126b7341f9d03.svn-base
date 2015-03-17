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
 * Accepts two SE-Literals used to represent two classes, one describing a desired type of product and the other the
 * type of shop that should (initially) be asked.
 */
+!suitable(ProductClass, ShopClass, Qty)
    <-      
    
        ?isEmployedBy(Customer);
        
        ?hasOrder(Customer, Order)[o(c)];
        
        ?ShopClass;
        jasdl.ia.get_individual(ShopClass, Shop);       
    
        // Generate a unique (guaranteed across entire agent society) request identifier (individual) for the new purchase
        jasdl.ia.get_anonymous_individual(ID);      
        
         // Get the rendering in Namespace-prefix Manchester OWL Syntax
        jasdl.ia.get_class_definition(ProductClass, ProductDescription);
        
        // Add the condition that the product must be in stock (this is not something the customer should be concerned with)        
        .concat("(",ProductDescription,") and c:hasInStock some integer [ >= ",Qty,"]",ProductDescriptionInStock);
        
        // Parse the ammended product description into a class
        jasdl.ia.define_class(productInStock, ProductDescriptionInStock);   
        
        .print("Asking ",Shop,":", ProductDescriptionInStock);
        
        // Ask for all brands that match these criteria
        .send(Shop, askOne,
            productInStock(Brand)[o(self), id(ID), stockist(Stockist)],
            productInStock(Brand)[o(self), id(ID), stockist(Stockist)]);            

        // ask for the customer's approval
        !!approve(ID, Brand, ProductDescription, Shop, Qty, Order, Stockist).
        

/**
 * Results in the "approve" customer environmental action. If this succeeds, we commit the purchase
 * details to the belief base.
 */
+!approve(ID, Brand, ProductDescription, Shop, Qty, Order, Stockist)
    <-
        ?isEmployedBy(Customer);
        .send(Customer, askOne,
            approve(Brand, Answer),
            approve(Brand, true));
            
        // Commit the purchase details to the belief base
        +hasBrand(ID, Brand)[o(c)];
        +hasShop(ID, Stockist)[o(c)];
        +includes(Order, ID)[o(c)];
        +purchase(ID)[o(c)];    
        +hasQuantity(ID, Qty)[o(c)].

/**
 * The customer has rejected this purchase. Try asking the shop for other brands of this type.
 */
-!approve(ID, Brand, ProductDescription, Shop, Qty, Order, Stockist)
    <-
        ?isEmployedBy(Customer);
        
        // Get the class describing the type of product, adding the additional requirement that it
        // also not be the individual rejected by the customer
        jasdl.ia.define_class(ammendedProductClass, "(",ProductDescription,") and (not {c:",Brand,"})");        
        
        // We use the same achieve goal used by a customer here, effectively emulating a customer request, but with the ammended product
        // description, given the customer's rejection
        !suitable(ammendedProductClass(_)[o(self)], shop(Shop)[o(s)], Qty).
    
/**
 * The product request has failed. No shop can find a product matching these (possibly ammended) criteria.
 */
-!suitable(ProductClass, ShopClass, Qty)
        <-
        ?isEmployedBy(Customer);
        .send(Customer, tell, message("I am sorry but I am unable to service your request."));
        .fail.

/**
 * The customer has confirmed their current order, instantiate the order confirmation process.
 */
+!order_confirmed[source(Customer)] : isEmployedBy(Customer)
        <-
        ?hasOrder(Customer, Order)[o(c)];
        .findall(ID, purchase(ID)[o(c)], Purchases);
        !order_confirmed(Purchases, []).
        
/**
 * The customer has attempted to confirm an order before any purchases have been made, let them know.
 */     
-!order_confirmed[source(Customer)] : isEmployedBy(Customer) & not hasOrder(Customer, _)[o(c)]
        <-
        .send(Customer, tell, message("You must request some products first")).


/**
 * Recursive case of the order confirmation process.
 */
+!order_confirmed([Purchase|Purchases], Shops)
    <-      
    
        // Get the details of this purchase
        ?hasBrand(Purchase, Brand)[o(c)];
        ?hasQuantity(Purchase, Qty)[o(c)];
        
        // JASDL current doesn't support domain-unground property queries
        // Instead, we use inverse properties such as this one (includedIn is the inverse of includes)
        // Note that both types of assertions have exactly the same meaning as far as JASDL is concerned
        ?includedIn(Purchase, Order)[o(c)]; 
    
        // ... and send them to the appropriate shop agent      
        ?hasShop(Purchase, Shop)[o(c)];
        .send(Shop, tell, purchase(Purchase)[o(c)]);
        .send(Shop, tell, includedIn(Purchase, Order)[o(c)]);
        .send(Shop, tell, hasBrand(Purchase, Brand)[o(c)]);
        .send(Shop, tell, hasQuantity(Purchase, Qty)[o(c)]);
        
        // Confirm the remaining purchases
        // (Here we drop the head of Purchases, and add to the list of shops responsible for delivery of this order)
        !order_confirmed(Purchases, [Shop|Shops]).
        
/**
 * Terminal case of the order confirmation process.
 */
+!order_confirmed([], Shops)
    <-
        // Now we have sent all purchase details, send the location where the order should be delivered to (i.e. the customer)
        ?isEmployedBy(Customer);
        ?hasOrder(Customer, Order)[o(c)];   
        
        // Inform ALL shops involved in this purchase for whom this order is on behalf of
        .send(Shops, tell, hasCustomer(Order, Customer)[o(c)]);
        
        // ... and finish with the order itself, which will instantiate the dispatch process in ALL invovled shop agents
        .send(Shops, tell, order(Order)[o(c)]);
        
        // abolish the order (and all included purchases), we no longer need it
        !abolish_order(Order);
    
        // Inform the customer      
        .concat("Your order has been confirmed and will be dispatched shortly by ",Shops," respectively.", Message);
        .send(Customer, tell, message(Message)).


    
