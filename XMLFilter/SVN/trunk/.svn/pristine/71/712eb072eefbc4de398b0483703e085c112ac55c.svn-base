package net.sourceforge.jasonide.popup.actions;

/**
 * VM launcher for Jason, such as Jason will run  
 * from eclipse console.
 * @author krupa@emse.fr
 */

import jason.jeditplugin.Config;


import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.debug.core.DebugPlugin;
import org.eclipse.debug.core.ILaunchConfigurationType;
import org.eclipse.debug.core.ILaunchConfigurationWorkingCopy;
import org.eclipse.debug.core.ILaunchManager;
import org.eclipse.debug.core.Launch;
import org.eclipse.debug.ui.IDebugUIConstants;
import org.eclipse.jdt.launching.IJavaLaunchConfigurationConstants;
import org.eclipse.jdt.launching.IVMInstall;
import org.eclipse.jdt.launching.IVMRunner;
import org.eclipse.jdt.launching.JavaRuntime;
import org.eclipse.jdt.launching.VMRunnerConfiguration;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IObjectActionDelegate;
import org.eclipse.ui.IWorkbenchPart;

public class RunJason implements IObjectActionDelegate {

    private String filename;

    /**
     * Constructor for Action1.
     */
    public RunJason() {
        super();
    }

    /**
     * @see IObjectActionDelegate#setActivePart(IAction, IWorkbenchPart)
     */
    public void setActivePart(IAction action, IWorkbenchPart targetPart) {
    }

    /**
     * @see IActionDelegate#run(IAction)
     */
    public void run(IAction action) {
        
            String[] pargs={filename,action.getActionDefinitionId()};
            
            runParser(pargs);
    }

    private static void runParser(String[] programArgs) {
         
            IVMInstall ivmi=JavaRuntime.getDefaultVMInstall();
        
            ILaunchConfigurationType launchType =
                DebugPlugin.getDefault().getLaunchManager().getLaunchConfigurationType(IJavaLaunchConfigurationConstants.ID_JAVA_APPLICATION);

            try {
            
            ILaunchConfigurationWorkingCopy conf = launchType.newInstance(null, "Jason");
            conf.setAttribute(IDebugUIConstants.ATTR_PRIVATE, true);
            conf.setAttribute(
                    IDebugUIConstants.ATTR_TARGET_DEBUG_PERSPECTIVE,
                    IDebugUIConstants.PERSPECTIVE_DEFAULT);
            conf.setAttribute(
                    IDebugUIConstants.ATTR_TARGET_RUN_PERSPECTIVE,
                    IDebugUIConstants.PERSPECTIVE_DEFAULT);
            Launch launch = new Launch(conf,ILaunchManager.DEBUG_MODE,null);
            conf.doSave();
            // ClassPath
            String[] cp =  {Config.get().getJasonJar()};
            VMRunnerConfiguration vmConfig =
                new VMRunnerConfiguration("jason.mas2j.parser.mas2j", cp);

            //Prog Args
            vmConfig.setProgramArguments(programArgs);
            IVMRunner vmRunner = ivmi.getVMRunner(ILaunchManager.DEBUG_MODE);
            vmRunner.run(vmConfig, launch, null);

            DebugPlugin.getDefault().getLaunchManager().addLaunch(launch);
            } catch (CoreException e) {
                Shell shell = new Shell();
                MessageDialog.openInformation(
                        shell,
                        "Jasonide Plug-in",
                        e.getMessage());
            }
    }

    /**
     * @see IActionDelegate#selectionChanged(IAction, ISelection)
     */
    public void selectionChanged(IAction action, ISelection selection) {
        if (selection != null && selection instanceof ISelection) {
            IStructuredSelection strucSel = (IStructuredSelection) selection;
                filename=(((IFile)strucSel.getFirstElement()).getLocation().toString());    
            }
        } 
    

}
