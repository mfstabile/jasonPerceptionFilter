/**
 * <copyright>
 * </copyright>
 *
 */
package jasonide.xtext.asl.asl.impl;

import jasonide.xtext.asl.asl.Agent;
import jasonide.xtext.asl.asl.AslPackage;
import jasonide.xtext.asl.asl.Belief;
import jasonide.xtext.asl.asl.Directive;
import jasonide.xtext.asl.asl.Initial_goal;
import jasonide.xtext.asl.asl.Plan;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Agent</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link jasonide.xtext.asl.asl.impl.AgentImpl#getDirective <em>Directive</em>}</li>
 *   <li>{@link jasonide.xtext.asl.asl.impl.AgentImpl#getBelief <em>Belief</em>}</li>
 *   <li>{@link jasonide.xtext.asl.asl.impl.AgentImpl#getInitial_goal <em>Initial goal</em>}</li>
 *   <li>{@link jasonide.xtext.asl.asl.impl.AgentImpl#getPlan <em>Plan</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class AgentImpl extends MinimalEObjectImpl.Container implements Agent
{
  /**
   * The cached value of the '{@link #getDirective() <em>Directive</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDirective()
   * @generated
   * @ordered
   */
  protected EList<Directive> directive;

  /**
   * The cached value of the '{@link #getBelief() <em>Belief</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getBelief()
   * @generated
   * @ordered
   */
  protected EList<Belief> belief;

  /**
   * The cached value of the '{@link #getInitial_goal() <em>Initial goal</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getInitial_goal()
   * @generated
   * @ordered
   */
  protected EList<Initial_goal> initial_goal;

  /**
   * The cached value of the '{@link #getPlan() <em>Plan</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getPlan()
   * @generated
   * @ordered
   */
  protected EList<Plan> plan;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected AgentImpl()
  {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass()
  {
    return AslPackage.Literals.AGENT;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<Directive> getDirective()
  {
    if (directive == null)
    {
      directive = new EObjectContainmentEList<Directive>(Directive.class, this, AslPackage.AGENT__DIRECTIVE);
    }
    return directive;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<Belief> getBelief()
  {
    if (belief == null)
    {
      belief = new EObjectContainmentEList<Belief>(Belief.class, this, AslPackage.AGENT__BELIEF);
    }
    return belief;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<Initial_goal> getInitial_goal()
  {
    if (initial_goal == null)
    {
      initial_goal = new EObjectContainmentEList<Initial_goal>(Initial_goal.class, this, AslPackage.AGENT__INITIAL_GOAL);
    }
    return initial_goal;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<Plan> getPlan()
  {
    if (plan == null)
    {
      plan = new EObjectContainmentEList<Plan>(Plan.class, this, AslPackage.AGENT__PLAN);
    }
    return plan;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs)
  {
    switch (featureID)
    {
      case AslPackage.AGENT__DIRECTIVE:
        return ((InternalEList<?>)getDirective()).basicRemove(otherEnd, msgs);
      case AslPackage.AGENT__BELIEF:
        return ((InternalEList<?>)getBelief()).basicRemove(otherEnd, msgs);
      case AslPackage.AGENT__INITIAL_GOAL:
        return ((InternalEList<?>)getInitial_goal()).basicRemove(otherEnd, msgs);
      case AslPackage.AGENT__PLAN:
        return ((InternalEList<?>)getPlan()).basicRemove(otherEnd, msgs);
    }
    return super.eInverseRemove(otherEnd, featureID, msgs);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType)
  {
    switch (featureID)
    {
      case AslPackage.AGENT__DIRECTIVE:
        return getDirective();
      case AslPackage.AGENT__BELIEF:
        return getBelief();
      case AslPackage.AGENT__INITIAL_GOAL:
        return getInitial_goal();
      case AslPackage.AGENT__PLAN:
        return getPlan();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @SuppressWarnings("unchecked")
  @Override
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
      case AslPackage.AGENT__DIRECTIVE:
        getDirective().clear();
        getDirective().addAll((Collection<? extends Directive>)newValue);
        return;
      case AslPackage.AGENT__BELIEF:
        getBelief().clear();
        getBelief().addAll((Collection<? extends Belief>)newValue);
        return;
      case AslPackage.AGENT__INITIAL_GOAL:
        getInitial_goal().clear();
        getInitial_goal().addAll((Collection<? extends Initial_goal>)newValue);
        return;
      case AslPackage.AGENT__PLAN:
        getPlan().clear();
        getPlan().addAll((Collection<? extends Plan>)newValue);
        return;
    }
    super.eSet(featureID, newValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eUnset(int featureID)
  {
    switch (featureID)
    {
      case AslPackage.AGENT__DIRECTIVE:
        getDirective().clear();
        return;
      case AslPackage.AGENT__BELIEF:
        getBelief().clear();
        return;
      case AslPackage.AGENT__INITIAL_GOAL:
        getInitial_goal().clear();
        return;
      case AslPackage.AGENT__PLAN:
        getPlan().clear();
        return;
    }
    super.eUnset(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public boolean eIsSet(int featureID)
  {
    switch (featureID)
    {
      case AslPackage.AGENT__DIRECTIVE:
        return directive != null && !directive.isEmpty();
      case AslPackage.AGENT__BELIEF:
        return belief != null && !belief.isEmpty();
      case AslPackage.AGENT__INITIAL_GOAL:
        return initial_goal != null && !initial_goal.isEmpty();
      case AslPackage.AGENT__PLAN:
        return plan != null && !plan.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //AgentImpl
