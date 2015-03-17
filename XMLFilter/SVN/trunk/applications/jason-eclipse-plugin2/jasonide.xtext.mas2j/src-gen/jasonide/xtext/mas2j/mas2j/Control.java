/**
 * <copyright>
 * </copyright>
 *
 */
package jasonide.xtext.mas2j.mas2j;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Control</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link jasonide.xtext.mas2j.mas2j.Control#getControl <em>Control</em>}</li>
 *   <li>{@link jasonide.xtext.mas2j.mas2j.Control#getControlLocus <em>Control Locus</em>}</li>
 * </ul>
 * </p>
 *
 * @see jasonide.xtext.mas2j.mas2j.Mas2jPackage#getControl()
 * @model
 * @generated
 */
public interface Control extends EObject
{
  /**
   * Returns the value of the '<em><b>Control</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Control</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Control</em>' containment reference.
   * @see #setControl(ClsDef)
   * @see jasonide.xtext.mas2j.mas2j.Mas2jPackage#getControl_Control()
   * @model containment="true"
   * @generated
   */
  ClsDef getControl();

  /**
   * Sets the value of the '{@link jasonide.xtext.mas2j.mas2j.Control#getControl <em>Control</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Control</em>' containment reference.
   * @see #getControl()
   * @generated
   */
  void setControl(ClsDef value);

  /**
   * Returns the value of the '<em><b>Control Locus</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Control Locus</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Control Locus</em>' attribute.
   * @see #setControlLocus(String)
   * @see jasonide.xtext.mas2j.mas2j.Mas2jPackage#getControl_ControlLocus()
   * @model
   * @generated
   */
  String getControlLocus();

  /**
   * Sets the value of the '{@link jasonide.xtext.mas2j.mas2j.Control#getControlLocus <em>Control Locus</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Control Locus</em>' attribute.
   * @see #getControlLocus()
   * @generated
   */
  void setControlLocus(String value);

} // Control
