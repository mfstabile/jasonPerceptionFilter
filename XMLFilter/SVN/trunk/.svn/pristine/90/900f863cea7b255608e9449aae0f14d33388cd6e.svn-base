/*******************************************************************************
 * Copyright (c) 2006 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/
package net.sourceforge.jasonide.importWizards;

import java.lang.reflect.InvocationTargetException;

import net.sourceforge.jasonide.core.ProjectCreation;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.ui.IImportWizard;
import org.eclipse.ui.IWorkbench;

public class JasonProjectImportWizard extends Wizard implements IImportWizard {
    
    private JasonProjectImportWizardPage page;
    private ProjectCreation projectCreation;

    public JasonProjectImportWizard() {
        super();
        projectCreation = new ProjectCreation(getShell());
    }

    /* (non-Javadoc)
     * @see org.eclipse.jface.wizard.Wizard#performFinish()
     */
    public boolean performFinish() {
        final String archiveFileName = page.getExternalProjectArchiveFilePath();
        final String projectName = page.getProjectName();
        
        IRunnableWithProgress op = new IRunnableWithProgress() {
            public void run(IProgressMonitor monitor) throws InvocationTargetException {
                try {
                    doFinish(archiveFileName, projectName, monitor);
                } catch (Exception e) {
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
    
    private void doFinish(String archiveFileName, String projectName, IProgressMonitor monitor) throws Exception {
        monitor.beginTask("Creating the project " + projectName, 2);
        
        // create a new Eclipse Jason Project
        IProject newProject = ResourcesPlugin.getWorkspace().getRoot().getProject(projectName);
        newProject.create(monitor);
        String projectRootDir = newProject.getLocation().toString();
        
        // create the project directories for sources.
        projectCreation.createProjectDirs(projectRootDir);
        
        // create the settings directory and core/ui prefs.
        projectCreation.createSettingsDir(projectRootDir);
        
        // create .classpath file
        projectCreation.createClassPathFile(projectRootDir);
        
        // open project and refesh local.
        newProject.open(monitor);
        
        // create the build.properties of the project.
        projectCreation.createBuildPropertiesFile(projectRootDir);
        
        // configure the .project file.
        projectCreation.configureProjectEnvironment(newProject, monitor);
        
        // import the resources from archive file.
        String mas2jFile = projectCreation.importResources(archiveFileName, projectRootDir);
        
        // create the project launchers (Run e Debug).
        projectCreation.createProjectLaunchConfiguration(projectRootDir, projectName, mas2jFile, newProject, false);
        projectCreation.createProjectLaunchConfiguration(projectRootDir, projectName, mas2jFile, newProject, true);
        
        // refresh the project after all these changes.
        newProject.getWorkspace().getRoot().refreshLocal(IWorkspaceRoot.DEPTH_INFINITE, monitor);
        monitor.beginTask("Project created in current workspace", 2);
    }
    
    /* (non-Javadoc)
     * @see org.eclipse.ui.IWorkbenchWizard#init(org.eclipse.ui.IWorkbench, org.eclipse.jface.viewers.IStructuredSelection)
     */
    public void init(IWorkbench workbench, IStructuredSelection selection) {
        setWindowTitle("Jason Project Import Wizard");
        setNeedsProgressMonitor(true);
    }
    
    /* (non-Javadoc)
     * @see org.eclipse.jface.wizard.IWizard#addPages()
     */
    public void addPages() {
        page = new JasonProjectImportWizardPage("Import Jason Project");
        addPage(page);        
    }
}
