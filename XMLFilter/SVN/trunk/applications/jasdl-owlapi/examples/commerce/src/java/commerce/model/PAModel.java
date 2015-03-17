package commerce.model;

import jason.asSyntax.Atom;
import jason.environment.Environment;
import jason.runtime.Settings;
import owl2mas.model.AgentModel;
import owl2mas.model.Model;

public class PAModel extends CommerceAgentModel{
    public PAModel(Atom id, Model model, Environment env, Settings stts) {
        super(id, model, env, stts);
    }

    @Override
    public void addPercepts() {
        super.addPercepts();
    }
}
