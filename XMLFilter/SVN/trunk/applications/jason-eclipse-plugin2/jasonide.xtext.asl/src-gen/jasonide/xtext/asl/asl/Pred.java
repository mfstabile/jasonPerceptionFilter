/**
 * <copyright>
 * </copyright>
 *
 */
package jasonide.xtext.asl.asl;

import java.lang.String;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Pred</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link jasonide.xtext.asl.asl.Pred#getAtom <em>Atom</em>}</li>
 *   <li>{@link jasonide.xtext.asl.asl.Pred#getTk_begin <em>Tk begin</em>}</li>
 *   <li>{@link jasonide.xtext.asl.asl.Pred#getTk_end <em>Tk end</em>}</li>
 *   <li>{@link jasonide.xtext.asl.asl.Pred#getTerms <em>Terms</em>}</li>
 *   <li>{@link jasonide.xtext.asl.asl.Pred#getPlan_term <em>Plan term</em>}</li>
 *   <li>{@link jasonide.xtext.asl.asl.Pred#getList <em>List</em>}</li>
 * </ul>
 * </p>
 *
 * @see jasonide.xtext.asl.asl.AslPackage#getPred()
 * @model
 * @generated
 */
public interface Pred extends EObject
{
  /**
   * Returns the value of the '<em><b>Atom</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Atom</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Atom</em>' attribute.
   * @see #setAtom(String)
   * @see jasonide.xtext.asl.asl.AslPackage#getPred_Atom()
   * @model
   * @generated
   */
  String getAtom();

  /**
   * Sets the value of the '{@link jasonide.xtext.asl.asl.Pred#getAtom <em>Atom</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Atom</em>' attribute.
   * @see #getAtom()
   * @generated
   */
  void setAtom(String value);

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
   * @see jasonide.xtext.asl.asl.AslPackage#getPred_Tk_begin()
   * @model
   * @generated
   */
  String getTk_begin();

  /**
   * Sets the value of the '{@link jasonide.xtext.asl.asl.Pred#getTk_begin <em>Tk begin</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Tk begin</em>' attribute.
   * @see #getTk_begin()
   * @generated
   */
  void setTk_begin(String value);

  /**
   * Returns the value of the '<em><b>Tk end</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Tk end</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Tk end</em>' attribute.
   * @see #setTk_end(String)
   * @see jasonide.xtext.asl.asl.AslPackage#getPred_Tk_end()
   * @model
   * @generated
   */
  String getTk_end();

  /**
   * Sets the value of the '{@link jasonide.xtext.asl.asl.Pred#getTk_end <em>Tk end</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Tk end</em>' attribute.
   * @see #getTk_end()
   * @generated
   */
  void setTk_end(String value);

  /**
   * Returns the value of the '<em><b>Terms</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Terms</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Terms</em>' containment reference.
   * @see #setTerms(Terms)
   * @see jasonide.xtext.asl.asl.AslPackage#getPred_Terms()
   * @model containment="true"
   * @generated
   */
  Terms getTerms();

  /**
   * Sets the value of the '{@link jasonide.xtext.asl.asl.Pred#getTerms <em>Terms</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Terms</em>' containment reference.
   * @see #getTerms()
   * @generated
   */
  void setTerms(Terms value);

  /**
   * Returns the value of the '<em><b>Plan term</b></em>' containment reference list.
   * The list contents are of type {@link jasonide.xtext.asl.asl.Plan_term}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Plan term</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Plan term</em>' containment reference list.
   * @see jasonide.xtext.asl.asl.AslPackage#getPred_Plan_term()
   * @model containment="true"
   * @generated
   */
  EList<Plan_term> getPlan_term();

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
   * @see jasonide.xtext.asl.asl.AslPackage#getPred_List()
   * @model containment="true"
   * @generated
   */
  List getList();

  /**
   * Sets the value of the '{@link jasonide.xtext.asl.asl.Pred#getList <em>List</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>List</em>' containment reference.
   * @see #getList()
   * @generated
   */
  void setList(List value);

} // Pred
