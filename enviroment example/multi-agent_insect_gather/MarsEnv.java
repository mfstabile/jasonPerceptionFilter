import jason.asSyntax.*;
import jason.environment.TimeSteppedEnvironment;
import jason.environment.grid.GridWorldModel;
import jason.environment.grid.GridWorldView;
import jason.environment.grid.Location;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.util.Random;
import java.util.logging.Logger;
import java.util.Iterator;
import java.util.LinkedList;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class MarsEnv extends TimeSteppedEnvironment {

    public static final int GSize = 20; // grid size
    public static final int GARB  = 16; // garbage code in grid model
    public static final int InsectNumber = 30; // insect number
    public static final int AgNumber = 4; // agent number

    public static int[] captures;
    public static int captureTotal = 0;
    public static int currentGarb = 1;
    public static int step = 0;

    public static final Term    ns = Literal.parseLiteral("next(slot)");
    public static final Term    pg = Literal.parseLiteral("pick(garb)");
    public static final Term    dg = Literal.parseLiteral("drop(garb)");
    public static final Term    bg = Literal.parseLiteral("burn(garb)");
    public static final Literal g2 = Literal.parseLiteral("garbage(burner)");

    static Logger logger = Logger.getLogger(MarsEnv.class.getName());

    private MarsModel model;
    private MarsView  view;
    
    @Override
    public void init(String[] args) {
        super.init(new String[] { "5000" } ); // set step timeout
        setOverActionsPolicy(OverActionsPolicy.ignoreSecond);
        model = new MarsModel();
        view  = new MarsView(model);
        model.setView(view);
        updateAgsPercept();

    }
    
    private int getAgIdBasedOnName(String agName) {
        if(agName.equals("burner")){
            return 0;
        }
        return (Integer.parseInt(agName.substring(1,agName.length())));
    }

    @Override
    public boolean executeAction(String ag, Structure action) {
        int agId = getAgIdBasedOnName(ag);
        logger.info(ag+" doing: "+ action);
        try {
            if (action.equals(ns)) {
                model.nextSlot();
            } else if (action.getFunctor().equals("move_towards")) {
                int x = (int)((NumberTerm)action.getTerm(0)).solve();
                int y = (int)((NumberTerm)action.getTerm(1)).solve();
                model.moveTowards(agId,x,y);
            } else if (action.equals(pg)) {
                return model.pickGarb(agId);
            } else if (action.equals(dg)) {
                model.dropGarb(agId);
            } else if (action.equals(bg)) {
                model.burnGarb();
            } else if (action.getFunctor().equals("move_towards")) {

            } else {
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return true;
    }
    
    static StepInformation currentStepInformation;
    @Override
    protected void stepStarted(int step) {
        currentStepInformation = new StepInformation();        
    }

    @Override
    protected void stepFinished(int step, long time, boolean timeout) {
        currentStepInformation.stopTime();
        currentStepInformation.setInsectsCaptured(captureTotal);
        currentStepInformation.setStep(this.step);
        //currentStepInformation.recordInformation();

        System.out.println("begin stepFinished"+step);
        this.step++;
        
        if(step>305){
            System.exit(0);
        }

        model.removeGarbage();
        model.updateGarbage();
        model.addGarbage();
        view.repaint();

        try {
            Thread.sleep(200);
        } catch (Exception e) {
        }
    }
    
    @Override
    protected void updateAgsPercept() {
        clearPercepts();
        
        Location burnerLoc = model.getAgPos(0);
        Literal pos2 = Literal.parseLiteral("pos(burner," + burnerLoc.x + "," + burnerLoc.y + ")");
        addPercept(pos2);

        for (int i=1; i<AgNumber; i++) {
            clearPercepts("r"+i);
            Location rLoc = model.getAgPos(i);
            Literal pos = Literal.parseLiteral("pos(r" + i + "," + rLoc.x + "," + rLoc.y + ")");
            addPercept(pos);

            if (model.hasObject(GARB, rLoc) && !pos.equals(burnerLoc)) {
                Literal g = Literal.parseLiteral("garbage(r"+i+")");
                addPercept(g);
            }

            for (Garbage garb : model.garbageList) {
                if(!garb.at(burnerLoc)){
                    double dist = Math.sqrt(Double.valueOf(Math.pow(rLoc.x - garb.x,2) + Math.pow(rLoc.y - garb.y,2)));
                    Literal garbL = Literal.parseLiteral("pos(t" + garb.id + "," + garb.x + "," + garb.y + "," + step + ")[distance(" + dist + ")]");
                    addPercept("r"+i,garbL);
                }
            }
        }
        
        Literal stepL = Literal.parseLiteral("step(" + step + ")");
        addPercept(stepL);

        Literal gridL = Literal.parseLiteral("grid(" + GSize + ")");
        addPercept(gridL);

        if (model.hasObject(GARB, burnerLoc)) {
            addPercept(g2);
        }
    }

    class Garbage {

        int id;
        int x;
        int y;

        public Garbage(int x, int y) {
            this.id = currentGarb;
            currentGarb++;
            this.x = x;
            this.y = y;
        }

        public boolean at(Garbage g) {
            if (g.x == x && g.y == y) {
                return true;
            }
            return false;
        }

        public boolean at(Location l){
            if (l.x == x && l.y == y) {
                return true;
            }
            return false;
        }

        public boolean at(int x2, int y2){
            if (x2 == x && y2 == y) {
                return true;
            }
            return false;
        }
    }

    class StepInformation{
        private int step;
        private int insectsCaptured;
        private long startingTime;
        private long endingTime;
        private long timeTaken;

        public StepInformation(){
            startingTime = System.nanoTime();
        }

        public void stopTime(){
            endingTime = System.nanoTime();
        }

        public void setInsectsCaptured(int captures){
            insectsCaptured = captures;
        }

        public void setStep(int step){
            this.step = step;
        }

        public void recordInformation(){
            timeTaken = endingTime - startingTime;
            PrintWriter out = null;
            try {
                out = new PrintWriter(new BufferedWriter(new FileWriter("execution log/enviroment log.txt", true)));
                out.println("step " + step + ":" + timeTaken + " : " + "no action recorded" + " : " + insectsCaptured + " captured"  + " Begin:" + startingTime + " End:" + endingTime);
            } catch (IOException ex) {
                System.out.println("ERRO NO LOG-------------");
            } finally {
                out.close();
            }
        }
    }

    class MarsModel extends GridWorldModel {
        
        Random random = new Random(1);
        boolean[] hasInsect;
        
        LinkedList<Garbage> garbageList = new LinkedList<Garbage>();

        private MarsModel() {
            super(GSize, GSize, AgNumber);
            hasInsect = new boolean[AgNumber];
            captures = new int[AgNumber];
            // initial location of agents
            try {
                for (int i=1; i<AgNumber; i++) {
                    setAgPos(i, random.nextInt(GSize), random.nextInt(GSize));
                }
                Location burnerLoc = new Location(GSize/2, GSize/2);
                setAgPos(0, burnerLoc);
            } catch (Exception e) {
                e.printStackTrace();
            }
            
            // initial location of garbage
            for (int i = 0; i < InsectNumber; i++) {
                int x = random.nextInt(width);
                int y = random.nextInt(width);
                garbageList.add(new Garbage(x, y));
                add(GARB, x, y);
            }
        }
        void deleteGarb(int x, int y) {
            Iterator<Garbage> it = garbageList.iterator();
            while (it.hasNext()) {
                if (it.next().at(new Garbage(x, y))) {
                    it.remove();
                    return;
                }
            }
        }

        void removeGarbage() {
            for (Garbage garb : garbageList) {
                remove(GARB, garb.x, garb.y);
            }
        }
        
        void updateGarbage() {
            boolean isAtAgentPosition = false;
            for (Garbage garb : garbageList) {
                isAtAgentPosition = false;
                for (int i=0; i<AgNumber; i++) {
                    if(garb.at(getAgPos(i))){
                        isAtAgentPosition=true;
                    }
                }
                if(isAtAgentPosition)continue;

                switch (random.nextInt(5)) {
                    case 0:
                        if (!(garb.x + 1 == width)) {
                            garb.x++;
                        }
                        break;
                    case 1:
                        if (!(garb.y + 1 == height)) {
                            garb.y++;
                        }
                        break;
                    case 2:
                        if (garb.x != 0) {
                            garb.x--;
                        }
                        break;
                    case 3:
                        if (garb.y != 0) {
                            garb.y--;
                        }
                        break;
                }
            }
        }

        void addGarbage() {
            for (Garbage garb : garbageList) {
                add(GARB, garb.x, garb.y);
            }
        }
        
        void nextSlot() throws Exception {
            Location r1 = getAgPos(0);
            r1.x++;
            if (r1.x == getWidth()) {
                r1.x = 0;
                r1.y++;
            }
            // finished searching the whole grid
            if (r1.y == getHeight()) {
                return;
            }
        }
        
        void moveTowards(int agent, int x, int y) throws Exception {
            Location r1 = getAgPos(agent);
            if (r1.x < x)
                r1.x++;
            else if (r1.x > x)
                r1.x--;
            if (r1.y < y)
                r1.y++;
            else if (r1.y > y)
                r1.y--;
            setAgPos(agent, r1);
            setAgPos(0, getAgPos(0)); // just to draw it in the view
        }
        
        boolean pickGarb(int agent) {
            // agent location has garbage
            if (model.hasObject(GARB, getAgPos(agent))) {
                remove(GARB, getAgPos(agent));
                deleteGarb(getAgPos(agent).x, getAgPos(agent).y);
                hasInsect[agent] = true;
                captures[agent]++;
                captureTotal++;
            } else{
                return false;
            }
            return true;
        }
        void dropGarb(int agent) {
            if (hasInsect[agent]) {
                hasInsect[agent] = false;
                add(GARB, getAgPos(agent));
                while(garbageList.size()<InsectNumber){
                    garbageList.add(new Garbage(random.nextInt(width), random.nextInt(height)));
                }
            }
        }
        void burnGarb() {
            // burner location has garbage
            while (model.hasObject(GARB, getAgPos(0))) {
                remove(GARB, getAgPos(0));
            }
        }
    }
    
    class MarsView extends GridWorldView {

        public MarsView(MarsModel model) {
            super(model, "Mars World", 600);
            defaultFont = new Font("Arial", Font.BOLD, 18); // change default font
            setVisible(true);
            repaint();
        }

        /** draw application objects */
        @Override
        public void draw(Graphics g, int x, int y, int object) {
            switch (object) {
                case MarsEnv.GARB: drawGarb(g, x, y); break;
            }
        }

        @Override
        public void drawAgent(Graphics g, int x, int y, Color c, int id) {
            String label = "R"+(id);
            c = Color.blue;
            if (id > 0) {
                c = Color.yellow;
                if (((MarsModel)model).hasInsect[id]) {
                    label += " - I";
                    c = Color.orange;
                }
            }
            super.drawAgent(g, x, y, c, -1);
            if (id > 0) {
                g.setColor(Color.black);
            } else {
                g.setColor(Color.white);
            }
            super.drawString(g, x, y, defaultFont, label);
        }

        public void drawGarb(Graphics g, int x, int y) {
            super.drawAgent(g, x, y, Color.black, 0);
            g.setColor(Color.white);
            drawString(g, x, y, defaultFont, "I");
        }
    }    
}
