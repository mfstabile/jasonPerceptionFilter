package net.sourceforge.jasonide.wizards;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Path;
import org.eclipse.jdt.core.ICompilationUnit;
import org.eclipse.jdt.core.IJavaElement;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.IPackageFragment;
import org.eclipse.jdt.core.IPackageFragmentRoot;
import org.eclipse.jdt.core.JavaConventions;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.jdt.ui.JavaUI;
import org.eclipse.jface.dialogs.IDialogPage;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
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
import org.eclipse.ui.dialogs.SelectionDialog;

/**
 * The "New" wizard page allows setting the container for the new file as well
 * as the file name. The page will only accept file name without the extension
 * OR with the extension that matches the expected one (java).
 */
public class NewEnvironmentWizardPage extends WizardPage {
    private Text containerText;
    private Text fileText;
    private Text packageText;

    private ISelection selection;
    private IPackageFragmentRoot root;
    private IWorkspaceRoot workspaceRoot;
    
    private String containerName;
    private String packageName;

    /**
     * Constructor for SampleNewWizardPage.
     * 
     * @param pageName
     */
    public NewEnvironmentWizardPage(ISelection selection) {
        super("wizardPage");
        
        if (selection instanceof ITreeSelection) {
            ITreeSelection ts = (ITreeSelection)selection;
            
            Object firstElement = ts.getFirstElement();
            if (firstElement != null) {
                if (firstElement instanceof IJavaProject) {
                    IJavaProject pfr = (IJavaProject)firstElement;
                    
                    if (pfr.getPath().segmentCount() > 0) {
                        containerName = pfr.getPath().segments()[0];
                        for (int i = 1; i < pfr.getPath().segmentCount(); i++) {
                            containerName += "/" + pfr.getPath().segments()[i];
                        }
                        
                        // default source folder for java classes
                        containerName += "/src/java";
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
                    
                    String[] names = ((org.eclipse.jdt.internal.core.PackageFragment)pfr).names; // TODO: fix that
                    if (names.length > 0) {
                        packageName = names[0];
                        for (int i = 1; i < names.length; i++) {
                            packageName += "." + names[i];
                        }
                    }
                    
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
                            }
                        }
                        else if (parent instanceof IPackageFragment) {
                            if (packageName == null) {
                                //System.out.println("eh pacote: " + parent.getPath().segments()[parent.getPath().segments().length-1]);
                                String[] names = ((org.eclipse.jdt.internal.core.PackageFragment)parent).names; // TODO: fix that
                                if (names.length > 0) {
                                    packageName = names[0];
                                    for (int i = 1; i < names.length; i++) {
                                        packageName += "." + names[i];
                                    }
                                }
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
                    containerName = projects[i].getName() + "/src/java";
                    break;
                }
            }
        }
        
        workspaceRoot = ResourcesPlugin.getWorkspace().getRoot();
        
        setTitle("New Environment Class");
        setDescription("This wizard creates a new Environment class.");
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
        label.setText("&Source Folder:");

        containerText = new Text(container, SWT.BORDER | SWT.SINGLE);
        GridData gd = new GridData(GridData.FILL_HORIZONTAL);
        containerText.setLayoutData(gd);
        containerText.addModifyListener(new ModifyListener() {
            public void modifyText(ModifyEvent e) {
                containerChanged();
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
        label = new Label(container, SWT.NULL);
        label.setText("&Package:");

        packageText = new Text(container, SWT.BORDER | SWT.SINGLE);
        gd = new GridData(GridData.FILL_HORIZONTAL);
        packageText.setLayoutData(gd);
        packageText.addModifyListener(new ModifyListener() {
            public void modifyText(ModifyEvent e) {
                packageChanged();
                dialogChanged();
            }
        });

        button = new Button(container, SWT.PUSH);
        button.setText("Browse...");
        button.addSelectionListener(new SelectionAdapter() {
            public void widgetSelected(SelectionEvent e) {
                handleBrowsePackage();
            }
        });
        
        
        label = new Label(container, SWT.NULL);
        label.setText("&Class name:");

        fileText = new Text(container, SWT.BORDER | SWT.SINGLE);
        gd = new GridData(GridData.FILL_HORIZONTAL);
        fileText.setLayoutData(gd);
        fileText.addModifyListener(new ModifyListener() {
            public void modifyText(ModifyEvent e) {
                dialogChanged();
            }
        });
        initialize();
        dialogChanged();
        setControl(container);
        
        if (containerName != null) {
            containerText.setText(containerName);
            packageText.setFocus();
        }
        else {
            containerText.setFocus();
        }
        
        if (packageName != null) {
            packageText.setText(packageName);
            fileText.setFocus();
        }
        else {
            if (containerName != null) {
                packageText.setFocus();
            }
        }
    }
    
    private void containerChanged() {       
        root= null;
        String str = containerText.getText();
        if (str.length() == 0) {
            
        }
        IPath path= new Path(str);
        IResource res= workspaceRoot.findMember(path);
        if (res != null) {  
            int resType= res.getType();
            if (resType == IResource.PROJECT || resType == IResource.FOLDER) {
                IProject proj= res.getProject();
                if (!proj.isOpen()) {

                }               
                IJavaProject jproject= JavaCore.create(proj);
                root= jproject.getPackageFragmentRoot(res);
                if (res.exists()) {
                    try {
                        if (!proj.hasNature(JavaCore.NATURE_ID)) {
                            if (resType == IResource.PROJECT) {
                                //status.setError(NewWizardMessages.NewContainerWizardPage_warning_NotAJavaProject); 
                            } else {
                                //status.setWarning(NewWizardMessages.NewContainerWizardPage_warning_NotInAJavaProject); 
                            }
                            //return status;
                        }
                        if (root.isArchive()) {
                            //status.setError(Messages.format(NewWizardMessages.NewContainerWizardPage_error_ContainerIsBinary, str)); 
                            //return status;
                        }
                        if (root.getKind() == IPackageFragmentRoot.K_BINARY) {
                            //status.setWarning(Messages.format(NewWizardMessages.NewContainerWizardPage_warning_inside_classfolder, str)); 
                        } else if (!jproject.isOnClasspath(root)) {
                            //status.setWarning(Messages.format(NewWizardMessages.NewContainerWizardPage_warning_NotOnClassPath, str)); 
                        }       
                    } catch (CoreException e) {
                        //status.setWarning(NewWizardMessages.NewContainerWizardPage_warning_NotAJavaProject); 
                    }
                }
                //return status;
            } else {
                //status.setError(Messages.format(NewWizardMessages.NewContainerWizardPage_error_NotAFolder, str)); 
                //return status;
            }
        } else {
            //status.setError(Messages.format(NewWizardMessages.NewContainerWizardPage_error_ContainerDoesNotExist, str)); 
            //return status;
        }
    }
    
    private void packageChanged() {
        if (root != null) {
            String packName= packageText.getText();
            if (packName.length() > 0) {
                IStatus val= JavaConventions.validatePackageName(packName);
                if (val.getSeverity() == IStatus.ERROR) {
                    setMessage("Package name is not valid.", ERROR);
                    //status.setError(Messages.format(NewWizardMessages.NewTypeWizardPage_error_InvalidPackageName, val.getMessage())); 
                    //return status;
                } else if (val.getSeverity() == IStatus.WARNING) {
                    setMessage("Package name is not correct.", WARNING);
                    //status.setWarning(Messages.format(NewWizardMessages.NewTypeWizardPage_warning_DiscouragedPackageName, val.getMessage())); 
                    // continue
                }
            } else {
                setMessage("The use of the default package is discouraged.", WARNING);
                //status.setWarning(NewWizardMessages.NewTypeWizardPage_warning_DefaultPackageDiscouraged); 
            }
        }
    }

    /**
     * Tests if the current workbench selection is a suitable container to use.
     */

    private void initialize() {
        if (selection != null && selection.isEmpty() == false
                && selection instanceof IStructuredSelection) {
            IStructuredSelection ssel = (IStructuredSelection) selection;
            if (ssel.size() > 1)
                return;
            Object obj = ssel.getFirstElement();
            if (obj instanceof IResource) {
                IContainer container;
                if (obj instanceof IContainer)
                    container = (IContainer) obj;
                else
                    container = ((IResource) obj).getParent();
                containerText.setText(container.getFullPath().toString());
            }
        }
        fileText.setText("");
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

    private void handleBrowsePackage() {
        if (root != null) {
            try {
                SelectionDialog dialog = JavaUI.createPackageDialog(getShell(), root);
                dialog.setTitle("Package Selection");
                dialog.setInitialSelections(new String[] {getPackageName()});
                if (dialog.open() == SelectionDialog.OK) {
                    Object[] result = dialog.getResult();
                    if (result.length == 1) {
                        String[] names = ((org.eclipse.jdt.internal.core.PackageFragment)result[0]).names; // TODO: fix that
                        if (names.length > 0) {
                            packageName = names[0];
                            for (int i = 1; i < names.length; i++) {
                                packageName += "." + names[i];
                            }
                        }
                        
                        packageText.setText(packageName);
                    }
                }
            } catch (JavaModelException e) {
                e.printStackTrace();
            }
        }
        else {
            // mensage: first of all, select the source folder.
        }
    }
    
    /**
     * Ensures that both text fields are set.
     */
    private void dialogChanged() {
        IResource container = ResourcesPlugin.getWorkspace().getRoot().findMember(new Path(getContainerName()));
        String fileName = getFileName();
        String packageName = getPackageName();
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
        if (packageName == null || packageName.length() == 0) {
            updateStatus("Package name must be specified");
            return;
        }
        if (fileName.length() == 0) {
            updateStatus("Class name must be specified");
            return;
        }
        else {
            IStatus val = JavaConventions.validateJavaTypeName(fileName);
            if (val.getSeverity() == IStatus.ERROR) {
                setMessage("Class name must be valid", ERROR);
                return;
            } else if (val.getSeverity() == IStatus.WARNING) {
                setMessage("Type name is discouraged. By convention, Java type names usually start with an uppercase letter", WARNING);
                return;
            }
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

    public String getPackageName() {
        return packageText.getText();
    }
    
    public String getFileName() {
        return fileText.getText();
    }
}
