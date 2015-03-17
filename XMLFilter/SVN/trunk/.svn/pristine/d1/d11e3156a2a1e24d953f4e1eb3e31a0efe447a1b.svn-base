package net.sourceforge.jasonide.core;

import jason.JasonException;
import jason.jeditplugin.Config;
import jason.mas2j.AgentParameters;
import jason.mas2j.MAS2JProject;
import jason.mas2j.parser.ParseException;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.core.resources.IProject;

/**
 * Handle Mas2J project file.
 * @author Germano
 */
public class MAS2JHandler {

    /**
     * Mas2j file extension.
     */
    public static final String MAS2J_EXT = "." + MAS2JProject.EXT;
    
    /**
     * ASL file extension.
     */
    public static final String AS_EXT = "." + MAS2JProject.AS_EXT;
    
    /**
     * Gets an array of agents from Mas2JProject object.
     * @param masProject
     * @return
     */
    public static String[] getAgentsFromMas2jProject(MAS2JProject masProject) {
        List lAgents = masProject.getAgents();
        String[] agents = new String[lAgents.size()];
        for (int i = 0; i < agents.length; i++) {
            AgentParameters agPar = ((AgentParameters)lAgents.get(i));
            agents[i] = agPar.name;
            if (agPar.qty > 1) {
                agents[i] += "#" + agPar.qty;
            }
        }
        return agents;
    }
    
    /**
     * Gets an array of class directives from Mas2JProject object.
     * @param masProject
     * @return
     */
    public static String[] getDirectivesFromMas2jProject(MAS2JProject masProject) {
        Map directives = masProject.getDirectiveClasses();
        
        String[] ret = new String[directives.size()];
        
        Object[] keys = directives.keySet().toArray();
        Object[] values = directives.values().toArray();
        for (int i = 0; i < directives.size(); i++) {
            String name = (String)keys[i];
            String value = (String)values[i];
            
            ret[i] = name + " = " + value;
        }
        
        return ret;
    }
    
    /**
     * Get classpath list from Mas2JProject object.
     * @param masProject
     * @return
     */
    public static String[] getClassPathFromMas2jProject(MAS2JProject masProject) {
        List lClassPath = masProject.getClassPaths();
        String[] classPath = new String[lClassPath.size()];
        for (int i = 0; i < classPath.length; i++) {
            classPath[i] = (String)lClassPath.get(i);
        }
        
        
        return classPath;
    }
    
    /**
     * Get sourpath list from Mas2JProject object.
     * @param masProject
     * @return
     */
    public static String[] getSourcePathFromMas2jProject(MAS2JProject masProject) {
        List lSourcePath = masProject.getSourcePaths();
        String[] sourcePath = new String[lSourcePath.size()];
        for (int i = 0; i < sourcePath.length; i++) {
            sourcePath[i] = (String)lSourcePath.get(i);
        }
        
        
        return sourcePath;
    }
    
    /**
     * Gets the contents of the mas2j file.
     */
    public static String getMas2JFilePath(String projectDir) throws FileNotFoundException {
        String pathToMas2JFile = null;
        File d = new File(projectDir);
        // list only dirs and *.mas2j
        File[] files = d.listFiles(
                new FilenameFilter() {
                    public boolean accept(File dir, String name) {
                        File f = new File(dir, name);
                        if (f.isDirectory()) {
                            return true;
                        }
                        else if (name.toLowerCase().endsWith("mas2j")){
                            return true;
                        }
                        return false;
                    }
                }
        );
        for (int i = 0; i < files.length; i++) {
            File f = files[i];
            if (f.isDirectory()) {
                pathToMas2JFile = getMas2JFilePath(f.getAbsolutePath());
                if (pathToMas2JFile != null) {
                    break;
                }
            }
            else {
                return f.getAbsolutePath();
            }
        }
        
        
        return pathToMas2JFile;
    }   
    
    /**
     * Gets all infras (default Jason infras + user custom infras).
     * @return List.
     */
    public static List getUserInfraStructures() {
        List infras = new ArrayList();
        
        String[] array = Config.get().getAvailableInfrastructures();
        for (int i = 0; i < array.length; i++) {
            infras.add(array[i]);           
        }
        
        return infras;
    }
    
    /**
     * Persists the contents of Mas2j to a temporary file.
     * @param project
     * @param contents
     * @return String fileName of the temp file.
     * @throws JasonPluginException
     */
    public static String persistTempMas2JFile(IProject project, String contents) throws JasonPluginException {      
        try {
            String fileName = getMas2JTempFileName(project);
            writeTextInFile(fileName, contents);
            
            return fileName;
        } catch (Exception e) {
            throw new JasonPluginException(e.getMessage());
        }
    }
    
    /**
     * Persists the contents of Mas2j to a temporary file.
     * @param project
     * @param contents
     * @return String fileName of the temp file.
     * @throws JasonPluginException
     */
    public static String persistMas2JFile(IProject project, String contents) throws JasonPluginException {      
        try {
            String fileName = getMas2JFilePath(project.getLocation().toString());
            writeTextInFile(fileName, contents);
            
            return fileName;
        } catch (Exception e) {
            throw new JasonPluginException(e.getMessage());
        }
    }
    
    /**
     * Deletes the mas2j temporary file.
     * @param fileName
     */
    public static void deleteMas2JTempFile(String fileName) {
        new File(fileName).delete();
    }
    
    /**
     * Gets the clean agent name by agent entry in mas2j;
     * @param agentEntry
     * @return
     */
    public static String getCleanAgentName(String agentEntry) {
        int index = agentEntry.indexOf("#");
        if (index > -1) {
            agentEntry = agentEntry.substring(0, index);
        }
        return agentEntry;
    }
    
    /**
     * Parse the mas2j file and setup default infos.
     * @param fileName
     * @return MAS2JProject
     * @throws ParseException
     */
    public static MAS2JProject parse(String fileName) throws ParseException {
        MAS2JProject project;
        try {
            project = new jason.mas2j.parser.mas2j(new FileReader(fileName)).mas();
            project.setupDefault();
            return project;
        } catch (FileNotFoundException e) {
            return null;
        }
    }
    
    /**
     * Parse the mas2j file and setup default infos.
     * @param iProject
     * @return MAS2JProject
     * @throws Exception
     */
    public static MAS2JProject parseForRun(String fileName, String projectLocation) throws ParseException {
        MAS2JProject project = parse(fileName);
        
        project.setDirectory(projectLocation);
        project.setProjectFile(new File(fileName));
        project.fixAgentsSrc(null);
        
        return project;     
    }

    /**
     * Parse ASL agents from Mas2J Project.
     * @param project
     * @return boolean
     * @throws jason.asSyntax.parser.ParseException 
     * @throws Exception
     */
    public static boolean parseProjectAS(MAS2JProject project) throws JasonException, jason.asSyntax.parser.ParseException {
        List srcPaths = project.getSourcePaths();
        
        // compile
        File asFile = null;
        Iterator iASfile = project.getAllASFiles().iterator();
        while (iASfile.hasNext()) {
            asFile = (File)iASfile.next();
            try {                
                // check if agent source file exists in actual sourcepath
                for (Iterator iter = srcPaths.iterator(); iter.hasNext();) {
                    String element = (String) iter.next();
                    String asFileName = element + File.separator + asFile.getName();
                    
                    File file = new File(asFileName);
                    if (file.exists()) {
                        jason.asSyntax.parser.as2j parser = new jason.asSyntax.parser.as2j(new FileReader(file));
                        parser.agent(null);
                        break;
                    } 
                }
            } catch (FileNotFoundException ex) {
                return false;
            }
        }
        
        return true;
    }

    
    /**
     * Gets a String that represents the project object.
     * @param mas2j
     * @return
     */
    public static String mas2jProjectToString(MAS2JProject mas2j) {
        String string = mas2j.toString();

        // nothing to do yet.
        string = string.replace("\n", "\r\n");
        
        return string;
    }
    
    /**
     * Writes the given contents in a file specified by fileName argument.</br>
     * If the file specified by fileName arg already exists, the contents will be replaced.
     * @param fileName Cannot be null.
     * @param contents 
     * @throws IOException
     */
    private static void writeTextInFile(String fileName, String contents) throws IOException {
        FileWriter fw = new FileWriter(new File(fileName));
        fw.write(contents);
        fw.flush();
        fw.close();
    }
    
    /**
     * Gets the Mas2J project file name for a given IProject object.
     * @param project
     * @return
     * @throws FileNotFoundException
     */
    private static String getMas2JTempFileName(IProject project) throws FileNotFoundException {
        String pathToMas2JFile = project.getLocation().toString() + File.separator + "bin" + File.separator + project.getName() + MAS2J_EXT + ".tmp";
        return pathToMas2JFile;
    }
}
