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
 * A representation of the model object '<em><b>Stmt WHILE</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link jasonide.xtext.asl.asl.StmtWHILE#getTk_while <em>Tk while</em>}</li>
 *   <li>{@link jasonide.xtext.asl.asl.StmtWHILE#getLog_expr <em>Log expr</em>}</li>
 *   <li>{@link jasonide.xtext.asl.asl.StmtWHILE#getPlan_term <em>Plan term</em>}</li>
 * </ul>
 * </p>
 *
 * @see jasonide.xtext.asl.asl.AslPackage#getStmtWHILE()
 * @model
 * @generated
 */
public interface StmtWHILE extends EObject
{
  /**
   * Returns the value of the '<em><b>Tk while</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Tk while</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Tk while</em>' attribute.
   * @see #setTk_while(String)
   * @see jasonide.xtext.asl.asl.AslPackage#getStmtWHILE_Tk_while()
   * @model
   * @generated
   */
  String getTk_while();

  /**
   * Sets the value of the '{@link jasonide.xtext.asl.asl.StmtWHILE#getTk_while <em>Tk while</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Tk while</em>' attribute.
   * @see #getTk_while()
   * @generated
   */
  void setTk_while(String value);

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
   * @see jasonide.xtext.asl.asl.AslPackage#getStmtWHILE_Log_expr()
   * @model containment="true"
   * @generated
   */
  Log_expr getLog_expr();

  /**
   * Sets the value of the '{@link jasonide.xtext.asl.asl.StmtWHILE#getLog_expr <em>Log expr</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Log expr</em>' containment reference.
   * @see #getLog_expr()
   * @generated
   */
  void setLog_expr(Log_expr value);

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
   * @see jasonide.xtext.asl.asl.AslPackage#getStmtWHILE_Plan_term()
   * @model containment="true"
   * @generated
   */
  Plan_term getPlan_term();

  /**
   * Sets the value of the '{@link jasonide.xtext.asl.asl.StmtWHILE#getPlan_term <em>Plan term</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Plan term</em>' containment reference.
   * @see #getPlan_term()
   * @generated
   */
  void setPlan_term(Plan_term value);

} // StmtWHILE
