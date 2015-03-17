/**
 * <copyright>
 * </copyright>
 *
 */
package jasonide.xtext.asl.asl.impl;

import jasonide.xtext.asl.asl.AslPackage;
import jasonide.xtext.asl.asl.List;
import jasonide.xtext.asl.asl.Plan_term;
import jasonide.xtext.asl.asl.Pred;
import jasonide.xtext.asl.asl.Terms;

import java.lang.String;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Pred</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link jasonide.xtext.asl.asl.impl.PredImpl#getAtom <em>Atom</em>}</li>
 *   <li>{@link jasonide.xtext.asl.asl.impl.PredImpl#getTk_begin <em>Tk begin</em>}</li>
 *   <li>{@link jasonide.xtext.asl.asl.impl.PredImpl#getTk_end <em>Tk end</em>}</li>
 *   <li>{@link jasonide.xtext.asl.asl.impl.PredImpl#getTerms <em>Terms</em>}</li>
 *   <li>{@link jasonide.xtext.asl.asl.impl.PredImpl#getPlan_term <em>Plan term</em>}</li>
 *   <li>{@link jasonide.xtext.asl.asl.impl.PredImpl#getList <em>List</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PredImpl extends MinimalEObjectImpl.Container implements Pred
{
  /**
   * The default value of the '{@link #getAtom() <em>Atom</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getAtom()
   * @generated
   * @ordered
   */
  protected static final String ATOM_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getAtom() <em>Atom</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getAtom()
   * @generated
   * @ordered
   */
  protected String atom = ATOM_EDEFAULT;

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
   * The default value of the '{@link #getTk_end() <em>Tk end</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTk_end()
   * @generated
   * @ordered
   */
  protected static final String TK_END_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getTk_end() <em>Tk end</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTk_end()
   * @generated
   * @ordered
   */
  protected String tk_end = TK_END_EDEFAULT;

  /**
   * The cached value of the '{@link #getTerms() <em>Terms</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTerms()
   * @generated
   * @ordered
   */
  protected Terms terms;

  /**
   * The cached value of the '{@link #getPlan_term() <em>Plan term</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getPlan_term()
   * @generated
   * @ordered
   */
  protected EList<Plan_term> plan_term;

  /**
   * The cached value of the '{@link #getList() <em>List</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getList()
   * @generated
   * @ordered
   */
  protected List list;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected PredImpl()
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
    return AslPackage.Literals.PRED;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getAtom()
  {
    return atom;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setAtom(String newAtom)
  {
    String oldAtom = atom;
    atom = newAtom;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AslPackage.PRED__ATOM, oldAtom, atom));
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
      eNotify(new ENotificationImpl(this, Notification.SET, AslPackage.PRED__TK_BEGIN, oldTk_begin, tk_begin));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getTk_end()
  {
    return tk_end;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setTk_end(String newTk_end)
  {
    String oldTk_end = tk_end;
    tk_end = newTk_end;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AslPackage.PRED__TK_END, oldTk_end, tk_end));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Terms getTerms()
  {
    return terms;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetTerms(Terms newTerms, NotificationChain msgs)
  {
    Terms oldTerms = terms;
    terms = newTerms;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AslPackage.PRED__TERMS, oldTerms, newTerms);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setTerms(Terms newTerms)
  {
    if (newTerms != terms)
    {
      NotificationChain msgs = null;
      if (terms != null)
        msgs = ((InternalEObject)terms).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AslPackage.PRED__TERMS, null, msgs);
      if (newTerms != null)
        msgs = ((InternalEObject)newTerms).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AslPackage.PRED__TERMS, null, msgs);
      msgs = basicSetTerms(newTerms, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AslPackage.PRED__TERMS, newTerms, newTerms));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<Plan_term> getPlan_term()
  {
    if (plan_term == null)
    {
      plan_term = new EObjectContainmentEList<Plan_term>(Plan_term.class, this, AslPackage.PRED__PLAN_TERM);
    }
    return plan_term;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public List getList()
  {
    return list;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetList(List newList, NotificationChain msgs)
  {
    List oldList = list;
    list = newList;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AslPackage.PRED__LIST, oldList, newList);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setList(List newList)
  {
    if (newList != list)
    {
      NotificationChain msgs = null;
      if (list != null)
        msgs = ((InternalEObject)list).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AslPackage.PRED__LIST, null, msgs);
      if (newList != null)
        msgs = ((InternalEObject)newList).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AslPackage.PRED__LIST, null, msgs);
      msgs = basicSetList(newList, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AslPackage.PRED__LIST, newList, newList));
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
      case AslPackage.PRED__TERMS:
        return basicSetTerms(null, msgs);
      case AslPackage.PRED__PLAN_TERM:
        return ((InternalEList<?>)getPlan_term()).basicRemove(otherEnd, msgs);
      case AslPackage.PRED__LIST:
        return basicSetList(null, msgs);
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
      case AslPackage.PRED__ATOM:
        return getAtom();
      case AslPackage.PRED__TK_BEGIN:
        return getTk_begin();
      case AslPackage.PRED__TK_END:
        return getTk_end();
      case AslPackage.PRED__TERMS:
        return getTerms();
      case AslPackage.PRED__PLAN_TERM:
        return getPlan_term();
      case AslPackage.PRED__LIST:
        return getList();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @SuppressWarnings("unchecked")
  @Override
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
      case AslPackage.PRED__ATOM:
        setAtom((String)newValue);
        return;
      case AslPackage.PRED__TK_BEGIN:
        setTk_begin((String)newValue);
        return;
      case AslPackage.PRED__TK_END:
        setTk_end((String)newValue);
        return;
      case AslPackage.PRED__TERMS:
        setTerms((Terms)newValue);
        return;
      case AslPackage.PRED__PLAN_TERM:
        getPlan_term().clear();
        getPlan_term().addAll((Collection<? extends Plan_term>)newValue);
        return;
      case AslPackage.PRED__LIST:
        setList((List)newValue);
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
      case AslPackage.PRED__ATOM:
        setAtom(ATOM_EDEFAULT);
        return;
      case AslPackage.PRED__TK_BEGIN:
        setTk_begin(TK_BEGIN_EDEFAULT);
        return;
      case AslPackage.PRED__TK_END:
        setTk_end(TK_END_EDEFAULT);
        return;
      case AslPackage.PRED__TERMS:
        setTerms((Terms)null);
        return;
      case AslPackage.PRED__PLAN_TERM:
        getPlan_term().clear();
        return;
      case AslPackage.PRED__LIST:
        setList((List)null);
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
      case AslPackage.PRED__ATOM:
        return ATOM_EDEFAULT == null ? atom != null : !ATOM_EDEFAULT.equals(atom);
      case AslPackage.PRED__TK_BEGIN:
        return TK_BEGIN_EDEFAULT == null ? tk_begin != null : !TK_BEGIN_EDEFAULT.equals(tk_begin);
      case AslPackage.PRED__TK_END:
        return TK_END_EDEFAULT == null ? tk_end != null : !TK_END_EDEFAULT.equals(tk_end);
      case AslPackage.PRED__TERMS:
        return terms != null;
      case AslPackage.PRED__PLAN_TERM:
        return plan_term != null && !plan_term.isEmpty();
      case AslPackage.PRED__LIST:
        return list != null;
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
    result.append(" (atom: ");
    result.append(atom);
    result.append(", tk_begin: ");
    result.append(tk_begin);
    result.append(", tk_end: ");
    result.append(tk_end);
    result.append(')');
    return result.toString();
  }

} //PredImpl
