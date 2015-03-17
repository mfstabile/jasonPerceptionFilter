package ora4mas;

import java.util.logging.Level;
import java.util.logging.Logger;

import c4jason.CartagoEnvironment;
import cartago.CartagoNode;

public class CartagoOrgEnvironment extends CartagoEnvironment {
    private Logger logger = Logger.getLogger("ora4mas."+CartagoOrgEnvironment.class.getName());

    /** Called before the MAS execution with the args informed in .mas2j */
    @Override
    public void init(String[] args) {
        super.init(args);        
        try {
            CartagoNode.getInstance().createWorkspace(args[0]);
            logger.info("Organisational environment "+args[0]+" init OK.");
            //Thread.sleep(500); // give some time for cartago to finish the process
        } catch (Exception ex){
            logger.log(Level.SEVERE, "Cartago Env Init Error", ex);
        }
    }

    /** Called before the end of MAS execution */
    @Override
    public void stop() {
        super.stop();
    }
}
