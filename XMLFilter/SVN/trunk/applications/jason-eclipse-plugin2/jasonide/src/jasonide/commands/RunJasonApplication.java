package jasonide.commands;

import java.io.PrintStream;
import java.io.StringReader;
import java.io.File;

import jason.jeditplugin.MASLauncherInfraTier;
import jason.mas2j.MAS2JProject;
import jason.mas2j.parser.ParseException;
import jason.mas2j.parser.TokenMgrError;
import jasonide.core.Utils;
import jasonide.ui.ErrorDialog;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.common.NotDefinedException;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.jdt.core.IJavaElement;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ITreeSelection;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.console.ConsolePlugin;
import org.eclipse.ui.console.IConsole;
import org.eclipse.ui.console.IConsoleManager;
import org.eclipse.ui.console.MessageConsole;
import org.eclipse.ui.console.MessageConsoleStream;
import org.eclipse.ui.handlers.HandlerUtil;

public class RunJasonApplication extends AbstractHandler {  
	public RunJasonApplication() {
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
	public Object execute(ExecutionEvent event) throws ExecutionException {
		ISelection selection = HandlerUtil.getActiveWorkbenchWindow(event).getActivePage().getSelection();
		
		boolean debug = event.getCommand().getId().equals("jasonide.debugJasonApplication");
		
		if (selection instanceof ITreeSelection) {
			ITreeSelection ts = (ITreeSelection)selection;
			Object firstElement = ts.getFirstElement();
			IProject project = null;
			
			if (firstElement instanceof IProject){
				project = (IProject)firstElement;
			} else if (firstElement instanceof IResource){
				IResource res = (IResource)firstElement;
				project = res.getProject();
			} else if (firstElement instanceof IJavaElement){
				IJavaElement javaElement = (IJavaElement)firstElement;
				IResource res = javaElement.getResource();
        		project = res.getProject();
			}
			
			try {
				if (project != null && project.isNatureEnabled("jasonide.jasonNature")) {
					run(debug, project);
					return null;
				}
			} catch (CoreException e) {
				e.printStackTrace();
				ErrorDialog.open(e);
			}
		} else {
			IEditorPart editor = HandlerUtil.getActiveWorkbenchWindow(event).getActivePage().getActiveEditor();
			IEditorInput input = editor.getEditorInput();
			IResource resource = (IResource) input.getAdapter(IResource.class);
			
			if (resource != null){
				IProject project = resource.getProject();
				run(debug, project);
				return null;
			}
		}
		ErrorDialog.open("Jason application not found.\nPlease select a resource related to a Jason project");
		return null;
	}

	private void run(boolean debug, IProject project) {
		if (!Utils.checkErrorsInProject(project, "run")){
			return;
		}
		
		try {
			project.build(0, null);
		} catch (CoreException e) {
			e.printStackTrace();
			ErrorDialog.open(e);
			return;
		}
//		System.out.println("Running Jason application " + project.getName());
		
		runProject(debug, project);
	}

    public void runProject(final boolean debug, final IProject projectEclipse) {
    	System.out.println("Launching " + projectEclipse.getName());
        
        new Thread() {
            public void run() {
            	
            	IResource mainFile = null;
            	
            	try {
        			for (IResource res : projectEclipse.members()) {
        				
        				
        				if (res.getFileExtension() != null && res.getFileExtension().equals("mas2j")) {
        					mainFile = res;
        					break;
        				}
        				
        			}
        		} catch (CoreException e) {
        			e.printStackTrace();
        		}            	
            		
            	MAS2JProject project = parseProject(mainFile, projectEclipse);
                if (project == null || mainFile == null) // || !parseProjectAS(project)) {
                    return;
                
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
    
    private MAS2JProject parseProject(IResource mainFile, IProject projectEclipse) {
        try {
        	System.out.println("Parsing project file... ");

        	//String text = loadFile(mainFile.getLocation().toString());
        	String text = Utils.loadFile(mainFile.getLocation().toString());
        	
            jason.mas2j.parser.mas2j parser = new jason.mas2j.parser.mas2j(new StringReader(text));
            MAS2JProject project = parser.mas();
            project.setDirectory(projectEclipse.getLocation().toString());
            project.setProjectFile(new File(mainFile.getLocation().toString()));
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
}
