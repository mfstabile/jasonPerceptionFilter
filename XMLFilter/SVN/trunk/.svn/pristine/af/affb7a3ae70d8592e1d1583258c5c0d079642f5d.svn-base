package jmoise;

import static jason.asSyntax.ASSyntax.createLiteral;
import static jason.asSyntax.ASSyntax.createNumber;
import static jason.asSyntax.ASSyntax.createString;
import static jason.asSyntax.ASSyntax.createStructure;
import jason.JasonException;
import jason.RevisionFailedException;
import jason.architecture.AgArch;
import jason.asSemantics.Agent;
import jason.asSemantics.Circumstance;
import jason.asSemantics.Event;
import jason.asSemantics.IntendedMeans;
import jason.asSemantics.Intention;
import jason.asSemantics.Message;
import jason.asSemantics.Unifier;
import jason.asSyntax.ASSyntax;
import jason.asSyntax.Atom;
import jason.asSyntax.ListTerm;
import jason.asSyntax.ListTermImpl;
import jason.asSyntax.Literal;
import jason.asSyntax.LiteralImpl;
import jason.asSyntax.Pred;
import jason.asSyntax.PredicateIndicator;
import jason.asSyntax.Structure;
import jason.asSyntax.Term;
import jason.asSyntax.Trigger;
import jason.asSyntax.UnnamedVar;
import jason.asSyntax.VarTerm;
import jason.asSyntax.Trigger.TEOperator;
import jason.asSyntax.Trigger.TEType;
import jason.asSyntax.parser.ParseException;
import jason.mas2j.ClassParameters;
import jason.runtime.Settings;

import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

import moise.common.MoiseException;
import moise.oe.GoalInstance;
import moise.oe.GroupInstance;
import moise.oe.MissionPlayer;
import moise.oe.OE;
import moise.oe.OEAgent;
import moise.oe.Permission;
import moise.oe.RolePlayer;
import moise.oe.SchemeInstance;
import moise.os.fs.Goal;
import moise.os.fs.Goal.GoalType;

/**
  * Organisational Architecture, binds Jason agent to
  * the Moise+ infrastructure
  */
public class OrgAgent extends AgArch {

    private static final Term managerSource          = Pred.createSource(new Atom("orgManager"));
    private static final Atom rootAtom               = new Atom("root");

    private Logger            logger                 = Logger.getLogger(OrgAgent.class.getName());
    private OE                currentOE              = null;
    private Set<GoalInstance> alreadyGeneratedEvents = new HashSet<GoalInstance>();
    private String            orgManagerName         = "orgManager";
    
    private boolean           checkCommLink          = true;
    
    @Override
    public void initAg(String agClass, ClassParameters bbPars, String asSrc, Settings stts) throws JasonException {
        super.initAg(agClass, bbPars, asSrc, stts);
        logger = getTS().getLogger(); //Logger.getLogger(OrgAgent.class.getName() + "." + getAgName());
        introduceMySelf();
    }

    public String getOrgManagerName() {
        return orgManagerName;
    }
    
    public void setOrgManagerName(String name) {
        orgManagerName = name;
        introduceMySelf();
    }
    
    public OE getOE() {
        return currentOE;
    }
    
    private void introduceMySelf() {
        try {
            Message m = new Message("tell", null, getOrgManagerName(), "add_agent");
            super.sendMsg(m);
        } catch (Exception e) {
            logger.fine("Error sending add_agent to OrgManager!");
        }        
    }

    public void setCheckCommunicationLink(boolean check) {
        checkCommLink = check;
    }
    
    @Override
    public void sendMsg(Message m) throws Exception {
        // check communication link
        if (checkCommLink) {
            String to = m.getReceiver();
            if (currentOE == null || to.equals(orgManagerName) || to.equals(getAgName()) ||
                getMyOEAgent().hasLink("communication", getOE().getAgent(to))) {
                super.sendMsg(m);
            } else {
                throw new MoiseException(getAgName()+" is not allowed to communicate with "+to+", sender roles are "+getMyOEAgent().getRoles());
            }
        } else {
            super.sendMsg(m);
        }
    }
    
    public void checkMail() {
        super.checkMail(); // get the messages from arch to circumstance
        
        Circumstance C = getTS().getC();
        Iterator<Message> i = C.getMailBox().iterator();
        
        boolean shouldUpdate = false;
        try {
            while (i.hasNext()) {
                Message m = i.next();

                // check if content comes from orgManager
                if (m.getSender().equals(getOrgManagerName())) {
                    i.remove();
                    if (m.getPropCont() instanceof OE) {
                        currentOE = (OE)m.getPropCont();
                        currentOE.rebuildHash();
                        shouldUpdate = true;
                    } else {                    
                        // the content is a normal predicate
                        final String content = m.getPropCont().toString();
                        
                        // test if it is the result of some org action    
                        if (m.getInReplyTo() != null) {
                            // find the intention
                            Intention pi = C.removePendingIntention("om/"+m.getInReplyTo());
                            if (pi != null) {
                                resumeIntention(pi, content, C);
                            }
                        }
                    }
                }
            } // while
            
            if (shouldUpdate) {
                updateBB(3);
            }
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Error!", e);
        }

    }

    
    /** update the bel base according to the current OE  */
    void updateBB(int n) throws RevisionFailedException, ParseException {
        if (n == 0) {
            getTS().getLogger().log(Level.SEVERE, "**** too much concurrent modification", new Exception());
            return;
        }
        try {
            updateGroup();
            updateRolePlayer();
            updateScheme();
            updateSchemeGroup();
            updatePermissionsObligations();
            updateCommitments();
            updateGoalBels(); // add all goals of the scheme in BB
            generateOrgGoalEvents(); // I need to generate AS Triggers like !<orggoal> since some scheme becomes well formed
        } catch (ConcurrentModificationException e) { 
            updateBB(n-1); // try again
        }
    }

    private void updateGroup() throws RevisionFailedException {
        // update "play"
        List<Literal> toAdd = new ArrayList<Literal>();

        // create list of groups
        for (GroupInstance gi: currentOE.getAllSubGroupsTree()) {
            Term typeAnnot;
            if (gi.getSuperGroup() != null)
                typeAnnot = createStructure("super_gr", new Atom(gi.getSuperGroup().getId()));
            else
                typeAnnot = new Atom("root");
            Literal l = createLiteral("group", new Atom(gi.getGrSpec().getId()), new Atom(gi.getId()));
            l.addAnnots(createStructure("owner", new Atom(gi.getOwner().getId())), typeAnnot, managerSource);        
            toAdd.add(l);
        }
        orgBUF(toAdd, groupLiteral);
    }

    private void updateRolePlayer() throws RevisionFailedException {
        // create list of players
        List<Literal> toAdd = new ArrayList<Literal>();
        for (RolePlayer myrole: getMyOEAgent().getRoles()) { // for all my groups
            for (RolePlayer rp: myrole.getGroup().getPlayers()) { // for player of the group I play some role
                Literal l = createLiteral("play", new Atom(rp.getPlayer().getId()), new Atom(rp.getRole().getId()), new Atom(rp.getGroup().getId()));
                l.addAnnot(managerSource);
                toAdd.add(l);
            }
        }        
        orgBUF(toAdd, playLiteral);
    }

    private void updateScheme() throws RevisionFailedException, ParseException {
        // create list of scheme
        List<Literal> toAdd = new ArrayList<Literal>();
        for (SchemeInstance sch: currentOE.getSchemes()) {
            Literal l = createLiteral("scheme", new Atom(sch.getSpec().getId()), new Atom(sch.getId()));
            l.addAnnots(createStructure("owner", new Atom(sch.getOwner().getId())), managerSource);        
            toAdd.add(l);

            if (sch.getOwner().equals(getMyOEAgent())) {
                // update the number of players
                getTS().getAg().delBel(createLiteral( "sch_players", new Atom(sch.getId()), new UnnamedVar()));
                getTS().getAg().addBel(createLiteral( "sch_players", new Atom(sch.getId()), createNumber(sch.getPlayersQty())));
            }
        }
        List<Literal> deleted = orgBUF(toAdd, schemeLiteral);
        
        for (Literal l: deleted) {
            cleanGoalsOfSch(l.getTerm(1).toString());
            removeBeliefs((Atom)l.getTerm(1));
        }
    }
    
    private void updateSchemeGroup() throws RevisionFailedException {
        // create list of scheme_group
        List<Literal> toAdd = new ArrayList<Literal>();
        for (RolePlayer myrole: getMyOEAgent().getRoles()) { // for all my groups
            for (SchemeInstance sch : myrole.getGroup().getRespSchemes()) { // for all scheme they are responsible for
                Literal l = createLiteral("scheme_group", new Atom(sch.getId()), new Atom(myrole.getGroup().getId()));
                l.addAnnot(managerSource);
                toAdd.add(l);
            }
        }
        orgBUF(toAdd, schemeGroupLiteral);
    }

    private void updatePermissionsObligations() throws RevisionFailedException {
        // create list of obligations/permissions
        Set<Permission> obligations = new HashSet<Permission>();
        List<Literal> toAdd = new ArrayList<Literal>();
        toAdd = createObligation(obligations);
        orgBUF(toAdd, obligationLiteral);
        toAdd.clear();
        toAdd = createPermission(obligations);
        orgBUF(toAdd, permissionLiteral);
    }

    private void updateCommitments() throws RevisionFailedException {
        List<Literal> toAdd = new ArrayList<Literal>();
        for (MissionPlayer mymission: getMyOEAgent().getMissions()) { 
            for (MissionPlayer mp: mymission.getScheme().getPlayers()) { 
                Literal l = createLiteral("commitment", new Atom(mp.getPlayer().getId()), new Atom(mp.getMission().getId()), new Atom(mp.getScheme().getId()));
                l.addAnnot(managerSource);
                toAdd.add(l);
            }
        }        
        List<Literal> deleted = orgBUF(toAdd, commitmentLiteral);
        
        for (Literal l: deleted) {
            String schId = l.getTerm(2).toString();
            SchemeInstance sch = currentOE.findScheme(schId);
            if (sch != null && !sch.isPlayer(getMyOEAgent())) {
                cleanGoalsOfSch(schId);
                removeBeliefs((Atom)l.getTerm(2));
            }
        }
    }
    
    private List<Literal> orgBUF(List<Literal> toAdd, PredicateIndicator bel) throws RevisionFailedException {
        List<Literal> toDel = new ArrayList<Literal>();
        Agent ag = getTS().getAg();
        
        // remove old bels
        Iterator<Literal> i = ag.getBB().getCandidateBeliefs(bel);
        if (i != null) {
            while (i.hasNext()) {
                Literal l = i.next();
                
                boolean isInOE = false;
                Iterator<Literal> ip = toAdd.iterator();
                while (ip.hasNext()) {
                    Literal p = ip.next();
                    if (p.equalsAsStructure(l)) {
                        isInOE = true;
                        ip.remove();
                        break;
                    }
                }
                if (!isInOE) {
                    toDel.add(l);
                }
            }
        }
        for (Literal l: toDel) 
            ag.delBel(l);      
        
        for (Literal l: toAdd)
            ag.addBel(l);
        return toDel;
    }
       
    private void resumeIntention(Intention pi, String content, Circumstance C) {
        pi.setSuspended(false);
        
        if (content.startsWith("error")) { // fail the IA
            IntendedMeans im = pi.peek();            
            Event failEvent = getTS().findEventForFailure(pi, im.getTrigger());
            if (failEvent != null) {
                Structure body = (Structure)im.getCurrentStep().getBodyTerm(); // get the internal action 

                ListTerm failAnnots = new ListTermImpl(); // create a list of error annotations
                String msg = content.substring(7,content.length()-2);
                failAnnots.add(createStructure("error", new Atom("org_error")));
                failAnnots.add(createStructure("error_msg", createString(msg)));
                failAnnots.add(createStructure("code", createString(body.toString())));
                if (body.getSrcInfo() != null) {
                    failAnnots.add(createStructure("code_src", createString(body.getSrcInfo().getSrcFile())));
                    failAnnots.add(createStructure("code_line", createNumber(body.getSrcInfo().getBeginSrcLine())));
                }
                failEvent.getTrigger().getLiteral().addAnnots(failAnnots);
                C.addEvent(failEvent);
                if (logger.isLoggable(Level.FINE)) logger.fine("Generating goal deletion " + failEvent.getTrigger() + " from goal: " + im.getTrigger());
            } else {
                logger.warning("No fail event was generated for " + im.getTrigger());
            }
        } else {
            Structure body = (Structure)pi.peek().removeCurrentStep(); // remove the internal action
            C.resumeIntention(pi); // add the intention back in I
            
            // try to unify the return value
            //System.out.println("answer is "+content+" or "+DefaultTerm.parse(content)+" with body "+body);
            // if the last arg of body is a free var
            Term lastTerm = body.getTerm(body.getArity()-1); 
            if (lastTerm != null && !lastTerm.isGround()) {
                try {
                    pi.peek().getUnif().unifies(lastTerm, ASSyntax.parseTerm(content));
                } catch (ParseException e) {
                    // no problem, the content is not a term
                }
                //System.out.println("un = "+pi.peek().getUnif());
            }
        }
        
    }
    
    private List<Literal> createObligation(Set<Permission> obligations) {
        List<Literal> r = new ArrayList<Literal>();
        
        if (logger.isLoggable(Level.FINE)) logger.fine("Computing obl with " + getMyOEAgent().getObligations());

        // obligations
        for (Permission p : getMyOEAgent().getObligations()) {
            obligations.add(p);
            Literal l = createLiteral("obligation", 
                            new Atom(p.getScheme().getId()),
                            new Atom(p.getMission().getId()));
            l.addAnnots(createStructure("role", new Atom(p.getRolePlayer().getRole().getId())),
                        createStructure("group", new Atom(p.getRolePlayer().getGroup().getId())),
                        managerSource);
            r.add(l);
            if (logger.isLoggable(Level.FINE)) logger.fine("New obligation: " + l);
        }
        return r;
    }
    
    private List<Literal> createPermission(Set<Permission> obligations)  {
        List<Literal> r = new ArrayList<Literal>();
        
        if (logger.isLoggable(Level.FINE)) logger.fine("Computing per with "+ getMyOEAgent().getPermissions());

        // permissions
        for (Permission p : getMyOEAgent().getPermissions()) {
            if (!obligations.contains(p)) {
                Literal l = createLiteral("permission", 
                                new Atom(p.getScheme().getId()),
                                new Atom(p.getMission().getId()));
                l.addAnnots(createStructure("role", new Atom(p.getRolePlayer().getRole().getId())),
                            createStructure("group", new Atom(p.getRolePlayer().getGroup().getId())),
                            managerSource);
                r.add(l);
                if (logger.isLoggable(Level.FINE)) logger.fine("New permission: " + l);
            }
        }
        return r;
    }

    private void generateOrgGoalEvents() {
       OEAgent me = getMyOEAgent();
       for (GoalInstance gi : getMyOEAgent().getPossibleGoals()) {
           if (!alreadyGeneratedEvents.contains(gi)) {
                alreadyGeneratedEvents.add(gi);

                Literal l = Literal.parseLiteral(gi.getAsProlog());
                // add annot with scheme id
                Structure giID = new Structure("scheme", 1);
                giID.addTerm(new Atom(gi.getScheme().getId()));
                l.addAnnot(giID);
                
                // add annot with mission id
                for (MissionPlayer mp: getMyOEAgent().getMissions()) {
                    if (mp.getMission().getGoals().contains(gi.getSpec())) {
                        l.addAnnot(createStructure("mission", new Atom(mp.getMission().getId())));
                    }
                }
                
                // add annot with type of goal
                Structure type = new Structure("type", 1);
                type.addTerm(getGoalTypeAtom(gi.getSpec()));
                l.addAnnot(type);
                
                // add source annot
                l.addAnnot(managerSource);
                
                // try to find the role/group of this goal
                // (the first all resp group of the scheme where I am)
                for (GroupInstance g: gi.getScheme().getResponsibleGroups()) {
                    for (RolePlayer rp: g.getPlayers()) {
                        if (rp.getPlayer().equals(me)) {
                            l.addAnnot(createStructure("role", new Atom(rp.getRole().getId())));
                            l.addAnnot(createStructure("group",new Atom(rp.getGroup().getId())));
                        }
                    }
                }
                getTS().updateEvents(new Event(new Trigger(TEOperator.add, TEType.achieve, l), Intention.EmptyInt));
                if (logger.isLoggable(Level.FINE)) logger.fine("New goal: " + l);
           }
       }
    }
   
    private static final Atom aAchievementGoal = new Atom(GoalType.achievement.toString()); 
    private static final Atom aMaintenanceGoal = new Atom(GoalType.maintenance.toString());
    
    public static Atom getGoalTypeAtom(Goal g) {
        switch (g.getType()) {
        case achievement: return aAchievementGoal;
        case maintenance: return aMaintenanceGoal;
        }
        return null;
    }

    void cleanGoalsOfSch(String schId) {
        Iterator<GoalInstance> i = alreadyGeneratedEvents.iterator();
        while (i.hasNext()) {
            GoalInstance gi = i.next();
            if (gi.getScheme().getId().equals(schId)) {
                i.remove();
            }
        }
    }

    private static final PredicateIndicator groupLiteral       = new PredicateIndicator("group", 2);
    private static final PredicateIndicator playLiteral        = new PredicateIndicator("play", 3);
    private static final PredicateIndicator schemeLiteral      = new PredicateIndicator("scheme", 2);
    private static final PredicateIndicator obligationLiteral  = new PredicateIndicator("obligation", 2);
    private static final PredicateIndicator permissionLiteral  = new PredicateIndicator("permission", 2);
    private static final PredicateIndicator schemeGroupLiteral = new PredicateIndicator("scheme_group", 2);
    private static final PredicateIndicator goalStateLiteral   = new PredicateIndicator("goal_state", 3);
    private static final PredicateIndicator schPlayersLiteral  = new PredicateIndicator("sch_players", 2);
    private static final PredicateIndicator commitmentLiteral  = new PredicateIndicator("commitment", 3);

    /** removes all bels related to a Scheme */
    private void removeBeliefs(Atom schId) throws RevisionFailedException {
        Agent ag = getTS().getAg();
        //ag.abolish(buildLiteralToCleanBB(aSchId, obligationLiteral, false), null);
        //ag.abolish(buildLiteralToCleanBB(aSchId, permissionLiteral, false), null);
        //ag.abolish(buildLiteralToCleanBB(aSchId, schemeGroupLiteral, false), null);
        ag.abolish(buildLiteralToCleanBB(schId, goalStateLiteral, false), null);
        ag.abolish(buildLiteralToCleanBB(schId, schPlayersLiteral, false), null);
        //ag.abolish(buildLiteralToCleanBB(aSchId, commitmentLiteral, true), null);
    }

    private Literal buildLiteralToCleanBB(Atom aSchId, PredicateIndicator pred, boolean schInEnd) {
        Literal l = new LiteralImpl(pred.getFunctor());
        if (!schInEnd) {
            l.addTerm(aSchId);
        }
        for (int i=1;i<pred.getArity();i++) {
            l.addTerm(new UnnamedVar());
        }
        if (schInEnd) {
            l.addTerm(aSchId);            
        }
        return l;
    }
    
    protected OEAgent getMyOEAgent() {
        return currentOE.getAgent(getAgName());
    }

    /** add/remove bel regarding the goals' state */
    void updateGoalBels() throws RevisionFailedException {
        // for all missions
        // for all goals of the mission's scheme
        // if not in BB, add
        // if different from BB, remove/add
        for (MissionPlayer mp : getMyOEAgent().getMissions()) {
            for (GoalInstance gi : mp.getScheme().getGoals()) {
                updateGoalBels(gi);
            }
        }
    }

    void updateGoalBels(Pred arg) throws RevisionFailedException {
        String schId  = arg.getTerm(0).toString();
        String goalId = arg.getTerm(1).toString();
        for (SchemeInstance sch : getMyOEAgent().getAllMySchemes()) {
            if (sch.getId().equals(schId)) {
                GoalInstance gi = sch.getGoal(goalId);
                if (gi != null) {
                    updateGoalBels(gi);
                }
            }
        }
    }

    // goal states
    private static final Atom aWaiting    = new Atom("waiting");
    private static final Atom aReady      = new Atom("ready");
    private static final Atom aImpossible = new Atom("impossible");
    private static final Atom aAchieved   = new Atom("achieved");

    void updateGoalBels(GoalInstance gi) throws RevisionFailedException {
        Pred gap = Pred.parsePred(gi.getAsProlog());
        
        if (gi.getScheme().getRoot() == gi) {
            gap.addAnnot(rootAtom);
        }

        Atom gState = aWaiting;
        if (gi.isReady()) {
            gState = aReady;
        } else if (gi.isSatisfied()) {
            gState = aAchieved;
        } else if (gi.isImpossible()) {
            gState = aImpossible;
        }
        
        // create the literal to be added
        VarTerm S = new VarTerm("S");
        Literal gil = createLiteral("goal_state", new Atom(gi.getScheme().getId()), gap, S);
        gil.addAnnot(managerSource);


        Unifier u = new Unifier();
        Literal gapforfind = gap.copy();
        gapforfind.makeTermsAnnon();
        Literal gilforfind = createLiteral("goal_state", new Atom(gi.getScheme().getId()), gapforfind, S);;
        Literal gilInBB = getTS().getAg().findBel(gilforfind, u);
        if (gilInBB != null) {
            // the agent believes in the goal, remove if different
            // so that an event is produced
            if (!u.get(S).equals(gState) || !gap.equals(gilInBB.getTerm(1))) { 
                if (!getTS().getAg().delBel(gilInBB))
                    logger.warning("Belief "+gilInBB+" should be deleted, but was not!");
                else 
                    if (logger.isLoggable(Level.FINE)) logger.fine("Remove goal belief: " + gil);
            }
        }

        gil = gil.copy();
        gil.setTerm(2, gState);
        
        if (getTS().getAg().addBel(gil))
            if (logger.isLoggable(Level.FINE)) logger.fine("New goal belief: " + gil);
    }
}
