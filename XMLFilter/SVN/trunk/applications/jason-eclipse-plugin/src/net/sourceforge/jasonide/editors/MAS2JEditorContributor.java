package net.sourceforge.jasonide.editors;

import org.eclipse.jface.action.IAction;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.actions.ActionFactory;
import org.eclipse.ui.ide.IDEActionFactory;
import org.eclipse.ui.part.MultiPageEditorActionBarContributor;
import org.eclipse.ui.texteditor.ITextEditor;
import org.eclipse.ui.texteditor.ITextEditorActionConstants;

/**
 * Manages the installation/deinstallation of global actions for multi-page editors.
 * Responsible for the redirection of global actions to the active editor.
 * Multi-page contributor replaces the contributors for the individual editors in the multi-page editor.
 */
public class MAS2JEditorContributor extends MultiPageEditorActionBarContributor /*implements RunProjectListener*/ {

//  private MASLauncherInfraTier masLauncher;
    private IEditorPart activeEditorPart;
//  private Action runAction;
//  private Action debugAction;
    
    /**
     * Creates a multi-page contributor.
     */
    public MAS2JEditorContributor() {
        super();
//      createActions();
    }
    /**
     * Returns the action registed with the given text editor.
     * @return IAction or null if editor is null.
     */
    protected IAction getAction(ITextEditor editor, String actionID) {
        return (editor == null ? null : editor.getAction(actionID));
    }
    /* (non-JavaDoc)
     * Method declared in AbstractMultiPageEditorActionBarContributor.
     */

    public void setActivePage(IEditorPart part) {
        if (activeEditorPart == part)
            return;

        activeEditorPart = part;

        IActionBars actionBars = getActionBars();
        if (actionBars != null) {

            ITextEditor editor = (part instanceof ITextEditor) ? (ITextEditor) part : null;

            actionBars.setGlobalActionHandler(
                ActionFactory.DELETE.getId(),
                getAction(editor, ITextEditorActionConstants.DELETE));
            actionBars.setGlobalActionHandler(
                ActionFactory.UNDO.getId(),
                getAction(editor, ITextEditorActionConstants.UNDO));
            actionBars.setGlobalActionHandler(
                ActionFactory.REDO.getId(),
                getAction(editor, ITextEditorActionConstants.REDO));
            actionBars.setGlobalActionHandler(
                ActionFactory.CUT.getId(),
                getAction(editor, ITextEditorActionConstants.CUT));
            actionBars.setGlobalActionHandler(
                ActionFactory.COPY.getId(),
                getAction(editor, ITextEditorActionConstants.COPY));
            actionBars.setGlobalActionHandler(
                ActionFactory.PASTE.getId(),
                getAction(editor, ITextEditorActionConstants.PASTE));
            actionBars.setGlobalActionHandler(
                ActionFactory.SELECT_ALL.getId(),
                getAction(editor, ITextEditorActionConstants.SELECT_ALL));
            actionBars.setGlobalActionHandler(
                ActionFactory.FIND.getId(),
                getAction(editor, ITextEditorActionConstants.FIND));
            actionBars.setGlobalActionHandler(
                IDEActionFactory.BOOKMARK.getId(),
                getAction(editor, IDEActionFactory.BOOKMARK.getId()));
            actionBars.updateActionBars();
        }
    }
    
//  private void createActions() {
//      runAction = new Action() {
//          public void run() {
//              runProject(false);
//          }
//      };
//      runAction.setText("Run MAS");
//      runAction.setToolTipText("Run MAS");
//      runAction.setImageDescriptor(Activator.getImageDescriptor("icons/execute.gif"));
//      
//      debugAction = new Action() {
//          public void run() {
//              runProject(true);
//          }
//      };
//      debugAction.setText("Debug MAS");
//      debugAction.setToolTipText("Debug MAS");
//      debugAction.setImageDescriptor(Activator.getImageDescriptor("icons/debug.gif"));
//  }
    
//  public void contributeToMenu(IMenuManager manager) {
//      IMenuManager menu = new MenuManager("Jason Plugin");
//      manager.prependToGroup(IWorkbenchActionConstants.MB_ADDITIONS, menu);
//      menu.add(runAction);
//      menu.add(debugAction);
//  }
    
//  public void contributeToToolBar(IToolBarManager manager) {
//      manager.add(new Separator());
//      manager.add(runAction);
//      manager.add(debugAction);
//  }
    
//  public void masFinished() {
//      changeEnableOfToolButtons(true);
//  }
    
//  public void changeEnableOfToolButtons(boolean enabled) {
//      debugAction.setEnabled(enabled);
//      runAction.setEnabled(enabled);
//  }
    
//  public void runProject(final boolean debug) {       
//      IWorkbenchWindow window = Activator.getPluginInstance().getWorkbench().getActiveWorkbenchWindow();
//      IEditorInput iei = window.getActivePage().getActiveEditor().getEditorInput();
//      if (iei instanceof IFileEditorInput) {
//          IFileEditorInput ifei = (IFileEditorInput)iei;
//          final IFile ifile = ifei.getFile();
//          final IProject iproject = ifile.getProject();
//          
//          window.getShell().getDisplay().asyncExec(new Runnable() {
//              public void run() {
//                  try {
//                      MAS2JProject project = MAS2JHandler.parseForRun(MAS2JHandler.getMas2JFileName(iproject), iproject.getLocation().toString());
//                      if (project != null && MAS2JHandler.parseProjectAS(project)) {
//                          if (masLauncher != null) {
//                              // stops old running mas
//                              masLauncher.stopMAS();
//                          }
//                          
//                          String javaHome = Config.get().getJavaHome();
//                          if (!Config.checkJavaHomePath(javaHome)) {
//                              System.err.println("The Java home directory (" + javaHome
//                                      + ") was not correctly set, the MAS may not run. Go to the Plugins->Options->Jason menu to configure the path.");
//                              return;
//                          }
//                          String antLib = Config.get().getAntLib();
//                          if (!Config.checkAntLib(antLib)) {
//                              System.err.println("The ant lib directory (" + antLib
//                                      + ") was not correctly set, the MAS may not run. Go to the Plugins->Options->Jason menu to configure the path.");
//                              return;
//                          }
//                          masLauncher = project.getInfrastructureFactory().createMASLauncher();
//                          masLauncher.setProject(project);
//                          masLauncher.setListener(MAS2JEditorContributor.this);
//                          if (masLauncher.writeScripts(debug)) {
//                              changeEnableOfToolButtons(false);                               
//                              new Thread(masLauncher, "MAS-Launcher").start();
//                          }
//                      }
//                  } catch (ParseException e) {
//                      String msg = "Compilation errors in the Mas2J project file:" + "\n\n" + e.getMessage();
//                      showError(msg, e);
//                      
//                  } catch (jason.asSyntax.parser.ParseException e) {
//                      String msg = "Compilation errors in ASL agent file:" + "\n\n" + e.getMessage();
//                      showError(msg, e);  
//                  } catch (JasonException e) {
//                      String msg = "Problems:" + "\n\n" + e.getMessage();
//                      showError(msg, e);
//                  } catch (FileNotFoundException e) {
//                      String msg = "Problem:" + "\n\n" + e.getMessage();
//                      showError(msg, e);
//                  }
//              }
//          });
//      }
//  }
//  
//  private void showError(String msg, Throwable e) {
//      ErrorDialog.openError(
//              activeEditorPart.getSite().getShell(),
//              "Error",
//              null,
//              new Status(IStatus.ERROR, Activator.getPluginId(), IStatus.ERROR, msg, e));
//  }
}
