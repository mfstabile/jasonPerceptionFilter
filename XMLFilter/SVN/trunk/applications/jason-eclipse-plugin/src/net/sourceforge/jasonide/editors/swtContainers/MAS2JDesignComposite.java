package net.sourceforge.jasonide.editors.swtContainers;

import jason.mas2j.AgentParameters;
import jason.mas2j.ClassParameters;
import jason.mas2j.MAS2JProject;
import jason.mas2j.parser.ParseException;
import net.sourceforge.jasonide.Activator;
import net.sourceforge.jasonide.core.JasonPluginConstants;
import net.sourceforge.jasonide.core.JasonPluginException;
import net.sourceforge.jasonide.core.MAS2JHandler;
import net.sourceforge.jasonide.editors.MAS2JTextEditor;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.jdt.core.IType;
import org.eclipse.jdt.ui.IJavaElementSearchConstants;
import org.eclipse.jdt.ui.JavaUI;
import org.eclipse.jface.dialogs.ErrorDialog;
import org.eclipse.jface.text.IDocument;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.FocusListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.List;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IFileEditorInput;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.dialogs.SelectionDialog;

public class MAS2JDesignComposite extends Composite {

    private Label lTitle = null;
    private Group group = null;
    private Label lInfra = null;
    private Combo cbInfra = null;
    private Label lEnvironment = null;
    private Text tEnvironment = null;
    private Label lEnvironmentHost = null;
    private Text tEnvironmentHost = null;
    private Label lExeControl = null;
    private Text tExeControl = null;
    private Label lExeControlHost = null;
    private Text tExeControlHost = null;
    private Label lAgents = null;
    private List lbAgents = null;
    private Label lDirectives = null;
    private List lbDirectives = null;
    private Label lClassPath = null;
    private List lbClassPath = null;
    private Label lSourcePath = null;
    private List lbSourcePath = null;
    private Button bBrowseEnvironmentClass = null;
    private Button bBrowseExecutionControlClass = null;
    private Button bAddAg = null;
    private Button bRemAg = null;
    private Button bEditAg = null;
    private Button bAddDirective = null;
    private Button bRemDirective = null;
    private Button bEditDirective = null;
    private Button bAddClassPath = null;
    private Button bRemClassPath = null;
    private Button bEditClassPath = null;
    private Button bAddSourcePath = null;
    private Button bRemSourcePath = null;
    private Button bEditSourcePath = null;
    
    private MAS2JTextEditor editor;
    
    public MAS2JDesignComposite(MAS2JTextEditor editor, Composite parent, int style) {
        super(parent, style);
        initialize();
        this.editor = editor;
    }

    private void initialize() {
        lTitle = new Label(this, SWT.SHADOW_OUT);
        createGroup();
        lTitle.setBackground(new Color(Display.getCurrent(), 255, 255, 255));
        lTitle.setBounds(new Rectangle(7, 5, 151, 19));
        lTitle.setFont(new Font(Display.getDefault(), "Tahoma", 12, SWT.BOLD));
        lTitle.setText("Jason MAS Project");
        this.setLayout(null);
        this.setBackground(new Color(Display.getCurrent(), 255, 255, 255));
        setSize(new Point(644, 245));
    }

    /**
     * This method initializes group
     *
     */
    private void createGroup() {
        group = new Group(this, SWT.NONE);
        group.setBackground(new Color(Display.getCurrent(), 255, 255, 255));
        group.setText("Project Details");
        group.setBounds(new Rectangle(7, 36, 494, 400));
        group.setLayout(null);
        lInfra = new Label(group, SWT.NONE);
        lInfra.setText("Infrastructure:");
        lInfra.setBounds(new Rectangle(11, 35, 89, 13));
        lInfra.setFont(new Font(Display.getDefault(), "Tahoma", 8, SWT.NORMAL));
        lInfra.setForeground(new Color(Display.getCurrent(), 0, 0, 0));
        lInfra.setBackground(new Color(Display.getCurrent(), 255, 255, 255));
        createCbInfra();
        
        lEnvironment = new Label(group, SWT.NONE);
        lEnvironment.setText("Environment Class:");
        lEnvironment.setBounds(new Rectangle(11, 83, 110, 13));
        lEnvironment.setFont(new Font(Display.getDefault(), "Tahoma", 8, SWT.NORMAL));
        lEnvironment.setForeground(new Color(Display.getCurrent(), 0, 0, 0));
        lEnvironment.setBackground(new Color(Display.getCurrent(), 255, 255, 255));
        tEnvironment = new Text(group, SWT.BORDER);
        tEnvironment.setBounds(new Rectangle(11, 98, 175, 19));
        
        tEnvironment.addFocusListener(
            new FocusListener() {

                public void focusGained(FocusEvent e) {}

                public void focusLost(FocusEvent e) {
                    IWorkbenchWindow window = Activator.getPluginInstance().getWorkbench().getActiveWorkbenchWindow();
                    IEditorInput iei = window.getActivePage().getActiveEditor().getEditorInput();
                    if (iei instanceof IFileEditorInput) {
                        IFileEditorInput ifei = (IFileEditorInput)iei;
                        IFile ifile = ifei.getFile();
                        IProject project = ifile.getProject();
                        
                        IDocument document = editor.getDocumentProvider().getDocument(editor.getEditorInput());
                        String editorContents = document.get();
                        
                        try {
                            // write the contents of text editor in a temporary file to be parsed by Jason.
                            String tempFileName = MAS2JHandler.persistTempMas2JFile(project, editorContents);
                            try {
                                // parse the mas2j file project.
                                MAS2JProject project2 = MAS2JHandler.parse(tempFileName);
                                
                                // set the new env class
                                if (!tEnvironment.getText().equals("")) {
                                    project2.setEnvClass(new ClassParameters(tEnvironment.getText()));
                                }
                                else {
                                    project2.setEnvClass(new ClassParameters(JasonPluginConstants.DEFAULT_ENVIRONMENT));
                                    tEnvironmentHost.setText("");
                                }
                                // write the new mas2j project file in text editor.
                                document.set(MAS2JHandler.mas2jProjectToString(project2));
                            }
                            finally {
                                MAS2JHandler.deleteMas2JTempFile(tempFileName);
                            }
                        }
                        catch (JasonPluginException e1) {
                            ErrorDialog.openError(window.getActivePage().getActiveEditor().getSite().getShell(), "Mas2J Error", e1.getMessage(), new Status(IStatus.ERROR, Activator.getPluginId(), IStatus.ERROR, e1.getMessage(), null));
                        }
                        catch (ParseException e1) {
                            ErrorDialog.openError(window.getActivePage().getActiveEditor().getSite().getShell(), "Mas2J Error", e1.getMessage(), new Status(IStatus.ERROR, Activator.getPluginId(), IStatus.ERROR, e1.getMessage(), null));
                        }
                        
                    }
                }
            }
        );
        
        bBrowseEnvironmentClass = new Button(group, SWT.NONE);
        bBrowseEnvironmentClass.setBounds(new Rectangle(191, 98, 28, 19));
        bBrowseEnvironmentClass.setText("...");
        bBrowseEnvironmentClass.setSize(new Point(50, 19));
        
        bBrowseEnvironmentClass.addSelectionListener(
                new SelectionListener() {

                    public void widgetDefaultSelected(SelectionEvent e) {}
                    
                    public void widgetSelected(SelectionEvent e) {
                        IWorkbenchWindow window = Activator.getPluginInstance().getWorkbench().getActiveWorkbenchWindow();
                        IEditorInput iei = window.getActivePage().getActiveEditor().getEditorInput();
                        if (iei instanceof IFileEditorInput) {
                            IFileEditorInput ifei = (IFileEditorInput)iei;
                            IFile ifile = ifei.getFile();
                            IProject project = ifile.getProject();
                            
                            try {
                                SelectionDialog d = JavaUI.createTypeDialog(MAS2JDesignComposite.this.getShell(), null, project, IJavaElementSearchConstants.CONSIDER_CLASSES_AND_INTERFACES, false);
                                d.setTitle("Environment Class Selection");
                                d.open();
                                Object[] result = d.getResult();
                                if (result != null && result.length > 0) {
                                    tEnvironment.setText(((IType)result[0]).getFullyQualifiedName());
                                    tEnvironment.setFocus();
                                    tEnvironmentHost.setFocus();
                                }
                            } catch (Exception e1) {
                                e1.printStackTrace();
                            }
                        }
                    }
                }
        );
        
        lEnvironmentHost = new Label(group, SWT.NONE);
        lEnvironmentHost.setText("Environment Host:");
        lEnvironmentHost.setBounds(new Rectangle(252, 83, 110, 13));
        lEnvironmentHost.setFont(new Font(Display.getDefault(), "Tahoma", 8, SWT.NORMAL));
        lEnvironmentHost.setForeground(new Color(Display.getCurrent(), 0, 0, 0));
        lEnvironmentHost.setBackground(new Color(Display.getCurrent(), 255, 255, 255));
        tEnvironmentHost = new Text(group, SWT.BORDER);
        tEnvironmentHost.setBounds(new Rectangle(252, 98, 145, 19));
        
        tEnvironmentHost.addFocusListener(
            new FocusListener() {

                public void focusGained(FocusEvent e) {}

                public void focusLost(FocusEvent e) {
                    IWorkbenchWindow window = Activator.getPluginInstance().getWorkbench().getActiveWorkbenchWindow();
                    IEditorInput iei = window.getActivePage().getActiveEditor().getEditorInput();
                    if (iei instanceof IFileEditorInput) {
                        IFileEditorInput ifei = (IFileEditorInput)iei;
                        IFile ifile = ifei.getFile();
                        IProject project = ifile.getProject();
                        
                        IDocument document = editor.getDocumentProvider().getDocument(editor.getEditorInput());
                        String editorContents = document.get();
                        
                        try {
                            // write the contents of text editor in a temporary file to be parsed by Jason.
                            String tempFileName = MAS2JHandler.persistTempMas2JFile(project, editorContents);
                            try {
                                // parse the mas2j file project.
                                MAS2JProject project2 = MAS2JHandler.parse(tempFileName);
                                
                                // set the new infra defined.
                                ClassParameters envClass = project2.getEnvClass();
                                if (envClass != null) {
                                    if (!tEnvironmentHost.getText().equals("")) {
                                        envClass.setHost("\"" + tEnvironmentHost.getText() + "\"");
                                    }
                                    else {
                                        envClass.setHost(null);
                                    }
                                }
                                
                                // write the new mas2j project file in text editor.
                                document.set(MAS2JHandler.mas2jProjectToString(project2));
                            }
                            finally {
                                MAS2JHandler.deleteMas2JTempFile(tempFileName);
                            }
                        }
                        catch (JasonPluginException e1) {
                            ErrorDialog.openError(window.getActivePage().getActiveEditor().getSite().getShell(), "Mas2J Error", e1.getMessage(), new Status(IStatus.ERROR, Activator.getPluginId(), IStatus.ERROR, e1.getMessage(), null));
                        }
                        catch (ParseException e1) {
                            ErrorDialog.openError(window.getActivePage().getActiveEditor().getSite().getShell(), "Mas2J Error", e1.getMessage(), new Status(IStatus.ERROR, Activator.getPluginId(), IStatus.ERROR, e1.getMessage(), null));
                        }
                        
                    }
                }
            }
        );
        
        lExeControl = new Label(group, SWT.NONE);
        lExeControl.setText("Execution Control Class:");
        lExeControl.setBounds(new Rectangle(11, 128, 120, 13));
        lExeControl.setFont(new Font(Display.getDefault(), "Tahoma", 8, SWT.NORMAL));
        lExeControl.setForeground(new Color(Display.getCurrent(), 0, 0, 0));
        lExeControl.setBackground(new Color(Display.getCurrent(), 255, 255, 255));
        tExeControl = new Text(group, SWT.BORDER);
        tExeControl.setBounds(new Rectangle(11, 143, 175, 19));
        
        tExeControl.addFocusListener(
            new FocusListener() {

                public void focusGained(FocusEvent e) {}

                public void focusLost(FocusEvent e) {
                    IWorkbenchWindow window = Activator.getPluginInstance().getWorkbench().getActiveWorkbenchWindow();
                    IEditorInput iei = window.getActivePage().getActiveEditor().getEditorInput();
                    if (iei instanceof IFileEditorInput) {
                        IFileEditorInput ifei = (IFileEditorInput)iei;
                        IFile ifile = ifei.getFile();
                        IProject project = ifile.getProject();
                        
                        IDocument document = editor.getDocumentProvider().getDocument(editor.getEditorInput());
                        String editorContents = document.get();
                        
                        try {
                            // write the contents of text editor in a temporary file to be parsed by Jason.
                            String tempFileName = MAS2JHandler.persistTempMas2JFile(project, editorContents);
                            try {
                                // parse the mas2j file project.
                                MAS2JProject project2 = MAS2JHandler.parse(tempFileName);
                                
                                // set the new env class
                                if (!tExeControl.getText().equals("")) {
                                    project2.setControlClass(new ClassParameters(tExeControl.getText()));
                                }
                                else {
                                    project2.setControlClass(null);
                                    tExeControlHost.setText("");
                                }
                                // write the new mas2j project file in text editor.
                                document.set(MAS2JHandler.mas2jProjectToString(project2));
                            }
                            finally {
                                MAS2JHandler.deleteMas2JTempFile(tempFileName);
                            }
                        }
                        catch (JasonPluginException e1) {
                            ErrorDialog.openError(window.getActivePage().getActiveEditor().getSite().getShell(), "Mas2J Error", e1.getMessage(), new Status(IStatus.ERROR, Activator.getPluginId(), IStatus.ERROR, e1.getMessage(), null));
                        }
                        catch (ParseException e1) {
                            ErrorDialog.openError(window.getActivePage().getActiveEditor().getSite().getShell(), "Mas2J Error", e1.getMessage(), new Status(IStatus.ERROR, Activator.getPluginId(), IStatus.ERROR, e1.getMessage(), null));
                        }
                        
                    }
                }
            }
        );
        
        bBrowseExecutionControlClass = new Button(group, SWT.NONE);
        bBrowseExecutionControlClass.setBounds(new Rectangle(191, 143, 28, 19));
        bBrowseExecutionControlClass.setText("...");
        bBrowseExecutionControlClass.setSize(new Point(50, 19));
        
        bBrowseExecutionControlClass.addSelectionListener(
            new SelectionListener() {

                public void widgetDefaultSelected(SelectionEvent e) {}
                
                public void widgetSelected(SelectionEvent e) {
                    IWorkbenchWindow window = Activator.getPluginInstance().getWorkbench().getActiveWorkbenchWindow();
                    IEditorInput iei = window.getActivePage().getActiveEditor().getEditorInput();
                    if (iei instanceof IFileEditorInput) {
                        IFileEditorInput ifei = (IFileEditorInput)iei;
                        IFile ifile = ifei.getFile();
                        IProject project = ifile.getProject();
                        
                        try {
                            SelectionDialog d = JavaUI.createTypeDialog(MAS2JDesignComposite.this.getShell(), null, project, IJavaElementSearchConstants.CONSIDER_CLASSES_AND_INTERFACES, false);
                            d.setTitle("Execution Control Class Selection");                        
                            d.open();
                            Object[] result = d.getResult();
                            if (result != null && result.length > 0) {
                                tExeControl.setText(((IType)result[0]).getFullyQualifiedName());
                                tExeControl.setFocus();
                                tExeControlHost.setFocus();
                            }
                        } catch (Exception e1) {
                            e1.printStackTrace();
                        }
                    }
                }
            }
        );
        
        lExeControlHost = new Label(group, SWT.NONE);
        lExeControlHost.setText("Execution Control Host:");
        lExeControlHost.setBounds(new Rectangle(252, 128, 120, 13));
        lExeControlHost.setFont(new Font(Display.getDefault(), "Tahoma", 8, SWT.NORMAL));
        lExeControlHost.setForeground(new Color(Display.getCurrent(), 0, 0, 0));
        lExeControlHost.setBackground(new Color(Display.getCurrent(), 255, 255, 255));
        tExeControlHost = new Text(group, SWT.BORDER);
        tExeControlHost.setBounds(new Rectangle(252, 143, 145, 19));
        
        tExeControlHost.addFocusListener(
            new FocusListener() {

                public void focusGained(FocusEvent e) {}

                public void focusLost(FocusEvent e) {
                    IWorkbenchWindow window = Activator.getPluginInstance().getWorkbench().getActiveWorkbenchWindow();
                    IEditorInput iei = window.getActivePage().getActiveEditor().getEditorInput();
                    if (iei instanceof IFileEditorInput) {
                        IFileEditorInput ifei = (IFileEditorInput)iei;
                        IFile ifile = ifei.getFile();
                        IProject project = ifile.getProject();
                        
                        IDocument document = editor.getDocumentProvider().getDocument(editor.getEditorInput());
                        String editorContents = document.get();
                        
                        try {
                            // write the contents of text editor in a temporary file to be parsed by Jason.
                            String tempFileName = MAS2JHandler.persistTempMas2JFile(project, editorContents);
                            try {
                                // parse the mas2j file project.
                                MAS2JProject project2 = MAS2JHandler.parse(tempFileName);
                                
                                // set the new infra defined.
                                ClassParameters controlClass = project2.getControlClass();
                                if (controlClass != null) {
                                    if (!tExeControlHost.getText().equals("")) {
                                        controlClass.setHost("\"" + tExeControlHost.getText() + "\"");
                                    }
                                    else {
                                        controlClass.setHost(null);
                                    }
                                }
                                
                                // write the new mas2j project file in text editor.
                                document.set(MAS2JHandler.mas2jProjectToString(project2));
                            }
                            finally {
                                MAS2JHandler.deleteMas2JTempFile(tempFileName);
                            }
                        }
                        catch (JasonPluginException e1) {
                            ErrorDialog.openError(window.getActivePage().getActiveEditor().getSite().getShell(), "Mas2J Error", e1.getMessage(), new Status(IStatus.ERROR, Activator.getPluginId(), IStatus.ERROR, e1.getMessage(), null));
                        }
                        catch (ParseException e1) {
                            ErrorDialog.openError(window.getActivePage().getActiveEditor().getSite().getShell(), "Mas2J Error", e1.getMessage(), new Status(IStatus.ERROR, Activator.getPluginId(), IStatus.ERROR, e1.getMessage(), null));
                        }
                        
                    }
                }
            }
        );
        
        lAgents = new Label(group, SWT.NONE);
        lAgents.setBackground(new Color(Display.getCurrent(), 255, 255, 255));
        lAgents.setSize(new Point(40, 13));
        lAgents.setLocation(new Point(11, 173));
        lAgents.setText("Agents:");
        createLbAgents();
        
        bAddAg = new Button(group, SWT.NONE);
        bAddAg.setBounds(new Rectangle(191, 188, 28, 25));
        bAddAg.setText("Add");
        bAddAg.setSize(new Point(50, 25));
        
        bAddAg.addSelectionListener(new SelectionAdapter() {
            public void widgetSelected(SelectionEvent e) {
                new AddEditAgentShell(editor, lbAgents, AddEditAgentShell.ACTION_INSERT);
            }
        });
        
        bEditAg = new Button(group, SWT.NONE);
        bEditAg.setLocation(new Point(191, 216));
        bEditAg.setText("Edit");
        bEditAg.setSize(new Point(50, 25));
        
        bEditAg.addSelectionListener(new SelectionAdapter() {
            public void widgetSelected(SelectionEvent e) {
                String[] agents = lbAgents.getSelection();
                if (agents.length == 1) {
                    AddEditAgentShell s = new AddEditAgentShell(editor, lbAgents, AddEditAgentShell.ACTION_EDIT);
                    s.setInput(agents[0]);
                }
            }
        });
        
        bRemAg = new Button(group, SWT.NONE);
        bRemAg.setLocation(new Point(191, 244));
        bRemAg.setText("Remove");
        bRemAg.setSize(new Point(50, 25));
        
        bRemAg.addSelectionListener(new SelectionAdapter() {
            public void widgetSelected(SelectionEvent e) {
                IWorkbenchWindow window = Activator.getPluginInstance().getWorkbench().getActiveWorkbenchWindow();
                if (lbAgents.getItemCount() > 1) {
                    String[] agents = lbAgents.getSelection();
                    if (agents.length == 1) {
                        // remove from list.
                        lbAgents.remove(agents[0]);
                        
                        String agName = MAS2JHandler.getCleanAgentName(agents[0]);
                        
                        // remove from editor contents.
                        IEditorInput iei = window.getActivePage().getActiveEditor().getEditorInput();
                        if (iei instanceof IFileEditorInput) {
                            IFileEditorInput ifei = (IFileEditorInput)iei;
                            IFile ifile = ifei.getFile();
                            IProject project = ifile.getProject();
                            
                            IDocument document = editor.getDocumentProvider().getDocument(editor.getEditorInput());
                            String editorContents = document.get();
                            
                            try {
                                // write the contents of text editor in a temporary file to be parsed by Jason.
                                String tempFileName = MAS2JHandler.persistTempMas2JFile(project, editorContents);
                                try {
                                    
                                    // parse the mas2j file project.
                                    MAS2JProject project2 = MAS2JHandler.parse(tempFileName);
        
                                    // locate agent to be removed.
                                    java.util.List mas2jAgents = project2.getAgents();
                                    for (int j = 0; j < mas2jAgents.size(); j++) {
                                        String xAgName = ((AgentParameters)mas2jAgents.get(j)).name;
                                        if (xAgName.equals(agName)) {
                                            mas2jAgents.remove(j);
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
                }
                else {
                    ErrorDialog.openError(window.getActivePage().getActiveEditor().getSite().getShell(), "Warning", "The project must contain least one agent.", new Status(IStatus.WARNING, Activator.getPluginId(), IStatus.WARNING, "You tried to remove the unique agent of the project.", null));
                }
            }
        });
        
        lClassPath = new Label(group, SWT.NONE);
        lClassPath.setBackground(new Color(Display.getCurrent(), 255, 255, 255));
        lClassPath.setSize(new Point(110, 13));
        lClassPath.setLocation(new Point(252, 173));
        lClassPath.setText("Class Path:");
        createLbClassPaths();
        
        bAddClassPath = new Button(group, SWT.NONE);
        bAddClassPath.setBounds(new Rectangle(432, 188, 28, 25));
        bAddClassPath.setText("Add");
        bAddClassPath.setSize(new Point(50, 25));
        
        bAddClassPath.addSelectionListener(new SelectionAdapter() {
            public void widgetSelected(SelectionEvent e) {
                new AddEditClassPathShell(editor, lbClassPath, AddEditClassPathShell.ACTION_INSERT);
            }
        });
        
        bEditClassPath= new Button(group, SWT.NONE);
        bEditClassPath.setLocation(new Point(432, 216));
        bEditClassPath.setText("Edit");
        bEditClassPath.setSize(new Point(50, 25));
        
        bEditClassPath.addSelectionListener(new SelectionAdapter() {
            public void widgetSelected(SelectionEvent e) {
                String[] classPaths = lbClassPath.getSelection();
                if (classPaths.length == 1) {
                    AddEditClassPathShell s = new AddEditClassPathShell(editor, lbClassPath, AddEditClassPathShell.ACTION_EDIT);
                    s.setInput(classPaths[0]);
                }
            }
        });
        
        bRemClassPath = new Button(group, SWT.NONE);
        bRemClassPath.setLocation(new Point(432, 244));
        bRemClassPath.setText("Remove");
        bRemClassPath.setSize(new Point(50, 25));
        
        bRemClassPath.addSelectionListener(new SelectionAdapter() {
            public void widgetSelected(SelectionEvent e) {
                IWorkbenchWindow window = Activator.getPluginInstance().getWorkbench().getActiveWorkbenchWindow();
                String[] classpaths = lbClassPath.getSelection();
                if (classpaths.length == 1) {
                    // remove from list.
                    lbClassPath.remove(classpaths[0]);
                    
                    String path = classpaths[0];
                    
                    // remove from editor contents.
                    IEditorInput iei = window.getActivePage().getActiveEditor().getEditorInput();
                    if (iei instanceof IFileEditorInput) {
                        IFileEditorInput ifei = (IFileEditorInput)iei;
                        IFile ifile = ifei.getFile();
                        IProject project = ifile.getProject();
                        
                        IDocument document = editor.getDocumentProvider().getDocument(editor.getEditorInput());
                        String editorContents = document.get();
                        
                        try {
                            // write the contents of text editor in a temporary file to be parsed by Jason.
                            String tempFileName = MAS2JHandler.persistTempMas2JFile(project, editorContents);
                            try {
                                
                                // parse the mas2j file project.
                                MAS2JProject project2 = MAS2JHandler.parse(tempFileName);
                                int i = project2.getClassPaths().indexOf(path);
                                project2.getClassPaths().remove(i); 
                                
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
            }
        });
        
        lDirectives = new Label(group, SWT.NONE);
        lDirectives.setBackground(new Color(Display.getCurrent(), 255, 255, 255));
        lDirectives.setSize(new Point(110, 13));
        lDirectives.setLocation(new Point(11, 282));
        lDirectives.setText("Class Directives:");
        createLbDirectives();
        
        bAddDirective = new Button(group, SWT.NONE);
        bAddDirective.setBounds(new Rectangle(191, 297, 28, 25));
        bAddDirective.setText("Add");
        bAddDirective.setSize(new Point(50, 25));
        
        bAddDirective.addSelectionListener(new SelectionAdapter() {
            public void widgetSelected(SelectionEvent e) {
                new AddEditDirectiveShell(editor, lbDirectives, AddEditDirectiveShell.ACTION_INSERT);
            }
        });
        
        bEditDirective = new Button(group, SWT.NONE);
        bEditDirective.setLocation(new Point(191, 325));
        bEditDirective.setText("Edit");
        bEditDirective.setSize(new Point(50, 25));
        
        bEditDirective.addSelectionListener(new SelectionAdapter() {
            public void widgetSelected(SelectionEvent e) {
                String[] directives = lbDirectives.getSelection();
                if (directives.length == 1) {
                    AddEditDirectiveShell s = new AddEditDirectiveShell(editor, lbDirectives, AddEditDirectiveShell.ACTION_EDIT);
                    s.setInput(directives[0]);
                }
            }
        });
        
        bRemDirective = new Button(group, SWT.NONE);
        bRemDirective.setLocation(new Point(191, 353));
        bRemDirective.setText("Remove");
        bRemDirective.setSize(new Point(50, 25));
        
        bRemDirective.addSelectionListener(new SelectionAdapter() {
            public void widgetSelected(SelectionEvent e) {
                IWorkbenchWindow window = Activator.getPluginInstance().getWorkbench().getActiveWorkbenchWindow();
                String[] directives = lbDirectives.getSelection();
                if (directives.length == 1) {
                    // remove from list.
                    lbDirectives.remove(directives[0]);
                    
                    String directiveName = directives[0].split(" = ")[0];
                    
                    // remove from editor contents.
                    IEditorInput iei = window.getActivePage().getActiveEditor().getEditorInput();
                    if (iei instanceof IFileEditorInput) {
                        IFileEditorInput ifei = (IFileEditorInput)iei;
                        IFile ifile = ifei.getFile();
                        IProject project = ifile.getProject();
                        
                        IDocument document = editor.getDocumentProvider().getDocument(editor.getEditorInput());
                        String editorContents = document.get();
                        
                        try {
                            // write the contents of text editor in a temporary file to be parsed by Jason.
                            String tempFileName = MAS2JHandler.persistTempMas2JFile(project, editorContents);
                            try {
                                
                                // parse the mas2j file project.
                                MAS2JProject project2 = MAS2JHandler.parse(tempFileName);
    
                                java.util.Map directivesMas2j = project2.getDirectiveClasses();
                                Object[] keyset = directivesMas2j.keySet().toArray();
                                for (int j = 0; j < directivesMas2j.size(); j++) {
                                    if (((String)keyset[j]).equals(directiveName)) {
                                        directivesMas2j.remove(directiveName);
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
            }
        });
        
        lSourcePath = new Label(group, SWT.NONE);
        lSourcePath.setBackground(new Color(Display.getCurrent(), 255, 255, 255));
        lSourcePath.setSize(new Point(110, 13));
        lSourcePath.setLocation(new Point(252, 282));
        lSourcePath.setText("Source Path:");
        createLbSourcePaths();
        
        bAddSourcePath = new Button(group, SWT.NONE);
        bAddSourcePath.setBounds(new Rectangle(432, 297, 28, 25));
        bAddSourcePath.setText("Add");
        bAddSourcePath.setSize(new Point(50, 25));
        
        bAddSourcePath.addSelectionListener(new SelectionAdapter() {
            public void widgetSelected(SelectionEvent e) {
                new AddEditAslSourcePathShell(editor, lbSourcePath, AddEditAslSourcePathShell.ACTION_INSERT);
            }
        });
        
        bEditSourcePath = new Button(group, SWT.NONE);
        bEditSourcePath.setLocation(new Point(432, 325));
        bEditSourcePath.setText("Edit");
        bEditSourcePath.setSize(new Point(50, 25));
        
        bEditSourcePath.addSelectionListener(new SelectionAdapter() {
            public void widgetSelected(SelectionEvent e) {
                String[] aslSourcePaths = lbSourcePath.getSelection();
                if (aslSourcePaths.length == 1) {
                    AddEditAslSourcePathShell s = new AddEditAslSourcePathShell(editor, lbSourcePath, AddEditAslSourcePathShell.ACTION_EDIT);
                    s.setInput(aslSourcePaths[0]);
                }
            }
        });
        
        bRemSourcePath = new Button(group, SWT.NONE);
        bRemSourcePath.setLocation(new Point(432, 353));
        bRemSourcePath.setText("Remove");
        bRemSourcePath.setSize(new Point(50, 25));
        
        bRemSourcePath.addSelectionListener(new SelectionAdapter() {
            public void widgetSelected(SelectionEvent e) {
                IWorkbenchWindow window = Activator.getPluginInstance().getWorkbench().getActiveWorkbenchWindow();
                String[] aslSourcePaths = lbSourcePath.getSelection();
                if (aslSourcePaths.length == 1) {
                    // remove from list.
                    lbSourcePath.remove(aslSourcePaths[0]);
                    
                    String path = aslSourcePaths[0];
                    
                    // remove from editor contents.
                    IEditorInput iei = window.getActivePage().getActiveEditor().getEditorInput();
                    if (iei instanceof IFileEditorInput) {
                        IFileEditorInput ifei = (IFileEditorInput)iei;
                        IFile ifile = ifei.getFile();
                        IProject project = ifile.getProject();
                        
                        IDocument document = editor.getDocumentProvider().getDocument(editor.getEditorInput());
                        String editorContents = document.get();
                        
                        try {
                            // write the contents of text editor in a temporary file to be parsed by Jason.
                            String tempFileName = MAS2JHandler.persistTempMas2JFile(project, editorContents);
                            try {
                                
                                // parse the mas2j file project.
                                MAS2JProject project2 = MAS2JHandler.parse(tempFileName);
                                int i = project2.getSourcePaths().indexOf(path);
                                project2.removeSourcePath(i);
                                
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
            }
        });
    }

    /**
     * This method initializes cbInfra
     *
     */
    private void createCbInfra() {
        cbInfra = new Combo(group, SWT.READ_ONLY);
        cbInfra.setLocation(new Point(11, 50));
        cbInfra.setSize(new Point(175, 21));
    
        cbInfra.addSelectionListener(new org.eclipse.swt.events.SelectionListener() {
            public void widgetSelected(org.eclipse.swt.events.SelectionEvent e) {
                IWorkbenchWindow window = Activator.getPluginInstance().getWorkbench().getActiveWorkbenchWindow();
                IEditorInput iei = window.getActivePage().getActiveEditor().getEditorInput();
                if (iei instanceof IFileEditorInput) {
                    IFileEditorInput ifei = (IFileEditorInput)iei;
                    IFile ifile = ifei.getFile();
                    IProject project = ifile.getProject();
                    
                    IDocument document = editor.getDocumentProvider().getDocument(editor.getEditorInput());
                    String editorContents = document.get();
                    
                    try {
                        // write the contents of text editor in a temporary file to be parsed by Jason.
                        String tempFileName = MAS2JHandler.persistTempMas2JFile(project, editorContents);
                        try {
                            
                            // parse the mas2j file project.
                            MAS2JProject project2 = MAS2JHandler.parse(tempFileName);
                            
                            // set the new infra defined.
                            project2.setInfrastructure(new ClassParameters(cbInfra.getText()));
                            // write the new mas2j project file in text editor.
                            document.set(MAS2JHandler.mas2jProjectToString(project2));
                        }
                        finally {
                            MAS2JHandler.deleteMas2JTempFile(tempFileName);
                        }
                    }
                    catch (JasonPluginException e1) {
                        ErrorDialog.openError(window.getActivePage().getActiveEditor().getSite().getShell(), "Mas2J Error", e1.getMessage(), new Status(IStatus.ERROR, Activator.getPluginId(), IStatus.ERROR, e1.getMessage(), null));
                    }
                    catch (ParseException e1) {
                        ErrorDialog.openError(window.getActivePage().getActiveEditor().getSite().getShell(), "Mas2J Error", e1.getMessage(), new Status(IStatus.ERROR, Activator.getPluginId(), IStatus.ERROR, e1.getMessage(), null));
                    }
                    
                }
            }
            public void widgetDefaultSelected(org.eclipse.swt.events.SelectionEvent e) {}
        });
        
        // add Items
        java.util.List infras = MAS2JHandler.getUserInfraStructures();
        for (int i = 0; i < infras.size(); i++) {
            cbInfra.add((String)infras.get(i));
        }
    }

    /**
     * This method initializes lbAgents
     *
     */
    private void createLbAgents() {
        lbAgents = new List(group, SWT.BORDER | SWT.V_SCROLL);
        lbAgents.setLocation(new Point(11, 188));
        lbAgents.setSize(new Point(175, 83));
    }
    
    private void createLbDirectives() {
        lbDirectives = new List(group, SWT.BORDER | SWT.V_SCROLL);
        lbDirectives.setLocation(new Point(11, 297));
        lbDirectives.setSize(new Point(175, 83));
    }
    
    private void createLbClassPaths() {
        lbClassPath = new List(group, SWT.BORDER | SWT.V_SCROLL);
        lbClassPath.setLocation(new Point(252, 188));
        lbClassPath.setSize(new Point(175, 83));
    }
    
    private void createLbSourcePaths() {
        lbSourcePath = new List(group, SWT.BORDER | SWT.V_SCROLL);
        lbSourcePath.setLocation(new Point(252, 297));
        lbSourcePath.setSize(new Point(175, 83));
    }
    
    /**
     * Sets the combo infrastructure value.
     */
    public boolean setComboInfraStructure(String infraStr) {
        if (getComboInfraStructure().equals(infraStr)) {
            return false;
        }
        else {
            cbInfra.setText(infraStr);
            return true;
        }
    }
    
    public String getComboInfraStructure() {
        return cbInfra.getText();
    }
    
    public void setAgentsList(String[] agents) {
        lbAgents.removeAll();
        for (int i = 0; i < agents.length; i++) {
            lbAgents.add(agents[i]);
        }
    }
    
    public void setDirectivesList(String[] directives) {
        lbDirectives.removeAll();
        for (int i = 0; i < directives.length; i++) {
            lbDirectives.add(directives[i]);
        }
    }
    
    public void setClassPathList(String[] cps) {
        lbClassPath.removeAll();
        for (int i = 0; i < cps.length; i++) {
            lbClassPath.add(cps[i]);
        }
    }
    
    public void setSourcePathList(String[] sps) {
        lbSourcePath.removeAll();
        for (int i = 0; i < sps.length; i++) {
            lbSourcePath.add(sps[i]);
        }
    }
    
    public void addAgentToList(String agentName) {
        lbAgents.add(agentName);
    }
    
    public void setEnv(ClassParameters clazz) {
        if (clazz != null && (!clazz.getClassName().equals(jason.environment.Environment.class.getName()))) {
            tEnvironment.setText(clazz.toString());
            
            if (clazz.getHost() != null) {
                tEnvironmentHost.setText(clazz.getHost().replace("\"", ""));
			}
			else {
				tEnvironmentHost.setText("");
			}
		}
		else {
			tEnvironment.setText("");
			tEnvironmentHost.setText("");
		}
	}
	
	public void setControl(ClassParameters clazz) {
		if (clazz != null) {
			tExeControl.setText(clazz.toString());
			
			if (clazz.getHost() != null) {
				tExeControlHost.setText(clazz.getHost().replace("\"", ""));
            }
            else {
                tExeControlHost.setText("");
            }
        }
        else {
            tExeControl.setText("");
            tExeControlHost.setText("");
        }
    }
}
