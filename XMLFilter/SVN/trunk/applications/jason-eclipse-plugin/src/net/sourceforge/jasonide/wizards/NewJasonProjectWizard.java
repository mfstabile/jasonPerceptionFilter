package net.sourceforge.jasonide.wizards;

import java.lang.reflect.InvocationTargetException;

import net.sourceforge.jasonide.core.ProjectCreation;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchWizard;
import org.eclipse.ui.wizards.newresource.BasicNewProjectResourceWizard;

/**
 * This wizard creates a new Jason project.
 * Jason project contains two initial files:<br>
 *  - <b>project_name.mas2j</b> - Main Jason project file.<br>
 *  - <b>environment_classname.java</b> - Java based environment class.
 * 
 * @author Germano
 * @version 1.0.0
 */
public class NewJasonProjectWizard extends BasicNewProjectResourceWizard implements INewWizard {
    
    private NewJasonProjectWizardPage page;
    private ISelection selection;
    private ProjectCreation projectCreation;

    /**
     * Constructor for NewJasonProjectWizard.
     */
    public NewJasonProjectWizard() {
        super();
        setNeedsProgressMonitor(true);
        setWindowTitle("Jason Project");
        projectCreation = new ProjectCreation(getShell());
    }
    
    /**
     * Adding the page to the wizard.
     */
    public void addPages() {
        page = new NewJasonProjectWizardPage(selection);
        addPage(page);
    }

    /**
     * This method is called when 'Finish' button is pressed in
     * the wizard. We will create an operation and run it
     * using wizard as execution context.
     */
    public boolean performFinish() {
        
        final String classFileName = page.getEnvironmentClassFileName();
        final String infrastructure = page.getInfrastructure();     
        final IProject newProject = page.getProjectHandle();

        IRunnableWithProgress op = new IRunnableWithProgress() {
            public void run(IProgressMonitor monitor) throws InvocationTargetException {
                try {
                    doFinish(newProject, classFileName, infrastructure, monitor);
                } catch (CoreException e) {
                    throw new InvocationTargetException(e);
                } finally {
                    monitor.done();
                }
            }
        };
        try {
            getContainer().run(true, false, op);
        } catch (InterruptedException e) {
            return false;
        } catch (InvocationTargetException e) {
            Throwable realException = e.getTargetException();
            MessageDialog.openError(getShell(), "Error", realException.getMessage());
            return false;
        }
        return true;
    }
    
    /**
     * The worker method. It will find the container, create the
     * file if missing or just replace its contents, and open
     * the editor on the newly created file.
     */
    private void doFinish(IProject newProject, String envClassName, String infraStructure, IProgressMonitor monitor) throws CoreException {     
        monitor.beginTask("Creating the project " + newProject.getName(), 2);
        
        try {
            // create a new jason project.
            newProject.create(monitor);
            String projectRootDir = newProject.getLocation().toString();
            String projectName = newProject.getName();
            
            // create the project directories for sources.
            projectCreation.createProjectDirs(projectRootDir);
            
            // create the settings directory and core/ui prefs.
            projectCreation.createSettingsDir(projectRootDir);

            // create .classpath file
            projectCreation.createClassPathFile(projectRootDir);
            
            // contains environment?
            if (envClassName.length() > 0) {
                projectCreation.createEnvironmentClass(projectRootDir, envClassName, projectName);
            }
            
            // create initial files.
            projectCreation.createSampleAgentFile(projectRootDir, projectName);
            projectCreation.createMas2JFile(projectRootDir, projectName, infraStructure, envClassName);
            
            // open project and refesh local.
            newProject.open(monitor);
            
            // create the build.properties of the project.
            projectCreation.createBuildPropertiesFile(projectRootDir);
            
            // configure the .project file.
            projectCreation.configureProjectEnvironment(newProject, monitor);
            
            // create the project launchers (Run e Debug).
            projectCreation.createProjectLaunchConfiguration(projectRootDir, projectName, null, newProject, false);
            projectCreation.createProjectLaunchConfiguration(projectRootDir, projectName, null, newProject, true);
            
            // refresh the project after all these changes.
            newProject.getWorkspace().getRoot().refreshLocal(IWorkspaceRoot.DEPTH_INFINITE, monitor);
            monitor.beginTask("Project created in current workspace", 2);
        } catch (Exception e) {
            MessageDialog.openError(getShell(), "Error", e.getMessage());
        }
    }
    
    /**
     * We will accept the selection in the workbench to see if
     * we can initialize from it.
     * @see IWorkbenchWizard#init(IWorkbench, IStructuredSelection)
     */
    public void init(IWorkbench workbench, IStructuredSelection selection) {
        this.selection = selection;
    }
}
