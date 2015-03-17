package jasonide.commands;

import jason.jeditplugin.MASLauncherInfraTier;
import jason.mas2j.MAS2JProject;
import jason.mas2j.parser.ParseException;
import jason.mas2j.parser.TokenMgrError;
import jasonide.core.Utils;

import java.io.File;
import java.io.PrintStream;
import java.io.StringReader;

import org.eclipse.core.resources.IFile;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.IObjectActionDelegate;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.console.ConsolePlugin;
import org.eclipse.ui.console.IConsole;
import org.eclipse.ui.console.IConsoleManager;
import org.eclipse.ui.console.MessageConsole;
import org.eclipse.ui.console.MessageConsoleStream;

public class RunJasonFile implements IObjectActionDelegate {
	private IFile jasonFile = null; 
	
	public RunJasonFile() {
		super();
		
		MessageConsole console = findConsole("Console");
		MessageConsoleStream out = console.newMessageStream();
		
		System.setOut(new PrintStream(out));
		System.setErr(new PrintStream(out));
	}
	
	private MessageConsole findConsole(String name) {
		ConsolePlugin plugin = ConsolePlugin.getDefault();
		IConsoleManager conMan = plugin.getConsoleManager();
		IConsole[] existing = conMan.getConsoles();
		for (int i = 0; i < existing.length; i++) {
			if (name.equals(existing[i].getName()))
				return (MessageConsole) existing[i];
		}
		//no console found, so create a new one
		MessageConsole myConsole = new MessageConsole(name, null);
		conMan.addConsoles(new IConsole[]{myConsole});
		return myConsole;
	}
	
	@Override
	public void run(IAction action) {
		boolean debug = action.getActionDefinitionId().equals("debug"); 
		runProject(debug);
	}
	
    private void runProject(final boolean debug) {
    	System.out.println("Launching " + jasonFile.getProject().getName());
        
        new Thread() {
            public void run() {
            	MAS2JProject project = parseProject();
                // launch the MAS
                try {
                	MASLauncherInfraTier masLauncher;
                    masLauncher = project.getInfrastructureFactory().createMASLauncher();
                    masLauncher.setProject(project);
                    //masLauncher.setListener(arg0)
                    if (masLauncher.writeScripts(debug)) {
                        new Thread(masLauncher, "MAS-Launcher").start();
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        }.start();
    }
    
    private MAS2JProject parseProject() {
        try {
        	System.out.println("Parsing project file... ");

        	//String text = loadFile(mainFile.getLocation().toString());
        	String text = Utils.loadFile(jasonFile.getLocation().toString());
        	
            jason.mas2j.parser.mas2j parser = new jason.mas2j.parser.mas2j(new StringReader(text));
            MAS2JProject project = parser.mas();
            //project.setDirectory(jasonFile.getProject().getLocation().toString());
            project.setDirectory(Utils.getDirectoryOfFile(jasonFile.getLocation().toString()));
            project.setProjectFile(new File(jasonFile.getLocation().toString()));
            project.fixAgentsSrc(null);
            System.out.println(" parsed successfully!\n");
            return project;
        } catch (ParseException ex) {  
        	System.out.println("\nmas2j: syntactic errors found... \n" + ex + "\n");
        } catch (TokenMgrError ex) {
        	System.out.println("\nmas2j: lexical errors found... \n" + ex + "\n");
        } catch (Exception ex) {
        	System.out.println("Error: " + ex.getMessage());
            ex.printStackTrace();
        }
        return null;
    }

	@Override
	public void selectionChanged(IAction action, ISelection selection) {
        if (selection != null && selection instanceof ISelection) {
            IStructuredSelection strucSel = (IStructuredSelection) selection;
            
            jasonFile = (IFile)strucSel.getFirstElement();
        }
	}

	@Override
	public void setActivePart(IAction action, IWorkbenchPart targetPart) {
		
	}
}