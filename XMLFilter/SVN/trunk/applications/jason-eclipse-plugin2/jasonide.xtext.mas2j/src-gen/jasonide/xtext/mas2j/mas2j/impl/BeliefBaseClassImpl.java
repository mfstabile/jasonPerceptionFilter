/**
 * <copyright>
 * </copyright>
 *
 */
package jasonide.xtext.mas2j.mas2j.impl;

import jasonide.xtext.mas2j.mas2j.BeliefBaseClass;
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
 * An implementation of the model object '<em><b>Belief Base Class</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link jasonide.xtext.mas2j.mas2j.impl.BeliefBaseClassImpl#getBeliefBaseClass <em>Belief Base Class</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class BeliefBaseClassImpl extends MinimalEObjectImpl.Container implements BeliefBaseClass
{
  /**
   * The cached value of the '{@link #getBeliefBaseClass() <em>Belief Base Class</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getBeliefBaseClass()
   * @generated
   * @ordered
   */
  protected ClsDef beliefBaseClass;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected BeliefBaseClassImpl()
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
    return Mas2jPackage.Literals.BELIEF_BASE_CLASS;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ClsDef getBeliefBaseClass()
  {
    return beliefBaseClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetBeliefBaseClass(ClsDef newBeliefBaseClass, NotificationChain msgs)
  {
    ClsDef oldBeliefBaseClass = beliefBaseClass;
    beliefBaseClass = newBeliefBaseClass;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, Mas2jPackage.BELIEF_BASE_CLASS__BELIEF_BASE_CLASS, oldBeliefBaseClass, newBeliefBaseClass);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setBeliefBaseClass(ClsDef newBeliefBaseClass)
  {
    if (newBeliefBaseClass != beliefBaseClass)
    {
      NotificationChain msgs = null;
      if (beliefBaseClass != null)
        msgs = ((InternalEObject)beliefBaseClass).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - Mas2jPackage.BELIEF_BASE_CLASS__BELIEF_BASE_CLASS, null, msgs);
      if (newBeliefBaseClass != null)
        msgs = ((InternalEObject)newBeliefBaseClass).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - Mas2jPackage.BELIEF_BASE_CLASS__BELIEF_BASE_CLASS, null, msgs);
      msgs = basicSetBeliefBaseClass(newBeliefBaseClass, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, Mas2jPackage.BELIEF_BASE_CLASS__BELIEF_BASE_CLASS, newBeliefBaseClass, newBeliefBaseClass));
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
      case Mas2jPackage.BELIEF_BASE_CLASS__BELIEF_BASE_CLASS:
        return basicSetBeliefBaseClass(null, msgs);
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
      case Mas2jPackage.BELIEF_BASE_CLASS__BELIEF_BASE_CLASS:
        return getBeliefBaseClass();
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
      case Mas2jPackage.BELIEF_BASE_CLASS__BELIEF_BASE_CLASS:
        setBeliefBaseClass((ClsDef)newValue);
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
      case Mas2jPackage.BELIEF_BASE_CLASS__BELIEF_BASE_CLASS:
        setBeliefBaseClass((ClsDef)null);
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
      case Mas2jPackage.BELIEF_BASE_CLASS__BELIEF_BASE_CLASS:
        return beliefBaseClass != null;
    }
    return super.eIsSet(featureID);
  }

} //BeliefBaseClassImpl
