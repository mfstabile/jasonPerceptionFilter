/**
 * <copyright>
 * </copyright>
 *
 */
package jasonide.xtext.asl.asl;

import java.lang.String;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Directive</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link jasonide.xtext.asl.asl.Directive#getTk_begin <em>Tk begin</em>}</li>
 *   <li>{@link jasonide.xtext.asl.asl.Directive#getPred <em>Pred</em>}</li>
 *   <li>{@link jasonide.xtext.asl.asl.Directive#getAgent <em>Agent</em>}</li>
 *   <li>{@link jasonide.xtext.asl.asl.Directive#getPred2 <em>Pred2</em>}</li>
 * </ul>
 * </p>
 *
 * @see jasonide.xtext.asl.asl.AslPackage#getDirective()
 * @model
 * @generated
 */
public interface Directive extends EObject
{
  /**
   * Returns the value of the '<em><b>Tk begin</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Tk begin</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Tk begin</em>' attribute.
   * @see #setTk_begin(String)
   * @see jasonide.xtext.asl.asl.AslPackage#getDirective_Tk_begin()
   * @model
   * @generated
   */
  String getTk_begin();

  /**
   * Sets the value of the '{@link jasonide.xtext.asl.asl.Directive#getTk_begin <em>Tk begin</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Tk begin</em>' attribute.
   * @see #getTk_begin()
   * @generated
   */
  void setTk_begin(String value);

  /**
   * Returns the value of the '<em><b>Pred</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Pred</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Pred</em>' containment reference.
   * @see #setPred(Pred)
   * @see jasonide.xtext.asl.asl.AslPackage#getDirective_Pred()
   * @model containment="true"
   * @generated
   */
  Pred getPred();

  /**
   * Sets the value of the '{@link jasonide.xtext.asl.asl.Directive#getPred <em>Pred</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Pred</em>' containment reference.
   * @see #getPred()
   * @generated
   */
  void setPred(Pred value);

  /**
   * Returns the value of the '<em><b>Agent</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Agent</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Agent</em>' containment reference.
   * @see #setAgent(Agent)
   * @see jasonide.xtext.asl.asl.AslPackage#getDirective_Agent()
   * @model containment="true"
   * @generated
   */
  Agent getAgent();

  /**
   * Sets the value of the '{@link jasonide.xtext.asl.asl.Directive#getAgent <em>Agent</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Agent</em>' containment reference.
   * @see #getAgent()
   * @generated
   */
  void setAgent(Agent value);

  /**
   * Returns the value of the '<em><b>Pred2</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Pred2</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Pred2</em>' containment reference.
   * @see #setPred2(Pred)
   * @see jasonide.xtext.asl.asl.AslPackage#getDirective_Pred2()
   * @model containment="true"
   * @generated
   */
  Pred getPred2();

  /**
   * Sets the value of the '{@link jasonide.xtext.asl.asl.Directive#getPred2 <em>Pred2</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Pred2</em>' containment reference.
   * @see #getPred2()
   * @generated
   */
  void setPred2(Pred value);

} // Directive
