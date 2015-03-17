package jasdl.owl2mas.handler;

import jasdl.JASDLParams;
import jasdl.util.JASDLCommon;

import java.net.URI;
import java.util.HashMap;
import java.util.Set;

import org.semanticweb.owl.model.OWLIndividual;

import owl2mas.OWL2MASLoader;
import owl2mas.exception.OWL2MASInvalidMASOntologyException;
import owl2mas.handler.ObjectPropertyHandler;

public class OntologyHandler implements ObjectPropertyHandler{


    public void handle(OWLIndividual agent, Set<OWLIndividual> values, OWL2MASLoader loader, HashMap<String, String> optionMap) throws OWL2MASInvalidMASOntologyException {
    
        String labels = "";
        for(OWLIndividual ontology : values){
            String label = loader.getPellet().getRelatedValue(
                    ontology, 
                    loader.getFactory().getOWLDataProperty(URI.create(JASDLParams.JASDL_OWL_NS + "ontology_label"))).getLiteral();
            
            String uri = loader.getPellet().getRelatedValue(
                    ontology, 
                    loader.getFactory().getOWLDataProperty(URI.create(JASDLParams.JASDL_OWL_NS + "ontology_uri"))).getLiteral();
            
            labels+=label+",";
            
            // uri
            optionMap.put("jasdl_"+label+"_uri", "\""+uri+"\"");
            
            // manual mappings
            String manualMappings = "";
            Set<OWLIndividual> manualMappingIs = loader.getPellet().getRelatedIndividuals(ontology, loader.getFactory().getOWLObjectProperty(URI.create(JASDLParams.JASDL_OWL_NS + "ontology_manual_mapping")));
            
            if(!manualMappingIs.isEmpty()){
                for(OWLIndividual manualMappingI : manualMappingIs){
                    String alias = loader.getPellet().getRelatedValue(
                            manualMappingI, 
                            loader.getFactory().getOWLDataProperty(URI.create(JASDLParams.JASDL_OWL_NS + "manual_mapping_alias"))).getLiteral();
                    
                    String fragment = loader.getPellet().getRelatedValue(
                            manualMappingI, 
                            loader.getFactory().getOWLDataProperty(URI.create(JASDLParams.JASDL_OWL_NS + "manual_mapping_fragment"))).getLiteral();
                    
                    manualMappings += alias+"="+fragment+",";
                }               
                manualMappings = JASDLCommon.dropLast(manualMappings);              
                optionMap.put("jasdl_"+label+"_manual_mappings", "\""+manualMappings+"\"");
            }
            
            // mapping strategies
            String mappingStrategies = "";
            Set<OWLIndividual> mappingStrategyIs = loader.getPellet().getRelatedIndividuals(
                    ontology, 
                    loader.getFactory().getOWLObjectProperty(URI.create(JASDLParams.JASDL_OWL_NS + "ontology_mapping_strategy")));
            
            if(!mappingStrategyIs.isEmpty()){
                for(OWLIndividual mappingStrategyI : mappingStrategyIs){
                    String mappingStrategyClassName = loader.getPellet().getRelatedValue(
                            mappingStrategyI, 
                            loader.getFactory().getOWLDataProperty(URI.create(loader.getMAS_NS() + "hasClassName"))).getLiteral();
                    
                    mappingStrategies += mappingStrategyClassName+",";
                }               
                mappingStrategies = JASDLCommon.dropLast(mappingStrategies);                
                optionMap.put("jasdl_"+label+"_mapping_strategies", "\""+mappingStrategies+"\"");
            }
        }
        
        labels = JASDLCommon.dropLast(labels);
        
        optionMap.put("jasdl_ontologies", "\""+labels+"\"");

    }
    



}
