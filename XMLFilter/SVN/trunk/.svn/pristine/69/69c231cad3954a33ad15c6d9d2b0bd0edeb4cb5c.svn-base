package jasonide.ui.wizards;

import jasonide.core.PluginConstants;
import jasonide.core.Utils;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Widget;
import org.eclipse.ui.IWorkbench;

public class NewAslFileWizardPage extends JasonWizardPage implements Listener {
	private Label agentNameLabel;
	private Text agentNameText;
	
	private IStatus agentNameStatus, agentAlreadyExistsStatus;
	
	public NewAslFileWizardPage(IWorkbench workbench, IStructuredSelection selection) {
		super("New Jason Agent", "This wizard creates a new Jason Agent",	"Create agent in project:", workbench, selection);
		agentNameStatus = new Status(IStatus.OK, "not_used", 0, "", null);
		agentAlreadyExistsStatus = new Status(IStatus.OK, "not_used", 0, "", null);
	}

	@Override
	public void createControl(Composite parent) {
		super.createControl(parent);
		GridLayout layout = new GridLayout();
		int nCols = 2;
		layout.numColumns = nCols;
		composite.setLayout(layout);
		composite.setLayoutData(new GridData(GridData.HORIZONTAL_ALIGN_FILL | GridData.VERTICAL_ALIGN_FILL));
		GridData gridData = new GridData(GridData.HORIZONTAL_ALIGN_FILL | GridData.GRAB_HORIZONTAL);
		gridData.widthHint = 250;
		
		//Asl filename
		agentNameLabel = new Label(composite, SWT.NONE);
		agentNameLabel.setText("Asl filename:");
		 
		agentNameText = new Text(composite, SWT.BORDER | SWT.SINGLE);
		agentNameText.setLayoutData(gridData);
		agentNameText.addListener(SWT.Modify, this);
		agentNameText.setFocus();
	}

	@Override
	public void handleEvent(Event event) {
		Widget source = event.widget;
		
		if (source == agentNameText){
			checkAgentName();
			checkAgentAlreadyExists();
			checkProjectsList();
		} else if (source == projectsList){
			checkProjectsList();
		}
		showStatus(findMostSevere());
		setPageComplete(isPageComplete());
		getWizard().getContainer().updateButtons();
	}
	
	private IStatus findMostSevere() {
		if (projectStatus.matches(IStatus.ERROR)){
			return projectStatus;
		}
		
		if (agentNameStatus.matches(IStatus.ERROR)){
			return agentNameStatus;
		}
		
		if (agentAlreadyExistsStatus.matches(IStatus.ERROR)){
			return agentAlreadyExistsStatus;
		}
		return new Status(IStatus.OK, "not_used", 0, "", null);
	}
	
	private void checkAgentName() {
		Status status = new Status(IStatus.OK, "not_used", 0, "", null);
		String agentNameWithoutExtension = Utils.removeFileExtension(agentNameText.getText());
		String fileExtension =  getAgentFileExtension();
		boolean error = false;
		
		if (agentNameWithoutExtension.length() == 0){
			error = true;
			status = new Status(IStatus.ERROR, "not_used", 0, "Agent name can't be empty", null);
		} else {
			char cFirst = agentNameWithoutExtension.charAt(0);
			
			if (!Character.isLowerCase(cFirst)){
				error = true;
				status = new Status(IStatus.ERROR, "not_used", 0, "Agent name must start with a lowercase letter", null);
			} else {
				for (int i = 1; i < agentNameWithoutExtension.length(); i++){
					char c = agentNameWithoutExtension.charAt(i);
					
					if (!error && !Character.isLetterOrDigit(c) && c != '_'){
						error = true;
						status = new Status(IStatus.ERROR, "not_used", 0, "Agent name must contain only letters, digits or '_'", null);
					}
				}
			}
		}
		
		if (!error) {
			if (!fileExtension.equals("") && !fileExtension.equals("." + PluginConstants.AGENT_EXT)){
				status = new Status(IStatus.ERROR, "not_used", 0, "Invalid file extension. Use '." + PluginConstants.AGENT_EXT + "', or just omit it", null);
			}
		}
		agentNameStatus = status;
	}
	
	private void checkAgentAlreadyExists() {
		Status status = new Status(IStatus.OK, "not_used", 0, "", null);
		IProject project = getSelectedProject();
		String fileExtension =  getAgentFileExtension();
		
		if (fileExtension.length() == 0){
			IResource resource = project.findMember("src/asl/" + agentNameText.getText() + "." + PluginConstants.AGENT_EXT);
			
			if (resource != null){
				status = new Status(IStatus.ERROR, "not_used", 0, 
						"Agent '" + agentNameText.getText() + "." + PluginConstants.AGENT_EXT + "' already exists", null);
			}
		} else {
			IResource resource = project.findMember("src/asl/" + agentNameText.getText());
			
			if (resource != null){
				status = new Status(IStatus.ERROR, "not_used", 0, "Agent '" + agentNameText.getText() + "' already exists", null);
			}
		}
		agentAlreadyExistsStatus = status;
	}
	
	public boolean isPageComplete(){
		if (getErrorMessage() != null){
			return false;
		}
		
		if (agentNameText.getText().length() == 0 || projectsList.getSelectionCount() == 0){
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
	
	public String getAgentName(){
		return agentNameText.getText();
	}
	
	public String getAgentFileExtension() {
		return Utils.getFileExtensionWithDot(agentNameText.getText());
	}
}
