package ora4mas;

import static jason.asSyntax.ASSyntax.createLiteral;
import jason.JasonException;
import jason.RevisionFailedException;
import jason.asSemantics.ActionExec;
import jason.asSemantics.Agent;
import jason.asSyntax.ASSyntax;
import jason.asSyntax.Atom;
import jason.asSyntax.ListTerm;
import jason.asSyntax.Literal;
import jason.asSyntax.PredicateIndicator;
import jason.asSyntax.StringTerm;
import jason.asSyntax.StringTermImpl;
import jason.asSyntax.Structure;
import jason.asSyntax.Term;
import jason.asSyntax.UnnamedVar;
import jason.asSyntax.parser.ParseException;
import jason.mas2j.ClassParameters;
import jason.runtime.Settings;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

import moise.prolog.ToProlog;
import npl.NormativeProgram;
import ora4mas.nopl.GroupBoard;
import ora4mas.nopl.OrgArt;
import ora4mas.nopl.SchemeBoard;
import ora4mas.nopl.oe.Player;
import c4jason.CAgentArch;
import c4jason.CartagoAction;
import c4jason.CartagoEnvironment;
import c4jason.actions.PendingAction;
import cartago.ArtifactConfig;
import cartago.ArtifactId;
import cartago.ArtifactObsProperty;
import cartago.CartagoEvent;
import cartago.CartagoException;
import cartago.ICartagoContext;
import cartago.Op;
import cartago.events.ArtifactObsEvent;
import cartago.events.FocusCompletedEvent;
import cartago.events.ObsPropAddedEvent;
import cartago.events.ObsPropUpdatedEvent;

/**
  * Organisational Architecture, binds Jason agent to
  * the Moise+ infrastructure based on ORA4MAS
  */
public class CartagoOrgAgent extends CAgentArch {

    private Logger            logger                 = Logger.getLogger(CartagoOrgAgent.class.getName());
    private String            currentOS              = null;
    
    protected Map<PredicateIndicator,Runnable> runOnPerceive = new HashMap<PredicateIndicator,Runnable>();
    
    public static final PredicateIndicator piResponsibleGroup = new PredicateIndicator("responsible_group", 2);
    public static final PredicateIndicator piObligation       = new PredicateIndicator(NormativeProgram.OblFunctor, 4);
    public static final PredicateIndicator piGrSpec           = new PredicateIndicator("group_specification", 4);
    public static final PredicateIndicator piSchSpec          = new PredicateIndicator("scheme_specification", 3);
    public static final PredicateIndicator piGrPlayer         = new PredicateIndicator("play", 3);
    public static final PredicateIndicator piSchPlayer        = new PredicateIndicator("commitment", 3);
    public static final PredicateIndicator piSglDestroy       = new PredicateIndicator(OrgArt.sglDestroyed, 0);
    public static final PredicateIndicator piWF               = new PredicateIndicator("well_formed", 1);
    

    @Override
    public void initAg(String agClass, ClassParameters bbPars, String asSrc, Settings stts) throws JasonException {
        super.initAg(agClass, bbPars, asSrc, stts);
        logger = getTS().getLogger();
                
        // add org actions
        CartagoEnvironment.getInstance().putCartagoAction("create_group", new CreateGroup());
        CartagoEnvironment.getInstance().putCartagoAction("remove_group", new RemoveOrgArt());
        CartagoEnvironment.getInstance().putCartagoAction("create_scheme", new CreateScheme());
        CartagoEnvironment.getInstance().putCartagoAction("remove_scheme", new RemoveOrgArt());
        CartagoEnvironment.getInstance().putCartagoAction("add_responsible_group", new AddResponsibleGroup());
        CartagoEnvironment.getInstance().putCartagoAction("adopt_role", new AdoptRole());
        CartagoEnvironment.getInstance().putCartagoAction("leave_role", new LeaveRole());
        CartagoEnvironment.getInstance().putCartagoAction("commit_mission", new CommitMission());
        CartagoEnvironment.getInstance().putCartagoAction("leave_mission", new LeaveMission());
        CartagoEnvironment.getInstance().putCartagoAction("goal_achieved", new GoalAchieved());
        CartagoEnvironment.getInstance().putCartagoAction("set_goal_arg", new SetGoalArgValue());

    }

    public String getCurrentOSFile() {
        return currentOS;
    }

    public void setCurrentOSFile(String currentOS) {
        this.currentOS = currentOS;
    }
    
    @Override
    public void notifyCartagoEvent(CartagoEvent cev) {
        ArtifactId aid  = null;
        String     label = null;
        Object     content = null;
        
        //ArtifactObsProperty prop = null;

        if (cev.isNewObsProp()) {
            ObsPropAddedEvent ev = (ObsPropAddedEvent)cev;
            aid     = ev.getArtifactId();
            label   = ev.getProperty().getName();
            content = ev.getProperty().getValue();
        } else if (cev.isObsPropUpdated()) {
            ObsPropUpdatedEvent ev = (ObsPropUpdatedEvent)cev;
            aid     = ev.getArtifactId();            
            label   = ev.getProperty().getName();
            content = ev.getProperty().getValue();
        } else if (cev.isObsEvent()) {
            ArtifactObsEvent ev = (ArtifactObsEvent)cev;
            aid     = ev.getSourceId();            
            label   = ev.getLabel();
            content = ev.getContent(0);
        //} else if (cev.isOpCompleted()) {
        //    OpCompletedEvent ev = (OpCompletedEvent) cev;
        //    System.out.println(" finished **** " + ev.getOp().getName());
        } else if (cev.isFocusSucceeded()) { // special case, many props
            FocusCompletedEvent ev = (FocusCompletedEvent)cev;
            aid = ev.getArtifactId();
            if (isOrgArt(aid.getArtifactType())) {
                for (ArtifactObsProperty p: ev.getProperties()) {
                    updateBB(aid, p.getName(), p.getValue());
                }
                getArchInfraTier().wake();
                return;
            }
        }
        
        if (aid != null && isOrgArt(aid.getArtifactType()) && updateBB(aid, label, content) ) 
            getArchInfraTier().wake();
        else
            super.notifyCartagoEvent(cev);
    }   
  
    @Override
    public List<Literal> perceive() {
        synchronized (runOnPerceive) {
            
            Runnable clean = runOnPerceive.remove(piSglDestroy); // cleanBB should be run as the last task
            
            for (PredicateIndicator pi: runOnPerceive.keySet())
                runOnPerceive.get(pi).run();
            
            if (clean != null)
                clean.run();
            
            runOnPerceive.clear();
        }

        return super.perceive();
    }
    
    @SuppressWarnings("unchecked")
    private boolean updateBB(final ArtifactId source, String label, final Object content) {
        //System.out.println(" ["+getAgName()+ "] * "+label+" = "+content);
        synchronized (runOnPerceive) {
            if (label.equals(GroupBoard.obsPropSchemes)) {
                
                // focus on all schemes of the group
                try {
                    ICartagoContext actx = getCurrentContext();
                    for (String s: (Collection<String>)content) {
                        ArtifactId aid = actx.lookupArtifact(s);
                        actx.focus(aid);
                    }
                } catch (CartagoException e) {
                    logger.log(Level.SEVERE,"Error on focusing "+content, e);
                }

                runOnPerceive.put(piResponsibleGroup, new Runnable() {  public void run() {
                    updateResponsibleGroup(source, content);
                }});
            } else if (label.equals(SchemeBoard.obsPropGoals)) {
                runOnPerceive.put(SchemeBoard.piGoalState, new Runnable() {  public void run() {
                    updateGoals(source, content);
                }});
            } else if (label.equals(GroupBoard.obsWellFormed)) {
                runOnPerceive.put(piWF, new Runnable() {  public void run() {
                    updateWF(source, content, piWF);
                }});
            } else if (label.equals(SchemeBoard.obsPropOblActv)) {
                runOnPerceive.put(piObligation, new Runnable() {  public void run() {
                    updateObligations(source, content);
                }});
            } else if (label.equals(SchemeBoard.obsPropPlayers) && source.getArtifactType().equals(SchemeBoard.class.getName())) {
                runOnPerceive.put(piSchPlayer, new Runnable() {  public void run() {
                    updatePlayers(source, content, piSchPlayer);
                }});
            } else if (label.equals(GroupBoard.obsPropPlayers) && source.getArtifactType().equals(GroupBoard.class.getName())) {
                runOnPerceive.put(piGrPlayer, new Runnable() {  public void run() {
                    updatePlayers(source, content, piGrPlayer);
                }});
            } else if (label.equals(GroupBoard.obsPropSpec) && source.getArtifactType().equals(GroupBoard.class.getName())) {
                runOnPerceive.put(piGrSpec, new Runnable() {  public void run() {
                    updateSpecification(source, content, piGrSpec);
                }});
            } else if (label.equals(SchemeBoard.obsPropSpec) && source.getArtifactType().equals(SchemeBoard.class.getName())) {
                runOnPerceive.put(piSchSpec, new Runnable() {  public void run() {
                    updateSpecification(source, content, piSchSpec);
                }});
            //} else if (label.equals(OrgArt.sglNormFailure)) {
            //    Literal reason = ((JasonLiteralWrapper)content).getLiteral();
            //    List<Term> failAnnots = JasonException.createBasicErrorAnnots( "norm_failure", "Error resuming pending intention related to organisational action: "+ev);
            //    failAnnots.add(ASSyntax.createStructure("norm_failure", reason.getTerm(0)));
                // TODO: fail the intention and put good annotations in the failure event
            } else if (label.equals(SchemeBoard.obsPropGroups)) { // ignore this obs prop in jason
            } else if (label.equals(OrgArt.sglDestroyed)) { // artifact destroyed
                runOnPerceive.put(piSglDestroy, new Runnable() {  public void run() {
                    cleanupBB(source);
                }});
                return false;
            } else {
                return false;
            }
            return true;            
        }
    }
    
    private void updateSpecification(ArtifactId source, Object content, PredicateIndicator pi) {
        try {
            if (content instanceof ToProlog) {

                List<Literal> toAdd = new ArrayList<Literal>();                
                Literal l = ASSyntax.parseLiteral( ((ToProlog)content).getAsProlog() );
                l.addSource(ASSyntax.createAtom(source.getWorkspaceId().getName()));
                Term artAnnot = ASSyntax.createStructure("artifact", ASSyntax.createAtom(source.getName()));
                l.addAnnot(artAnnot);
                toAdd.add(l);
                orgBUF(toAdd, pi, artAnnot);
            }
        } catch (ParseException e) {
            logger.log(Level.SEVERE,"Error updating "+content, e);
        }
    }

    @SuppressWarnings("unchecked")
    private void updateObligations(ArtifactId source, Object content) {
        List<Literal> toAdd = new ArrayList<Literal>();
        Term artAnnot = ASSyntax.createStructure("artifact", ASSyntax.createAtom(source.getName()));
        for (Literal o: (Collection<Literal>)content) {
            Literal l = o.copy();
            l.addSource(ASSyntax.createAtom(source.getWorkspaceId().getName()));
            l.addAnnot(artAnnot);
            toAdd.add(l);
        }
        orgBUF(toAdd, piObligation, artAnnot);
    }

    @SuppressWarnings("unchecked")
    private void updateResponsibleGroup(ArtifactId source, Object content)  {
        // content is a set of schemes
        Atom gId = new Atom(source.getName());
        Term grAnnot = ASSyntax.createStructure("artifact", ASSyntax.createAtom(source.getName()));
        List<Literal> toAdd = new ArrayList<Literal>();
        for (String s: (Collection<String>)content) {
            Atom schAtom = new Atom(s);
            Literal l = createLiteral(piResponsibleGroup.getFunctor(), gId, schAtom);
            l.addSource(ASSyntax.createAtom(source.getWorkspaceId().getName()));
            l.addAnnot(grAnnot);
            l.addAnnot(ASSyntax.createStructure("artifact", schAtom));
            toAdd.add(l);
        }
        orgBUF(toAdd, piResponsibleGroup, grAnnot);
    }

    @SuppressWarnings("unchecked")
    private void updatePlayers(ArtifactId source, Object content, PredicateIndicator pred) {
        // event arg is a collection of Players (from oe)
        Term artAnnot = ASSyntax.createStructure("artifact", ASSyntax.createAtom(source.getName()));
        List<Literal> toAdd = new ArrayList<Literal>();
        for (Player p: (Collection<Player>)content) {
            Literal l = createLiteral(pred.getFunctor(), new Atom(p.getAg()), new Atom(p.getTarget()), new Atom(source.getName()));
            l.addSource(ASSyntax.createAtom(source.getWorkspaceId().getName()));
            l.addAnnot(artAnnot);
            toAdd.add(l);
        }
        orgBUF(toAdd, pred, artAnnot);
    }
    
    @SuppressWarnings("unchecked")
    private void updateGoals(ArtifactId source, Object content) {
        // event arg is a collection of literals with goal state
        Term artAnnot = ASSyntax.createStructure("artifact", ASSyntax.createAtom(source.getName()));
        List<Literal> toAdd = new ArrayList<Literal>();
        for (Literal g: (Collection<Literal>)content) {
            Literal l = g.copy();
            l.addSource(ASSyntax.createAtom(source.getWorkspaceId().getName()));
            l.addAnnot(artAnnot);
            toAdd.add(l);
        }
        orgBUF(toAdd, SchemeBoard.piGoalState, artAnnot);
    }

    private void updateWF(ArtifactId source, Object content, PredicateIndicator pred) {
        Term artAnnot = ASSyntax.createStructure("artifact", ASSyntax.createAtom(source.getName()));
        List<Literal> toAdd = new ArrayList<Literal>();
        Literal l = createLiteral(pred.getFunctor(), new Atom(content.toString()));
        l.addSource(ASSyntax.createAtom(source.getWorkspaceId().getName()));
        l.addAnnot(artAnnot);
        toAdd.add(l);
        orgBUF(toAdd, pred, artAnnot);
    }

    private void cleanupBB(ArtifactId source) {
        try {
            Literal v = new UnnamedVar();
            v.addAnnot( ASSyntax.createStructure("artifact", new Atom(source.getName())));
            getTS().getAg().abolish(v, null);
        } catch (RevisionFailedException e) {
            e.printStackTrace();
        }
    }
    
    
    public boolean isOrgArt(String aType) {
        return aType.equals(GroupBoard.class.getName()) || 
               aType.equals(SchemeBoard.class.getName());
    }
    
    private List<Literal> orgBUF(List<Literal> toAdd, PredicateIndicator bel, Term source) {
        if (getTS().getLogger().isLoggable(Level.FINE)) getTS().getLogger().fine("orgBUF for "+bel+" with "+toAdd+" for "+source);

        List<Literal> toDel = new ArrayList<Literal>();
        Agent ag = getTS().getAg();
        
        // remove old bels
        Iterator<Literal> i = ag.getBB().getCandidateBeliefs(bel);
        if (i != null) {
            while (i.hasNext()) {
                Literal l = i.next();
                ListTerm artifacts = l.getAnnots("artifact");
                if (source == null || artifacts.contains(source)) { // consider only beliefs from source art
                    boolean isInOE = false;
                    Iterator<Literal> ip = toAdd.iterator();
                    while (ip.hasNext()) {
                        Literal p = ip.next();
                        if (p.equalsAsStructure(l)) { // if the beliefs is in the BB, remove from toAdd (ignore annots)
                            isInOE = true;
                            ip.remove();
                            break;
                        }
                    }
                    if (!isInOE) { // if the beliefs is not in toADD, remove from BB
                        toDel.add(l);
                    }
                }
            }
        }
        
        if (getTS().getLogger().isLoggable(Level.FINE)) getTS().getLogger().fine("org buf add: "+toAdd+"\norg bug del: "+toDel);        
        try {
            for (Literal l: toDel)
                ag.delBel(l);
            
            for (Literal l: toAdd)
                ag.addBel(l);
        } catch (RevisionFailedException e) {
            e.printStackTrace();
        }
        
        if (getTS().getLogger().isLoggable(Level.FINE)) getTS().getLogger().fine("end of orgBUG");
        return toDel;
    }
    
    String arg2str(Term a) {
        if (a.isString())
            return ((StringTerm)a).getString();
        else 
            return a.toString();
    }

    boolean arg2bool(Term a) {
        if (a.isString())
            return ((StringTerm)a).getString().equals("true");
        else 
            return a.toString().equals("true");
    }

    class CreateGroup extends CartagoAction {
        public void execute(String agName, CAgentArch agent, ICartagoContext ctx, Structure action, ActionExec actionExec){                     
            try {
                // parameters
                String gId = arg2str(action.getTerm(0)); 

                ArtifactId aid = ctx.makeArtifact(
                        gId,   
                        GroupBoard.class.getName(),  
                        new ArtifactConfig( gId, arg2str(action.getTerm(1)), arg2str(action.getTerm(2)), arg2bool(action.getTerm(3)), arg2bool(action.getTerm(4))));
                ctx.focus(aid);

                //logger.info("created "+aid+"@"+aid.getWorkspaceId().getName());
                notifyActionSuccess(agent, actionExec);
            } catch (CartagoException e) {
                Literal reason = ASSyntax.createLiteral("cartago_action_failed",action);
                String   msg   = "Error in create group "+e.getMessage();
                notifyActionFailure(agent, actionExec, reason, msg); 
                logger.log(Level.SEVERE,"Cartago error: "+e, e);
            }
        }
    }

    class RemoveOrgArt extends CartagoAction {
        public void execute(String agName, CAgentArch agent, final ICartagoContext ctx, Structure action, ActionExec actionExec){                     
            try {
                String artIdStr = arg2str(action.getTerm(0)); 

                final ArtifactId aid = ctx.lookupArtifact(artIdStr);
                if (aid == null){
                    logger.warning("remove art by "+agName+" failed - artifact not found: "+artIdStr);
                    notifyActionFailure(agent, actionExec, ASSyntax.createLiteral("artifact_unknown",new StringTermImpl(artIdStr)), "artifact "+aid+" does not exist to be removed.");
                } else {
                    PendingAction act = agent.createPendingAction(agent, agName, action, actionExec);
                    ctx.use(act.getActionId(),aid,new Op("destroy"),null,Long.MAX_VALUE);
                    
                    // call dispose later
                    getTS().getAg().getScheduler().schedule(new Callable<Object>() {
                        public Object call() throws Exception {
                            ctx.disposeArtifact(aid);
                            return null;
                        }
                    }, 4, TimeUnit.SECONDS);
                }
                notifyActionSuccess(agent, actionExec);
            } catch (Exception e) {
                Literal reason = ASSyntax.createLiteral("cartago_action_failed",action);
                String   msg   = "Error in remove group "+e.getMessage();
                notifyActionFailure(agent, actionExec, reason, msg); 
                logger.log(Level.SEVERE,"Cartago error: "+e, e);
            }
        }
    }
    
    class CreateScheme extends CartagoAction {
        public void execute(String agName, CAgentArch agent, ICartagoContext ctx, Structure action, ActionExec actionExec){                     
            try {
                // parameters
                String sId = arg2str(action.getTerm(0)); 
                
                ArtifactId aid = ctx.makeArtifact(
                        sId,   
                        SchemeBoard.class.getName(),  
                        new ArtifactConfig( sId, arg2str(action.getTerm(1)), arg2str(action.getTerm(2)), arg2bool(action.getTerm(3)), arg2bool(action.getTerm(4))));
                ctx.focus(aid);

                notifyActionSuccess(agent, actionExec);
            } catch (CartagoException e) {
                Literal reason = ASSyntax.createLiteral("cartago_action_failed",action);
                String   msg   = "Error in create group "+e.getMessage();
                notifyActionFailure(agent, actionExec, reason, msg); 
                logger.log(Level.SEVERE,"Cartago error: "+e, e);
            }
        }
    }

    // basic class for all other actions
    abstract class OrgAction extends CartagoAction {
        public void execute(String agName, CAgentArch agent, ICartagoContext ctx, Structure action, ActionExec actionExec) {                     
            try {
                PendingAction act = agent.createPendingAction(agent, agName, action, actionExec);
                ArtifactId aid = ctx.lookupArtifact( arg2str(action.getTerm( getArtPosition()) ));
                ctx.use(act.getActionId(), aid, getOp(action), null,Long.MAX_VALUE);
                if (focusAfter())
                    ctx.focus(aid);

            } catch (Exception e) {
                Literal reason = ASSyntax.createLiteral("cartago_action_failed",action);
                String   msg   = "Error in organisational action "+action+": "+e.getMessage();
                notifyActionFailure(agent, actionExec, reason, msg); 
                logger.log(Level.SEVERE,"Cartago error: "+e, e);
            }
        }
        abstract Op getOp(Structure action);
        int getArtPosition() { return 1; } // the position of the art id in the parameters
        boolean focusAfter() { return false; }
    }


    class AddResponsibleGroup extends OrgAction {
        Op getOp(Structure action) {
            return new Op("addScheme", arg2str(action.getTerm(0)));
        }
    }
    
    class AdoptRole extends OrgAction {
        Op getOp(Structure action) {
            return new Op("adoptRole", arg2str(action.getTerm(0)));
        }
        boolean focusAfter() { 
            return true; 
        }
    }
    
    class LeaveRole extends OrgAction {
        Op getOp(Structure action) {
            return new Op("leaveRole", arg2str(action.getTerm(0)));
        }
    }

    class CommitMission extends OrgAction {
        Op getOp(Structure action) {
            return new Op("commitMission", arg2str(action.getTerm(0)));
        }
        boolean focusAfter() { 
            return true; 
        }
    }

    class LeaveMission extends OrgAction {
        Op getOp(Structure action) {
            return new Op("leaveMission", arg2str(action.getTerm(0)));
        }
    }

    class GoalAchieved extends OrgAction {
        Op getOp(Structure action) {
            return new Op("goalAchieved", arg2str(action.getTerm(0)));
        }
    }

    class SetGoalArgValue extends OrgAction {
        Op getOp(Structure action) {
            return new Op("setArgumentValue", arg2str(action.getTerm(1)), arg2str(action.getTerm(2)), arg2str(action.getTerm(3)));
        }
        int getArtPosition() {
            return 0;
        }
    }

}
