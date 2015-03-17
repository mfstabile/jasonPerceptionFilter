/**
 * <copyright>
 * </copyright>
 *
 */
package jasonide.xtext.asl.asl.impl;

import jasonide.xtext.asl.asl.Agent;
import jasonide.xtext.asl.asl.AslPackage;
import jasonide.xtext.asl.asl.Directive;
import jasonide.xtext.asl.asl.Pred;

import java.lang.String;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Directive</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link jasonide.xtext.asl.asl.impl.DirectiveImpl#getTk_begin <em>Tk begin</em>}</li>
 *   <li>{@link jasonide.xtext.asl.asl.impl.DirectiveImpl#getPred <em>Pred</em>}</li>
 *   <li>{@link jasonide.xtext.asl.asl.impl.DirectiveImpl#getAgent <em>Agent</em>}</li>
 *   <li>{@link jasonide.xtext.asl.asl.impl.DirectiveImpl#getPred2 <em>Pred2</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class DirectiveImpl extends MinimalEObjectImpl.Container implements Directive
{
  /**
   * The default value of the '{@link #getTk_begin() <em>Tk begin</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTk_begin()
   * @generated
   * @ordered
   */
  protected static final String TK_BEGIN_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getTk_begin() <em>Tk begin</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTk_begin()
   * @generated
   * @ordered
   */
  protected String tk_begin = TK_BEGIN_EDEFAULT;

  /**
   * The cached value of the '{@link #getPred() <em>Pred</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getPred()
   * @generated
   * @ordered
   */
  protected Pred pred;

  /**
   * The cached value of the '{@link #getAgent() <em>Agent</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getAgent()
   * @generated
   * @ordered
   */
  protected Agent agent;

  /**
   * The cached value of the '{@link #getPred2() <em>Pred2</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getPred2()
   * @generated
   * @ordered
   */
  protected Pred pred2;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected DirectiveImpl()
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
    return AslPackage.Literals.DIRECTIVE;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getTk_begin()
  {
    return tk_begin;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setTk_begin(String newTk_begin)
  {
    String oldTk_begin = tk_begin;
    tk_begin = newTk_begin;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AslPackage.DIRECTIVE__TK_BEGIN, oldTk_begin, tk_begin));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Pred getPred()
  {
    return pred;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetPred(Pred newPred, NotificationChain msgs)
  {
    Pred oldPred = pred;
    pred = newPred;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AslPackage.DIRECTIVE__PRED, oldPred, newPred);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setPred(Pred newPred)
  {
    if (newPred != pred)
    {
      NotificationChain msgs = null;
      if (pred != null)
        msgs = ((InternalEObject)pred).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AslPackage.DIRECTIVE__PRED, null, msgs);
      if (newPred != null)
        msgs = ((InternalEObject)newPred).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AslPackage.DIRECTIVE__PRED, null, msgs);
      msgs = basicSetPred(newPred, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AslPackage.DIRECTIVE__PRED, newPred, newPred));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Agent getAgent()
  {
    return agent;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetAgent(Agent newAgent, NotificationChain msgs)
  {
    Agent oldAgent = agent;
    agent = newAgent;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AslPackage.DIRECTIVE__AGENT, oldAgent, newAgent);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setAgent(Agent newAgent)
  {
    if (newAgent != agent)
    {
      NotificationChain msgs = null;
      if (agent != null)
        msgs = ((InternalEObject)agent).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AslPackage.DIRECTIVE__AGENT, null, msgs);
      if (newAgent != null)
        msgs = ((InternalEObject)newAgent).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AslPackage.DIRECTIVE__AGENT, null, msgs);
      msgs = basicSetAgent(newAgent, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AslPackage.DIRECTIVE__AGENT, newAgent, newAgent));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Pred getPred2()
  {
    return pred2;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetPred2(Pred newPred2, NotificationChain msgs)
  {
    Pred oldPred2 = pred2;
    pred2 = newPred2;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AslPackage.DIRECTIVE__PRED2, oldPred2, newPred2);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setPred2(Pred newPred2)
  {
    if (newPred2 != pred2)
    {
      NotificationChain msgs = null;
      if (pred2 != null)
        msgs = ((InternalEObject)pred2).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AslPackage.DIRECTIVE__PRED2, null, msgs);
      if (newPred2 != null)
        msgs = ((InternalEObject)newPred2).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AslPackage.DIRECTIVE__PRED2, null, msgs);
      msgs = basicSetPred2(newPred2, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AslPackage.DIRECTIVE__PRED2, newPred2, newPred2));
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
      case AslPackage.DIRECTIVE__PRED:
        return basicSetPred(null, msgs);
      case AslPackage.DIRECTIVE__AGENT:
        return basicSetAgent(null, msgs);
      case AslPackage.DIRECTIVE__PRED2:
        return basicSetPred2(null, msgs);
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
      case AslPackage.DIRECTIVE__TK_BEGIN:
        return getTk_begin();
      case AslPackage.DIRECTIVE__PRED:
        return getPred();
      case AslPackage.DIRECTIVE__AGENT:
        return getAgent();
      case AslPackage.DIRECTIVE__PRED2:
        return getPred2();
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
      case AslPackage.DIRECTIVE__TK_BEGIN:
        setTk_begin((String)newValue);
        return;
      case AslPackage.DIRECTIVE__PRED:
        setPred((Pred)newValue);
        return;
      case AslPackage.DIRECTIVE__AGENT:
        setAgent((Agent)newValue);
        return;
      case AslPackage.DIRECTIVE__PRED2:
        setPred2((Pred)newValue);
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
      case AslPackage.DIRECTIVE__TK_BEGIN:
        setTk_begin(TK_BEGIN_EDEFAULT);
        return;
      case AslPackage.DIRECTIVE__PRED:
        setPred((Pred)null);
        return;
      case AslPackage.DIRECTIVE__AGENT:
        setAgent((Agent)null);
        return;
      case AslPackage.DIRECTIVE__PRED2:
        setPred2((Pred)null);
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
      case AslPackage.DIRECTIVE__TK_BEGIN:
        return TK_BEGIN_EDEFAULT == null ? tk_begin != null : !TK_BEGIN_EDEFAULT.equals(tk_begin);
      case AslPackage.DIRECTIVE__PRED:
        return pred != null;
      case AslPackage.DIRECTIVE__AGENT:
        return agent != null;
      case AslPackage.DIRECTIVE__PRED2:
        return pred2 != null;
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
    result.append(" (tk_begin: ");
    result.append(tk_begin);
    result.append(')');
    return result.toString();
  }

} //DirectiveImpl
