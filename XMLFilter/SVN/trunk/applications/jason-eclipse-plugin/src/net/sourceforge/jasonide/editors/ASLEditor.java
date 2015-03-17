package net.sourceforge.jasonide.editors;

import jason.JasonException;
import jason.asSemantics.Agent;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

import net.sourceforge.jasonide.Activator;
import net.sourceforge.jasonide.core.PluginMarkerUtils;
import net.sourceforge.jasonide.editors.cbg.ColoringEditor;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.jface.dialogs.ErrorDialog;
import org.eclipse.jface.text.IDocument;
import org.eclipse.ui.IFileEditorInput;

/**
 * ASL Text Editor.
 * @author Germano
 */
public class ASLEditor extends ColoringEditor {
    
    public ASLEditor() {
        super();
    }
    public void dispose() {
        super.dispose();
    }
    
    public void doSave(IProgressMonitor progressMonitor) {
        super.doSave(progressMonitor);
        
        compileInput();
    }
    
    private void compileInput() {       
        IDocument document = getDocumentProvider().getDocument(getEditorInput());
        IFileEditorInput iei = (IFileEditorInput)getEditorInput();
        IFile ifile = iei.getFile();
        IProject iproject = ifile.getProject();
        
        // delete old markers
        PluginMarkerUtils.deleteOldMarkers(ifile);
        
        try {       
            // absolute project location + filePath relative in project (without project name)
            String asfileName = iproject.getLocation().toString() + getFilePathWithoutProjectName(ifile);
            jason.asSyntax.parser.as2j parser = new jason.asSyntax.parser.as2j(new FileReader(new File(asfileName)));
            if (parser != null) {
                Agent ag = new Agent();
                ag.initAg();
                ag.setASLSrc(asfileName);
                parser.agent(ag);
            }
            
        } catch (FileNotFoundException e) {
            showError(e.getMessage(), e);
        } catch (JasonException e) {
            String msg = "Problems:" + "\n\n" + e.getMessage();
            showError(msg, e);
        } catch (jason.asSyntax.parser.ParseException e) {
            String msg = e.getMessage();

            int lineError = e.currentToken.beginLine; //PluginMarkerUtils.getLineNumberFromMsg(msg);
            PluginMarkerUtils.createMarker(ifile, e.getMessage().replace("\r", "").replace("\n", ""), 
                         lineError,
                         PluginMarkerUtils.getCharStart(document.get(), lineError, msg),
                         PluginMarkerUtils.getCharEnd(document.get(), lineError, msg));
        } catch (jason.asSyntax.parser.TokenMgrError e) {
            String msg = e.getMessage();
            
            int lineError = PluginMarkerUtils.getLineNumberFromMsg(msg);
            int charStart = PluginMarkerUtils.getCharStartFromLexicalError(document.get(), lineError, msg);
            int charEnd = PluginMarkerUtils.getCharEndLexicalError(document.get(), lineError, msg);
            PluginMarkerUtils.createMarker(ifile, e.getMessage().replace("\r", "").replace("\n", ""), 
                         lineError,
                         charStart,
                         charEnd);
        } 
    }
    
    /**
     * Extract only the path of the file, excluding the project name.
     * @param iFile
     * @return String
     */
    private String getFilePathWithoutProjectName(IFile iFile) {
        String[] parts = iFile.getFullPath().toString().split("/");
        StringBuilder sb = new StringBuilder();
        // first is empty and the second is the project name
        for(int i = 2; i < parts.length; i++) {
            sb.append("/");
            sb.append(parts[i]);
        }
        return sb.toString();
    }
    
    private void showError(String msg, Throwable e) {
        ErrorDialog.openError(
                getSite().getShell(),
                "Error",
                null,
                new Status(IStatus.ERROR, Activator.getPluginId(), IStatus.ERROR, msg, e));
    }
}
