/* 
 *  Copyright (C) 2008 Thomas Klapiscak (t.g.klapiscak@durham.ac.uk)
 *  
 *  This file is part of JASDL.
 *
 *  JASDL is free software: you can redistribute it and/or modify
 *  it under the terms of the Lesser GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *
 *  JASDL is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  Lesser GNU General Public License for more details.
 *
 *  You should have received a copy of the Lesser GNU General Public License
 *  along with JASDL.  If not, see <http://www.gnu.org/licenses/>.
 *  
 */
package commerce.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import owl2mas.model.ObjectModel;

import commerce.env.CommerceEnvironment;
import commerce.model.CommerceModel;
import commerce.model.CustomerModel;
import commerce.model.EmbodiedAgentModel;
import commerce.ui.customer.CustomerUIPanel;

/**
 * Displays a bird-eye view of the commerce world and a tab (containing a CustomerUIPane) for each customer present.
 * Runs in its own thread responsible for rendering the world at a set interval.
 * @author Tom Klapiscak
 *
 */
public class CommerceView extends JFrame implements Runnable{
    
    private final CommerceView view;
    private final CommerceModel model;
    private final CommerceViewPane viewPane;
    private JTabbedPane tabs;
    private CommerceEnvironment env;
    private JPanel masterPane;

    public CommerceView(CommerceModel model, CommerceEnvironment env) {
        super("JASDL MAS Example: Commerce");
        
        this.model = model;
        this.view = this;
        this.env = env;
        
        
            
        masterPane = new JPanel();      
            masterPane.setLayout(new BoxLayout(masterPane, BoxLayout.X_AXIS));
            add(masterPane);
        
            // Add the environment view pane
            viewPane = new CommerceViewPane();  
                viewPane.setPreferredSize(new Dimension(500, 300));
                masterPane.add( viewPane );     
            
            // Add the customer tabs
            tabs = new JTabbedPane();
                tabs.setVisible(true);
                masterPane.add(tabs);       
        
        
        new Thread(this).start();   
        
        setPreferredSize(new Dimension(980, 740));
        
        pack();
        setVisible(true);
    }
    
    
    /**
     * Add a customer tab
     * @param customer
     */
    public void addCustomer(CustomerModel customer){
        CustomerUIPanel panel = new CustomerUIPanel(env, customer);
        tabs.addTab(customer.getLabel(), panel);        
    }
    
    
    public void update(){
        viewPane.repaint();
    }
    public void run() {
        
        while(true){
            
            synchronized(model.getObjects()){
                view.update();
            }
            try {
                Thread.sleep(250);
            } catch (InterruptedException e) {
            }
        }
    }
    

    
    
    
    
    class CommerceViewPane extends JPanel{
        
        

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            
            // TODO: extract to window listener
            Dimension tileSize = new Dimension(
                    getSize().width / model.getGridSize().width,
                    getSize().height / model.getGridSize().height
                    );
            
            Dimension borderSize = new Dimension(tileSize.width*2, tileSize.height*2);
            
            Point origin = new Point(borderSize.width, borderSize.height);
            
            Dimension renderSize = new Dimension(getSize().width - (borderSize.width*2), getSize().height - (borderSize.height*2));
            
            // adapt tileSize to respect borders
            tileSize = new Dimension(
                    renderSize.width / model.getGridSize().width,
                    renderSize.height / model.getGridSize().height
                    );
            
            g.setColor(Color.GRAY);
            for(int x=0; x<model.getGridSize().width; x++){
                g.drawLine(origin.x+x*tileSize.width, origin.y, origin.x+x*tileSize.width, origin.y+renderSize.height);             
                for(int y=0; y<model.getGridSize().height; y++){
                    g.drawLine(origin.x, origin.y+y*tileSize.height, origin.x+renderSize.width, origin.y+y*tileSize.height);
                }
            }
            
            g.setColor(Color.BLACK);
            g.drawRect(origin.x, origin.y, renderSize.width, renderSize.height);
            
            g.setColor(Color.RED);
            for(ObjectModel o : model.getObjects()){
                if(o instanceof EmbodiedAgentModel){
                    ((EmbodiedAgentModel)o).render(g, tileSize, origin);
                }               
            }
            
        }


        
    }

}
