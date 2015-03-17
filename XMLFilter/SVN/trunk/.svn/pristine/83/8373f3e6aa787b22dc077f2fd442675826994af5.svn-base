/**
 * <copyright>
 * </copyright>
 *
 */
package jasonide.xtext.asl.asl.impl;

import jasonide.xtext.asl.asl.AslPackage;

import java.lang.String;

import java.util.Collection;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EDataTypeEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Number</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link jasonide.xtext.asl.asl.impl.NumberImpl#getNumber <em>Number</em>}</li>
 *   <li>{@link jasonide.xtext.asl.asl.impl.NumberImpl#getDecimalPart <em>Decimal Part</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class NumberImpl extends MinimalEObjectImpl.Container implements jasonide.xtext.asl.asl.Number
{
  /**
   * The cached value of the '{@link #getNumber() <em>Number</em>}' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getNumber()
   * @generated
   * @ordered
   */
  protected EList<String> number;

  /**
   * The cached value of the '{@link #getDecimalPart() <em>Decimal Part</em>}' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDecimalPart()
   * @generated
   * @ordered
   */
  protected EList<String> decimalPart;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected NumberImpl()
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
    return AslPackage.Literals.NUMBER;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<String> getNumber()
  {
    if (number == null)
    {
      number = new EDataTypeEList<String>(String.class, this, AslPackage.NUMBER__NUMBER);
    }
    return number;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<String> getDecimalPart()
  {
    if (decimalPart == null)
    {
      decimalPart = new EDataTypeEList<String>(String.class, this, AslPackage.NUMBER__DECIMAL_PART);
    }
    return decimalPart;
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
      case AslPackage.NUMBER__NUMBER:
        return getNumber();
      case AslPackage.NUMBER__DECIMAL_PART:
        return getDecimalPart();
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
      case AslPackage.NUMBER__NUMBER:
        getNumber().clear();
        getNumber().addAll((Collection<? extends String>)newValue);
        return;
      case AslPackage.NUMBER__DECIMAL_PART:
        getDecimalPart().clear();
        getDecimalPart().addAll((Collection<? extends String>)newValue);
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
      case AslPackage.NUMBER__NUMBER:
        getNumber().clear();
        return;
      case AslPackage.NUMBER__DECIMAL_PART:
        getDecimalPart().clear();
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
      case AslPackage.NUMBER__NUMBER:
        return number != null && !number.isEmpty();
      case AslPackage.NUMBER__DECIMAL_PART:
        return decimalPart != null && !decimalPart.isEmpty();
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
    result.append(" (number: ");
    result.append(number);
    result.append(", decimalPart: ");
    result.append(decimalPart);
    result.append(')');
    return result.toString();
  }

} //NumberImpl
