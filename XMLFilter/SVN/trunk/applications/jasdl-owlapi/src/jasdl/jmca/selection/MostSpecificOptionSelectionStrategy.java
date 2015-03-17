package jasdl.jmca.selection;

import jasdl.asSemantics.JASDLAgent;
import jasdl.util.JASDLCommon;
import jason.asSemantics.Agent;
import jason.asSemantics.Option;

import java.util.List;
import java.util.Vector;

import jmca.selection.SelectionStrategy;
import jmca.util.JmcaException;

public class MostSpecificOptionSelectionStrategy extends SelectionStrategy<Option> {
    
    private JASDLAgent jasdlMaster;

    public MostSpecificOptionSelectionStrategy(Agent master) {
        super(master);
        if(!(master instanceof JASDLAgent)){
            throw new RuntimeException("Most Specific Option Selection Strategy may only be used in conjunction with a JASDL agent");
        }       
        this.jasdlMaster = (JASDLAgent)master;
    }

    /**
     * Selects the most specific option from the intersection chosen by the selection chain up till now.
     */
    @Override
    public List<Option> select(List<Option> all, List<Option> intersection) throws JmcaException {

        Option mostSpecific = null;
        for(Option choice : intersection){
            if(mostSpecific == null){
                mostSpecific = choice;
            }else{
                try {
                    if(JASDLCommon.isMoreSpecific(
                            choice.getPlan().getTrigger().getLiteral(), 
                            mostSpecific.getPlan().getTrigger().getLiteral(), 
                            jasdlMaster.getJom()))  mostSpecific = choice;                  
                } catch (Exception e) {
                    throw new JmcaException("Most specific option selection failed", e);
                }
            }
        }
        List<Option> chosen = new Vector<Option>();
        if(mostSpecific != null){
            chosen.add(mostSpecific);
        }
        return chosen;
    }

}
