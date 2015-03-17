package jasdl.util.owlapi.rendering;

import jasdl.bridge.JASDLOntologyManager;
import jasdl.util.exception.JASDLUnknownMappingException;

import org.semanticweb.owl.model.OWLDescription;
import org.semanticweb.owl.model.OWLEntity;
import org.semanticweb.owl.util.ShortFormProvider;

import uk.ac.manchester.cs.owl.mansyntaxrenderer.ManchesterOWLSyntaxOWLObjectRendererImpl;

/**
 * A renderer that renders a run-time defined class in normal form. If entity is not a run-time defined class, return null
 * (to be detected by sub-class and acted upon)
 * @author tom
 *
 */
public abstract class NormalisingOWLObjectShortFormProvider implements ShortFormProvider {
    
    protected JASDLOntologyManager jom;


    public NormalisingOWLObjectShortFormProvider(JASDLOntologyManager jom){
        this.jom = jom;
    }
    

    public void dispose() {
    }
    
    
    public String getShortForm(OWLEntity entity) {      
        // detect run-time defined classes and render them in "normal" form (i.e. in terms of schema-defined classes)
        if(entity.isOWLClass()){
            try{
                OWLDescription desc = jom.getDefinitionManager().getRight(entity.asOWLClass());
                ManchesterOWLSyntaxOWLObjectRendererImpl renderer = new ManchesterOWLSyntaxOWLObjectRendererImpl();
                renderer.setShortFormProvider(this);                
                return renderer.render(desc);
            }catch(JASDLUnknownMappingException e){         
            }
        }
        return null;
    }
    
    
}
