package commerce.model;

import jason.asSyntax.Atom;
import jason.environment.Environment;

import java.awt.Dimension;
import java.awt.Point;
import java.net.URI;
import java.util.HashSet;
import java.util.Set;

import owl2mas.exception.OWL2MASInvalidMASOntologyException;
import owl2mas.model.ObjectModel;

import commerce.view.CommerceView;

public class CommerceModel extends owl2mas.model.Model{
    
    public static int DEFAULT_PERCEPTION_RANGE = 1;
    
    private Dimension gridSize; 
    
    private CommerceView view;   

    public CommerceModel(Environment env, Dimension gridSize) throws OWL2MASInvalidMASOntologyException {
        super(env, "soc", URI.create("file:onts/society.owl"));
        this.gridSize = gridSize;
        initCatalogues();
    }
    
    private void initCatalogues(){
        
        ShopModel a_supermarket = (ShopModel)getObjectById(new Atom("a_supermarket"));
        a_supermarket.addProductToCatalogue(new Product("bread", "hovis", 1.4, 800), 22);
        a_supermarket.addProductToCatalogue(new Product("bread", "kingsmill", 1.6, 750), 58);
        a_supermarket.addProductToCatalogue(new Product("milk", "cravendale", 0.9, 500), 33);
        a_supermarket.addProductToCatalogue(new Product("milk", "tescos_semi_skimmed", 0.7, 500), 85);
        a_supermarket.addProductToCatalogue(new Product("butter", "clover_butter", 0.8, 300), 74);
        a_supermarket.addProductToCatalogue(new Product("rootVegetable", "sweet_potatoes", 2.2, 600), 58);
        
        ShopModel a_butchers = (ShopModel)getObjectById(new Atom("a_butchers"));
        a_butchers.addProductToCatalogue(new Product("beef", "farmer_jims_rump_steak", 10.5, 500), 22);
        a_butchers.addProductToCatalogue(new Product("lamb", "farmer_jims_lamb_chops", 10.5, 400), 80);
        a_butchers.addProductToCatalogue(new Product("beef", "tescos_sirloin_steak", 5, 600), 11);
        a_butchers.addProductToCatalogue(new Product("fish", "tescos_salmon", 8, 200), 29);
        a_butchers.addProductToCatalogue(new Product("fish", "tescos_chicken_breasts", 5.9, 450), 92);
        
        ShopModel a_greengrocers = (ShopModel)getObjectById(new Atom("a_greengrocers"));
        a_greengrocers.addProductToCatalogue(new Product("greenVegetable", "iceburg_lettuce", 0.3, 90), 54);
        a_greengrocers.addProductToCatalogue(new Product("rootVegetable", "potatoes", 1.2, 1000), 92);
    }
    
    
    public Set<EmbodiedAgentModel> getAgentsInVicinityOfPosition(Point position){
        return getAgentsInVicinityOfPosition(position, DEFAULT_PERCEPTION_RANGE);
    }
    
    private Set<EmbodiedAgentModel> getAgentsInVicinityOfPosition(Point position, int radius){
        Set<EmbodiedAgentModel> found = new HashSet<EmbodiedAgentModel>();
        for(int x = position.x-radius; x<position.x+radius; x++){
            for(int y = position.y-radius; y<position.y+radius; y++){
                found.addAll( getAgentsAtPosition(new Point(x, y)) );
            }       
        }
        return found;
    }
    
    public Set<EmbodiedAgentModel> getAgentsAtPosition(Point position){
        Set<EmbodiedAgentModel> found = new HashSet<EmbodiedAgentModel>();
        for(ObjectModel o : getObjects()){
            if(o instanceof EmbodiedAgentModel){
                EmbodiedAgentModel eam = (EmbodiedAgentModel)o;
                if(eam.getPosition().equals(position)){
                    found.add(eam);
                }
            }
        }
        return found;
    }
    

    
    public Dimension getGridSize() {
        return gridSize;
    }

    public CommerceView getView() {
        return view;
    }

}
