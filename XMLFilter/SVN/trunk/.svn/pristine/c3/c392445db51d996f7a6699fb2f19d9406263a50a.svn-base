/**
 * <copyright>
 * </copyright>
 *
 */
package jasonide.xtext.mas2j.mas2j.impl;

import jasonide.xtext.mas2j.mas2j.AgentClass;
import jasonide.xtext.mas2j.mas2j.ClsDef;
import jasonide.xtext.mas2j.mas2j.Mas2jPackage;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Agent Class</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link jasonide.xtext.mas2j.mas2j.impl.AgentClassImpl#getAgentClass <em>Agent Class</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class AgentClassImpl extends MinimalEObjectImpl.Container implements AgentClass
{
  /**
   * The cached value of the '{@link #getAgentClass() <em>Agent Class</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getAgentClass()
   * @generated
   * @ordered
   */
  protected ClsDef agentClass;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected AgentClassImpl()
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
    return Mas2jPackage.Literals.AGENT_CLASS;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ClsDef getAgentClass()
  {
    return agentClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetAgentClass(ClsDef newAgentClass, NotificationChain msgs)
  {
    ClsDef oldAgentClass = agentClass;
    agentClass = newAgentClass;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, Mas2jPackage.AGENT_CLASS__AGENT_CLASS, oldAgentClass, newAgentClass);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setAgentClass(ClsDef newAgentClass)
  {
    if (newAgentClass != agentClass)
    {
      NotificationChain msgs = null;
      if (agentClass != null)
        msgs = ((InternalEObject)agentClass).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - Mas2jPackage.AGENT_CLASS__AGENT_CLASS, null, msgs);
      if (newAgentClass != null)
        msgs = ((InternalEObject)newAgentClass).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - Mas2jPackage.AGENT_CLASS__AGENT_CLASS, null, msgs);
      msgs = basicSetAgentClass(newAgentClass, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, Mas2jPackage.AGENT_CLASS__AGENT_CLASS, newAgentClass, newAgentClass));
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
      case Mas2jPackage.AGENT_CLASS__AGENT_CLASS:
        return basicSetAgentClass(null, msgs);
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
      case Mas2jPackage.AGENT_CLASS__AGENT_CLASS:
        return getAgentClass();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
      case Mas2jPackage.AGENT_CLASS__AGENT_CLASS:
        setAgentClass((ClsDef)newValue);
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
      case Mas2jPackage.AGENT_CLASS__AGENT_CLASS:
        setAgentClass((ClsDef)null);
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
      case Mas2jPackage.AGENT_CLASS__AGENT_CLASS:
        return agentClass != null;
    }
    return super.eIsSet(featureID);
  }

} //AgentClassImpl
