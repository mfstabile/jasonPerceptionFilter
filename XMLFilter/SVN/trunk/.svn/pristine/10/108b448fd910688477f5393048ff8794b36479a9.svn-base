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

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see jasonide.xtext.asl.asl.AslPackage
 * @generated
 */
public class AslAdapterFactory extends AdapterFactoryImpl
{
  /**
   * The cached model package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected static AslPackage modelPackage;

  /**
   * Creates an instance of the adapter factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public AslAdapterFactory()
  {
    if (modelPackage == null)
    {
      modelPackage = AslPackage.eINSTANCE;
    }
  }

  /**
   * Returns whether this factory is applicable for the type of the object.
   * <!-- begin-user-doc -->
   * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
   * <!-- end-user-doc -->
   * @return whether this factory is applicable for the type of the object.
   * @generated
   */
  @Override
  public boolean isFactoryForType(Object object)
  {
    if (object == modelPackage)
    {
      return true;
    }
    if (object instanceof EObject)
    {
      return ((EObject)object).eClass().getEPackage() == modelPackage;
    }
    return false;
  }

  /**
   * The switch that delegates to the <code>createXXX</code> methods.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected AslSwitch<Adapter> modelSwitch =
    new AslSwitch<Adapter>()
    {
      @Override
      public Adapter caseAgent(Agent object)
      {
        return createAgentAdapter();
      }
      @Override
      public Adapter caseDirective(Directive object)
      {
        return createDirectiveAdapter();
      }
      @Override
      public Adapter caseBelief(Belief object)
      {
        return createBeliefAdapter();
      }
      @Override
      public Adapter caseInitial_goal(Initial_goal object)
      {
        return createInitial_goalAdapter();
      }
      @Override
      public Adapter casePlan(Plan object)
      {
        return createPlanAdapter();
      }
      @Override
      public Adapter caseTrigger(Trigger object)
      {
        return createTriggerAdapter();
      }
      @Override
      public Adapter casePlan_body(Plan_body object)
      {
        return createPlan_bodyAdapter();
      }
      @Override
      public Adapter caseStmtIF(StmtIF object)
      {
        return createStmtIFAdapter();
      }
      @Override
      public Adapter caseStmtFOR(StmtFOR object)
      {
        return createStmtFORAdapter();
      }
      @Override
      public Adapter caseStmtWHILE(StmtWHILE object)
      {
        return createStmtWHILEAdapter();
      }
      @Override
      public Adapter caseBody_formula(Body_formula object)
      {
        return createBody_formulaAdapter();
      }
      @Override
      public Adapter casePlan_term(Plan_term object)
      {
        return createPlan_termAdapter();
      }
      @Override
      public Adapter caseLiteral(Literal object)
      {
        return createLiteralAdapter();
      }
      @Override
      public Adapter casePred(Pred object)
      {
        return createPredAdapter();
      }
      @Override
      public Adapter caseTerms(Terms object)
      {
        return createTermsAdapter();
      }
      @Override
      public Adapter caseTerm(Term object)
      {
        return createTermAdapter();
      }
      @Override
      public Adapter caseList(List object)
      {
        return createListAdapter();
      }
      @Override
      public Adapter caseTerm_in_list(Term_in_list object)
      {
        return createTerm_in_listAdapter();
      }
      @Override
      public Adapter caseLog_expr(Log_expr object)
      {
        return createLog_exprAdapter();
      }
      @Override
      public Adapter caseLog_expr_trm(Log_expr_trm object)
      {
        return createLog_expr_trmAdapter();
      }
      @Override
      public Adapter caseLog_expr_factor(Log_expr_factor object)
      {
        return createLog_expr_factorAdapter();
      }
      @Override
      public Adapter caseRel_expr(Rel_expr object)
      {
        return createRel_exprAdapter();
      }
      @Override
      public Adapter caseArithm_expr(Arithm_expr object)
      {
        return createArithm_exprAdapter();
      }
      @Override
      public Adapter caseArithm_expr_trm(Arithm_expr_trm object)
      {
        return createArithm_expr_trmAdapter();
      }
      @Override
      public Adapter caseArithm_expr_factor(Arithm_expr_factor object)
      {
        return createArithm_expr_factorAdapter();
      }
      @Override
      public Adapter caseArithm_expr_simple(Arithm_expr_simple object)
      {
        return createArithm_expr_simpleAdapter();
      }
      @Override
      public Adapter caseFunction(Function object)
      {
        return createFunctionAdapter();
      }
      @Override
      public Adapter caseVar(Var object)
      {
        return createVarAdapter();
      }
      @Override
      public Adapter caseString(jasonide.xtext.asl.asl.String object)
      {
        return createStringAdapter();
      }
      @Override
      public Adapter caseNumber(jasonide.xtext.asl.asl.Number object)
      {
        return createNumberAdapter();
      }
      @Override
      public Adapter defaultCase(EObject object)
      {
        return createEObjectAdapter();
      }
    };

  /**
   * Creates an adapter for the <code>target</code>.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param target the object to adapt.
   * @return the adapter for the <code>target</code>.
   * @generated
   */
  @Override
  public Adapter createAdapter(Notifier target)
  {
    return modelSwitch.doSwitch((EObject)target);
  }


  /**
   * Creates a new adapter for an object of class '{@link jasonide.xtext.asl.asl.Agent <em>Agent</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see jasonide.xtext.asl.asl.Agent
   * @generated
   */
  public Adapter createAgentAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link jasonide.xtext.asl.asl.Directive <em>Directive</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see jasonide.xtext.asl.asl.Directive
   * @generated
   */
  public Adapter createDirectiveAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link jasonide.xtext.asl.asl.Belief <em>Belief</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see jasonide.xtext.asl.asl.Belief
   * @generated
   */
  public Adapter createBeliefAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link jasonide.xtext.asl.asl.Initial_goal <em>Initial goal</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see jasonide.xtext.asl.asl.Initial_goal
   * @generated
   */
  public Adapter createInitial_goalAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link jasonide.xtext.asl.asl.Plan <em>Plan</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see jasonide.xtext.asl.asl.Plan
   * @generated
   */
  public Adapter createPlanAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link jasonide.xtext.asl.asl.Trigger <em>Trigger</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see jasonide.xtext.asl.asl.Trigger
   * @generated
   */
  public Adapter createTriggerAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link jasonide.xtext.asl.asl.Plan_body <em>Plan body</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see jasonide.xtext.asl.asl.Plan_body
   * @generated
   */
  public Adapter createPlan_bodyAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link jasonide.xtext.asl.asl.StmtIF <em>Stmt IF</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see jasonide.xtext.asl.asl.StmtIF
   * @generated
   */
  public Adapter createStmtIFAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link jasonide.xtext.asl.asl.StmtFOR <em>Stmt FOR</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see jasonide.xtext.asl.asl.StmtFOR
   * @generated
   */
  public Adapter createStmtFORAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link jasonide.xtext.asl.asl.StmtWHILE <em>Stmt WHILE</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see jasonide.xtext.asl.asl.StmtWHILE
   * @generated
   */
  public Adapter createStmtWHILEAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link jasonide.xtext.asl.asl.Body_formula <em>Body formula</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see jasonide.xtext.asl.asl.Body_formula
   * @generated
   */
  public Adapter createBody_formulaAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link jasonide.xtext.asl.asl.Plan_term <em>Plan term</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see jasonide.xtext.asl.asl.Plan_term
   * @generated
   */
  public Adapter createPlan_termAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link jasonide.xtext.asl.asl.Literal <em>Literal</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see jasonide.xtext.asl.asl.Literal
   * @generated
   */
  public Adapter createLiteralAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link jasonide.xtext.asl.asl.Pred <em>Pred</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see jasonide.xtext.asl.asl.Pred
   * @generated
   */
  public Adapter createPredAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link jasonide.xtext.asl.asl.Terms <em>Terms</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see jasonide.xtext.asl.asl.Terms
   * @generated
   */
  public Adapter createTermsAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link jasonide.xtext.asl.asl.Term <em>Term</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see jasonide.xtext.asl.asl.Term
   * @generated
   */
  public Adapter createTermAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link jasonide.xtext.asl.asl.List <em>List</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see jasonide.xtext.asl.asl.List
   * @generated
   */
  public Adapter createListAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link jasonide.xtext.asl.asl.Term_in_list <em>Term in list</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see jasonide.xtext.asl.asl.Term_in_list
   * @generated
   */
  public Adapter createTerm_in_listAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link jasonide.xtext.asl.asl.Log_expr <em>Log expr</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see jasonide.xtext.asl.asl.Log_expr
   * @generated
   */
  public Adapter createLog_exprAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link jasonide.xtext.asl.asl.Log_expr_trm <em>Log expr trm</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see jasonide.xtext.asl.asl.Log_expr_trm
   * @generated
   */
  public Adapter createLog_expr_trmAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link jasonide.xtext.asl.asl.Log_expr_factor <em>Log expr factor</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see jasonide.xtext.asl.asl.Log_expr_factor
   * @generated
   */
  public Adapter createLog_expr_factorAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link jasonide.xtext.asl.asl.Rel_expr <em>Rel expr</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see jasonide.xtext.asl.asl.Rel_expr
   * @generated
   */
  public Adapter createRel_exprAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link jasonide.xtext.asl.asl.Arithm_expr <em>Arithm expr</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see jasonide.xtext.asl.asl.Arithm_expr
   * @generated
   */
  public Adapter createArithm_exprAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link jasonide.xtext.asl.asl.Arithm_expr_trm <em>Arithm expr trm</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see jasonide.xtext.asl.asl.Arithm_expr_trm
   * @generated
   */
  public Adapter createArithm_expr_trmAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link jasonide.xtext.asl.asl.Arithm_expr_factor <em>Arithm expr factor</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see jasonide.xtext.asl.asl.Arithm_expr_factor
   * @generated
   */
  public Adapter createArithm_expr_factorAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link jasonide.xtext.asl.asl.Arithm_expr_simple <em>Arithm expr simple</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see jasonide.xtext.asl.asl.Arithm_expr_simple
   * @generated
   */
  public Adapter createArithm_expr_simpleAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link jasonide.xtext.asl.asl.Function <em>Function</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see jasonide.xtext.asl.asl.Function
   * @generated
   */
  public Adapter createFunctionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link jasonide.xtext.asl.asl.Var <em>Var</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see jasonide.xtext.asl.asl.Var
   * @generated
   */
  public Adapter createVarAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link jasonide.xtext.asl.asl.String <em>String</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see jasonide.xtext.asl.asl.String
   * @generated
   */
  public Adapter createStringAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link jasonide.xtext.asl.asl.Number <em>Number</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see jasonide.xtext.asl.asl.Number
   * @generated
   */
  public Adapter createNumberAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for the default case.
   * <!-- begin-user-doc -->
   * This default implementation returns null.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @generated
   */
  public Adapter createEObjectAdapter()
  {
    return null;
  }

} //AslAdapterFactory
