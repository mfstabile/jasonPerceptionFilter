
import jason.asSyntax.*;
import jason.environment.Environment;
import jason.environment.grid.GridWorldModel;
import jason.environment.grid.GridWorldView;
import jason.environment.grid.Location;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MarsEnv extends Environment {

    public static final int GSize = 20; // grid size
    public static final int GARB = 16; // garbage code in grid model
    public static final int AGENTS = 20; // thief number


    public static final Term ns = Literal.parseLiteral("next(slot)");
    public static final Term pg = Literal.parseLiteral("pick(garb)");
    public static final Term dg = Literal.parseLiteral("drop(garb)");
    public static final Term bg = Literal.parseLiteral("burn(garb)");
    public static final Literal g1 = Literal.parseLiteral("garbage(r1)");//[priority(" + (2 * GSize) + 1 + ")]");
    public static final Literal g2 = Literal.parseLiteral("garbage(r2)");//[priority(" + (2 * GSize) + 1 + ")]");

    static Logger logger = Logger.getLogger(MarsEnv.class.getName());

    private MarsModel model;
    private MarsView view;

    Status currentStatus = null;
    String filename = "no filter";
    int step = 0;
    int thievesLeft = 0;
    long initTime;
    long totalTime = 0;
    @Override
    public void init(String[] args) {
        model = new MarsModel();
        view = new MarsView(model);
        model.setView(view);
        updatePercepts();
        //initTime = System.nanoTime();
    }

    public boolean executeAction(String ag, Structure action) {
        //logger.info("Action Received");
        long stopTime = System.nanoTime();
        if(initTime>0){
           totalTime += stopTime - initTime;
        }
        step++;
        if(step % 50 == 0){
            //long end = System.nanoTime();
            System.out.println(step + "steps. Time spent: " + (totalTime));
        }
        if (currentStatus != null && thievesLeft > 0) {
        //    logger.info("Entered if");
            currentStatus.actionName = action.toString();
        //    logger.info("1");
            currentStatus.end = stopTime;
        //    logger.info("2");
            currentStatus.storeInformation();
        //    logger.info("3");
        }
        //logger.info(ag + " doing: " + action);
        try {
            if (action.equals(ns)) {
                model.nextSlot();
            } else if (action.getFunctor().equals("move_towards")) {
                int x = (int) ((NumberTerm) action.getTerm(0)).solve();
                int y = (int) ((NumberTerm) action.getTerm(1)).solve();
                model.moveTowards(x, y);
            } else if (action.equals(pg)) {
                model.pickGarb();
            } else if (action.equals(dg)) {
                model.dropGarb();
            } else if (action.equals(bg)) {
                model.burnGarb();
            } else {
                return false;
            }
            model.burnGarb();
        } catch (Exception e) {
            e.printStackTrace();
        }
        //logger.info(ag + " did: " + action);
        if (ag.compareTo("r1") == 0) {
            model.removeGarbage();
        //    logger.info("garbage removed");
            model.updateGarbage();
        //    logger.info("garbage updated");
            model.addGarbage();
        //    logger.info("garbage added");
            view.repaint();
        //    logger.info("garbage repainted");
            updatePercepts();
        //    logger.info("percepts updated");
        }
        try {
            Thread.sleep(200);
        } catch (Exception e) {
        }
        //logger.info("slept");
        currentStatus = new Status(filename);
        currentStatus.begin = System.nanoTime();
        //logger.info("Percepts sent");
        informAgsEnvironmentChanged();
        initTime = System.nanoTime();
        return true;
    }

    /**
     * creates the agents perception based on the MarsModel
     */
    void updatePercepts() {
        clearPercepts();
        
        Literal stepL = Literal.parseLiteral("step(" + step + ")");
        addPercept(stepL);
        
        Location r1Loc = model.getAgPos(0);
        Location r2Loc = model.getAgPos(1);

        Literal pos1 = Literal.parseLiteral("pos(r1," + r1Loc.x + "," + r1Loc.y + "," + step + ")");//[priority(" + ((2 * GSize) + 1) + ")]");
        Literal pos2 = Literal.parseLiteral("pos(r2," + r2Loc.x + "," + r2Loc.y + "," + step + ")");//[priority(" + ((2 * GSize) + 1) + ")]");

        addPercept(pos1);
        addPercept(pos2);

        if (model.hasObject(GARB, r1Loc)) {
            addPercept(g1);
        }
        if (model.hasObject(GARB, r2Loc)) {
            addPercept(g2);
        }
        int i = 0;
        for (Garbage garb : model.garbageList) {
            double dist = Math.sqrt(Double.valueOf(Math.pow(r1Loc.x - garb.x,2) + Math.pow(r1Loc.y - garb.y,2)));
            //dist = ((2 * GSize) + 1) - dist;
            Literal garbL = Literal.parseLiteral("pos(t" + i + "," + garb.x + "," + garb.y + "," + step + ")[distance(" + dist + ")]");
            addPercept(garbL);
            i++;
        }
    }

    class Status {

        long begin;
        long end;
        String fileName;
        String actionName;

        public Status(String fileName) {
            this.fileName = fileName;
        }

        public void storeInformation() {
            PrintWriter out = null;
            try {
                out = new PrintWriter(new BufferedWriter(new FileWriter("enviroment log.txt", true)));
                long elapsedTime = end - begin;
                out.println("step " + step + ":" + elapsedTime + " : " + actionName + " : " + thievesLeft + " tLeft"  + " Begin:" + begin + " End:" + end);
            } catch (IOException ex) {
                System.out.println("ERRO NO LOG-------------");
            } finally {
                out.close();
            }
        }
    }

    class Garbage {

        int x;
        int y;

        public Garbage(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public boolean equals(Garbage g) {
            if (g.x == x && g.y == y) {
                return true;
            }
            return false;
        }
    }

    class MarsModel extends GridWorldModel {

        public static final int MErr = 0; // max error in pick garb
        int nerr; // number of tries of pick garb
        boolean r1HasGarb = false; // whether r1 is carrying garbage or not
        LinkedList<Garbage> garbageList;
        Random random = new Random(1);

        private MarsModel() {
            super(GSize, GSize, 2);
            garbageList = new LinkedList<Garbage>();
            // initial location of agents
            try {
                Location r2Loc = new Location(GSize / 2, GSize / 2);
                setAgPos(0, r2Loc);
                setAgPos(1, r2Loc);
            } catch (Exception e) {
                e.printStackTrace();
            }

            for (int i = 0; i < AGENTS; i++) {
                garbageList.add(new Garbage(random.nextInt(width), random.nextInt(height)));
            }
            //garbageList.add(new Garbage(3, 0));
            // initial location of garbage
/*            garbageList.add(new Garbage(3, 0));
             garbageList.add(new Garbage(GSize - 1, 0));
             garbageList.add(new Garbage(1, 2));
             garbageList.add(new Garbage(0, GSize - 2));
             garbageList.add(new Garbage(GSize - 1, GSize - 1));
             */
            addGarbage();
        }

        void deleteGarb(int x, int y
        ) {
            Iterator<Garbage> it = garbageList.iterator();
            while (it.hasNext()) {
                if (it.next().equals(new Garbage(x, y))) {
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
            thievesLeft = garbageList.size();
            for (Garbage garb : garbageList) {

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
                //System.out.println(garb.x + "-" + garb.y);
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
            setAgPos(0, r1);
            setAgPos(1, getAgPos(1)); // just to draw it in the view
        }

        void moveTowards(int x, int y) throws Exception {
            Location r1 = getAgPos(0);
            if (r1.x < x) {
                r1.x++;
            } else if (r1.x > x) {
                r1.x--;
            }
            if (r1.y < y) {
                r1.y++;
            } else if (r1.y > y) {
                r1.y--;
            }
            setAgPos(0, r1);
            setAgPos(1, getAgPos(1)); // just to draw it in the view
        }

        void pickGarb() {
            // r1 location has garbage
            if (model.hasObject(GARB, getAgPos(0))) {
                // sometimes the "picking" action doesn't work
                // but never more than MErr times
                if (random.nextBoolean() || nerr == MErr) {
                    remove(GARB, getAgPos(0));
                    deleteGarb(getAgPos(0).x, getAgPos(0).y);
                    nerr = 0;
                    r1HasGarb = true;
                } else {
                    nerr++;
                }
                //System.out.println("Picking up");
            }
        }

        int arrested = 0;
        void dropGarb() {
            if (r1HasGarb) {
                r1HasGarb = false;
                add(GARB, getAgPos(0));
                while(garbageList.size()<AGENTS){
                    garbageList.add(new Garbage(random.nextInt(width), random.nextInt(height)));
                    //System.out.println("Dropping and adding");
                }

            }
            arrested++;
            /*if(arrested % 10 == 0){
                long end = System.nanoTime();
                System.out.println(arrested + "Time spent: " + (end - initTime));
            }*/
        }

        void burnGarb() {
            // r2 location has garbage
            if (model.hasObject(GARB, getAgPos(1))) {
                remove(GARB, getAgPos(1));
            }
            //System.out.println("thievesLeft:" + thievesLeft + "step " + step);
        }
    }

    class MarsView extends GridWorldView {

        public MarsView(MarsModel model) {
            super(model, "Mars World", 600);
            defaultFont = new Font("Arial", Font.BOLD, 18); // change default font
            setVisible(true);
            repaint();
        }

        /**
         * draw application objects
         */
        @Override
        public void draw(Graphics g, int x, int y, int object) {
            switch (object) {
                case MarsEnv.GARB:
                    drawGarb(g, x, y);
                    break;
            }
        }

        @Override
        public void drawAgent(Graphics g, int x, int y, Color c, int id) {
            String label = "C" + (id + 1);
            c = Color.blue;
            if (id == 0) {
                c = Color.yellow;
                if (((MarsModel) model).r1HasGarb) {
                    label += " - I";
                    c = Color.orange;
                }
            }
            super.drawAgent(g, x, y, c, -1);
            if (id == 0) {
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
