/**
 * <copyright>
 * </copyright>
 *
 */
package jasonide.xtext.mas2j.mas2j.impl;

import jasonide.xtext.mas2j.mas2j.Agent;
import jasonide.xtext.mas2j.mas2j.AgentArchClass;
import jasonide.xtext.mas2j.mas2j.AgentClass;
import jasonide.xtext.mas2j.mas2j.Agents;
import jasonide.xtext.mas2j.mas2j.BeliefBaseClass;
import jasonide.xtext.mas2j.mas2j.Classpath;
import jasonide.xtext.mas2j.mas2j.Classpaths;
import jasonide.xtext.mas2j.mas2j.ClsDef;
import jasonide.xtext.mas2j.mas2j.Control;
import jasonide.xtext.mas2j.mas2j.Directive;
import jasonide.xtext.mas2j.mas2j.Directives;
import jasonide.xtext.mas2j.mas2j.DiscardEvents;
import jasonide.xtext.mas2j.mas2j.Environment;
import jasonide.xtext.mas2j.mas2j.EnvironmentLocus;
import jasonide.xtext.mas2j.mas2j.Events;
import jasonide.xtext.mas2j.mas2j.FileName;
import jasonide.xtext.mas2j.mas2j.Infrastructure;
import jasonide.xtext.mas2j.mas2j.Instances;
import jasonide.xtext.mas2j.mas2j.IntBels;
import jasonide.xtext.mas2j.mas2j.LstParametersClsDef;
import jasonide.xtext.mas2j.mas2j.Mas2jFactory;
import jasonide.xtext.mas2j.mas2j.Mas2jModel;
import jasonide.xtext.mas2j.mas2j.Mas2jPackage;
import jasonide.xtext.mas2j.mas2j.NewFocus;
import jasonide.xtext.mas2j.mas2j.Nrcbp;
import jasonide.xtext.mas2j.mas2j.Option;
import jasonide.xtext.mas2j.mas2j.Options;
import jasonide.xtext.mas2j.mas2j.OtherOption;
import jasonide.xtext.mas2j.mas2j.ParameterClsDef;
import jasonide.xtext.mas2j.mas2j.RequeueEvents;
import jasonide.xtext.mas2j.mas2j.RetrieveEvents;
import jasonide.xtext.mas2j.mas2j.SameFocus;
import jasonide.xtext.mas2j.mas2j.Sourcepath;
import jasonide.xtext.mas2j.mas2j.Sourcepaths;
import jasonide.xtext.mas2j.mas2j.Verbose;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class Mas2jPackageImpl extends EPackageImpl implements Mas2jPackage
{
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass mas2jModelEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass infrastructureEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass environmentEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass controlEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass classpathsEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass classpathEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass sourcepathsEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass sourcepathEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass parameterClsDefEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass lstParametersClsDefEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass clsDefEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass directivesEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass directiveEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass agentsEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass agentEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass fileNameEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass environmentLocusEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass optionsEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass optionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass eventsEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass intBelsEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass nrcbpEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass verboseEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass otherOptionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass agentArchClassEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass beliefBaseClassEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass agentClassEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass instancesEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass discardEventsEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass requeueEventsEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass retrieveEventsEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass sameFocusEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass newFocusEClass = null;

  /**
   * Creates an instance of the model <b>Package</b>, registered with
   * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
   * package URI value.
   * <p>Note: the correct way to create the package is via the static
   * factory method {@link #init init()}, which also performs
   * initialization of the package, or returns the registered package,
   * if one already exists.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.emf.ecore.EPackage.Registry
   * @see jasonide.xtext.mas2j.mas2j.Mas2jPackage#eNS_URI
   * @see #init()
   * @generated
   */
  private Mas2jPackageImpl()
  {
    super(eNS_URI, Mas2jFactory.eINSTANCE);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private static boolean isInited = false;

  /**
   * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
   * 
   * <p>This method is used to initialize {@link Mas2jPackage#eINSTANCE} when that field is accessed.
   * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #eNS_URI
   * @see #createPackageContents()
   * @see #initializePackageContents()
   * @generated
   */
  public static Mas2jPackage init()
  {
    if (isInited) return (Mas2jPackage)EPackage.Registry.INSTANCE.getEPackage(Mas2jPackage.eNS_URI);

    // Obtain or create and register package
    Mas2jPackageImpl theMas2jPackage = (Mas2jPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof Mas2jPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new Mas2jPackageImpl());

    isInited = true;

    // Create package meta-data objects
    theMas2jPackage.createPackageContents();

    // Initialize created meta-data
    theMas2jPackage.initializePackageContents();

    // Mark meta-data to indicate it can't be changed
    theMas2jPackage.freeze();

  
    // Update the registry and return the package
    EPackage.Registry.INSTANCE.put(Mas2jPackage.eNS_URI, theMas2jPackage);
    return theMas2jPackage;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getMas2jModel()
  {
    return mas2jModelEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getMas2jModel_Name()
  {
    return (EAttribute)mas2jModelEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getMas2jModel_Infrastructure()
  {
    return (EReference)mas2jModelEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getMas2jModel_Environment()
  {
    return (EReference)mas2jModelEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getMas2jModel_Control()
  {
    return (EReference)mas2jModelEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getMas2jModel_Agents()
  {
    return (EReference)mas2jModelEClass.getEStructuralFeatures().get(4);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getMas2jModel_Directives()
  {
    return (EReference)mas2jModelEClass.getEStructuralFeatures().get(5);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getMas2jModel_Classpath()
  {
    return (EReference)mas2jModelEClass.getEStructuralFeatures().get(6);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getMas2jModel_Sourcepath()
  {
    return (EReference)mas2jModelEClass.getEStructuralFeatures().get(7);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getInfrastructure()
  {
    return infrastructureEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getInfrastructure_Infrastructure()
  {
    return (EReference)infrastructureEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getEnvironment()
  {
    return environmentEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getEnvironment_Environment()
  {
    return (EReference)environmentEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getEnvironment_EnvironmentLocus()
  {
    return (EAttribute)environmentEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getControl()
  {
    return controlEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getControl_Control()
  {
    return (EReference)controlEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getControl_ControlLocus()
  {
    return (EAttribute)controlEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getClasspaths()
  {
    return classpathsEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getClasspaths_Classpath()
  {
    return (EReference)classpathsEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getClasspath()
  {
    return classpathEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getClasspath_Nomeclasspath()
  {
    return (EAttribute)classpathEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getSourcepaths()
  {
    return sourcepathsEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getSourcepaths_Sourcepath()
  {
    return (EReference)sourcepathsEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getSourcepath()
  {
    return sourcepathEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getSourcepath_Nomesourcepath()
  {
    return (EAttribute)sourcepathEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getParameterClsDef()
  {
    return parameterClsDefEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getParameterClsDef_Parameterclsint()
  {
    return (EAttribute)parameterClsDefEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getParameterClsDef_Parameterclsstr()
  {
    return (EAttribute)parameterClsDefEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getParameterClsDef_Parameter()
  {
    return (EReference)parameterClsDefEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getLstParametersClsDef()
  {
    return lstParametersClsDefEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getClsDef()
  {
    return clsDefEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getClsDef_Infrastructure()
  {
    return (EAttribute)clsDefEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getDirectives()
  {
    return directivesEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getDirectives_Directives()
  {
    return (EReference)directivesEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getDirective()
  {
    return directiveEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getDirective_Directive()
  {
    return (EAttribute)directiveEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getDirective_ClsDirective()
  {
    return (EReference)directiveEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getAgents()
  {
    return agentsEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getAgents_Agents()
  {
    return (EReference)agentsEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getAgent()
  {
    return agentEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getAgent_Name()
  {
    return (EAttribute)agentEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getAgent_SourceFile()
  {
    return (EReference)agentEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getAgent_Options()
  {
    return (EReference)agentEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getAgent_AgentArchClass()
  {
    return (EReference)agentEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getAgent_BeliefBaseClass()
  {
    return (EReference)agentEClass.getEStructuralFeatures().get(4);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getAgent_AgentClass()
  {
    return (EReference)agentEClass.getEStructuralFeatures().get(5);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getAgent_Instances()
  {
    return (EReference)agentEClass.getEStructuralFeatures().get(6);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getAgent_Environment()
  {
    return (EReference)agentEClass.getEStructuralFeatures().get(7);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getFileName()
  {
    return fileNameEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getFileName_Path()
  {
    return (EAttribute)fileNameEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getFileName_Asid()
  {
    return (EAttribute)fileNameEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getEnvironmentLocus()
  {
    return environmentLocusEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getEnvironmentLocus_EnvironmentLocus()
  {
    return (EAttribute)environmentLocusEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getOptions()
  {
    return optionsEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getOptions_Options()
  {
    return (EReference)optionsEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getOption()
  {
    return optionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getEvents()
  {
    return eventsEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getIntBels()
  {
    return intBelsEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getNrcbp()
  {
    return nrcbpEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getNrcbp_Val()
  {
    return (EAttribute)nrcbpEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getVerbose()
  {
    return verboseEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getVerbose_Val()
  {
    return (EAttribute)verboseEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getOtherOption()
  {
    return otherOptionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getOtherOption_OptionName()
  {
    return (EAttribute)otherOptionEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getOtherOption_Val()
  {
    return (EAttribute)otherOptionEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getOtherOption_Int_val()
  {
    return (EAttribute)otherOptionEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getAgentArchClass()
  {
    return agentArchClassEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getAgentArchClass_AgentArchClass()
  {
    return (EReference)agentArchClassEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getBeliefBaseClass()
  {
    return beliefBaseClassEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getBeliefBaseClass_BeliefBaseClass()
  {
    return (EReference)beliefBaseClassEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getAgentClass()
  {
    return agentClassEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getAgentClass_AgentClass()
  {
    return (EReference)agentClassEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getInstances()
  {
    return instancesEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getInstances_Instances()
  {
    return (EAttribute)instancesEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getDiscardEvents()
  {
    return discardEventsEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getRequeueEvents()
  {
    return requeueEventsEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getRetrieveEvents()
  {
    return retrieveEventsEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getSameFocus()
  {
    return sameFocusEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getNewFocus()
  {
    return newFocusEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Mas2jFactory getMas2jFactory()
  {
    return (Mas2jFactory)getEFactoryInstance();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private boolean isCreated = false;

  /**
   * Creates the meta-model objects for the package.  This method is
   * guarded to have no affect on any invocation but its first.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void createPackageContents()
  {
    if (isCreated) return;
    isCreated = true;

    // Create classes and their features
    mas2jModelEClass = createEClass(MAS2J_MODEL);
    createEAttribute(mas2jModelEClass, MAS2J_MODEL__NAME);
    createEReference(mas2jModelEClass, MAS2J_MODEL__INFRASTRUCTURE);
    createEReference(mas2jModelEClass, MAS2J_MODEL__ENVIRONMENT);
    createEReference(mas2jModelEClass, MAS2J_MODEL__CONTROL);
    createEReference(mas2jModelEClass, MAS2J_MODEL__AGENTS);
    createEReference(mas2jModelEClass, MAS2J_MODEL__DIRECTIVES);
    createEReference(mas2jModelEClass, MAS2J_MODEL__CLASSPATH);
    createEReference(mas2jModelEClass, MAS2J_MODEL__SOURCEPATH);

    infrastructureEClass = createEClass(INFRASTRUCTURE);
    createEReference(infrastructureEClass, INFRASTRUCTURE__INFRASTRUCTURE);

    environmentEClass = createEClass(ENVIRONMENT);
    createEReference(environmentEClass, ENVIRONMENT__ENVIRONMENT);
    createEAttribute(environmentEClass, ENVIRONMENT__ENVIRONMENT_LOCUS);

    controlEClass = createEClass(CONTROL);
    createEReference(controlEClass, CONTROL__CONTROL);
    createEAttribute(controlEClass, CONTROL__CONTROL_LOCUS);

    classpathsEClass = createEClass(CLASSPATHS);
    createEReference(classpathsEClass, CLASSPATHS__CLASSPATH);

    classpathEClass = createEClass(CLASSPATH);
    createEAttribute(classpathEClass, CLASSPATH__NOMECLASSPATH);

    sourcepathsEClass = createEClass(SOURCEPATHS);
    createEReference(sourcepathsEClass, SOURCEPATHS__SOURCEPATH);

    sourcepathEClass = createEClass(SOURCEPATH);
    createEAttribute(sourcepathEClass, SOURCEPATH__NOMESOURCEPATH);

    parameterClsDefEClass = createEClass(PARAMETER_CLS_DEF);
    createEAttribute(parameterClsDefEClass, PARAMETER_CLS_DEF__PARAMETERCLSINT);
    createEAttribute(parameterClsDefEClass, PARAMETER_CLS_DEF__PARAMETERCLSSTR);
    createEReference(parameterClsDefEClass, PARAMETER_CLS_DEF__PARAMETER);

    lstParametersClsDefEClass = createEClass(LST_PARAMETERS_CLS_DEF);

    clsDefEClass = createEClass(CLS_DEF);
    createEAttribute(clsDefEClass, CLS_DEF__INFRASTRUCTURE);

    directivesEClass = createEClass(DIRECTIVES);
    createEReference(directivesEClass, DIRECTIVES__DIRECTIVES);

    directiveEClass = createEClass(DIRECTIVE);
    createEAttribute(directiveEClass, DIRECTIVE__DIRECTIVE);
    createEReference(directiveEClass, DIRECTIVE__CLS_DIRECTIVE);

    agentsEClass = createEClass(AGENTS);
    createEReference(agentsEClass, AGENTS__AGENTS);

    agentEClass = createEClass(AGENT);
    createEAttribute(agentEClass, AGENT__NAME);
    createEReference(agentEClass, AGENT__SOURCE_FILE);
    createEReference(agentEClass, AGENT__OPTIONS);
    createEReference(agentEClass, AGENT__AGENT_ARCH_CLASS);
    createEReference(agentEClass, AGENT__BELIEF_BASE_CLASS);
    createEReference(agentEClass, AGENT__AGENT_CLASS);
    createEReference(agentEClass, AGENT__INSTANCES);
    createEReference(agentEClass, AGENT__ENVIRONMENT);

    fileNameEClass = createEClass(FILE_NAME);
    createEAttribute(fileNameEClass, FILE_NAME__PATH);
    createEAttribute(fileNameEClass, FILE_NAME__ASID);

    environmentLocusEClass = createEClass(ENVIRONMENT_LOCUS);
    createEAttribute(environmentLocusEClass, ENVIRONMENT_LOCUS__ENVIRONMENT_LOCUS);

    optionsEClass = createEClass(OPTIONS);
    createEReference(optionsEClass, OPTIONS__OPTIONS);

    optionEClass = createEClass(OPTION);

    eventsEClass = createEClass(EVENTS);

    intBelsEClass = createEClass(INT_BELS);

    nrcbpEClass = createEClass(NRCBP);
    createEAttribute(nrcbpEClass, NRCBP__VAL);

    verboseEClass = createEClass(VERBOSE);
    createEAttribute(verboseEClass, VERBOSE__VAL);

    otherOptionEClass = createEClass(OTHER_OPTION);
    createEAttribute(otherOptionEClass, OTHER_OPTION__OPTION_NAME);
    createEAttribute(otherOptionEClass, OTHER_OPTION__VAL);
    createEAttribute(otherOptionEClass, OTHER_OPTION__INT_VAL);

    agentArchClassEClass = createEClass(AGENT_ARCH_CLASS);
    createEReference(agentArchClassEClass, AGENT_ARCH_CLASS__AGENT_ARCH_CLASS);

    beliefBaseClassEClass = createEClass(BELIEF_BASE_CLASS);
    createEReference(beliefBaseClassEClass, BELIEF_BASE_CLASS__BELIEF_BASE_CLASS);

    agentClassEClass = createEClass(AGENT_CLASS);
    createEReference(agentClassEClass, AGENT_CLASS__AGENT_CLASS);

    instancesEClass = createEClass(INSTANCES);
    createEAttribute(instancesEClass, INSTANCES__INSTANCES);

    discardEventsEClass = createEClass(DISCARD_EVENTS);

    requeueEventsEClass = createEClass(REQUEUE_EVENTS);

    retrieveEventsEClass = createEClass(RETRIEVE_EVENTS);

    sameFocusEClass = createEClass(SAME_FOCUS);

    newFocusEClass = createEClass(NEW_FOCUS);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private boolean isInitialized = false;

  /**
   * Complete the initialization of the package and its meta-model.  This
   * method is guarded to have no affect on any invocation but its first.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void initializePackageContents()
  {
    if (isInitialized) return;
    isInitialized = true;

    // Initialize package
    setName(eNAME);
    setNsPrefix(eNS_PREFIX);
    setNsURI(eNS_URI);

    // Create type parameters

    // Set bounds for type parameters

    // Add supertypes to classes
    lstParametersClsDefEClass.getESuperTypes().add(this.getParameterClsDef());
    clsDefEClass.getESuperTypes().add(this.getParameterClsDef());
    eventsEClass.getESuperTypes().add(this.getOption());
    intBelsEClass.getESuperTypes().add(this.getOption());
    nrcbpEClass.getESuperTypes().add(this.getOption());
    verboseEClass.getESuperTypes().add(this.getOption());
    otherOptionEClass.getESuperTypes().add(this.getOption());
    discardEventsEClass.getESuperTypes().add(this.getEvents());
    requeueEventsEClass.getESuperTypes().add(this.getEvents());
    retrieveEventsEClass.getESuperTypes().add(this.getEvents());
    sameFocusEClass.getESuperTypes().add(this.getIntBels());
    newFocusEClass.getESuperTypes().add(this.getIntBels());

    // Initialize classes and features; add operations and parameters
    initEClass(mas2jModelEClass, Mas2jModel.class, "Mas2jModel", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getMas2jModel_Name(), ecorePackage.getEString(), "name", null, 0, 1, Mas2jModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getMas2jModel_Infrastructure(), this.getInfrastructure(), null, "infrastructure", null, 0, 1, Mas2jModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getMas2jModel_Environment(), this.getEnvironment(), null, "environment", null, 0, 1, Mas2jModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getMas2jModel_Control(), this.getControl(), null, "control", null, 0, 1, Mas2jModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getMas2jModel_Agents(), this.getAgents(), null, "agents", null, 0, 1, Mas2jModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getMas2jModel_Directives(), this.getDirectives(), null, "directives", null, 0, 1, Mas2jModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getMas2jModel_Classpath(), this.getClasspaths(), null, "classpath", null, 0, 1, Mas2jModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getMas2jModel_Sourcepath(), this.getSourcepaths(), null, "sourcepath", null, 0, 1, Mas2jModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(infrastructureEClass, Infrastructure.class, "Infrastructure", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getInfrastructure_Infrastructure(), this.getClsDef(), null, "infrastructure", null, 0, 1, Infrastructure.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(environmentEClass, Environment.class, "Environment", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getEnvironment_Environment(), this.getClsDef(), null, "environment", null, 0, 1, Environment.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getEnvironment_EnvironmentLocus(), ecorePackage.getEString(), "environmentLocus", null, 0, 1, Environment.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(controlEClass, Control.class, "Control", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getControl_Control(), this.getClsDef(), null, "control", null, 0, 1, Control.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getControl_ControlLocus(), ecorePackage.getEString(), "controlLocus", null, 0, 1, Control.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(classpathsEClass, Classpaths.class, "Classpaths", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getClasspaths_Classpath(), this.getClasspath(), null, "classpath", null, 0, -1, Classpaths.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(classpathEClass, Classpath.class, "Classpath", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getClasspath_Nomeclasspath(), ecorePackage.getEString(), "nomeclasspath", null, 0, 1, Classpath.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(sourcepathsEClass, Sourcepaths.class, "Sourcepaths", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getSourcepaths_Sourcepath(), this.getSourcepath(), null, "sourcepath", null, 0, -1, Sourcepaths.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(sourcepathEClass, Sourcepath.class, "Sourcepath", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getSourcepath_Nomesourcepath(), ecorePackage.getEString(), "nomesourcepath", null, 0, 1, Sourcepath.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(parameterClsDefEClass, ParameterClsDef.class, "ParameterClsDef", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getParameterClsDef_Parameterclsint(), ecorePackage.getEInt(), "parameterclsint", null, 0, 1, ParameterClsDef.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getParameterClsDef_Parameterclsstr(), ecorePackage.getEString(), "parameterclsstr", null, 0, 1, ParameterClsDef.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getParameterClsDef_Parameter(), this.getParameterClsDef(), null, "parameter", null, 0, -1, ParameterClsDef.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(lstParametersClsDefEClass, LstParametersClsDef.class, "LstParametersClsDef", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(clsDefEClass, ClsDef.class, "ClsDef", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getClsDef_Infrastructure(), ecorePackage.getEString(), "infrastructure", null, 0, 1, ClsDef.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(directivesEClass, Directives.class, "Directives", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getDirectives_Directives(), this.getDirective(), null, "directives", null, 0, -1, Directives.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(directiveEClass, Directive.class, "Directive", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getDirective_Directive(), ecorePackage.getEString(), "directive", null, 0, 1, Directive.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getDirective_ClsDirective(), this.getClsDef(), null, "clsDirective", null, 0, 1, Directive.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(agentsEClass, Agents.class, "Agents", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getAgents_Agents(), this.getAgent(), null, "agents", null, 0, -1, Agents.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(agentEClass, Agent.class, "Agent", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getAgent_Name(), ecorePackage.getEString(), "name", null, 0, 1, Agent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getAgent_SourceFile(), this.getFileName(), null, "sourceFile", null, 0, 1, Agent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getAgent_Options(), this.getOptions(), null, "options", null, 0, 1, Agent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getAgent_AgentArchClass(), this.getAgentArchClass(), null, "agentArchClass", null, 0, -1, Agent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getAgent_BeliefBaseClass(), this.getBeliefBaseClass(), null, "beliefBaseClass", null, 0, -1, Agent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getAgent_AgentClass(), this.getAgentClass(), null, "agentClass", null, 0, -1, Agent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getAgent_Instances(), this.getInstances(), null, "instances", null, 0, -1, Agent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getAgent_Environment(), this.getEnvironmentLocus(), null, "environment", null, 0, -1, Agent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(fileNameEClass, FileName.class, "FileName", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getFileName_Path(), ecorePackage.getEString(), "path", null, 0, 1, FileName.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getFileName_Asid(), ecorePackage.getEString(), "asid", null, 0, -1, FileName.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(environmentLocusEClass, EnvironmentLocus.class, "EnvironmentLocus", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getEnvironmentLocus_EnvironmentLocus(), ecorePackage.getEString(), "environmentLocus", null, 0, 1, EnvironmentLocus.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(optionsEClass, Options.class, "Options", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getOptions_Options(), this.getOption(), null, "options", null, 0, -1, Options.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(optionEClass, Option.class, "Option", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(eventsEClass, Events.class, "Events", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(intBelsEClass, IntBels.class, "IntBels", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(nrcbpEClass, Nrcbp.class, "Nrcbp", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getNrcbp_Val(), ecorePackage.getEInt(), "val", null, 0, 1, Nrcbp.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(verboseEClass, Verbose.class, "Verbose", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getVerbose_Val(), ecorePackage.getEInt(), "val", null, 0, 1, Verbose.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(otherOptionEClass, OtherOption.class, "OtherOption", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getOtherOption_OptionName(), ecorePackage.getEString(), "optionName", null, 0, 1, OtherOption.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getOtherOption_Val(), ecorePackage.getEString(), "val", null, 0, 1, OtherOption.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getOtherOption_Int_val(), ecorePackage.getEInt(), "int_val", null, 0, 1, OtherOption.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(agentArchClassEClass, AgentArchClass.class, "AgentArchClass", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getAgentArchClass_AgentArchClass(), this.getClsDef(), null, "agentArchClass", null, 0, 1, AgentArchClass.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(beliefBaseClassEClass, BeliefBaseClass.class, "BeliefBaseClass", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getBeliefBaseClass_BeliefBaseClass(), this.getClsDef(), null, "beliefBaseClass", null, 0, 1, BeliefBaseClass.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(agentClassEClass, AgentClass.class, "AgentClass", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getAgentClass_AgentClass(), this.getClsDef(), null, "agentClass", null, 0, 1, AgentClass.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(instancesEClass, Instances.class, "Instances", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getInstances_Instances(), ecorePackage.getEInt(), "instances", null, 0, 1, Instances.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(discardEventsEClass, DiscardEvents.class, "DiscardEvents", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(requeueEventsEClass, RequeueEvents.class, "RequeueEvents", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(retrieveEventsEClass, RetrieveEvents.class, "RetrieveEvents", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(sameFocusEClass, SameFocus.class, "SameFocus", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(newFocusEClass, NewFocus.class, "NewFocus", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    // Create resource
    createResource(eNS_URI);
  }

} //Mas2jPackageImpl
