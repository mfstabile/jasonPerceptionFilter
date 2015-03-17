package owl2mas.handler;

import java.util.HashMap;
import java.util.Set;

import org.semanticweb.owl.model.OWLIndividual;

import owl2mas.OWL2MASLoader;
import owl2mas.exception.OWL2MASInvalidMASOntologyException;

public class IntBelsObjectPropertyHandler implements ObjectPropertyHandler{

    public void handle(OWLIndividual agent, Set<OWLIndividual> values, OWL2MASLoader d, HashMap<String, String> optionMap) throws OWL2MASInvalidMASOntologyException{
        if(values.size() != 1){
            throw new OWL2MASInvalidMASOntologyException("Exactly one value must be specified for intBels property");
        }
        optionMap.put("intBels", ((OWLIndividual)values.toArray()[0]).getURI().getFragment().toString());
    }

}
