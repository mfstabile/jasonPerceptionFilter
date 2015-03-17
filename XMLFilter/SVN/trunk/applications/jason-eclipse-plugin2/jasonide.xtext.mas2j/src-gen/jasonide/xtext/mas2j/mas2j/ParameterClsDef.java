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
 * A representation of the model object '<em><b>Parameter Cls Def</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link jasonide.xtext.mas2j.mas2j.ParameterClsDef#getParameterclsint <em>Parameterclsint</em>}</li>
 *   <li>{@link jasonide.xtext.mas2j.mas2j.ParameterClsDef#getParameterclsstr <em>Parameterclsstr</em>}</li>
 *   <li>{@link jasonide.xtext.mas2j.mas2j.ParameterClsDef#getParameter <em>Parameter</em>}</li>
 * </ul>
 * </p>
 *
 * @see jasonide.xtext.mas2j.mas2j.Mas2jPackage#getParameterClsDef()
 * @model
 * @generated
 */
public interface ParameterClsDef extends EObject
{
  /**
   * Returns the value of the '<em><b>Parameterclsint</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Parameterclsint</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Parameterclsint</em>' attribute.
   * @see #setParameterclsint(int)
   * @see jasonide.xtext.mas2j.mas2j.Mas2jPackage#getParameterClsDef_Parameterclsint()
   * @model
   * @generated
   */
  int getParameterclsint();

  /**
   * Sets the value of the '{@link jasonide.xtext.mas2j.mas2j.ParameterClsDef#getParameterclsint <em>Parameterclsint</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Parameterclsint</em>' attribute.
   * @see #getParameterclsint()
   * @generated
   */
  void setParameterclsint(int value);

  /**
   * Returns the value of the '<em><b>Parameterclsstr</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Parameterclsstr</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Parameterclsstr</em>' attribute.
   * @see #setParameterclsstr(String)
   * @see jasonide.xtext.mas2j.mas2j.Mas2jPackage#getParameterClsDef_Parameterclsstr()
   * @model
   * @generated
   */
  String getParameterclsstr();

  /**
   * Sets the value of the '{@link jasonide.xtext.mas2j.mas2j.ParameterClsDef#getParameterclsstr <em>Parameterclsstr</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Parameterclsstr</em>' attribute.
   * @see #getParameterclsstr()
   * @generated
   */
  void setParameterclsstr(String value);

  /**
   * Returns the value of the '<em><b>Parameter</b></em>' containment reference list.
   * The list contents are of type {@link jasonide.xtext.mas2j.mas2j.ParameterClsDef}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Parameter</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Parameter</em>' containment reference list.
   * @see jasonide.xtext.mas2j.mas2j.Mas2jPackage#getParameterClsDef_Parameter()
   * @model containment="true"
   * @generated
   */
  EList<ParameterClsDef> getParameter();

} // ParameterClsDef
