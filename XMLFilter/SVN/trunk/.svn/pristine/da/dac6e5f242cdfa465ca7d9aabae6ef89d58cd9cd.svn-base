package net.sourceforge.jasonide.editors.swtContainers;

import java.io.File;

import jason.mas2j.AgentParameters;
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
import org.eclipse.jdt.core.IType;
import org.eclipse.jdt.ui.IJavaElementSearchConstants;
import org.eclipse.jdt.ui.JavaUI;
import org.eclipse.jface.dialogs.ErrorDialog;
import org.eclipse.jface.text.IDocument;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.List;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Spinner;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IFileEditorInput;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.dialogs.SelectionDialog;

public class AddEditAgentShell {

    private Shell sShell = null;
    private Label lAgentName = null;
    private Text tAgentName = null;
    private Label lCount = null;
    private Spinner sCount = null;
    private Button bInclude = null;
    private Button bCancel = null;
    private Label lAgentClass = null;
    private Text tAgentClass = null;
    private Label lArchirecture = null;
    private Text tArchitectureClass = null;
    private Label lAgentSource = null;
    private Text tAgentSource = null;
    private Label lBBClass = null;
    private Text tBBClass = null;
    private Label lHost = null;
    private Text tHost = null;
    private Button bBrowseAgentClass = null;
    private Button bBrowseArchitectureClass = null;
    private Button bBrowseBBClass = null;
    private Group group = null;
    
    private MAS2JTextEditor editor;
    private List lbAgents;

    private int action = ACTION_INSERT;
    
    public static final int ACTION_INSERT = 0;
    public static final int ACTION_EDIT = 1;
    
    public AddEditAgentShell(MAS2JTextEditor editor, List lbAgents, int action) {
        this.lbAgents = lbAgents;
        this.action = action;
        createSShell();
        
        this.editor = editor;
        this.tAgentName.setFocus();
    }
    
    /**
     * This method initializes sShell
     */
    private void createSShell() {
        sShell = new Shell(SWT.APPLICATION_MODAL | SWT.SHELL_TRIM);
        sShell.setSize(new Point(312, 262));
        sShell.setText("ASL Agent");
        sShell.setLayout(null);
        sShell.setVisible(true);
        lAgentName = new Label(sShell, SWT.NONE);
        lAgentName.setBounds(new Rectangle(38, 21, 65, 13));
        lAgentName.setText("Agent Name:");
        tAgentName = new Text(sShell, SWT.BORDER);
        tAgentName.setBounds(new Rectangle(110, 16, 141, 19));
        lCount = new Label(sShell, SWT.NONE);
        lCount.setText("Count:");
        lCount.setLocation(new Point(68, 177));
        lCount.setSize(new Point(35, 13));
        sCount = new Spinner(sShell, SWT.BORDER);
        sCount.setLocation(new Point(110, 172));
        sCount.setDigits(0);
        sCount.setSelection(1);
        sCount.setMinimum(1);
        sCount.setSize(new Point(61, 19));
        bInclude = new Button(sShell, SWT.NONE);
        bInclude.setBounds(new Rectangle(71, 203, 76, 23));
        
        if (action == ACTION_INSERT) {
            bInclude.setText("Add");
        }
        else {
            bInclude.setText("Edit");
        }
        
        bInclude.addSelectionListener(new org.eclipse.swt.events.SelectionAdapter() {
            public void widgetSelected(org.eclipse.swt.events.SelectionEvent e) {
                String agent = tAgentName.getText();
                
                if (sCount.getSelection() > 1) {
                    agent = agent + "#" + sCount.getSelection(); 
                }
                
                IWorkbenchWindow window = Activator.getPluginInstance().getWorkbench().getActiveWorkbenchWindow();
                IEditorInput iei = window.getActivePage().getActiveEditor().getEditorInput();
                if (iei instanceof IFileEditorInput) {
                    IFileEditorInput ifei = (IFileEditorInput)iei;
                    IFile ifile = ifei.getFile();
                    IProject project = ifile.getProject();
                    
                    IDocument document = editor.getDocumentProvider().getDocument(editor.getEditorInput());
                    String editorContents = document.get();
                    
                    if (action == ACTION_INSERT) {
                        // add agent to List
                        lbAgents.add(agent);

                        // add agent to editor contents.
                        try {
                            // write the contents of text editor in a temporary file to be parsed by Jason.
                            String tempFileName = MAS2JHandler.persistTempMas2JFile(project, editorContents);
                            try {
                                
                                // parse the mas2j file project.
                                MAS2JProject project2 = MAS2JHandler.parse(tempFileName);
                                
                                AgentParameters ag = new AgentParameters();
                                ag.name = tAgentName.getText();
                                ag.qty = sCount.getSelection();
                                
                                if (!tAgentClass.getText().equals("")) {
                                    ag.agClass = new ClassParameters(tAgentClass.getText());
                                }
                                else {
                                    ag.agClass = null;
                                }
                                
                                if (!tAgentSource.getText().equals("")) {
                                    ag.asSource = new File(tAgentSource.getText());
                                }
                                else {
                                    ag.asSource = null;
                                }
                                
                                if (!tArchitectureClass.getText().equals("")) {
                                    ag.addArchClass(tArchitectureClass.getText());
                                }
                                
                                if (!tBBClass.getText().equals("")) {
                                    ag.bbClass = new ClassParameters(tBBClass.getText());
                                }
                                else {
                                    ag.bbClass = null;
                                }
                                
                                if (!tHost.getText().equals("")) {
                                    ag.setHost(tHost.getText());
                                }
                                else {
                                    ag.setHost(null);
                                }
                                
                                project2.addAgent(ag);
                                
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
                        int index = lbAgents.getSelectionIndex();
                        String oldAgentName = MAS2JHandler.getCleanAgentName(lbAgents.getItem(index));
                        
                        lbAgents.remove(index);
                        lbAgents.add(agent, index);
                        
                        // update agent of editor contents.
                        try {
                            // write the contents of text editor in a temporary file to be parsed by Jason.
                            String tempFileName = MAS2JHandler.persistTempMas2JFile(project, editorContents);
                            try {
                                // parse the mas2j file project.
                                MAS2JProject project2 = MAS2JHandler.parse(tempFileName);
    
                                java.util.List mas2jAgents = project2.getAgents();
                                for (int j = 0; j < mas2jAgents.size(); j++) {
                                    AgentParameters xAgent = (AgentParameters)mas2jAgents.get(j);
                                    if (xAgent.name.equals(oldAgentName)) {
                                        xAgent.name = tAgentName.getText(); // new agent name
                                        xAgent.qty = sCount.getSelection();
                                        
                                        if (!tAgentClass.getText().equals("")) {
                                            xAgent.agClass = new ClassParameters(tAgentClass.getText());
                                        }
                                        else {
                                            xAgent.agClass = null;
                                        }
                                        
                                        if (!tAgentSource.getText().equals("")) {
                                            xAgent.asSource = new File(tAgentSource.getText());
                                        }
                                        else {
                                            xAgent.asSource = null;
                                        }
                                        
                                        if (!tArchitectureClass.getText().equals("")) {
                                            xAgent.addArchClass(tArchitectureClass.getText());
                                        }
                                        
                                        if (!tBBClass.getText().equals("")) {
                                            xAgent.bbClass = new ClassParameters(tBBClass.getText());
                                        }
                                        else {
                                            xAgent.bbClass = null;
                                        }
                                        
                                        if (!tHost.getText().equals("")) {
                                            xAgent.setHost(tHost.getText());
                                        }
                                        else {
                                            xAgent.setHost(null);
                                        }
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
        bCancel.setLocation(new Point(154, 203));
        bCancel.setText("Cancel");
        bCancel.setSize(new Point(76, 23));
        lAgentClass = new Label(sShell, SWT.NONE);
        lAgentClass.setBounds(new Rectangle(40, 47, 63, 13));
        lAgentClass.setText("Agent Class:");
        tAgentClass = new Text(sShell, SWT.BORDER);
        tAgentClass.setBounds(new Rectangle(110, 42, 141, 19));
        lArchirecture = new Label(sShell, SWT.NONE);
        lArchirecture.setBounds(new Rectangle(10, 73, 94, 13));
        lArchirecture.setText("Architecture Class:");
        tArchitectureClass = new Text(sShell, SWT.BORDER);
        tArchitectureClass.setBounds(new Rectangle(110, 68, 141, 19));
        lAgentSource = new Label(sShell, SWT.NONE);
        lAgentSource.setBounds(new Rectangle(32, 99, 70, 13));
        lAgentSource.setText("Agent Source:");
        tAgentSource = new Text(sShell, SWT.BORDER);
        tAgentSource.setBounds(new Rectangle(110, 94, 141, 19));
        lBBClass = new Label(sShell, SWT.NONE);
        lBBClass.setBounds(new Rectangle(17, 125, 85, 13));
        lBBClass.setText("Belief Base Class:");
        tBBClass = new Text(sShell, SWT.BORDER);
        tBBClass.setBounds(new Rectangle(110, 120, 141, 19));
        lHost = new Label(sShell, SWT.NONE);
        lHost.setBounds(new Rectangle(75, 151, 27, 13));
        lHost.setText("Host:");
        tHost = new Text(sShell, SWT.BORDER);
        tHost.setBounds(new Rectangle(110, 146, 141, 19));
        bBrowseAgentClass = new Button(sShell, SWT.NONE);
        bBrowseAgentClass.setBounds(new Rectangle(256, 43, 39, 18));
        bBrowseAgentClass.setText("...");
        bBrowseAgentClass.addSelectionListener(
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
                                SelectionDialog d = JavaUI.createTypeDialog(sShell, null, project, IJavaElementSearchConstants.CONSIDER_CLASSES_AND_INTERFACES, false);
                                d.setTitle("Agent Class Selection");
                                d.open();
                                Object[] result = d.getResult();
                                if (result != null && result.length > 0) {
                                    tAgentClass.setText(((IType)result[0]).getFullyQualifiedName());
                                    tAgentClass.setFocus();
                                    tArchitectureClass.setFocus();
                                }
                            } catch (Exception e1) {
                                e1.printStackTrace();
                            }
                        }
                    }
                }
        );
        
        bBrowseArchitectureClass = new Button(sShell, SWT.NONE);
        bBrowseArchitectureClass.setBounds(new Rectangle(256, 69, 39, 18));
        bBrowseArchitectureClass.setText("...");
        bBrowseArchitectureClass.addSelectionListener(
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
                                SelectionDialog d = JavaUI.createTypeDialog(sShell, null, project, IJavaElementSearchConstants.CONSIDER_CLASSES_AND_INTERFACES, false);
                                d.setTitle("Architecture Class Selection");
                                d.open();
                                Object[] result = d.getResult();
                                if (result != null && result.length > 0) {
                                    tArchitectureClass.setText(((IType)result[0]).getFullyQualifiedName());
                                    tArchitectureClass.setFocus();
                                    tAgentSource.setFocus();
                                }
                            } catch (Exception e1) {
                                e1.printStackTrace();
                            }
                        }
                    }
                }
        );
        
        bBrowseBBClass = new Button(sShell, SWT.NONE);
        bBrowseBBClass.setBounds(new Rectangle(256, 121, 39, 18));
        bBrowseBBClass.setText("...");
        bBrowseBBClass.addSelectionListener(
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
                                SelectionDialog d = JavaUI.createTypeDialog(sShell, null, project, IJavaElementSearchConstants.CONSIDER_CLASSES_AND_INTERFACES, false);
                                d.setTitle("Belief Base Class Selection");
                                d.open();
                                Object[] result = d.getResult();
                                if (result != null && result.length > 0) {
                                    tBBClass.setText(((IType)result[0]).getFullyQualifiedName());
                                    tBBClass.setFocus();
                                    tHost.setFocus();
                                }
                            } catch (Exception e1) {
                                e1.printStackTrace();
                            }
                        }
                    }
                }
        );
        
        
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
        group.setBounds(new Rectangle(4, -1, 296, 199));
    }

    public void setInput(String agent) {
        int index = agent.indexOf("#");
        if (index > -1) {
            String agName = agent.substring(0, index);
            String countStr = agent.substring(index+1, agent.length());
            
            tAgentName.setText(agName);
            sCount.setSelection(Integer.parseInt(countStr));
        }
        else {
            tAgentName.setText(agent);
        }
        
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

                    AgentParameters agentInfo = project2.getAg(tAgentName.getText());
                    
                    if (agentInfo.agClass != null) {
                        tAgentClass.setText(agentInfo.agClass.toString());
                    }
                    
                    if (!agentInfo.getAgArchClasses().isEmpty()) {
                        tArchitectureClass.setText(agentInfo.getAgArchClasses().get(0));
                    }
                    
                    if (agentInfo.asSource != null) {
                        String asSource = agentInfo.asSource.getName();
                        if (!asSource.equals(tAgentName.getText() + MAS2JHandler.AS_EXT)) {
                            tAgentSource.setText(agentInfo.asSource.getName());
                        }
                    }
                    
                    if (agentInfo.bbClass != null) {
                        tBBClass.setText(agentInfo.bbClass.toString());
                    }
                    
                    if (agentInfo.getHost() != null) {
                        tHost.setText(agentInfo.getHost().replace("\"", ""));
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
