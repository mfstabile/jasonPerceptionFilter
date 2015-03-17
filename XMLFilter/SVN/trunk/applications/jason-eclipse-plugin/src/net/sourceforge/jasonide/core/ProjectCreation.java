package net.sourceforge.jasonide.core;

import jason.jeditplugin.Config;
import jason.mas2j.AgentParameters;
import jason.mas2j.ClassParameters;
import jason.mas2j.MAS2JProject;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Formatter;
import java.util.Hashtable;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;

import org.eclipse.core.resources.ICommand;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectDescription;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.debug.core.DebugPlugin;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.ILaunchConfigurationType;
import org.eclipse.debug.core.ILaunchConfigurationWorkingCopy;
import org.eclipse.debug.core.ILaunchManager;
import org.eclipse.jdt.launching.IJavaLaunchConfigurationConstants;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.widgets.Shell;

public class ProjectCreation {

    private Shell shell;
    
    public ProjectCreation(Shell shell) {
        this.shell = shell;
    }
    
    public Shell getShell() {
        return this.shell;
    }
    
    /**
     * Creates the empty directories for the new Jason project.
     */
    public void createProjectDirs(String projectRootDir) {
        new File(projectRootDir + File.separator + "src").mkdir();
        new File(projectRootDir + File.separator + "src" + File.separator + "java").mkdir();
        new File(projectRootDir + File.separator + "src" + File.separator + "asl").mkdir();
        new File(projectRootDir + File.separator + "bin").mkdir();
        new File(projectRootDir + File.separator + "bin" + File.separator + "classes").mkdir();
    }
    
    /**
     * Creates the .classpath file for Jason Project.
     */
    public void createClassPathFile(String projectRootDir) {
        String classPathContent = PluginTemplates.getProjectClasspathContents();

        String jasonJarInProject = Config.get().getJasonJar();
        classPathContent = new Formatter().format(classPathContent, new Object[] {jasonJarInProject}).toString();
        
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
     * Configures de .project file.
     * @param project
     * @param monitor
     */
    public void configureProjectEnvironment(IProject project, IProgressMonitor monitor) {
        try {
            IProjectDescription pd = project.getDescription();
            
            ICommand c1 = pd.newCommand();
            c1.setBuilderName("org.eclipse.jdt.core.javabuilder");
            
            ICommand c2 = pd.newCommand();
            c2.setBuilderName("org.eclipse.pde.ManifestBuilder");
            
            pd.setBuildSpec(new ICommand[] {c1, c2});
            pd.setNatureIds(new String[] {"org.eclipse.jdt.core.javanature"});
        
            project.setDescription(pd, monitor);
        } catch (CoreException e) { 
            MessageDialog.openError(getShell(), "Error", e.getMessage());
        }
    }
    
    /**
     * Creates the build.properties of the new Jason Project.
     */
    public void createBuildPropertiesFile(String projectRootDir) {
        try {
            FileWriter fw = new FileWriter(new File(projectRootDir + File.separator + "build.properties"));
            fw.write(PluginTemplates.getBuildPropertiesContents());
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
    
    /**
     * Creates the Java based Environment.
     * @param projectRootDir
     * @param envClassName
     * @param projectName
     */
    public void createEnvironmentClass(String dirRoot, String envClassName, String projectName) {
        try {
            // replace "." because it's special symbol in regular expressions.
            envClassName = envClassName.replace(".", "&");
            
            String[] items = envClassName.split("&");
            String className = null;
            String actualPackage = dirRoot + File.separator + "src" + File.separator + "java";
            String packages = "";
            
            if (items.length > 0) {
                className = items[items.length-1];
                
                for (int i = 0; i < items.length-1; i++) {
                    File f = new File(actualPackage + File.separator + items[i]);
                    f.mkdir();
                    actualPackage = actualPackage + File.separator + items[i];
                    
                    if (packages.length() != 0) {
                        packages = packages.concat(".");
                    }
                    packages = packages.concat(items[i]);
                }
            }
            else {
                className = "src" + File.separator + "java" + File.separator + envClassName;
            }
            
            // is Java code then must be placed in the source Java folder of the project.
            actualPackage += File.separator;

            File f = new File(actualPackage + File.separator + className + ".java");
            f.createNewFile();
        
            String templateContent = Config.get().getTemplate("environment");
            
            // contains package(s)
            if (packages.length() != 0) {
                templateContent = "package ".concat(packages).concat(";\r\n\r\n").concat(templateContent);
            }
            
            templateContent = templateContent.replace("<PROJECT_NAME>", projectName);
            templateContent = templateContent.replace("<ENV_NAME>", className);
            
            FileWriter fw = new FileWriter(f);
            fw.write(templateContent);
            fw.flush();
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
            MessageDialog.openError(getShell(), "Error", e.getMessage());
        }
    }
    
    /**
     * Creates a sample agent named sample.asl.
     * @param projectRootDir
     */
    public void createSampleAgentFile(String projectRootDir, String projectName) {
        try {
            File f = new File(projectRootDir + File.separator + JasonPluginConstants.AGENT_DEFAULT_REPOS + File.separator + "sample.asl");
            f.createNewFile();
            String templateContent = Config.get().getTemplate("agent");
            
            templateContent = templateContent.replace("<AG_NAME>", "sample");
            templateContent = templateContent.replace("<PROJECT_NAME>", projectName);
            
            FileWriter fw = new FileWriter(f);
            fw.write(templateContent);
            fw.flush();
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
            MessageDialog.openError(getShell(), "Error", e.getMessage());
        }
    }

    /**
     * Creates the Mas2J file. This file represents a Jason project.
     * @param projectRootDir
     * @param projectName
     * @param infrastructure
     */
    public void createMas2JFile(String projectRootDir, String projectName, String infrastructure, String envClassName) {
        MAS2JProject mas2jProject = new MAS2JProject();
        mas2jProject.setSocName(projectName.toLowerCase());
        mas2jProject.setInfrastructure(new ClassParameters(infrastructure));
        mas2jProject.addSourcePath(JasonPluginConstants.AGENT_DEFAULT_REPOS_MAS2J);
        
        AgentParameters ag = new AgentParameters();
        ag.name = JasonPluginConstants.SAMPLE_AGENT_NAME;
        //ag.setupDefault();
        mas2jProject.addAgent(ag);
        mas2jProject.setupDefault();
        
        if (envClassName.length() > 0) {
            mas2jProject.setEnvClass(new ClassParameters(envClassName));
        }
        
        try {
            File f = new File(projectRootDir + File.separator + projectName + MAS2JHandler.MAS2J_EXT);
            f.createNewFile();
            
            FileWriter fw = new FileWriter(f);
            fw.write(MAS2JHandler.mas2jProjectToString(mas2jProject));
            fw.flush();
            fw.close();
        } catch (IOException e) {
            MessageDialog.openError(getShell(), "Error", e.getMessage());
        }
    }
    
    /**
     * Creates the Launcher for the MAS Project.
     * @param projectRootDir
     * @param projectName
     * @param newProject
     * @param debug
     */
    public void createProjectLaunchConfiguration(String projectRootDir, String projectName, String mas2jFile, IProject newProject, boolean debug) {
        try {
            if (mas2jFile == null) {
                mas2jFile = projectName + MAS2JHandler.MAS2J_EXT;
            }
            
            String mas2jFileName = "\"" + projectRootDir + File.separator + mas2jFile + "\"";
            String launcherConfigName;
            String secondParameter;
            String supportsMode;
            if (debug) {
                launcherConfigName = "Debug MAS - " + projectName;
                secondParameter = "debug";
                supportsMode = ILaunchManager.DEBUG_MODE;
            }
            else {
                launcherConfigName = "Run MAS - " + projectName;
                secondParameter = "run";
                supportsMode = ILaunchManager.RUN_MODE;
            }
            
            ILaunchManager manager = DebugPlugin.getDefault().getLaunchManager();
            ILaunchConfigurationType type = manager.getLaunchConfigurationType(IJavaLaunchConfigurationConstants.ID_JAVA_APPLICATION);
            ILaunchConfiguration[] configurations = manager.getLaunchConfigurations(type);
            for (int i = 0; i < configurations.length; i++) {
                ILaunchConfiguration configuration = configurations[i];
                if (configuration.getName().equals(launcherConfigName)) {
                    configuration.delete();
                    break;
                }
            }
            
            ILaunchConfigurationWorkingCopy workingCopy = type.newInstance(null, launcherConfigName);
            workingCopy.setAttribute(IJavaLaunchConfigurationConstants.ATTR_PROJECT_NAME, projectName);
            workingCopy.setAttribute(IJavaLaunchConfigurationConstants.ATTR_MAIN_TYPE_NAME, "jason.mas2j.parser.mas2j");
            workingCopy.setAttribute(IJavaLaunchConfigurationConstants.ATTR_PROGRAM_ARGUMENTS, mas2jFileName + " " + secondParameter);
            workingCopy.supportsMode(supportsMode);

            /*ILaunchConfiguration config = */
            workingCopy.doSave();
        } catch (CoreException e) {
            MessageDialog.openError(getShell(), "Error", e.getMessage());
        }
    }
    
    /**
     * @return Mas2J filename.
     */
    public String importResources(String archiveFileName, String projectRootDir) throws IOException, FileNotFoundException {
        Hashtable htSizes = new Hashtable();  
           
        // extracts just sizes only. 
        ZipFile zf=new ZipFile(archiveFileName);
        Enumeration e=zf.entries();
        while (e.hasMoreElements()) {
            ZipEntry ze=(ZipEntry)e.nextElement();
            htSizes.put(ze.getName(),new Integer((int)ze.getSize()));
        }
        zf.close();
        
        String mas2jFileName = null;
        
        FileInputStream fis = new FileInputStream(archiveFileName);
        BufferedInputStream bis=new BufferedInputStream(fis);
        ZipInputStream zis=new ZipInputStream(bis);
        ZipEntry ze=null;
        while ((ze=zis.getNextEntry())!=null) {
            if (ze.getName().endsWith(MAS2JHandler.MAS2J_EXT)) {
                String[] mas2jFileNameParts = ze.getName().split("/");
                mas2jFileName = mas2jFileNameParts[mas2jFileNameParts.length-1];
            }
            
            if ((!projectRootDir.endsWith("/")) || (!ze.getName().startsWith("/"))) {
                projectRootDir = projectRootDir.concat("/");
            }
            
            File newFile = new File(projectRootDir.concat(ze.getName()));
            
            if (ze.isDirectory()) {
                //make dir
                newFile.mkdir();
            }
            else { // is a file
                int size=(int)ze.getSize();
                // -1 means unknown size. 
                if (size==-1) {
                   size=((Integer)htSizes.get(ze.getName())).intValue();
                }
                byte[] b=new byte[(int)size];
                int rb=0;
                int chunk=0;
                while (((int)size - rb) > 0) {
                    chunk = zis.read(b,rb,(int)size - rb);
                    if (chunk==-1) {
                       break;
                    }
                    rb+=chunk;
                }
               
                // write contents in a file
                new FileOutputStream(newFile).write(b);
            }
        }
        
        return mas2jFileName;
    }
    
    /**
     * @return Mas2J filename.
     */
    public String getMas2jFileNameInArchiveFile(String archiveFileName) throws IOException, FileNotFoundException {       
        FileInputStream fis = new FileInputStream(archiveFileName);
        BufferedInputStream bis=new BufferedInputStream(fis);
        ZipInputStream zis=new ZipInputStream(bis);
        ZipEntry ze=null;
        while ((ze=zis.getNextEntry())!=null) {
            if (ze.getName().endsWith(MAS2JHandler.MAS2J_EXT)) {
                String[] mas2jFileNameParts = ze.getName().split("/");
                return mas2jFileNameParts[mas2jFileNameParts.length-1];
            }
        }
        return "";
    }
}
