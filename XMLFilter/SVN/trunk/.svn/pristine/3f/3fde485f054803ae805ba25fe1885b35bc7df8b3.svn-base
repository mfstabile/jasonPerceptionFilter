package net.sourceforge.jasonide.editors;

import jason.mas2j.ClassParameters;
import jason.mas2j.MAS2JProject;
import jason.mas2j.parser.ParseException;
import net.sourceforge.jasonide.core.MAS2JHandler;
import net.sourceforge.jasonide.core.PluginMarkerUtils;
import net.sourceforge.jasonide.editors.swtContainers.MAS2JDesignComposite;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResourceChangeEvent;
import org.eclipse.core.resources.IResourceChangeListener;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.jface.dialogs.ErrorDialog;
import org.eclipse.jface.text.IDocument;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.IFileEditorInput;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.ide.IDE;
import org.eclipse.ui.part.FileEditorInput;
import org.eclipse.ui.part.MultiPageEditorPart;

/**
 * Mas2J Multi Page editor.
 * @author Germano
 */
public class MAS2JEditor extends MultiPageEditorPart implements IResourceChangeListener {

    /** The text editor used in page 0. */
    private MAS2JTextEditor editor;
    
    private String infraStructure;
    private String[] agents;
    private ClassParameters envClass;
    private ClassParameters controlExecClass;
    private String [] directives;
    private String [] classPath;
    private String [] sourcePath;
    
    private MAS2JDesignComposite mas2jDesignComposite;

    /**
     * Creates a multi-page editor example.
     */
    public MAS2JEditor() {
        super();
        ResourcesPlugin.getWorkspace().addResourceChangeListener(this);
    }
    /**
     * Creates page 0 of the multi-page editor,
     * which contains a text editor.
     */
    void createPageSouce() {
        try {
            editor = new MAS2JTextEditor();
            
            int index = addPage(editor, getEditorInput());
            setPageText(index, "Source");
        } catch (PartInitException e) {
            ErrorDialog.openError(
                getSite().getShell(),
                "Error creating nested text editor",
                null,
                e.getStatus());
        }
    }
    
    /**
     * Creates page 1 of the multi-page editor,
     * which allows you to change the font used in page 2.
     */
    void createPageDesign() {       
        mas2jDesignComposite = new MAS2JDesignComposite(editor, getContainer(), SWT.NONE);
        
        int index = addPage(mas2jDesignComposite);
        setPageText(index, "Design");
    }
    
    /**
     * Creates the pages of the multi-page editor.
     */
    protected void createPages() {
        createPageSouce();
        createPageDesign();
    }
    /**
     * The <code>MultiPageEditorPart</code> implementation of this 
     * <code>IWorkbenchPart</code> method disposes all nested editors.
     * Subclasses may extend.
     */
    public void dispose() {
        ResourcesPlugin.getWorkspace().removeResourceChangeListener(this);
        super.dispose();
    }
    
    /**
     * Saves the multi-page editor's document.
     */
    public void doSave(IProgressMonitor monitor) {
        getEditor(0).doSave(monitor);
        
        compileInput();
    }
    
    /**
     * Saves the multi-page editor's document as another file.
     * Also updates the text for page 0's tab, and updates this multi-page editor's input
     * to correspond to the nested editor's.
     */
    public void doSaveAs() {
        IEditorPart editor = getEditor(0);
        editor.doSaveAs();
        setPageText(0, editor.getTitle());
        setInput(editor.getEditorInput());
    }
    /* (non-Javadoc)
     * Method declared on IEditorPart
     */
    public void gotoMarker(IMarker marker) {
        setActivePage(0);
    
        IDE.gotoMarker(getEditor(0), marker);
    }
    /**
     * The <code>MultiPageEditorExample</code> implementation of this method
     * checks that the input is an instance of <code>IFileEditorInput</code>.
     */
    public void init(IEditorSite site, IEditorInput editorInput) throws PartInitException {
        super.init(site, editorInput);
        setPartNameForEditorInput(editorInput);
    }
    
    /**
     * Sets the part name for given editorInput.
     * @param editorInput
     */
    private void setPartNameForEditorInput(IEditorInput editorInput) {
        IFileEditorInput iei = (IFileEditorInput)editorInput;
        IFile ifile = iei.getFile();
        
        this.setPartName(ifile.getName());
    }
    
    /**
     * Compiles Mas2J Project for given editorInput.
     * @param editorInput
     */
    void compileInput() {
        IEditorInput editorInput = getEditor(0).getEditorInput();
        
        IFileEditorInput iei = (IFileEditorInput)editorInput;
        IFile ifile = iei.getFile();
        
        IDocument document = editor.getDocumentProvider().getDocument(editor.getEditorInput());
        
        // delete old markers
        PluginMarkerUtils.deleteOldMarkers(ifile);
        
        IProject project = ifile.getProject();
        String mas2jFilePath = null;
        try {
            // absolute project location + filePath relative in project (without project name)
            mas2jFilePath = project.getLocation().toString() + getFilePathWithoutProjectName(ifile);
            
            // compile Mas2J
            MAS2JProject mas2Project = MAS2JHandler.parse(mas2jFilePath);
            
            // extract infos
            extractInfoFromMas2J(mas2Project);
        } catch (ParseException e) {
            try {
                String msg = e.getMessage();
                int lineError = e.currentToken.beginLine; //PluginMarkerUtils.getLineNumberFromMsg(msg);
                PluginMarkerUtils.createMarker(ifile, e.getMessage().replace("\r", "").replace("\n", ""), 
                             lineError,
                             PluginMarkerUtils.getCharStart(document.get(), lineError, msg),
                             PluginMarkerUtils.getCharEnd(document.get(), lineError, msg));
            } catch (Exception e2) {
                e2.printStackTrace(); // debug
            }
        } catch (Throwable e) {
            PluginMarkerUtils.createMarker(ifile, e.getMessage(), 0, 0, 0);
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
    
    /**
     * Extracts informations from Mas2JProject object.
     * @param masProject
     */
    private void extractInfoFromMas2J(MAS2JProject masProject) {
        infraStructure = masProject.getInfrastructure().toString();
        agents = MAS2JHandler.getAgentsFromMas2jProject(masProject);
        envClass = masProject.getEnvClass();
        controlExecClass = masProject.getControlClass();
        directives = MAS2JHandler.getDirectivesFromMas2jProject(masProject);
        classPath = MAS2JHandler.getClassPathFromMas2jProject(masProject);
        sourcePath = MAS2JHandler.getSourcePathFromMas2jProject(masProject); 
    }
    
    /**
     * Updates GUI of tab Design.
     */
    private void updateDesignGUI() {
        mas2jDesignComposite.setComboInfraStructure(infraStructure);
        mas2jDesignComposite.setAgentsList(agents);
        mas2jDesignComposite.setEnv(envClass);
        mas2jDesignComposite.setControl(controlExecClass);
        mas2jDesignComposite.setDirectivesList(directives);
        mas2jDesignComposite.setClassPathList(classPath);
        mas2jDesignComposite.setSourcePathList(sourcePath);
    }
    
    /**
     * Checks if save as allowed.
     */
    public boolean isSaveAsAllowed() {
        return true;
    }
    
    /**
     * Calculates the contents of page 2 when the it is activated.
     */
    protected void pageChange(int newPageIndex) {
        super.pageChange(newPageIndex);
        if (newPageIndex == 0) {
            // do something
        }
        else {
            // compile
            compileInput();
            
            // update GUI
            updateDesignGUI();
        }
    }
    
    /**
     * Closes all project files on project close.
     */
    public void resourceChanged(final IResourceChangeEvent event){
        if(event.getType() == IResourceChangeEvent.PRE_CLOSE){
            Display.getDefault().asyncExec(new Runnable(){
                public void run(){
                    IWorkbenchPage[] pages = getSite().getWorkbenchWindow().getPages();
                    for (int i = 0; i<pages.length; i++){
                        if(((FileEditorInput)editor.getEditorInput()).getFile().getProject().equals(event.getResource())){
                            IEditorPart editorPart = pages[i].findEditor(editor.getEditorInput());
                            pages[i].closeEditor(editorPart,true);
                        }
                    }
                }            
            });
        }
    }
    public MAS2JTextEditor getEditor() {
        return editor;
    }
}
