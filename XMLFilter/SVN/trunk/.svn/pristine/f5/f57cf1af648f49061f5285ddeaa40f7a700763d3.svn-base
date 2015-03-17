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
package commerce.env;
// Environment code for project commerce.mas2j

import jasdl.bridge.factory.AliasFactory;
import jasdl.bridge.mapping.aliasing.Alias;
import jasdl.bridge.mapping.aliasing.DecapitaliseMappingStrategy;
import jasdl.bridge.mapping.aliasing.MappingStrategy;
import jasdl.env.JASDLEnvironment;
import jasdl.util.JASDLCommon;
import jasdl.util.exception.JASDLException;
import jason.asSyntax.Atom;
import jason.asSyntax.Literal;
import jason.asSyntax.NumberTerm;
import jason.asSyntax.NumberTermImpl;
import jason.asSyntax.Structure;
import jason.asSyntax.Term;
import jason.asSyntax.VarTerm;

import java.awt.Dimension;
import java.awt.Point;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;

import owl2mas.exception.OWL2MASInvalidMASOntologyException;
import owl2mas.model.AgentModel;
import owl2mas.model.ObjectModel;

import commerce.exception.AgentModelException;
import commerce.model.CommerceModel;
import commerce.model.CustomerModel;
import commerce.model.DeliveryVanModel;
import commerce.model.ShopModel;
import commerce.view.CommerceView;





/**
 * 
 * 
 * @author Tom Klapiscak
 *
 */
public class CommerceEnvironment extends JASDLEnvironment{


    public Atom s = new Atom("s");
    public Atom c = new Atom("c");
    private List<MappingStrategy> mappingStrategies = Arrays.asList( new MappingStrategy[] { new DecapitaliseMappingStrategy()} );
    
    private Alias inVicinityOf = AliasFactory.INSTANCE.create(new Atom("inVicinityOf"), s);
    
    private CommerceModel model;
    private CommerceView view;

    
    /** Called before the MAS execution with the args informed in .mas2j */
    @Override
    public void init(String[] args) {
        super.init(args);
        
        System.out.println("Agents loading... please wait.");
        
        try {
            model = new CommerceModel(this, new Dimension(20, 20));
        } catch (OWL2MASInvalidMASOntologyException e) {
            throw new RuntimeException("Unable to instantiate commerce model", e);
        }
        
        
        System.out.println("Objects: "+model.getObjects());
        
        view = new CommerceView(model, this);
           
        // for each customer set-up a UI Panel
        for(ObjectModel o : model.getObjects()){
            if(o instanceof CustomerModel){
                view.addCustomer((CustomerModel)o);
            }
        }
        
        try {
            getJom().loadOntology(c, JASDLCommon.getRelativeLocalURI("/onts/commerce.owl"), mappingStrategies);
            getJom().loadOntology(s, JASDLCommon.getRelativeLocalURI("/onts/society.owl"), mappingStrategies);
            
        } catch (JASDLException e) {
            e.printStackTrace();
        }
        
                
        updatePercepts();
        
    }   
    

    private void updatePercepts(){
        synchronized(model.getObjects()){       
            model.updateObjects();              
                
            for(ObjectModel o : model.getObjects()){
                if(o instanceof AgentModel){
                    clearPercepts(o.getId().toString());    
                }
            }
            clearPercepts();
            
            // Add individual percepts for each ModelAgent (determined by ModelAgent#getPercepts)
            for(ObjectModel o : model.getObjects()){
                if(o instanceof AgentModel){
                    AgentModel agent = (AgentModel)o;
                    agent.addPercepts();
                }
            }   

        }       
    }

    
    
    
    
    @Override
    public List<Literal> getPercepts(String agName) {
        synchronized (model.getObjects()) {
            return super.getPercepts(agName);
        }       
    }


    /* NOTE: ADDING SE-PERCEPTS DIRECTLY BETWEEN AGENTS CIRCUMVENTS SYNTACTIC-TRANSLATION AND SO CANNOT BE PERFORMED HERE */
    @Override
    public boolean executeAction(String agName, Structure action) {
        Logger agentLogger = Logger.getLogger(agName);
        try{
            Term[] terms = new Term[action.getTerms().size()];
            int i=0;
            for(Term term : action.getTerms()){
                if(term instanceof VarTerm && term.isGround()){
                    terms[i] = ((VarTerm)term).getValue();
                }else{
                    terms[i] = term;
                }
                i++;
            }
            
            AgentModel agent = (AgentModel)model.getObjectById(new Atom(agName));       
            
            // Actions that can be performed by delivery vans
            if(agent instanceof DeliveryVanModel){
                DeliveryVanModel van = (DeliveryVanModel)agent;
                if(action.getFunctor().equals("load")){
                    van.load((Atom)terms[0]);
                }else if(action.getFunctor().equals("unload")){
                    van.unload((Atom)terms[0]);         
                }else if(action.getFunctor().equals("move_towards")){
                    van.moveTowards(
                            new Point(
                                    (int)((NumberTermImpl)terms[0]).solve(),
                                    (int)((NumberTermImpl)terms[1]).solve()));
                }else{
                    throw new AgentModelException("Unknown action");
                }
            }
            
            if(agent instanceof ShopModel){
                ShopModel shop = (ShopModel)agent;
                if(action.getFunctor().equals("deploy")){
                    shop.deploy((Atom)terms[0], shop.getProductByBrand(terms[1].toString()), (int)((NumberTerm)terms[2]).solve());
                }
            }
            
            if(agent instanceof CustomerModel){
                CustomerModel customer = (CustomerModel)agent;
                if(action.getFunctor().equals("request_product")){
                    customer.request(terms[0].toString(), terms[1].toString(), (int)((NumberTerm)terms[2]).solve());
                }
                if(action.getFunctor().equals("confirm_order")){
                    customer.confirm_order();
                }
                if(action.getFunctor().equals("approve")){
                    return customer.approve(terms[0].toString());
                }
                if(action.getFunctor().equals("message")){
                    customer.message(terms[0].toString());
                }
            }
            
            
            
        }catch(AgentModelException e){
            agentLogger.info("Unable to complete action "+action+". Reason: ");
            e.printStackTrace();            
            return false;    
        }finally{
            updatePercepts();
        }
        agentLogger.fine("Completed action "+action);
        return true;
    }

    /** Called before the end of MAS execution */
    @Override
    public void stop() {
        super.stop();
    }
    
}

