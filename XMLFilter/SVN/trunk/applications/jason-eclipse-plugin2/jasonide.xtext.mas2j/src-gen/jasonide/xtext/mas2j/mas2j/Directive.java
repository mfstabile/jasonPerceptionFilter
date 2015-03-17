/**
 * <copyright>
 * </copyright>
 *
 */
package jasonide.xtext.mas2j.mas2j;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Directive</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link jasonide.xtext.mas2j.mas2j.Directive#getDirective <em>Directive</em>}</li>
 *   <li>{@link jasonide.xtext.mas2j.mas2j.Directive#getClsDirective <em>Cls Directive</em>}</li>
 * </ul>
 * </p>
 *
 * @see jasonide.xtext.mas2j.mas2j.Mas2jPackage#getDirective()
 * @model
 * @generated
 */
public interface Directive extends EObject
{
  /**
   * Returns the value of the '<em><b>Directive</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Directive</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Directive</em>' attribute.
   * @see #setDirective(String)
   * @see jasonide.xtext.mas2j.mas2j.Mas2jPackage#getDirective_Directive()
   * @model
   * @generated
   */
  String getDirective();

  /**
   * Sets the value of the '{@link jasonide.xtext.mas2j.mas2j.Directive#getDirective <em>Directive</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Directive</em>' attribute.
   * @see #getDirective()
   * @generated
   */
  void setDirective(String value);

  /**
   * Returns the value of the '<em><b>Cls Directive</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Cls Directive</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Cls Directive</em>' containment reference.
   * @see #setClsDirective(ClsDef)
   * @see jasonide.xtext.mas2j.mas2j.Mas2jPackage#getDirective_ClsDirective()
   * @model containment="true"
   * @generated
   */
  ClsDef getClsDirective();

  /**
   * Sets the value of the '{@link jasonide.xtext.mas2j.mas2j.Directive#getClsDirective <em>Cls Directive</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Cls Directive</em>' containment reference.
   * @see #getClsDirective()
   * @generated
   */
  void setClsDirective(ClsDef value);

} // Directive
