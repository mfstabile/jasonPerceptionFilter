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

/* 
 * Some Notes:
 * The ontologies and syntactic translation protocol is providing a well-defined shared vocabulary between agents.
 * With an accurate ontology alignment our agents could communicate even without prior agreement on terms.
 * - the structural information in the ontology gives us a richer palette for semantic matching over and above that available through
 *   e.g. synonym matching.
 * We are assuming central repository of agents and their types (society.owl schema). We are also assuming agent's cannot falsify their names
 * (in fact, security is not an issue considered yet throughout the system).
 * IDs are propagated through annotations to match product request brands with quantities
 */
 


/**
 * Will instantiate a unique order ID and associated it with this customer if none known.
 * Fails quietly otherwise.
 */
+!init
    <-
        // ask the PA if it already has a current order listed for this custoemr
        ?employs(PA);
        .send(PA, askOne, order(Order)[o(c)], false);
        
        // ... it does not, give it a new order ID and associate it with this customer
        ?employs(PA);
    
        jasdl.ia.get_anonymous_individual(Order);
        
        .my_name(Me);   
        +order(Order)[o(c)];
        +hasOrder(Me, Order)[o(c)]; // note: inverse of hasCustomer
        
        .send(PA, tell, order(Order)[o(c)]);
        .send(PA, tell, hasOrder(Me, Order)[o(c)]).

/**
 * Fail quietly
 */
-!init.         

    
/**
 * The user has hit the "submit request" button on the customer UI.
 */
+ui_product_request(ProductDescription, ShopDescription, Qty)[source(percept)]
    <-
        !init;
        
        // Get a PA employed by me
        ?employs(PA);
        
        // Explicitly discard the percept - in case an identical request comes in next perception cycle (we still want to catch it)
        -ui_product_request(ProductDescription, ShopDescription, Qty)[source(percept)];
        
        // Must be defined locally in order to take advantage of syntactic translation.
        // If these were simply sent as string to PA and this agent had different entity aliases / ontology labels
        // then the PA would not be able to understand the request.     
        jasdl.ia.define_class(suitableProduct, ProductDescription);
        jasdl.ia.define_class(suitableShop, ShopDescription);   
        
        // Request a suitable brand from the PA
        .send(PA, achieve, suitable(suitableProduct(_)[o(self)], suitableShop(_)[o(self)], Qty)).

/*
 * The user has hit the "confirm order" button on the customer UI.
 */
+ui_confirm_order[source(Percept)]
    <-
        // Find the PA I employ
        ?employs(PA);
        // Ask the PA to achieve the state of affairs such that the customer's current order is confirmed with the necessary shop agents.
        .send(PA, achieve, order_confirmed).

/**
 * A message has been recieved from the PA. Execute the "message" environmental action,
 * thus displaying a dialog box on the customer UI.
 */
+message(Message)[source(PA)] : pA(PA)[o(s)]
        <-
        // We no longer need (or want) this belief
        -message(Message)[source(PA)];
        // Display the dialog on the customer UI
        message(Message).
    
/**
 * The PA has asked for approval from the customer to make a purchase (identified by the approve annotation).
 * This results in the execution of the "approve" environmental action. This displays a confirm dialog on the
 * customer UI and suspends the thread awaiting a response.
 */
+?approve(Brand, Answer)
    <-
        // Execute the "approve" environmental action
        approve(Brand);
        // Will only be reached if the user hits "OK" - otherwise the above environmental action will fail
        Answer = true.
    
    


