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
 * A representation of the model object '<em><b>Sourcepaths</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link jasonide.xtext.mas2j.mas2j.Sourcepaths#getSourcepath <em>Sourcepath</em>}</li>
 * </ul>
 * </p>
 *
 * @see jasonide.xtext.mas2j.mas2j.Mas2jPackage#getSourcepaths()
 * @model
 * @generated
 */
public interface Sourcepaths extends EObject
{
  /**
   * Returns the value of the '<em><b>Sourcepath</b></em>' containment reference list.
   * The list contents are of type {@link jasonide.xtext.mas2j.mas2j.Sourcepath}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Sourcepath</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Sourcepath</em>' containment reference list.
   * @see jasonide.xtext.mas2j.mas2j.Mas2jPackage#getSourcepaths_Sourcepath()
   * @model containment="true"
   * @generated
   */
  EList<Sourcepath> getSourcepath();

} // Sourcepaths
