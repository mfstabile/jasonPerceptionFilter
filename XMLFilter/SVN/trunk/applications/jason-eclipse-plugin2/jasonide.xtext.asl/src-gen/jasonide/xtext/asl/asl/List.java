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
 * A representation of the model object '<em><b>List</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link jasonide.xtext.asl.asl.List#getTerm_in_list <em>Term in list</em>}</li>
 *   <li>{@link jasonide.xtext.asl.asl.List#getVar <em>Var</em>}</li>
 *   <li>{@link jasonide.xtext.asl.asl.List#getUnnamedvar <em>Unnamedvar</em>}</li>
 *   <li>{@link jasonide.xtext.asl.asl.List#getList <em>List</em>}</li>
 * </ul>
 * </p>
 *
 * @see jasonide.xtext.asl.asl.AslPackage#getList()
 * @model
 * @generated
 */
public interface List extends EObject
{
  /**
   * Returns the value of the '<em><b>Term in list</b></em>' containment reference list.
   * The list contents are of type {@link jasonide.xtext.asl.asl.Term_in_list}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Term in list</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Term in list</em>' containment reference list.
   * @see jasonide.xtext.asl.asl.AslPackage#getList_Term_in_list()
   * @model containment="true"
   * @generated
   */
  EList<Term_in_list> getTerm_in_list();

  /**
   * Returns the value of the '<em><b>Var</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Var</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Var</em>' attribute.
   * @see #setVar(String)
   * @see jasonide.xtext.asl.asl.AslPackage#getList_Var()
   * @model
   * @generated
   */
  String getVar();

  /**
   * Sets the value of the '{@link jasonide.xtext.asl.asl.List#getVar <em>Var</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Var</em>' attribute.
   * @see #getVar()
   * @generated
   */
  void setVar(String value);

  /**
   * Returns the value of the '<em><b>Unnamedvar</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Unnamedvar</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Unnamedvar</em>' attribute.
   * @see #setUnnamedvar(String)
   * @see jasonide.xtext.asl.asl.AslPackage#getList_Unnamedvar()
   * @model
   * @generated
   */
  String getUnnamedvar();

  /**
   * Sets the value of the '{@link jasonide.xtext.asl.asl.List#getUnnamedvar <em>Unnamedvar</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Unnamedvar</em>' attribute.
   * @see #getUnnamedvar()
   * @generated
   */
  void setUnnamedvar(String value);

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
   * @see jasonide.xtext.asl.asl.AslPackage#getList_List()
   * @model containment="true"
   * @generated
   */
  List getList();

  /**
   * Sets the value of the '{@link jasonide.xtext.asl.asl.List#getList <em>List</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>List</em>' containment reference.
   * @see #getList()
   * @generated
   */
  void setList(List value);

} // List
