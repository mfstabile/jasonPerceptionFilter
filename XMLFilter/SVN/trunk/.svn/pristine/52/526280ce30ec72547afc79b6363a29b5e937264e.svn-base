package net.sourceforge.jasonide.wizards;

import jason.jeditplugin.Config;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;

import net.sourceforge.jasonide.Activator;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Status;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWizard;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.ide.IDE;

/**
 * Wizard for create a new Internal Action with default contents.
 * @author Germano
 */
public class NewInternalActionWizard extends Wizard implements INewWizard {
    private NewInternalActionWizardPage page;
    private ISelection selection;

    /**
     * Constructor for NewInternalActionWizard.
     */
    public NewInternalActionWizard() {
        super();
        setNeedsProgressMonitor(true);
    }
    
    /**
     * Adding the page to the wizard.
     */

    public void addPages() {
        page = new NewInternalActionWizardPage(selection);
        addPage(page);
    }

    /**
     * This method is called when 'Finish' button is pressed in
     * the wizard. We will create an operation and run it
     * using wizard as execution context.
     */
    public boolean performFinish() {
        String tmpContainerName = page.getContainerName();
        final String packageName = page.getPackageName();
        
        if (packageName != null) {
            tmpContainerName += "/" + packageName.replace(".", "/");
        }
        
        final String containerName = tmpContainerName;
        final String fileName = page.getFileName();
        IRunnableWithProgress op = new IRunnableWithProgress() {
            public void run(IProgressMonitor monitor) throws InvocationTargetException {
                try {
                    doFinish(containerName, packageName, fileName, monitor);
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

    private void doFinish(String containerName, String packageName, String fileName, IProgressMonitor monitor) throws CoreException {
        //new File(tmpContainerName).mkdirs();
        
        // create a sample file
        monitor.beginTask("Creating " + fileName, 2);
        IWorkspaceRoot root = ResourcesPlugin.getWorkspace().getRoot();

        // if necessary, create the packages.
        containerName = createPackages(containerName, monitor, root);
        
        IResource resource = root.findMember(new Path(containerName));
        if ((resource == null) || (!resource.exists() || !(resource instanceof IContainer))) {
            throwCoreException("Container \"" + containerName + "\" does not exist.");
        }
        
        IContainer container = (IContainer) resource;       
        final IFile file = container.getFile(new Path(fileName + ".java"));
        try {
            InputStream stream = openContentStream(containerName, packageName, fileName);
            if (file.exists()) {
                file.setContents(stream, true, true, monitor);
            } else {
                file.create(stream, true, monitor);
            }
            stream.close();
        } catch (IOException e) {
            MessageDialog.openError(getShell(), "Error", e.getMessage());
        }
        monitor.worked(1);
        monitor.setTaskName("Opening file for editing...");
        getShell().getDisplay().asyncExec(new Runnable() {
            public void run() {
                IWorkbenchPage page =
                    PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
                try {
                    IDE.openEditor(page, file, true);
                } catch (PartInitException e) {
                    MessageDialog.openError(getShell(), "Error", e.getMessage());
                }
            }
        });
        monitor.worked(1);
    }

    private String createPackages(String containerName, IProgressMonitor monitor, IWorkspaceRoot root) throws CoreException {
        String rootLocation = root.getLocation().toString();
        
        if (!containerName.startsWith("/")) {
            containerName = "/" + containerName;
        }
        new File(rootLocation + containerName).mkdirs();
        root.refreshLocal(IWorkspaceRoot.DEPTH_INFINITE, monitor);
        return containerName;
    }
    
    /**
     * We will initialize file contents with a sample text.
     */

    private InputStream openContentStream(String containerName, String packageName, String fileName) throws CoreException {
        try {
            String iaCode = Config.get().getTemplate("ia");
            
            String iaName = fileName;
            String projectName = containerName.split("/")[1];
            
            iaCode = iaCode.replace("<IA_NAME>", iaName);
            iaCode = iaCode.replace("<PROJECT_NAME>", projectName);
            iaCode = iaCode.replace("<SUPER_CLASS>", "DefaultInternalAction");        
            
            if (packageName != null) {
                iaCode = iaCode.replace("<PCK>", packageName);
            }
            
            return new ByteArrayInputStream(iaCode.getBytes());
        } catch (Exception e) {
            e.printStackTrace();
            throwCoreException(e.getMessage());
            return null;
        }
    }

    private void throwCoreException(String message) throws CoreException {
        IStatus status =
            new Status(IStatus.ERROR, Activator.getPluginId(), IStatus.OK, message, null);
        throw new CoreException(status);
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
