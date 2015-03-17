/**
 * <copyright>
 * </copyright>
 *
 */
package jasonide.xtext.asl.asl.impl;

import jasonide.xtext.asl.asl.AslPackage;
import jasonide.xtext.asl.asl.Body_formula;
import jasonide.xtext.asl.asl.Log_expr;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Body formula</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link jasonide.xtext.asl.asl.impl.Body_formulaImpl#getLog_expr <em>Log expr</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class Body_formulaImpl extends MinimalEObjectImpl.Container implements Body_formula
{
  /**
   * The cached value of the '{@link #getLog_expr() <em>Log expr</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getLog_expr()
   * @generated
   * @ordered
   */
  protected Log_expr log_expr;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected Body_formulaImpl()
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
    return AslPackage.Literals.BODY_FORMULA;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Log_expr getLog_expr()
  {
    return log_expr;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetLog_expr(Log_expr newLog_expr, NotificationChain msgs)
  {
    Log_expr oldLog_expr = log_expr;
    log_expr = newLog_expr;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AslPackage.BODY_FORMULA__LOG_EXPR, oldLog_expr, newLog_expr);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setLog_expr(Log_expr newLog_expr)
  {
    if (newLog_expr != log_expr)
    {
      NotificationChain msgs = null;
      if (log_expr != null)
        msgs = ((InternalEObject)log_expr).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AslPackage.BODY_FORMULA__LOG_EXPR, null, msgs);
      if (newLog_expr != null)
        msgs = ((InternalEObject)newLog_expr).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AslPackage.BODY_FORMULA__LOG_EXPR, null, msgs);
      msgs = basicSetLog_expr(newLog_expr, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AslPackage.BODY_FORMULA__LOG_EXPR, newLog_expr, newLog_expr));
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
      case AslPackage.BODY_FORMULA__LOG_EXPR:
        return basicSetLog_expr(null, msgs);
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
      case AslPackage.BODY_FORMULA__LOG_EXPR:
        return getLog_expr();
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
      case AslPackage.BODY_FORMULA__LOG_EXPR:
        setLog_expr((Log_expr)newValue);
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
      case AslPackage.BODY_FORMULA__LOG_EXPR:
        setLog_expr((Log_expr)null);
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
      case AslPackage.BODY_FORMULA__LOG_EXPR:
        return log_expr != null;
    }
    return super.eIsSet(featureID);
  }

} //Body_formulaImpl
