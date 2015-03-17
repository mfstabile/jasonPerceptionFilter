package jasonide.ui.wizards;

import java.io.IOException;

import jasonide.core.PluginTemplates;
import jasonide.core.Utils;
import jasonide.ui.ErrorDialog;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IWorkbench;

public class NewInternalActionWizard extends Wizard implements INewWizard {
	private NewInternalActionWizardPage page;
	private IStructuredSelection selection;
	private IWorkbench workbench;
	
	public NewInternalActionWizard() {
		super();
		setWindowTitle("New Jason Internal Action");
	}
	
	@Override
	public void init(IWorkbench workbench, IStructuredSelection selection) {
		this.workbench = workbench;
		this.selection = selection;
	}

	@Override
	public boolean performFinish() {
		try {
			page.createType(null);
			IResource resource = page.getModifiedResource();
			
			if (resource != null) {
				try {
					Utils.saveFile(resource.getLocation().toString(), PluginTemplates.getContentInternalAction(resource.getProject().getName(), page.getTypeName(), page.getPackageText(), page.getSuperClass()), false);
				} catch (IOException e) {
					e.printStackTrace();
				}
				Utils.selectAndReveal(getShell(), resource);
				Utils.openResource(getShell(), (IFile) resource);
			}
		} catch (CoreException e) {
			e.printStackTrace();
			ErrorDialog.open(e);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return true;
	}

	/**
     * Adding the page to the wizard.
     */
    public void addPages() {
    	page = new NewInternalActionWizardPage(true, "New internal action", selection);
    	page.init(selection);
    	addPage(page);
    }
}
