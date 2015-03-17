package commerce.model;

import jason.asSyntax.Atom;
import jason.environment.Environment;
import jason.runtime.Settings;

import java.awt.Color;
import java.awt.Point;
import java.util.Set;

import owl2mas.model.Model;

/**
 * Used for representation of a purchase deployed by a shop.
 * Crates cannot be created at run-time (at least not using standard OWL2MAS society model instantiation mechanism)
 * 
 * It might be better to seperate crates from the agent model hierarchy
 * 
 * @author Tom Klapiscak
 *
 */
public class CrateModel extends MobileAgentModel{
    /**
     * The product contained within this crate.
     */
    private Product product;
    
    /**
     * The quanity of product contained within this crate.
     */
    private int qty;
    
    /**
     * The delivery van this crate is loaded onto, null if not loaded.
     */
    private DeliveryVanModel loadedOn = null;


    public CrateModel(Atom id, Model model, Environment env, Settings stts) {
        super(id, model, env, stts);
        throw new RuntimeException("Crates cannot be instantiated at run-time using OWL2MAS society model instantiation mechanism");
    }
    
    
    public CrateModel(Atom id, Model model, Environment env, Point position, Product p, int qty) {      
        super(id, model, env, generateSettings(position));
        this.product = p;
        this.qty = qty;
    }
    
    public static Settings generateSettings(Point position){
        Settings stts = new Settings();
        stts.addOption("x_position", ""+position.x);
        stts.addOption("y_position", ""+position.y);
        return stts;
    }

    
    
    public void setLoadedOn(DeliveryVanModel van){
        loadedOn = van;
    }

    public DeliveryVanModel getLoadedOn() {
        return loadedOn;
    }
    
    public boolean isLoaded(){
        return loadedOn != null;
    }
    protected float getOffset(){
        return 0.9f;
    }
    
    protected Color getColour(){
        return new Color(80, 80, 0);
    }
    
    @Override
    public String getLabel(){
        Set<EmbodiedAgentModel> os = cmodel.getAgentsAtPosition(getPosition());
        int no = 0;
        for(EmbodiedAgentModel o : os){
            if(o instanceof CrateModel){
                no++;
            }
        }
        if(no==1){
            return "crate";
        }else{
            return "crates ("+no+")";
        }
    }
    


    public void setProduct(Product product) {
        this.product = product;
    }


    public void setQuantity(int qty) {
        this.qty = qty;
    }   
    

    public Product getProduct() {
        return product;
    }


    public int getQty() {
        return qty;
    }
    
    
}
