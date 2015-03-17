package commerce.model;

import jason.asSyntax.Atom;
import jason.environment.Environment;
import jason.runtime.Settings;
import owl2mas.model.AgentModel;
import owl2mas.model.Model;

import commerce.env.CommerceEnvironment;

public abstract class CommerceAgentModel extends AgentModel{
    public CommerceEnvironment cenv;
    public CommerceModel cmodel;

    public CommerceAgentModel(Atom id, Model model, Environment env, Settings stts) {
        super(id, model, env, stts);
        this.cenv = (CommerceEnvironment)env;
        this.cmodel = (CommerceModel)model;
    }
    
    
}
