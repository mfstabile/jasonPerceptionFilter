// Internal action code for project mars.mas2j

package path;

import jason.*;
import jason.asSemantics.*;
import jason.asSyntax.*;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Random;

public class bestDirection extends DefaultInternalAction {

    public static Random random = new Random(1);

    @Override
    public Object execute(TransitionSystem ts, Unifier un, Term[] terms) throws Exception {
        // execute the internal action
        Position agent = null;
        Position base = null;
        String agentName = terms[2].toString();

        int[] quadrant = new int[4];
        int width = 0;
        int height = 0;
        int gridSize = 0;
        LinkedList<Position> positions = new LinkedList<Position>();
        LinkedList<Position> agentPositions = new LinkedList<Position>();
        Iterator it = ts.getAg().getBB().iterator();
        while (it.hasNext()) {
            Literal lit = (Literal) it.next();
            if (lit.toString().contains("grid")) {
                gridSize = Integer.parseInt(lit.getTerm(0).toString());
            }
            //System.out.println(lit);
            if (lit.getTerm(0).toString().startsWith("t")) {
                int x = Integer.parseInt(lit.getTerm(1).toString());
                int y = Integer.parseInt(lit.getTerm(2).toString());
                positions.add(new Position(x, y));
                if (x > width) {
                    width = x;
                }
                if (y > height) {
                    height = y;
                }
            }
            if (lit.getTerm(0).toString().startsWith(agentName) && !lit.toString().contains("garbage")) {
                int x = Integer.parseInt(lit.getTerm(1).toString());
                int y = Integer.parseInt(lit.getTerm(2).toString());
                agent = new Position(x, y);
                if (x > width) {
                    width = x;
                }
                if (y > height) {
                    height = y;
                }
//Term Tx = new NumberTermImpl(agent.x);
//Term Ty = new NumberTermImpl(agent.y);
//return un.unifies(terms[0], Tx) & un.unifies(terms[1], Ty);

            }
            if (lit.getTerm(0).toString().startsWith("r") && !lit.toString().contains("garbage") && !lit.getTerm(0).toString().startsWith(agentName)) {
                int x = Integer.parseInt(lit.getTerm(1).toString());
                int y = Integer.parseInt(lit.getTerm(2).toString());
                agentPositions.add(new Position(x, y));
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
                base = new Position(x, y);
                if (x > width) {
                    width = x;
                }
                if (y > height) {
                    height = y;
                }
            }
        }
        Position bestNext = null;
        for (Position position : positions) {
            if (euclideanDistance(agent, position) <= 1) {
                //System.out.println("seguindo 1");
                bestNext = position;
                break;
            } else if (euclideanDistance(agent, position) <= 2) {
                bestNext = position;
                quadrant[quadrant(agent, position)]++;
            } else {
                quadrant[quadrant(agent, position)]++;
            }
        }

        for (Position position : agentPositions) {
            quadrant[quadrant(agent, position)]-=2;
        }
        //if (bestNext != null) System.out.println("seguindo 2");
        if (bestNext == null) {
            // = new Position(10, 10);/*
            /*int[] qSize = new int[4];
            qSize[0] = agent.x * agent.y;
            qSize[1] = (width - agent.x) * agent.y;
            qSize[2] = agent.x * (height - agent.y);
            qSize[3] = (width - agent.x) * (height - agent.y);*/
            double[] qScore = new double[4];
            //System.out.println("Scores");
            
            for (int i = 0; i < qScore.length; i++) {
                qScore[i] = (double) quadrant[i];// / qSize[i];
                //System.out.println(qScore[i]);
            }
            int biggest = biggest(qScore[0], qScore[1], qScore[2], qScore[3]);
            if(qScore[biggest] == 0){
                biggest = random.nextInt(5);
            }
            switch (biggest) {
                case 0:
                    bestNext = new Position(agent.x - 1, agent.y - 1);
                    break;
                case 1:
                    bestNext = new Position(agent.x + 1, agent.y - 1);
                    break;
                case 2:
                    bestNext = new Position(agent.x - 1, agent.y + 1);
                    break;
                case 3:
                    bestNext = new Position(agent.x + 1, agent.y + 1);
                    break;
                default:
                    bestNext = new Position(agent.x, agent.y);
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
        //System.out.println("seguindo direcao");
        Term Tx = new NumberTermImpl(bestNext.x);
        Term Ty = new NumberTermImpl(bestNext.y);
        //System.out.println("Best action found");

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

    int euclideanDistance(Position p1, Position p2) {
        //System.out.println(p1 + "-" + p2 + "-" + Math.abs(p1.x - p2.x) + Math.abs(p1.y - p2.y));
        return Math.abs(p1.x - p2.x) + Math.abs(p1.y - p2.y);
    }

    int quadrant(Position ag, Position pos) {
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

class Position {

    int x;
    int y;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Position() {
        this.x = 0;
        this.y = 0;
    }

    public boolean equals(Position g) {
        if (g.x == x && g.y == y) {
            return true;
        }
        return false;
    }
}

