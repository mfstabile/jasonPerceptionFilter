/**
 * <copyright>
 * </copyright>
 *
 */
package jasonide.xtext.asl.asl.impl;

import jasonide.xtext.asl.asl.AslPackage;
import jasonide.xtext.asl.asl.Log_expr_factor;
import jasonide.xtext.asl.asl.Log_expr_trm;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Log expr trm</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link jasonide.xtext.asl.asl.impl.Log_expr_trmImpl#getLog_expr_factor <em>Log expr factor</em>}</li>
 *   <li>{@link jasonide.xtext.asl.asl.impl.Log_expr_trmImpl#getLog_expr_trm <em>Log expr trm</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class Log_expr_trmImpl extends MinimalEObjectImpl.Container implements Log_expr_trm
{
  /**
   * The cached value of the '{@link #getLog_expr_factor() <em>Log expr factor</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getLog_expr_factor()
   * @generated
   * @ordered
   */
  protected Log_expr_factor log_expr_factor;

  /**
   * The cached value of the '{@link #getLog_expr_trm() <em>Log expr trm</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getLog_expr_trm()
   * @generated
   * @ordered
   */
  protected Log_expr_trm log_expr_trm;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected Log_expr_trmImpl()
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
    return AslPackage.Literals.LOG_EXPR_TRM;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Log_expr_factor getLog_expr_factor()
  {
    return log_expr_factor;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetLog_expr_factor(Log_expr_factor newLog_expr_factor, NotificationChain msgs)
  {
    Log_expr_factor oldLog_expr_factor = log_expr_factor;
    log_expr_factor = newLog_expr_factor;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AslPackage.LOG_EXPR_TRM__LOG_EXPR_FACTOR, oldLog_expr_factor, newLog_expr_factor);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setLog_expr_factor(Log_expr_factor newLog_expr_factor)
  {
    if (newLog_expr_factor != log_expr_factor)
    {
      NotificationChain msgs = null;
      if (log_expr_factor != null)
        msgs = ((InternalEObject)log_expr_factor).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AslPackage.LOG_EXPR_TRM__LOG_EXPR_FACTOR, null, msgs);
      if (newLog_expr_factor != null)
        msgs = ((InternalEObject)newLog_expr_factor).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AslPackage.LOG_EXPR_TRM__LOG_EXPR_FACTOR, null, msgs);
      msgs = basicSetLog_expr_factor(newLog_expr_factor, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AslPackage.LOG_EXPR_TRM__LOG_EXPR_FACTOR, newLog_expr_factor, newLog_expr_factor));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Log_expr_trm getLog_expr_trm()
  {
    return log_expr_trm;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetLog_expr_trm(Log_expr_trm newLog_expr_trm, NotificationChain msgs)
  {
    Log_expr_trm oldLog_expr_trm = log_expr_trm;
    log_expr_trm = newLog_expr_trm;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AslPackage.LOG_EXPR_TRM__LOG_EXPR_TRM, oldLog_expr_trm, newLog_expr_trm);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setLog_expr_trm(Log_expr_trm newLog_expr_trm)
  {
    if (newLog_expr_trm != log_expr_trm)
    {
      NotificationChain msgs = null;
      if (log_expr_trm != null)
        msgs = ((InternalEObject)log_expr_trm).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AslPackage.LOG_EXPR_TRM__LOG_EXPR_TRM, null, msgs);
      if (newLog_expr_trm != null)
        msgs = ((InternalEObject)newLog_expr_trm).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AslPackage.LOG_EXPR_TRM__LOG_EXPR_TRM, null, msgs);
      msgs = basicSetLog_expr_trm(newLog_expr_trm, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AslPackage.LOG_EXPR_TRM__LOG_EXPR_TRM, newLog_expr_trm, newLog_expr_trm));
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
      case AslPackage.LOG_EXPR_TRM__LOG_EXPR_FACTOR:
        return basicSetLog_expr_factor(null, msgs);
      case AslPackage.LOG_EXPR_TRM__LOG_EXPR_TRM:
        return basicSetLog_expr_trm(null, msgs);
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
      case AslPackage.LOG_EXPR_TRM__LOG_EXPR_FACTOR:
        return getLog_expr_factor();
      case AslPackage.LOG_EXPR_TRM__LOG_EXPR_TRM:
        return getLog_expr_trm();
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
      case AslPackage.LOG_EXPR_TRM__LOG_EXPR_FACTOR:
        setLog_expr_factor((Log_expr_factor)newValue);
        return;
      case AslPackage.LOG_EXPR_TRM__LOG_EXPR_TRM:
        setLog_expr_trm((Log_expr_trm)newValue);
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
      case AslPackage.LOG_EXPR_TRM__LOG_EXPR_FACTOR:
        setLog_expr_factor((Log_expr_factor)null);
        return;
      case AslPackage.LOG_EXPR_TRM__LOG_EXPR_TRM:
        setLog_expr_trm((Log_expr_trm)null);
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
      case AslPackage.LOG_EXPR_TRM__LOG_EXPR_FACTOR:
        return log_expr_factor != null;
      case AslPackage.LOG_EXPR_TRM__LOG_EXPR_TRM:
        return log_expr_trm != null;
    }
    return super.eIsSet(featureID);
  }

} //Log_expr_trmImpl
