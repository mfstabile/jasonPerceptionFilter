package jasonide.core;

import java.io.BufferedReader;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import jasonide.ui.ErrorDialog;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.ide.IDE;
import org.eclipse.ui.wizards.newresource.BasicNewResourceWizard;

public class Utils {
	public static String removeFileExtension(String s){
		int index = s.lastIndexOf(".");
		
		if (index > -1){
			return s.substring(0, index);
		} else {
			return s;
		}
	}
	 
	public static String getFileExtensionWithDot(String s){
		int index = s.lastIndexOf(".");
		
		if (index > -1 && index < s.length()){
			return s.substring(index);
		} else {
			return "";
		}
	}
	
	public static String getDirectoryOfFile(String s){
		int index = s.lastIndexOf(File.separatorChar);
		
		if (index > -1 && index < s.length()){
			return s.substring(0,index);
		} else {
			index = s.lastIndexOf("/");
			if (index > -1 && index < s.length()){
				return s.substring(0,index);
			} else {
				index = s.lastIndexOf("\\");
				if (index > -1 && index < s.length()){
					return s.substring(0,index);
				} else {
					return "";
				}
			}
		}
	}
	
	public static void selectAndReveal(Shell shell, final IResource resource) {
		shell.getDisplay().asyncExec(new Runnable() {
            public void run() {
                IWorkbenchWindow window = PlatformUI.getWorkbench().getActiveWorkbenchWindow();
                BasicNewResourceWizard.selectAndReveal(resource, window);
            }
        });
	}
	
	public static void openResource(final Shell shell, final IFile resource) {
		shell.getDisplay().asyncExec(new Runnable() {
            public void run() {
                IWorkbenchPage page = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
                
                try {
                    IDE.openEditor(page, resource, true);
                } catch (PartInitException e) {
                	e.printStackTrace();
                    ErrorDialog.open(e);
                }
            }
        });
	}
	
	public static boolean checkErrorsInProject(IProject project, String action){
		PlatformUI.getWorkbench().saveAllEditors(true);
		
		try {
			IMarker[] markers = project.findMarkers("org.eclipse.core.resources.problemmarker", true, IResource.DEPTH_INFINITE);
			boolean errors = false;
			
			for (IMarker marker: markers){
				if (marker.getAttribute(IMarker.SEVERITY, IMarker.SEVERITY_INFO) == IMarker.SEVERITY_ERROR){
					errors = true;
					break;
				}
			}
			
			if (errors){
				ErrorDialog.open("Errors found in project " + project.getName() + 
						", cant' "+ action + " Jason application.\nPlease check Problems view or error markers");
				return false;
			}
		} catch (CoreException e) {
			e.printStackTrace();
			ErrorDialog.open(e);
			return false;
		}
		return true;
	}
	
    public static void saveFile(String archive, String content, boolean append)
    throws IOException {

        FileWriter fw = new FileWriter(archive, append);

        fw.write(content);
        fw.close();
    }
    
    public static String loadFile(String archive)
    	throws FileNotFoundException, IOException {

        File file = new File(archive);

        if (!file.exists()) {
            return null;
        }

        BufferedReader br = new BufferedReader(new FileReader(archive));
        StringBuffer outputBuf = new StringBuffer();

        String line;
        while( (line = br.readLine()) != null ){
        	outputBuf.append(line + "\n");
        }
        br.close();
        return outputBuf.toString().trim();
    }
}
