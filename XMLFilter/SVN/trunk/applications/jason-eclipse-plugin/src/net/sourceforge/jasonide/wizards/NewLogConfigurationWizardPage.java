package net.sourceforge.jasonide.wizards;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.Path;
import org.eclipse.jdt.core.ICompilationUnit;
import org.eclipse.jdt.core.IJavaElement;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.IPackageFragment;
import org.eclipse.jdt.core.IPackageFragmentRoot;
import org.eclipse.jface.dialogs.IDialogPage;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ITreeSelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.dialogs.ContainerSelectionDialog;

/**
 * The "New" wizard page allows setting the container for the new file as well
 * as the file name. The page will only accept file name without the extension
 * OR with the extension that matches the expected one (java).
 */
public class NewLogConfigurationWizardPage extends WizardPage {
    private Text containerText;
    private ISelection selection;

    /**
     * Constructor for SampleNewWizardPage.
     * 
     * @param pageName
     */
    public NewLogConfigurationWizardPage(ISelection selection) {
        super("wizardPage");
        
        setTitle("New Log Configuration");
        setDescription("This wizard creates a new Log Configuration file properties.");
        this.selection = selection;
    }

    /**
     * @see IDialogPage#createControl(Composite)
     */
    public void createControl(Composite parent) {
        Composite container = new Composite(parent, SWT.NULL);
        GridLayout layout = new GridLayout();
        container.setLayout(layout);
        layout.numColumns = 3;
        layout.verticalSpacing = 9;
        
        Label label = new Label(container, SWT.NULL);
        label.setText("&Project:");

        containerText = new Text(container, SWT.BORDER | SWT.SINGLE);
        GridData gd = new GridData(GridData.FILL_HORIZONTAL);
        containerText.setLayoutData(gd);
        containerText.addModifyListener(new ModifyListener() {
            public void modifyText(ModifyEvent e) {
                dialogChanged();
            }
        });

        Button button = new Button(container, SWT.PUSH);
        button.setText("Browse...");
        button.addSelectionListener(new SelectionAdapter() {
            public void widgetSelected(SelectionEvent e) {
                handleBrowseSourceFolder();
            }
        });
        
        initialize();
        dialogChanged();
        setControl(container);
    }

    /**
     * Tests if the current workbench selection is a suitable container to use.
     */
    private void initialize() {
        String containerName = null;
        
        if (selection instanceof ITreeSelection) {
            ITreeSelection ts = (ITreeSelection)selection;
            
            Object firstElement = ts.getFirstElement();
            if (firstElement != null) {
                // is a Java Project Root
                if (firstElement instanceof IJavaProject) {
                    IJavaProject pfr = (IJavaProject)firstElement;
                     
                    if (pfr.getPath().segmentCount() > 0) {
                        containerName = pfr.getPath().segments()[0];
                        for (int i = 1; i < pfr.getPath().segmentCount(); i++) {
                            containerName += "/" + pfr.getPath().segments()[i];
                        }
                    }
                }
                // is a Source Folder?
                else if (firstElement instanceof IPackageFragmentRoot) {
                    IPackageFragmentRoot pfr = (IPackageFragmentRoot)firstElement;
                     
                    if (pfr.getPath().segmentCount() > 0) {
                        containerName = pfr.getPath().segments()[0];
                        for (int i = 1; i < pfr.getPath().segmentCount(); i++) {
                            containerName += "/" + pfr.getPath().segments()[i];
                        }
                    }
                }
                // is a Package?
                else if (firstElement instanceof IPackageFragment) {
                    IPackageFragment pfr = (IPackageFragment)firstElement;
                    
                    IJavaElement parent = pfr.getParent();
                    if (parent.getPath().segmentCount() > 0) {
                        containerName = parent.getPath().segments()[0];
                        for (int i = 1; i < parent.getPath().segmentCount(); i++) {
                            containerName += "/" + parent.getPath().segments()[i];
                        }
                    }
                }
                // is a file?
                else if (firstElement instanceof ICompilationUnit) {
                    ICompilationUnit pfr = (ICompilationUnit)firstElement;
                    IJavaElement parent = pfr.getParent();
                    while (!(parent instanceof IJavaProject)) {
                        if (parent instanceof IPackageFragmentRoot) {
                            //System.out.println("source folder:" + parent.getPath().segments()[parent.getPath().segments().length-1]);
                            if (containerName == null) {
                                if (parent.getPath().segmentCount() > 0) {
                                    containerName = parent.getPath().segments()[0];
                                    for (int i = 1; i < parent.getPath().segmentCount(); i++) {
                                        containerName += "/" + parent.getPath().segments()[i];
                                    }
                                }
                                break;
                            }
                        }
                        
                        parent = parent.getParent();
                    }
                }
            }   
        }
        else if (selection instanceof StructuredSelection) {
            IWorkspaceRoot root = ResourcesPlugin.getWorkspace().getRoot();
            IProject[] projects = root.getProjects();
            for (int i = 0; i < projects.length; i++) {
                if (projects[i].isOpen()) {
                    containerName = projects[i].getName();
                    break;
                }
            }
        }
        
        if (containerName != null) {
            containerText.setText(containerName);
        }
    }

    /**
     * Uses the standard container selection dialog to choose the new value for
     * the container field.
     */
    private void handleBrowseSourceFolder() {
        ContainerSelectionDialog dialog = new ContainerSelectionDialog(
                getShell(), ResourcesPlugin.getWorkspace().getRoot(), false,
                "Select new file container");
        if (dialog.open() == ContainerSelectionDialog.OK) {
            Object[] result = dialog.getResult();
            if (result.length == 1) {
                containerText.setText(((Path) result[0]).toString());
            }
        }
    }
    
    /**
     * Ensures that both text fields are set.
     */
    private void dialogChanged() {
        IResource container = ResourcesPlugin.getWorkspace().getRoot()
                .findMember(new Path(getContainerName()));
        if (getContainerName().length() == 0) {
            updateStatus("File container must be specified");
            return;
        }
        if (container == null
                || (container.getType() & (IResource.PROJECT | IResource.FOLDER)) == 0) {
            updateStatus("File container must exist");
            return;
        }
        if (!container.isAccessible()) {
            updateStatus("Project must be writable");
            return;
        }
        updateStatus(null);
    }

    private void updateStatus(String message) {
        setErrorMessage(message);
        setMessage(null);
        setPageComplete(message == null);
    }

    public String getContainerName() {
        return containerText.getText();
    }
}
