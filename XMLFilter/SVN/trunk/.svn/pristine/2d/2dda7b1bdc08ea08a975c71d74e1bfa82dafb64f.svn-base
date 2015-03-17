package jmca.owl2mas.handler;

import java.net.URI;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.Vector;

import jmca.util.JMCAParams;

import org.semanticweb.owl.model.OWLIndividual;

import owl2mas.OWL2MASLoader;
import owl2mas.exception.OWL2MASInvalidMASOntologyException;
import owl2mas.handler.ObjectPropertyHandler;


public class SelectionStrategyClassEntryHandler implements ObjectPropertyHandler{
    
    class ClassEntry implements Comparable{
        public String className;
        public Integer position;
        
        
        public ClassEntry(String className, Integer position) {
            super();
            this.className = className;
            this.position = position;
        }


        public int compareTo(Object o) {
            if(o instanceof ClassEntry){
                ClassEntry c = (ClassEntry)o;               
                return position.compareTo(c.position);
            }else{
                throw new RuntimeException("Attempting to compare a class entry to something that is not a class entry");
            }
        }
        
        
    }

    public void handle(OWLIndividual agent, Set<OWLIndividual> values, OWL2MASLoader loader, HashMap<String, String> optionMap) throws OWL2MASInvalidMASOntologyException {
        Set<OWLIndividual> classEntries = loader.getPellet().getRelatedIndividuals(
                agent, 
                loader.getFactory().getOWLObjectProperty(URI.create(JMCAParams.JMCA_OWL_NS + "hasSelectionStrategyClassEntry")));
        
        System.out.println("Class entries for "+agent+": "+classEntries);
        
        HashMap<Class, Vector<ClassEntry>> aspectLists = new HashMap<Class, Vector<ClassEntry>>();
        for(Class aspect : JMCAParams.aspects){
            aspectLists.put(aspect, new Vector<ClassEntry>());
        }
        
        System.out.println("Aspects: "+aspectLists);
        
        
        for(OWLIndividual classEntry : classEntries){
            OWLIndividual cls = loader.getPellet().getRelatedIndividual(
                    classEntry, 
                    loader.getFactory().getOWLObjectProperty(URI.create(JMCAParams.JMCA_OWL_NS+"hasSelectionStrategyClass")));
            
            System.out.println("Class: "+cls);
            
            String className = loader.getPellet().getRelatedValue(
                    cls, 
                    loader.getFactory().getOWLDataProperty(URI.create(loader.getMAS_NS() + "hasClassName"))).getLiteral();
            
            int position = Integer.parseInt(loader.getPellet().getRelatedValue(
                    classEntry, 
                    loader.getFactory().getOWLDataProperty(URI.create(JMCAParams.JMCA_OWL_NS+"hasPosition"))).getLiteral());
            
            
            String aspectName = loader.getPellet().getRelatedIndividual(
                    cls, 
                    loader.getFactory().getOWLObjectProperty(URI.create(JMCAParams.JMCA_OWL_NS+"hasAspect"))).getURI().getFragment();
            
            Class aspect;
            try {
                aspect = Class.forName("jason.asSemantics."+aspectName);
            } catch (ClassNotFoundException e) {
                throw new OWL2MASInvalidMASOntologyException("Unknown aspect class ", e);
            }
            aspectLists.get(aspect).add(new ClassEntry(className, position));           
            
        }       
        
        
        for(Map.Entry<Class, Vector<ClassEntry>> entry : aspectLists.entrySet()){
            String paramName = "jmca_"+entry.getKey().getSimpleName()+"_selection_strategies";
            String paramValue = "";
            
            Collections.sort(entry.getValue());
            
            for(ClassEntry value : entry.getValue()){
                paramValue += value.className+",";
            }
            if(paramValue.length() >0 ){
                paramValue = paramValue.substring(0, paramValue.length()-1);
                optionMap.put(paramName, "\""+paramValue+"\"");
            }           
            
            
        }
    }
}
