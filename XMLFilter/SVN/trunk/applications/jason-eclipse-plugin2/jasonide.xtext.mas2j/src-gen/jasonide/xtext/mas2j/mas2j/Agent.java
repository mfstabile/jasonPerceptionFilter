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
 * A representation of the model object '<em><b>Agent</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link jasonide.xtext.mas2j.mas2j.Agent#getName <em>Name</em>}</li>
 *   <li>{@link jasonide.xtext.mas2j.mas2j.Agent#getSourceFile <em>Source File</em>}</li>
 *   <li>{@link jasonide.xtext.mas2j.mas2j.Agent#getOptions <em>Options</em>}</li>
 *   <li>{@link jasonide.xtext.mas2j.mas2j.Agent#getAgentArchClass <em>Agent Arch Class</em>}</li>
 *   <li>{@link jasonide.xtext.mas2j.mas2j.Agent#getBeliefBaseClass <em>Belief Base Class</em>}</li>
 *   <li>{@link jasonide.xtext.mas2j.mas2j.Agent#getAgentClass <em>Agent Class</em>}</li>
 *   <li>{@link jasonide.xtext.mas2j.mas2j.Agent#getInstances <em>Instances</em>}</li>
 *   <li>{@link jasonide.xtext.mas2j.mas2j.Agent#getEnvironment <em>Environment</em>}</li>
 * </ul>
 * </p>
 *
 * @see jasonide.xtext.mas2j.mas2j.Mas2jPackage#getAgent()
 * @model
 * @generated
 */
public interface Agent extends EObject
{
  /**
   * Returns the value of the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Name</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Name</em>' attribute.
   * @see #setName(String)
   * @see jasonide.xtext.mas2j.mas2j.Mas2jPackage#getAgent_Name()
   * @model
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link jasonide.xtext.mas2j.mas2j.Agent#getName <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' attribute.
   * @see #getName()
   * @generated
   */
  void setName(String value);

  /**
   * Returns the value of the '<em><b>Source File</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Source File</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Source File</em>' containment reference.
   * @see #setSourceFile(FileName)
   * @see jasonide.xtext.mas2j.mas2j.Mas2jPackage#getAgent_SourceFile()
   * @model containment="true"
   * @generated
   */
  FileName getSourceFile();

  /**
   * Sets the value of the '{@link jasonide.xtext.mas2j.mas2j.Agent#getSourceFile <em>Source File</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Source File</em>' containment reference.
   * @see #getSourceFile()
   * @generated
   */
  void setSourceFile(FileName value);

  /**
   * Returns the value of the '<em><b>Options</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Options</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Options</em>' containment reference.
   * @see #setOptions(Options)
   * @see jasonide.xtext.mas2j.mas2j.Mas2jPackage#getAgent_Options()
   * @model containment="true"
   * @generated
   */
  Options getOptions();

  /**
   * Sets the value of the '{@link jasonide.xtext.mas2j.mas2j.Agent#getOptions <em>Options</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Options</em>' containment reference.
   * @see #getOptions()
   * @generated
   */
  void setOptions(Options value);

  /**
   * Returns the value of the '<em><b>Agent Arch Class</b></em>' containment reference list.
   * The list contents are of type {@link jasonide.xtext.mas2j.mas2j.AgentArchClass}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Agent Arch Class</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Agent Arch Class</em>' containment reference list.
   * @see jasonide.xtext.mas2j.mas2j.Mas2jPackage#getAgent_AgentArchClass()
   * @model containment="true"
   * @generated
   */
  EList<AgentArchClass> getAgentArchClass();

  /**
   * Returns the value of the '<em><b>Belief Base Class</b></em>' containment reference list.
   * The list contents are of type {@link jasonide.xtext.mas2j.mas2j.BeliefBaseClass}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Belief Base Class</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Belief Base Class</em>' containment reference list.
   * @see jasonide.xtext.mas2j.mas2j.Mas2jPackage#getAgent_BeliefBaseClass()
   * @model containment="true"
   * @generated
   */
  EList<BeliefBaseClass> getBeliefBaseClass();

  /**
   * Returns the value of the '<em><b>Agent Class</b></em>' containment reference list.
   * The list contents are of type {@link jasonide.xtext.mas2j.mas2j.AgentClass}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Agent Class</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Agent Class</em>' containment reference list.
   * @see jasonide.xtext.mas2j.mas2j.Mas2jPackage#getAgent_AgentClass()
   * @model containment="true"
   * @generated
   */
  EList<AgentClass> getAgentClass();

  /**
   * Returns the value of the '<em><b>Instances</b></em>' containment reference list.
   * The list contents are of type {@link jasonide.xtext.mas2j.mas2j.Instances}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Instances</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Instances</em>' containment reference list.
   * @see jasonide.xtext.mas2j.mas2j.Mas2jPackage#getAgent_Instances()
   * @model containment="true"
   * @generated
   */
  EList<Instances> getInstances();

  /**
   * Returns the value of the '<em><b>Environment</b></em>' containment reference list.
   * The list contents are of type {@link jasonide.xtext.mas2j.mas2j.EnvironmentLocus}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Environment</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Environment</em>' containment reference list.
   * @see jasonide.xtext.mas2j.mas2j.Mas2jPackage#getAgent_Environment()
   * @model containment="true"
   * @generated
   */
  EList<EnvironmentLocus> getEnvironment();

} // Agent
