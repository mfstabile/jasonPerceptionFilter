package net.sourceforge.jasonide.editors.swtContainers;

import jason.mas2j.MAS2JProject;
import jason.mas2j.parser.ParseException;
import net.sourceforge.jasonide.Activator;
import net.sourceforge.jasonide.core.JasonPluginException;
import net.sourceforge.jasonide.core.MAS2JHandler;
import net.sourceforge.jasonide.editors.MAS2JTextEditor;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.jface.dialogs.ErrorDialog;
import org.eclipse.jface.text.IDocument;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.List;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IFileEditorInput;
import org.eclipse.ui.IWorkbenchWindow;

public class AddEditClassPathShell {

    private Shell sShell = null;
    private Label lPath = null;
    private Text tPath = null;
    private Button bInclude = null;
    private Button bCancel = null;
    private Group group = null;
    
    private MAS2JTextEditor editor;
    private List lbClassPath;

    private int action = ACTION_INSERT;
    
    public static final int ACTION_INSERT = 0;
    public static final int ACTION_EDIT = 1;
    
    public AddEditClassPathShell(MAS2JTextEditor editor, List lbClassPath, int action) {
        this.lbClassPath = lbClassPath;
        this.action = action;
        createSShell();
        
        this.editor = editor;
        this.tPath.setFocus();
    }
    
    /**
     * This method initializes sShell
     */
    private void createSShell() {
        sShell = new Shell(SWT.APPLICATION_MODAL | SWT.SHELL_TRIM);
        sShell.setSize(new Point(243, 120));
        sShell.setText("Class Path");
        sShell.setLayout(null);
        sShell.setVisible(true);
        lPath = new Label(sShell, SWT.NONE);
        lPath.setBounds(new Rectangle(11, 20, 68, 13));
        lPath.setText("Path:");
        tPath = new Text(sShell, SWT.BORDER);
        tPath.setBounds(new Rectangle(82, 15, 141, 19));
        bInclude = new Button(sShell, SWT.NONE);
        bInclude.setBounds(new Rectangle(37, 58, 76, 23));
        
        if (action == ACTION_INSERT) {
            bInclude.setText("Add");
        }
        else {
            bInclude.setText("Edit");
        }
                
        
        bInclude.addSelectionListener(new org.eclipse.swt.events.SelectionAdapter() {
            public void widgetSelected(org.eclipse.swt.events.SelectionEvent e) {
                String path = tPath.getText();
                
                IWorkbenchWindow window = Activator.getPluginInstance().getWorkbench().getActiveWorkbenchWindow();
                IEditorInput iei = window.getActivePage().getActiveEditor().getEditorInput();
                if (iei instanceof IFileEditorInput) {
                    IFileEditorInput ifei = (IFileEditorInput)iei;
                    IFile ifile = ifei.getFile();
                    IProject project = ifile.getProject();
                    
                    IDocument document = editor.getDocumentProvider().getDocument(editor.getEditorInput());
                    String editorContents = document.get();
                    
                    if (action == ACTION_INSERT) {                                  
                        // add path to List
                        lbClassPath.add(path);

                        // add path to editor contents.
                        try {
                            // write the contents of text editor in a temporary file to be parsed by Jason.
                            String tempFileName = MAS2JHandler.persistTempMas2JFile(project, editorContents);
                            try {
                                
                                // parse the mas2j file project.
                                MAS2JProject project2 = MAS2JHandler.parse(tempFileName);
                                
                                project2.addClassPath(path);
                                
                                // write the new mas2j project file in text editor.
                                document.set(MAS2JHandler.mas2jProjectToString(project2));
                            }
                            finally {
                                MAS2JHandler.deleteMas2JTempFile(tempFileName);
                            }
                        } catch (JasonPluginException e1) {
                            ErrorDialog.openError(window.getActivePage().getActiveEditor().getSite().getShell(), "Mas2J Error", e1.getMessage(), new Status(IStatus.ERROR, Activator.getPluginId(), IStatus.ERROR, e1.getMessage(), null));
                        } catch (ParseException e1) {
                            ErrorDialog.openError(window.getActivePage().getActiveEditor().getSite().getShell(), "Mas2J Error", e1.getMessage(), new Status(IStatus.ERROR, Activator.getPluginId(), IStatus.ERROR, e1.getMessage(), null));
                        }
                    }
                    else {
                        int index = lbClassPath.getSelectionIndex();
                        String oldPath = lbClassPath.getItem(index);
                        
                        lbClassPath.remove(index);
                        lbClassPath.add(path, index);
                        
                        // update path of editor contents.
                        try {
                            // write the contents of text editor in a temporary file to be parsed by Jason.
                            String tempFileName = MAS2JHandler.persistTempMas2JFile(project, editorContents);
                            try {
                                // parse the mas2j file project.
                                MAS2JProject project2 = MAS2JHandler.parse(tempFileName);
                            
                                int i = project2.getClassPaths().indexOf(oldPath);
                                project2.getClassPaths().remove(i);
                                project2.getClassPaths().add(i, path);
                                
                                // write the new mas2j project file in text editor.
                                document.set(MAS2JHandler.mas2jProjectToString(project2));
                            }
                            finally {
                                MAS2JHandler.deleteMas2JTempFile(tempFileName);
                            }
                        } catch (JasonPluginException e1) {
                            ErrorDialog.openError(window.getActivePage().getActiveEditor().getSite().getShell(), "Mas2J Error", e1.getMessage(), new Status(IStatus.ERROR, Activator.getPluginId(), IStatus.ERROR, e1.getMessage(), null));
                        } catch (ParseException e1) {
                            ErrorDialog.openError(window.getActivePage().getActiveEditor().getSite().getShell(), "Mas2J Error", e1.getMessage(), new Status(IStatus.ERROR, Activator.getPluginId(), IStatus.ERROR, e1.getMessage(), null));
                        }
                    }
                }
                sShell.close();
            }
        });
        bCancel = new Button(sShell, SWT.NONE);
        bCancel.setLocation(new Point(120, 58));
        bCancel.setText("Cancel");
        bCancel.setSize(new Point(76, 23));
        bCancel.addSelectionListener(new org.eclipse.swt.events.SelectionAdapter() {
            public void widgetSelected(org.eclipse.swt.events.SelectionEvent e) {
                sShell.close();
            }
        });
        createGroup();
    }
    /**
     * This method initializes group
     *
     */
    private void createGroup() {
        group = new Group(sShell, SWT.NONE);
        group.setLayout(new GridLayout());
        group.setBounds(new Rectangle(4, -1, 227, 54));
    }

    public void setInput(String path) {
        tPath.setText(path);
    }
}
