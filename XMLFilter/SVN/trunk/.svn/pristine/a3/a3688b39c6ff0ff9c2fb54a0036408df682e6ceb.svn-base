package net.sourceforge.jasonide.wizards;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.sourceforge.jasonide.core.JasonInternalInfras;
import net.sourceforge.jasonide.core.MAS2JHandler;

import org.eclipse.jface.dialogs.IDialogPage;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.dialogs.WizardNewProjectCreationPage;

/**
 * The "New" wizard page allows setting the container for the new file as well
 * as the file name. The page will only accept file name without the extension
 * OR with the extension that matches the expected one (mas2j).
 */

public class NewJasonProjectWizardPage extends WizardNewProjectCreationPage {
    
    private Text environmentClassFileNameText;

    private Combo infraCombo;
    
    /**
     * Constructor for SampleNewWizardPage.
     */
    public NewJasonProjectWizardPage(ISelection selection) {
        super("wizardPage");
        setTitle("Jason Project Wizard");
        setDescription("This wizard creates a new Jason project.");
    }
    
    protected boolean validatePage() {
        return super.validatePage() && (dialogChanged());
    }

    public void setVisible(boolean visible) {
        super.setVisible(true);
    }
        
    /**
     * @see IDialogPage#createControl(Composite)
     */
    public void createControl(Composite parent) {
        super.createControl(parent);
        
        Composite projectComposite = (Composite)getControl();   
        Composite container = new Composite(projectComposite, SWT.NULL);
        GridLayout layout = new GridLayout();
        container.setLayout(layout);
        layout.verticalSpacing = 5;
                
        Group jasonInfo = new Group(container, SWT.NULL);
        jasonInfo.setText("Mas2J Options");
        GridLayout gridLayout = new GridLayout();
        gridLayout.numColumns = 2;
        jasonInfo.setLayout(gridLayout);
        GridData gridData = new GridData(GridData.HORIZONTAL_ALIGN_FILL);
        gridData.horizontalSpan = 2;
        jasonInfo.setLayoutData(gridData);
        
        // Environment Class file name 
        Label label = new Label(jasonInfo, SWT.NULL);
        label.setText("&Environment class:");

        environmentClassFileNameText = new Text(jasonInfo, SWT.BORDER | SWT.SINGLE);
        GridData gd = new GridData(GridData.FILL_HORIZONTAL);
        environmentClassFileNameText.setLayoutData(gd);
        environmentClassFileNameText.addModifyListener(new ModifyListener() {
            public void modifyText(ModifyEvent e) {
                dialogChanged();
            }
        });

        // Infrastructure
        label = new Label(jasonInfo, SWT.NULL);
        label.setText("&Infrastructure:");

        infraCombo = new Combo(jasonInfo, SWT.BORDER | SWT.SINGLE | SWT.READ_ONLY);
        List infras = MAS2JHandler.getUserInfraStructures();
        for (int i = 0; i < infras.size(); i++) {
            infraCombo.add((String)infras.get(i));
        }
        
        infraCombo.setText(JasonInternalInfras.CENTRALISED); // set as default
        
        infraCombo.addModifyListener(new ModifyListener() {
            public void modifyText(ModifyEvent e) {
                dialogChanged();
            }
        });
        
        gd = new GridData(GridData.FILL_HORIZONTAL);
        infraCombo.setLayoutData(gd);
        
        dialogChanged();
        setControl(container);
    }

    /**
     * Ensures that both text fields are set.
     */
    private boolean dialogChanged() {
        
        String environmentClassFileName = getEnvironmentClassFileName();
        String infraType = infraCombo.getText();

        // project name: required
        if (getProjectName().equals("")) {
            updateStatus("Project name must be specified");
            return false;
        }
        
        // environment class: not required
        if (environmentClassFileName.length() > 0) {
            if (!isValidClassName(environmentClassFileName)) {
                updateStatus("Environment class must be valid");
                return false;
            }
        }
        
        // infrastructure type: required
        if (infraType.length() == 0) {
            updateStatus("Choose the infrastructure");
            return false;
        }
        
        updateStatus(null);
        return true;
    }

    private boolean isValidClassName(String className) {
        Pattern pat = Pattern.compile("([a-z]+.)*[A-Z]([a-zA-Z])*");  
        Matcher matcher = pat.matcher(className);   
        
        return matcher.matches(); 
    }
    
    private void updateStatus(String message) {
        setErrorMessage(message);
        setPageComplete(message == null);
    }
    
    public String getEnvironmentClassFileName() {
        return environmentClassFileNameText.getText();
    }
    
    public String getInfrastructure() {
        return infraCombo.getText();
    }
}
