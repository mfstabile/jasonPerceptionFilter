/**
 * <copyright>
 * </copyright>
 *
 */
package jasonide.xtext.asl.asl.impl;

import jasonide.xtext.asl.asl.Arithm_expr_simple;
import jasonide.xtext.asl.asl.AslPackage;
import jasonide.xtext.asl.asl.Function;
import jasonide.xtext.asl.asl.Log_expr;
import jasonide.xtext.asl.asl.Var;

import java.lang.String;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Arithm expr simple</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link jasonide.xtext.asl.asl.impl.Arithm_expr_simpleImpl#getNumber <em>Number</em>}</li>
 *   <li>{@link jasonide.xtext.asl.asl.impl.Arithm_expr_simpleImpl#getUnary <em>Unary</em>}</li>
 *   <li>{@link jasonide.xtext.asl.asl.impl.Arithm_expr_simpleImpl#getArithm_expr_simple <em>Arithm expr simple</em>}</li>
 *   <li>{@link jasonide.xtext.asl.asl.impl.Arithm_expr_simpleImpl#getLog_expr <em>Log expr</em>}</li>
 *   <li>{@link jasonide.xtext.asl.asl.impl.Arithm_expr_simpleImpl#getVar <em>Var</em>}</li>
 *   <li>{@link jasonide.xtext.asl.asl.impl.Arithm_expr_simpleImpl#getFunction <em>Function</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class Arithm_expr_simpleImpl extends MinimalEObjectImpl.Container implements Arithm_expr_simple
{
  /**
   * The cached value of the '{@link #getNumber() <em>Number</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getNumber()
   * @generated
   * @ordered
   */
  protected jasonide.xtext.asl.asl.Number number;

  /**
   * The default value of the '{@link #getUnary() <em>Unary</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getUnary()
   * @generated
   * @ordered
   */
  protected static final String UNARY_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getUnary() <em>Unary</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getUnary()
   * @generated
   * @ordered
   */
  protected String unary = UNARY_EDEFAULT;

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
   * The cached value of the '{@link #getLog_expr() <em>Log expr</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getLog_expr()
   * @generated
   * @ordered
   */
  protected Log_expr log_expr;

  /**
   * The cached value of the '{@link #getVar() <em>Var</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getVar()
   * @generated
   * @ordered
   */
  protected Var var;

  /**
   * The cached value of the '{@link #getFunction() <em>Function</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getFunction()
   * @generated
   * @ordered
   */
  protected Function function;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected Arithm_expr_simpleImpl()
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
    return AslPackage.Literals.ARITHM_EXPR_SIMPLE;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public jasonide.xtext.asl.asl.Number getNumber()
  {
    return number;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetNumber(jasonide.xtext.asl.asl.Number newNumber, NotificationChain msgs)
  {
    jasonide.xtext.asl.asl.Number oldNumber = number;
    number = newNumber;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AslPackage.ARITHM_EXPR_SIMPLE__NUMBER, oldNumber, newNumber);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setNumber(jasonide.xtext.asl.asl.Number newNumber)
  {
    if (newNumber != number)
    {
      NotificationChain msgs = null;
      if (number != null)
        msgs = ((InternalEObject)number).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AslPackage.ARITHM_EXPR_SIMPLE__NUMBER, null, msgs);
      if (newNumber != null)
        msgs = ((InternalEObject)newNumber).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AslPackage.ARITHM_EXPR_SIMPLE__NUMBER, null, msgs);
      msgs = basicSetNumber(newNumber, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AslPackage.ARITHM_EXPR_SIMPLE__NUMBER, newNumber, newNumber));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getUnary()
  {
    return unary;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setUnary(String newUnary)
  {
    String oldUnary = unary;
    unary = newUnary;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AslPackage.ARITHM_EXPR_SIMPLE__UNARY, oldUnary, unary));
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
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AslPackage.ARITHM_EXPR_SIMPLE__ARITHM_EXPR_SIMPLE, oldArithm_expr_simple, newArithm_expr_simple);
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
        msgs = ((InternalEObject)arithm_expr_simple).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AslPackage.ARITHM_EXPR_SIMPLE__ARITHM_EXPR_SIMPLE, null, msgs);
      if (newArithm_expr_simple != null)
        msgs = ((InternalEObject)newArithm_expr_simple).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AslPackage.ARITHM_EXPR_SIMPLE__ARITHM_EXPR_SIMPLE, null, msgs);
      msgs = basicSetArithm_expr_simple(newArithm_expr_simple, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AslPackage.ARITHM_EXPR_SIMPLE__ARITHM_EXPR_SIMPLE, newArithm_expr_simple, newArithm_expr_simple));
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
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AslPackage.ARITHM_EXPR_SIMPLE__LOG_EXPR, oldLog_expr, newLog_expr);
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
        msgs = ((InternalEObject)log_expr).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AslPackage.ARITHM_EXPR_SIMPLE__LOG_EXPR, null, msgs);
      if (newLog_expr != null)
        msgs = ((InternalEObject)newLog_expr).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AslPackage.ARITHM_EXPR_SIMPLE__LOG_EXPR, null, msgs);
      msgs = basicSetLog_expr(newLog_expr, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AslPackage.ARITHM_EXPR_SIMPLE__LOG_EXPR, newLog_expr, newLog_expr));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Var getVar()
  {
    return var;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetVar(Var newVar, NotificationChain msgs)
  {
    Var oldVar = var;
    var = newVar;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AslPackage.ARITHM_EXPR_SIMPLE__VAR, oldVar, newVar);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setVar(Var newVar)
  {
    if (newVar != var)
    {
      NotificationChain msgs = null;
      if (var != null)
        msgs = ((InternalEObject)var).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AslPackage.ARITHM_EXPR_SIMPLE__VAR, null, msgs);
      if (newVar != null)
        msgs = ((InternalEObject)newVar).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AslPackage.ARITHM_EXPR_SIMPLE__VAR, null, msgs);
      msgs = basicSetVar(newVar, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AslPackage.ARITHM_EXPR_SIMPLE__VAR, newVar, newVar));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Function getFunction()
  {
    return function;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetFunction(Function newFunction, NotificationChain msgs)
  {
    Function oldFunction = function;
    function = newFunction;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AslPackage.ARITHM_EXPR_SIMPLE__FUNCTION, oldFunction, newFunction);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setFunction(Function newFunction)
  {
    if (newFunction != function)
    {
      NotificationChain msgs = null;
      if (function != null)
        msgs = ((InternalEObject)function).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AslPackage.ARITHM_EXPR_SIMPLE__FUNCTION, null, msgs);
      if (newFunction != null)
        msgs = ((InternalEObject)newFunction).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AslPackage.ARITHM_EXPR_SIMPLE__FUNCTION, null, msgs);
      msgs = basicSetFunction(newFunction, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AslPackage.ARITHM_EXPR_SIMPLE__FUNCTION, newFunction, newFunction));
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
      case AslPackage.ARITHM_EXPR_SIMPLE__NUMBER:
        return basicSetNumber(null, msgs);
      case AslPackage.ARITHM_EXPR_SIMPLE__ARITHM_EXPR_SIMPLE:
        return basicSetArithm_expr_simple(null, msgs);
      case AslPackage.ARITHM_EXPR_SIMPLE__LOG_EXPR:
        return basicSetLog_expr(null, msgs);
      case AslPackage.ARITHM_EXPR_SIMPLE__VAR:
        return basicSetVar(null, msgs);
      case AslPackage.ARITHM_EXPR_SIMPLE__FUNCTION:
        return basicSetFunction(null, msgs);
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
      case AslPackage.ARITHM_EXPR_SIMPLE__NUMBER:
        return getNumber();
      case AslPackage.ARITHM_EXPR_SIMPLE__UNARY:
        return getUnary();
      case AslPackage.ARITHM_EXPR_SIMPLE__ARITHM_EXPR_SIMPLE:
        return getArithm_expr_simple();
      case AslPackage.ARITHM_EXPR_SIMPLE__LOG_EXPR:
        return getLog_expr();
      case AslPackage.ARITHM_EXPR_SIMPLE__VAR:
        return getVar();
      case AslPackage.ARITHM_EXPR_SIMPLE__FUNCTION:
        return getFunction();
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
      case AslPackage.ARITHM_EXPR_SIMPLE__NUMBER:
        setNumber((jasonide.xtext.asl.asl.Number)newValue);
        return;
      case AslPackage.ARITHM_EXPR_SIMPLE__UNARY:
        setUnary((String)newValue);
        return;
      case AslPackage.ARITHM_EXPR_SIMPLE__ARITHM_EXPR_SIMPLE:
        setArithm_expr_simple((Arithm_expr_simple)newValue);
        return;
      case AslPackage.ARITHM_EXPR_SIMPLE__LOG_EXPR:
        setLog_expr((Log_expr)newValue);
        return;
      case AslPackage.ARITHM_EXPR_SIMPLE__VAR:
        setVar((Var)newValue);
        return;
      case AslPackage.ARITHM_EXPR_SIMPLE__FUNCTION:
        setFunction((Function)newValue);
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
      case AslPackage.ARITHM_EXPR_SIMPLE__NUMBER:
        setNumber((jasonide.xtext.asl.asl.Number)null);
        return;
      case AslPackage.ARITHM_EXPR_SIMPLE__UNARY:
        setUnary(UNARY_EDEFAULT);
        return;
      case AslPackage.ARITHM_EXPR_SIMPLE__ARITHM_EXPR_SIMPLE:
        setArithm_expr_simple((Arithm_expr_simple)null);
        return;
      case AslPackage.ARITHM_EXPR_SIMPLE__LOG_EXPR:
        setLog_expr((Log_expr)null);
        return;
      case AslPackage.ARITHM_EXPR_SIMPLE__VAR:
        setVar((Var)null);
        return;
      case AslPackage.ARITHM_EXPR_SIMPLE__FUNCTION:
        setFunction((Function)null);
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
      case AslPackage.ARITHM_EXPR_SIMPLE__NUMBER:
        return number != null;
      case AslPackage.ARITHM_EXPR_SIMPLE__UNARY:
        return UNARY_EDEFAULT == null ? unary != null : !UNARY_EDEFAULT.equals(unary);
      case AslPackage.ARITHM_EXPR_SIMPLE__ARITHM_EXPR_SIMPLE:
        return arithm_expr_simple != null;
      case AslPackage.ARITHM_EXPR_SIMPLE__LOG_EXPR:
        return log_expr != null;
      case AslPackage.ARITHM_EXPR_SIMPLE__VAR:
        return var != null;
      case AslPackage.ARITHM_EXPR_SIMPLE__FUNCTION:
        return function != null;
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
    result.append(" (unary: ");
    result.append(unary);
    result.append(')');
    return result.toString();
  }

} //Arithm_expr_simpleImpl
