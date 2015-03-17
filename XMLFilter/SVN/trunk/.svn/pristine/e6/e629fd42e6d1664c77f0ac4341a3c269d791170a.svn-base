package owl2mas;

import jason.JasonException;
import jason.asSyntax.Atom;
import jason.asSyntax.Structure;
import jason.jeditplugin.MASLauncherInfraTier;
import jason.mas2j.AgentParameters;
import jason.mas2j.ClassParameters;
import jason.mas2j.MAS2JProject;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.lang.reflect.Constructor;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Set;

import org.semanticweb.owl.inference.OWLReasonerAdapter;
import org.semanticweb.owl.model.OWLAnnotation;
import org.semanticweb.owl.model.OWLConstant;
import org.semanticweb.owl.model.OWLDataProperty;
import org.semanticweb.owl.model.OWLException;
import org.semanticweb.owl.model.OWLIndividual;
import org.semanticweb.owl.model.OWLObjectProperty;
import org.semanticweb.owl.model.OWLOntology;
import org.semanticweb.owl.model.OWLOntologyCreationException;

import owl2mas.exception.OWL2MASInvalidMASOntologyException;
import owl2mas.exception.OWL2MASParameterNotSetException;
import owl2mas.handler.ObjectPropertyHandler;
import owl2mas.util.OWL2MASCommon;

/**
 * Agent designers should extend the base ontology (mas.owl) in order to describe their specific MAS.
 * This utility class takes such a description and generates the corresponding MAS project.
 * 
 * @author Tom Klapiscak
 *
 */
public class OWL2MAS extends OWL2MASLoader{
    
    

    /**
     * Accept a name identifying a master "MAS" individual and the URI of an ontology describing this MAS and generate
     * a MAS2J project.
     * @param socName
     * @param o_uri
     * @return
     * @throws OWLException
     */
    public MAS2JProject convert(String socName, URI o_uri){
        try{
            MAS2JProject project = new MAS2JProject();
            
            project.setupDefault();
            
            OWLOntology o;
            try {
                o = manager.loadOntology(o_uri);
            } catch (OWLOntologyCreationException e1) {
                throw new OWL2MASInvalidMASOntologyException(e1);
            }
            Set<OWLOntology> importsClosure = manager.getImportsClosure(o);
            pellet.loadOntologies(importsClosure);
            pellet.classify();          
            
            String ns = o.getURI()+"#";
            
            
            // Set the society individual
            soc = factory.getOWLIndividual(URI.create(ns + socName));
            
            // MAS name
            project.setSocName(socName);
                
            try{project.setInfrastructure(loadClass(soc, factory.getOWLObjectProperty(URI.create(MAS_NS + "infrastructure")))); }catch(OWL2MASParameterNotSetException e){}
            try{project.setEnvClass(loadClass(soc, factory.getOWLObjectProperty(URI.create(MAS_NS + "environment")))); }catch(OWL2MASParameterNotSetException e){}
            try{project.setControlClass(loadClass(soc, factory.getOWLObjectProperty(URI.create(MAS_NS + "executionControl")))); }catch(OWL2MASParameterNotSetException e){}
            
            // agents
            Set<OWLIndividual> agents = pellet.getRelatedIndividuals(
                    soc,
                    factory.getOWLObjectProperty( URI.create(MAS_NS + "hasAgent") ));
            
            System.out.println("Agents: "+agents);
            
            
            for(OWLIndividual agent : agents){
                AgentParameters agentParams = new AgentParameters();
                
                // name
                agentParams.name = agent.getURI().getFragment();
                
                // filename
                try{
                agentParams.asSource =
                    new File(pellet.getRelatedValue(
                        agent,
                        factory.getOWLDataProperty(URI.create(MAS_NS+"filename"))).getLiteral());
                }catch(NullPointerException e){
                    // do nothing, optional
                }
                
                
                // (user) options               
                HashMap<String, String> optionMap = new HashMap<String, String>();
                            
                // user agent data properties
                Set<OWLDataProperty> userAgentDataProperties = OWLReasonerAdapter.flattenSetOfSets(pellet.getSubProperties(factory.getOWLDataProperty(URI.create(MAS_NS+"userAgentDataProperty"))));
                for(OWLDataProperty userAgentDataProperty : userAgentDataProperties){                   
                    Set<OWLConstant> options = pellet.getRelatedValues(agent, userAgentDataProperty);
                    for(OWLConstant option : options){          
                        String value = option.getLiteral();
                        
                        // Must be enclosed with quotes unless an integer
                        try{
                            Integer.parseInt(value);
                        }catch(NumberFormatException e){
                            value = "\""+value+"\"";
                        }
                        
                        optionMap.put(userAgentDataProperty.getURI().getFragment(), value);
                    }
                }
                
                // user agent object properties
                // invoke custom handlers
                Set<OWLObjectProperty> userAgentObjectProperties = OWLReasonerAdapter.flattenSetOfSets(pellet.getSubProperties(factory.getOWLObjectProperty(URI.create(MAS_NS+"userAgentObjectProperty"))));
                URI pHandlerURI = URI.create(MAS_NS+"PropertyHandler");
                
                for(OWLObjectProperty userAgentObjectProperty : userAgentObjectProperties){
                                        
                    // Get the property handler class
                    // TODO: Assign precedence by distance from mas.owl?
                    Set<OWLAnnotation> pHandlerAnnots = null;
                    for(OWLOntology check : manager.getOntologies()){
                        pHandlerAnnots = userAgentObjectProperty.getAnnotations(check, pHandlerURI);
                        if(!pHandlerAnnots.isEmpty()){
                            break;
                        }
                    }
                    if(pHandlerAnnots == null || pHandlerAnnots.isEmpty()){
                        throw new RuntimeException("Unable to locate handler for "+userAgentObjectProperty);
                    }
                    for(OWLAnnotation pHandlerAnnot : pHandlerAnnots){
                        String pHandlerClassName = pHandlerAnnot.getAnnotationValueAsConstant().getLiteral();
                        try {
                            Class cls = Class.forName(pHandlerClassName);
                            Constructor ct = cls.getConstructor(new Class[] {});
                            ObjectPropertyHandler pHandler = (ObjectPropertyHandler)ct.newInstance(new Object[] {});
                            
                            // For all relationships over this property for this agent
                            
                            Set<OWLIndividual> values = pellet.getRelatedIndividuals(agent, userAgentObjectProperty);
                            if(!values.isEmpty()){
                                pHandler.handle(agent, values, this, optionMap);
                            }
                        } catch (Exception e){
                            throw new RuntimeException("Failure while invoking property handler "+pHandlerClassName, e);
                        }

                    }
                    
                    
                }
                
                //agentParams.options = optionMap;
                for (String k: optionMap.keySet())
                    agentParams.addOption(k, optionMap.get(k));
                                
                try{agentParams.addArchClass(loadClass(agent, factory.getOWLObjectProperty(URI.create(MAS_NS + "hasAgentArchClass"))).getClassName()); }catch(OWL2MASParameterNotSetException e){}
                try{agentParams.setBB(loadClass(agent, factory.getOWLObjectProperty(URI.create(MAS_NS + "hasBeliefBaseClass")))); }catch(OWL2MASParameterNotSetException e){}
                try{agentParams.setAgClass(loadClass(agent, factory.getOWLObjectProperty(URI.create(MAS_NS + "hasAgentClass"))).getClassName()); }catch(OWL2MASParameterNotSetException e){}
                
                // Force #1
                agentParams.qty = 1;            
                
                // at
                try{
                    agentParams.setHost( 
                        "\""+pellet.getRelatedValue(agent, factory.getOWLDataProperty(URI.create(MAS_NS+"at"))).getLiteral()+"\"");
                }catch(NullPointerException e){
                    // do nothing, optional
                }
                
                project.addAgent(agentParams);
                
                
            }
            
            // classpaths
            Set<OWLConstant> classpaths = pellet.getRelatedValues(soc, factory.getOWLDataProperty(URI.create(MAS_NS+"classpath")));
            for(OWLConstant classpath : classpaths){
                project.addClassPath(classpath.getLiteral());
            }
            
            // asl source paths
            Set<OWLConstant> sourcepaths = pellet.getRelatedValues(soc, factory.getOWLDataProperty(URI.create(MAS_NS+"aslSourcePath")));
            for(OWLConstant sourcePath : sourcepaths){
                project.addSourcePath(sourcePath.getLiteral());
            }
            
            
            return project;
        }catch(OWL2MASInvalidMASOntologyException e){
            throw new RuntimeException("Invalid MAS ontology "+o_uri, e);
        }
    }
    
    /**
     * Generate a class parameter object described by an ontology fragment identified by a
     * property relating an individual to a member the "Class" concept.
     * 
     * @param i_mas The "master" individual ("MAS" or "Agent") to which this class applied.d
     * @param p     The property linking the "master" individual to a class instance.
     * @return      The constructed class parameters object.
     * 
     * @throws OWL2MASParameterNotSetException      If the parameter is not set, note that it may be an optional parameter.
     * @throws OWL2MASInvalidMASOntologyException   If the parameter is set, but necessary dependencies are not (e.g. hasClassName).
     */
    public ClassParameters loadClass(OWLIndividual domain, OWLObjectProperty p) throws OWL2MASParameterNotSetException, OWL2MASInvalidMASOntologyException{
        OWLIndividual i = pellet.getRelatedIndividual(domain, p);
        if(i == null){
            throw new OWL2MASParameterNotSetException();
        }
        String className;
        try{
            className = pellet.getRelatedValue(i, factory.getOWLDataProperty(URI.create(MAS_NS+"hasClassName"))).getLiteral();
        }catch(NullPointerException e){
            throw new OWL2MASInvalidMASOntologyException("No class name provided for "+p);
        }
        Structure paramsStructure = new Structure(className);
        Set<OWLConstant> params = pellet.getRelatedValues(i, factory.getOWLDataProperty(URI.create(MAS_NS+"hasClassParameter")));
        for(OWLConstant param : params){
            paramsStructure.addTerm(new Atom(param.getLiteral()));
        }
        return new ClassParameters(paramsStructure);    
    }
    
    /**
     * External entry point to the utility.
     * @param args
     */
    public static void main(String[] args){ 
        
        if(args.length < 4){
            System.out.println("Usage: OWL2MAS <MAS Project Directory> <MAS Individual Name> <MAS Ontology URI> <Debug> [test|run]");
            System.exit(0);
        }       
        
        
        String projectDir = args[0];
        String individualName = args[1];        
        URI uri;
        try {
            uri = new URI(args[2]);
            if (!uri.isAbsolute()) {
                uri = OWL2MASCommon.getRelativeLocalURI(args[2]); // try relative path
            }
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
        boolean debug = Boolean.parseBoolean(args[3]);
        
        OWL2MAS converter = new OWL2MAS();  
        MAS2JProject project = converter.convert(individualName, uri);
        
        System.out.println("***Generated .mas2j file ***");
        System.out.println(project);
        System.out.println("****************************");

        if(args.length == 5 && args[4].equals("test")){
            
            // test run, don't execute MAS, just print generated file to console            
            
        }else{
        
            File projectFile = new File("MAS.mas2j");
            
            PrintWriter writer;
            try {
                writer = new PrintWriter(projectFile);
            } catch (FileNotFoundException e1) {
                throw new RuntimeException(e1);
            }
            writer.write(project.toString());
            writer.close();
            
            project.setProjectFile(projectFile);        
            project.setDirectory(projectDir);
            
            
            
            MASLauncherInfraTier masLauncher;
            try {
                masLauncher = project.getInfrastructureFactory().createMASLauncher();
            } catch (JasonException e) {
                throw new RuntimeException(e);
            }
            masLauncher.setProject(project);
            if (masLauncher.writeScripts(debug)) {
                new Thread(masLauncher, "MAS-Launcher").start();
            }
        }
        
        
    }
    

}
