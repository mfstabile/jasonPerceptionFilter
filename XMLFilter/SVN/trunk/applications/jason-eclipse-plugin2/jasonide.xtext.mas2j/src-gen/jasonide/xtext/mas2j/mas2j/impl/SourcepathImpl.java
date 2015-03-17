/**
 * <copyright>
 * </copyright>
 *
 */
package jasonide.xtext.mas2j.mas2j.impl;

import jasonide.xtext.mas2j.mas2j.Mas2jPackage;
import jasonide.xtext.mas2j.mas2j.Sourcepath;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Sourcepath</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link jasonide.xtext.mas2j.mas2j.impl.SourcepathImpl#getNomesourcepath <em>Nomesourcepath</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SourcepathImpl extends MinimalEObjectImpl.Container implements Sourcepath
{
  /**
   * The default value of the '{@link #getNomesourcepath() <em>Nomesourcepath</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getNomesourcepath()
   * @generated
   * @ordered
   */
  protected static final String NOMESOURCEPATH_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getNomesourcepath() <em>Nomesourcepath</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getNomesourcepath()
   * @generated
   * @ordered
   */
  protected String nomesourcepath = NOMESOURCEPATH_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected SourcepathImpl()
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
    return Mas2jPackage.Literals.SOURCEPATH;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getNomesourcepath()
  {
    return nomesourcepath;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setNomesourcepath(String newNomesourcepath)
  {
    String oldNomesourcepath = nomesourcepath;
    nomesourcepath = newNomesourcepath;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, Mas2jPackage.SOURCEPATH__NOMESOURCEPATH, oldNomesourcepath, nomesourcepath));
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
      case Mas2jPackage.SOURCEPATH__NOMESOURCEPATH:
        return getNomesourcepath();
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
      case Mas2jPackage.SOURCEPATH__NOMESOURCEPATH:
        setNomesourcepath((String)newValue);
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
      case Mas2jPackage.SOURCEPATH__NOMESOURCEPATH:
        setNomesourcepath(NOMESOURCEPATH_EDEFAULT);
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
      case Mas2jPackage.SOURCEPATH__NOMESOURCEPATH:
        return NOMESOURCEPATH_EDEFAULT == null ? nomesourcepath != null : !NOMESOURCEPATH_EDEFAULT.equals(nomesourcepath);
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
    result.append(" (nomesourcepath: ");
    result.append(nomesourcepath);
    result.append(')');
    return result.toString();
  }

} //SourcepathImpl
