/**
 * <copyright>
 * </copyright>
 *
 */
package jasonide.xtext.asl.asl.impl;

import jasonide.xtext.asl.asl.AslPackage;
import jasonide.xtext.asl.asl.Body_formula;
import jasonide.xtext.asl.asl.Plan_body;
import jasonide.xtext.asl.asl.StmtFOR;
import jasonide.xtext.asl.asl.StmtIF;
import jasonide.xtext.asl.asl.StmtWHILE;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Plan body</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link jasonide.xtext.asl.asl.impl.Plan_bodyImpl#getStmtIF <em>Stmt IF</em>}</li>
 *   <li>{@link jasonide.xtext.asl.asl.impl.Plan_bodyImpl#getStmtFOR <em>Stmt FOR</em>}</li>
 *   <li>{@link jasonide.xtext.asl.asl.impl.Plan_bodyImpl#getStmtWHILE <em>Stmt WHILE</em>}</li>
 *   <li>{@link jasonide.xtext.asl.asl.impl.Plan_bodyImpl#getBody_formula <em>Body formula</em>}</li>
 *   <li>{@link jasonide.xtext.asl.asl.impl.Plan_bodyImpl#getPlan_body <em>Plan body</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class Plan_bodyImpl extends MinimalEObjectImpl.Container implements Plan_body
{
  /**
   * The cached value of the '{@link #getStmtIF() <em>Stmt IF</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getStmtIF()
   * @generated
   * @ordered
   */
  protected StmtIF stmtIF;

  /**
   * The cached value of the '{@link #getStmtFOR() <em>Stmt FOR</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getStmtFOR()
   * @generated
   * @ordered
   */
  protected StmtFOR stmtFOR;

  /**
   * The cached value of the '{@link #getStmtWHILE() <em>Stmt WHILE</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getStmtWHILE()
   * @generated
   * @ordered
   */
  protected StmtWHILE stmtWHILE;

  /**
   * The cached value of the '{@link #getBody_formula() <em>Body formula</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getBody_formula()
   * @generated
   * @ordered
   */
  protected Body_formula body_formula;

  /**
   * The cached value of the '{@link #getPlan_body() <em>Plan body</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getPlan_body()
   * @generated
   * @ordered
   */
  protected Plan_body plan_body;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected Plan_bodyImpl()
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
    return AslPackage.Literals.PLAN_BODY;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public StmtIF getStmtIF()
  {
    return stmtIF;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetStmtIF(StmtIF newStmtIF, NotificationChain msgs)
  {
    StmtIF oldStmtIF = stmtIF;
    stmtIF = newStmtIF;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AslPackage.PLAN_BODY__STMT_IF, oldStmtIF, newStmtIF);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setStmtIF(StmtIF newStmtIF)
  {
    if (newStmtIF != stmtIF)
    {
      NotificationChain msgs = null;
      if (stmtIF != null)
        msgs = ((InternalEObject)stmtIF).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AslPackage.PLAN_BODY__STMT_IF, null, msgs);
      if (newStmtIF != null)
        msgs = ((InternalEObject)newStmtIF).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AslPackage.PLAN_BODY__STMT_IF, null, msgs);
      msgs = basicSetStmtIF(newStmtIF, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AslPackage.PLAN_BODY__STMT_IF, newStmtIF, newStmtIF));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public StmtFOR getStmtFOR()
  {
    return stmtFOR;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetStmtFOR(StmtFOR newStmtFOR, NotificationChain msgs)
  {
    StmtFOR oldStmtFOR = stmtFOR;
    stmtFOR = newStmtFOR;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AslPackage.PLAN_BODY__STMT_FOR, oldStmtFOR, newStmtFOR);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setStmtFOR(StmtFOR newStmtFOR)
  {
    if (newStmtFOR != stmtFOR)
    {
      NotificationChain msgs = null;
      if (stmtFOR != null)
        msgs = ((InternalEObject)stmtFOR).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AslPackage.PLAN_BODY__STMT_FOR, null, msgs);
      if (newStmtFOR != null)
        msgs = ((InternalEObject)newStmtFOR).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AslPackage.PLAN_BODY__STMT_FOR, null, msgs);
      msgs = basicSetStmtFOR(newStmtFOR, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AslPackage.PLAN_BODY__STMT_FOR, newStmtFOR, newStmtFOR));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public StmtWHILE getStmtWHILE()
  {
    return stmtWHILE;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetStmtWHILE(StmtWHILE newStmtWHILE, NotificationChain msgs)
  {
    StmtWHILE oldStmtWHILE = stmtWHILE;
    stmtWHILE = newStmtWHILE;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AslPackage.PLAN_BODY__STMT_WHILE, oldStmtWHILE, newStmtWHILE);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setStmtWHILE(StmtWHILE newStmtWHILE)
  {
    if (newStmtWHILE != stmtWHILE)
    {
      NotificationChain msgs = null;
      if (stmtWHILE != null)
        msgs = ((InternalEObject)stmtWHILE).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AslPackage.PLAN_BODY__STMT_WHILE, null, msgs);
      if (newStmtWHILE != null)
        msgs = ((InternalEObject)newStmtWHILE).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AslPackage.PLAN_BODY__STMT_WHILE, null, msgs);
      msgs = basicSetStmtWHILE(newStmtWHILE, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AslPackage.PLAN_BODY__STMT_WHILE, newStmtWHILE, newStmtWHILE));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Body_formula getBody_formula()
  {
    return body_formula;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetBody_formula(Body_formula newBody_formula, NotificationChain msgs)
  {
    Body_formula oldBody_formula = body_formula;
    body_formula = newBody_formula;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AslPackage.PLAN_BODY__BODY_FORMULA, oldBody_formula, newBody_formula);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setBody_formula(Body_formula newBody_formula)
  {
    if (newBody_formula != body_formula)
    {
      NotificationChain msgs = null;
      if (body_formula != null)
        msgs = ((InternalEObject)body_formula).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AslPackage.PLAN_BODY__BODY_FORMULA, null, msgs);
      if (newBody_formula != null)
        msgs = ((InternalEObject)newBody_formula).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AslPackage.PLAN_BODY__BODY_FORMULA, null, msgs);
      msgs = basicSetBody_formula(newBody_formula, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AslPackage.PLAN_BODY__BODY_FORMULA, newBody_formula, newBody_formula));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Plan_body getPlan_body()
  {
    return plan_body;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetPlan_body(Plan_body newPlan_body, NotificationChain msgs)
  {
    Plan_body oldPlan_body = plan_body;
    plan_body = newPlan_body;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AslPackage.PLAN_BODY__PLAN_BODY, oldPlan_body, newPlan_body);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setPlan_body(Plan_body newPlan_body)
  {
    if (newPlan_body != plan_body)
    {
      NotificationChain msgs = null;
      if (plan_body != null)
        msgs = ((InternalEObject)plan_body).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AslPackage.PLAN_BODY__PLAN_BODY, null, msgs);
      if (newPlan_body != null)
        msgs = ((InternalEObject)newPlan_body).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AslPackage.PLAN_BODY__PLAN_BODY, null, msgs);
      msgs = basicSetPlan_body(newPlan_body, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AslPackage.PLAN_BODY__PLAN_BODY, newPlan_body, newPlan_body));
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
      case AslPackage.PLAN_BODY__STMT_IF:
        return basicSetStmtIF(null, msgs);
      case AslPackage.PLAN_BODY__STMT_FOR:
        return basicSetStmtFOR(null, msgs);
      case AslPackage.PLAN_BODY__STMT_WHILE:
        return basicSetStmtWHILE(null, msgs);
      case AslPackage.PLAN_BODY__BODY_FORMULA:
        return basicSetBody_formula(null, msgs);
      case AslPackage.PLAN_BODY__PLAN_BODY:
        return basicSetPlan_body(null, msgs);
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
      case AslPackage.PLAN_BODY__STMT_IF:
        return getStmtIF();
      case AslPackage.PLAN_BODY__STMT_FOR:
        return getStmtFOR();
      case AslPackage.PLAN_BODY__STMT_WHILE:
        return getStmtWHILE();
      case AslPackage.PLAN_BODY__BODY_FORMULA:
        return getBody_formula();
      case AslPackage.PLAN_BODY__PLAN_BODY:
        return getPlan_body();
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
      case AslPackage.PLAN_BODY__STMT_IF:
        setStmtIF((StmtIF)newValue);
        return;
      case AslPackage.PLAN_BODY__STMT_FOR:
        setStmtFOR((StmtFOR)newValue);
        return;
      case AslPackage.PLAN_BODY__STMT_WHILE:
        setStmtWHILE((StmtWHILE)newValue);
        return;
      case AslPackage.PLAN_BODY__BODY_FORMULA:
        setBody_formula((Body_formula)newValue);
        return;
      case AslPackage.PLAN_BODY__PLAN_BODY:
        setPlan_body((Plan_body)newValue);
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
      case AslPackage.PLAN_BODY__STMT_IF:
        setStmtIF((StmtIF)null);
        return;
      case AslPackage.PLAN_BODY__STMT_FOR:
        setStmtFOR((StmtFOR)null);
        return;
      case AslPackage.PLAN_BODY__STMT_WHILE:
        setStmtWHILE((StmtWHILE)null);
        return;
      case AslPackage.PLAN_BODY__BODY_FORMULA:
        setBody_formula((Body_formula)null);
        return;
      case AslPackage.PLAN_BODY__PLAN_BODY:
        setPlan_body((Plan_body)null);
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
      case AslPackage.PLAN_BODY__STMT_IF:
        return stmtIF != null;
      case AslPackage.PLAN_BODY__STMT_FOR:
        return stmtFOR != null;
      case AslPackage.PLAN_BODY__STMT_WHILE:
        return stmtWHILE != null;
      case AslPackage.PLAN_BODY__BODY_FORMULA:
        return body_formula != null;
      case AslPackage.PLAN_BODY__PLAN_BODY:
        return plan_body != null;
    }
    return super.eIsSet(featureID);
  }

} //Plan_bodyImpl
