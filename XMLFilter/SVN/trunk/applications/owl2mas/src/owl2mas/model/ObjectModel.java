package owl2mas.model;

import jason.asSyntax.Atom;
import jason.environment.Environment;
import jason.runtime.Settings;

public class ObjectModel {
    /**
     * A unique identifier for this agent.
     */
    private Atom id;
    
    /**
     * The model this object resides within.
     */
    protected Model model;
    
    /**
     * The environment this object resides within.
     */
    protected Environment env;

    public ObjectModel(Atom id, Model model, Environment env, Settings stts) {
        super();
        this.id = id;
        this.model = model;
        this.env = env;
    }
    
    public String toString(){
        return id.toString();
    }

    public Environment getEnv() {
        return env;
    }

    public Atom getId() {
        return id;
    }

    public Model getModel() {
        return model;
    }
    
    
}
