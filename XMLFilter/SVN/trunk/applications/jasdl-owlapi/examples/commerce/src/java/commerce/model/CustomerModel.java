package commerce.model;

import jason.asSyntax.Atom;
import jason.asSyntax.Literal;
import jason.environment.Environment;
import jason.runtime.Settings;

import java.awt.Color;
import java.util.List;
import java.util.Vector;

import owl2mas.model.Model;

public class CustomerModel extends EmbodiedAgentModel{  
    /**
     * Objects interesting in recieving notification of customer related events.
     * Currently used only by the customer UI pane for the request_approved and message events.
     */
    private List<ModelCustomerListener> listeners;
    
    /**
     * For queing requests made by this customer to send to "customer" agent.
     */
    private List<Request> requests;
    
    /**
     * Set to true by confirm_order environmental action (currently instantiated by UI)
     */
    private boolean orderConfirmed = false;
    
    
    public CustomerModel(Atom id, Model model, Environment env, Settings stts) {
        super(id, model, env, stts);
        requests = new Vector<Request>();
        listeners = new Vector<ModelCustomerListener>();
    }   


    
    
    public void addListener(ModelCustomerListener listener){
        listeners.add(listener);
    }
    
    /**
     * Adds percepts relating to product_requets and confirm_order events.
     */
    @Override
    public void addPercepts(){
        super.addPercepts();
        for(Request request : requests){
            env.addPercept(getId().toString(), Literal.parseLiteral("ui_product_request("+request.productDescription+","+request.shopDescription+","+request.qty+")"));
        }
        if(orderConfirmed){
            env.addPercept(getId().toString(), Literal.parseLiteral("ui_confirm_order"));
            orderConfirmed = false;
        }
        requests.clear();
    }

    
    public void request(String productDescription, String shopDescription, int qty){
        Request request = new Request(productDescription, shopDescription,  qty);
        System.out.println("Requested "+request);
        requests.add(request);
    }
    
    /**
     * Called by the confirm_order environmental action (currently instantiated by UI)
     *
     */
    public void confirm_order(){
        orderConfirmed = true;
    }
    
    /**
     * Returns true if all listeners (current just a CustomerUIPanel) approve of this choice as a purchase.
     * @param brand
     * @return
     */
    public boolean approve(String brand){
        boolean result = true;
        for(ModelCustomerListener listener : listeners){
            result&=listener.approve(brand); // do all listeners approve of this choice?
        }
        return result;
    }
    
    /**
     * Passes a message to all listeners (currently just causes a dialog box to be displayed by CustomerUIPanel)
     * @param message
     */
    public void message(String message){
        for(ModelCustomerListener listener : listeners){
            listener.message(message);
        }
    }
    
    protected float getOffset(){
        return 0.6f;
    }
    
    protected Color getColour(){
        return new Color(0, 100, 0);
    }
    
    /**
     * Associates a product description with a quantity
     * @author tom
     *
     */
    class Request{
        public String shopDescription;
        public String productDescription;
        public int qty;
        public Request(String productDescription, String shopDescription, int qty) {
            super();
            this.shopDescription = shopDescription;
            this.productDescription = productDescription;
            this.qty = qty;
        }
        
        public String toString(){
            return productDescription+" ("+qty+")";
        }
        
    }

}
