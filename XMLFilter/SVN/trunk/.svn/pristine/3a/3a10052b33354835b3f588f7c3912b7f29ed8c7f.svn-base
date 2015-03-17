package owl2mas.model;

import jason.asSyntax.Atom;
import jason.environment.Environment;

import java.net.URI;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Vector;

import owl2mas.exception.OWL2MASInvalidMASOntologyException;

public class Model {
    
    /**
     * Maintains a reference to all objects contained within the MAS
     */
    private Set<ObjectModel> objects;
    
    /**
     * For deferring run-time addition of objects until updateObjects is called
     */
    private List<ObjectModel> addQueue;
    
    /**
     * For deferring run-time removal of objects until updateObjects is called
     */ 
    private List<ObjectModel> removeQueue;
    
    public Model(Environment env, String socName, URI o_uri) throws OWL2MASInvalidMASOntologyException{
        objects = new HashSet<ObjectModel>();
        addQueue = new Vector<ObjectModel>();
        removeQueue = new Vector<ObjectModel>();
        
        ModelLoader loader = new ModelLoader(this, env);
        objects.addAll(
                loader.load(
                        socName, 
                        o_uri));
        
        
    }
    
    public ObjectModel getObjectById(Atom id){
        for(ObjectModel o : getObjects()){
            if(o.getId().equals(id)){
                return o;
            }
        }
        return null;
    }
    
    public void addObject(ObjectModel o){
        addQueue.add(o);
    }
    
    public void removeObject(ObjectModel o){
        removeQueue.add(o);
    }
    
    public void updateObjects(){
        for(ObjectModel o : removeQueue){
            objects.remove(o);
        }
        for(ObjectModel o : addQueue){
            objects.add(o);
        }
        removeQueue.clear();
        addQueue.clear();
    }
        
    public Set<ObjectModel> getObjects() {
        return objects;
    }
}
