package jasonide.core;

import jasonide.ui.ErrorDialog;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectDescription;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.widgets.Shell;

public class ProjectCreation {
	private Shell shell;
	private IProject project;
	
	public ProjectCreation(Shell shell) {
		this.shell = shell;
	}
	
	public Shell getShell() {
		return this.shell;
	}
 
	public void createProjectDirs(String projectRootDir) {
		new File(projectRootDir + File.separator + "src").mkdir();
		new File(projectRootDir + File.separator + "src" + File.separator + "asl").mkdir();
		new File(projectRootDir + File.separator + "src" + File.separator + "java").mkdir();
	}

	public void importJasonLibraries(IProgressMonitor monitor){
		try {
			project.open(monitor);
		} catch (Exception e) {
			e.printStackTrace();
			MessageDialog.openError(getShell(), "Error", e.getMessage());
		}
	}

    public void configureProjectEnvironment(IProgressMonitor monitor) {
    	try {
            IProjectDescription pd = project.getDescription();
            pd.setNatureIds(new String[] {"org.eclipse.jdt.core.javanature", 
            								"org.eclipse.xtext.ui.shared.xtextNature",
            								"jasonide.jasonNature"});
        
            project.setDescription(pd, monitor);
        } catch (CoreException e) {
        	e.printStackTrace();
        	ErrorDialog.open(e);
        }
    }
    
    /**
     * Creates the .classpath file for Jason Project.
     */
    public void createClassPathFile(String projectRootDir, String projectName, boolean cartagoEnvironment, String infrastructure) {
        String classPathContent = PluginTemplates.getProjectClasspathContents(projectName, cartagoEnvironment, infrastructure);
        
        try {
            FileWriter fw = new FileWriter(new File(projectRootDir + File.separator + ".classpath"));
            fw.write(classPathContent);
            fw.flush();
            fw.close();
        } catch (IOException e) {
            MessageDialog.openError(getShell(), "Error", e.getMessage());
        }
    }
    
    /**
     * Creates the Jason file. This file represents a Jason project.
     * @param projectRootDir
     * @param projectName
     * @param infrastructure
     */
    public void createJasonFile(String projectRootDir, String projectName, String infrastructure, String environment, String environmentClass, String environmentHost) {
        try {
            File f = new File(projectRootDir + File.separator + projectName + "." + PluginConstants.MAS_EXT);
            f.createNewFile();
            FileWriter fw = new FileWriter(f);
            fw.write(PluginTemplates.getJasonFileContents(projectName, infrastructure, environment, environmentClass, environmentHost));
            fw.flush();
            fw.close();
        } catch (IOException e) {
            MessageDialog.openError(getShell(), "Error", e.getMessage());
        }
    }
    
    /**
     * Creates the .settings directory for Jason Project.
     */
    public void createSettingsDir(String projectRootDir) {
        String corePrefsContent = PluginTemplates.getProjectCorePrefsContents();
        String uiPrefsContent = PluginTemplates.getProjectUiPrefsContents();

        try {
            // make .settings folder
            new File(projectRootDir + File.separator + ".settings").mkdir();
            
            // core prefs           
            FileWriter fw = new FileWriter(new File(projectRootDir + File.separator + ".settings" + File.separator + PluginTemplates.CORE_PREFS));
            fw.write(corePrefsContent);
            fw.flush();
            fw.close();
            
            // ui prefs
            fw = new FileWriter(new File(projectRootDir + File.separator + ".settings" + File.separator + PluginTemplates.UI_PREFS));
            fw.write(uiPrefsContent);
            fw.flush();
            fw.close();
        } catch (IOException e) {
            MessageDialog.openError(getShell(), "Error", e.getMessage());
        }
    }

	public void createSampleAgentFile(String projectRootDir, String projectName) {
		String agentName = "sample_agent." + PluginConstants.AGENT_EXT;
        String containerName = "/" + project.getName() + "/src/asl";
		IResource agentsFolder = project.findMember("src/asl");
		
		IContainer container = (IContainer)agentsFolder;
        IFile file = container.getFile(new Path(agentName));
        
        try {
            InputStream stream = PluginTemplates.openContentStreamAgent(containerName, agentName);
            file.create(stream, true, null);
            stream.close();
        } catch (Exception e) {
        	e.printStackTrace();
            ErrorDialog.open(e);
        }
	}
	
	public void createJasonEnvironmentFile(String projectRootDir, String mas2jFile, String environmentName) {
		String fileContent = PluginTemplates.getContentJasonEnvironment(mas2jFile, environmentName);
		
        try {
            FileWriter fw = new FileWriter(new File(
            		projectRootDir + File.separator + "src" + File.separator + "java" + File.separator + environmentName + ".java"));
            fw.write(fileContent);
            fw.flush();
            fw.close();
        } catch (IOException e) {
        	e.printStackTrace();
            ErrorDialog.open(e);
        }
	}
	
	public void setProject(IProject newProject) {
		project = newProject;
	}
}
