package jasonide.ui.wizards;


import jasonide.core.PluginConstants;
import jasonide.core.PluginTemplates;
import jasonide.core.Utils;
import jasonide.ui.ErrorDialog;
import java.io.InputStream;
import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.Path;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IWorkbench;

public class NewAgentWizard extends Wizard implements INewWizard {
	private IWorkbench workbench;
	private IStructuredSelection selection;
	private NewAgentWizardPage page;

	public NewAgentWizard() {
		super();
		setWindowTitle("New Jason Agent");
	}

	@Override
	public void init(IWorkbench workbench, IStructuredSelection selection) {
		this.selection = selection;
		this.workbench = workbench;
	}
	 
	public void addPages() {
		page = new NewAgentWizardPage(workbench, selection);
		addPage(page);
    }
	
	@Override
	public boolean performFinish() {
		IProject project = page.getSelectedProject();
		String fileExtension = page.getAgentFileExtension();
		String agentName;
		
		if (fileExtension.length() == 0){
			agentName = page.getAgentName() + "." + PluginConstants.AGENT_EXT;
		} else {
			agentName = page.getAgentName();
		}
		String containerName = "/" + project.getName() + "/src/asl";
		IResource agentsFolder = project.findMember("src/asl");
		IContainer container = (IContainer)agentsFolder;
        IFile file = container.getFile(new Path(agentName));
        
        try {
            InputStream stream = PluginTemplates.openContentStreamAgent(containerName, agentName);
            
            if (file.exists()) {
                file.setContents(stream, true, true, null);
            } else {
                file.create(stream, true, null);
            }
            stream.close();
        } catch (Exception e) {
        	e.printStackTrace();
            ErrorDialog.open(e);
        }
        Utils.selectAndReveal(getShell(), (IResource)file);
        Utils.openResource(getShell(), file);
        
        //Add agent in MAS2J
        IResource mainFile = null;
		try {
			for (IResource res : project.members()) {
				if (res.getFileExtension() != null && res.getFileExtension().equals("mas2j")) {
					mainFile = res;
					break;
				}
			}
		} catch (CoreException e) {
			e.printStackTrace();
		}
        
		if (mainFile != null) {
	        try {
				String sourceMainFile = Utils.loadFile(mainFile.getLocation().toString());
				
				String agent = generateAgente() + ";";
				
				int idxStartReplace = 0;
				int i = sourceMainFile.indexOf("agents:");
				
				if (i == -1)
					i = sourceMainFile.indexOf("agents");
				else
					i--;
				
				for (; i < sourceMainFile.length(); i++) {
					if (sourceMainFile.charAt(i) == ':') {
						idxStartReplace = i;
						break;
					}
				}
				
				if (idxStartReplace > 0) {
					sourceMainFile = sourceMainFile.substring(0, idxStartReplace+1) + "\n\t\t" + agent + sourceMainFile.substring(idxStartReplace+1, sourceMainFile.length());
					Utils.saveFile(mainFile.getLocation().toString(), sourceMainFile, false);
				}
				//System.out.println(sourceMainFile + " agents: " + sourceMainFile.indexOf("agents") + " : " + idxStartReplace);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
        
		return true;
	}
	
	private String generateAgente() {
		String agent = page.getAgentName();
		
		//Source
		if (page.getAgentSource() != null && page.getAgentSource().trim().length() > 0) {
			agent += " " + page.getAgentSource().trim();
		}
		
		//Verbose
		if (page.getAgentVerbose().equals("no output")) {
			agent += " [verbose=0]";
		} else if (page.getAgentVerbose().equals("debug")) {
			agent += " [verbose=2]";
		}
		
		//Architecture class
		if (page.getArchitectureClass() != null && page.getArchitectureClass().trim().length() > 0) {
			agent += " agentArchClass " + page.getArchitectureClass().trim();
		}
		
		//Agent class
		if (page.getAgentClass() != null && page.getAgentClass().trim().length() > 0) {
			agent += " agentClass " + page.getAgentClass().trim();
		}
		
		//Number agents
		if (page.getAgentNumber() != null && !page.getAgentNumber().trim().equals("1")) {
			agent += " #" + page.getAgentNumber().trim();
		}

		//Agent host
		if (page.getAgentHost() != null && !page.getAgentHost().trim().equalsIgnoreCase("localhost")) {
			agent += " at \"" + page.getAgentHost().trim() + "\"";
		}
		
		return agent;
	}
	

}
