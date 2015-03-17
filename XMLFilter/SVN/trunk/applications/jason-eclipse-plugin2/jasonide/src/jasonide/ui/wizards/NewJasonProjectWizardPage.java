package jasonide.ui.wizards;

import org.eclipse.core.resources.IProject;

import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Widget;

public class NewJasonProjectWizardPage extends WizardPage implements Listener {
	private Composite composite;
	private Label projectNameLabel;
	private Text projectNameText;
	
	private Label projectInfrastructureLabel;
	private Combo projectInfrastructureCombo;
	
	private Label projectEnvironmentLabel;
	private Combo projectEnvironmentCombo;
	
	private Label projectEnvironmentHostLabel;
	private Text projectEnvironmentHostText;
	
	private Label projectEnvironmentClassNameLabel;
	private Text projectEnvironmentClassNameText;
	
	private IStatus projectNameStatus, projectAlreadyExistsStatus;
	
	public NewJasonProjectWizardPage() {
		super("wizardPage");
		setTitle("New Jason Project");
		setDescription("This wizard creates a new Jason Project");
		projectNameStatus = new Status(IStatus.OK, "not_used", 0, "", null);
		projectAlreadyExistsStatus = new Status(IStatus.OK, "not_used", 0, "", null);
	}
 
	@Override
	public void createControl(Composite parent) {
		composite = new Composite(parent, SWT.NONE);
		GridLayout layout = new GridLayout();
		int nCols = 2;
		layout.numColumns = nCols;
		composite.setLayout(layout);
		composite.setLayoutData(new GridData(GridData.HORIZONTAL_ALIGN_FILL | GridData.VERTICAL_ALIGN_FILL));
		GridData gridData = new GridData(GridData.HORIZONTAL_ALIGN_FILL | GridData.GRAB_HORIZONTAL);
		gridData.widthHint = 250;
		
		//Project name
		projectNameLabel = new Label(composite, SWT.NONE);
		projectNameLabel.setText("Project name:");
		
		projectNameText = new Text(composite, SWT.BORDER | SWT.SINGLE);
		projectNameText.setLayoutData(gridData);
		projectNameText.addListener(SWT.Modify, this);
		projectNameText.setFocus();
		
		//Project infrastructure
		projectInfrastructureLabel = new Label(composite, SWT.NONE);
		projectInfrastructureLabel.setText("Infrastructure:");
		
		projectInfrastructureCombo = new Combo(composite, SWT.BORDER | SWT.SINGLE | SWT.READ_ONLY);
		projectInfrastructureCombo.add("Centralised");
		//projectInfrastructureCombo.add("Saci");
		projectInfrastructureCombo.add("Jade");
		projectInfrastructureCombo.add("JaCaMo");
		projectInfrastructureCombo.setText("Centralised");
		projectInfrastructureCombo.addListener(SWT.Modify, this);
		
		//Project environment
		projectEnvironmentLabel = new Label(composite, SWT.NONE);
		projectEnvironmentLabel.setText("Environment");
		
		projectEnvironmentCombo = new Combo(composite, SWT.BORDER | SWT.SINGLE | SWT.READ_ONLY);
		projectEnvironmentCombo.add("Without environment");
		projectEnvironmentCombo.add("CArtAgO");
		projectEnvironmentCombo.add("Jason");
		projectEnvironmentCombo.setText("Without environment");
		projectEnvironmentCombo.addListener(SWT.Modify, this);

		projectEnvironmentHostLabel = new Label(composite, SWT.NONE);
		projectEnvironmentHostLabel.setText("Environment host:");
		
		projectEnvironmentHostText = new Text(composite, SWT.BORDER | SWT.SINGLE);
		projectEnvironmentHostText.setLayoutData(gridData);
		projectEnvironmentHostText.setText("localhost");

		projectEnvironmentClassNameLabel = new Label(composite, SWT.NONE);
		projectEnvironmentClassNameLabel.setText("Environment class name:");
		
		projectEnvironmentClassNameText = new Text(composite, SWT.BORDER | SWT.SINGLE);
		projectEnvironmentClassNameText.setLayoutData(gridData);
		projectEnvironmentClassNameText.setText("");

		projectEnvironmentHostLabel.setVisible(false);
		projectEnvironmentHostText.setVisible(false);
		projectEnvironmentClassNameLabel.setVisible(false);
		projectEnvironmentClassNameText.setVisible(false);
		
		setControl(composite);
	}
	
	@Override
	public void handleEvent(Event event) {
		Widget source = event.widget;
		
		if (source == projectNameText){
			checkProjectName();
			checkProjectAlreadyExists();
		} else if (source == projectEnvironmentCombo) {
			if (projectEnvironmentCombo.getText().equals("CArtAgO")) {
				projectEnvironmentHostLabel.setVisible(true);
				projectEnvironmentHostText.setVisible(true);
				projectEnvironmentClassNameLabel.setVisible(false);
				projectEnvironmentClassNameText.setVisible(false);				
			} else if (projectEnvironmentCombo.getText().equals("Jason")) {
				projectEnvironmentHostLabel.setVisible(true);
				projectEnvironmentHostText.setVisible(true);
				projectEnvironmentClassNameLabel.setVisible(true);
				projectEnvironmentClassNameText.setVisible(true);
			} else {
				projectEnvironmentHostLabel.setVisible(false);
				projectEnvironmentHostText.setVisible(false);
				projectEnvironmentClassNameLabel.setVisible(false);
				projectEnvironmentClassNameText.setVisible(false);
			}
		} else if (source == projectInfrastructureCombo) {
			if (projectInfrastructureCombo.getText().equals("JaCaMo")) {
				projectEnvironmentLabel.setVisible(false);
				projectEnvironmentCombo.setVisible(false);
			} else {
				projectEnvironmentLabel.setVisible(true);
				projectEnvironmentCombo.setVisible(true);				
			}
		}
		showStatus(findMostSevere());
		setPageComplete(isPageComplete());
		getWizard().getContainer().updateButtons();
	}

	private IStatus findMostSevere() {
		if (projectNameStatus.matches(IStatus.ERROR)){
			return projectNameStatus;
		} else {
			return projectAlreadyExistsStatus;
		}
	}

	private void checkProjectName() {
		Status status = new Status(IStatus.OK, "not_used", 0, "", null);
		String projectName = projectNameText.getText();
		
		if (projectName.length() == 0){
			status = new Status(IStatus.ERROR, "not_used", 0, "Project name can't be empty", null);
		} else {
			char cFirst = projectName.charAt(0);
			
			if (!Character.isLowerCase(cFirst)){
				status = new Status(IStatus.ERROR, "not_used", 0, "Project name must start with a lowercase letter", null);
			} else {
				for (int i = 1; i < projectName.length(); i++){
					char c = projectName.charAt(i);
					
					if (!Character.isLetterOrDigit(c) && c != '_'){
						status = new Status(IStatus.ERROR, "not_used", 0, "Project name must contain only letters, digits or '_'", null);
					}
				}
			}
		}
		projectNameStatus = status;
	}
	
	private void checkProjectAlreadyExists() {
		Status status = new Status(IStatus.OK, "not_used", 0, "", null);
		IWorkspace workspace = ResourcesPlugin.getWorkspace();
		IWorkspaceRoot root = workspace.getRoot();
		String projectName = projectNameText.getText();
		IProject project = root.getProject(projectName);
		
		if (project.exists()){
			status = new Status(IStatus.ERROR, "not_used", 0, "Project '" + projectName + "' already exists", null);
		}
		projectAlreadyExistsStatus = status;
	}
	
	public boolean isPageComplete(){
		if (getErrorMessage() != null){
			return false;
		}
		
		if (projectNameText.getText().length() == 0){
			return false;
		} else {
			return true;
		}
	}
	
	private void showStatus(IStatus status){
		String message = status.getMessage();
		if (message.length() == 0) message= null;
		switch (status.getSeverity()) {
			case IStatus.OK:
				setErrorMessage(null);
				setMessage(message);
				break;
			case IStatus.WARNING:
				setErrorMessage(null);
				setMessage(message, WizardPage.WARNING);
				break;
			case IStatus.INFO:
				setErrorMessage(null);
				setMessage(message, WizardPage.INFORMATION);
				break;
			default:
				setErrorMessage(message);
				setMessage(null);
				break;
		}
	}
	
	public IProject getProjectHandle() {
        return ResourcesPlugin.getWorkspace().getRoot().getProject(
                getProjectName());
    }
	
	public String getProjectName(){
		return projectNameText.getText();
	}
	
	public String getInfrastructure() {
		return projectInfrastructureCombo.getText();
	}
	
	public String getEnvironment() {
		return projectEnvironmentCombo.getText();
	}
	
	public String getEnvironmentClass() {
		return projectEnvironmentClassNameText.getText();
	}
	
	public String getEnvironmentHost() {
		return projectEnvironmentHostText.getText();
	}
}
