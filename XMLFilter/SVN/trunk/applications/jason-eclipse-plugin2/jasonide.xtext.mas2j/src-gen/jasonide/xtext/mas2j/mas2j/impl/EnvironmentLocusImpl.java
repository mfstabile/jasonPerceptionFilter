/**
 * <copyright>
 * </copyright>
 *
 */
package jasonide.xtext.mas2j.mas2j.impl;

import jasonide.xtext.mas2j.mas2j.EnvironmentLocus;
import jasonide.xtext.mas2j.mas2j.Mas2jPackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Environment Locus</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link jasonide.xtext.mas2j.mas2j.impl.EnvironmentLocusImpl#getEnvironmentLocus <em>Environment Locus</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class EnvironmentLocusImpl extends MinimalEObjectImpl.Container implements EnvironmentLocus
{
  /**
   * The default value of the '{@link #getEnvironmentLocus() <em>Environment Locus</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getEnvironmentLocus()
   * @generated
   * @ordered
   */
  protected static final String ENVIRONMENT_LOCUS_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getEnvironmentLocus() <em>Environment Locus</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getEnvironmentLocus()
   * @generated
   * @ordered
   */
  protected String environmentLocus = ENVIRONMENT_LOCUS_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected EnvironmentLocusImpl()
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
    return Mas2jPackage.Literals.ENVIRONMENT_LOCUS;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getEnvironmentLocus()
  {
    return environmentLocus;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setEnvironmentLocus(String newEnvironmentLocus)
  {
    String oldEnvironmentLocus = environmentLocus;
    environmentLocus = newEnvironmentLocus;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, Mas2jPackage.ENVIRONMENT_LOCUS__ENVIRONMENT_LOCUS, oldEnvironmentLocus, environmentLocus));
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
      case Mas2jPackage.ENVIRONMENT_LOCUS__ENVIRONMENT_LOCUS:
        return getEnvironmentLocus();
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
      case Mas2jPackage.ENVIRONMENT_LOCUS__ENVIRONMENT_LOCUS:
        setEnvironmentLocus((String)newValue);
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
      case Mas2jPackage.ENVIRONMENT_LOCUS__ENVIRONMENT_LOCUS:
        setEnvironmentLocus(ENVIRONMENT_LOCUS_EDEFAULT);
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
      case Mas2jPackage.ENVIRONMENT_LOCUS__ENVIRONMENT_LOCUS:
        return ENVIRONMENT_LOCUS_EDEFAULT == null ? environmentLocus != null : !ENVIRONMENT_LOCUS_EDEFAULT.equals(environmentLocus);
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
    result.append(" (environmentLocus: ");
    result.append(environmentLocus);
    result.append(')');
    return result.toString();
  }

} //EnvironmentLocusImpl
