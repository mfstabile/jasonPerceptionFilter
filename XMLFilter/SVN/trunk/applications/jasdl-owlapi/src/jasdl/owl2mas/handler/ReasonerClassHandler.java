package jasdl.owl2mas.handler;

import jasdl.JASDLParams;

import java.net.URI;
import java.util.HashMap;
import java.util.Set;

import org.semanticweb.owl.model.OWLIndividual;

import owl2mas.OWL2MASLoader;
import owl2mas.exception.OWL2MASInvalidMASOntologyException;
import owl2mas.handler.ObjectPropertyHandler;

public class ReasonerClassHandler implements ObjectPropertyHandler{
    public void handle(OWLIndividual agent, Set<OWLIndividual> values, OWL2MASLoader loader, HashMap<String, String> optionMap) throws OWL2MASInvalidMASOntologyException {
        OWLIndividual reasonerClassI = loader.getPellet().getRelatedIndividual(
                agent, 
                loader.getFactory().getOWLObjectProperty(URI.create(JASDLParams.JASDL_OWL_NS + "reasoner_class")));
        
        String reasonerClassName = loader.getPellet().getRelatedValue(
                reasonerClassI, 
                loader.getFactory().getOWLDataProperty(URI.create(loader.getMAS_NS() + "hasClassName"))).getLiteral();
        
        optionMap.put("jasdl_reasonerClass", "\""+reasonerClassName+"\"");
    
    }


}
