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

public class DefaultMappingStrategyClassHandler implements ObjectPropertyHandler{

    public void handle(OWLIndividual agent, Set<OWLIndividual> values, OWL2MASLoader loader, HashMap<String, String> optionMap) throws OWL2MASInvalidMASOntologyException {
        Set<OWLIndividual> defaultMappingStrategyIs = loader.getPellet().getRelatedIndividuals(
                agent, 
                loader.getFactory().getOWLObjectProperty(URI.create(JASDLParams.JASDL_OWL_NS + "default_mapping_strategy")));
        
        String defaultMappingStrategies = "";
        
        for(OWLIndividual defaultMappingStrategyI : defaultMappingStrategyIs){
            String mappingStrategyClassName = loader.getPellet().getRelatedValue(
                    defaultMappingStrategyI, 
                    loader.getFactory().getOWLDataProperty(URI.create(loader.getMAS_NS() + "hasClassName"))).getLiteral();
            
            defaultMappingStrategies += mappingStrategyClassName+",";
        }
        
        defaultMappingStrategies = JASDLCommon.dropLast(defaultMappingStrategies);
        
        optionMap.put("jasdl_default_mapping_strategies", "\""+defaultMappingStrategies+"\"");
    }
}
