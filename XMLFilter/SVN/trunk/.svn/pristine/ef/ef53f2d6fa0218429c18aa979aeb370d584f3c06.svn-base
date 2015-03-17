/**
 * <copyright>
 * </copyright>
 *
 */
package jasonide.xtext.mas2j.mas2j.impl;

import jasonide.xtext.mas2j.mas2j.ClsDef;
import jasonide.xtext.mas2j.mas2j.Infrastructure;
import jasonide.xtext.mas2j.mas2j.Mas2jPackage;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Infrastructure</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link jasonide.xtext.mas2j.mas2j.impl.InfrastructureImpl#getInfrastructure <em>Infrastructure</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class InfrastructureImpl extends MinimalEObjectImpl.Container implements Infrastructure
{
  /**
   * The cached value of the '{@link #getInfrastructure() <em>Infrastructure</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getInfrastructure()
   * @generated
   * @ordered
   */
  protected ClsDef infrastructure;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected InfrastructureImpl()
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
    return Mas2jPackage.Literals.INFRASTRUCTURE;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ClsDef getInfrastructure()
  {
    return infrastructure;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetInfrastructure(ClsDef newInfrastructure, NotificationChain msgs)
  {
    ClsDef oldInfrastructure = infrastructure;
    infrastructure = newInfrastructure;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, Mas2jPackage.INFRASTRUCTURE__INFRASTRUCTURE, oldInfrastructure, newInfrastructure);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setInfrastructure(ClsDef newInfrastructure)
  {
    if (newInfrastructure != infrastructure)
    {
      NotificationChain msgs = null;
      if (infrastructure != null)
        msgs = ((InternalEObject)infrastructure).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - Mas2jPackage.INFRASTRUCTURE__INFRASTRUCTURE, null, msgs);
      if (newInfrastructure != null)
        msgs = ((InternalEObject)newInfrastructure).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - Mas2jPackage.INFRASTRUCTURE__INFRASTRUCTURE, null, msgs);
      msgs = basicSetInfrastructure(newInfrastructure, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, Mas2jPackage.INFRASTRUCTURE__INFRASTRUCTURE, newInfrastructure, newInfrastructure));
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
      case Mas2jPackage.INFRASTRUCTURE__INFRASTRUCTURE:
        return basicSetInfrastructure(null, msgs);
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
      case Mas2jPackage.INFRASTRUCTURE__INFRASTRUCTURE:
        return getInfrastructure();
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
      case Mas2jPackage.INFRASTRUCTURE__INFRASTRUCTURE:
        setInfrastructure((ClsDef)newValue);
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
      case Mas2jPackage.INFRASTRUCTURE__INFRASTRUCTURE:
        setInfrastructure((ClsDef)null);
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
      case Mas2jPackage.INFRASTRUCTURE__INFRASTRUCTURE:
        return infrastructure != null;
    }
    return super.eIsSet(featureID);
  }

} //InfrastructureImpl
