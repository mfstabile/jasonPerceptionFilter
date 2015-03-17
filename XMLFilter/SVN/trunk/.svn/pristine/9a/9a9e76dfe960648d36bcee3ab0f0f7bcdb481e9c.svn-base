package commerce.model;

import jason.asSyntax.Atom;
import jason.asSyntax.Literal;
import jason.environment.Environment;
import jason.runtime.Settings;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Point;
import java.util.Set;

import owl2mas.model.Model;
import owl2mas.model.ObjectModel;

public abstract class EmbodiedAgentModel extends CommerceAgentModel{
    
    protected Point position;
    
    public EmbodiedAgentModel(Atom id, Model model, Environment env, Settings stts) {
        super(id, model, env, stts);    
        try{
            position = new Point(
                    Integer.parseInt(stts.getUserParameter("x_position")),
                    Integer.parseInt(stts.getUserParameter("y_position")));
        }catch(NumberFormatException e){
            throw new RuntimeException("Invalid parameter set specified for "+id, e);
        }
    }
    
    public void addPercepts(){
        Set<EmbodiedAgentModel> inVicinityList = ((CommerceModel)model).getAgentsInVicinityOfPosition(getPosition());
        // don't want to add atLocation(me, me)
        inVicinityList.remove((ObjectModel)this);
        
        // add my x and y coords
        env.addPercept(getId().toString(), Literal.parseLiteral("hasPosition("+getId()+","+getPosition().x+","+getPosition().y+")"));
        
        for(EmbodiedAgentModel inVicinity : inVicinityList){                    
            env.addPercept(getId().toString(), Literal.parseLiteral("inVicinityOf("+inVicinity.getId()+")"));
            env.addPercept(getId().toString(), Literal.parseLiteral("hasPosition("+inVicinity.getId()+","+inVicinity.getPosition().x+","+inVicinity.getPosition().y+")"));
                                
        }
    }
    
    /**
     * The on-screen label for this agent drawn in {@link ModelObject#render(Graphics, Dimension, Point)}. Commonly extended by
     * specialisations of this class.
     * @return
     */
    public String getLabel(){
        return getId().toString();
    }

    public Point getPosition() {
        return position;
    }
    
    public String toString(){
        return super.toString() + "("+position.x+","+position.y+")";
    }
    
    public void render(Graphics g, Dimension tileSize, Point origin){
        Dimension size = new Dimension(tileSize.width / 4, tileSize.height / 4);
        
        Point centre = new Point(
                origin.x+getPosition().x*tileSize.width + (int)(tileSize.width * getOffset()),
                origin.y+getPosition().y*tileSize.height + (int)(tileSize.height/2));
        
        
        g.setColor(getColour());
        g.fillOval(
                centre.x - size.width/2,
                centre.y - size.height/2,
                size.width,
                size.height);
        
        int lineBottom = centre.y+(int)((tileSize.height/2) + (tileSize.height*2 - (tileSize.height*getOffset()*2)));
        g.drawLine(centre.x, centre.y, centre.x, lineBottom);
        
        g.setFont(new Font("arial", tileSize.width, tileSize.height/2));
        g.drawString(getLabel(), centre.x, lineBottom+tileSize.height/2);
    }
    
    protected float getOffset(){
        return 0.6f;
    }
    
    protected Color getColour(){
        return Color.CYAN;
    }
    

    
    
}
