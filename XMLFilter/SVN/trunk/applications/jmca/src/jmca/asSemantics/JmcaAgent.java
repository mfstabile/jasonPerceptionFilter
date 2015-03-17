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
package jmca.asSemantics;

import static jmca.util.Common.DELIM;
import static jmca.util.Common.strip;
import jason.JasonException;
import jason.architecture.AgArch;
import jason.asSemantics.ActionExec;
import jason.asSemantics.Agent;
import jason.asSemantics.Event;
import jason.asSemantics.Intention;
import jason.asSemantics.Message;
import jason.asSemantics.Option;
import jason.asSemantics.TransitionSystem;
import jason.bb.BeliefBase;
import jason.runtime.Settings;

import java.lang.reflect.Constructor;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Queue;
import java.util.Vector;

import jmca.mediation.MediationStrategy;
import jmca.selection.SelectionStrategy;
import jmca.util.Common;
import jmca.util.JMCAParams;
import jmca.util.JmcaException;


/**
 * "Jason Module Composition Architecture"<p>
 * 
 * Overrides Jason Agent selection functions to provide modular composition services.
 * Agents wishing to make use of JMCA should extend this class<p>
 * 
 * An aspect is (currently) one of: Option, Message, Intention, Event, ActionExec and are identified by their Java class.<p>
 * 
 * Each step in a composition chain is known as an "selection strategy". AgentModules select an "agreed" set of aspects, mediated 
 * by the "mediation strategy". Each aspect type has its own composition chain and mediation strategy.<p>
 * <p>
 * This class is responsible for:
 * <ul>
 *  <li>initialising and managing selection and mediation strategies</li>
 *  <li>overriding key Jason Agent methods to interface with JMCA</li>
 * </ul>
 * 
 * @author Tom Klapiscak
 *
 */
public class JmcaAgent extends jason.asSemantics.Agent {
    
    private static String DEFAULT_MEDIATION_STRATEGY_CLASS = "jmca.mediation.OverrulingIntersection";   
    private static String PARAM_DELIM = "_";
    private static String PARAM_PREFIX = "jmca"+PARAM_DELIM;        
    
    /**
     * Maps aspect type to the list of selection strategies instantiated for it
     */
    private HashMap<Class, List<SelectionStrategy>> aspectSelectionStrategyMap;
    
    /**
     * Maps aspect type to its mediation strategy
     */
    private HashMap<Class, MediationStrategy> aspectMediationStrategyMap;
    
    
    
    
    /**
     * Instantiates selection and mediation strategies for this JmcaAgent, then calls Jason's default initAg method
     */
    @SuppressWarnings("unchecked")
    @Override
    public void initAg(String asSrc) throws JasonException{
        aspectSelectionStrategyMap = new HashMap<Class, List<SelectionStrategy>>();
        aspectMediationStrategyMap = new HashMap<Class, MediationStrategy>();
        TransitionSystem ts = getTS();
        for(Class aspect : JMCAParams.aspects){
            aspectSelectionStrategyMap.put(aspect, getSelectionStrategyClasses(this, ts.getUserAgArch(), getBB(), asSrc, ts.getSettings(), aspect));
            aspectMediationStrategyMap.put(aspect, getMediationStrategyClass(ts.getSettings(), aspect));
        }
        super.initAg(asSrc);
    }
    

    /**
     * Apply module composition to the Option aspect
     * May be passed a null Option list if events=retrieve is set, if so, an empty list is instantiated to allow for generated Options
     */
    public Option selectOption(List<Option> options){
        if(options == null){ // if events=retrieve, option list may be null
            options = new Vector<Option>();
        }
        getLogger().finest("Options: "+options);
        return (Option)apply(Option.class, options);
    }
    
    /**
     * Apply module composition to the ActionExec aspect
     */
    public ActionExec selectAction(List<ActionExec> actions){
        getLogger().finest("Actions: "+actions);
        return (ActionExec)apply(ActionExec.class, actions);
    }

    /**
     * Apply module composition to the Message aspect
     */
    public Message selectMessage(Queue<Message> messages){
        getLogger().finest("Messages: "+messages);
        return (Message)apply(Message.class, messages);     
    }
    
    /**
     * Apply module composition to the Event aspect
     */
    public Event selectEvent(Queue<Event> events){
        getLogger().finest("Events: "+events);
        return (Event)apply(Event.class, events);   
    }
    
    /**
     * Apply module composition to the Intention aspect
     */
    public Intention selectIntention(Queue<Intention> intentions){
        getLogger().finest("Intentions: "+intentions);
        return (Intention)apply(Intention.class, intentions);
    }
    
    /**
     * Applies mediation strategies for all selection strategies of this aspect and returns the first aspect from the "agreed" set
     * 
     * @param aspect        the aspect type we are applying a mediation strategy to
     * @param aspects       a collection of aspects we are applingy a mediation strategy to - collection allows lists and queues to be passed
     * @return              the first aspect present within the "agreed" set.
     */
    @SuppressWarnings("unchecked")
    private Object apply(Class aspect, Collection aspects){
        MediationStrategy strategy = aspectMediationStrategyMap.get(aspect);
        List<SelectionStrategy> modules = aspectSelectionStrategyMap.get(aspect);   
        List asList = new Vector(); // auxilliary list required since aspects could be a queue or a list
        asList.addAll(aspects);
        try{
            asList = strategy.apply(modules, asList);
        }catch(JmcaException e){
            getLogger().severe("Error in jmca "+getUCN(aspect)+" selection. Reason: ");
            e.printStackTrace();
            return null;
        }
        if(asList.isEmpty()){
            return null;
        }else{
            Object selected = asList.remove(0);
            aspects.remove(selected); // affect master queue
            return selected;
        }
    }

    /**
     * Instantiates (using Java Reflect) the mediation strategy implementation class speficied in the JmcaAgent's .mas2j file.
     * If none present, the defaultmediation strategy class is used.
     * 
     * @param stts              .mas2j settings of this JmcaAgent
     * @param aspect            the type of aspect we are instantiating this mediation strategy for
     * @return                  the mediation strategy instance
     * @throws JmcaException    if instantiation fails
     */
    private static MediationStrategy getMediationStrategyClass(Settings stts, Class aspect) throws JmcaException{
        MediationStrategy strategy;
        String paramName = PARAM_PREFIX+getUCN(aspect)+PARAM_DELIM+"mediation"+PARAM_DELIM+"strategy";
        String param = stts.getUserParameter(paramName);
        if(param == null){ // if none specified, use default
            param = DEFAULT_MEDIATION_STRATEGY_CLASS;
        }else{
            param = strip(param, "\"");
		}
		try {
			Class cls = Class.forName(param);
			Constructor ct = cls.getConstructor(new Class[] {});
			strategy = (MediationStrategy)ct.newInstance();		
			strategy.init(stts);
		}
		catch (Throwable e) {
			throw new JmcaException("Error instantiating "+getUCN(aspect)+" mediation strategy class. Reason: "+e);
		}			
		return strategy;
	}
	
	/**
	 * Instantiates (using Java Reflect), based on .mas2j parameters, the selection strategy composition chain for a particular type of aspect
	 * 
	 * @param agent				the JmcaAgent these selection strategies are to be associated with (passed to module for later use)
	 * @param arch				the AgArch of the JmcaAgent (used for strategy initialisation)
	 * @param bb				the BeliefBase of the JmcaAgent (used for strategy initialisation)
	 * @param asSrc				the AgentSpeak source of the JmcaAgent (used for strategy initialisation)
	 * @param stts				the .mas2j settings of the JmcaAgent (used for strategy initialisation)
	 * @param aspect			the type of aspect for which we are instantiating this selection strategy composition chain
	 * @return					a list of selection strategies representing the composition chain for this type of aspect
	 * @throws JmcaException	if selection strategies instantiation fails
	 * @throws JasonException	if selection strategies initialisation fails
	 */
	private static List<SelectionStrategy> getSelectionStrategyClasses(Agent agent, AgArch arch, BeliefBase bb, String asSrc, Settings stts, Class aspect) throws JmcaException, JasonException{		
		List<SelectionStrategy> strategies = new Vector<SelectionStrategy>();
		String paramName = PARAM_PREFIX+getUCN(aspect)+PARAM_DELIM+"selection"+PARAM_DELIM+"strategies";
		String param = stts.getUserParameter(paramName);
		if(param != null){ // no AgentModules specific for this aspect
			for(String strategyClassName : Common.strip(param, "\"").split(DELIM)){
                strategyClassName = strategyClassName.trim();
                SelectionStrategy strategy = null;
                // use java reflect to instantiate agent module class
                try {
                    Class cls = Class.forName(strategyClassName);
                    Constructor ct = cls.getConstructor(new Class[] {Agent.class});
                    strategy = (SelectionStrategy)ct.newInstance(new Object[] {agent});
                }
                catch (Throwable e) {
                    throw new JmcaException("Error instantiating "+getUCN(aspect)+" selection strategy class "+strategyClassName+". Reason: "+e);
                }
                strategies.add(strategy);
            }
        }
        return strategies;
    }
    
    /**
     * Gets the unqualified (bit after last .) class name of a class
     * @param aspect    the class to get the unqualified name of
     * @return          the unqualified name of the supplied class
     */
    private static String getUCN(Class aspect){
        String name =  aspect.getName();
        if(name.contains(".")){
            name = name.substring(name.lastIndexOf(".")+1);
        }
        return name;
    }   
    
}
