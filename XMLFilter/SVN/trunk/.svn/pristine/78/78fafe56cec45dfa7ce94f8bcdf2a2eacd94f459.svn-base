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
 * Unify PossibleStockist with a shop that is a member of the class specified by Expression. Additionally, we add
 * the constraints that it not be exhausted (i.e. already tried and failed) for this purchase ID, it is in the same
 * company as this shop and is not this shop.
 * This is a good example of how certain JASDL features (such as SE-Literal queries and run-time class definitions) 
 * can be conveniently expressed within a rule.
 */
 
possibleStockist(ID, Expression, PossibleStockist) :-
    jasdl.ia.define_class(possibleStockist, Expression) &
    possibleStockist(PossibleStockist)[o(self)] &
    shopInSameCompany(PossibleStockist) &   // note: this constraint could be more flexible by using an expression such as '' in the above class definition
    not exhausted(ID)[source(PossibleStockist)] &
    not (PossibleStockist == Me).
    

/**
 * Unify with a shop, other than this one, that is owned by the same company as this one.
 */
shopInSameCompany(Shop) :-
    shop(Shop)[o(s)] &
    .my_name(Me) &
    ownedBy(Me, Company)[o(s)] &
    owns(Company, Shop)[o(s)] &
    (not Shop==Me). 
    
    
/*
 * The single term of the jasdl_tg_cause annotation is unified with the original cause of this trigger generalisation.
 * This allows us to use a generalised plan, while still having access to the information given by the (more specific) event that
 * led to the invocation of this plan.
 *
 * This shop has managed to find a suitable product in its belief base.
 * We know this is the case since the original query leading to generalisation to this is in the context (OriginalQuery).
 * Respond to the PA, keeping id annotation intact so we can match this response with the customer's request elsewhere.
 * The up till now unground stockist annotation is grounded with the name of this agent - ultimately informing the PA
 * of whom it should submit the delivery request to.
 */
@found_product_for_PA
+?product(Brand)[o(c), id(ID), stockist(Me)] : jasdl.ia.get_tg_cause(OriginalQuery, false) &
    OriginalQuery   // the agent has found a suitable product within its belief base
        <-
        .print("Recieved request and is able to service it");
        .my_name(Me);
        jasdl.ia.get_individual(OriginalQuery, Brand).
        
/** TODO: Match other, more specific, types of product and opportunistically present special offers to the PA
 * i.e. "buy two get one free on all types of milk" using a plan such as:
 *
 * +?milk(Brand)[o(c), id(ID), stockist(Me)] : jasdl.ia.get_tg_cause(OriginalQuery, false) &
 *      OriginalQuery
 *          <-
 *              ...
 */ 

+?milk(Brand)[o(c), id(ID), stockist(Me)] : jasdl.ia.get_tg_cause(OriginalQuery, false) &
    OriginalQuery   // the agent has found a suitable product within its belief base
        <-
        .print("Recieved request and is able to service it");
        .my_name(Me);
        jasdl.ia.get_individual(OriginalQuery, Brand).

/**
 * We are unable to find a suitable product, moreover, we are unable to establish a possible stockist to try on behalf of the PA.
 * Notice that the plans below also with "not OriginalQuery" in their context will take precence over this one,
 * since their are both more specific than owl:thing (which is the most general concept) - additionally, plan ordering
 * is irrelevant here since JASDL automatically assigns precence according to concept specificity for trigger generalisation
 */
+?thing(Brand)[o(owl), id(ID), stockist(_)] :  jasdl.ia.get_tg_cause(OriginalQuery, false) &
    not OriginalQuery   // the agent has not found a suitable product within its belief base
    <-
        !reset(ID);
        .print("Recieved request and is UNABLE to service it");
        .fail.  
        
/**
 * Requested a type of product that this agent cannot supply, try asking any other shop.
 */
+?product(Brand)[o(c), id(ID), stockist(Stockist)] : jasdl.ia.get_tg_cause(OriginalQuery, false) & .print(OriginalQuery) &
    not OriginalQuery & // the agent has not found a suitable product within its belief base
    possibleStockist(ID, "s:shop", Try)
        <-
        .print("Unknown GENERAL PRODUCT requested");
        !exhausted(ID);
        ?stocked_by_another_shop(Try, ID, OriginalQuery, Brand, Stockist).

/**
 * Requested a type of vegetable product that this agent cannot supply, try asking a greengrocer or a supermarket.
 */
+?vegetable(Brand)[o(c), id(ID), stockist(Stockist)] : jasdl.ia.get_tg_cause(OriginalQuery, false) &
    not OriginalQuery & // the agent has not found a suitable product within its belief base
    possibleStockist(ID, "s:greenGrocers or s:supermarket", Try)
        <-
        .print("Unknown VEGETABLE PRODUCT requested");
        !exhausted(ID);
        ?stocked_by_another_shop(Try, ID, OriginalQuery, Brand, Stockist).

/**
 * Requested a type of meat product that this agent cannot supply, try asking a butchers.
 */
+?meatProduct(Brand)[o(c), id(ID), stockist(Stockist)] : jasdl.ia.get_tg_cause(OriginalQuery, false) &
    not OriginalQuery & // the agent has not found a suitable product within its belief base
    possibleStockist(ID, "s:butchers", Try)
        <-
        .print("Unknown MEAT PRODUCT requested");
        !exhausted(ID);
        ?stocked_by_another_shop(Try, ID, OriginalQuery, Brand, Stockist).

/**
 * Try the shop identified by PossibleStockist, preserving the necessary annotations.
 */
+?stocked_by_another_shop(PossibleStockist, ID, Query, Answer, Stockist) :
    shopInSameCompany(PossibleStockist) // Must be a known shop in this company
        <-
        .print("Trying ", PossibleStockist);
        .add_annot(Query, id(ID), Q1);
        .add_annot(Q1, stockist(Stockist), Q2);
        .send(PossibleStockist, askOne, Q2, Q2);    
        jasdl.ia.get_individual(Q2, Answer).
        
    
/**
 * Inform all other known shops within this company that I have already been tried for this order and unable to service it
 * (so I am not asked again)
 */
+!exhausted(ID)
        <-
        .print("Setting exhausted status for purchase ", ID);
        .findall(Shop, shopInSameCompany(Shop), Shops);
        .send(Shops, tell, exhausted(ID)).

/**
 * Reset the exhausted status for a product for this shop and across all other known shops in this company.
 */
+!reset(ID)
        <-
        .print("Resetting exhausted status for purchase ", ID);
        .findall(Shop, shopInSameCompany(Shop), Shops);
        .abolish(exhausted(ID)[source(_)]);
        .send(Shops, untell, exhausted(ID)[source(_)]).

/**
 * Another shop has "reset" the exhausted status for a product, ensure all exhausted beliefs for this purchase ID are abolished accordingly.
 */
-exhausted(ID)[source(Shop)] :
    shopInSameCompany(Shop)
        <-
        .abolish(exhausted(ID)).
   
  
   
/**
 * All plans below this point deal with coordinating delivery with a delivery van employed by the shop.
 * Note that these are not so interesting in terms of exploring JASDL extensions to Jason's core functionality, so
 * don't worry about them too much.
 */
 
 /**
 * An order request has been recieved from a PA, coordinate delivery of it
 */
+order(Order)[o(c), source(PA)] :
    hasCustomer(Order, Customer)[o(c)] &                      
    employs(Customer, PA)[o(s)]
        <-
        // Delopy crates containing product
        !deploy(Order);
        // Obtain an available van (or suspend this intention until one it available)
        !wait_available(Van);
        // Instruct this van to move to shop's position
        !recall(Van);
        // Instruct the van to load the deployed products into its cargo hold
        !load(Order, Van);
        // Instruct the van to move to the customer's position
        !dispatch(Order, Van);
        // Instruct the van to unload its cargo at its current position (i.e. the customer's)
        !unload(Order, Van);
        // Abolish beliefs about this order (and all included purchases), we no longer need them
        !abolish_order(Order);
        // Make the van available again
        +available[source(Van)].
    

 /*
 * The agent has attempted to find an available van (see above) within the belief base but has failed.
 * Wait until we become aware that there is an agent that it is available (thus resuming the intention).
 */

+!wait_available(Van) : not available[source(Van)]
        <-
        .wait(800);
        !wait_available(Van).

/**
 * This must remain atomic to prevent the same van being allocated more than once at any one time.
 */
 @allocate_available[atomic]
+!wait_available(Van) : available[source(Van)]
        <-
        -available[source(Van)].
        

/**
 * Achieve the state of affairs such that a van has loaded an entire order into its cargo.
 * (Suspends the intention until this is so) 
 */
+!load(Order, Van) : .my_name(Me) & inVicinityOf(Van)
        <-
        -hasPosition(Van, X, Y)[source(Van)];   
        .findall(PID, includes(Order, PID)[o(c)], PIDs);
        .send(Van, achieve, load(PIDs));
        !wait_loading_complete(Van).
        
+!wait_loading_complete(Van) : not loading_complete[source(Van)]
        <-
        .wait(400);
        !wait_loading_complete(Van).
        
+!wait_loading_complete(Van) : loading_complete[source(Van)]
        <-
        -loading_complete[source(Van)].
        
/**
 * Achieve the state of affairs such that a van has unloaded its entire cargo at its current destination
 * (Suspends the intention until this is so) 
 */ 
+!unload(Order, Van)
        <-
        .findall(PID, includes(Order, PID)[o(c)], PIDs);
        .send(Van, achieve, unload(PIDs));
        !wait_unloading_complete(Van).
        
+!wait_unloading_complete(Van) : not unloading_complete[source(Van)]
        <-
        .wait(400);
        !wait_unloading_complete(Van).
        
+!wait_unloading_complete(Van) : unloading_complete[source(Van)]
        <-
        -unloading_complete[source(Van)].

/**
 * Instruct a van to go to the shop's position
 * (Suspends the intention until this is so) 
 */
+!recall(Van)
        <-
        .my_name(Me);
        ?hasPosition(Me, MX, MY);
        !hasPosition(Van, MX, MY).

/**
 * Instruct a van to go to the location of the customer assocaited with an order
 * (Suspends the intention until this is so) 
 */
+!dispatch(Order, Van)
        <-
        ?hasCustomer(Order, Customer)[o(c)];
        .send(Customer, askOne, hasPosition(Customer, X, Y), hasPosition(Customer, X, Y));
        .print("Dispatching ", Van, " to ", X,",",Y,"(",Customer,")");
        !hasPosition(Van, X, Y).    
    
/**
 * Achieve the state of affairs such that a van is at a position on the grid.
 * (Suspends the intention until this is so)
 */
+!hasPosition(Van, X, Y) : not hasPosition(Van, X, Y)
        <-  
        .send(Van, achieve, hasPosition(Van, X, Y));
        !wait_hasPosition(Van, X, Y).
        
+!wait_hasPosition(Van, X, Y) : not hasPosition(Van, X, Y)
        <-
        .wait(2000);
        !wait_hasPosition(Van, X, Y).

+!wait_hasPosition(Van, X, Y) : hasPosition(Van, X, Y)
        <-
        -hasPosition(Van, X, Y)[source(_)].



/**
 * (Recursively) achieve the state of affairs such that all purchases are deployed (i.e present
 * on the grid as a "crate") at the shop's location. 
 */
+!deploy([]).
+!deploy([Purchase|Purchases])
        <-
        ?hasBrand(Purchase, Brand)[o(c)];
        ?hasQuantity(Purchase, Qty)[o(c)];
    
        // The "deploy" environmental action results in the creation of a ModelCrate object
        // at the shop's current position and decreases it's stock for the supplied brand accordingly.
        deploy(Purchase, Brand, Qty);
        .print("Deploying crate", Purchase);
        !deploy(Purchases).
        
/**
 * Convenience plan that finds all the purchases in an order and instantiates !deploy above.
 */
+!deploy(Order)
        <-
        .findall(PID, includes(Order, PID)[o(c)], PIDs);
        !deploy(PIDs).

    

+?details(Brand, Details) : product(PID)[o(c)]
        <-
        ?hasPrice(Brand, Price)[o(c)];
        ?hasInStock(Brand, StockLevel)[o(c)];
        // Unifies Types with all asserted (since third parameter is "true") classifications of the individual Brand 
        // in the ontology identified by c
        jasdl.ia.get_types(Brand, c, true, Types);
        .concat("Brand Name=", Brand, ", Stock level=", StockLevel, ", Price=", ", Classifications=", Types, Price, Details).

/* Failed to get details. Reason: No price listed for product type */
-?details(Brand, Details) : product(Brand)[o(c)] & not hasPrice(Brand, Price)
        <-
        .concat("No price listed for product ", Brand, Details).
    
+!print_details(Brand) : product(Brand)[o(c)]
        <-
        ?details(Brand, Details);
        .print(Details).
