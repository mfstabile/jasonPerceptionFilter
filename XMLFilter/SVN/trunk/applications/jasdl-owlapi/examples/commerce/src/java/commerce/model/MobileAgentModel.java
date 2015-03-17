package commerce.model;

import java.awt.Point;

import commerce.exception.ModelMobileAgentException;

import jason.asSyntax.Atom;
import jason.environment.Environment;
import jason.runtime.Settings;
import owl2mas.model.Model;

public class MobileAgentModel extends EmbodiedAgentModel{

    public MobileAgentModel(Atom id, Model model, Environment env, Settings stts) {
        super(id, model, env, stts);
    }
    
    public void setPosition(Point position){
        this.position = position;
    }

    
    public void moveTowards(Point position) throws ModelMobileAgentException{
        //try{
            // TODO: Implement A* pathfinding
            int nx = getPosition().x;
            int ny = getPosition().y;
            if(position.x < getPosition().x){
                nx--;
            }else if(position.x > getPosition().x){
                nx++;
            }else if(position.y < getPosition().y){
                ny--;
            }else if(position.y > getPosition().y){
                ny++;
            }
            setPosition(new Point(nx, ny)); 
        //}catch(ModelMobileAgentException e){
        //  throw new ModelMobileAgentException("Unable to move towards "+position, e);
        //}
    }
}
