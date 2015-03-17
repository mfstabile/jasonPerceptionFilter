/**
 * <copyright>
 * </copyright>
 *
 */
package jasonide.xtext.asl.asl.impl;

import jasonide.xtext.asl.asl.AslPackage;
import jasonide.xtext.asl.asl.List;
import jasonide.xtext.asl.asl.Term_in_list;

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
 * An implementation of the model object '<em><b>List</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link jasonide.xtext.asl.asl.impl.ListImpl#getTerm_in_list <em>Term in list</em>}</li>
 *   <li>{@link jasonide.xtext.asl.asl.impl.ListImpl#getVar <em>Var</em>}</li>
 *   <li>{@link jasonide.xtext.asl.asl.impl.ListImpl#getUnnamedvar <em>Unnamedvar</em>}</li>
 *   <li>{@link jasonide.xtext.asl.asl.impl.ListImpl#getList <em>List</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ListImpl extends MinimalEObjectImpl.Container implements List
{
  /**
   * The cached value of the '{@link #getTerm_in_list() <em>Term in list</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTerm_in_list()
   * @generated
   * @ordered
   */
  protected EList<Term_in_list> term_in_list;

  /**
   * The default value of the '{@link #getVar() <em>Var</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getVar()
   * @generated
   * @ordered
   */
  protected static final String VAR_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getVar() <em>Var</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getVar()
   * @generated
   * @ordered
   */
  protected String var = VAR_EDEFAULT;

  /**
   * The default value of the '{@link #getUnnamedvar() <em>Unnamedvar</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getUnnamedvar()
   * @generated
   * @ordered
   */
  protected static final String UNNAMEDVAR_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getUnnamedvar() <em>Unnamedvar</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getUnnamedvar()
   * @generated
   * @ordered
   */
  protected String unnamedvar = UNNAMEDVAR_EDEFAULT;

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
  protected ListImpl()
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
    return AslPackage.Literals.LIST;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<Term_in_list> getTerm_in_list()
  {
    if (term_in_list == null)
    {
      term_in_list = new EObjectContainmentEList<Term_in_list>(Term_in_list.class, this, AslPackage.LIST__TERM_IN_LIST);
    }
    return term_in_list;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getVar()
  {
    return var;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setVar(String newVar)
  {
    String oldVar = var;
    var = newVar;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AslPackage.LIST__VAR, oldVar, var));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getUnnamedvar()
  {
    return unnamedvar;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setUnnamedvar(String newUnnamedvar)
  {
    String oldUnnamedvar = unnamedvar;
    unnamedvar = newUnnamedvar;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AslPackage.LIST__UNNAMEDVAR, oldUnnamedvar, unnamedvar));
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
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AslPackage.LIST__LIST, oldList, newList);
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
        msgs = ((InternalEObject)list).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AslPackage.LIST__LIST, null, msgs);
      if (newList != null)
        msgs = ((InternalEObject)newList).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AslPackage.LIST__LIST, null, msgs);
      msgs = basicSetList(newList, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AslPackage.LIST__LIST, newList, newList));
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
      case AslPackage.LIST__TERM_IN_LIST:
        return ((InternalEList<?>)getTerm_in_list()).basicRemove(otherEnd, msgs);
      case AslPackage.LIST__LIST:
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
      case AslPackage.LIST__TERM_IN_LIST:
        return getTerm_in_list();
      case AslPackage.LIST__VAR:
        return getVar();
      case AslPackage.LIST__UNNAMEDVAR:
        return getUnnamedvar();
      case AslPackage.LIST__LIST:
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
      case AslPackage.LIST__TERM_IN_LIST:
        getTerm_in_list().clear();
        getTerm_in_list().addAll((Collection<? extends Term_in_list>)newValue);
        return;
      case AslPackage.LIST__VAR:
        setVar((String)newValue);
        return;
      case AslPackage.LIST__UNNAMEDVAR:
        setUnnamedvar((String)newValue);
        return;
      case AslPackage.LIST__LIST:
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
      case AslPackage.LIST__TERM_IN_LIST:
        getTerm_in_list().clear();
        return;
      case AslPackage.LIST__VAR:
        setVar(VAR_EDEFAULT);
        return;
      case AslPackage.LIST__UNNAMEDVAR:
        setUnnamedvar(UNNAMEDVAR_EDEFAULT);
        return;
      case AslPackage.LIST__LIST:
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
      case AslPackage.LIST__TERM_IN_LIST:
        return term_in_list != null && !term_in_list.isEmpty();
      case AslPackage.LIST__VAR:
        return VAR_EDEFAULT == null ? var != null : !VAR_EDEFAULT.equals(var);
      case AslPackage.LIST__UNNAMEDVAR:
        return UNNAMEDVAR_EDEFAULT == null ? unnamedvar != null : !UNNAMEDVAR_EDEFAULT.equals(unnamedvar);
      case AslPackage.LIST__LIST:
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
    result.append(" (var: ");
    result.append(var);
    result.append(", unnamedvar: ");
    result.append(unnamedvar);
    result.append(')');
    return result.toString();
  }

} //ListImpl
