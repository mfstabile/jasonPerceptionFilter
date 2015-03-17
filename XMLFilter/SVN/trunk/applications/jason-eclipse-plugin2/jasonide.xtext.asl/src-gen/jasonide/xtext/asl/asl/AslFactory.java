/**
 * <copyright>
 * </copyright>
 *
 */
package jasonide.xtext.asl.asl;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see jasonide.xtext.asl.asl.AslPackage
 * @generated
 */
public interface AslFactory extends EFactory
{
  /**
   * The singleton instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  AslFactory eINSTANCE = jasonide.xtext.asl.asl.impl.AslFactoryImpl.init();

  /**
   * Returns a new object of class '<em>Agent</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Agent</em>'.
   * @generated
   */
  Agent createAgent();

  /**
   * Returns a new object of class '<em>Directive</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Directive</em>'.
   * @generated
   */
  Directive createDirective();

  /**
   * Returns a new object of class '<em>Belief</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Belief</em>'.
   * @generated
   */
  Belief createBelief();

  /**
   * Returns a new object of class '<em>Initial goal</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Initial goal</em>'.
   * @generated
   */
  Initial_goal createInitial_goal();

  /**
   * Returns a new object of class '<em>Plan</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Plan</em>'.
   * @generated
   */
  Plan createPlan();

  /**
   * Returns a new object of class '<em>Trigger</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Trigger</em>'.
   * @generated
   */
  Trigger createTrigger();

  /**
   * Returns a new object of class '<em>Plan body</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Plan body</em>'.
   * @generated
   */
  Plan_body createPlan_body();

  /**
   * Returns a new object of class '<em>Stmt IF</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Stmt IF</em>'.
   * @generated
   */
  StmtIF createStmtIF();

  /**
   * Returns a new object of class '<em>Stmt FOR</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Stmt FOR</em>'.
   * @generated
   */
  StmtFOR createStmtFOR();

  /**
   * Returns a new object of class '<em>Stmt WHILE</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Stmt WHILE</em>'.
   * @generated
   */
  StmtWHILE createStmtWHILE();

  /**
   * Returns a new object of class '<em>Body formula</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Body formula</em>'.
   * @generated
   */
  Body_formula createBody_formula();

  /**
   * Returns a new object of class '<em>Plan term</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Plan term</em>'.
   * @generated
   */
  Plan_term createPlan_term();

  /**
   * Returns a new object of class '<em>Literal</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Literal</em>'.
   * @generated
   */
  Literal createLiteral();

  /**
   * Returns a new object of class '<em>Pred</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Pred</em>'.
   * @generated
   */
  Pred createPred();

  /**
   * Returns a new object of class '<em>Terms</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Terms</em>'.
   * @generated
   */
  Terms createTerms();

  /**
   * Returns a new object of class '<em>Term</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Term</em>'.
   * @generated
   */
  Term createTerm();

  /**
   * Returns a new object of class '<em>List</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>List</em>'.
   * @generated
   */
  List createList();

  /**
   * Returns a new object of class '<em>Term in list</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Term in list</em>'.
   * @generated
   */
  Term_in_list createTerm_in_list();

  /**
   * Returns a new object of class '<em>Log expr</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Log expr</em>'.
   * @generated
   */
  Log_expr createLog_expr();

  /**
   * Returns a new object of class '<em>Log expr trm</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Log expr trm</em>'.
   * @generated
   */
  Log_expr_trm createLog_expr_trm();

  /**
   * Returns a new object of class '<em>Log expr factor</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Log expr factor</em>'.
   * @generated
   */
  Log_expr_factor createLog_expr_factor();

  /**
   * Returns a new object of class '<em>Rel expr</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Rel expr</em>'.
   * @generated
   */
  Rel_expr createRel_expr();

  /**
   * Returns a new object of class '<em>Arithm expr</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Arithm expr</em>'.
   * @generated
   */
  Arithm_expr createArithm_expr();

  /**
   * Returns a new object of class '<em>Arithm expr trm</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Arithm expr trm</em>'.
   * @generated
   */
  Arithm_expr_trm createArithm_expr_trm();

  /**
   * Returns a new object of class '<em>Arithm expr factor</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Arithm expr factor</em>'.
   * @generated
   */
  Arithm_expr_factor createArithm_expr_factor();

  /**
   * Returns a new object of class '<em>Arithm expr simple</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Arithm expr simple</em>'.
   * @generated
   */
  Arithm_expr_simple createArithm_expr_simple();

  /**
   * Returns a new object of class '<em>Function</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Function</em>'.
   * @generated
   */
  Function createFunction();

  /**
   * Returns a new object of class '<em>Var</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Var</em>'.
   * @generated
   */
  Var createVar();

  /**
   * Returns a new object of class '<em>String</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>String</em>'.
   * @generated
   */
  String createString();

  /**
   * Returns a new object of class '<em>Number</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Number</em>'.
   * @generated
   */
  Number createNumber();

  /**
   * Returns the package supported by this factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the package supported by this factory.
   * @generated
   */
  AslPackage getAslPackage();

} //AslFactory
