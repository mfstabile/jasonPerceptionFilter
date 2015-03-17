package net.sourceforge.jasonide.wizards;

import jason.jeditplugin.Config;
import jason.mas2j.AgentParameters;
import jason.mas2j.MAS2JProject;
import jason.mas2j.parser.ParseException;

import java.io.ByteArrayInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import net.sourceforge.jasonide.Activator;
import net.sourceforge.jasonide.core.JasonPluginException;
import net.sourceforge.jasonide.core.MAS2JHandler;
import net.sourceforge.jasonide.editors.MAS2JEditor;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Status;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IEditorReference;
import org.eclipse.ui.IFileEditorInput;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.IWorkbenchWizard;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.ide.IDE;

/**
 * Wizard for create a new agent with default contents.
 * @author Germano
 */
public class NewAgentWizard extends Wizard implements INewWizard {
    private NewAgentWizardPage page;
    private ISelection selection;

    /**
     * Constructor for NewFileAgentWizard.
     */
    public NewAgentWizard() {
        super();
        setNeedsProgressMonitor(true);
    }
    
    /**
     * Adding the page to the wizard.
     */
    public void addPages() {
        page = new NewAgentWizardPage(selection);
        addPage(page);
    }

    /**
     * This method is called when 'Finish' button is pressed in
     * the wizard. We will create an operation and run it
     * using wizard as execution context.
     */
    public boolean performFinish() {
        String containerName = page.getContainerName();
        String fileName = page.getFileName();
        
        try {
            doFinish(containerName, fileName);
        } catch (CoreException e) {
            MessageDialog.openError(getShell(), "Error", e.getMessage());
        }
        return true;
    }
    
    /**
     * The worker method. It will find the container, create the
     * file if missing or just replace its contents, and open
     * the editor on the newly created file.
     */
    private void doFinish(String containerName, String fileName) throws CoreException {
        
        // create a sample file
        IWorkspaceRoot root = ResourcesPlugin.getWorkspace().getRoot();

        IResource resource = root.findMember(new Path(containerName));
        if (!resource.exists() || !(resource instanceof IContainer)) {
            throwCoreException("Container \"" + containerName + "\" does not exist.");
        }
        IContainer container = (IContainer) resource;
        
        final IFile file = container.getFile(new Path(fileName));
        try {
            InputStream stream = openContentStream(containerName, fileName);
            if (file.exists()) {
                file.setContents(stream, true, true, null);
            } else {
                file.create(stream, true, null);
                registerNewAgentInMas2JProjectFile(resource, file);
            }
            stream.close();
        } catch (IOException e) {
            MessageDialog.openError(getShell(), "Error", e.getMessage());
        }
        
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
    }
    
    /**
     * Register the new created agent in Mas2j file project.
     * @param resource
     * @param file
     * @throws CoreException
     */
    private void registerNewAgentInMas2JProjectFile(IResource resource, IFile file) throws CoreException {
        IDocument document = null;
        
        String projectName = file.getProject().getName();
        
        IWorkbenchWindow[] windows = PlatformUI.getWorkbench().getWorkbenchWindows();
        for (int i = 0; i < windows.length; i++) {
            IWorkbenchPage[] pages = windows[i].getPages();
            for (int j = 0; j < pages.length; j++) {
                IEditorReference[] editors = pages[j].getEditorReferences();
                for (int k = 0; k < editors.length; k++) {
                    IEditorPart part = editors[k].getEditor(false); 
                    if (part != null) {
                        if (part instanceof MAS2JEditor) {
                            String projectNameToCompare = ((IFileEditorInput)part.getEditorInput()).getFile().getProject().getName();
                            if (projectName.equals(projectNameToCompare)) {
                                document = ((MAS2JEditor)part).getEditor().getDocumentProvider().getDocument(part.getEditorInput());
                            }
                        }
                    }
                }
            }
        } 
        
        try {   
            // mas2j editor is open? yes: then modify contents of editor, no: then modify contents of file.
            if (document == null) {
                
                // get the mas2j file path, if null then mas2j is not located in project directory.
                String mas2jFilePath = MAS2JHandler.getMas2JFilePath(file.getProject().getLocation().toString());
                if (mas2jFilePath != null) {
                    // parse the mas2j file project.
                    MAS2JProject project2 = MAS2JHandler.parse(mas2jFilePath);
                    
                    AgentParameters ag = new AgentParameters();
                    ag.name = file.getName().replace(MAS2JHandler.AS_EXT, ""); // removes the file extension.
                    project2.addAgent(ag);
                    
                    String mas2jContents = MAS2JHandler.mas2jProjectToString(project2);
                    MAS2JHandler.persistMas2JFile(file.getProject(), mas2jContents);
                }
            }
            else {
                String tempFileName = MAS2JHandler.persistTempMas2JFile(file.getProject(), document.get());
                try {
                    MAS2JProject project2 = MAS2JHandler.parse(tempFileName);
                    
                    AgentParameters ag = new AgentParameters();
                    ag.name = file.getName().replace(MAS2JHandler.AS_EXT, ""); // removes the file extension.
                    project2.addAgent(ag);
                    
                    String mas2jContents = MAS2JHandler.mas2jProjectToString(project2);
                    document.set(mas2jContents);
                }
                finally {
                    MAS2JHandler.deleteMas2JTempFile(tempFileName);
                }
            }
        } catch (ParseException e1) {
            MessageDialog.openError(getShell(), "Error", e1.getMessage());
        } catch (FileNotFoundException e1) {
            MessageDialog.openError(getShell(), "Error", e1.getMessage());
        } catch (JasonPluginException e1) {
            MessageDialog.openError(getShell(), "Error", e1.getMessage());
        }
    }
    
    /**
     * We will initialize file contents with a sample text.
     */
    private InputStream openContentStream(String containerName, String fileName) {
        try {
            String agentFileContents = Config.get().getTemplate("agent");

            fileName = fileName.replace(".", ">");
            String agentName = fileName.split(">")[0];
            String projectName = containerName.split("/")[1];
            
            agentFileContents = agentFileContents.replace("<AG_NAME>", agentName);
            agentFileContents = agentFileContents.replace("<PROJECT_NAME>", projectName);
            
            return new ByteArrayInputStream(agentFileContents.getBytes());
        } catch (Exception e) {
            e.printStackTrace();
            MessageDialog.openError(getShell(), "Error", e.getMessage());
            return null;
        }
    }

    /**
     * Throw CoreException for a given message.
     * @param message
     * @throws CoreException
     */
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
