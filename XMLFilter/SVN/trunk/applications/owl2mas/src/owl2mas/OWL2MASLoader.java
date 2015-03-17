package owl2mas;

import java.net.URI;

import org.mindswap.pellet.owlapi.Reasoner;
import org.semanticweb.owl.apibinding.OWLManager;
import org.semanticweb.owl.model.OWLDataFactory;
import org.semanticweb.owl.model.OWLIndividual;
import org.semanticweb.owl.model.OWLOntology;
import org.semanticweb.owl.model.OWLOntologyCreationException;
import org.semanticweb.owl.model.OWLOntologyManager;

import owl2mas.util.OWL2MASCommon;

public class OWL2MASLoader {
    protected URI MAS_URI;  
    protected OWLOntologyManager manager;
    protected OWLOntology O_MAS;    
    protected String MAS_NS;
    protected Reasoner pellet;
    protected OWLDataFactory factory;
    protected OWLIndividual soc;
    
    public OWL2MASLoader(){
        MAS_URI = URI.create("http://www.dur.ac.uk/t.g.klapiscak/onts/owl2mas/mas.owl");
        manager = OWLManager.createOWLOntologyManager();
        try {
            O_MAS = manager.loadOntology(MAS_URI);
        } catch (OWLOntologyCreationException e) {
            throw new RuntimeException(e);
        }
        MAS_NS = O_MAS.getURI()+"#";
        pellet = new Reasoner(manager);     
        factory = manager.getOWLDataFactory();
    }
    
    
    public OWLDataFactory getFactory() {
        return factory;
    }


    public OWLOntologyManager getManager() {
        return manager;
    }


    public String getMAS_NS() {
        return MAS_NS;
    }


    public URI getMAS_URI() {
        return MAS_URI;
    }


    public OWLOntology getO_MAS() {
        return O_MAS;
    }


    public Reasoner getPellet() {
        return pellet;
    }


    public OWLIndividual getSoc() {
        return soc;
    }
}
