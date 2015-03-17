package jmca.util;

import jason.asSemantics.ActionExec;
import jason.asSemantics.Event;
import jason.asSemantics.Intention;
import jason.asSemantics.Message;
import jason.asSemantics.Option;

import java.util.Arrays;
import java.util.Vector;

public class JMCAParams {
    
    /**
     * A static list of aspect types (classes) this Jmca supports (current Option, Message, Intention, Event, ActionExec)
     */
    public static Vector<Class> aspects = new Vector<Class>();
    static{
        aspects.addAll(Arrays.asList(new Class[] {Option.class, Message.class, Intention.class, Event.class, ActionExec.class}));
    }
    
    public static String JMCA_OWL_NS = "http://www.dur.ac.uk/t.g.klapiscak/onts/owl2mas/jmca.owl#";
}
