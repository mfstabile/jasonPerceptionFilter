package net.sourceforge.jasonide.core;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;

/**
 * Methods for handle problem markers.
 * @author Germano
 */
public class PluginMarkerUtils {

    /**
     * Creates a problem marker for a given IFile.
     * @param ifile
     * @param msg
     * @param lineNumber starts by 1.
     * @param charStart starts by 0.
     * @param charEnd start by 0.
     */
    public static void createMarker(IFile ifile, String msg, int lineNumber, int charStart, int charEnd) {
        try {
            IMarker m = ifile.createMarker(IMarker.PROBLEM);
            
            m.setAttribute(IMarker.LINE_NUMBER, lineNumber);
            m.setAttribute(IMarker.CHAR_START, charStart);
            m.setAttribute(IMarker.CHAR_END, charEnd);
            m.setAttribute(IMarker.MESSAGE, msg);
            m.setAttribute(IMarker.PRIORITY, IMarker.PRIORITY_HIGH);
            m.setAttribute(IMarker.SEVERITY, IMarker.SEVERITY_ERROR);
        } catch (CoreException e) {
            e.printStackTrace();
        }
    }
    
    /**
     * Deletes all old problem markers from IFile.
     * @param ifile
     */
    public static void deleteOldMarkers(IFile ifile) {
        try {
            ifile.deleteMarkers(IMarker.PROBLEM, true, IResource.DEPTH_INFINITE);
        } catch (CoreException e2) {
            e2.printStackTrace();
        }
    }
    
    /**
     * Gets line number from ParseException message of Jason.
     * @param msg
     * @return
     */
    public static int getLineNumberFromMsg(String msg) {
        String[] msgTokens = msg.split(" ");
        for (int i = 0; i < msgTokens.length; i++) {
            if (msgTokens[i].equals("line")) {
                int line = Integer.parseInt( msgTokens[i+1].substring(0, msgTokens[i+1].length()-1) );
                //System.out.println("Linha: "+line);
                return line;
            }
        }
        
        return 1;
    }
    
    /**
     * Gets position of start char in the document contents.
     * @param documentContents Got by editor input.
     * @param line
     * @param msg
     * @return
     */
    public static int getCharStart(String documentContents, int line, String msg) {
        String[] lines = documentContents.replace("\n", "@@").split("@@");
        
        int charCount = 0;
        for (int i = 0; i < (line-1); i++) {
            charCount += lines[i].length()+1;
        }

        String[] msgTokens = msg.split(" ");
        for (int i = 0; i < msgTokens.length; i++) {
            if (msgTokens[i].equals("column")) {
                int col = Integer.parseInt( msgTokens[i+1].substring(0, msgTokens[i+1].length()-6) );
                return charCount + (col -1); // starts by 0
            }
        }
        
        return 1;
    }
        
    /**
     * Gets position of start char in the document contents.
     * @param documentContents Got by editor input.
     * @param line
     * @param msg
     * @return
     */
    public static int getCharStartFromLexicalError(String documentContents, int line, String msg) {
        String[] lines = documentContents.replace("\n", "@@").split("@@");
        
        int charCount = 0;
        for (int i = 0; i < (line-1); i++) {
            charCount += lines[i].length()+1;
        }

        String[] msgTokens = msg.split(" ");
        for (int i = 0; i < msgTokens.length; i++) {
            if (msgTokens[i].equals("column")) {
                int col = Integer.parseInt( msgTokens[i+1].substring(0, msgTokens[i+1].length()-1) );
                return charCount + (col -1); // starts by 0
            }
        }
        
        return 1;
    }
    
    /**
     * Gets position of end char in the document contents.
     * @param documentContents Got by editor input.
     * @param line
     * @param msg
     * @return
     */
    public static int getCharEndLexicalError(String documentContents, int line, String msg) {
        String[] msgTokens = msg.split(" ");
        for (int i = 0; i < msgTokens.length; i++) {
            if (msgTokens[i].equals("Encountered:")) {
                int wordSize = getCharStartFromLexicalError(documentContents, line, msg) + (msgTokens[i+1].length() - 2);
                //System.out.println("End: " + wordSize);
                return wordSize;
            }
        }
        
        return 1;
    }
    
    /**
     * Gets position of end char in the document contents.
     * @param documentContents Got by editor input.
     * @param line
     * @param msg
     * @return
     */
    public static int getCharEnd(String documentContents, int line, String msg) {
        String[] msgTokens = msg.split(" ");
        for (int i = 0; i < msgTokens.length; i++) {
            if (msgTokens[i].equals("Encountered")) {
                int wordSize = getCharStart(documentContents, line, msg) + (msgTokens[i+1].length() - 2);
                //System.out.println("End: " + wordSize);
                return wordSize;
            }
        }
        
        return 1;
    }   
}
