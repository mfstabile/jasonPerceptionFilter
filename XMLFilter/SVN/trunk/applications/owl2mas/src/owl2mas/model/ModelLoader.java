package owl2mas.model;

import jason.asSyntax.Atom;
import jason.environment.Environment;
import jason.runtime.Settings;

import java.lang.reflect.Constructor;
import java.net.URI;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.Map.Entry;

import org.semanticweb.owl.inference.OWLReasonerAdapter;
import org.semanticweb.owl.model.OWLAnnotation;
import org.semanticweb.owl.model.OWLClass;
import org.semanticweb.owl.model.OWLConstant;
import org.semanticweb.owl.model.OWLDataProperty;
import org.semanticweb.owl.model.OWLIndividual;
import org.semanticweb.owl.model.OWLObjectProperty;
import org.semanticweb.owl.model.OWLOntology;
import org.semanticweb.owl.model.OWLOntologyCreationException;

import owl2mas.OWL2MASLoader;
import owl2mas.exception.OWL2MASInvalidMASOntologyException;
import owl2mas.handler.ObjectPropertyHandler;

public class ModelLoader extends OWL2MASLoader{
    
    
    private Environment env;
    private Model model;

    public ModelLoader(Model model, Environment env){
        super();
        this.model = model;
        this.env = env;
    }
    
    public Set<ObjectModel> load(String socName, URI o_uri) throws OWL2MASInvalidMASOntologyException{
        Set<ObjectModel> objects = new HashSet<ObjectModel>();
        
        System.out.println("Loading "+o_uri);
        OWLOntology o;
        try {
            o = manager.loadOntology(o_uri);
        } catch (OWLOntologyCreationException e1) {
            throw new OWL2MASInvalidMASOntologyException(e1);
        }
        System.out.println("Loaded "+o_uri);
        Set<OWLOntology> importsClosure = manager.getImportsClosure(o);
        pellet.loadOntologies(importsClosure);
        pellet.classify();          
        
        String ns = o.getURI()+"#";
        
        
        // Get the society individual
        soc = factory.getOWLIndividual(URI.create(ns + socName));
        
        // Get agents
        Set<OWLIndividual> agents = pellet.getRelatedIndividuals(
                soc,
                factory.getOWLObjectProperty(URI.create(MAS_NS + "hasAgent")));
        
        URI aClassURI = URI.create(MAS_NS + "AgentClass");
        
        for(OWLIndividual agent : agents){
            OWLClass agentType = pellet.getType(agent);
            
            Set<OWLAnnotation> aClassAnnots = null;
            for(OWLOntology check : manager.getOntologies()){
                aClassAnnots = agentType.getAnnotations(check, aClassURI);
                if(!aClassAnnots.isEmpty()){
                    break;
                }
            }
            if(aClassAnnots == null || aClassAnnots.isEmpty()){
                throw new RuntimeException("Unable to locate class for "+agentType+" (while creating model for "+agent+")");
            }
            
            for(OWLAnnotation aClassAnnot : aClassAnnots){
                String aClassName = aClassAnnot.getAnnotationValueAsConstant().getLiteral();
                try {
                    Constructor act = Class.forName(aClassName).getConstructor(new Class[] {Atom.class, Model.class, Environment.class, Settings.class});
                    
                    // load settings
                    Settings stts = new Settings();
                    Set<OWLDataProperty> modelProperties = OWLReasonerAdapter.flattenSetOfSets(pellet.getSubProperties(factory.getOWLDataProperty(URI.create(MAS_NS+"agentModelDataProperty"))));
                    
                    // data property settings
                    for(OWLDataProperty modelProperty : modelProperties){
                        OWLConstant c = pellet.getRelatedValue(agent, modelProperty);
                        
                        if(c != null){
                            stts.addOption(
                                    modelProperty.getURI().getFragment(),
                                    c.getLiteral());
                        }
                    }
                    
                    
                    
                    
                    
                    // object property settings
                    // invoke custom handlers
                    // TODO: unify with OWL2MAS code
                    HashMap<String, String> optionMap = new HashMap<String, String>();
                    
                    Set<OWLObjectProperty> agentModelObjectProperties = OWLReasonerAdapter.flattenSetOfSets(
                            pellet.getSubProperties(
                                    factory.getOWLObjectProperty(
                                            URI.create(MAS_NS+"agentModelObjectProperty"))));
                    
                    URI pHandlerURI = URI.create(MAS_NS+"PropertyHandler");
                    
                    for(OWLObjectProperty agentModelObjectProperty : agentModelObjectProperties){
                                            
                        // Get the property handler class
                        // TODO: Assign precedence by distance from mas.owl?
                        Set<OWLAnnotation> pHandlerAnnots = null;
                        for(OWLOntology check : manager.getOntologies()){
                            pHandlerAnnots = agentModelObjectProperty.getAnnotations(check, pHandlerURI);
                            if(!pHandlerAnnots.isEmpty()){
                                break;
                            }
                        }
                        if(pHandlerAnnots == null || pHandlerAnnots.isEmpty()){
                            throw new RuntimeException("Unable to locate handler for "+agentModelObjectProperty);
                        }
                        for(OWLAnnotation pHandlerAnnot : pHandlerAnnots){
                            String pHandlerClassName = pHandlerAnnot.getAnnotationValueAsConstant().getLiteral();
                            try {
                                Constructor pct = Class.forName(pHandlerClassName).getConstructor(new Class[] {});
                                ObjectPropertyHandler pHandler = (ObjectPropertyHandler)pct.newInstance(new Object[] {});
                                
                                // For all relationships over this property for this agent
                                
                                Set<OWLIndividual> values = pellet.getRelatedIndividuals(agent, agentModelObjectProperty);
                                if(!values.isEmpty()){
                                    pHandler.handle(agent, values, this, optionMap);
                                }
                            } catch (Exception e){
                                throw new RuntimeException("Failure while invoking property handler "+pHandlerClassName, e);
                            }

                        }
                        
                        
                    }
                    
                    // add results from object property handlers
                    for(Entry<String, String> entry : optionMap.entrySet()){
                        stts.addOption(entry.getKey(), entry.getValue());
                    }
                    
                    
                    
                    ObjectModel aClass = (ObjectModel)act.newInstance(new Object[] {
                            new Atom(agent.getURI().getFragment()),
                            model,
                            env,
                            stts
                    });
                    
                    objects.add(aClass);
                } catch (Exception e){
                    throw new RuntimeException("Failure while invoking property handler "+aClassName, e);
                }

            }
            
        }
        
        
        return objects;
    }
}
