package jasdl.owl2mas.handler;

import jasdl.JASDLParams;

import java.net.URI;
import java.util.HashMap;
import java.util.Set;

import org.semanticweb.owl.model.OWLIndividual;

import owl2mas.OWL2MASLoader;
import owl2mas.exception.OWL2MASInvalidMASOntologyException;
import owl2mas.handler.ObjectPropertyHandler;

public class TrustRatingHandler implements ObjectPropertyHandler{
    public void handle(OWLIndividual agent, Set<OWLIndividual> values, OWL2MASLoader loader, HashMap<String, String> optionMap) throws OWL2MASInvalidMASOntologyException {
        
        Set<OWLIndividual> trustRatingIs = loader.getPellet().getRelatedIndividuals(
                agent, 
                loader.getFactory().getOWLObjectProperty(URI.create(JASDLParams.JASDL_OWL_NS + "trust_rating")));
        
        
        for(OWLIndividual trustRatingI : trustRatingIs){
            OWLIndividual trustRatingAgent = loader.getPellet().getRelatedIndividual(
                    trustRatingI, 
                    loader.getFactory().getOWLObjectProperty(URI.create(JASDLParams.JASDL_OWL_NS + "trust_rating_agent")));
            
            float trustRatingValue = Float.parseFloat(loader.getPellet().getRelatedValue(
                    trustRatingI, 
                    loader.getFactory().getOWLDataProperty(URI.create(JASDLParams.JASDL_OWL_NS + "trust_rating_value"))).getLiteral());
            
            optionMap.put("jasdl_"+trustRatingAgent+"_trustRating", "\""+trustRatingValue+"\"");
            
        }
    
    }


}
