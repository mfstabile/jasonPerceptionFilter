/**
 * <copyright>
 * </copyright>
 *
 */
package jasonide.xtext.asl.asl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Log expr</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link jasonide.xtext.asl.asl.Log_expr#getLog_expr_trm <em>Log expr trm</em>}</li>
 *   <li>{@link jasonide.xtext.asl.asl.Log_expr#getLog_expr <em>Log expr</em>}</li>
 * </ul>
 * </p>
 *
 * @see jasonide.xtext.asl.asl.AslPackage#getLog_expr()
 * @model
 * @generated
 */
public interface Log_expr extends EObject
{
  /**
   * Returns the value of the '<em><b>Log expr trm</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Log expr trm</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Log expr trm</em>' containment reference.
   * @see #setLog_expr_trm(Log_expr_trm)
   * @see jasonide.xtext.asl.asl.AslPackage#getLog_expr_Log_expr_trm()
   * @model containment="true"
   * @generated
   */
  Log_expr_trm getLog_expr_trm();

  /**
   * Sets the value of the '{@link jasonide.xtext.asl.asl.Log_expr#getLog_expr_trm <em>Log expr trm</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Log expr trm</em>' containment reference.
   * @see #getLog_expr_trm()
   * @generated
   */
  void setLog_expr_trm(Log_expr_trm value);

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
   * @see jasonide.xtext.asl.asl.AslPackage#getLog_expr_Log_expr()
   * @model containment="true"
   * @generated
   */
  Log_expr getLog_expr();

  /**
   * Sets the value of the '{@link jasonide.xtext.asl.asl.Log_expr#getLog_expr <em>Log expr</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Log expr</em>' containment reference.
   * @see #getLog_expr()
   * @generated
   */
  void setLog_expr(Log_expr value);

} // Log_expr
