/**
 * <copyright>
 * </copyright>
 *
 */
package jasonide.xtext.mas2j.mas2j.impl;

import jasonide.xtext.mas2j.mas2j.ClsDef;
import jasonide.xtext.mas2j.mas2j.Directive;
import jasonide.xtext.mas2j.mas2j.Mas2jPackage;

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
 *   <li>{@link jasonide.xtext.mas2j.mas2j.impl.DirectiveImpl#getDirective <em>Directive</em>}</li>
 *   <li>{@link jasonide.xtext.mas2j.mas2j.impl.DirectiveImpl#getClsDirective <em>Cls Directive</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class DirectiveImpl extends MinimalEObjectImpl.Container implements Directive
{
  /**
   * The default value of the '{@link #getDirective() <em>Directive</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDirective()
   * @generated
   * @ordered
   */
  protected static final String DIRECTIVE_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getDirective() <em>Directive</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDirective()
   * @generated
   * @ordered
   */
  protected String directive = DIRECTIVE_EDEFAULT;

  /**
   * The cached value of the '{@link #getClsDirective() <em>Cls Directive</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getClsDirective()
   * @generated
   * @ordered
   */
  protected ClsDef clsDirective;

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
    return Mas2jPackage.Literals.DIRECTIVE;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getDirective()
  {
    return directive;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setDirective(String newDirective)
  {
    String oldDirective = directive;
    directive = newDirective;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, Mas2jPackage.DIRECTIVE__DIRECTIVE, oldDirective, directive));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ClsDef getClsDirective()
  {
    return clsDirective;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetClsDirective(ClsDef newClsDirective, NotificationChain msgs)
  {
    ClsDef oldClsDirective = clsDirective;
    clsDirective = newClsDirective;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, Mas2jPackage.DIRECTIVE__CLS_DIRECTIVE, oldClsDirective, newClsDirective);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setClsDirective(ClsDef newClsDirective)
  {
    if (newClsDirective != clsDirective)
    {
      NotificationChain msgs = null;
      if (clsDirective != null)
        msgs = ((InternalEObject)clsDirective).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - Mas2jPackage.DIRECTIVE__CLS_DIRECTIVE, null, msgs);
      if (newClsDirective != null)
        msgs = ((InternalEObject)newClsDirective).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - Mas2jPackage.DIRECTIVE__CLS_DIRECTIVE, null, msgs);
      msgs = basicSetClsDirective(newClsDirective, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, Mas2jPackage.DIRECTIVE__CLS_DIRECTIVE, newClsDirective, newClsDirective));
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
      case Mas2jPackage.DIRECTIVE__CLS_DIRECTIVE:
        return basicSetClsDirective(null, msgs);
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
      case Mas2jPackage.DIRECTIVE__DIRECTIVE:
        return getDirective();
      case Mas2jPackage.DIRECTIVE__CLS_DIRECTIVE:
        return getClsDirective();
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
      case Mas2jPackage.DIRECTIVE__DIRECTIVE:
        setDirective((String)newValue);
        return;
      case Mas2jPackage.DIRECTIVE__CLS_DIRECTIVE:
        setClsDirective((ClsDef)newValue);
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
      case Mas2jPackage.DIRECTIVE__DIRECTIVE:
        setDirective(DIRECTIVE_EDEFAULT);
        return;
      case Mas2jPackage.DIRECTIVE__CLS_DIRECTIVE:
        setClsDirective((ClsDef)null);
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
      case Mas2jPackage.DIRECTIVE__DIRECTIVE:
        return DIRECTIVE_EDEFAULT == null ? directive != null : !DIRECTIVE_EDEFAULT.equals(directive);
      case Mas2jPackage.DIRECTIVE__CLS_DIRECTIVE:
        return clsDirective != null;
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
    result.append(" (directive: ");
    result.append(directive);
    result.append(')');
    return result.toString();
  }

} //DirectiveImpl
