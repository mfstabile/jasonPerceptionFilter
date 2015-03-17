package example;

import jason.asSyntax.Literal;
import jason.asSyntax.Structure;
import jason.environment.Environment;

public class BRFTestEnv extends Environment {
    
    public static final Literal iInfo = Literal.parseLiteral("info");
    
    public boolean executeAction(String agName, Structure pAction) {
        // System.out.println(agName+" executing action "+pAction);
        if (pAction.getFunctor().equals("get_info_as_percept"))
            addPercept( agName, Literal.parseLiteral("info") );
        else if (pAction.getFunctor().equals("clear_my_percepts"))
            clearPercepts(agName);
        
        return true;        
    }
}
