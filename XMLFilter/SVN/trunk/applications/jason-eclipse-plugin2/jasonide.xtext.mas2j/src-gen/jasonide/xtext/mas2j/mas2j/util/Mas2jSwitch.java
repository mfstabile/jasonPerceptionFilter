/**
 * <copyright>
 * </copyright>
 *
 */
package jasonide.xtext.mas2j.mas2j.util;

import jasonide.xtext.mas2j.mas2j.*;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.Switch;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see jasonide.xtext.mas2j.mas2j.Mas2jPackage
 * @generated
 */
public class Mas2jSwitch<T> extends Switch<T>
{
  /**
   * The cached model package
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected static Mas2jPackage modelPackage;

  /**
   * Creates an instance of the switch.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Mas2jSwitch()
  {
    if (modelPackage == null)
    {
      modelPackage = Mas2jPackage.eINSTANCE;
    }
  }

  /**
   * Checks whether this is a switch for the given package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @parameter ePackage the package in question.
   * @return whether this is a switch for the given package.
   * @generated
   */
  @Override
  protected boolean isSwitchFor(EPackage ePackage)
  {
    return ePackage == modelPackage;
  }

  /**
   * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the first non-null result returned by a <code>caseXXX</code> call.
   * @generated
   */
  @Override
  protected T doSwitch(int classifierID, EObject theEObject)
  {
    switch (classifierID)
    {
      case Mas2jPackage.MAS2J_MODEL:
      {
        Mas2jModel mas2jModel = (Mas2jModel)theEObject;
        T result = caseMas2jModel(mas2jModel);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case Mas2jPackage.INFRASTRUCTURE:
      {
        Infrastructure infrastructure = (Infrastructure)theEObject;
        T result = caseInfrastructure(infrastructure);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case Mas2jPackage.ENVIRONMENT:
      {
        Environment environment = (Environment)theEObject;
        T result = caseEnvironment(environment);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case Mas2jPackage.CONTROL:
      {
        Control control = (Control)theEObject;
        T result = caseControl(control);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case Mas2jPackage.CLASSPATHS:
      {
        Classpaths classpaths = (Classpaths)theEObject;
        T result = caseClasspaths(classpaths);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case Mas2jPackage.CLASSPATH:
      {
        Classpath classpath = (Classpath)theEObject;
        T result = caseClasspath(classpath);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case Mas2jPackage.SOURCEPATHS:
      {
        Sourcepaths sourcepaths = (Sourcepaths)theEObject;
        T result = caseSourcepaths(sourcepaths);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case Mas2jPackage.SOURCEPATH:
      {
        Sourcepath sourcepath = (Sourcepath)theEObject;
        T result = caseSourcepath(sourcepath);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case Mas2jPackage.PARAMETER_CLS_DEF:
      {
        ParameterClsDef parameterClsDef = (ParameterClsDef)theEObject;
        T result = caseParameterClsDef(parameterClsDef);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case Mas2jPackage.LST_PARAMETERS_CLS_DEF:
      {
        LstParametersClsDef lstParametersClsDef = (LstParametersClsDef)theEObject;
        T result = caseLstParametersClsDef(lstParametersClsDef);
        if (result == null) result = caseParameterClsDef(lstParametersClsDef);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case Mas2jPackage.CLS_DEF:
      {
        ClsDef clsDef = (ClsDef)theEObject;
        T result = caseClsDef(clsDef);
        if (result == null) result = caseParameterClsDef(clsDef);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case Mas2jPackage.DIRECTIVES:
      {
        Directives directives = (Directives)theEObject;
        T result = caseDirectives(directives);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case Mas2jPackage.DIRECTIVE:
      {
        Directive directive = (Directive)theEObject;
        T result = caseDirective(directive);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case Mas2jPackage.AGENTS:
      {
        Agents agents = (Agents)theEObject;
        T result = caseAgents(agents);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case Mas2jPackage.AGENT:
      {
        Agent agent = (Agent)theEObject;
        T result = caseAgent(agent);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case Mas2jPackage.FILE_NAME:
      {
        FileName fileName = (FileName)theEObject;
        T result = caseFileName(fileName);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case Mas2jPackage.ENVIRONMENT_LOCUS:
      {
        EnvironmentLocus environmentLocus = (EnvironmentLocus)theEObject;
        T result = caseEnvironmentLocus(environmentLocus);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case Mas2jPackage.OPTIONS:
      {
        Options options = (Options)theEObject;
        T result = caseOptions(options);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case Mas2jPackage.OPTION:
      {
        Option option = (Option)theEObject;
        T result = caseOption(option);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case Mas2jPackage.EVENTS:
      {
        Events events = (Events)theEObject;
        T result = caseEvents(events);
        if (result == null) result = caseOption(events);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case Mas2jPackage.INT_BELS:
      {
        IntBels intBels = (IntBels)theEObject;
        T result = caseIntBels(intBels);
        if (result == null) result = caseOption(intBels);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case Mas2jPackage.NRCBP:
      {
        Nrcbp nrcbp = (Nrcbp)theEObject;
        T result = caseNrcbp(nrcbp);
        if (result == null) result = caseOption(nrcbp);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case Mas2jPackage.VERBOSE:
      {
        Verbose verbose = (Verbose)theEObject;
        T result = caseVerbose(verbose);
        if (result == null) result = caseOption(verbose);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case Mas2jPackage.OTHER_OPTION:
      {
        OtherOption otherOption = (OtherOption)theEObject;
        T result = caseOtherOption(otherOption);
        if (result == null) result = caseOption(otherOption);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case Mas2jPackage.AGENT_ARCH_CLASS:
      {
        AgentArchClass agentArchClass = (AgentArchClass)theEObject;
        T result = caseAgentArchClass(agentArchClass);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case Mas2jPackage.BELIEF_BASE_CLASS:
      {
        BeliefBaseClass beliefBaseClass = (BeliefBaseClass)theEObject;
        T result = caseBeliefBaseClass(beliefBaseClass);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case Mas2jPackage.AGENT_CLASS:
      {
        AgentClass agentClass = (AgentClass)theEObject;
        T result = caseAgentClass(agentClass);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case Mas2jPackage.INSTANCES:
      {
        Instances instances = (Instances)theEObject;
        T result = caseInstances(instances);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case Mas2jPackage.DISCARD_EVENTS:
      {
        DiscardEvents discardEvents = (DiscardEvents)theEObject;
        T result = caseDiscardEvents(discardEvents);
        if (result == null) result = caseEvents(discardEvents);
        if (result == null) result = caseOption(discardEvents);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case Mas2jPackage.REQUEUE_EVENTS:
      {
        RequeueEvents requeueEvents = (RequeueEvents)theEObject;
        T result = caseRequeueEvents(requeueEvents);
        if (result == null) result = caseEvents(requeueEvents);
        if (result == null) result = caseOption(requeueEvents);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case Mas2jPackage.RETRIEVE_EVENTS:
      {
        RetrieveEvents retrieveEvents = (RetrieveEvents)theEObject;
        T result = caseRetrieveEvents(retrieveEvents);
        if (result == null) result = caseEvents(retrieveEvents);
        if (result == null) result = caseOption(retrieveEvents);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case Mas2jPackage.SAME_FOCUS:
      {
        SameFocus sameFocus = (SameFocus)theEObject;
        T result = caseSameFocus(sameFocus);
        if (result == null) result = caseIntBels(sameFocus);
        if (result == null) result = caseOption(sameFocus);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case Mas2jPackage.NEW_FOCUS:
      {
        NewFocus newFocus = (NewFocus)theEObject;
        T result = caseNewFocus(newFocus);
        if (result == null) result = caseIntBels(newFocus);
        if (result == null) result = caseOption(newFocus);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      default: return defaultCase(theEObject);
    }
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Model</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Model</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseMas2jModel(Mas2jModel object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Infrastructure</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Infrastructure</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseInfrastructure(Infrastructure object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Environment</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Environment</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseEnvironment(Environment object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Control</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Control</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseControl(Control object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Classpaths</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Classpaths</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseClasspaths(Classpaths object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Classpath</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Classpath</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseClasspath(Classpath object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Sourcepaths</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Sourcepaths</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseSourcepaths(Sourcepaths object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Sourcepath</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Sourcepath</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseSourcepath(Sourcepath object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Parameter Cls Def</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Parameter Cls Def</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseParameterClsDef(ParameterClsDef object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Lst Parameters Cls Def</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Lst Parameters Cls Def</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseLstParametersClsDef(LstParametersClsDef object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Cls Def</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Cls Def</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseClsDef(ClsDef object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Directives</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Directives</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseDirectives(Directives object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Directive</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Directive</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseDirective(Directive object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Agents</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Agents</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseAgents(Agents object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Agent</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Agent</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseAgent(Agent object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>File Name</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>File Name</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseFileName(FileName object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Environment Locus</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Environment Locus</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseEnvironmentLocus(EnvironmentLocus object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Options</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Options</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseOptions(Options object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Option</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Option</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseOption(Option object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Events</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Events</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseEvents(Events object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Int Bels</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Int Bels</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseIntBels(IntBels object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Nrcbp</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Nrcbp</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseNrcbp(Nrcbp object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Verbose</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Verbose</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseVerbose(Verbose object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Other Option</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Other Option</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseOtherOption(OtherOption object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Agent Arch Class</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Agent Arch Class</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseAgentArchClass(AgentArchClass object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Belief Base Class</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Belief Base Class</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseBeliefBaseClass(BeliefBaseClass object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Agent Class</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Agent Class</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseAgentClass(AgentClass object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Instances</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Instances</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseInstances(Instances object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Discard Events</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Discard Events</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseDiscardEvents(DiscardEvents object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Requeue Events</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Requeue Events</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseRequeueEvents(RequeueEvents object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Retrieve Events</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Retrieve Events</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseRetrieveEvents(RetrieveEvents object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Same Focus</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Same Focus</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseSameFocus(SameFocus object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>New Focus</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>New Focus</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseNewFocus(NewFocus object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch, but this is the last case anyway.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject)
   * @generated
   */
  @Override
  public T defaultCase(EObject object)
  {
    return null;
  }

} //Mas2jSwitch
