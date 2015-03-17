package jasonide.core;

import jason.jeditplugin.Config;
import jasonide.ui.ErrorDialog;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileReader;
import java.io.InputStream;

public class PluginTemplates {
	public static final String CORE_PREFS = "org.eclipse.jdt.core.prefs";
	public static final String UI_PREFS = "org.eclipse.jdt.ui.prefs";
	
	public static String getProjectClasspathContents(String projectName, boolean cartagoEnvironment, String infrastructure) {
		String cartagoLib = "";
		String c4jasonLib = "";
		if (cartagoEnvironment || infrastructure.equals("JaCaMo")) {
			cartagoLib = "\t<classpathentry kind=\"lib\" path=\""+ Config.get().getJasonHome() + "/lib/cartago.jar" +"\"/>\n";
			c4jasonLib = "\t<classpathentry kind=\"lib\" path=\""+ Config.get().getJasonHome() + "/lib/c4jason.jar" +"\"/>\n";
		}
		
		String jadeLib = "";
		if (infrastructure.equals("Jade")) {
			jadeLib = "\t<classpathentry kind=\"lib\" path=\""+ Config.get().getJasonHome() + "/lib/jade.jar" +"\"/>\n";
		}
		
		String saciLib = "";
		if (infrastructure.equals("Saci")) {
			saciLib = "\t<classpathentry kind=\"lib\" path=\""+ Config.get().getJasonHome() + "/lib/saci.jar" +"\"/>\n";
		}
		
		String moiseLib = "";
		String jacamoLib = "";
		if (infrastructure.equals("JaCaMo")) {
			moiseLib = "\t<classpathentry kind=\"lib\" path=\""+ Config.get().getJasonHome() + "/lib/moise.jar" +"\"/>\n";
			jacamoLib = "\t<classpathentry kind=\"lib\" path=\""+ Config.get().getJasonHome() + "/lib/jacamo.jar" +"\"/>\n";
		}
		
        return
        "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
        "<classpath>\n" +
        	"\t<classpathentry kind=\"con\" path=\"org.eclipse.jdt.launching.JRE_CONTAINER\"/>\n"+
        	"\t<classpathentry excluding=\"*.asl\" kind=\"src\" path=\"src/asl\" />\n" +
        	"\t<classpathentry kind=\"src\" path=\"src/java\" />\n" +
        	"\t<classpathentry kind=\"lib\" path=\""+ Config.get().getJasonJar() +"\"/>\n" +
        	cartagoLib +
        	c4jasonLib +
        	jadeLib +
        	saciLib +
        	moiseLib +
        	jacamoLib +
        	"<classpathentry kind=\"output\" path=\"bin/classes\"/>" +
        "</classpath>\n";
    } 
	
	public static String getProjectCorePrefsContents() {
        return "#Tue Aug 28 09:21:02 BRT 2007\n" + // TODO: put actual date
                "eclipse.preferences.version=1\n" +
                "org.eclipse.jdt.core.compiler.codegen.inlineJsrBytecode=enabled\n" +
                "org.eclipse.jdt.core.compiler.codegen.targetPlatform=1.5\n" +
                "org.eclipse.jdt.core.compiler.codegen.unusedLocal=preserve\n" +
                "org.eclipse.jdt.core.compiler.compliance=1.5\n" +
                "org.eclipse.jdt.core.compiler.debug.lineNumber=generate\n" +
                "org.eclipse.jdt.core.compiler.debug.localVariable=generate\n" +
                "org.eclipse.jdt.core.compiler.debug.sourceFile=generate\n" +
                "org.eclipse.jdt.core.compiler.problem.assertIdentifier=error\n" +
                "org.eclipse.jdt.core.compiler.problem.enumIdentifier=error\n" +
                "org.eclipse.jdt.core.compiler.source=1.5\n";
    }
    
    public static String getProjectUiPrefsContents() {
        return "#Tue Aug 28 09:21:02 BRT 2007\n" + // TODO: put actual date
               "eclipse.preferences.version=1\n" +
               "internal.default.compliance=default\n";
    }
    
    public static String getJasonFileContents(String projectName, String infrastructure, String environment, String environmentClass, String environmentHost){
    	
    	String env;
    	String ag;
    	if (environment.equals("Jason")) {
    		env = "\tenvironment: " + environmentClass;
    		ag = "\t\tagent1 sample_agent;\n\n";
    	} else if (environment.equals("CArtAgO")) {
    		env = "\tenvironment: c4jason.CartagoEnvironment";
    		ag = "\t\tagent1 sample_agent agentArchClass c4jason.CAgentArch;\n\n";
    	} else {
    		env = "";
    		ag = "\t\tagent1 sample_agent;\n\n";
    	}
    	
    	if (!env.equals("")) {
    		if (!environmentHost.equalsIgnoreCase("localhost")) {
    			env += " at \"" + environmentHost + "\"";
    		}
    		env += "\n\n";
    	}
    	
    	return "MAS " + projectName + " {\n\n" +
					"\tinfrastructure: "+ infrastructure +"\n\n" +
					env +
					"\tagents:\n" +
						ag +
						
					"\taslSourcePath:\n" +
					"\t\t\"src/asl\";\n" +					
				
				"}\n";
    }
    
	public static String getArtifactContents(String mas2jFile, String artifactName, String packageName, String superClass) {
		
		String pkg = "";
		if (packageName != null && !packageName.trim().equals("")) {
			pkg = "package "+packageName+";\n\n";
		}
		
		return  "//CArtAgO artifact code for project "+mas2jFile+"\n\n" +
				pkg +
				"import cartago.*;\n\n" +
				"public class " + artifactName + " extends "+superClass+" {\n" +
				"\tvoid init(int initialValue) {\n" +
				"\t\tdefineObsProperty(\"count\", initialValue);\n" +
				"\t}\n\n" +
				"\t@OPERATION\n" +
				"\tvoid inc() {\n" +
				"\t\tObsProperty prop = getObsProperty(\"count\");\n" +
				"\t\tprop.updateValue(prop.intValue()+1);\n" +
				"\t\tsignal(\"tick\");\n" +
				"\t}\n" +
				"}\n";
	}
	
	public static String getContentCArtAgOArtifact(String mas2jFile, String artifactName, String packageName, String superClass) {
        try {
            String agentFileContents = getTemplate("CArtAgOartifact");

            if (agentFileContents != null && !agentFileContents.equals("")) {
            	if (packageName == null || packageName.trim().equals("")) {
            		agentFileContents = agentFileContents.replace("package <PCK>;", "");
            		agentFileContents = agentFileContents.replace("\n\n\n\n", "\n\n");
            	} else {
            		agentFileContents = agentFileContents.replace("<PCK>", packageName);
            	}
	            agentFileContents = agentFileContents.replace("<PROJECT_NAME>", mas2jFile);
	            agentFileContents = agentFileContents.replace("<ARTIFACT_NAME>", artifactName);
	            agentFileContents = agentFileContents.replace("<SUPER_CLASS>", superClass);
            } else {
            	return getArtifactContents(mas2jFile, artifactName, packageName, superClass);
            }
            
            return agentFileContents;
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }
	
	public static String getContentJasonEnvironment(String mas2jFile, String environmentName) {
        try {
            String agentFileContents = getTemplate("environment");
            
            agentFileContents = agentFileContents.replace("<ENV_NAME>", environmentName);
            agentFileContents = agentFileContents.replace("<PROJECT_NAME>", mas2jFile);
            
            return agentFileContents;
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }
	
	public static String getContentInternalAction(String mas2jFile, String internalActionName, String packageName, String superClass) {
        try {
            String agentFileContents = getTemplate("ia");
            
        	if (packageName == null || packageName.trim().equals("")) {
        		agentFileContents = agentFileContents.replace("package <PCK>;", "");
        		agentFileContents = agentFileContents.replace("\n\n\n\n", "\n\n");
        	} else {
        		agentFileContents = agentFileContents.replace("<PCK>", packageName);
        	}
            agentFileContents = agentFileContents.replace("<IA_NAME>", internalActionName);
            agentFileContents = agentFileContents.replace("<SUPER_CLASS>", superClass);
            agentFileContents = agentFileContents.replace("<PROJECT_NAME>", mas2jFile);
            
            return agentFileContents;
        } catch (Exception e) {
        	e.printStackTrace();
            return "";
        }
    }
	
	public static InputStream openContentStreamAgent(String containerName, String fileName) {
        try {
            String agentFileContents = getTemplate("agent.asl");

            fileName = fileName.replace(".", ">");
            String agentName = fileName.split(">")[0];
            String projectName = containerName.split("/")[1];
            
            agentFileContents = agentFileContents.replace("<AG_NAME>", agentName);
            agentFileContents = agentFileContents.replace("<PROJECT_NAME>", projectName);
            
            return new ByteArrayInputStream(agentFileContents.getBytes());
        } catch (Exception e) {
            e.printStackTrace();
            ErrorDialog.open(e);
            return null;
        }
    }
	
    public static String getTemplate(String templateName) {
        try {
            String nl = System.getProperty("line.separator");
            BufferedReader in;
            
            File bt = new File(Config.get().getJasonHome() + "/src/templates/" + templateName);
            if (bt.exists()) {
                in = new BufferedReader(new FileReader(bt));                
            } else {
                return Config.get().getTemplate(templateName);
            }
            
            StringBuilder scriptBuf = new StringBuilder();
            String line = in.readLine();
            while (line != null) {
                scriptBuf.append(line + nl);
                line = in.readLine();
            }
            return scriptBuf.toString();
        } catch (Exception e) {
            System.err.println("Error reading template: " + templateName);
            e.printStackTrace();
            return null;
        }
    }
}
