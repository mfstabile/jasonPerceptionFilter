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
package jasdl.bridge;

import static jasdl.util.JASDLCommon.strip;
import jasdl.JASDLParams;
import jasdl.bridge.factory.AliasFactory;
import jasdl.bridge.factory.AxiomToSELiteralConverter;
import jasdl.bridge.factory.SELiteralFactory;
import jasdl.bridge.factory.SELiteralToAxiomConverter;
import jasdl.bridge.mapping.aliasing.Alias;
import jasdl.bridge.mapping.aliasing.AliasManager;
import jasdl.bridge.mapping.aliasing.AllDifferentPlaceholder;
import jasdl.bridge.mapping.aliasing.DefinitionManager;
import jasdl.bridge.mapping.aliasing.MappingStrategy;
import jasdl.bridge.mapping.label.LabelManager;
import jasdl.bridge.mapping.label.OntologyURIManager;
import jasdl.util.exception.JASDLDuplicateMappingException;
import jasdl.util.exception.JASDLException;
import jasdl.util.exception.JASDLInvalidSELiteralException;
import jasdl.util.exception.JASDLUnknownMappingException;
import jasdl.util.owlapi.parsing.NsPrefixOWLEntityChecker;
import jasdl.util.owlapi.parsing.URIOWLEntityChecker;
import jasdl.util.owlapi.rendering.NsPrefixOWLObjectShortFormProvider;
import jasdl.util.owlapi.rendering.URIOWLObjectShortFormProvider;
import jason.asSyntax.Atom;
import jason.asSyntax.Literal;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.Vector;
import java.util.logging.Logger;

import org.apache.commons.logging.impl.Log4JLogger;
import org.coode.manchesterowlsyntax.ManchesterOWLSyntaxDescriptionParser;
import org.mindswap.pellet.owlapi.Reasoner;
import org.semanticweb.owl.apibinding.OWLManager;
import org.semanticweb.owl.inference.OWLReasoner;
import org.semanticweb.owl.inference.OWLReasonerException;
import org.semanticweb.owl.model.AddAxiom;
import org.semanticweb.owl.model.OWLAnnotation;
import org.semanticweb.owl.model.OWLAxiom;
import org.semanticweb.owl.model.OWLClass;
import org.semanticweb.owl.model.OWLDataFactory;
import org.semanticweb.owl.model.OWLDescription;
import org.semanticweb.owl.model.OWLEntity;
import org.semanticweb.owl.model.OWLEquivalentClassesAxiom;
import org.semanticweb.owl.model.OWLException;
import org.semanticweb.owl.model.OWLIndividual;
import org.semanticweb.owl.model.OWLIndividualAxiom;
import org.semanticweb.owl.model.OWLOntology;
import org.semanticweb.owl.model.OWLOntologyChangeException;
import org.semanticweb.owl.model.OWLOntologyCreationException;
import org.semanticweb.owl.model.OWLOntologyManager;
import org.semanticweb.owl.model.RemoveAxiom;

import uk.ac.manchester.cs.owl.OWLLabelAnnotationImpl;
import uk.ac.manchester.cs.owl.mansyntaxrenderer.ManchesterOWLSyntaxOWLObjectRendererImpl;

/**
 *  
 * @author Tom Klapiscak
 *
 */
public class JASDLOntologyManager {

    private Logger logger;

    private OWLOntologyManager ontologyManager;

    private AliasManager aliasManager;

    private LabelManager labelManager;

    private OntologyURIManager logicalURIManager;

    private OntologyURIManager physicalURIManager;

    private OWLReasoner reasoner;

    private URI personalOntologyURI;

    private DefinitionManager definitionManager;

    private ManchesterOWLSyntaxOWLObjectRendererImpl manchesterNsPrefixOWLObjectRenderer;

    private ManchesterOWLSyntaxOWLObjectRendererImpl manchesterURIOWLObjectRenderer;

    private ManchesterOWLSyntaxDescriptionParser manchesterNsPrefixDescriptionParser;

    private ManchesterOWLSyntaxDescriptionParser manchesterURIDescriptionParser;    

    private SELiteralFactory seLiteralFactory;
    
    private AxiomToSELiteralConverter axiomToSELiteralConverter;

    private SELiteralToAxiomConverter SELiteralToAxiomConverter;
    
    private boolean annotationGatheringEnabled;
    

    public JASDLOntologyManager(Logger logger) throws OWLException{
        this.logger = logger;
        this.personalOntologyURI = URI.create("http://self.ontology/default.owl");
        aliasManager = new AliasManager();
        labelManager = new LabelManager();
        ontologyManager = OWLManager.createOWLOntologyManager();
        physicalURIManager = new OntologyURIManager();
        logicalURIManager = new OntologyURIManager();
        
        seLiteralFactory = new SELiteralFactory(this);
        SELiteralToAxiomConverter = new SELiteralToAxiomConverter(this);
        axiomToSELiteralConverter = new AxiomToSELiteralConverter(this);

        definitionManager = new DefinitionManager();

        manchesterURIOWLObjectRenderer = new ManchesterOWLSyntaxOWLObjectRendererImpl();
        manchesterURIOWLObjectRenderer.setShortFormProvider(new URIOWLObjectShortFormProvider(this));

        manchesterNsPrefixOWLObjectRenderer = new ManchesterOWLSyntaxOWLObjectRendererImpl();
        manchesterNsPrefixOWLObjectRenderer.setShortFormProvider(new NsPrefixOWLObjectShortFormProvider(this));

        manchesterNsPrefixDescriptionParser = new ManchesterOWLSyntaxDescriptionParser(getOntologyManager().getOWLDataFactory(), new NsPrefixOWLEntityChecker(this));
        manchesterURIDescriptionParser = new ManchesterOWLSyntaxDescriptionParser(getOntologyManager().getOWLDataFactory(), new URIOWLEntityChecker(this));

        
    }
    
    /**
     * Calls {@link JASDLOntologyManager#getOWLIndividual(URI)}} converting uri to an alias.
     * Default mapping strategies are applied.
     * 
     * @see JASDLOntologyManager#toAlias(URI,List)
     * @see JASDLParams#DEFAULT_MAPPING_STRATEGIES
     * @param uri
     * @return
     * @throws JASDLException
     */
    public OWLIndividual getOWLIndividual(URI uri) throws JASDLException{
        return getOWLIndividual(toAlias(uri, JASDLParams.DEFAULT_MAPPING_STRATEGIES));
    }
    
    /**
     * Search across all known ontologies for an individual with the functor of alias (Individuals are global between ontology instances, wrt functor).
     * If not found, instantiate a new individual according to the functor and label of alias.
     * @param alias
     * @return
     */
    public OWLIndividual getOWLIndividual(Alias alias) throws JASDLException{
        OWLIndividual i = null;
        
        // search across all known ontologies for an individual by this name (functor only)     
        for(OWLOntology tryOntology : getReasoner().getLoadedOntologies()){
            try{
                i = (OWLIndividual) getAliasManager().getRight(
                        AliasFactory.INSTANCE.create(
                                alias.getFunctor(),
                                getLabelManager().getLeft(tryOntology)));
            }catch(JASDLUnknownMappingException e){             
            }
        }   
        
        
        // we can't find one, define a new individual within the ontology referenced by this SE-Literal     
        if(i == null){
            // get the ontology of this SE-Literal
            OWLOntology ontology = getLabelManager().getRight(alias.getLabel());
            
            // instantiate a new alias mapping for this individual
            URI uri = URI.create(ontology.getURI() + "#" + alias.getFunctor());
            
            getLogger().finest("Instantiating individual ("+alias+") "+uri);
            
            i = getOntologyManager().getOWLDataFactory().getOWLIndividual(uri);
            getAliasManager().put(alias, i);
            
            // create a semantically-meaningless empty annotation axiom so this individual is referenced within the ontology
            OWLAnnotation a = new OWLLabelAnnotationImpl(getOWLDataFactory(), getOWLDataFactory().getOWLTypedConstant(""));
            OWLAxiom axiom = getOWLDataFactory().getOWLEntityAnnotationAxiom(i, a);
            try {
                getOntologyManager().applyChange(new AddAxiom(ontology, axiom)); // <- add this "redundant" axiom to ensure we have a reference to this individuals in the ontology (for toEntity method and description parsing)
                refreshReasoner();
            } catch (Exception e) {
                throw new JASDLException("Error instantiating owl individual from " + alias, e);
            }
        }
        
        return i;
    }
    
    /**
     * Gets the alias corresponding to a URI. URI corresponds to a known entity, its alias is returned.
     * Otherwise, the label is taken from (scheme concat scheme specific part) and the functor from the fragment (minus the #).
     * Additionally, applied default mapping strategies to URI fragment to prevent invalid functors being generated.
     * 
     * Note: Ontology referenced by URI must be a known ontology!
     * @param uri
     * @return
     */
    public Alias toAlias(URI uri, List<MappingStrategy> strategies) throws JASDLUnknownMappingException{
        try {
            OWLEntity entity = toEntity(uri);
            return getAliasManager().getLeft(entity);
        } catch (JASDLUnknownMappingException e) {
            // unknown uri, create a new alias
            OWLOntology ontology = getLogicalURIManager().getLeft(URI.create(uri.getScheme() + ":" + uri.getSchemeSpecificPart()));
            Atom label = getLabelManager().getLeft(ontology);           
            String _functor = uri.getFragment();
            
            // apply mapping strategies to fragment of URI to generate a valid functor
            for (MappingStrategy strategy : strategies) {
                _functor = strategy.apply(_functor);
            }
            return AliasFactory.INSTANCE.create(new Atom(_functor), label);
            
        }
    }
    
    
    public List<Literal> getAllSELiterals() throws JASDLException{
        List<Literal> bels = new Vector<Literal>();
        for (OWLOntology ontology : getOntologyManager().getOntologies()) {
            for (OWLIndividualAxiom axiom : ontology.getIndividualAxioms()) {
                Literal l = getAxiomToSELiteralConverter().convert(axiom).getLiteral();
                bels.add(l);
            }
        }
        return bels;
    }
    
    public void setAnnotationGatheringEnabled(boolean b) {
        this.annotationGatheringEnabled = b;
    }
    
    public boolean isAnnotationGatheringEnabled() {
        return annotationGatheringEnabled;
    }
    
    public SELiteralFactory getSELiteralFactory(){
        return seLiteralFactory;
    }

    public Atom getPersonalOntologyLabel() {
        return new Atom("self");
    }

    public URI getPersonalOntologyURI() {
        return personalOntologyURI;
    }

    public void setPersonalOntologyURI(URI personalOntologyURI) {
        this.personalOntologyURI = personalOntologyURI;
    }
    
    public SELiteralToAxiomConverter getSELiteralToAxiomConverter() {
        return SELiteralToAxiomConverter;
    }

    public AxiomToSELiteralConverter getAxiomToSELiteralConverter() {
        return axiomToSELiteralConverter;
    }

    /**
     * Convenience method to (polymorphically) create an entity from resource URI (if known).
     * TODO: where should this sit?
     * @param uri   URI of resource to create entity from
     * @return      entity identified by URI
     * @throws UnknownReferenceException    if OWLObject not known
     */
    public OWLEntity toEntity(URI uri) throws JASDLUnknownMappingException {
        URI ontURI;
        try {
            ontURI = new URI(uri.getScheme(), uri.getSchemeSpecificPart(), null);
        } catch (URISyntaxException e) {
            throw new JASDLUnknownMappingException("Invalid entity URI " + uri, e);
        }
        OWLOntology ontology = getLogicalURIManager().getLeft(ontURI);
        // clumsy approach, but I can't find any way of achieving this polymorphically (i.e. retrieve an OWLEntity from a URI) using OWL-API
        OWLEntity entity;
        if (ontology.containsClassReference(uri)) {
            entity = getOntologyManager().getOWLDataFactory().getOWLClass(uri);
        } else if (ontology.containsObjectPropertyReference(uri)) {
            entity = getOntologyManager().getOWLDataFactory().getOWLObjectProperty(uri);
        } else if (ontology.containsDataPropertyReference(uri)) {
            entity = getOntologyManager().getOWLDataFactory().getOWLDataProperty(uri);
        } else if (ontology.containsIndividualReference(uri)) {
            entity = getOntologyManager().getOWLDataFactory().getOWLIndividual(uri);
        } else {
            throw new JASDLUnknownMappingException("Unknown ontology resource URI: " + uri);
        }
        return entity;
    }

    /**
     * Convenience method to parse a string into a URI and return the associated ontology.
     * Ontology is instantiated and assigned a unique anonymous label if unknown.
     * @param uri
     * @return
     * @throws JASDLException
     */
    public OWLOntology getOntology(String _uri) throws JASDLUnknownMappingException {
        URI uri;
        try {
            uri = new URI(strip(_uri, "\"")); // quotes stripped
			return getOntology(uri);
		} catch (URISyntaxException e) {
			throw new JASDLUnknownMappingException("Invalid physical ontology URI " + _uri, e);
		}
	}

	/**
	 * Convenience method to return the ontology associated with a URI.
	 * Ontology is instantiated and assigned a unique anonymous label if unknown.
	 * @param uri
	 * @return
	 * @throws JASDLException
	 */
	public OWLOntology getOntology(URI uri) throws JASDLUnknownMappingException {
		return getPhysicalURIManager().getLeft(uri);
	}

	public Atom getAnonymousOntologyLabel() {
		String label;
		Atom labelAtom;
		int i = 0;
		while (true) {
			label = JASDLParams.ANON_LABEL_PREFIX + i;
			labelAtom = new Atom(label);
			if (!getLabelManager().isKnownLeft(labelAtom)) {
				break;
			}
			i++;
		}
		return labelAtom;
	}

	public OWLOntology loadOntology(String _uri, List<MappingStrategy> strategies) throws JASDLException {
		URI uri;
		try {
			uri = new URI(strip(_uri, "\"")); // quotes stripped
            return loadOntology(uri, strategies);
        } catch (URISyntaxException e) {
            throw new JASDLInvalidSELiteralException("Invalid physical ontology URI " + _uri, e);
        }
    }

    public OWLOntology loadOntology(URI uri, List<MappingStrategy> strategies) throws JASDLException {
        return loadOntology(getAnonymousOntologyLabel(), uri, strategies);
    }

    /**
     * Convenience method to instantiate an ontology, load it into reasoner and map it to a label.
     * Will not instantiate if ontology already known, either by physical or logical URI
     * Configured automapping strategies are applied here.
     * @param uri
     * @throws JASDLException
     */
    public OWLOntology loadOntology(Atom label, URI uri, List<MappingStrategy> strategies) throws JASDLException {
        //  simply return an already known (by PHYSICAL uri) ontology if available
        // simply return an already known (by LOGICAL uri) ontology if available
        try {
            return getOntology(uri);
        } catch (JASDLUnknownMappingException e) {
        }
        // not known by physical uri, load

        getLogger().fine("Loading ontology " + uri + " with label " + label);
        try {
            OWLOntology ontology = ontologyManager.loadOntologyFromPhysicalURI(uri);

            // simply return an already known (by LOGICAL uri) ontology if available
            try {
                return logicalURIManager.getLeft(ontology.getURI());
            } catch (JASDLUnknownMappingException e) {
            }

            // not yet known, load
            Set<OWLOntology> imports = ontologyManager.getImportsClosure(ontology);
            try {
                getReasoner().loadOntologies(imports);
                getReasoner().classify();
            } catch (OWLReasonerException e) {
                throw new JASDLException("Unable to load " + uri, e);
            }
            initOntology(ontology, label, uri, ontology.getURI(), false); // (successfully) loaded ontologies never personal            
            applyMappingStrategies(ontology, strategies);
            getLogger().fine("Loaded ontology from " + uri + " and assigned label " + label);
            
            
            return ontology;
        } catch (OWLOntologyCreationException e) {
            throw new JASDLException("Unable to load ontology", e);
        }
    }

    public OWLOntology createOntology(String _uri, boolean isPersonal) throws JASDLException {
        URI uri;
        try {
            uri = new URI(strip(_uri, "\"")); // quotes stripped
			return createOntology(uri, isPersonal);
		} catch (URISyntaxException e) {
			throw new JASDLInvalidSELiteralException("Invalid physical ontology URI " + _uri, e);
		}
	}

	public OWLOntology createOntology(URI uri, boolean isPersonal) throws JASDLException {
		return createOntology(getAnonymousOntologyLabel(), uri, isPersonal);
	}

	/**
	 * Creates and fully maps a blank ontology. Used for example for "owl" ontology, containing
	 * axioms referencing "owl:thing" and "owl:nothing", and for personal ontologies containing
	 * axioms referencing run-time defined anonymous classes.
	 * @param label
	 * @param uri
	 * @throws JASDLException
	 */
	public OWLOntology createOntology(Atom label, URI uri, boolean isPersonal) throws JASDLException {
		try {
			OWLOntology ontology = getOntologyManager().createOntology(uri);
			try {
				getReasoner().loadOntologies(Collections.singleton(ontology));
			} catch (OWLReasonerException e) {
				throw new JASDLException("Unable to load " + uri + ". Reason: " + e);
			}
			initOntology(ontology, label, uri, uri, isPersonal);
			return ontology;
		} catch (OWLOntologyCreationException e) {
			throw new JASDLException("Error instantiating OWL ontology. Reason: " + e);
		}
	}

	/**
	 * Common ontology initialisation functionality, sets up various mappings.
	 * @param ontology
	 * @param label
	 * @param physicalURI
	 * @param logicalURI
	 * @param isPersonal
	 * @throws JASDLException
	 */
	private void initOntology(OWLOntology ontology, Atom label, URI physicalURI, URI logicalURI, boolean isPersonal) throws JASDLException {
		getLogger().fine("Initialising ontology " + label + " with uri " + physicalURI);

		labelManager.put(label, ontology, isPersonal);

		physicalURIManager.put(ontology, physicalURI);
		logicalURIManager.put(ontology, logicalURI);
		// create the AllDifferent placeholder entity for this ontology
		getAliasManager().put(AliasFactory.INSTANCE.all_different(label), new AllDifferentPlaceholder(label)); // must be new instance to avoid duplicate mapping exceptions

	}

	/**
	 * When a duplicate mapping is encountered, an anonymous alias is created for the offending resource
	 * @param ontology
	 * @param strategies
	 * @throws JASDLException
	 */
	private void applyMappingStrategies(OWLOntology ontology, List<MappingStrategy> strategies) throws JASDLException {
		// we need to construct a reasoner specifically for this to isolate entities from just one ontology
		Reasoner reasoner = new Reasoner(getOntologyManager());
		Set<OWLOntology> imports = getOntologyManager().getImportsClosure(ontology);
		reasoner.loadOntologies(imports);

		List<OWLEntity> entities = new Vector<OWLEntity>();
		entities.addAll(reasoner.getClasses());
		entities.addAll(reasoner.getProperties());
		entities.addAll(reasoner.getIndividuals());

		Atom label = getLabelManager().getLeft(ontology);

		for (OWLEntity entity : entities) {
			try {
				String _functor = entity.getURI().getFragment();
				for (MappingStrategy strategy : strategies) {
					_functor = strategy.apply(_functor);
				}
				Atom functor = new Atom(_functor);
				getAliasManager().put(AliasFactory.INSTANCE.create(functor, label), entity);
			} catch (JASDLDuplicateMappingException e) {
				// generate an anonymous alias for this entity
				String functor;
				Alias anonAlias;
				int i = 0;
				while (true) {
					functor = JASDLParams.ANON_ALIAS_PREFIX + i;
					anonAlias = AliasFactory.INSTANCE.create(new Atom(functor), label);
					if (!getAliasManager().isKnownLeft(anonAlias)) {
						break;
					}
					i++;
				}
				getAliasManager().put(anonAlias, entity);
			}
		}
	}

	public OWLDescription defineClass(Atom functor, String expression, ManchesterOWLSyntaxDescriptionParser parser) throws JASDLException, OWLException {
		return defineClass(functor, getPersonalOntologyLabel(), expression, parser);
	}

	public OWLDescription defineClass(Atom functor, Atom label, String expression, ManchesterOWLSyntaxDescriptionParser parser) throws JASDLException, OWLException {
		Alias alias = AliasFactory.INSTANCE.create(functor, label);
		
		
		
	

		expression = expression.replace("\\\"", "\""); // drop quote escape characters
		
		getLogger().fine("Defining class "+label+" with expression "+expression);

		OWLDescription desc;
		try {
			getLogger().fine("Parsing expression: "+expression);
						
			desc = parser.parse(expression);
		} catch (Exception e) {
			throw new JASDLException("Could not parse expression " + expression, e);
		}
	
		
		if (getAliasManager().isKnownLeft(alias)) {
			// throw new DuplicateMappingException("New class definition with alias "+alias+" overlaps with an existing ontological entity");
			/** As of 14/04/2008 - new class definitions with clashing aliases override old ones */
			abolishDefinedClass(alias);
		}
		

		// We need this class to be named for parsing.
		// Create an equivalent class and add this instead with alias as fragment.
		// Clashes shouldn't be an issue here (thanks to distinct personal ontologies).
		OWLOntology ontology = getLabelManager().getRight(label);
		String _uri = getLogicalURIManager().getRight(ontology).toString();
		_uri += "#" + functor;
		URI uri = URI.create(_uri);
		OWLClass naming = getOWLDataFactory().getOWLClass(uri);
		OWLEquivalentClassesAxiom axiom = getOWLDataFactory().getOWLEquivalentClassesAxiom(naming, desc);
		try {
			getOntologyManager().applyChange(new AddAxiom(ontology, axiom));
		} catch (OWLOntologyChangeException e) {
			throw new JASDLException("Error adding " + uri + " naming of " + desc + " to " + label, e);
		}
		getLogger().fine("Adding named class " + uri + " for " + desc + " in " + label);
		getAliasManager().put(alias, naming); // consequence, we can no longer easily distinguish run-time defined classes from pre-defined - need to maintain a map
		getDefinitionManager().put(naming, desc);

		refreshReasoner();

		getLogger().fine("Defined new class with alias " + alias);
		return desc;
	}

	public void abolishDefinedClass(Alias alias) throws JASDLException, OWLException {
		OWLOntology ontology = getLabelManager().getRight(alias.getLabel());		
		
		OWLClass naming = (OWLClass) getAliasManager().getRight(alias);
		OWLDescription desc = (OWLDescription) getDefinitionManager().getRight(naming);	
		
		Set<OWLIndividual> instances = getReasoner().getIndividuals(naming, true);
		
		for(OWLIndividual instance : instances){
			OWLAxiom namingInstanceAxiom = getOWLDataFactory().getOWLClassAssertionAxiom(instance, naming);
			getOntologyManager().applyChange(new RemoveAxiom(ontology, namingInstanceAxiom));
			OWLAxiom descInstanceAxiom = getOWLDataFactory().getOWLClassAssertionAxiom(instance, desc);
			getOntologyManager().applyChange(new RemoveAxiom(ontology, descInstanceAxiom));
		}
		
		instances = getReasoner().getIndividuals(naming, false);		
		
		OWLAxiom axiom = getOWLDataFactory().getOWLEquivalentClassesAxiom(naming, desc);
		getOntologyManager().applyChange(new RemoveAxiom(ontology, axiom));

		getAliasManager().removeByLeft(alias);
		getDefinitionManager().removeByLeft(naming);
		
		refreshReasoner();

	}
	
	public void refreshReasoner() throws JASDLException{
		refreshReasoner(getReasoner());
	}

	public void refreshReasoner(OWLReasoner refresh) throws JASDLException {
		try {
			if (refresh instanceof uk.ac.manchester.cs.factplusplus.owlapi.Reasoner) {
				((uk.ac.manchester.cs.factplusplus.owlapi.Reasoner) getReasoner()).classify();
			} else if (refresh instanceof org.mindswap.pellet.owlapi.Reasoner) {
				((org.mindswap.pellet.owlapi.Reasoner) getReasoner()).refresh();
			} else {
				refresh.classify();
			}
		} catch (OWLReasonerException e) {
			throw new JASDLException("Unable to refresh reasoner. Reason: " + e);
		}

	}

	public void setReasonerLogLevel(org.apache.log4j.Level level) {
		try {
			if (getReasoner() instanceof org.mindswap.pellet.owlapi.Reasoner) {
				org.mindswap.pellet.owlapi.Reasoner pellet = (org.mindswap.pellet.owlapi.Reasoner) getReasoner();
				Log4JLogger abox_logger = (Log4JLogger) pellet.getKB().getABox().log;
				abox_logger.getLogger().setLevel(level);

				Log4JLogger taxonomy_logger = (Log4JLogger) pellet.getKB().getTaxonomy().log;
				taxonomy_logger.getLogger().setLevel(level);

				Log4JLogger kb_logger = (Log4JLogger) pellet.getKB().log;
				kb_logger.getLogger().setLevel(level);
			}
		} catch (JASDLException e) {
			getLogger().info("Unable to set reasoner log level. Reason:");
			e.printStackTrace();
		}
	}

	/**
	 *  For some reason, use of pellet's isConsistent(OWLOntology) method causes strange behaviour.
	 *  So we wrap its isConsistent() method here.
	 *  TODO: resolve this issue properly
	 * @return
	 * @throws JASDLException
	 */
	public boolean areOntologiesConsistent(OWLReasoner check) throws JASDLException {
		if (check instanceof org.mindswap.pellet.owlapi.Reasoner) {
			return ((org.mindswap.pellet.owlapi.Reasoner) check).isConsistent();
		} else {
			//TODO: FaCT++
			throw new JASDLException("isBBConsistent not implemented for FaCT++ reasoner");
		}
	}
	
	public boolean areOntologiesConsistent() throws JASDLException{
		return areOntologiesConsistent(getReasoner());
	}

	public OWLDataFactory getOWLDataFactory() {
		return getOntologyManager().getOWLDataFactory();
	}

	public void setLogger(Logger logger) {
		this.logger = logger;
	}

	public Logger getLogger() {
		return logger;
	}

	public OWLReasoner getReasoner() throws JASDLException {
		if (reasoner == null) {
			throw new JASDLException("No reasoner loaded");
		}
		return reasoner;
	}

	public void setReasoner(OWLReasoner reasoner) {
		this.reasoner = reasoner;
	}

	public AliasManager getAliasManager() {
		return aliasManager;
	}

	public LabelManager getLabelManager() {
		return labelManager;
	}

	public OntologyURIManager getLogicalURIManager() {
		return logicalURIManager;
	}

	public OWLOntologyManager getOntologyManager() {
		return ontologyManager;
	}

	public OntologyURIManager getPhysicalURIManager() {
		return physicalURIManager;
	}

	public ManchesterOWLSyntaxOWLObjectRendererImpl getManchesterURIOWLObjectRenderer() {
		return manchesterURIOWLObjectRenderer;
	}

	public ManchesterOWLSyntaxDescriptionParser getManchesterNsPrefixDescriptionParser() {
		return manchesterNsPrefixDescriptionParser;
	}

	public ManchesterOWLSyntaxDescriptionParser getManchesterURIDescriptionParser() {
		return manchesterURIDescriptionParser;
	}

	public ManchesterOWLSyntaxOWLObjectRendererImpl getManchesterNsPrefixOWLObjectRenderer() {
		return manchesterNsPrefixOWLObjectRenderer;
	}

	public DefinitionManager getDefinitionManager() {
		return definitionManager;
	}

}
