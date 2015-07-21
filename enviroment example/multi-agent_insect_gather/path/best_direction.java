// Internal action code for project mars.mas2j

package path;

import jason.*;
import jason.asSemantics.*;
import jason.asSyntax.*;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Random;

public class best_direction extends DefaultInternalAction {

    public static Random random = new Random(1);

    private double getDistance(PositionId pos1, PositionId pos2){
        return Math.sqrt(Double.valueOf(Math.pow(pos1.x - pos2.x,2) + Math.pow(pos1.y - pos2.y,2)));
    }

    private boolean isCloser(PositionId oldPos, PositionId newPos, PositionId agent){
        return(getDistance(newPos,agent)<getDistance(oldPos,agent));
    }

    private boolean gotCloser(PositionId insect, PositionId agent, LinkedList<PositionId> pastInsectPositions){    
        for (PositionId oldPos : pastInsectPositions) {
            if(oldPos.id.equals(insect.id)){
                return isCloser(oldPos,insect,agent);
            }
        }
        return false;
    }

    @Override
    public Object execute(TransitionSystem ts, Unifier un, Term[] terms) throws Exception {
        // execute the internal action
        PositionId agent = null;
        PositionId base = null;
        int currentStep;
        String agentName = terms[2].toString();

        int[] quadrant = new int[4];
        int width = 0;
        int height = 0;
        int gridSize = 0;
        LinkedList<PositionId> positions = new LinkedList<PositionId>();
        LinkedList<PositionId> pastInsectPositions = new LinkedList<PositionId>();
        LinkedList<PositionId> agentPositions = new LinkedList<PositionId>();
        Iterator it = ts.getAg().getBB().iterator();

        while (it.hasNext()) {
            Literal lit = (Literal) it.next();
            if (lit.toString().contains("grid")) {
                gridSize = Integer.parseInt(lit.getTerm(0).toString());
            }

            if (lit.toString().startsWith("at(t")) {

                int x = Integer.parseInt(lit.getTerm(1).toString());
                int y = Integer.parseInt(lit.getTerm(2).toString());

                pastInsectPositions.add(new PositionId(x, y, lit.getTerm(0).toString()));

                if (x > width) {
                    width = x;
                }
                if (y > height) {
                    height = y;
                }
            }

            if (lit.toString().startsWith("pos") && lit.getTerm(0).toString().startsWith("t")) {
                int x = Integer.parseInt(lit.getTerm(1).toString());
                int y = Integer.parseInt(lit.getTerm(2).toString());
                positions.add(new PositionId(x, y, lit.getTerm(0).toString()));
                if (x > width) {
                    width = x;
                }
                if (y > height) {
                    height = y;
                }
            }
            if (lit.toString().startsWith("pos") && lit.getTerm(0).toString().startsWith(agentName) && !lit.toString().contains("garbage")) {
                int x = Integer.parseInt(lit.getTerm(1).toString());
                int y = Integer.parseInt(lit.getTerm(2).toString());
                agent = new PositionId(x, y, lit.getTerm(0).toString());
                if (x > width) {
                    width = x;
                }
                if (y > height) {
                    height = y;
                }
            }
            if (lit.getTerm(0).toString().startsWith("r") && !lit.toString().contains("garbage") && !lit.getTerm(0).toString().startsWith(agentName)) {
                int x = Integer.parseInt(lit.getTerm(1).toString());
                int y = Integer.parseInt(lit.getTerm(2).toString());
                agentPositions.add(new PositionId(x, y, lit.getTerm(0).toString()));
                if (x > width) {
                    width = x;
                }
                if (y > height) {
                    height = y;
                }
            }
            if (lit.getTerm(0).toString().startsWith("burner") && !lit.toString().contains("garbage")) {
                int x = Integer.parseInt(lit.getTerm(1).toString());
                int y = Integer.parseInt(lit.getTerm(2).toString());
                base = new PositionId(x, y, lit.getTerm(0).toString());
                if (x > width) {
                    width = x;
                }
                if (y > height) {
                    height = y;
                }
            }
        }
        PositionId bestNext = null;
        for (PositionId position : positions) {
            if (euclideanDistance(agent, position) <= 1) {
                bestNext = position;
                break;
            } else if (euclideanDistance(agent, position) <= 2) {
                bestNext = position;
                if(gotCloser(position,agent,pastInsectPositions)){
                    quadrant[quadrant(agent, position)]++;
                }
            } else {
                if(gotCloser(position,agent,pastInsectPositions)){
                    quadrant[quadrant(agent, position)]++;
                }
            }
        }

        for (PositionId position : agentPositions) {
            quadrant[quadrant(agent, position)]-=5;
        }

        if (bestNext == null) {
            double[] qScore = new double[4];
            
            for (int i = 0; i < qScore.length; i++) {
                qScore[i] = (double) quadrant[i];
            }
            int biggest = biggest(qScore[0], qScore[1], qScore[2], qScore[3]);
            if(qScore[biggest] == 0){
                biggest = random.nextInt(4);
            }
            switch (biggest) {
                case 0:
                    bestNext = new PositionId(agent.x - 1, agent.y - 1, agentName);
                    break;
                case 1:
                    bestNext = new PositionId(agent.x + 1, agent.y - 1, agentName);
                    break;
                case 2:
                    bestNext = new PositionId(agent.x - 1, agent.y + 1, agentName);
                    break;
                case 3:
                    bestNext = new PositionId(agent.x + 1, agent.y + 1, agentName);
                    break;
                default:
                    bestNext = new PositionId(agent.x, agent.y, agentName);
            }
            //*/
            if (bestNext.x < 0) {
                bestNext.x = 0;
            }
            if (bestNext.y < 0) {
                bestNext.y = 0;
            }
            if (bestNext.x >= gridSize) {
                bestNext.x = gridSize-1;
            }
            if (bestNext.y >= gridSize) {
                bestNext.y = gridSize-1;
            }

        }
        Term Tx = new NumberTermImpl(bestNext.x);
        Term Ty = new NumberTermImpl(bestNext.y);
        
        return un.unifies(terms[0], Tx) & un.unifies(terms[1], Ty);
    }

    int biggest(double a, double b, double c, double d) {
        if (a >= b && a >= c && a >= d) {
            return 0;
        }
        if (b >= a && b >= c && b >= d) {
            return 1;
        }
        if (c >= a && c >= b && c >= d) {
            return 2;
        }
        if (d >= a && d >= b && d >= c) {
            return 3;
        }
        return 0;
    }

    int euclideanDistance(PositionId p1, PositionId p2) {
        return Math.abs(p1.x - p2.x) + Math.abs(p1.y - p2.y);
    }

    int quadrant(PositionId ag, PositionId pos) {
        if (ag.x >= pos.x) {
            if (ag.y >= pos.y) {
                return 0;
            } else {
                return 2;
            }
        } else {
            if (ag.y >= pos.y) {
                return 1;
            } else {
                return 3;
            }
        }
    }
}

class PositionId {

    String id;
    int x;
    int y;

    public PositionId(int x, int y, String id) {
        this.id = id;
        this.x = x;
        this.y = y;
    }

    public boolean at(PositionId g) {
        if (g.x == x && g.y == y) {
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


