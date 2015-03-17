package jason.eis;

import static jason.eis.Translator.literalToAction;
import static jason.eis.Translator.perceptToLiteral;
import jason.JasonException;
import jason.asSyntax.ASSyntax;
import jason.asSyntax.Literal;
import jason.asSyntax.StringTerm;
import jason.asSyntax.Structure;
import jason.asSyntax.Term;
import jason.environment.Environment;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import eis.AgentListener;
import eis.EILoader;
import eis.EnvironmentInterfaceStandard;
import eis.EnvironmentListener;
import eis.exceptions.ActException;
import eis.iilang.EnvironmentState;
import eis.iilang.Parameter;
import eis.iilang.Percept;


/**
 * This class adapts an EIS environment to be used as a Jason environment
 * (see http://cig.in.tu-clausthal.de/eis)
 * 
 * @author Jomi
 */
public class EISAdapter extends Environment implements AgentListener {

    private Logger logger = Logger.getLogger("EISAdapter."+EISAdapter.class.getName());

    private EnvironmentInterfaceStandard ei; 
    
    public EISAdapter() {
        super(20);
    }
    
    /** Called before the MAS execution with the args informed in .mas2j */
    @Override
    public void init(String[] args) {
        if (args.length == 0) {
            logger.warning("The jar file with the EIS environment have to be informed as parameter!");
            return;
        }
        try {
            ei = EILoader.fromJarFile( new File(args[0]) );
            
            ei.attachEnvironmentListener(new EnvironmentListener() {
                @Override
                public void handleNewEntity(String entity) {
                    //logger.info("new entity "+entity);
                }
                @Override
                public void handleStateChange(EnvironmentState s) {
                    logger.info("new state "+s);
                }
                @Override
                public void handleDeletedEntity(String arg0, Collection<String> arg1) {
                }
                @Override
                public void handleFreeEntity(String arg0, Collection<String> arg1) {
                }
            });
            
            
            //LinkedList<Parameter> initArgs    = new LinkedList<Parameter>();
            Map<String,Parameter> initMapArgs = new HashMap<String, Parameter>();
            List<String[]>        agEnt       = new ArrayList<String[]>();
            
            // identify initial paramaters
            for (int i=1; i<args.length; i++) {
                Term t = ASSyntax.parseTerm(args[i]);
                if (t.isStructure()) {
                    Structure arg = (Structure)t;
                    if (arg.getFunctor().equals("agent_entity")) {
                        agEnt.add(new String[] {arg.getTerm(0).toString(), arg.getTerm(1).toString() } );
                    } else if (arg.getFunctor().equals("map")) {
                        String k = arg.getTerm(0).toString();
                        if (k.startsWith("\""))
                            k = k.substring(1,k.length()-1);
                        initMapArgs.put(k, Translator.termToParameter( arg.getTerm(1)) );
                    }
                }
            }
            if (ei.isInitSupported()) {
                ei.init(initMapArgs);
            } else if (! initMapArgs.isEmpty()) {
                logger.warning("Init parameters are not supported by this EIS environment!");
            }
            
            try {
                if (ei.getState() != EnvironmentState.PAUSED)
                    ei.pause(); // EIS requires a pause before running
            } catch (Exception e) {
                e.printStackTrace();
            }

            // if no association is given, use agent name = entity name
            if (agEnt.isEmpty()) {
                for(String e: ei.getEntities()) {
                    try {
                        ei.registerAgent(e);
                        ei.attachAgentListener(e, this);
                        ei.associateEntity(e, e);
                    } catch (Exception ex) {
                        logger.log(Level.SEVERE,"Error associating entity "+e,ex);
                    }
                }
            } else {
            // associate agents to entities
                for (String[] p: agEnt) {
                    String agName = p[0];
                    if (!ei.getAgents().contains(agName)) {
                        ei.registerAgent(agName);
                        ei.attachAgentListener(agName, this);
                    }
                    //System.out.println("Associating "+agName+" with "+arg.getTerm(1));
                    try {
                        ei.associateEntity(agName, p[1].toString());
                    } catch (Exception ex) {
                        logger.log(Level.SEVERE,"Error associating entity "+agName+" to "+p[1],ex);
                        logger.info("Entities are:"+ei.getEntities());
                    }
                }
            }

            if (ei.isStartSupported())
                ei.start();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // method of AgentListener interface
    public void handlePercept(String agent, Percept percept) {        
        try {
            addPercept(agent, perceptToLiteral(percept));
        } catch (JasonException e) {
            e.printStackTrace();
        }
        informAgsEnvironmentChanged(agent); // wake up the agent
    }

    // special method for EISMASSIM
    public void handlePercept(String agent, Collection<Percept> percepts) {        
        try {
            clearPercepts(agent);
            Literal[] jasonPers = new Literal[percepts.size()];
            int i = 0;
            for (Percept p: percepts)
                jasonPers[i++] = perceptToLiteral(p);
            addPercept(agent, jasonPers);
            informAgsEnvironmentChanged(agent); // wake up the agent
        } catch (JasonException e) {
            e.printStackTrace();
        }
    } 

    @Override
    public List<Literal> getPercepts(String agName) {
        return addEISPercept(super.getPercepts(agName),agName);
    }

    
    protected List<Literal> addEISPercept(List<Literal> percepts, String agName) {
        clearPercepts(agName);
        if (percepts == null) 
            percepts = new ArrayList<Literal>();
        
        if (ei != null) {
            try {
                Map<String,Collection<Percept>> perMap = ei.getAllPercepts(agName);
                for (String entity: perMap.keySet()) {
                    Structure strcEnt = ASSyntax.createStructure("entity", ASSyntax.createAtom(entity));
                    for (Percept p: perMap.get(entity)) {
                        percepts.add(perceptToLiteral(p).addAnnots(strcEnt));
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return percepts;        
    }
    
    @Override
    public boolean executeAction(String agName, Structure action) {
        //checkAgRegistry(agName);
        if (ei == null) {
            logger.warning("There is no environment loaded! Ignoring action "+action);
            return false;
        }
        try {
            // check case of action on an entity: ae(<action>,<entity as string>)
            if (action.getArity() == 2 && action.getFunctor().equals("ae") && action.getTerm(1).isString()) {
                String entity = ((StringTerm)action.getTerm(1)).getString();
                //System.out.println(agName+" doing "+action.getTerm(0)+" as "+entity);
                ei.performAction(agName, literalToAction((Literal)action.getTerm(0)), entity);                  
            } else {
                //Map<String,Percept> r = 
                ei.performAction(agName, literalToAction(action));
                //logger.info("***"+r+" for "+action);
            }
            //for (ActionResult r: result) {
            //    if (r.getName().equals("success")) 
            return true;
            //}
        } catch (ActException e) {
            //e.printStackTrace();
            logger.warning("Error in action '"+action+"' by "+agName+": "+e);
        } 
        return false;
    }

    /** Called before the end of MAS execution */
    @Override
    public void stop() {
        if (ei != null) {
            try {
                if (ei.isKillSupported())
                    ei.kill();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        super.stop();
    }
    
    /** register an agent if not registered yet */
    /*
    protected synchronized void checkAgRegistry(final String agName) {
        if (!ei.getAgents().contains(agName)) { // if the agent is not registered yet, register
            try {
                System.out.println("registering "+agName);
                ei.registerAgent(agName);
                for (String entity: ei.getEntities()) 
                    ei.associateEntity(agName, entity);
                ei.attachAgentListener(agName, new AgentListener() {
                   public void handlePercept(String agent, Percept percept) {
                       // wake up the agent
                       informAgsEnvironmentChanged(agName);
                    } 
                });
            } catch (Exception e) {
                e.printStackTrace();
            }
        }        
    }
    */
    
}
