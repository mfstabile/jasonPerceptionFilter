/**
 * <copyright>
 * </copyright>
 *
 */
package jasonide.xtext.mas2j.mas2j;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Agent Class</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link jasonide.xtext.mas2j.mas2j.AgentClass#getAgentClass <em>Agent Class</em>}</li>
 * </ul>
 * </p>
 *
 * @see jasonide.xtext.mas2j.mas2j.Mas2jPackage#getAgentClass()
 * @model
 * @generated
 */
public interface AgentClass extends EObject
{
  /**
   * Returns the value of the '<em><b>Agent Class</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Agent Class</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Agent Class</em>' containment reference.
   * @see #setAgentClass(ClsDef)
   * @see jasonide.xtext.mas2j.mas2j.Mas2jPackage#getAgentClass_AgentClass()
   * @model containment="true"
   * @generated
   */
  ClsDef getAgentClass();

  /**
   * Sets the value of the '{@link jasonide.xtext.mas2j.mas2j.AgentClass#getAgentClass <em>Agent Class</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Agent Class</em>' containment reference.
   * @see #getAgentClass()
   * @generated
   */
  void setAgentClass(ClsDef value);

} // AgentClass
