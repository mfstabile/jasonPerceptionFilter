/**
 * <copyright>
 * </copyright>
 *
 */
package jasonide.xtext.mas2j.mas2j.util;

import jasonide.xtext.mas2j.mas2j.*;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see jasonide.xtext.mas2j.mas2j.Mas2jPackage
 * @generated
 */
public class Mas2jAdapterFactory extends AdapterFactoryImpl
{
  /**
   * The cached model package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected static Mas2jPackage modelPackage;

  /**
   * Creates an instance of the adapter factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Mas2jAdapterFactory()
  {
    if (modelPackage == null)
    {
      modelPackage = Mas2jPackage.eINSTANCE;
    }
  }

  /**
   * Returns whether this factory is applicable for the type of the object.
   * <!-- begin-user-doc -->
   * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
   * <!-- end-user-doc -->
   * @return whether this factory is applicable for the type of the object.
   * @generated
   */
  @Override
  public boolean isFactoryForType(Object object)
  {
    if (object == modelPackage)
    {
      return true;
    }
    if (object instanceof EObject)
    {
      return ((EObject)object).eClass().getEPackage() == modelPackage;
    }
    return false;
  }

  /**
   * The switch that delegates to the <code>createXXX</code> methods.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected Mas2jSwitch<Adapter> modelSwitch =
    new Mas2jSwitch<Adapter>()
    {
      @Override
      public Adapter caseMas2jModel(Mas2jModel object)
      {
        return createMas2jModelAdapter();
      }
      @Override
      public Adapter caseInfrastructure(Infrastructure object)
      {
        return createInfrastructureAdapter();
      }
      @Override
      public Adapter caseEnvironment(Environment object)
      {
        return createEnvironmentAdapter();
      }
      @Override
      public Adapter caseControl(Control object)
      {
        return createControlAdapter();
      }
      @Override
      public Adapter caseClasspaths(Classpaths object)
      {
        return createClasspathsAdapter();
      }
      @Override
      public Adapter caseClasspath(Classpath object)
      {
        return createClasspathAdapter();
      }
      @Override
      public Adapter caseSourcepaths(Sourcepaths object)
      {
        return createSourcepathsAdapter();
      }
      @Override
      public Adapter caseSourcepath(Sourcepath object)
      {
        return createSourcepathAdapter();
      }
      @Override
      public Adapter caseParameterClsDef(ParameterClsDef object)
      {
        return createParameterClsDefAdapter();
      }
      @Override
      public Adapter caseLstParametersClsDef(LstParametersClsDef object)
      {
        return createLstParametersClsDefAdapter();
      }
      @Override
      public Adapter caseClsDef(ClsDef object)
      {
        return createClsDefAdapter();
      }
      @Override
      public Adapter caseDirectives(Directives object)
      {
        return createDirectivesAdapter();
      }
      @Override
      public Adapter caseDirective(Directive object)
      {
        return createDirectiveAdapter();
      }
      @Override
      public Adapter caseAgents(Agents object)
      {
        return createAgentsAdapter();
      }
      @Override
      public Adapter caseAgent(Agent object)
      {
        return createAgentAdapter();
      }
      @Override
      public Adapter caseFileName(FileName object)
      {
        return createFileNameAdapter();
      }
      @Override
      public Adapter caseEnvironmentLocus(EnvironmentLocus object)
      {
        return createEnvironmentLocusAdapter();
      }
      @Override
      public Adapter caseOptions(Options object)
      {
        return createOptionsAdapter();
      }
      @Override
      public Adapter caseOption(Option object)
      {
        return createOptionAdapter();
      }
      @Override
      public Adapter caseEvents(Events object)
      {
        return createEventsAdapter();
      }
      @Override
      public Adapter caseIntBels(IntBels object)
      {
        return createIntBelsAdapter();
      }
      @Override
      public Adapter caseNrcbp(Nrcbp object)
      {
        return createNrcbpAdapter();
      }
      @Override
      public Adapter caseVerbose(Verbose object)
      {
        return createVerboseAdapter();
      }
      @Override
      public Adapter caseOtherOption(OtherOption object)
      {
        return createOtherOptionAdapter();
      }
      @Override
      public Adapter caseAgentArchClass(AgentArchClass object)
      {
        return createAgentArchClassAdapter();
      }
      @Override
      public Adapter caseBeliefBaseClass(BeliefBaseClass object)
      {
        return createBeliefBaseClassAdapter();
      }
      @Override
      public Adapter caseAgentClass(AgentClass object)
      {
        return createAgentClassAdapter();
      }
      @Override
      public Adapter caseInstances(Instances object)
      {
        return createInstancesAdapter();
      }
      @Override
      public Adapter caseDiscardEvents(DiscardEvents object)
      {
        return createDiscardEventsAdapter();
      }
      @Override
      public Adapter caseRequeueEvents(RequeueEvents object)
      {
        return createRequeueEventsAdapter();
      }
      @Override
      public Adapter caseRetrieveEvents(RetrieveEvents object)
      {
        return createRetrieveEventsAdapter();
      }
      @Override
      public Adapter caseSameFocus(SameFocus object)
      {
        return createSameFocusAdapter();
      }
      @Override
      public Adapter caseNewFocus(NewFocus object)
      {
        return createNewFocusAdapter();
      }
      @Override
      public Adapter defaultCase(EObject object)
      {
        return createEObjectAdapter();
      }
    };

  /**
   * Creates an adapter for the <code>target</code>.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param target the object to adapt.
   * @return the adapter for the <code>target</code>.
   * @generated
   */
  @Override
  public Adapter createAdapter(Notifier target)
  {
    return modelSwitch.doSwitch((EObject)target);
  }


  /**
   * Creates a new adapter for an object of class '{@link jasonide.xtext.mas2j.mas2j.Mas2jModel <em>Model</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see jasonide.xtext.mas2j.mas2j.Mas2jModel
   * @generated
   */
  public Adapter createMas2jModelAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link jasonide.xtext.mas2j.mas2j.Infrastructure <em>Infrastructure</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see jasonide.xtext.mas2j.mas2j.Infrastructure
   * @generated
   */
  public Adapter createInfrastructureAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link jasonide.xtext.mas2j.mas2j.Environment <em>Environment</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see jasonide.xtext.mas2j.mas2j.Environment
   * @generated
   */
  public Adapter createEnvironmentAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link jasonide.xtext.mas2j.mas2j.Control <em>Control</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see jasonide.xtext.mas2j.mas2j.Control
   * @generated
   */
  public Adapter createControlAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link jasonide.xtext.mas2j.mas2j.Classpaths <em>Classpaths</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see jasonide.xtext.mas2j.mas2j.Classpaths
   * @generated
   */
  public Adapter createClasspathsAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link jasonide.xtext.mas2j.mas2j.Classpath <em>Classpath</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see jasonide.xtext.mas2j.mas2j.Classpath
   * @generated
   */
  public Adapter createClasspathAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link jasonide.xtext.mas2j.mas2j.Sourcepaths <em>Sourcepaths</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see jasonide.xtext.mas2j.mas2j.Sourcepaths
   * @generated
   */
  public Adapter createSourcepathsAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link jasonide.xtext.mas2j.mas2j.Sourcepath <em>Sourcepath</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see jasonide.xtext.mas2j.mas2j.Sourcepath
   * @generated
   */
  public Adapter createSourcepathAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link jasonide.xtext.mas2j.mas2j.ParameterClsDef <em>Parameter Cls Def</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see jasonide.xtext.mas2j.mas2j.ParameterClsDef
   * @generated
   */
  public Adapter createParameterClsDefAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link jasonide.xtext.mas2j.mas2j.LstParametersClsDef <em>Lst Parameters Cls Def</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see jasonide.xtext.mas2j.mas2j.LstParametersClsDef
   * @generated
   */
  public Adapter createLstParametersClsDefAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link jasonide.xtext.mas2j.mas2j.ClsDef <em>Cls Def</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see jasonide.xtext.mas2j.mas2j.ClsDef
   * @generated
   */
  public Adapter createClsDefAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link jasonide.xtext.mas2j.mas2j.Directives <em>Directives</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see jasonide.xtext.mas2j.mas2j.Directives
   * @generated
   */
  public Adapter createDirectivesAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link jasonide.xtext.mas2j.mas2j.Directive <em>Directive</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see jasonide.xtext.mas2j.mas2j.Directive
   * @generated
   */
  public Adapter createDirectiveAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link jasonide.xtext.mas2j.mas2j.Agents <em>Agents</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see jasonide.xtext.mas2j.mas2j.Agents
   * @generated
   */
  public Adapter createAgentsAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link jasonide.xtext.mas2j.mas2j.Agent <em>Agent</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see jasonide.xtext.mas2j.mas2j.Agent
   * @generated
   */
  public Adapter createAgentAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link jasonide.xtext.mas2j.mas2j.FileName <em>File Name</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see jasonide.xtext.mas2j.mas2j.FileName
   * @generated
   */
  public Adapter createFileNameAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link jasonide.xtext.mas2j.mas2j.EnvironmentLocus <em>Environment Locus</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see jasonide.xtext.mas2j.mas2j.EnvironmentLocus
   * @generated
   */
  public Adapter createEnvironmentLocusAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link jasonide.xtext.mas2j.mas2j.Options <em>Options</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see jasonide.xtext.mas2j.mas2j.Options
   * @generated
   */
  public Adapter createOptionsAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link jasonide.xtext.mas2j.mas2j.Option <em>Option</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see jasonide.xtext.mas2j.mas2j.Option
   * @generated
   */
  public Adapter createOptionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link jasonide.xtext.mas2j.mas2j.Events <em>Events</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see jasonide.xtext.mas2j.mas2j.Events
   * @generated
   */
  public Adapter createEventsAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link jasonide.xtext.mas2j.mas2j.IntBels <em>Int Bels</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see jasonide.xtext.mas2j.mas2j.IntBels
   * @generated
   */
  public Adapter createIntBelsAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link jasonide.xtext.mas2j.mas2j.Nrcbp <em>Nrcbp</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see jasonide.xtext.mas2j.mas2j.Nrcbp
   * @generated
   */
  public Adapter createNrcbpAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link jasonide.xtext.mas2j.mas2j.Verbose <em>Verbose</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see jasonide.xtext.mas2j.mas2j.Verbose
   * @generated
   */
  public Adapter createVerboseAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link jasonide.xtext.mas2j.mas2j.OtherOption <em>Other Option</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see jasonide.xtext.mas2j.mas2j.OtherOption
   * @generated
   */
  public Adapter createOtherOptionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link jasonide.xtext.mas2j.mas2j.AgentArchClass <em>Agent Arch Class</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see jasonide.xtext.mas2j.mas2j.AgentArchClass
   * @generated
   */
  public Adapter createAgentArchClassAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link jasonide.xtext.mas2j.mas2j.BeliefBaseClass <em>Belief Base Class</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see jasonide.xtext.mas2j.mas2j.BeliefBaseClass
   * @generated
   */
  public Adapter createBeliefBaseClassAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link jasonide.xtext.mas2j.mas2j.AgentClass <em>Agent Class</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see jasonide.xtext.mas2j.mas2j.AgentClass
   * @generated
   */
  public Adapter createAgentClassAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link jasonide.xtext.mas2j.mas2j.Instances <em>Instances</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see jasonide.xtext.mas2j.mas2j.Instances
   * @generated
   */
  public Adapter createInstancesAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link jasonide.xtext.mas2j.mas2j.DiscardEvents <em>Discard Events</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see jasonide.xtext.mas2j.mas2j.DiscardEvents
   * @generated
   */
  public Adapter createDiscardEventsAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link jasonide.xtext.mas2j.mas2j.RequeueEvents <em>Requeue Events</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see jasonide.xtext.mas2j.mas2j.RequeueEvents
   * @generated
   */
  public Adapter createRequeueEventsAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link jasonide.xtext.mas2j.mas2j.RetrieveEvents <em>Retrieve Events</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see jasonide.xtext.mas2j.mas2j.RetrieveEvents
   * @generated
   */
  public Adapter createRetrieveEventsAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link jasonide.xtext.mas2j.mas2j.SameFocus <em>Same Focus</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see jasonide.xtext.mas2j.mas2j.SameFocus
   * @generated
   */
  public Adapter createSameFocusAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link jasonide.xtext.mas2j.mas2j.NewFocus <em>New Focus</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see jasonide.xtext.mas2j.mas2j.NewFocus
   * @generated
   */
  public Adapter createNewFocusAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for the default case.
   * <!-- begin-user-doc -->
   * This default implementation returns null.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @generated
   */
  public Adapter createEObjectAdapter()
  {
    return null;
  }

} //Mas2jAdapterFactory
