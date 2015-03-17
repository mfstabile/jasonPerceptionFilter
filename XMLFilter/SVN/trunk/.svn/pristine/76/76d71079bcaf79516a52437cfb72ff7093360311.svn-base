package net.sourceforge.jasonide.editors.swtContainers;

import jason.mas2j.ClassParameters;
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

public class AddEditDirectiveShell {

    private Shell sShell = null;
    private Label lDirectiveName = null;
    private Text tDirectiveName = null;
    private Label lDirectiveValue = null;
    private Text tDirectiveValue = null;
    private Button bInclude = null;
    private Button bCancel = null;
    private Group group = null;
    
    private MAS2JTextEditor editor;
    private List lbDirectives;

    private int action = ACTION_INSERT;
    
    public static final int ACTION_INSERT = 0;
    public static final int ACTION_EDIT = 1;
    
    public AddEditDirectiveShell(MAS2JTextEditor editor, List lbDirectives, int action) {
        this.lbDirectives = lbDirectives;
        this.action = action;
        createSShell();
        
        this.editor = editor;
        this.tDirectiveName.setFocus();
    }
    
    /**
     * This method initializes sShell
     */
    private void createSShell() {
        sShell = new Shell(SWT.APPLICATION_MODAL | SWT.SHELL_TRIM);
        sShell.setSize(new Point(243, 142));
        sShell.setText("Directive");
        sShell.setLayout(null);
        sShell.setVisible(true);
        lDirectiveName = new Label(sShell, SWT.NONE);
        lDirectiveName.setBounds(new Rectangle(11, 20, 75, 13));
        lDirectiveName.setText("Directive Name:");
        tDirectiveName = new Text(sShell, SWT.BORDER);
        tDirectiveName.setBounds(new Rectangle(90, 15, 131, 19));
        lDirectiveValue = new Label(sShell, SWT.NONE);
        lDirectiveValue.setText("Directive Class:");
        lDirectiveValue.setLocation(new Point(11, 46));
        lDirectiveValue.setSize(new Point(75, 13));
        tDirectiveValue = new Text(sShell, SWT.BORDER);
        tDirectiveValue.setBounds(new Rectangle(90, 42, 131, 19));
        bInclude = new Button(sShell, SWT.NONE);
        bInclude.setBounds(new Rectangle(37, 79, 76, 23));
        
        if (action == ACTION_INSERT) {
            bInclude.setText("Add");
        }
        else {
            bInclude.setText("Edit");
        }
                
        
        bInclude.addSelectionListener(new org.eclipse.swt.events.SelectionAdapter() {
            public void widgetSelected(org.eclipse.swt.events.SelectionEvent e) {
                String dirName = tDirectiveName.getText();
                String dirValue = tDirectiveValue.getText();
                
                IWorkbenchWindow window = Activator.getPluginInstance().getWorkbench().getActiveWorkbenchWindow();
                IEditorInput iei = window.getActivePage().getActiveEditor().getEditorInput();
                if (iei instanceof IFileEditorInput) {
                    IFileEditorInput ifei = (IFileEditorInput)iei;
                    IFile ifile = ifei.getFile();
                    IProject project = ifile.getProject();
                    
                    IDocument document = editor.getDocumentProvider().getDocument(editor.getEditorInput());
                    String editorContents = document.get();
                    
                    if (action == ACTION_INSERT) {                                  
                        // add directive to List
                        lbDirectives.add(dirName + " = " + dirValue);

                        // add directive to editor contents.
                        try {
                            // write the contents of text editor in a temporary file to be parsed by Jason.
                            String tempFileName = MAS2JHandler.persistTempMas2JFile(project, editorContents);
                            try {
                                
                                // parse the mas2j file project.
                                MAS2JProject project2 = MAS2JHandler.parse(tempFileName);
    
                                project2.addDirectiveClass(dirName, new ClassParameters(dirValue));
                                
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
                        int index = lbDirectives.getSelectionIndex();
                        
                        String oldDirectiveName = lbDirectives.getItem(index).split(" = ")[0];
                        
                        lbDirectives.remove(index);
                        lbDirectives.add(dirName + " = " + dirValue, index);
                        // update directive of editor contents.
                        try {
                            // write the contents of text editor in a temporary file to be parsed by Jason.
                            String tempFileName = MAS2JHandler.persistTempMas2JFile(project, editorContents);
                            try {
                                // parse the mas2j file project.
                                MAS2JProject project2 = MAS2JHandler.parse(tempFileName);
    
                                java.util.Map directives = project2.getDirectiveClasses();
                                Object[] keyset = directives.keySet().toArray();
                                for (int j = 0; j < directives.size(); j++) {
                                    if (((String)keyset[j]).equals(oldDirectiveName)) {
                                        directives.remove(keyset[j]);
                                        directives.put(dirName, dirValue);
                                        break;
                                    }
                                }                               
                                
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
        bCancel.setLocation(new Point(120, 79));
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
        group.setBounds(new Rectangle(4, -1, 227, 76));
    }

    public void setInput(String directive) {
        String[] directiveAttrs = directive.split("=");
        tDirectiveName.setText(directiveAttrs[0].trim());
        tDirectiveValue.setText(directiveAttrs[1].trim());
    }
}
