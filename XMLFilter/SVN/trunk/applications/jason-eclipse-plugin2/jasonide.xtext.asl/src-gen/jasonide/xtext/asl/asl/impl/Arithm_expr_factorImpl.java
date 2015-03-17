/**
 * <copyright>
 * </copyright>
 *
 */
package jasonide.xtext.asl.asl.impl;

import jasonide.xtext.asl.asl.Arithm_expr_factor;
import jasonide.xtext.asl.asl.Arithm_expr_simple;
import jasonide.xtext.asl.asl.AslPackage;

import java.lang.String;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Arithm expr factor</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link jasonide.xtext.asl.asl.impl.Arithm_expr_factorImpl#getArithm_expr_simple <em>Arithm expr simple</em>}</li>
 *   <li>{@link jasonide.xtext.asl.asl.impl.Arithm_expr_factorImpl#getExponential <em>Exponential</em>}</li>
 *   <li>{@link jasonide.xtext.asl.asl.impl.Arithm_expr_factorImpl#getArithm_expr_factor <em>Arithm expr factor</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class Arithm_expr_factorImpl extends MinimalEObjectImpl.Container implements Arithm_expr_factor
{
  /**
   * The cached value of the '{@link #getArithm_expr_simple() <em>Arithm expr simple</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getArithm_expr_simple()
   * @generated
   * @ordered
   */
  protected Arithm_expr_simple arithm_expr_simple;

  /**
   * The default value of the '{@link #getExponential() <em>Exponential</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getExponential()
   * @generated
   * @ordered
   */
  protected static final String EXPONENTIAL_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getExponential() <em>Exponential</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getExponential()
   * @generated
   * @ordered
   */
  protected String exponential = EXPONENTIAL_EDEFAULT;

  /**
   * The cached value of the '{@link #getArithm_expr_factor() <em>Arithm expr factor</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getArithm_expr_factor()
   * @generated
   * @ordered
   */
  protected Arithm_expr_factor arithm_expr_factor;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected Arithm_expr_factorImpl()
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
    return AslPackage.Literals.ARITHM_EXPR_FACTOR;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Arithm_expr_simple getArithm_expr_simple()
  {
    return arithm_expr_simple;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetArithm_expr_simple(Arithm_expr_simple newArithm_expr_simple, NotificationChain msgs)
  {
    Arithm_expr_simple oldArithm_expr_simple = arithm_expr_simple;
    arithm_expr_simple = newArithm_expr_simple;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AslPackage.ARITHM_EXPR_FACTOR__ARITHM_EXPR_SIMPLE, oldArithm_expr_simple, newArithm_expr_simple);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setArithm_expr_simple(Arithm_expr_simple newArithm_expr_simple)
  {
    if (newArithm_expr_simple != arithm_expr_simple)
    {
      NotificationChain msgs = null;
      if (arithm_expr_simple != null)
        msgs = ((InternalEObject)arithm_expr_simple).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AslPackage.ARITHM_EXPR_FACTOR__ARITHM_EXPR_SIMPLE, null, msgs);
      if (newArithm_expr_simple != null)
        msgs = ((InternalEObject)newArithm_expr_simple).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AslPackage.ARITHM_EXPR_FACTOR__ARITHM_EXPR_SIMPLE, null, msgs);
      msgs = basicSetArithm_expr_simple(newArithm_expr_simple, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AslPackage.ARITHM_EXPR_FACTOR__ARITHM_EXPR_SIMPLE, newArithm_expr_simple, newArithm_expr_simple));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getExponential()
  {
    return exponential;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setExponential(String newExponential)
  {
    String oldExponential = exponential;
    exponential = newExponential;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AslPackage.ARITHM_EXPR_FACTOR__EXPONENTIAL, oldExponential, exponential));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Arithm_expr_factor getArithm_expr_factor()
  {
    return arithm_expr_factor;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetArithm_expr_factor(Arithm_expr_factor newArithm_expr_factor, NotificationChain msgs)
  {
    Arithm_expr_factor oldArithm_expr_factor = arithm_expr_factor;
    arithm_expr_factor = newArithm_expr_factor;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AslPackage.ARITHM_EXPR_FACTOR__ARITHM_EXPR_FACTOR, oldArithm_expr_factor, newArithm_expr_factor);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setArithm_expr_factor(Arithm_expr_factor newArithm_expr_factor)
  {
    if (newArithm_expr_factor != arithm_expr_factor)
    {
      NotificationChain msgs = null;
      if (arithm_expr_factor != null)
        msgs = ((InternalEObject)arithm_expr_factor).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AslPackage.ARITHM_EXPR_FACTOR__ARITHM_EXPR_FACTOR, null, msgs);
      if (newArithm_expr_factor != null)
        msgs = ((InternalEObject)newArithm_expr_factor).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AslPackage.ARITHM_EXPR_FACTOR__ARITHM_EXPR_FACTOR, null, msgs);
      msgs = basicSetArithm_expr_factor(newArithm_expr_factor, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AslPackage.ARITHM_EXPR_FACTOR__ARITHM_EXPR_FACTOR, newArithm_expr_factor, newArithm_expr_factor));
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
      case AslPackage.ARITHM_EXPR_FACTOR__ARITHM_EXPR_SIMPLE:
        return basicSetArithm_expr_simple(null, msgs);
      case AslPackage.ARITHM_EXPR_FACTOR__ARITHM_EXPR_FACTOR:
        return basicSetArithm_expr_factor(null, msgs);
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
      case AslPackage.ARITHM_EXPR_FACTOR__ARITHM_EXPR_SIMPLE:
        return getArithm_expr_simple();
      case AslPackage.ARITHM_EXPR_FACTOR__EXPONENTIAL:
        return getExponential();
      case AslPackage.ARITHM_EXPR_FACTOR__ARITHM_EXPR_FACTOR:
        return getArithm_expr_factor();
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
      case AslPackage.ARITHM_EXPR_FACTOR__ARITHM_EXPR_SIMPLE:
        setArithm_expr_simple((Arithm_expr_simple)newValue);
        return;
      case AslPackage.ARITHM_EXPR_FACTOR__EXPONENTIAL:
        setExponential((String)newValue);
        return;
      case AslPackage.ARITHM_EXPR_FACTOR__ARITHM_EXPR_FACTOR:
        setArithm_expr_factor((Arithm_expr_factor)newValue);
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
      case AslPackage.ARITHM_EXPR_FACTOR__ARITHM_EXPR_SIMPLE:
        setArithm_expr_simple((Arithm_expr_simple)null);
        return;
      case AslPackage.ARITHM_EXPR_FACTOR__EXPONENTIAL:
        setExponential(EXPONENTIAL_EDEFAULT);
        return;
      case AslPackage.ARITHM_EXPR_FACTOR__ARITHM_EXPR_FACTOR:
        setArithm_expr_factor((Arithm_expr_factor)null);
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
      case AslPackage.ARITHM_EXPR_FACTOR__ARITHM_EXPR_SIMPLE:
        return arithm_expr_simple != null;
      case AslPackage.ARITHM_EXPR_FACTOR__EXPONENTIAL:
        return EXPONENTIAL_EDEFAULT == null ? exponential != null : !EXPONENTIAL_EDEFAULT.equals(exponential);
      case AslPackage.ARITHM_EXPR_FACTOR__ARITHM_EXPR_FACTOR:
        return arithm_expr_factor != null;
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
    result.append(" (exponential: ");
    result.append(exponential);
    result.append(')');
    return result.toString();
  }

} //Arithm_expr_factorImpl
