package net.sourceforge.jasonide.core;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import javax.swing.JOptionPane;

/**
 * Util contants for Jason Plugin.
 * @author Germano
 * @version 1.0.0
 */
public class JasonPluginConstants {

    /**
     * Jason's Jar.
     */
    public static final String JASON_JAR = "lib" + File.separator + "jason.jar";
    
    /**
     * Saci's Jar.
     */
    public static final String SACI_JAR = "lib" + File.separator + "saci.jar";
    
    /**
     * Jade's Jar.
     */
    public static final String JADE_JAR = "lib" + File.separator + "jade.jar";
    
    /**
     * Jade Tools Jar.
     */
    public static final String JADE_TOOLS_JAR = "lib" + File.separator + "jadeTools.jar";
    
    /**
     * Runner class for Centralised infrastructure.
     */
    public static final String RUNNER_CLASS_CENTRALISED = "jason.infra.centralised.RunCentralisedMAS";
    
    /**
     * Runner class for Saci infrastructure.
     */
    public static final String RUNNER_CLASS_SACI = "saci.tools.runApplicationScript";
    
    /**
     * Path to Jason installation root directory.
     */
    public static String JASON_HOME;
    
    /**
     * Jason version.
     */
    public static String JASON_VERSION;
    
    /**
     * Path to Jason JEdit Plugin.
     */
    public static String JASON_HOME_JEDIT;
    
    /**
     * Relative path to Jason jar in the new project.
     */
    public static final String JASON_JAR_PROJECT = JasonPluginConstants.JASON_JAR;
    
    /**
     * Default repository for agents ASL.
     */
    public static final String AGENT_DEFAULT_REPOS = "src" + File.separator + "asl";
    
    /**
     * Default repository for agents ASL for mas2j project file.
     */
    public static final String AGENT_DEFAULT_REPOS_MAS2J = "src/asl";
    
    /**
     * Name of sample agent for the new project.
     */
    public static final String SAMPLE_AGENT_NAME = "sample";
    
    /**
     * Directory of classes binaries.
     */
    public static final String CLASSES_BIN_DIR = "bin";
    
    /**
     * Default Environment Class
     */
    public static final String DEFAULT_ENVIRONMENT = jason.environment.Environment.class.getName();
    
    /**
     * Load Jason User Properties and set config.
     */
    static {
        String userHome = System.getProperty("user.home");
        String jasonUserPropertiesFile = userHome + 
                                         File.separator + 
                                         ".jason" +
                                         File.separator +
                                         "user.properties";
        
        Properties jasonUserProperties = new Properties();
        try {
            jasonUserProperties.load(new FileInputStream(new File(jasonUserPropertiesFile)));
                        
            JASON_VERSION = jasonUserProperties.getProperty("version");
        
            JASON_HOME = jasonUserProperties.getProperty("jasonJar");
            JASON_HOME = JASON_HOME.substring(0, JASON_HOME.indexOf("jason.jar")-5);
            
            JASON_HOME_JEDIT = JASON_HOME + File.separator + "src" + File.separator + "jeditPlugin";
        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(null, "Jason User Properties not found in user home directory. Eclipse will be shutdown.", "Error", JOptionPane.ERROR_MESSAGE);       
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
