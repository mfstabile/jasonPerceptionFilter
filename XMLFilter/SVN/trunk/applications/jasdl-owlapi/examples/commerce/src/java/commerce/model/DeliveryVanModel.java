package commerce.model;

import jason.asSyntax.Atom;
import jason.asSyntax.Literal;
import jason.environment.Environment;
import jason.runtime.Settings;

import java.awt.Color;
import java.awt.Point;
import java.util.HashSet;
import java.util.Set;

import owl2mas.model.Model;

import commerce.exception.ModelDeliveryVanException;
import commerce.exception.ModelMobileAgentException;

public class DeliveryVanModel extends MobileAgentModel{
    public static int DEFAULT_CARGO_SPACE;
    
    private Set<CrateModel> cargo;
    private int cargoSpace;
    
    
    public DeliveryVanModel(Atom id, Model model, Environment env, Settings stts) {
        super(id, model, env, stts);
        cargo = new HashSet<CrateModel>();
        cargoSpace = DEFAULT_CARGO_SPACE;
        
    }
    


    public void load(Atom id) throws ModelDeliveryVanException{
        try{            
            CrateModel toLoad = null;
            for(EmbodiedAgentModel inVicinity : ((CommerceModel)model).getAgentsInVicinityOfPosition(getPosition())){
                if(inVicinity instanceof CrateModel){                   
                    CrateModel p = (CrateModel)inVicinity;
                    if(!p.isLoaded()){                                      // not already loaded on some van                       
                        if(p.getId().equals(id)){
                            toLoad = p;
                            break;
                        }
                    }
                }
            }
            if(toLoad == null){
                throw new ModelDeliveryVanException("Crate not found in vicinity of van");
            }
            // TODO: check cargo space
            cargo.add(toLoad);
            toLoad.setLoadedOn(this);
        }catch(ModelDeliveryVanException e){
            throw new ModelDeliveryVanException("Cannot load crate "+id, e);
        }
    }
    
    public void unload(Atom id) throws ModelDeliveryVanException{
        try{
            CrateModel toUnload = null;
            for(CrateModel loaded : cargo){
                if(loaded.getId().equals(id)){
                    toUnload = loaded;
                    break;
                }
            }           
            if(toUnload == null){
                throw new ModelDeliveryVanException("Not loaded on this van");
            }   
            cargo.remove(toUnload);
            toUnload.setLoadedOn(null);
        }catch(ModelDeliveryVanException e){
            throw new ModelDeliveryVanException("Cannot unload "+id, e);
        }       
    }
    
    
    
    /**
     * Also move cargo (model purchases)
     */
    @Override
    public void moveTowards(Point position) throws ModelMobileAgentException {
        super.moveTowards(position);
        for(CrateModel loaded : cargo){
            loaded.setPosition(getPosition());
        }
    }

    @Override
    public void addPercepts(){
        super.addPercepts();
        env.addPercept(getId().toString(), Literal.parseLiteral("cargo_space("+cargoSpace+")"));        
        for(CrateModel loaded : cargo){
            env.addPercept(getId().toString(), Literal.parseLiteral("cargo("+loaded.getId()+")"));
        }       
    }

    protected float getOffset(){
        return 0.8f;
    }
    
    protected Color getColour(){
        return Color.MAGENTA;
    }
}
