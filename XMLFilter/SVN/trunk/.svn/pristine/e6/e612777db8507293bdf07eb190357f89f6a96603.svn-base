package jasonide.ui.wizards;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.jdt.core.IJavaElement;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.ITreeSelection;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.List;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IWorkbench;

public class JasonWizardPage extends WizardPage implements Listener {
	protected String projectsListLabel;
	protected IWorkbench workbench;
	protected IStructuredSelection selection;
	protected Shell shell;
	protected Composite composite;
	protected List projectsList;
	protected IStatus projectStatus;
	
	public JasonWizardPage(String title, String description, String projectsListLabel, 
			IWorkbench workbench, IStructuredSelection selection) {
		super(title);
		this.projectsListLabel = projectsListLabel;
		this.workbench = workbench;
		this.selection = selection;
		shell = workbench.getActiveWorkbenchWindow().getShell();
		setTitle(title);
		setDescription(description);
		projectStatus = new Status(IStatus.OK, "not_used", 0, "", null);
	} 

	@Override
	public void createControl(Composite parent) {
		composite = new Composite(parent, SWT.NONE);
		GridLayout layout = new GridLayout();
		int nCols = 3;
		layout.numColumns = nCols;
		composite.setLayout(layout);
		composite.setLayoutData(new GridData(GridData.HORIZONTAL_ALIGN_FILL | GridData.VERTICAL_ALIGN_FILL));
		
		Label projectLabel = new Label(composite, SWT.NONE);
		projectLabel.setText(projectsListLabel);
		GridData gridData = new GridData();
		gridData.horizontalSpan = nCols;
		projectLabel.setLayoutData(gridData);
		
		projectsList = new List(composite, SWT.BORDER | SWT.V_SCROLL);
		addProjectsToList();
		gridData = new GridData(SWT.FILL, SWT.FILL, true, false, nCols, 1);
		int listHeight = projectsList.getItemHeight() * 3;
		Rectangle trim = projectsList.computeTrim(0, 0, 0, listHeight);
		gridData.heightHint = trim.height;
		projectsList.setLayoutData(gridData);
		projectsList.addListener(SWT.Selection, this);
		initProjectSelection();
		
		createLine(composite, nCols);
		setControl(composite);
	}

	private void initProjectSelection() {
		if (selection instanceof ITreeSelection) {
			ITreeSelection ts = (ITreeSelection)selection;
			Object firstElement = ts.getFirstElement();
			IProject project = null;
			
			if (firstElement instanceof IProject){
				project = (IProject)firstElement;
			} else if (firstElement instanceof IResource){
				IResource res = (IResource)firstElement;
				project = res.getProject();
			} else if (firstElement instanceof IJavaElement){
				IJavaElement javaElement = (IJavaElement)firstElement;
				IResource res = javaElement.getResource();
        		project = res.getProject();
			}
			
			if (project != null){
				projectsList.select(projectsList.indexOf(project.getName()));
			}
		}
	}
	
	protected IProject getSelectedProject(){
		String[] selection = projectsList.getSelection();
		IWorkspace workspace = ResourcesPlugin.getWorkspace();
		IWorkspaceRoot root = workspace.getRoot();
		IProject project = root.getProject(selection[0]);
		
		if (project.exists()){
			return project;
		} else {
			return null;
		}
	}
	
	protected void checkProjectsList(){
		Status status = new Status(IStatus.OK, "not_used", 0, "", null);
		
		if (projectsList.getSelectionCount() == 0){
			status = new Status(IStatus.ERROR, "not_used", 0, "Select a project", null);
		}
		projectStatus = status;
	}
	
	private void addProjectsToList() {
		IWorkspace workspace = ResourcesPlugin.getWorkspace();
		IWorkspaceRoot root = workspace.getRoot();
		IProject[] projects = root.getProjects();
		
		for (IProject project : projects){
			try {
				if (project.isNatureEnabled("jasonide.jasonNature")){
					projectsList.add(project.getName());
				}
			} catch (CoreException e) {
				//e.printStackTrace();
				//MessageDialog.openError(shell, "CoreException", e.getMessage());
			}
		}
	}
	
	private void createLine(Composite parent, int nCols){
		Label line = new Label(parent, SWT.SEPARATOR | SWT.HORIZONTAL | SWT.BOLD);
		GridData gridData = new GridData(GridData.FILL_HORIZONTAL);
		gridData.horizontalSpan = nCols;
		line.setLayoutData(gridData);
	}
	
	@Override
	public void handleEvent(Event event){
	}
}
