/**
 * <copyright>
 * </copyright>
 *
 */
package jasonide.xtext.asl.asl.impl;

import jasonide.xtext.asl.asl.Arithm_expr;
import jasonide.xtext.asl.asl.Arithm_expr_trm;
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
 * An implementation of the model object '<em><b>Arithm expr</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link jasonide.xtext.asl.asl.impl.Arithm_exprImpl#getArithm_expr_trm <em>Arithm expr trm</em>}</li>
 *   <li>{@link jasonide.xtext.asl.asl.impl.Arithm_exprImpl#getSubadd <em>Subadd</em>}</li>
 *   <li>{@link jasonide.xtext.asl.asl.impl.Arithm_exprImpl#getArithm_expr <em>Arithm expr</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class Arithm_exprImpl extends MinimalEObjectImpl.Container implements Arithm_expr
{
  /**
   * The cached value of the '{@link #getArithm_expr_trm() <em>Arithm expr trm</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getArithm_expr_trm()
   * @generated
   * @ordered
   */
  protected Arithm_expr_trm arithm_expr_trm;

  /**
   * The default value of the '{@link #getSubadd() <em>Subadd</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSubadd()
   * @generated
   * @ordered
   */
  protected static final String SUBADD_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getSubadd() <em>Subadd</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSubadd()
   * @generated
   * @ordered
   */
  protected String subadd = SUBADD_EDEFAULT;

  /**
   * The cached value of the '{@link #getArithm_expr() <em>Arithm expr</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getArithm_expr()
   * @generated
   * @ordered
   */
  protected Arithm_expr arithm_expr;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected Arithm_exprImpl()
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
    return AslPackage.Literals.ARITHM_EXPR;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Arithm_expr_trm getArithm_expr_trm()
  {
    return arithm_expr_trm;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetArithm_expr_trm(Arithm_expr_trm newArithm_expr_trm, NotificationChain msgs)
  {
    Arithm_expr_trm oldArithm_expr_trm = arithm_expr_trm;
    arithm_expr_trm = newArithm_expr_trm;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AslPackage.ARITHM_EXPR__ARITHM_EXPR_TRM, oldArithm_expr_trm, newArithm_expr_trm);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setArithm_expr_trm(Arithm_expr_trm newArithm_expr_trm)
  {
    if (newArithm_expr_trm != arithm_expr_trm)
    {
      NotificationChain msgs = null;
      if (arithm_expr_trm != null)
        msgs = ((InternalEObject)arithm_expr_trm).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AslPackage.ARITHM_EXPR__ARITHM_EXPR_TRM, null, msgs);
      if (newArithm_expr_trm != null)
        msgs = ((InternalEObject)newArithm_expr_trm).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AslPackage.ARITHM_EXPR__ARITHM_EXPR_TRM, null, msgs);
      msgs = basicSetArithm_expr_trm(newArithm_expr_trm, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AslPackage.ARITHM_EXPR__ARITHM_EXPR_TRM, newArithm_expr_trm, newArithm_expr_trm));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getSubadd()
  {
    return subadd;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setSubadd(String newSubadd)
  {
    String oldSubadd = subadd;
    subadd = newSubadd;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AslPackage.ARITHM_EXPR__SUBADD, oldSubadd, subadd));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Arithm_expr getArithm_expr()
  {
    return arithm_expr;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetArithm_expr(Arithm_expr newArithm_expr, NotificationChain msgs)
  {
    Arithm_expr oldArithm_expr = arithm_expr;
    arithm_expr = newArithm_expr;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AslPackage.ARITHM_EXPR__ARITHM_EXPR, oldArithm_expr, newArithm_expr);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setArithm_expr(Arithm_expr newArithm_expr)
  {
    if (newArithm_expr != arithm_expr)
    {
      NotificationChain msgs = null;
      if (arithm_expr != null)
        msgs = ((InternalEObject)arithm_expr).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AslPackage.ARITHM_EXPR__ARITHM_EXPR, null, msgs);
      if (newArithm_expr != null)
        msgs = ((InternalEObject)newArithm_expr).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AslPackage.ARITHM_EXPR__ARITHM_EXPR, null, msgs);
      msgs = basicSetArithm_expr(newArithm_expr, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AslPackage.ARITHM_EXPR__ARITHM_EXPR, newArithm_expr, newArithm_expr));
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
      case AslPackage.ARITHM_EXPR__ARITHM_EXPR_TRM:
        return basicSetArithm_expr_trm(null, msgs);
      case AslPackage.ARITHM_EXPR__ARITHM_EXPR:
        return basicSetArithm_expr(null, msgs);
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
      case AslPackage.ARITHM_EXPR__ARITHM_EXPR_TRM:
        return getArithm_expr_trm();
      case AslPackage.ARITHM_EXPR__SUBADD:
        return getSubadd();
      case AslPackage.ARITHM_EXPR__ARITHM_EXPR:
        return getArithm_expr();
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
      case AslPackage.ARITHM_EXPR__ARITHM_EXPR_TRM:
        setArithm_expr_trm((Arithm_expr_trm)newValue);
        return;
      case AslPackage.ARITHM_EXPR__SUBADD:
        setSubadd((String)newValue);
        return;
      case AslPackage.ARITHM_EXPR__ARITHM_EXPR:
        setArithm_expr((Arithm_expr)newValue);
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
      case AslPackage.ARITHM_EXPR__ARITHM_EXPR_TRM:
        setArithm_expr_trm((Arithm_expr_trm)null);
        return;
      case AslPackage.ARITHM_EXPR__SUBADD:
        setSubadd(SUBADD_EDEFAULT);
        return;
      case AslPackage.ARITHM_EXPR__ARITHM_EXPR:
        setArithm_expr((Arithm_expr)null);
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
      case AslPackage.ARITHM_EXPR__ARITHM_EXPR_TRM:
        return arithm_expr_trm != null;
      case AslPackage.ARITHM_EXPR__SUBADD:
        return SUBADD_EDEFAULT == null ? subadd != null : !SUBADD_EDEFAULT.equals(subadd);
      case AslPackage.ARITHM_EXPR__ARITHM_EXPR:
        return arithm_expr != null;
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
    result.append(" (subadd: ");
    result.append(subadd);
    result.append(')');
    return result.toString();
  }

} //Arithm_exprImpl
