/**
 * <copyright>
 * </copyright>
 *
 */
package jasonide.xtext.asl.asl.impl;

import jasonide.xtext.asl.asl.AslPackage;
import jasonide.xtext.asl.asl.Log_expr_factor;
import jasonide.xtext.asl.asl.Rel_expr;

import java.lang.String;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Log expr factor</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link jasonide.xtext.asl.asl.impl.Log_expr_factorImpl#getTk_not <em>Tk not</em>}</li>
 *   <li>{@link jasonide.xtext.asl.asl.impl.Log_expr_factorImpl#getLog_expr_factor <em>Log expr factor</em>}</li>
 *   <li>{@link jasonide.xtext.asl.asl.impl.Log_expr_factorImpl#getRel_expr <em>Rel expr</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class Log_expr_factorImpl extends MinimalEObjectImpl.Container implements Log_expr_factor
{
  /**
   * The default value of the '{@link #getTk_not() <em>Tk not</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTk_not()
   * @generated
   * @ordered
   */
  protected static final String TK_NOT_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getTk_not() <em>Tk not</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTk_not()
   * @generated
   * @ordered
   */
  protected String tk_not = TK_NOT_EDEFAULT;

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
   * The cached value of the '{@link #getRel_expr() <em>Rel expr</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getRel_expr()
   * @generated
   * @ordered
   */
  protected Rel_expr rel_expr;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected Log_expr_factorImpl()
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
    return AslPackage.Literals.LOG_EXPR_FACTOR;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getTk_not()
  {
    return tk_not;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setTk_not(String newTk_not)
  {
    String oldTk_not = tk_not;
    tk_not = newTk_not;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AslPackage.LOG_EXPR_FACTOR__TK_NOT, oldTk_not, tk_not));
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
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AslPackage.LOG_EXPR_FACTOR__LOG_EXPR_FACTOR, oldLog_expr_factor, newLog_expr_factor);
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
        msgs = ((InternalEObject)log_expr_factor).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AslPackage.LOG_EXPR_FACTOR__LOG_EXPR_FACTOR, null, msgs);
      if (newLog_expr_factor != null)
        msgs = ((InternalEObject)newLog_expr_factor).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AslPackage.LOG_EXPR_FACTOR__LOG_EXPR_FACTOR, null, msgs);
      msgs = basicSetLog_expr_factor(newLog_expr_factor, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AslPackage.LOG_EXPR_FACTOR__LOG_EXPR_FACTOR, newLog_expr_factor, newLog_expr_factor));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Rel_expr getRel_expr()
  {
    return rel_expr;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetRel_expr(Rel_expr newRel_expr, NotificationChain msgs)
  {
    Rel_expr oldRel_expr = rel_expr;
    rel_expr = newRel_expr;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AslPackage.LOG_EXPR_FACTOR__REL_EXPR, oldRel_expr, newRel_expr);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setRel_expr(Rel_expr newRel_expr)
  {
    if (newRel_expr != rel_expr)
    {
      NotificationChain msgs = null;
      if (rel_expr != null)
        msgs = ((InternalEObject)rel_expr).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AslPackage.LOG_EXPR_FACTOR__REL_EXPR, null, msgs);
      if (newRel_expr != null)
        msgs = ((InternalEObject)newRel_expr).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AslPackage.LOG_EXPR_FACTOR__REL_EXPR, null, msgs);
      msgs = basicSetRel_expr(newRel_expr, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AslPackage.LOG_EXPR_FACTOR__REL_EXPR, newRel_expr, newRel_expr));
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
      case AslPackage.LOG_EXPR_FACTOR__LOG_EXPR_FACTOR:
        return basicSetLog_expr_factor(null, msgs);
      case AslPackage.LOG_EXPR_FACTOR__REL_EXPR:
        return basicSetRel_expr(null, msgs);
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
      case AslPackage.LOG_EXPR_FACTOR__TK_NOT:
        return getTk_not();
      case AslPackage.LOG_EXPR_FACTOR__LOG_EXPR_FACTOR:
        return getLog_expr_factor();
      case AslPackage.LOG_EXPR_FACTOR__REL_EXPR:
        return getRel_expr();
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
      case AslPackage.LOG_EXPR_FACTOR__TK_NOT:
        setTk_not((String)newValue);
        return;
      case AslPackage.LOG_EXPR_FACTOR__LOG_EXPR_FACTOR:
        setLog_expr_factor((Log_expr_factor)newValue);
        return;
      case AslPackage.LOG_EXPR_FACTOR__REL_EXPR:
        setRel_expr((Rel_expr)newValue);
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
      case AslPackage.LOG_EXPR_FACTOR__TK_NOT:
        setTk_not(TK_NOT_EDEFAULT);
        return;
      case AslPackage.LOG_EXPR_FACTOR__LOG_EXPR_FACTOR:
        setLog_expr_factor((Log_expr_factor)null);
        return;
      case AslPackage.LOG_EXPR_FACTOR__REL_EXPR:
        setRel_expr((Rel_expr)null);
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
      case AslPackage.LOG_EXPR_FACTOR__TK_NOT:
        return TK_NOT_EDEFAULT == null ? tk_not != null : !TK_NOT_EDEFAULT.equals(tk_not);
      case AslPackage.LOG_EXPR_FACTOR__LOG_EXPR_FACTOR:
        return log_expr_factor != null;
      case AslPackage.LOG_EXPR_FACTOR__REL_EXPR:
        return rel_expr != null;
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
    result.append(" (tk_not: ");
    result.append(tk_not);
    result.append(')');
    return result.toString();
  }

} //Log_expr_factorImpl
