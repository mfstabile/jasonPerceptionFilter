/**
 * <copyright>
 * </copyright>
 *
 */
package jasonide.xtext.mas2j.mas2j.impl;

import jasonide.xtext.mas2j.mas2j.ClsDef;
import jasonide.xtext.mas2j.mas2j.Control;
import jasonide.xtext.mas2j.mas2j.Mas2jPackage;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Control</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link jasonide.xtext.mas2j.mas2j.impl.ControlImpl#getControl <em>Control</em>}</li>
 *   <li>{@link jasonide.xtext.mas2j.mas2j.impl.ControlImpl#getControlLocus <em>Control Locus</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ControlImpl extends MinimalEObjectImpl.Container implements Control
{
  /**
   * The cached value of the '{@link #getControl() <em>Control</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getControl()
   * @generated
   * @ordered
   */
  protected ClsDef control;

  /**
   * The default value of the '{@link #getControlLocus() <em>Control Locus</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getControlLocus()
   * @generated
   * @ordered
   */
  protected static final String CONTROL_LOCUS_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getControlLocus() <em>Control Locus</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getControlLocus()
   * @generated
   * @ordered
   */
  protected String controlLocus = CONTROL_LOCUS_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ControlImpl()
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
    return Mas2jPackage.Literals.CONTROL;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ClsDef getControl()
  {
    return control;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetControl(ClsDef newControl, NotificationChain msgs)
  {
    ClsDef oldControl = control;
    control = newControl;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, Mas2jPackage.CONTROL__CONTROL, oldControl, newControl);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setControl(ClsDef newControl)
  {
    if (newControl != control)
    {
      NotificationChain msgs = null;
      if (control != null)
        msgs = ((InternalEObject)control).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - Mas2jPackage.CONTROL__CONTROL, null, msgs);
      if (newControl != null)
        msgs = ((InternalEObject)newControl).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - Mas2jPackage.CONTROL__CONTROL, null, msgs);
      msgs = basicSetControl(newControl, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, Mas2jPackage.CONTROL__CONTROL, newControl, newControl));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getControlLocus()
  {
    return controlLocus;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setControlLocus(String newControlLocus)
  {
    String oldControlLocus = controlLocus;
    controlLocus = newControlLocus;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, Mas2jPackage.CONTROL__CONTROL_LOCUS, oldControlLocus, controlLocus));
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
      case Mas2jPackage.CONTROL__CONTROL:
        return basicSetControl(null, msgs);
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
      case Mas2jPackage.CONTROL__CONTROL:
        return getControl();
      case Mas2jPackage.CONTROL__CONTROL_LOCUS:
        return getControlLocus();
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
      case Mas2jPackage.CONTROL__CONTROL:
        setControl((ClsDef)newValue);
        return;
      case Mas2jPackage.CONTROL__CONTROL_LOCUS:
        setControlLocus((String)newValue);
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
      case Mas2jPackage.CONTROL__CONTROL:
        setControl((ClsDef)null);
        return;
      case Mas2jPackage.CONTROL__CONTROL_LOCUS:
        setControlLocus(CONTROL_LOCUS_EDEFAULT);
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
      case Mas2jPackage.CONTROL__CONTROL:
        return control != null;
      case Mas2jPackage.CONTROL__CONTROL_LOCUS:
        return CONTROL_LOCUS_EDEFAULT == null ? controlLocus != null : !CONTROL_LOCUS_EDEFAULT.equals(controlLocus);
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
    result.append(" (controlLocus: ");
    result.append(controlLocus);
    result.append(')');
    return result.toString();
  }

} //ControlImpl
