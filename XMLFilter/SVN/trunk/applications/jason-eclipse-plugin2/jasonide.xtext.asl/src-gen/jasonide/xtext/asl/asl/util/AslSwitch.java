/**
 * <copyright>
 * </copyright>
 *
 */
package jasonide.xtext.asl.asl.util;

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

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.Switch;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see jasonide.xtext.asl.asl.AslPackage
 * @generated
 */
public class AslSwitch<T> extends Switch<T>
{
  /**
   * The cached model package
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected static AslPackage modelPackage;

  /**
   * Creates an instance of the switch.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public AslSwitch()
  {
    if (modelPackage == null)
    {
      modelPackage = AslPackage.eINSTANCE;
    }
  }

  /**
   * Checks whether this is a switch for the given package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @parameter ePackage the package in question.
   * @return whether this is a switch for the given package.
   * @generated
   */
  @Override
  protected boolean isSwitchFor(EPackage ePackage)
  {
    return ePackage == modelPackage;
  }

  /**
   * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the first non-null result returned by a <code>caseXXX</code> call.
   * @generated
   */
  @Override
  protected T doSwitch(int classifierID, EObject theEObject)
  {
    switch (classifierID)
    {
      case AslPackage.AGENT:
      {
        Agent agent = (Agent)theEObject;
        T result = caseAgent(agent);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AslPackage.DIRECTIVE:
      {
        Directive directive = (Directive)theEObject;
        T result = caseDirective(directive);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AslPackage.BELIEF:
      {
        Belief belief = (Belief)theEObject;
        T result = caseBelief(belief);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AslPackage.INITIAL_GOAL:
      {
        Initial_goal initial_goal = (Initial_goal)theEObject;
        T result = caseInitial_goal(initial_goal);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AslPackage.PLAN:
      {
        Plan plan = (Plan)theEObject;
        T result = casePlan(plan);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AslPackage.TRIGGER:
      {
        Trigger trigger = (Trigger)theEObject;
        T result = caseTrigger(trigger);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AslPackage.PLAN_BODY:
      {
        Plan_body plan_body = (Plan_body)theEObject;
        T result = casePlan_body(plan_body);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AslPackage.STMT_IF:
      {
        StmtIF stmtIF = (StmtIF)theEObject;
        T result = caseStmtIF(stmtIF);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AslPackage.STMT_FOR:
      {
        StmtFOR stmtFOR = (StmtFOR)theEObject;
        T result = caseStmtFOR(stmtFOR);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AslPackage.STMT_WHILE:
      {
        StmtWHILE stmtWHILE = (StmtWHILE)theEObject;
        T result = caseStmtWHILE(stmtWHILE);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AslPackage.BODY_FORMULA:
      {
        Body_formula body_formula = (Body_formula)theEObject;
        T result = caseBody_formula(body_formula);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AslPackage.PLAN_TERM:
      {
        Plan_term plan_term = (Plan_term)theEObject;
        T result = casePlan_term(plan_term);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AslPackage.LITERAL:
      {
        Literal literal = (Literal)theEObject;
        T result = caseLiteral(literal);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AslPackage.PRED:
      {
        Pred pred = (Pred)theEObject;
        T result = casePred(pred);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AslPackage.TERMS:
      {
        Terms terms = (Terms)theEObject;
        T result = caseTerms(terms);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AslPackage.TERM:
      {
        Term term = (Term)theEObject;
        T result = caseTerm(term);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AslPackage.LIST:
      {
        List list = (List)theEObject;
        T result = caseList(list);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AslPackage.TERM_IN_LIST:
      {
        Term_in_list term_in_list = (Term_in_list)theEObject;
        T result = caseTerm_in_list(term_in_list);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AslPackage.LOG_EXPR:
      {
        Log_expr log_expr = (Log_expr)theEObject;
        T result = caseLog_expr(log_expr);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AslPackage.LOG_EXPR_TRM:
      {
        Log_expr_trm log_expr_trm = (Log_expr_trm)theEObject;
        T result = caseLog_expr_trm(log_expr_trm);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AslPackage.LOG_EXPR_FACTOR:
      {
        Log_expr_factor log_expr_factor = (Log_expr_factor)theEObject;
        T result = caseLog_expr_factor(log_expr_factor);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AslPackage.REL_EXPR:
      {
        Rel_expr rel_expr = (Rel_expr)theEObject;
        T result = caseRel_expr(rel_expr);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AslPackage.ARITHM_EXPR:
      {
        Arithm_expr arithm_expr = (Arithm_expr)theEObject;
        T result = caseArithm_expr(arithm_expr);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AslPackage.ARITHM_EXPR_TRM:
      {
        Arithm_expr_trm arithm_expr_trm = (Arithm_expr_trm)theEObject;
        T result = caseArithm_expr_trm(arithm_expr_trm);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AslPackage.ARITHM_EXPR_FACTOR:
      {
        Arithm_expr_factor arithm_expr_factor = (Arithm_expr_factor)theEObject;
        T result = caseArithm_expr_factor(arithm_expr_factor);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AslPackage.ARITHM_EXPR_SIMPLE:
      {
        Arithm_expr_simple arithm_expr_simple = (Arithm_expr_simple)theEObject;
        T result = caseArithm_expr_simple(arithm_expr_simple);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AslPackage.FUNCTION:
      {
        Function function = (Function)theEObject;
        T result = caseFunction(function);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AslPackage.VAR:
      {
        Var var = (Var)theEObject;
        T result = caseVar(var);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AslPackage.STRING:
      {
        jasonide.xtext.asl.asl.String string = (jasonide.xtext.asl.asl.String)theEObject;
        T result = caseString(string);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AslPackage.NUMBER:
      {
        jasonide.xtext.asl.asl.Number number = (jasonide.xtext.asl.asl.Number)theEObject;
        T result = caseNumber(number);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      default: return defaultCase(theEObject);
    }
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Agent</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Agent</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseAgent(Agent object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Directive</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Directive</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseDirective(Directive object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Belief</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Belief</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseBelief(Belief object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Initial goal</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Initial goal</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseInitial_goal(Initial_goal object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Plan</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Plan</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T casePlan(Plan object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Trigger</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Trigger</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseTrigger(Trigger object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Plan body</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Plan body</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T casePlan_body(Plan_body object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Stmt IF</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Stmt IF</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseStmtIF(StmtIF object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Stmt FOR</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Stmt FOR</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseStmtFOR(StmtFOR object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Stmt WHILE</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Stmt WHILE</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseStmtWHILE(StmtWHILE object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Body formula</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Body formula</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseBody_formula(Body_formula object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Plan term</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Plan term</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T casePlan_term(Plan_term object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Literal</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Literal</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseLiteral(Literal object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Pred</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Pred</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T casePred(Pred object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Terms</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Terms</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseTerms(Terms object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Term</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Term</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseTerm(Term object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>List</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>List</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseList(List object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Term in list</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Term in list</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseTerm_in_list(Term_in_list object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Log expr</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Log expr</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseLog_expr(Log_expr object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Log expr trm</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Log expr trm</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseLog_expr_trm(Log_expr_trm object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Log expr factor</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Log expr factor</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseLog_expr_factor(Log_expr_factor object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Rel expr</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Rel expr</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseRel_expr(Rel_expr object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Arithm expr</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Arithm expr</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseArithm_expr(Arithm_expr object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Arithm expr trm</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Arithm expr trm</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseArithm_expr_trm(Arithm_expr_trm object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Arithm expr factor</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Arithm expr factor</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseArithm_expr_factor(Arithm_expr_factor object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Arithm expr simple</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Arithm expr simple</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseArithm_expr_simple(Arithm_expr_simple object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Function</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Function</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseFunction(Function object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Var</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Var</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseVar(Var object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>String</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>String</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseString(jasonide.xtext.asl.asl.String object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Number</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Number</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseNumber(jasonide.xtext.asl.asl.Number object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch, but this is the last case anyway.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject)
   * @generated
   */
  @Override
  public T defaultCase(EObject object)
  {
    return null;
  }

} //AslSwitch
