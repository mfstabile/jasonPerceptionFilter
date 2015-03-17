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
 * A representation of the model object '<em><b>Literal</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link jasonide.xtext.asl.asl.Literal#getTk_neg <em>Tk neg</em>}</li>
 *   <li>{@link jasonide.xtext.asl.asl.Literal#getPred <em>Pred</em>}</li>
 *   <li>{@link jasonide.xtext.asl.asl.Literal#getTk_true <em>Tk true</em>}</li>
 *   <li>{@link jasonide.xtext.asl.asl.Literal#getTk_false <em>Tk false</em>}</li>
 * </ul>
 * </p>
 *
 * @see jasonide.xtext.asl.asl.AslPackage#getLiteral()
 * @model
 * @generated
 */
public interface Literal extends EObject
{
  /**
   * Returns the value of the '<em><b>Tk neg</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Tk neg</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Tk neg</em>' attribute.
   * @see #setTk_neg(String)
   * @see jasonide.xtext.asl.asl.AslPackage#getLiteral_Tk_neg()
   * @model
   * @generated
   */
  String getTk_neg();

  /**
   * Sets the value of the '{@link jasonide.xtext.asl.asl.Literal#getTk_neg <em>Tk neg</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Tk neg</em>' attribute.
   * @see #getTk_neg()
   * @generated
   */
  void setTk_neg(String value);

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
   * @see jasonide.xtext.asl.asl.AslPackage#getLiteral_Pred()
   * @model containment="true"
   * @generated
   */
  Pred getPred();

  /**
   * Sets the value of the '{@link jasonide.xtext.asl.asl.Literal#getPred <em>Pred</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Pred</em>' containment reference.
   * @see #getPred()
   * @generated
   */
  void setPred(Pred value);

  /**
   * Returns the value of the '<em><b>Tk true</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Tk true</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Tk true</em>' attribute.
   * @see #setTk_true(String)
   * @see jasonide.xtext.asl.asl.AslPackage#getLiteral_Tk_true()
   * @model
   * @generated
   */
  String getTk_true();

  /**
   * Sets the value of the '{@link jasonide.xtext.asl.asl.Literal#getTk_true <em>Tk true</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Tk true</em>' attribute.
   * @see #getTk_true()
   * @generated
   */
  void setTk_true(String value);

  /**
   * Returns the value of the '<em><b>Tk false</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Tk false</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Tk false</em>' attribute.
   * @see #setTk_false(String)
   * @see jasonide.xtext.asl.asl.AslPackage#getLiteral_Tk_false()
   * @model
   * @generated
   */
  String getTk_false();

  /**
   * Sets the value of the '{@link jasonide.xtext.asl.asl.Literal#getTk_false <em>Tk false</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Tk false</em>' attribute.
   * @see #getTk_false()
   * @generated
   */
  void setTk_false(String value);

} // Literal
