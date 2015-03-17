/**
 * <copyright>
 * </copyright>
 *
 */
package jasonide.xtext.mas2j.mas2j.impl;

import jasonide.xtext.mas2j.mas2j.Mas2jPackage;
import jasonide.xtext.mas2j.mas2j.ParameterClsDef;

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
 * An implementation of the model object '<em><b>Parameter Cls Def</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link jasonide.xtext.mas2j.mas2j.impl.ParameterClsDefImpl#getParameterclsint <em>Parameterclsint</em>}</li>
 *   <li>{@link jasonide.xtext.mas2j.mas2j.impl.ParameterClsDefImpl#getParameterclsstr <em>Parameterclsstr</em>}</li>
 *   <li>{@link jasonide.xtext.mas2j.mas2j.impl.ParameterClsDefImpl#getParameter <em>Parameter</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ParameterClsDefImpl extends MinimalEObjectImpl.Container implements ParameterClsDef
{
  /**
   * The default value of the '{@link #getParameterclsint() <em>Parameterclsint</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getParameterclsint()
   * @generated
   * @ordered
   */
  protected static final int PARAMETERCLSINT_EDEFAULT = 0;

  /**
   * The cached value of the '{@link #getParameterclsint() <em>Parameterclsint</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getParameterclsint()
   * @generated
   * @ordered
   */
  protected int parameterclsint = PARAMETERCLSINT_EDEFAULT;

  /**
   * The default value of the '{@link #getParameterclsstr() <em>Parameterclsstr</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getParameterclsstr()
   * @generated
   * @ordered
   */
  protected static final String PARAMETERCLSSTR_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getParameterclsstr() <em>Parameterclsstr</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getParameterclsstr()
   * @generated
   * @ordered
   */
  protected String parameterclsstr = PARAMETERCLSSTR_EDEFAULT;

  /**
   * The cached value of the '{@link #getParameter() <em>Parameter</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getParameter()
   * @generated
   * @ordered
   */
  protected EList<ParameterClsDef> parameter;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ParameterClsDefImpl()
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
    return Mas2jPackage.Literals.PARAMETER_CLS_DEF;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public int getParameterclsint()
  {
    return parameterclsint;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setParameterclsint(int newParameterclsint)
  {
    int oldParameterclsint = parameterclsint;
    parameterclsint = newParameterclsint;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, Mas2jPackage.PARAMETER_CLS_DEF__PARAMETERCLSINT, oldParameterclsint, parameterclsint));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getParameterclsstr()
  {
    return parameterclsstr;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setParameterclsstr(String newParameterclsstr)
  {
    String oldParameterclsstr = parameterclsstr;
    parameterclsstr = newParameterclsstr;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, Mas2jPackage.PARAMETER_CLS_DEF__PARAMETERCLSSTR, oldParameterclsstr, parameterclsstr));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<ParameterClsDef> getParameter()
  {
    if (parameter == null)
    {
      parameter = new EObjectContainmentEList<ParameterClsDef>(ParameterClsDef.class, this, Mas2jPackage.PARAMETER_CLS_DEF__PARAMETER);
    }
    return parameter;
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
      case Mas2jPackage.PARAMETER_CLS_DEF__PARAMETER:
        return ((InternalEList<?>)getParameter()).basicRemove(otherEnd, msgs);
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
      case Mas2jPackage.PARAMETER_CLS_DEF__PARAMETERCLSINT:
        return getParameterclsint();
      case Mas2jPackage.PARAMETER_CLS_DEF__PARAMETERCLSSTR:
        return getParameterclsstr();
      case Mas2jPackage.PARAMETER_CLS_DEF__PARAMETER:
        return getParameter();
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
      case Mas2jPackage.PARAMETER_CLS_DEF__PARAMETERCLSINT:
        setParameterclsint((Integer)newValue);
        return;
      case Mas2jPackage.PARAMETER_CLS_DEF__PARAMETERCLSSTR:
        setParameterclsstr((String)newValue);
        return;
      case Mas2jPackage.PARAMETER_CLS_DEF__PARAMETER:
        getParameter().clear();
        getParameter().addAll((Collection<? extends ParameterClsDef>)newValue);
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
      case Mas2jPackage.PARAMETER_CLS_DEF__PARAMETERCLSINT:
        setParameterclsint(PARAMETERCLSINT_EDEFAULT);
        return;
      case Mas2jPackage.PARAMETER_CLS_DEF__PARAMETERCLSSTR:
        setParameterclsstr(PARAMETERCLSSTR_EDEFAULT);
        return;
      case Mas2jPackage.PARAMETER_CLS_DEF__PARAMETER:
        getParameter().clear();
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
      case Mas2jPackage.PARAMETER_CLS_DEF__PARAMETERCLSINT:
        return parameterclsint != PARAMETERCLSINT_EDEFAULT;
      case Mas2jPackage.PARAMETER_CLS_DEF__PARAMETERCLSSTR:
        return PARAMETERCLSSTR_EDEFAULT == null ? parameterclsstr != null : !PARAMETERCLSSTR_EDEFAULT.equals(parameterclsstr);
      case Mas2jPackage.PARAMETER_CLS_DEF__PARAMETER:
        return parameter != null && !parameter.isEmpty();
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
    result.append(" (parameterclsint: ");
    result.append(parameterclsint);
    result.append(", parameterclsstr: ");
    result.append(parameterclsstr);
    result.append(')');
    return result.toString();
  }

} //ParameterClsDefImpl
