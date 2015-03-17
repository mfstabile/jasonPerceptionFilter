/**
 * <copyright>
 * </copyright>
 *
 */
package jasonide.xtext.asl.asl.impl;

import jasonide.xtext.asl.asl.Agent;
import jasonide.xtext.asl.asl.Arithm_expr;
import jasonide.xtext.asl.asl.Arithm_expr_factor;
import jasonide.xtext.asl.asl.Arithm_expr_simple;
import jasonide.xtext.asl.asl.Arithm_expr_trm;
import jasonide.xtext.asl.asl.AslFactory;
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

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class AslFactoryImpl extends EFactoryImpl implements AslFactory
{
  /**
   * Creates the default factory implementation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static AslFactory init()
  {
    try
    {
      AslFactory theAslFactory = (AslFactory)EPackage.Registry.INSTANCE.getEFactory("http://www.xtext.jasonide/asl/Asl"); 
      if (theAslFactory != null)
      {
        return theAslFactory;
      }
    }
    catch (Exception exception)
    {
      EcorePlugin.INSTANCE.log(exception);
    }
    return new AslFactoryImpl();
  }

  /**
   * Creates an instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public AslFactoryImpl()
  {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EObject create(EClass eClass)
  {
    switch (eClass.getClassifierID())
    {
      case AslPackage.AGENT: return createAgent();
      case AslPackage.DIRECTIVE: return createDirective();
      case AslPackage.BELIEF: return createBelief();
      case AslPackage.INITIAL_GOAL: return createInitial_goal();
      case AslPackage.PLAN: return createPlan();
      case AslPackage.TRIGGER: return createTrigger();
      case AslPackage.PLAN_BODY: return createPlan_body();
      case AslPackage.STMT_IF: return createStmtIF();
      case AslPackage.STMT_FOR: return createStmtFOR();
      case AslPackage.STMT_WHILE: return createStmtWHILE();
      case AslPackage.BODY_FORMULA: return createBody_formula();
      case AslPackage.PLAN_TERM: return createPlan_term();
      case AslPackage.LITERAL: return createLiteral();
      case AslPackage.PRED: return createPred();
      case AslPackage.TERMS: return createTerms();
      case AslPackage.TERM: return createTerm();
      case AslPackage.LIST: return createList();
      case AslPackage.TERM_IN_LIST: return createTerm_in_list();
      case AslPackage.LOG_EXPR: return createLog_expr();
      case AslPackage.LOG_EXPR_TRM: return createLog_expr_trm();
      case AslPackage.LOG_EXPR_FACTOR: return createLog_expr_factor();
      case AslPackage.REL_EXPR: return createRel_expr();
      case AslPackage.ARITHM_EXPR: return createArithm_expr();
      case AslPackage.ARITHM_EXPR_TRM: return createArithm_expr_trm();
      case AslPackage.ARITHM_EXPR_FACTOR: return createArithm_expr_factor();
      case AslPackage.ARITHM_EXPR_SIMPLE: return createArithm_expr_simple();
      case AslPackage.FUNCTION: return createFunction();
      case AslPackage.VAR: return createVar();
      case AslPackage.STRING: return createString();
      case AslPackage.NUMBER: return createNumber();
      default:
        throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Agent createAgent()
  {
    AgentImpl agent = new AgentImpl();
    return agent;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Directive createDirective()
  {
    DirectiveImpl directive = new DirectiveImpl();
    return directive;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Belief createBelief()
  {
    BeliefImpl belief = new BeliefImpl();
    return belief;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Initial_goal createInitial_goal()
  {
    Initial_goalImpl initial_goal = new Initial_goalImpl();
    return initial_goal;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Plan createPlan()
  {
    PlanImpl plan = new PlanImpl();
    return plan;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Trigger createTrigger()
  {
    TriggerImpl trigger = new TriggerImpl();
    return trigger;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Plan_body createPlan_body()
  {
    Plan_bodyImpl plan_body = new Plan_bodyImpl();
    return plan_body;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public StmtIF createStmtIF()
  {
    StmtIFImpl stmtIF = new StmtIFImpl();
    return stmtIF;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public StmtFOR createStmtFOR()
  {
    StmtFORImpl stmtFOR = new StmtFORImpl();
    return stmtFOR;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public StmtWHILE createStmtWHILE()
  {
    StmtWHILEImpl stmtWHILE = new StmtWHILEImpl();
    return stmtWHILE;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Body_formula createBody_formula()
  {
    Body_formulaImpl body_formula = new Body_formulaImpl();
    return body_formula;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Plan_term createPlan_term()
  {
    Plan_termImpl plan_term = new Plan_termImpl();
    return plan_term;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Literal createLiteral()
  {
    LiteralImpl literal = new LiteralImpl();
    return literal;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Pred createPred()
  {
    PredImpl pred = new PredImpl();
    return pred;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Terms createTerms()
  {
    TermsImpl terms = new TermsImpl();
    return terms;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Term createTerm()
  {
    TermImpl term = new TermImpl();
    return term;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public List createList()
  {
    ListImpl list = new ListImpl();
    return list;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Term_in_list createTerm_in_list()
  {
    Term_in_listImpl term_in_list = new Term_in_listImpl();
    return term_in_list;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Log_expr createLog_expr()
  {
    Log_exprImpl log_expr = new Log_exprImpl();
    return log_expr;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Log_expr_trm createLog_expr_trm()
  {
    Log_expr_trmImpl log_expr_trm = new Log_expr_trmImpl();
    return log_expr_trm;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Log_expr_factor createLog_expr_factor()
  {
    Log_expr_factorImpl log_expr_factor = new Log_expr_factorImpl();
    return log_expr_factor;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Rel_expr createRel_expr()
  {
    Rel_exprImpl rel_expr = new Rel_exprImpl();
    return rel_expr;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Arithm_expr createArithm_expr()
  {
    Arithm_exprImpl arithm_expr = new Arithm_exprImpl();
    return arithm_expr;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Arithm_expr_trm createArithm_expr_trm()
  {
    Arithm_expr_trmImpl arithm_expr_trm = new Arithm_expr_trmImpl();
    return arithm_expr_trm;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Arithm_expr_factor createArithm_expr_factor()
  {
    Arithm_expr_factorImpl arithm_expr_factor = new Arithm_expr_factorImpl();
    return arithm_expr_factor;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Arithm_expr_simple createArithm_expr_simple()
  {
    Arithm_expr_simpleImpl arithm_expr_simple = new Arithm_expr_simpleImpl();
    return arithm_expr_simple;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Function createFunction()
  {
    FunctionImpl function = new FunctionImpl();
    return function;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Var createVar()
  {
    VarImpl var = new VarImpl();
    return var;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public jasonide.xtext.asl.asl.String createString()
  {
    StringImpl string = new StringImpl();
    return string;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public jasonide.xtext.asl.asl.Number createNumber()
  {
    NumberImpl number = new NumberImpl();
    return number;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public AslPackage getAslPackage()
  {
    return (AslPackage)getEPackage();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @deprecated
   * @generated
   */
  @Deprecated
  public static AslPackage getPackage()
  {
    return AslPackage.eINSTANCE;
  }

} //AslFactoryImpl
