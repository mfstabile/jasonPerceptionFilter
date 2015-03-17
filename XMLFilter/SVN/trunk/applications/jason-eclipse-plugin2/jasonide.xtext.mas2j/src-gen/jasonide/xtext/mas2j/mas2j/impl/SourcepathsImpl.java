/**
 * <copyright>
 * </copyright>
 *
 */
package jasonide.xtext.mas2j.mas2j.impl;

import jasonide.xtext.mas2j.mas2j.Mas2jPackage;
import jasonide.xtext.mas2j.mas2j.Sourcepath;
import jasonide.xtext.mas2j.mas2j.Sourcepaths;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Sourcepaths</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link jasonide.xtext.mas2j.mas2j.impl.SourcepathsImpl#getSourcepath <em>Sourcepath</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SourcepathsImpl extends MinimalEObjectImpl.Container implements Sourcepaths
{
  /**
   * The cached value of the '{@link #getSourcepath() <em>Sourcepath</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSourcepath()
   * @generated
   * @ordered
   */
  protected EList<Sourcepath> sourcepath;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected SourcepathsImpl()
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
    return Mas2jPackage.Literals.SOURCEPATHS;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<Sourcepath> getSourcepath()
  {
    if (sourcepath == null)
    {
      sourcepath = new EObjectContainmentEList<Sourcepath>(Sourcepath.class, this, Mas2jPackage.SOURCEPATHS__SOURCEPATH);
    }
    return sourcepath;
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
      case Mas2jPackage.SOURCEPATHS__SOURCEPATH:
        return ((InternalEList<?>)getSourcepath()).basicRemove(otherEnd, msgs);
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
      case Mas2jPackage.SOURCEPATHS__SOURCEPATH:
        return getSourcepath();
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
      case Mas2jPackage.SOURCEPATHS__SOURCEPATH:
        getSourcepath().clear();
        getSourcepath().addAll((Collection<? extends Sourcepath>)newValue);
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
      case Mas2jPackage.SOURCEPATHS__SOURCEPATH:
        getSourcepath().clear();
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
      case Mas2jPackage.SOURCEPATHS__SOURCEPATH:
        return sourcepath != null && !sourcepath.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //SourcepathsImpl
