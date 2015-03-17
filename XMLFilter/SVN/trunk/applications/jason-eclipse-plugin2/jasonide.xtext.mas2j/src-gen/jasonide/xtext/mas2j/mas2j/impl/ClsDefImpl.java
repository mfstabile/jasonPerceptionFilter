/**
 * <copyright>
 * </copyright>
 *
 */
package jasonide.xtext.mas2j.mas2j.impl;

import jasonide.xtext.mas2j.mas2j.ClsDef;
import jasonide.xtext.mas2j.mas2j.Mas2jPackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Cls Def</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link jasonide.xtext.mas2j.mas2j.impl.ClsDefImpl#getInfrastructure <em>Infrastructure</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ClsDefImpl extends ParameterClsDefImpl implements ClsDef
{
  /**
   * The default value of the '{@link #getInfrastructure() <em>Infrastructure</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getInfrastructure()
   * @generated
   * @ordered
   */
  protected static final String INFRASTRUCTURE_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getInfrastructure() <em>Infrastructure</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getInfrastructure()
   * @generated
   * @ordered
   */
  protected String infrastructure = INFRASTRUCTURE_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ClsDefImpl()
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
    return Mas2jPackage.Literals.CLS_DEF;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getInfrastructure()
  {
    return infrastructure;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setInfrastructure(String newInfrastructure)
  {
    String oldInfrastructure = infrastructure;
    infrastructure = newInfrastructure;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, Mas2jPackage.CLS_DEF__INFRASTRUCTURE, oldInfrastructure, infrastructure));
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
      case Mas2jPackage.CLS_DEF__INFRASTRUCTURE:
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
      case Mas2jPackage.CLS_DEF__INFRASTRUCTURE:
        setInfrastructure((String)newValue);
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
      case Mas2jPackage.CLS_DEF__INFRASTRUCTURE:
        setInfrastructure(INFRASTRUCTURE_EDEFAULT);
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
      case Mas2jPackage.CLS_DEF__INFRASTRUCTURE:
        return INFRASTRUCTURE_EDEFAULT == null ? infrastructure != null : !INFRASTRUCTURE_EDEFAULT.equals(infrastructure);
    }
    return super.eIsSet(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String toString()
  {
    if (eIsProxy()) return super.toString();

    StringBuffer result = new StringBuffer(super.toString());
    result.append(" (infrastructure: ");
    result.append(infrastructure);
    result.append(')');
    return result.toString();
  }

} //ClsDefImpl
