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
 * A representation of the model object '<em><b>Rel expr</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link jasonide.xtext.asl.asl.Rel_expr#getArithm_exp <em>Arithm exp</em>}</li>
 *   <li>{@link jasonide.xtext.asl.asl.Rel_expr#getString <em>String</em>}</li>
 *   <li>{@link jasonide.xtext.asl.asl.Rel_expr#getRelOp <em>Rel Op</em>}</li>
 *   <li>{@link jasonide.xtext.asl.asl.Rel_expr#getArithm_expr <em>Arithm expr</em>}</li>
 *   <li>{@link jasonide.xtext.asl.asl.Rel_expr#getString2 <em>String2</em>}</li>
 *   <li>{@link jasonide.xtext.asl.asl.Rel_expr#getList <em>List</em>}</li>
 *   <li>{@link jasonide.xtext.asl.asl.Rel_expr#getPlan_term <em>Plan term</em>}</li>
 * </ul>
 * </p>
 *
 * @see jasonide.xtext.asl.asl.AslPackage#getRel_expr()
 * @model
 * @generated
 */
public interface Rel_expr extends EObject
{
  /**
   * Returns the value of the '<em><b>Arithm exp</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Arithm exp</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Arithm exp</em>' containment reference.
   * @see #setArithm_exp(Arithm_expr)
   * @see jasonide.xtext.asl.asl.AslPackage#getRel_expr_Arithm_exp()
   * @model containment="true"
   * @generated
   */
  Arithm_expr getArithm_exp();

  /**
   * Sets the value of the '{@link jasonide.xtext.asl.asl.Rel_expr#getArithm_exp <em>Arithm exp</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Arithm exp</em>' containment reference.
   * @see #getArithm_exp()
   * @generated
   */
  void setArithm_exp(Arithm_expr value);

  /**
   * Returns the value of the '<em><b>String</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>String</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>String</em>' containment reference.
   * @see #setString(jasonide.xtext.asl.asl.String)
   * @see jasonide.xtext.asl.asl.AslPackage#getRel_expr_String()
   * @model containment="true"
   * @generated
   */
  jasonide.xtext.asl.asl.String getString();

  /**
   * Sets the value of the '{@link jasonide.xtext.asl.asl.Rel_expr#getString <em>String</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>String</em>' containment reference.
   * @see #getString()
   * @generated
   */
  void setString(jasonide.xtext.asl.asl.String value);

  /**
   * Returns the value of the '<em><b>Rel Op</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Rel Op</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Rel Op</em>' attribute.
   * @see #setRelOp(String)
   * @see jasonide.xtext.asl.asl.AslPackage#getRel_expr_RelOp()
   * @model
   * @generated
   */
  String getRelOp();

  /**
   * Sets the value of the '{@link jasonide.xtext.asl.asl.Rel_expr#getRelOp <em>Rel Op</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Rel Op</em>' attribute.
   * @see #getRelOp()
   * @generated
   */
  void setRelOp(String value);

  /**
   * Returns the value of the '<em><b>Arithm expr</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Arithm expr</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Arithm expr</em>' containment reference.
   * @see #setArithm_expr(Arithm_expr)
   * @see jasonide.xtext.asl.asl.AslPackage#getRel_expr_Arithm_expr()
   * @model containment="true"
   * @generated
   */
  Arithm_expr getArithm_expr();

  /**
   * Sets the value of the '{@link jasonide.xtext.asl.asl.Rel_expr#getArithm_expr <em>Arithm expr</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Arithm expr</em>' containment reference.
   * @see #getArithm_expr()
   * @generated
   */
  void setArithm_expr(Arithm_expr value);

  /**
   * Returns the value of the '<em><b>String2</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>String2</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>String2</em>' containment reference.
   * @see #setString2(jasonide.xtext.asl.asl.String)
   * @see jasonide.xtext.asl.asl.AslPackage#getRel_expr_String2()
   * @model containment="true"
   * @generated
   */
  jasonide.xtext.asl.asl.String getString2();

  /**
   * Sets the value of the '{@link jasonide.xtext.asl.asl.Rel_expr#getString2 <em>String2</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>String2</em>' containment reference.
   * @see #getString2()
   * @generated
   */
  void setString2(jasonide.xtext.asl.asl.String value);

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
   * @see jasonide.xtext.asl.asl.AslPackage#getRel_expr_List()
   * @model containment="true"
   * @generated
   */
  List getList();

  /**
   * Sets the value of the '{@link jasonide.xtext.asl.asl.Rel_expr#getList <em>List</em>}' containment reference.
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
   * @see jasonide.xtext.asl.asl.AslPackage#getRel_expr_Plan_term()
   * @model containment="true"
   * @generated
   */
  Plan_term getPlan_term();

  /**
   * Sets the value of the '{@link jasonide.xtext.asl.asl.Rel_expr#getPlan_term <em>Plan term</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Plan term</em>' containment reference.
   * @see #getPlan_term()
   * @generated
   */
  void setPlan_term(Plan_term value);

} // Rel_expr
