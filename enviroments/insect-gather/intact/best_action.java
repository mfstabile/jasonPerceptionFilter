// Internal action code for project mars.mas2j
package intact;

import jason.*;
import jason.asSemantics.*;
import jason.asSyntax.*;
import java.util.Iterator;
import java.util.LinkedList;

public class best_action extends DefaultInternalAction {

    @Override
    public Object execute(TransitionSystem ts, Unifier un, Term[] terms) throws Exception {
        //System.out.println("Finding best action");
        Position agent = null;
        Position base = null;

        int[] quadrant = new int[4];
        int width = 0;
        int height = 0;
        LinkedList<Position> positions = new LinkedList<Position>();
        Iterator it = ts.getAg().getBB().iterator();
        while (it.hasNext()) {
            Literal lit = (Literal) it.next();
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
            if (lit.getTerm(0).toString().startsWith("r1") && !lit.toString().contains("garbage")) {
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
            if (lit.getTerm(0).toString().startsWith("r2") && !lit.toString().contains("garbage")) {
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
            if (manhattanDistance(agent, position) <= 1) {
                bestNext = position;
                break;
            } else if (manhattanDistance(agent, position) <= 2) {
                bestNext = position;
                quadrant[quadrant(agent, position)]++;
            } else {
                quadrant[quadrant(agent, position)]++;
            }
        }
        if (bestNext == null) {
            // = new Position(10, 10);/*
            int[] qSize = new int[4];
            qSize[0] = agent.x * agent.y;
            qSize[1] = (width - agent.x) * agent.y;
            qSize[2] = agent.x * (height - agent.y);
            qSize[3] = (width - agent.x) * (height - agent.y);
            double[] qScore = new double[4];
            //System.out.println("Scores");

            for (int i = 0; i < qScore.length; i++) {
                qScore[i] = (double) quadrant[i] / qSize[i];
                //System.out.println(qScore[i]);
            }
            switch (biggest(qScore[0], qScore[1], qScore[2], qScore[3])) {
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
            }//*/
            if (bestNext.x < 0) {
                bestNext.x = 0;
            }
            if (bestNext.y < 0) {
                bestNext.y = 0;
            }
        }

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

    int manhattanDistance(Position p1, Position p2) {
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
