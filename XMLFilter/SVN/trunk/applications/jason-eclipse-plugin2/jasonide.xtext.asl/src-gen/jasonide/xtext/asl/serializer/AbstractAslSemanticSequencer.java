package jasonide.xtext.asl.serializer;

import com.google.inject.Inject;
import com.google.inject.Provider;
import jasonide.xtext.asl.asl.Agent;
import jasonide.xtext.asl.asl.Arithm_expr;
import jasonide.xtext.asl.asl.Arithm_expr_factor;
import jasonide.xtext.asl.asl.Arithm_expr_simple;
import jasonide.xtext.asl.asl.Arithm_expr_trm;
import jasonide.xtext.asl.asl.AslPackage;
import jasonide.xtext.asl.asl.Belief;
import jasonide.xtext.asl.asl.Body_formula;
import jasonide.xtext.asl.asl.Directive;
import jasonide.xtext.asl.asl.Function;
import jasonide.xtext.asl.asl.Initial_goal;
import jasonide.xtext.asl.asl.List;
import jasonide.xtext.asl.asl.Literal;
import jasonide.xtext.asl.asl.Log_expr;
import jasonide.xtext.asl.asl.Log_expr_factor;
import jasonide.xtext.asl.asl.Log_expr_trm;
import jasonide.xtext.asl.asl.Plan;
import jasonide.xtext.asl.asl.Plan_body;
import jasonide.xtext.asl.asl.Plan_term;
import jasonide.xtext.asl.asl.Pred;
import jasonide.xtext.asl.asl.Rel_expr;
import jasonide.xtext.asl.asl.StmtFOR;
import jasonide.xtext.asl.asl.StmtIF;
import jasonide.xtext.asl.asl.StmtWHILE;
import jasonide.xtext.asl.asl.Term;
import jasonide.xtext.asl.asl.Term_in_list;
import jasonide.xtext.asl.asl.Terms;
import jasonide.xtext.asl.asl.Trigger;
import jasonide.xtext.asl.asl.Var;
import jasonide.xtext.asl.services.AslGrammarAccess;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.serializer.acceptor.ISemanticSequenceAcceptor;
import org.eclipse.xtext.serializer.acceptor.SequenceFeeder;
import org.eclipse.xtext.serializer.diagnostic.ISemanticSequencerDiagnosticProvider;
import org.eclipse.xtext.serializer.diagnostic.ISerializationDiagnostic.Acceptor;
import org.eclipse.xtext.serializer.sequencer.AbstractSemanticSequencer;
import org.eclipse.xtext.serializer.sequencer.GenericSequencer;
import org.eclipse.xtext.serializer.sequencer.ISemanticNodeProvider.INodesForEObjectProvider;
import org.eclipse.xtext.serializer.sequencer.ISemanticSequencer;
import org.eclipse.xtext.serializer.sequencer.ITransientValueService;
import org.eclipse.xtext.serializer.sequencer.ITransientValueService.ValueTransient;

@SuppressWarnings("restriction")
public class AbstractAslSemanticSequencer extends AbstractSemanticSequencer {

	@Inject
	protected AslGrammarAccess grammarAccess;
	
	@Inject
	protected ISemanticSequencerDiagnosticProvider diagnosticProvider;
	
	@Inject
	protected ITransientValueService transientValues;
	
	@Inject
	@GenericSequencer
	protected Provider<ISemanticSequencer> genericSequencerProvider;
	
	protected ISemanticSequencer genericSequencer;
	
	
	@Override
	public void init(ISemanticSequencer sequencer, ISemanticSequenceAcceptor sequenceAcceptor, Acceptor errorAcceptor) {
		super.init(sequencer, sequenceAcceptor, errorAcceptor);
		this.genericSequencer = genericSequencerProvider.get();
		this.genericSequencer.init(sequencer, sequenceAcceptor, errorAcceptor);
	}
	
	public void createSequence(EObject context, EObject semanticObject) {
		if(semanticObject.eClass().getEPackage() == AslPackage.eINSTANCE) switch(semanticObject.eClass().getClassifierID()) {
			case AslPackage.AGENT:
				if(context == grammarAccess.getAgentRule()) {
					sequence_Agent(context, (Agent) semanticObject); 
					return; 
				}
				else break;
			case AslPackage.ARITHM_EXPR:
				if(context == grammarAccess.getArithm_exprRule()) {
					sequence_Arithm_expr(context, (Arithm_expr) semanticObject); 
					return; 
				}
				else break;
			case AslPackage.ARITHM_EXPR_FACTOR:
				if(context == grammarAccess.getArithm_expr_factorRule()) {
					sequence_Arithm_expr_factor(context, (Arithm_expr_factor) semanticObject); 
					return; 
				}
				else break;
			case AslPackage.ARITHM_EXPR_SIMPLE:
				if(context == grammarAccess.getArithm_expr_simpleRule()) {
					sequence_Arithm_expr_simple(context, (Arithm_expr_simple) semanticObject); 
					return; 
				}
				else break;
			case AslPackage.ARITHM_EXPR_TRM:
				if(context == grammarAccess.getArithm_expr_trmRule()) {
					sequence_Arithm_expr_trm(context, (Arithm_expr_trm) semanticObject); 
					return; 
				}
				else break;
			case AslPackage.BELIEF:
				if(context == grammarAccess.getBeliefRule()) {
					sequence_Belief(context, (Belief) semanticObject); 
					return; 
				}
				else break;
			case AslPackage.BODY_FORMULA:
				if(context == grammarAccess.getBody_formulaRule()) {
					sequence_Body_formula(context, (Body_formula) semanticObject); 
					return; 
				}
				else break;
			case AslPackage.DIRECTIVE:
				if(context == grammarAccess.getDirectiveRule()) {
					sequence_Directive(context, (Directive) semanticObject); 
					return; 
				}
				else break;
			case AslPackage.FUNCTION:
				if(context == grammarAccess.getFunctionRule()) {
					sequence_Function(context, (Function) semanticObject); 
					return; 
				}
				else break;
			case AslPackage.INITIAL_GOAL:
				if(context == grammarAccess.getInitial_goalRule()) {
					sequence_Initial_goal(context, (Initial_goal) semanticObject); 
					return; 
				}
				else break;
			case AslPackage.LIST:
				if(context == grammarAccess.getListRule()) {
					sequence_List(context, (List) semanticObject); 
					return; 
				}
				else break;
			case AslPackage.LITERAL:
				if(context == grammarAccess.getLiteralRule()) {
					sequence_Literal(context, (Literal) semanticObject); 
					return; 
				}
				else break;
			case AslPackage.LOG_EXPR:
				if(context == grammarAccess.getLog_exprRule()) {
					sequence_Log_expr(context, (Log_expr) semanticObject); 
					return; 
				}
				else break;
			case AslPackage.LOG_EXPR_FACTOR:
				if(context == grammarAccess.getLog_expr_factorRule()) {
					sequence_Log_expr_factor(context, (Log_expr_factor) semanticObject); 
					return; 
				}
				else break;
			case AslPackage.LOG_EXPR_TRM:
				if(context == grammarAccess.getLog_expr_trmRule()) {
					sequence_Log_expr_trm(context, (Log_expr_trm) semanticObject); 
					return; 
				}
				else break;
			case AslPackage.NUMBER:
				if(context == grammarAccess.getNumberRule()) {
					sequence_Number(context, (jasonide.xtext.asl.asl.Number) semanticObject); 
					return; 
				}
				else break;
			case AslPackage.PLAN:
				if(context == grammarAccess.getPlanRule()) {
					sequence_Plan(context, (Plan) semanticObject); 
					return; 
				}
				else break;
			case AslPackage.PLAN_BODY:
				if(context == grammarAccess.getPlan_bodyRule()) {
					sequence_Plan_body(context, (Plan_body) semanticObject); 
					return; 
				}
				else break;
			case AslPackage.PLAN_TERM:
				if(context == grammarAccess.getPlan_termRule()) {
					sequence_Plan_term(context, (Plan_term) semanticObject); 
					return; 
				}
				else break;
			case AslPackage.PRED:
				if(context == grammarAccess.getPredRule()) {
					sequence_Pred(context, (Pred) semanticObject); 
					return; 
				}
				else break;
			case AslPackage.REL_EXPR:
				if(context == grammarAccess.getRel_exprRule()) {
					sequence_Rel_expr(context, (Rel_expr) semanticObject); 
					return; 
				}
				else break;
			case AslPackage.STMT_FOR:
				if(context == grammarAccess.getStmtFORRule()) {
					sequence_StmtFOR(context, (StmtFOR) semanticObject); 
					return; 
				}
				else break;
			case AslPackage.STMT_IF:
				if(context == grammarAccess.getStmtIFRule()) {
					sequence_StmtIF(context, (StmtIF) semanticObject); 
					return; 
				}
				else break;
			case AslPackage.STMT_WHILE:
				if(context == grammarAccess.getStmtWHILERule()) {
					sequence_StmtWHILE(context, (StmtWHILE) semanticObject); 
					return; 
				}
				else break;
			case AslPackage.STRING:
				if(context == grammarAccess.getStringRule()) {
					sequence_String(context, (jasonide.xtext.asl.asl.String) semanticObject); 
					return; 
				}
				else break;
			case AslPackage.TERM:
				if(context == grammarAccess.getTermRule()) {
					sequence_Term(context, (Term) semanticObject); 
					return; 
				}
				else break;
			case AslPackage.TERM_IN_LIST:
				if(context == grammarAccess.getTerm_in_listRule()) {
					sequence_Term_in_list(context, (Term_in_list) semanticObject); 
					return; 
				}
				else break;
			case AslPackage.TERMS:
				if(context == grammarAccess.getTermsRule()) {
					sequence_Terms(context, (Terms) semanticObject); 
					return; 
				}
				else break;
			case AslPackage.TRIGGER:
				if(context == grammarAccess.getTriggerRule()) {
					sequence_Trigger(context, (Trigger) semanticObject); 
					return; 
				}
				else break;
			case AslPackage.VAR:
				if(context == grammarAccess.getVarRule()) {
					sequence_Var(context, (Var) semanticObject); 
					return; 
				}
				else break;
			}
		if (errorAcceptor != null) errorAcceptor.accept(diagnosticProvider.createInvalidContextOrTypeDiagnostic(semanticObject, context));
	}
	
	/**
	 * Constraint:
	 *     (
	 *         directive+=Directive* 
	 *         (belief+=Belief directive+=Directive*)* 
	 *         (initial_goal+=Initial_goal directive+=Directive*)* 
	 *         (plan+=Plan belief+=Belief* directive+=Directive*)*
	 *     )
	 *
	 * Features:
	 *    directive[0, *]
	 *    belief[0, *]
	 *    initial_goal[0, *]
	 *         MANDATORY_IF_SET directive
	 *    plan[0, *]
	 *         MANDATORY_IF_SET belief
	 *         MANDATORY_IF_SET directive
	 */
	protected void sequence_Agent(EObject context, Agent semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (arithm_expr_trm=Arithm_expr_trm (subadd=TK_SUB_ADD arithm_expr=Arithm_expr)?)
	 *
	 * Features:
	 *    arithm_expr_trm[1, 1]
	 *    subadd[0, 1]
	 *         EXCLUDE_IF_UNSET arithm_expr
	 *         MANDATORY_IF_SET arithm_expr
	 *    arithm_expr[0, 1]
	 *         EXCLUDE_IF_UNSET subadd
	 *         MANDATORY_IF_SET subadd
	 */
	protected void sequence_Arithm_expr(EObject context, Arithm_expr semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (arithm_expr_simple=Arithm_expr_simple (exponential=TK_EXPONENTIAL arithm_expr_factor=Arithm_expr_factor)?)
	 *
	 * Features:
	 *    arithm_expr_simple[1, 1]
	 *    exponential[0, 1]
	 *         EXCLUDE_IF_UNSET arithm_expr_factor
	 *         MANDATORY_IF_SET arithm_expr_factor
	 *    arithm_expr_factor[0, 1]
	 *         EXCLUDE_IF_UNSET exponential
	 *         MANDATORY_IF_SET exponential
	 */
	protected void sequence_Arithm_expr_factor(EObject context, Arithm_expr_factor semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (number=Number | (unary=TK_UNARY_OP arithm_expr_simple=Arithm_expr_simple) | log_expr=Log_expr | var=Var | function=Function)
	 *
	 * Features:
	 *    number[0, 1]
	 *         EXCLUDE_IF_SET unary
	 *         EXCLUDE_IF_SET arithm_expr_simple
	 *         EXCLUDE_IF_SET log_expr
	 *         EXCLUDE_IF_SET var
	 *         EXCLUDE_IF_SET function
	 *    unary[0, 1]
	 *         EXCLUDE_IF_UNSET arithm_expr_simple
	 *         MANDATORY_IF_SET arithm_expr_simple
	 *         EXCLUDE_IF_SET number
	 *         EXCLUDE_IF_SET log_expr
	 *         EXCLUDE_IF_SET var
	 *         EXCLUDE_IF_SET function
	 *    arithm_expr_simple[0, 1]
	 *         EXCLUDE_IF_UNSET unary
	 *         MANDATORY_IF_SET unary
	 *         EXCLUDE_IF_SET number
	 *         EXCLUDE_IF_SET log_expr
	 *         EXCLUDE_IF_SET var
	 *         EXCLUDE_IF_SET function
	 *    log_expr[0, 1]
	 *         EXCLUDE_IF_SET number
	 *         EXCLUDE_IF_SET unary
	 *         EXCLUDE_IF_SET arithm_expr_simple
	 *         EXCLUDE_IF_SET var
	 *         EXCLUDE_IF_SET function
	 *    var[0, 1]
	 *         EXCLUDE_IF_SET number
	 *         EXCLUDE_IF_SET unary
	 *         EXCLUDE_IF_SET arithm_expr_simple
	 *         EXCLUDE_IF_SET log_expr
	 *         EXCLUDE_IF_SET function
	 *    function[0, 1]
	 *         EXCLUDE_IF_SET number
	 *         EXCLUDE_IF_SET unary
	 *         EXCLUDE_IF_SET arithm_expr_simple
	 *         EXCLUDE_IF_SET log_expr
	 *         EXCLUDE_IF_SET var
	 */
	protected void sequence_Arithm_expr_simple(EObject context, Arithm_expr_simple semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (arithm_expr_factor=Arithm_expr_factor ((muldiv=TK_MUL_DIV | tk_intdiv=TK_INTDIV | tk_intmod=TK_INTMOD) arithm_expr_trm=Arithm_expr_trm)?)
	 *
	 * Features:
	 *    arithm_expr_factor[1, 1]
	 *    muldiv[0, 1]
	 *         EXCLUDE_IF_SET tk_intdiv
	 *         EXCLUDE_IF_SET tk_intmod
	 *         EXCLUDE_IF_UNSET arithm_expr_trm
	 *    tk_intdiv[0, 1]
	 *         EXCLUDE_IF_SET muldiv
	 *         EXCLUDE_IF_SET tk_intmod
	 *         EXCLUDE_IF_UNSET arithm_expr_trm
	 *    tk_intmod[0, 1]
	 *         EXCLUDE_IF_SET muldiv
	 *         EXCLUDE_IF_SET tk_intdiv
	 *         EXCLUDE_IF_UNSET arithm_expr_trm
	 *    arithm_expr_trm[0, 1]
	 *         MANDATORY_IF_SET muldiv
	 *         MANDATORY_IF_SET tk_intdiv
	 *         MANDATORY_IF_SET tk_intmod
	 */
	protected void sequence_Arithm_expr_trm(EObject context, Arithm_expr_trm semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (literal=Literal log_expr=Log_expr?)
	 *
	 * Features:
	 *    literal[1, 1]
	 *    log_expr[0, 1]
	 */
	protected void sequence_Belief(EObject context, Belief semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     log_expr=Log_expr
	 *
	 * Features:
	 *    log_expr[1, 1]
	 */
	protected void sequence_Body_formula(EObject context, Body_formula semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, AslPackage.Literals.BODY_FORMULA__LOG_EXPR) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, AslPackage.Literals.BODY_FORMULA__LOG_EXPR));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getBody_formulaAccess().getLog_exprLog_exprParserRuleCall_1_0(), semanticObject.getLog_expr());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     ((tk_begin=TK_BEGIN pred=Pred agent=Agent) | pred2=Pred)
	 *
	 * Features:
	 *    tk_begin[0, 1]
	 *         EXCLUDE_IF_UNSET pred
	 *         MANDATORY_IF_SET pred
	 *         EXCLUDE_IF_UNSET agent
	 *         MANDATORY_IF_SET agent
	 *         EXCLUDE_IF_SET pred2
	 *    pred[0, 1]
	 *         EXCLUDE_IF_UNSET tk_begin
	 *         MANDATORY_IF_SET tk_begin
	 *         EXCLUDE_IF_UNSET agent
	 *         MANDATORY_IF_SET agent
	 *         EXCLUDE_IF_SET pred2
	 *    agent[0, 1]
	 *         EXCLUDE_IF_UNSET tk_begin
	 *         MANDATORY_IF_SET tk_begin
	 *         EXCLUDE_IF_UNSET pred
	 *         MANDATORY_IF_SET pred
	 *         EXCLUDE_IF_SET pred2
	 *    pred2[0, 1]
	 *         EXCLUDE_IF_SET tk_begin
	 *         EXCLUDE_IF_SET pred
	 *         EXCLUDE_IF_SET agent
	 */
	protected void sequence_Directive(EObject context, Directive semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     literal=Literal
	 *
	 * Features:
	 *    literal[1, 1]
	 */
	protected void sequence_Function(EObject context, Function semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, AslPackage.Literals.FUNCTION__LITERAL) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, AslPackage.Literals.FUNCTION__LITERAL));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getFunctionAccess().getLiteralLiteralParserRuleCall_0(), semanticObject.getLiteral());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     literal=Literal
	 *
	 * Features:
	 *    literal[1, 1]
	 */
	protected void sequence_Initial_goal(EObject context, Initial_goal semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, AslPackage.Literals.INITIAL_GOAL__LITERAL) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, AslPackage.Literals.INITIAL_GOAL__LITERAL));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getInitial_goalAccess().getLiteralLiteralParserRuleCall_1_0(), semanticObject.getLiteral());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     ((term_in_list+=Term_in_list term_in_list+=Term_in_list* (var=VART | unnamedvar=UNNAMEDVART | list=List)?)?)
	 *
	 * Features:
	 *    term_in_list[0, *]
	 *    var[0, 1]
	 *         EXCLUDE_IF_SET unnamedvar
	 *         EXCLUDE_IF_SET list
	 *         EXCLUDE_IF_UNSET term_in_list
	 *    unnamedvar[0, 1]
	 *         EXCLUDE_IF_SET var
	 *         EXCLUDE_IF_SET list
	 *         EXCLUDE_IF_UNSET term_in_list
	 *    list[0, 1]
	 *         EXCLUDE_IF_SET var
	 *         EXCLUDE_IF_SET unnamedvar
	 *         EXCLUDE_IF_UNSET term_in_list
	 */
	protected void sequence_List(EObject context, List semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     ((tk_neg=TK_NEG? pred=Pred) | tk_true=TK_TRUE | tk_false=TK_FALSE)
	 *
	 * Features:
	 *    tk_neg[0, 1]
	 *         EXCLUDE_IF_UNSET pred
	 *         EXCLUDE_IF_SET tk_true
	 *         EXCLUDE_IF_SET tk_false
	 *    pred[0, 1]
	 *         MANDATORY_IF_SET tk_neg
	 *         EXCLUDE_IF_SET tk_true
	 *         EXCLUDE_IF_SET tk_false
	 *    tk_true[0, 1]
	 *         EXCLUDE_IF_SET tk_neg
	 *         EXCLUDE_IF_SET pred
	 *         EXCLUDE_IF_SET tk_false
	 *    tk_false[0, 1]
	 *         EXCLUDE_IF_SET tk_neg
	 *         EXCLUDE_IF_SET pred
	 *         EXCLUDE_IF_SET tk_true
	 */
	protected void sequence_Literal(EObject context, Literal semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (log_expr_trm=Log_expr_trm log_expr=Log_expr?)
	 *
	 * Features:
	 *    log_expr_trm[1, 1]
	 *    log_expr[0, 1]
	 */
	protected void sequence_Log_expr(EObject context, Log_expr semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     ((tk_not=TK_NOT log_expr_factor=Log_expr_factor) | rel_expr=Rel_expr)
	 *
	 * Features:
	 *    tk_not[0, 1]
	 *         EXCLUDE_IF_UNSET log_expr_factor
	 *         MANDATORY_IF_SET log_expr_factor
	 *         EXCLUDE_IF_SET rel_expr
	 *    log_expr_factor[0, 1]
	 *         EXCLUDE_IF_UNSET tk_not
	 *         MANDATORY_IF_SET tk_not
	 *         EXCLUDE_IF_SET rel_expr
	 *    rel_expr[0, 1]
	 *         EXCLUDE_IF_SET tk_not
	 *         EXCLUDE_IF_SET log_expr_factor
	 */
	protected void sequence_Log_expr_factor(EObject context, Log_expr_factor semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (log_expr_factor=Log_expr_factor log_expr_trm=Log_expr_trm?)
	 *
	 * Features:
	 *    log_expr_factor[1, 1]
	 *    log_expr_trm[0, 1]
	 */
	protected void sequence_Log_expr_trm(EObject context, Log_expr_trm semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     ((number+=NUMBERT+ decimalPart+=NUMBERT+) | decimalPart+=NUMBERT+ | number+=NUMBERT+)
	 *
	 * Features:
	 *    number[0, *]
	 *         EXCLUDE_IF_SET decimalPart
	 *    decimalPart[0, *]
	 *         EXCLUDE_IF_SET number
	 */
	protected void sequence_Number(EObject context, jasonide.xtext.asl.asl.Number semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     ((tk_label_at=TK_LABEL_AT pred=Pred)? trigger=Trigger log_expr=Log_expr? plan_body=Plan_body?)
	 *
	 * Features:
	 *    tk_label_at[0, 1]
	 *         EXCLUDE_IF_UNSET pred
	 *         MANDATORY_IF_SET pred
	 *    pred[0, 1]
	 *         EXCLUDE_IF_UNSET tk_label_at
	 *         MANDATORY_IF_SET tk_label_at
	 *    trigger[1, 1]
	 *    log_expr[0, 1]
	 *    plan_body[0, 1]
	 */
	protected void sequence_Plan(EObject context, Plan semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     ((stmtIF=StmtIF | stmtFOR=StmtFOR | stmtWHILE=StmtWHILE | body_formula=Body_formula) plan_body=Plan_body?)
	 *
	 * Features:
	 *    stmtIF[0, 1]
	 *         EXCLUDE_IF_SET stmtFOR
	 *         EXCLUDE_IF_SET stmtWHILE
	 *         EXCLUDE_IF_SET body_formula
	 *    stmtFOR[0, 1]
	 *         EXCLUDE_IF_SET stmtIF
	 *         EXCLUDE_IF_SET stmtWHILE
	 *         EXCLUDE_IF_SET body_formula
	 *    stmtWHILE[0, 1]
	 *         EXCLUDE_IF_SET stmtIF
	 *         EXCLUDE_IF_SET stmtFOR
	 *         EXCLUDE_IF_SET body_formula
	 *    body_formula[0, 1]
	 *         EXCLUDE_IF_SET stmtIF
	 *         EXCLUDE_IF_SET stmtFOR
	 *         EXCLUDE_IF_SET stmtWHILE
	 *    plan_body[0, 1]
	 */
	protected void sequence_Plan_body(EObject context, Plan_body semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (((tk_label_at=TK_LABEL_AT pred=Pred)? trigger=Trigger log_expr=Log_expr?)? plan_body=Plan_body?)
	 *
	 * Features:
	 *    tk_label_at[0, 1]
	 *         EXCLUDE_IF_UNSET pred
	 *         MANDATORY_IF_SET pred
	 *         EXCLUDE_IF_UNSET trigger
	 *    pred[0, 1]
	 *         EXCLUDE_IF_UNSET tk_label_at
	 *         MANDATORY_IF_SET tk_label_at
	 *         EXCLUDE_IF_UNSET trigger
	 *    trigger[0, 1]
	 *         MANDATORY_IF_SET tk_label_at
	 *         MANDATORY_IF_SET pred
	 *         MANDATORY_IF_SET log_expr
	 *    log_expr[0, 1]
	 *         EXCLUDE_IF_UNSET trigger
	 *    plan_body[0, 1]
	 */
	protected void sequence_Plan_term(EObject context, Plan_term semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     ((atom=JASON_ATOM | tk_begin=TK_BEGIN | tk_end=TK_END) terms=Terms? plan_term+=Plan_term* list=List?)
	 *
	 * Features:
	 *    atom[0, 1]
	 *         EXCLUDE_IF_SET tk_begin
	 *         EXCLUDE_IF_SET tk_end
	 *    tk_begin[0, 1]
	 *         EXCLUDE_IF_SET atom
	 *         EXCLUDE_IF_SET tk_end
	 *    tk_end[0, 1]
	 *         EXCLUDE_IF_SET atom
	 *         EXCLUDE_IF_SET tk_begin
	 *    terms[0, 1]
	 *    plan_term[0, *]
	 *    list[0, 1]
	 */
	protected void sequence_Pred(EObject context, Pred semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     ((arithm_exp=Arithm_expr | string=String) (relOp=TK_REL_OP (arithm_expr=Arithm_expr | string2=String | list=List | plan_term=Plan_term))?)
	 *
	 * Features:
	 *    arithm_exp[0, 1]
	 *         EXCLUDE_IF_SET string
	 *    string[0, 1]
	 *         EXCLUDE_IF_SET arithm_exp
	 *    relOp[0, 1]
	 *         MANDATORY_IF_SET arithm_expr
	 *         MANDATORY_IF_SET string2
	 *         MANDATORY_IF_SET list
	 *         MANDATORY_IF_SET plan_term
	 *    arithm_expr[0, 1]
	 *         EXCLUDE_IF_SET string2
	 *         EXCLUDE_IF_SET list
	 *         EXCLUDE_IF_SET plan_term
	 *         EXCLUDE_IF_UNSET relOp
	 *    string2[0, 1]
	 *         EXCLUDE_IF_SET arithm_expr
	 *         EXCLUDE_IF_SET list
	 *         EXCLUDE_IF_SET plan_term
	 *         EXCLUDE_IF_UNSET relOp
	 *    list[0, 1]
	 *         EXCLUDE_IF_SET arithm_expr
	 *         EXCLUDE_IF_SET string2
	 *         EXCLUDE_IF_SET plan_term
	 *         EXCLUDE_IF_UNSET relOp
	 *    plan_term[0, 1]
	 *         EXCLUDE_IF_SET arithm_expr
	 *         EXCLUDE_IF_SET string2
	 *         EXCLUDE_IF_SET list
	 *         EXCLUDE_IF_UNSET relOp
	 */
	protected void sequence_Rel_expr(EObject context, Rel_expr semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (tk_for=TK_FOR log_expr=Log_expr plan_term=Plan_term)
	 *
	 * Features:
	 *    tk_for[1, 1]
	 *    log_expr[1, 1]
	 *    plan_term[1, 1]
	 */
	protected void sequence_StmtFOR(EObject context, StmtFOR semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, AslPackage.Literals.STMT_FOR__TK_FOR) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, AslPackage.Literals.STMT_FOR__TK_FOR));
			if(transientValues.isValueTransient(semanticObject, AslPackage.Literals.STMT_FOR__LOG_EXPR) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, AslPackage.Literals.STMT_FOR__LOG_EXPR));
			if(transientValues.isValueTransient(semanticObject, AslPackage.Literals.STMT_FOR__PLAN_TERM) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, AslPackage.Literals.STMT_FOR__PLAN_TERM));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getStmtFORAccess().getTk_forTK_FORParserRuleCall_0_0(), semanticObject.getTk_for());
		feeder.accept(grammarAccess.getStmtFORAccess().getLog_exprLog_exprParserRuleCall_2_0(), semanticObject.getLog_expr());
		feeder.accept(grammarAccess.getStmtFORAccess().getPlan_termPlan_termParserRuleCall_4_0(), semanticObject.getPlan_term());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     (tk_if=TK_IF log_expr=Log_expr plan_term=Plan_term (tk_else=TK_ELSE? plan_term2=Plan_term)?)
	 *
	 * Features:
	 *    tk_if[1, 1]
	 *    log_expr[1, 1]
	 *    plan_term[1, 1]
	 *    tk_else[0, 1]
	 *         EXCLUDE_IF_UNSET plan_term2
	 *    plan_term2[0, 1]
	 *         MANDATORY_IF_SET tk_else
	 */
	protected void sequence_StmtIF(EObject context, StmtIF semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (tk_while=TK_WHILE log_expr=Log_expr plan_term=Plan_term)
	 *
	 * Features:
	 *    tk_while[1, 1]
	 *    log_expr[1, 1]
	 *    plan_term[1, 1]
	 */
	protected void sequence_StmtWHILE(EObject context, StmtWHILE semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, AslPackage.Literals.STMT_WHILE__TK_WHILE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, AslPackage.Literals.STMT_WHILE__TK_WHILE));
			if(transientValues.isValueTransient(semanticObject, AslPackage.Literals.STMT_WHILE__LOG_EXPR) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, AslPackage.Literals.STMT_WHILE__LOG_EXPR));
			if(transientValues.isValueTransient(semanticObject, AslPackage.Literals.STMT_WHILE__PLAN_TERM) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, AslPackage.Literals.STMT_WHILE__PLAN_TERM));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getStmtWHILEAccess().getTk_whileTK_WHILEParserRuleCall_0_0(), semanticObject.getTk_while());
		feeder.accept(grammarAccess.getStmtWHILEAccess().getLog_exprLog_exprParserRuleCall_2_0(), semanticObject.getLog_expr());
		feeder.accept(grammarAccess.getStmtWHILEAccess().getPlan_termPlan_termParserRuleCall_4_0(), semanticObject.getPlan_term());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     string=STRINGT
	 *
	 * Features:
	 *    string[1, 1]
	 */
	protected void sequence_String(EObject context, jasonide.xtext.asl.asl.String semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, AslPackage.Literals.STRING__STRING) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, AslPackage.Literals.STRING__STRING));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getStringAccess().getStringSTRINGTTerminalRuleCall_0(), semanticObject.getString());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     (list=List | plan_term=Plan_term | log_expr=Log_expr)
	 *
	 * Features:
	 *    list[0, 1]
	 *         EXCLUDE_IF_SET plan_term
	 *         EXCLUDE_IF_SET log_expr
	 *    plan_term[0, 1]
	 *         EXCLUDE_IF_SET list
	 *         EXCLUDE_IF_SET log_expr
	 *    log_expr[0, 1]
	 *         EXCLUDE_IF_SET list
	 *         EXCLUDE_IF_SET plan_term
	 */
	protected void sequence_Term(EObject context, Term semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (list=List | arithm_expr=Arithm_expr | string=String | plan_term=Plan_term)
	 *
	 * Features:
	 *    list[0, 1]
	 *         EXCLUDE_IF_SET arithm_expr
	 *         EXCLUDE_IF_SET string
	 *         EXCLUDE_IF_SET plan_term
	 *    arithm_expr[0, 1]
	 *         EXCLUDE_IF_SET list
	 *         EXCLUDE_IF_SET string
	 *         EXCLUDE_IF_SET plan_term
	 *    string[0, 1]
	 *         EXCLUDE_IF_SET list
	 *         EXCLUDE_IF_SET arithm_expr
	 *         EXCLUDE_IF_SET plan_term
	 *    plan_term[0, 1]
	 *         EXCLUDE_IF_SET list
	 *         EXCLUDE_IF_SET arithm_expr
	 *         EXCLUDE_IF_SET string
	 */
	protected void sequence_Term_in_list(EObject context, Term_in_list semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (term+=Term term+=Term*)
	 *
	 * Features:
	 *    term[1, *]
	 */
	protected void sequence_Terms(EObject context, Terms semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (trigger=TriggerSymbol (literal=Literal | var=Var))
	 *
	 * Features:
	 *    trigger[1, 1]
	 *    literal[0, 1]
	 *         EXCLUDE_IF_SET var
	 *    var[0, 1]
	 *         EXCLUDE_IF_SET literal
	 */
	protected void sequence_Trigger(EObject context, Trigger semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     ((var=VART | unnamedvar=UNNAMEDVART) list=List?)
	 *
	 * Features:
	 *    var[0, 1]
	 *         EXCLUDE_IF_SET unnamedvar
	 *    unnamedvar[0, 1]
	 *         EXCLUDE_IF_SET var
	 *    list[0, 1]
	 */
	protected void sequence_Var(EObject context, Var semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
}
