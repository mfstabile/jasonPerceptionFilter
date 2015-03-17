/**
 * <copyright>
 * </copyright>
 *
 */
package jasonide.xtext.asl.asl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Term</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link jasonide.xtext.asl.asl.Term#getList <em>List</em>}</li>
 *   <li>{@link jasonide.xtext.asl.asl.Term#getPlan_term <em>Plan term</em>}</li>
 *   <li>{@link jasonide.xtext.asl.asl.Term#getLog_expr <em>Log expr</em>}</li>
 * </ul>
 * </p>
 *
 * @see jasonide.xtext.asl.asl.AslPackage#getTerm()
 * @model
 * @generated
 */
public interface Term extends EObject
{
  /**
   * Returns the value of the '<em><b>List</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>List</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>List</em>' containment reference.
   * @see #setList(List)
   * @see jasonide.xtext.asl.asl.AslPackage#getTerm_List()
   * @model containment="true"
   * @generated
   */
  List getList();

  /**
   * Sets the value of the '{@link jasonide.xtext.asl.asl.Term#getList <em>List</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>List</em>' containment reference.
   * @see #getList()
   * @generated
   */
  void setList(List value);

  /**
   * Returns the value of the '<em><b>Plan term</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Plan term</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Plan term</em>' containment reference.
   * @see #setPlan_term(Plan_term)
   * @see jasonide.xtext.asl.asl.AslPackage#getTerm_Plan_term()
   * @model containment="true"
   * @generated
   */
  Plan_term getPlan_term();

  /**
   * Sets the value of the '{@link jasonide.xtext.asl.asl.Term#getPlan_term <em>Plan term</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Plan term</em>' containment reference.
   * @see #getPlan_term()
   * @generated
   */
  void setPlan_term(Plan_term value);

  /**
   * Returns the value of the '<em><b>Log expr</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Log expr</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Log expr</em>' containment reference.
   * @see #setLog_expr(Log_expr)
   * @see jasonide.xtext.asl.asl.AslPackage#getTerm_Log_expr()
   * @model containment="true"
   * @generated
   */
  Log_expr getLog_expr();

  /**
   * Sets the value of the '{@link jasonide.xtext.asl.asl.Term#getLog_expr <em>Log expr</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Log expr</em>' containment reference.
   * @see #getLog_expr()
   * @generated
   */
  void setLog_expr(Log_expr value);

} // Term
