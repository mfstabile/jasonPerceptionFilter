package jmoise;

import jason.JasonException;
import jason.architecture.AgArch;
import jason.asSemantics.Message;
import jason.asSyntax.ListTerm;
import jason.asSyntax.Pred;
import jason.asSyntax.StringTerm;
import jason.asSyntax.Structure;
import jason.asSyntax.Term;
import jason.infra.centralised.CentralisedAgArch;
import jason.mas2j.ClassParameters;
import jason.runtime.Settings;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

import moise.common.MoiseException;
import moise.oe.GoalInstance;
import moise.oe.GroupInstance;
import moise.oe.MissionPlayer;
import moise.oe.OE;
import moise.oe.OEAgent;
import moise.oe.Player;
import moise.oe.SchemeInstance;
import moise.tools.SimOE;

/**
  * Organisational Manager, special agent that maintains the
  * organisation entity (OE) state.
  */
public class OrgManager extends AgArch {

    private static Logger logger = Logger.getLogger(OrgManager.class.getName());

    private OE     currentOE = null;                                        
    private SimOE  simOE     = null;                                      
    private Map<String, OrgManagerCommand> commands = new HashMap<String, OrgManagerCommand>();
    
    
    @Override
    public void initAg(String agClass, ClassParameters bbPars, String asSrc, Settings stts) throws JasonException {
        super.initAg(agClass, bbPars, asSrc, stts);
        String osFile = getTS().getSettings().getUserParameter("osfile");
        if (osFile.startsWith("\"")) {
            osFile = osFile.substring(1, osFile.length() - 1);
        }
        logger.fine("OS file is " + osFile);
        if (osFile == null) {
            logger.log(Level.SEVERE, "No osfile was informed for this OrgManager!");
            return;
        }
        try {
            currentOE = OE.createOE("noprop", osFile);
            logger.fine("Creation of OE from " + osFile + " is Ok.");
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Error creating current OE.", e);
        }
        
        initCommandsMap();
        
        // starts GUI        
        if ("yes".equals(getTS().getSettings().getUserParameter("gui"))) {
            new Thread() {
                public void run() {
                    try {
                        simOE = new SimOE(currentOE, false);
                        simOE.setName("OrgManager");
                        simOE.frame.addWindowListener(new java.awt.event.WindowAdapter() {
                            public void windowClosing(java.awt.event.WindowEvent e) {
                                if (simOE != null) {
                                    simOE.disposeWindow();
                                }
                                simOE = null;
                            }
                        });
                        simOE.frame.centerScreen();
                    } catch (Exception e) {
                        logger.log(Level.SEVERE, "Error creating OrgManager GUI!", e);
                    }
                }
            }.start();
        }
        
    }
    
    protected void initCommandsMap() {
        addCommand(new GetOE());
        
        addCommand(new AdoptRole());
        addCommand(new RemoveRole());
        
        addCommand(new CreateGroup());
        addCommand(new RemoveGroup());

        addCommand(new CommitMission());
        addCommand(new RemoveMission());

        addCommand(new CreateScheme());
        addCommand(new AddResponsibleGroup());
        addCommand(new SetGoalState());
        addCommand(new SetGoalArg());
        addCommand(new RemoveScheme());
        addCommand(new AbortScheme());
        
        addCommand(new AddAgent());
    }
    
    public void addCommand(OrgManagerCommand c) {
        commands.put(c.getId(), c);        
    }

    public void stopAg() {
        if (simOE != null) {
            simOE.disposeWindow();
        }
        super.stopAg();
    }

    private void updateGUI() {
        if (simOE != null) {
            simOE.updateScreen();
        }
    }

    public void checkMail() {
        super.checkMail(); // get the messages
        
        // check the MailBox (at TS) for org messages
        Iterator<Message> i = getTS().getC().getMailBox().iterator();
        while (i.hasNext()) {
            Message m = i.next();
            i.remove(); // the agent do not receive this message
            if (currentOE == null) break;
            if (m.getSender() == null) break;
            
            OEAgent agSender = currentOE.getAgent(m.getSender());
            if (logger.isLoggable(Level.FINE)) logger.fine("Processing '" + m + "' for " + agSender);
            try {
                if (agSender == null) {
                    agSender = currentOE.addAgent(m.getSender());
                    updateMembersOE(currentOE.getAgent(m.getSender()));
                }
                
                // get content
                Pred content = null;
                if (m.getPropCont() instanceof Pred) {
                    content = (Pred)m.getPropCont();
                } else {
                    content = Pred.parsePred(m.getPropCont().toString());
                }
                
                // check whether there is a command
                OrgManagerCommand cmd = commands.get(content.getFunctor());
                if (cmd != null) {
                    cmd.process(currentOE, content, agSender, m.getMsgId());
                    updateGUI();
                } else {
                    logger.info("Received an unknown message: " + m + "!");
                }
            } catch (MoiseException e) {
                logger.log(Level.SEVERE, "Error processing '" + m + "' for " + agSender + ". "+e);
                sendReply(agSender, m.getMsgId(), "error(\"" + e + "\")");
            } catch (Exception e) {
                logger.log(Level.SEVERE, "Error processing '" + m + "' for " + agSender, e);
                sendReply(agSender, m.getMsgId(), "error(\"" + e + "\")");
            }
        }
    }
    
    class GetOE implements OrgManagerCommand {
        public String getId() {
            return "getOE";
        }
        public void process(OE currentOE, Pred command, OEAgent sender, String mId) throws MoiseException {
            sendReply(sender, mId, currentOE.partialOE(sender));
        }        
    }

    class AdoptRole implements OrgManagerCommand {
        public String getId() { 
            return "adopt_role"; 
        }
        
        public void process(OE currentOE, Pred m, OEAgent sender, String mId) throws MoiseException {
            String roleId = m.getTerm(0).toString();
            String grId   = m.getTerm(1).toString();

            sender.adoptRole(roleId, grId);
            GroupInstance gr = currentOE.findGroup(grId);

            // send new OE to the members of the group
            updateMembersOE(gr.getAgents(true), gr.getOwner());

            sendReply(sender, mId, "ok");
        }        
    }
    
    class RemoveRole implements OrgManagerCommand {
        public String getId() {
            return "remove_role";
        }
        public void process(OE currentOE, Pred command, OEAgent sender, String mId) throws MoiseException {
            String roleId = command.getTerm(0).toString();
            String grId   = command.getTerm(1).toString();
            
            sender.removeRole(roleId, grId);
            GroupInstance gr = currentOE.findGroup(grId);

            // notify other players
            // and the sender (that is not in the group anymore)
            updateMembersOE(gr.getAgents(true), sender, gr.getOwner());
            
            sendReply(sender, mId, "ok");
        }
    }
    
    class CommitMission implements OrgManagerCommand {
        public String getId() {
            return "commit_mission";
        }
        public void process(OE currentOE, Pred command, OEAgent sender, String mId) throws MoiseException {
            String misId = command.getTerm(0).toString();
            String schId = command.getTerm(1).toString();
            sender.commitToMission(misId, schId);

            SchemeInstance sch = currentOE.findScheme(schId);

            // notify to the scheme players the new player
            updateMembersOE(sch.getPlayers(), sch.getOwner());
            sendReply(sender, mId, "ok");
        }
    }
    
    class RemoveMission implements OrgManagerCommand {
        public String getId() {
            return "remove_mission";
        }
        public void process(OE currentOE, Pred command, OEAgent sender, String mId) throws MoiseException {
            String misId = null;
            String schId = null;
            boolean all = command.getArity() == 1;
            if (all) {
                schId = command.getTerm(0).toString();
            } else {
                misId = command.getTerm(0).toString();
                schId = command.getTerm(1).toString();
            }
            SchemeInstance sch;
            if (all) {
                sch = currentOE.findScheme(schId);
                Iterator<MissionPlayer> mpi = sender.getMissions().iterator();
                while (mpi.hasNext()) {
                    MissionPlayer mp = mpi.next();
                    sender.removeMission(mp.getMission().getId(), schId);
                    mpi = sender.getMissions().iterator();
                }
            } else {
                MissionPlayer omp = sender.removeMission(misId, schId);
                sch = omp.getScheme();
            }

            updateMembersOE(sch.getPlayers(),sender,sch.getOwner()); // the owner may be removed its mission already

            sendReply(sender, mId, "ok");
        }
    }
    
    
    class CreateGroup implements OrgManagerCommand {
        public String getId() {
            return "create_group";
        }
        public void process(OE currentOE, Pred command, OEAgent sender, String mId) throws MoiseException {
            boolean isNewRoot;
            String grName = null;
            String specId = null;
            if (command.getTerm(0).toString().startsWith("gr_name")) {
                grName = ((Structure)command.getTerm(0)).getTerm(0).toString();
                specId = command.getTerm(1).toString();
                isNewRoot = command.getArity() == 2;
            } else {
                specId = command.getTerm(0).toString();
                isNewRoot = command.getArity() == 1;
            }
            
            GroupInstance newGr;
            if (isNewRoot) {
                if (grName == null)
                    newGr = currentOE.addGroup(specId);
                else
                    newGr = currentOE.addGroup(grName,specId);
            } else {
                String superGrId = command.getTerm(1).toString();
                GroupInstance superGr = currentOE.findGroup(superGrId);
                if (superGr == null) {
                    sendReply(sender, mId, "error(\"the super-group " + superGrId + " does not exist\")");
                    return;
                }
                if (grName == null)
                    newGr = superGr.addSubGroup(specId);
                else
                    newGr = superGr.addSubGroup(grName,specId);
            }
            newGr.setOwner(sender);

            updateMembersOE(currentOE.getAgents());
            sendReply(sender, mId, newGr.getId());
        }
    }
    
    
    class RemoveGroup implements OrgManagerCommand {
        public String getId() {
            return "remove_group";
        }
        public void process(OE currentOE, Pred command, OEAgent sender, String mId) throws MoiseException {
            String grId      = command.getTerm(0).toString();
            GroupInstance gr = currentOE.findGroup(grId);
            if (gr == null) {
                sendReply(sender, mId, "error(\"the group " + grId + " does not exist\")");
                return;
            }
            if (!sender.equals(gr.getOwner())) {
                sendReply(sender, mId, "error(\"you are not the owner of the group " + grId + ", so you can not remove it\")");
            }

            //gr.checkRemove();

            currentOE.removeGroup(grId);

            // sent a new copy of OE
            updateMembersOE(currentOE.getAgents());
            sendReply(sender, mId, "ok");
        }
    }

    class AddAgent implements OrgManagerCommand {
        public String getId() {
            return "add_agent";
        }
        public void process(OE currentOE, Pred command, OEAgent sender, String mId) throws MoiseException {
            // send new OE to all
            updateMembersOE(currentOE.getAgents());
        }
    }

    class CreateScheme implements OrgManagerCommand {
        public String getId() {
            return "create_scheme";
        }
        public void process(OE currentOE, Pred command, OEAgent sender, String mId) throws MoiseException {
            String schId = null;
            String schSpecId;
            ListTerm groups = null;
            if (command.getTerm(0).toString().startsWith("sch_name")) {
                schId = ((Structure)command.getTerm(0)).getTerm(0).toString();
                schSpecId = command.getTerm(1).toString();
                if (command.getArity() == 3)
                    groups = (ListTerm)command.getTerm(2);
            } else {
                schSpecId = command.getTerm(0).toString();
                if (command.getArity() == 2)
                    groups = (ListTerm)command.getTerm(1);
            }

            SchemeInstance sch;
            if (schId == null)
                sch = currentOE.startScheme(schSpecId);
            else
                sch = currentOE.startScheme(schId, schSpecId);
            
            sch.setOwner(sender);
            
            if (groups != null) {
                // set the initial groups
                for (Term gr: groups) {
                    GroupInstance gi = currentOE.findGroup(gr.toString());
                    if (gi == null) {
                        sendReply(sender, mId, "error(\"the group " + gr + " does not exist\")");
                        return;
                    }
                    sch.addResponsibleGroup(gi);
                }
            }
            
            updateMembersOE(currentOE.getAgents());
            sendReply(sender, mId, sch.getId());
        }
    }

    class AddResponsibleGroup implements OrgManagerCommand {
        public String getId() {
            return "add_responsible_group";
        }
        public void process(OE currentOE, Pred command, OEAgent sender, String mId) throws MoiseException {
            String schId = command.getTerm(0).toString();
            String grId  = command.getTerm(1).toString();
            SchemeInstance sch = currentOE.findScheme(schId);
            if (sch == null) {
                sendReply(sender, mId, "error(\"the scheme " + schId + " does not exist\")");
                return;
            }

            GroupInstance gr = currentOE.findGroup(grId);
            if (gr == null) {
                sendReply(sender, mId, "error(\"the group " + grId + " does not exist\")");
                return;
            }
            if (!sender.equals(gr.getOwner())) {
                sendReply(sender, mId, "error(\"you are not the owner of the group " + schId + ", so you can not add it as responsible for a scheme.\")");
            }

            sch.addResponsibleGroup(gr);

            updateMembersOE(gr.getPlayers());
            sendReply(sender, mId, "ok");
        }
    }
    
    class RemoveScheme implements OrgManagerCommand {
        public String getId() {
            return "remove_scheme";
        }
        public void process(OE currentOE, Pred command, OEAgent sender, String mId) throws MoiseException {
            String schId       = command.getTerm(0).toString();
            SchemeInstance sch = currentOE.findScheme(schId);
            if (sch == null) {
                sendReply(sender, mId, "error(\"the scheme " + schId + " does not exist\")");
                return;
            }
            
            if (sch.getSpec().getFS().getBoolProperty("only-owner-can-remove-scheme", true) && !sender.equals(sch.getOwner())) {
                sendReply(sender, mId, "error(\"you are not the owner of the scheme " + schId + ", so you can not change it\")");
                return;
            }

            act(currentOE, sch);
            // send untell to agents
            updateMembersOE(currentOE.getAgents());
            sendReply(sender, mId, "ok");
        }
        protected void act(OE currentOE, SchemeInstance sch) throws MoiseException {
            currentOE.finishScheme(sch);        	
        }
    }
    
    class AbortScheme extends RemoveScheme {
        public String getId() {
            return "abort_scheme";
        }
        protected void act(OE currentOE, SchemeInstance sch) throws MoiseException {
            currentOE.abortScheme(sch);
        }
    }

    class SetGoalState implements OrgManagerCommand {
        public String getId() {
            return "set_goal_state";
        }
        public void process(OE currentOE, Pred command, OEAgent sender, String mId) throws MoiseException {
            String schId  = command.getTerm(0).toString();
            String goalId = command.getTerm(1).toString();
            String state  = command.getTerm(2).toString();

            SchemeInstance sch = currentOE.findScheme(schId);
            if (sch == null) {
                sendReply(sender, mId, "error(\"the scheme " + schId + " does not exist\")");
                return;
            }

            GoalInstance gi = sch.getGoal(goalId);
            if (gi == null) {
                sendReply(sender, mId, "error(\"the goal " + goalId + " does not exist in scheme " + schId + "\")");
                return;
            }

            if (!gi.getCommittedAgents().contains(sender)) {
                sendReply(sender, mId, "error(\"You are not committed to the goal " + goalId + ", so you can not change its state.\")");
                return;
            }

            if (state.equals("satisfied")) {
                gi.setAchieved(sender);
            } else if (state.equals("impossible")) {
                gi.setImpossible(sender);
            }

            updateMembersOE(sch.getPlayers());
            sendReply(sender, mId, "ok");
        }
    }

    class SetGoalArg implements OrgManagerCommand {
        public String getId() {
            return "set_goal_arg";
        }
        public void process(OE currentOE, Pred command, OEAgent sender, String mId) throws MoiseException {
            String schId  = command.getTerm(0).toString();
            String goalId = command.getTerm(1).toString();
            String arg    = command.getTerm(2).toString();
            if (arg.startsWith("\"")) {
                arg = arg.substring(1, arg.length() - 1);
            }
            String value  = command.getTerm(3).toString();
            if (command.getTerm(3).isString()) {
                value = ((StringTerm)command.getTerm(3)).getString();
            }

            SchemeInstance sch = currentOE.findScheme(schId);
            if (sch == null) {
                sendReply(sender, mId, "error(\"the scheme " + schId + " does not exist\")");
                return;
            }

            GoalInstance gi = sch.getGoal(goalId);
            if (gi == null) {
                sendReply(sender, mId, "error(\"the goal " + goalId + " does not exist in scheme " + schId + "\")");
                return;
            }

            /*
            if (!gi.getCommittedAgents().contains(sender)) {
                sendReply(sender, mId, "error(\"You are not committed to the goal " + goalId + ", so you can not change its arguments.\")");
                return;
            }
            */
            
            gi.setArgumentValue(arg, value);

            updateMembersOE(sch.getPlayers()); 
            sendReply(sender, mId, "ok");
        }
    }

    void sendReply(OEAgent to, String mId, String content) {
        try {
            Message r = new Message("tell", null, to.getId(), content);
            r.setInReplyTo(mId);
            super.sendMsg(r);
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Error sending reply '" + content + "' to " + to, e);
        }
    }

    void sendReply(OEAgent to, String mId, Object content) {
        try {
            Message r = new Message("tell", null, to.getId(), null);
            r.setInReplyTo(mId);
            r.setPropCont(content);
            super.sendMsg(r);
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Error sending reply '" + content + "' to " + to, e);
        }
    }

    /* send OE to a set of agents */
    @SuppressWarnings("unchecked")
    private void updateMembersOE(Collection ags, OEAgent... others) {
        Set<OEAgent> all = new HashSet<OEAgent>(); // to remove duplicates
        Iterator iAgs = ags.iterator();
        while (iAgs.hasNext()) {
            Object next = iAgs.next();

            if (next instanceof OEAgent) // check if it is a list of OEAgents
                all.add((OEAgent) next);
            else if (next instanceof Player) // check if it is a list of Players
                all.add(((Player) next).getPlayer());

        }
        if (others != null)
            for (OEAgent ag: others) 
                all.add(ag);
        for (OEAgent ag : all) 
            updateMembersOE(ag);
    }

    /** send OE to one agent */
    private void updateMembersOE(OEAgent ag) {
        if (!ag.getId().equals("orgManager")) {
            try {
                Message moe = new Message("tell", null, ag.getId(), null);
                // need to clone only on centralised execution, otherwise the serialization will clone
                if (getArchInfraTier() instanceof CentralisedAgArch)
                    moe.setPropCont(currentOE.clone()); //partialOE(ag)); // TODO: the clone of OE is not working, using serialisation/de-serialisation!
                else 
                    moe.setPropCont(currentOE);
                sendMsg(moe);
            } catch (Exception e) {
                logger.log(Level.SEVERE, "Error sending update to " + ag, e);
            }
        }
    }
}
