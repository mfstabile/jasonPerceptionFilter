package net.sourceforge.jasonide.core;



/**
 * Plugin Templates and constants to access the Jason templates in your installation directory.
 * @author Germano
 */
public class PluginTemplates {

    //public static final String TEMPLATE_DIR = "src" + File.separator + "templates";
    
    //public static final String ENVIRONMENT = "environment";
    
    //public static final String INTERNAL_ACTION = "ia";
    
    //public static final String AGENT = "agent.asl";
    
    public static final String MAS2J = "project.mas2j";
    
    //public static final String BUILD = "build-template.xml";
    
    public static final String LOGGING_CONFIGURATION = "logging.properties";
    
    public static final String CORE_PREFS = "org.eclipse.jdt.core.prefs";
    
    public static final String UI_PREFS = "org.eclipse.jdt.ui.prefs";
    
    public static final String JASON_BUILDER_LAUNCHER = "JasonBuilder.launch";
    
    public static String getProjectClasspathContents() {
        return 
        "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
        "<classpath>\n" +
            "\t<classpathentry kind=\"src\" path=\"src/java\"/>\n" +
            "\t<classpathentry kind=\"src\" output=\"src/asl\" path=\"src/asl\"/>\n" +
            "\t<classpathentry kind=\"con\" path=\"org.eclipse.jdt.launching.JRE_CONTAINER\"/>\n"+
            "\t<classpathentry kind=\"lib\" path=\"%s\"/>\n" +
            "\t<classpathentry kind=\"output\" path=\"bin/classes\"/>\n" +
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
    
    public static String getBuildPropertiesContents() {
        return "source.. = src/java, src/asl\n" +
               "output.. = bin/";
    }
}
