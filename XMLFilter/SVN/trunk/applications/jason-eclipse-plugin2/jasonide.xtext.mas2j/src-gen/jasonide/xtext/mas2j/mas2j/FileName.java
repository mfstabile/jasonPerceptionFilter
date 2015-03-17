/**
 * <copyright>
 * </copyright>
 *
 */
package jasonide.xtext.mas2j.mas2j;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>File Name</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link jasonide.xtext.mas2j.mas2j.FileName#getPath <em>Path</em>}</li>
 *   <li>{@link jasonide.xtext.mas2j.mas2j.FileName#getAsid <em>Asid</em>}</li>
 * </ul>
 * </p>
 *
 * @see jasonide.xtext.mas2j.mas2j.Mas2jPackage#getFileName()
 * @model
 * @generated
 */
public interface FileName extends EObject
{
  /**
   * Returns the value of the '<em><b>Path</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Path</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Path</em>' attribute.
   * @see #setPath(String)
   * @see jasonide.xtext.mas2j.mas2j.Mas2jPackage#getFileName_Path()
   * @model
   * @generated
   */
  String getPath();

  /**
   * Sets the value of the '{@link jasonide.xtext.mas2j.mas2j.FileName#getPath <em>Path</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Path</em>' attribute.
   * @see #getPath()
   * @generated
   */
  void setPath(String value);

  /**
   * Returns the value of the '<em><b>Asid</b></em>' attribute list.
   * The list contents are of type {@link java.lang.String}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Asid</em>' attribute list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Asid</em>' attribute list.
   * @see jasonide.xtext.mas2j.mas2j.Mas2jPackage#getFileName_Asid()
   * @model unique="false"
   * @generated
   */
  EList<String> getAsid();

} // FileName
