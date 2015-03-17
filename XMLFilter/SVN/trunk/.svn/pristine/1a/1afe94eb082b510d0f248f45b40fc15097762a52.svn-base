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
package jasdl.asSemantics;

import static jasdl.util.JASDLCommon.strip;
import jasdl.JASDLParams;
import jasdl.bridge.factory.AliasFactory;
import jasdl.bridge.mapping.aliasing.Alias;
import jasdl.bridge.mapping.aliasing.MappingStrategy;
import jasdl.util.JASDLCommon;
import jasdl.util.exception.JASDLConfigurationException;
import jasdl.util.exception.JASDLException;
import jason.asSyntax.Atom;
import jason.runtime.Settings;

import java.lang.reflect.Constructor;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.semanticweb.owl.inference.OWLReasoner;
import org.semanticweb.owl.model.OWLEntity;
import org.semanticweb.owl.model.OWLOntology;
import org.semanticweb.owl.model.OWLOntologyManager;

public class JASDLAgentConfigurator {

    /* Agent configuration */

    private HashMap<Atom, Float> trustMap;

    private boolean beliefRevisionEnabled;
    
    private boolean contractionEnabled;

    /** The mapping strategies this agent will use as its default - i.e. those applied to run-time instantiated ontologies or 
     * configuration time specified ontologies with no mapping strategies setting supplied
     */
    private List<MappingStrategy> defaultMappingStrategies = JASDLParams.DEFAULT_MAPPING_STRATEGIES;

    private JASDLAgent agent;

    public JASDLAgentConfigurator(JASDLAgent agent) {
        this.agent = agent;

        trustMap = new HashMap<Atom, Float>();
    }

    /**
     * Convenience method to run agent configuration routines that should be performed before agent initialisation
     */
    public void preInitConfigure(Settings stts) throws JASDLException {
        loadReasoner(stts);
        loadDefaultMappingStrategies(stts);
        setUseBeliefRevision(stts);
        setUseAnnotationGathering(stts);
        setUseContraction(stts);
        loadOntologies(stts);
        applyManualMappings(stts);      
        createOWLPlaceholderOntologies();
    }

    /**
     * Convenience method to run agent configuration routines that should be performed after agent initialisation
     */
    public void postInitConfigure(Settings stts) throws JASDLException {
        agent.getJom().setPersonalOntologyURI(URI.create("http://self.ontology/" + agent.getAgentName() + ".owl"));

        agent.getJom().setLogger(agent.getLogger()); // <- set logger now agent logger is initialised using agent name

        createSelfPlaceholderOntologies();
        
        loadTrustRatings(stts);

        // output initialisation details
        getLogger().fine("Using annotation gathering? " + isAnnotationGatheringEnabled());
        getLogger().fine("Using belief revision? " + isBeliefRevisionEnabled());

    }

    /**
     * create a "placeholder" ontology so we can safely map thing and nothing without actually loading the ontology
     * @throws JASDLException
     */
    private void createOWLPlaceholderOntologies() throws JASDLException {
        agent.getJom().createOntology(JASDLParams.OWL_THING.getLabel(), JASDLParams.OWL_URI, false);
        agent.getJom().getAliasManager().put(JASDLParams.OWL_THING, agent.getJom().getOntologyManager().getOWLDataFactory().getOWLThing());
        agent.getJom().getAliasManager().put(JASDLParams.OWL_NOTHING, agent.getJom().getOntologyManager().getOWLDataFactory().getOWLNothing());
    }

    /**
     * Create a personal ontology for (axioms that reference) run-time defined class
     * @throws JASDLException
     */
    public void createSelfPlaceholderOntologies() throws JASDLException {
        agent.getJom().createOntology(agent.getJom().getPersonalOntologyLabel(), agent.getJom().getPersonalOntologyURI(), true);
    }

    private Logger getLogger() {
        return agent.getLogger();
    }

    @SuppressWarnings("unchecked")
    private void loadReasoner(Settings stts) throws JASDLException {
        String reasonerClass;
        try {
            reasonerClass = prepareUserParameter(stts, JASDLParams.MAS2J_PREFIX + JASDLParams.MAS2J_REASONERCLASS);
        } catch (JASDLConfigurationException e) {
            reasonerClass = JASDLParams.DEFAULT_REASONER_CLASS;
        }
        try {
            Class cls = Class.forName(reasonerClass);
            Constructor ct = cls.getConstructor(new Class[] { OWLOntologyManager.class });

            // TODO: These cause error when generating explanations for:
            /*
             * +hotel(bennys)[o(travel), hotel_annotation];
             * +hasRating(bennys, threeStarRating)[o(travel), hasRating_annotation];
             * +luxuryHotel(bennys)[o(travel), luxuryHotel_annotation];
             * ?luxuryHotel(bennys)[o(travel), hotel_annotation, hasRating_annotation, luxuryHotel_annotation];
             * Use of Pellet tracing functionality is deprecated
             */
            //PelletOptions.USE_TRACING = true;
            //PelletOptions.USE_COMPLETION_QUEUE = true;
            //PelletOptions.USE_INCREMENTAL_CONSISTENCY = true;
            //PelletOptions.USE_SMART_RESTORE = false;          
            OWLReasoner reasoner = (OWLReasoner) ct.newInstance(new Object[] { agent.getJom().getOntologyManager() });
            // TODO: generalise. e.g. to agent.initReasoner(String className)
            //if(reasoner instanceof org.mindswap.pellet.owlapi.Reasoner){
            //  ((org.mindswap.pellet.owlapi.Reasoner)reasoner).getKB().setDoExplanation(true);
            // }            
            if (reasoner == null) {
                throw new JASDLException("Unknown reasoner class: " + reasonerClass);
            } else {
                agent.setReasoner(reasoner);
                agent.getJom().setReasonerLogLevel(org.apache.log4j.Level.FATAL);
            }
        } catch (Throwable e) {
            throw new JASDLException("Error instantiating reasoner " + reasonerClass + ". Reason: " + e);
        }
    }

    private void loadDefaultMappingStrategies(Settings stts) throws JASDLException {
        defaultMappingStrategies = getMappingStrategies(stts, new Atom("default")); //implication "default" is a reserved ontology label
    }

    private void setUseBeliefRevision(Settings stts) throws JASDLException {
        try {
            // set whether to use belief revision or not
            String useBeliefRevision = prepareUserParameter(stts, JASDLParams.MAS2J_PREFIX + JASDLParams.MAS2J_USEBELIEFREVISION);
            beliefRevisionEnabled = Boolean.parseBoolean(useBeliefRevision);
        } catch (JASDLConfigurationException e) {
            beliefRevisionEnabled = JASDLParams.DEFAULT_USEBELIEFREVISION;
        }
    }

    private void setUseAnnotationGathering(Settings stts) throws JASDLException {
        try {
            // set whether to use belief revision or not
            String useAnnotationGathering = prepareUserParameter(stts, JASDLParams.MAS2J_PREFIX + JASDLParams.MAS2J_USEANNOTATIONGATHERING);
            setAnnotationGatheringEnabled(Boolean.parseBoolean(useAnnotationGathering));
        } catch (JASDLConfigurationException e) {
            setAnnotationGatheringEnabled(JASDLParams.DEFAULT_USEANNOTATIONGATHERING);
        }
    }
    
    private void setUseContraction(Settings stts) throws JASDLException {
        try {
            // set whether to use belief revision or not
            String useContraction = prepareUserParameter(stts, JASDLParams.MAS2J_PREFIX + JASDLParams.MAS2J_USECONTRACTION);
            setContractionEnabled(Boolean.parseBoolean(useContraction));
        } catch (JASDLConfigurationException e) {
            setContractionEnabled(JASDLParams.DEFAULT_USECONTRACTION);
        }
    }

    public void setAnnotationGatheringEnabled(boolean b) {
        agent.getJom().setAnnotationGatheringEnabled(b);
    }

    /**
     * Load ontologies as specified in .mas2j settings
     * @param stts  .mas2j settings
     * @throws JASDLException   if instantiation of an ontology fails
     */
    private void loadOntologies(Settings stts) throws JASDLConfigurationException {
        String[] labels = splitUserParameter(stts, JASDLParams.MAS2J_PREFIX + JASDLParams.MAS2J_ONTOLOGIES);
        for (String label : labels) {
            if (JASDLParams.RESERVED_ONTOLOGY_LABELS.contains(label)) {
                throw new JASDLConfigurationException(label + " is a reserved ontology label");
            }
            String _uri = prepareUserParameter(stts, JASDLParams.MAS2J_PREFIX + "_" + label + JASDLParams.MAS2J_URI);
            URI uri = null;
            try {
                try {
                    uri = new URI(_uri);
                    if (!uri.isAbsolute()) {
                        throw new URISyntaxException("", "");
                    }
                } catch (URISyntaxException urie) {
                    uri = JASDLCommon.getRelativeLocalURI(_uri); // try relative path
                    agent.getLogger().fine("Loaded ontology " + uri + " from relative uri");
                }
                agent.getJom().loadOntology(new Atom(label), uri, getMappingStrategies(stts, new Atom(label)));
            } catch (Exception e) {
                String msg = "Unable to instantiate ontology \"" + _uri + "\" (" + label + ")";
                agent.getLogger().log(Level.SEVERE, msg, e);
                throw new JASDLConfigurationException(msg, e);
            }
        }
    }

    /**
     * Overrides auto mappings!
     * @param stts
     * @throws JASDLException
     */
    private void applyManualMappings(Settings stts) throws JASDLException {
        for (Atom label : agent.getJom().getLabelManager().getLefts()) {
            try {
                String[] mappings = splitUserParameter(stts, JASDLParams.MAS2J_PREFIX + "_" + label + JASDLParams.MAS2J_MAPPING_MANUAL);
                for (String mapping : mappings) {
                    OWLOntology ontology = agent.getJom().getLabelManager().getRight(label);
                    String[] split = mapping.split("=");
                    if (split.length == 2) {
                        Alias alias = AliasFactory.INSTANCE.create(new Atom(split[0].trim()), label);
                        URI uri = URI.create(ontology.getURI() + "#" + split[1].trim());
                        OWLEntity entity = agent.getJom().toEntity(uri);

                        if (agent.getJom().getAliasManager().isKnownRight(entity)) { // manual mappings override automatic ones
                            agent.getJom().getAliasManager().removeByRight(entity);
                        }

                        agent.getJom().getAliasManager().put(alias, entity);
                    }
                }
            } catch (JASDLConfigurationException e) {
                // manual mappings are optional
            }
        }
    }


    // TODO: set trust ratings for assertions predefined in ontology schema (maybe annotated with self)
    private void loadTrustRatings(Settings stts) throws JASDLException {
        // agent trusts itself completely!
        setTrustRating(new Atom("self"), 1f);
        for (String knownAgent : getKnownAgentNames()) {
            // load trust ratings (mandatory for known agents)
            float trustRating;
            try{
                String _trustRating = prepareUserParameter(stts, JASDLParams.MAS2J_PREFIX + "_" + knownAgent + JASDLParams.MAS2J_TRUSTRATING);
                trustRating = Float.parseFloat(_trustRating);   
                setTrustRating(new Atom(knownAgent), trustRating);
                agent.getLogger().fine("Setting trust rating of "+knownAgent+" to "+trustRating);
            } catch (NumberFormatException e) {
                throw new JASDLConfigurationException("Invalid trust rating for " + knownAgent, e);
            }catch (JASDLConfigurationException e){
                // set default trust rating - now performed when attempting to fetch trust rating for unknown agent
                //trustRating = JASDLParams.DEFAULT_TRUST_RATING;
            }           
        }
    }

    /**
     * Extracts mapping strategy related entries from .mas2j settings and applies to relevant ontologies.
     * Applies mappings to all resources in an ontology according to composition of supplied strategies.
     * @param stts  .mas2j settings
     */
    @SuppressWarnings("unchecked")
    private List<MappingStrategy> getMappingStrategies(Settings stts, Atom label) throws JASDLException {
        List<MappingStrategy> strategies = new Vector<MappingStrategy>();
        try {
            String[] strategyNames = splitUserParameter(stts, JASDLParams.MAS2J_PREFIX + "_" + label + JASDLParams.MAS2J_MAPPING_STRATEGIES);
            for (String strategyName : strategyNames) {
                try {
                    Class cls = Class.forName(strategyName);
                    Constructor ct = cls.getConstructor(new Class[] {});
                    MappingStrategy strategy = (MappingStrategy) ct.newInstance(new Object[] {});
                    if (strategy == null) {
                        throw new JASDLException("Unknown mapping strategy class: " + strategy);
                    } else {
                        strategies.add(strategy);
                    }
                } catch (Throwable e) {
                    throw new JASDLException("Error instantiating mapping strategy " + strategyName + ". Reason: " + e);
                }
            }
        } catch (JASDLConfigurationException e) {
            strategies = agent.getDefaultMappingStrategies(); // mapping strategies optional, use defaults if not set
        }
        return strategies;
    }

    /**
     * Convenience method to strip quotes and trim a .mas2j setting
     * @param stts  .mas2j settings
     * @param name  name of the setting to prepare
     * @return
     */
    private String prepareUserParameter(Settings stts, String name) throws JASDLConfigurationException {
        String p = stts.getUserParameter(name);
        if (p == null) {
            throw new JASDLConfigurationException(name + " is not set!");
        } else {
            return strip(p, "\"").trim();
		}
	}

	/**
	 * Convenience method to strip quotes, trim and split (by default delimiter) a .mas2j setting
	 * @param stts	.mas2j settings
	 * @param name	name of the setting to split
	 * @return
	 */
	private String[] splitUserParameter(Settings stts, String name, String delim) throws JASDLConfigurationException {
		String[] elems = prepareUserParameter(stts, name).split(delim);
		for (int i = 0; i < elems.length; i++) {
			elems[i] = strip(elems[i], "\"").trim();
        }
        return elems;
    }

    /**
     * Convenience method to strip quotes, trim and split (by default delimiter) a .mas2j setting
     * @param stts  .mas2j settings
     * @param name  name of the setting to split
     * @return
     */
    private String[] splitUserParameter(Settings stts, String name) throws JASDLConfigurationException {
        return splitUserParameter(stts, name, JASDLParams.DELIM);
    }

    public boolean isAnnotationGatheringEnabled() {
        return agent.getJom().isAnnotationGatheringEnabled();
    }

    public boolean isBeliefRevisionEnabled() {
        return beliefRevisionEnabled;
    }
    
    public boolean isContractionEnabled() {
        return contractionEnabled;
    }

    public List<MappingStrategy> getDefaultMappingStrategies() {
        return defaultMappingStrategies;
    }

    public HashMap<Atom, Float> getTrustMap() {
        return trustMap;
    }

    public void setTrustRating(Atom name, float trust) {
        trustMap.remove(name);
        trustMap.put(name, trust);
    }

    public Set<String> getKnownAgentNames(){
        return agent.getTS().getUserAgArch().getRuntimeServices().getAgentsNames();
    }

    public float getTrustRating(Atom name) {        
        Float rating = trustMap.get(name);
        if(rating == null){
            return JASDLParams.DEFAULT_TRUST_RATING;
        }else{
            return rating;
        }
    }

    public void setBeliefRevisionEnabled(boolean b) {
        this.beliefRevisionEnabled = b;
    }
    
    public void setContractionEnabled(boolean b) {
        this.contractionEnabled = b;
    }

}
