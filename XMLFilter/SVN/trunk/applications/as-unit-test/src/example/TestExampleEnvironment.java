package example;

import jason.asunit.TestAgent;

import org.junit.Before;
import org.junit.Test;

public class TestExampleEnvironment {

    TestAgent ag; 

    // initialisation of the agent test
    @Before
    public void setupAg() {
        ag = new TestAgent();
        
        // defines the agent's AgentSpeak code
        ag.parseAScode(
               "+!start <- get_info_as_percept; "+
               "           !add_second_source; "+
               "           clear_my_percepts; "+
               "           !chose_act. " +
               "+!add_second_source <- +info[source(second_source)]. "+
               "+!chose_act : info[source(second_source)]     <- a1. "+
               "+!chose_act : not info[source(second_source)] <- a2. "
        );
        
        // setup the environment for the agent
        ag.getArch().setEnv(new BRFTestEnv());
    }
    
    @Test(timeout=2000)
    public void testPerception1() {
        ag.addGoal("start");           // add a new goal for the agent
        ag.assertBel("info[source(second_source), source(percept)]",10); // the agent should believe in info with two sources
    }
    @Test(timeout=2000)
    public void testPerception2() {
        ag.addGoal("start");           // add a new goal for the agent
        ag.assertBel("info[source(second_source)]",10); // the agent should believe in info with one sources
    }

    @Test(timeout=3000)
    public void testAction() {
        ag.addGoal("start");           // add a new goal for the agent
        ag.assertAct("a1", 20);        // the agent have to perform 'a1' in 10 reasoning cycles
    }
}
