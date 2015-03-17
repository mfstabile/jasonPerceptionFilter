/**
 * <copyright>
 * </copyright>
 *
 */
package jasonide.xtext.asl.asl;

import java.lang.String;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Number</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link jasonide.xtext.asl.asl.Number#getNumber <em>Number</em>}</li>
 *   <li>{@link jasonide.xtext.asl.asl.Number#getDecimalPart <em>Decimal Part</em>}</li>
 * </ul>
 * </p>
 *
 * @see jasonide.xtext.asl.asl.AslPackage#getNumber()
 * @model
 * @generated
 */
public interface Number extends EObject
{
  /**
   * Returns the value of the '<em><b>Number</b></em>' attribute list.
   * The list contents are of type {@link java.lang.String}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Number</em>' attribute list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Number</em>' attribute list.
   * @see jasonide.xtext.asl.asl.AslPackage#getNumber_Number()
   * @model unique="false"
   * @generated
   */
  EList<String> getNumber();

  /**
   * Returns the value of the '<em><b>Decimal Part</b></em>' attribute list.
   * The list contents are of type {@link java.lang.String}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Decimal Part</em>' attribute list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Decimal Part</em>' attribute list.
   * @see jasonide.xtext.asl.asl.AslPackage#getNumber_DecimalPart()
   * @model unique="false"
   * @generated
   */
  EList<String> getDecimalPart();

} // Number
