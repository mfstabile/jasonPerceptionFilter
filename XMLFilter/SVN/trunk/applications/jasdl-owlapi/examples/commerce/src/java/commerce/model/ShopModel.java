package commerce.model;

import jasdl.util.exception.JASDLInvalidSELiteralException;
import jason.asSyntax.Atom;
import jason.asSyntax.NumberTermImpl;
import jason.asSyntax.Term;
import jason.environment.Environment;
import jason.runtime.Settings;

import java.awt.Color;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Vector;

import owl2mas.model.Model;
import owl2mas.model.ObjectModel;

import commerce.exception.ModelShopException;

public class ShopModel extends EmbodiedAgentModel{
    
    
    private Set<Product> catalogue;
    private HashMap<Product, Integer> stock;

    public ShopModel(Atom id, Model model, Environment env, Settings stts) {
        super(id, model, env, stts);
        this.catalogue = new HashSet<Product>();
        stock = new HashMap<Product, Integer>();
    }
    
    public Product getProductByBrand(String brand) throws ModelShopException{
        for(Product p : catalogue){
            if(p.brand.equals(brand)){
                return p;
            }
        }
        throw new ModelShopException("Unknown brand "+brand);
    }
    
    public void addProductToCatalogue(Product product, int initialStockLevel){
        catalogue.add(product);
        setStockLevel(product, initialStockLevel);
    }
    
    public void setStockLevel(Product product, int level){
        stock.remove(product);
        stock.put(product, level);
    }
    
    public int getStockLevel(Product product){
        return stock.get(product);
    }
    
    public void decreaseStockLevel(Product product, int amount){
        setStockLevel(product, getStockLevel(product)-amount);
    }
    
    public void deploy(Atom id, Product p, int quantity) throws ModelShopException{
        if(!catalogue.contains(p)){
            throw new ModelShopException("We do not stock this product");
        }       
        if(quantity > getStockLevel(p)){
            throw new ModelShopException("Requested quantity exceeds stock level");
        }
        decreaseStockLevel(p, quantity);
        model.addObject( 
                new CrateModel(
                        id,
                        model,
                        env,
                        getPosition(),
                        p,
                        quantity));
    }

    /**
     * Adds details of product catalogue as SE-percepts
     */
    @Override
    public void addPercepts(){
        super.addPercepts();
        try {
        List<Atom> differentIndividuals = new Vector<Atom>();
        
        for(Product product : catalogue){
            
            
                // add product
                env.addPercept(
                        getId().toString(),
                        cenv.getSELiteralFactory().construct(
                            true,
                            new Atom(product.classification),
                            new Atom(product.brand),
                            new Term[0],
                            cenv.c)
                        .getLiteral());
                
                // add product stock
                env.addPercept(
                        getId().toString(),
                        cenv.getSELiteralFactory().construct(
                                true,
                                new Atom("hasInStock"),
                                new Atom(product.brand),
                                new NumberTermImpl(getStockLevel(product)),
                                new Term[0],
                                cenv.c)
                            .getLiteral());
                
                // add product weight
                env.addPercept(
                        getId().toString(),
                        cenv.getSELiteralFactory().construct(
                                true,
                                new Atom("hasWeight"),
                                new Atom(product.brand),
                                new NumberTermImpl(product.weight),
                                new Term[0],
                                cenv.c)
                            .getLiteral());
                
                // add product price
                env.addPercept(
                        getId().toString(),
                        cenv.getSELiteralFactory().construct(
                                true,
                                new Atom("hasPrice"),
                                new Atom(product.brand),
                                new NumberTermImpl(product.RRP),
                                new Term[0],
                                cenv.c)
                            .getLiteral());

                        
            }
            
            for(ObjectModel o : cmodel.getObjects()){
                if(o instanceof ShopModel){
                    for(Product product :((ShopModel)o).getCatalogue()){
                        differentIndividuals.add(new Atom(product.brand));
                    }               
                }
            }
            
            // enter all products into an all_different assertion
            if(differentIndividuals.size() > 0){ // make sure we have some products (cannot add all_differents with no individuals)
                Atom[] is = (Atom[]) differentIndividuals.toArray(new Atom[differentIndividuals.size()]);
                env.addPercept(
                    getId().toString(),
                    cenv.getSELiteralFactory().construct(
                            true,
                            is,
                            new Atom[0],
                            cenv.c)
                            .getLiteral());
            }
        
        } catch (JASDLInvalidSELiteralException e) {
            e.printStackTrace();
        }   
        
    }
    
    public Set<Product> getCatalogue(){
        return catalogue;
    }

    protected float getOffset(){
        return 0.4f;
    }
    
    protected Color getColour(){
        return Color.BLUE;
    }
}
