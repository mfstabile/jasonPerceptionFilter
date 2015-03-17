package example;

import jason.asunit.TestAgent;

import org.junit.Before;
import org.junit.Test;

public class TestExample {

    TestAgent ag; 

    // initialisation of the agent test
    @Before
    public void setupAg() {
        ag = new TestAgent();
        
        // defines the agent's AgentSpeak code
        ag.parseAScode(
                "b(10). b(20). "+
                "+!begin <- ?something(X); action(X). "+
                "+?something(Y) <- Y=22."
        );
    }
    
    @Test(timeout=2000)
    public void testInitialBels() {
        ag.assertBel("b(20)",0);       // agent must believe "b(20)" without any reasoning
        ag.assertBel("not b",0); 
        ag.assertBel("not b(5)",0);
        ag.assertBel("b(10) & b(20) & not b(60)",0);
    }
    
    @Test(timeout=2000)
    public void testAction() {
        ag.addGoal("begin");           // add a new goal for the agent
        ag.assertEvt("+!begin", 0);    // the agent have an event like '+!begin' in the set of events now
        ag.assertAct("action(22)", 4); // the agent have to perform 'action(22)' in 4 reasoning cycles
    }

    @Test(timeout=2000)
    public void testIdle1() {
        ag.assertIdle(0);              // the agent should be initially in idle
    }
    
    @Test(timeout=2000)
    public void testIdle2() {
        ag.addGoal("begin");           // add a new goal for the agent
        ag.addGoal("begin"); 
        ag.assertIdle(10);             // the agent becomes idle in 10 cycles
    }
}
