/**
 * <copyright>
 * </copyright>
 *
 */
package jasonide.xtext.mas2j.mas2j.impl;

import jasonide.xtext.mas2j.mas2j.Mas2jPackage;
import jasonide.xtext.mas2j.mas2j.OtherOption;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Other Option</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link jasonide.xtext.mas2j.mas2j.impl.OtherOptionImpl#getOptionName <em>Option Name</em>}</li>
 *   <li>{@link jasonide.xtext.mas2j.mas2j.impl.OtherOptionImpl#getVal <em>Val</em>}</li>
 *   <li>{@link jasonide.xtext.mas2j.mas2j.impl.OtherOptionImpl#getInt_val <em>Int val</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class OtherOptionImpl extends OptionImpl implements OtherOption
{
  /**
   * The default value of the '{@link #getOptionName() <em>Option Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getOptionName()
   * @generated
   * @ordered
   */
  protected static final String OPTION_NAME_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getOptionName() <em>Option Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getOptionName()
   * @generated
   * @ordered
   */
  protected String optionName = OPTION_NAME_EDEFAULT;

  /**
   * The default value of the '{@link #getVal() <em>Val</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getVal()
   * @generated
   * @ordered
   */
  protected static final String VAL_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getVal() <em>Val</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getVal()
   * @generated
   * @ordered
   */
  protected String val = VAL_EDEFAULT;

  /**
   * The default value of the '{@link #getInt_val() <em>Int val</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getInt_val()
   * @generated
   * @ordered
   */
  protected static final int INT_VAL_EDEFAULT = 0;

  /**
   * The cached value of the '{@link #getInt_val() <em>Int val</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getInt_val()
   * @generated
   * @ordered
   */
  protected int int_val = INT_VAL_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected OtherOptionImpl()
  {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass()
  {
    return Mas2jPackage.Literals.OTHER_OPTION;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getOptionName()
  {
    return optionName;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setOptionName(String newOptionName)
  {
    String oldOptionName = optionName;
    optionName = newOptionName;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, Mas2jPackage.OTHER_OPTION__OPTION_NAME, oldOptionName, optionName));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getVal()
  {
    return val;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setVal(String newVal)
  {
    String oldVal = val;
    val = newVal;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, Mas2jPackage.OTHER_OPTION__VAL, oldVal, val));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public int getInt_val()
  {
    return int_val;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setInt_val(int newInt_val)
  {
    int oldInt_val = int_val;
    int_val = newInt_val;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, Mas2jPackage.OTHER_OPTION__INT_VAL, oldInt_val, int_val));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType)
  {
    switch (featureID)
    {
      case Mas2jPackage.OTHER_OPTION__OPTION_NAME:
        return getOptionName();
      case Mas2jPackage.OTHER_OPTION__VAL:
        return getVal();
      case Mas2jPackage.OTHER_OPTION__INT_VAL:
        return getInt_val();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
      case Mas2jPackage.OTHER_OPTION__OPTION_NAME:
        setOptionName((String)newValue);
        return;
      case Mas2jPackage.OTHER_OPTION__VAL:
        setVal((String)newValue);
        return;
      case Mas2jPackage.OTHER_OPTION__INT_VAL:
        setInt_val((Integer)newValue);
        return;
    }
    super.eSet(featureID, newValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eUnset(int featureID)
  {
    switch (featureID)
    {
      case Mas2jPackage.OTHER_OPTION__OPTION_NAME:
        setOptionName(OPTION_NAME_EDEFAULT);
        return;
      case Mas2jPackage.OTHER_OPTION__VAL:
        setVal(VAL_EDEFAULT);
        return;
      case Mas2jPackage.OTHER_OPTION__INT_VAL:
        setInt_val(INT_VAL_EDEFAULT);
        return;
    }
    super.eUnset(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public boolean eIsSet(int featureID)
  {
    switch (featureID)
    {
      case Mas2jPackage.OTHER_OPTION__OPTION_NAME:
        return OPTION_NAME_EDEFAULT == null ? optionName != null : !OPTION_NAME_EDEFAULT.equals(optionName);
      case Mas2jPackage.OTHER_OPTION__VAL:
        return VAL_EDEFAULT == null ? val != null : !VAL_EDEFAULT.equals(val);
      case Mas2jPackage.OTHER_OPTION__INT_VAL:
        return int_val != INT_VAL_EDEFAULT;
    }
    return super.eIsSet(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String toString()
  {
    if (eIsProxy()) return super.toString();

    StringBuffer result = new StringBuffer(super.toString());
    result.append(" (optionName: ");
    result.append(optionName);
    result.append(", val: ");
    result.append(val);
    result.append(", int_val: ");
    result.append(int_val);
    result.append(')');
    return result.toString();
  }

} //OtherOptionImpl
