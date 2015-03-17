package net.sourceforge.jasonide.wizards;

import net.sourceforge.jasonide.core.MAS2JHandler;

import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.Path;
import org.eclipse.jdt.core.IPackageFragmentRoot;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ITreeSelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.ui.dialogs.WizardNewFileCreationPage;

/**
 * The "New" wizard page allows setting the container for the new file as well
 * as the file name. The page will only accept file name without the extension
 * OR with the extension that matches the expected one (asl).
 */
public class NewAgentWizardPage extends WizardNewFileCreationPage {

    /**
     * Constructor for SampleNewWizardPage.
     * @param pageName
     */
    public NewAgentWizardPage(ISelection selection) {
        super("New AgentSpeak File", StructuredSelection.EMPTY);
        if (selection instanceof ITreeSelection) {
            ITreeSelection ts = (ITreeSelection)selection;
            
            Object firstElement = ts.getFirstElement();
            if (firstElement != null) {
                if (firstElement instanceof IPackageFragmentRoot) {
                    IPackageFragmentRoot pfr = (IPackageFragmentRoot)firstElement;
                    setContainerFullPath(ResourcesPlugin.getWorkspace().getRoot().findMember(new Path(pfr.getPath().toFile().getPath())).getFullPath());
                }
            }
        }
        
        setTitle("New AgentSpeak File");
        setDescription("This wizard creates a new AgentSpeak file.");
        this.setFileName("new_agent" + MAS2JHandler.AS_EXT);
    }

    public String getContainerName() {
        return this.getContainerFullPath().toString();
    }
}
