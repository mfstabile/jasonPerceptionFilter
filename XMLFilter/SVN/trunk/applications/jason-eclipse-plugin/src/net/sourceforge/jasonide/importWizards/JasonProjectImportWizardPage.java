/*******************************************************************************
 * Copyright (c) 2006 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/
package net.sourceforge.jasonide.importWizards;

import net.sourceforge.jasonide.core.MAS2JHandler;
import net.sourceforge.jasonide.core.ProjectCreation;

import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

public class JasonProjectImportWizardPage extends WizardPage {
    
    private Text externalProjectText;
    private Text projectNameText;
    
    public JasonProjectImportWizardPage(String pageName) {
        super(pageName);
        setTitle(pageName);
        setDescription("Import a external Jason project into the workspace");
    }

    public void createControl(Composite parent) {
        Composite container = new Composite(parent, SWT.NULL);
        GridLayout layout = new GridLayout();
        container.setLayout(layout);
        layout.numColumns = 3;
        layout.verticalSpacing = 9;
        
        Label label = new Label(container, SWT.NULL);
        label.setText("&Archive file:");

        externalProjectText = new Text(container, SWT.BORDER | SWT.SINGLE);
        GridData gd = new GridData(GridData.FILL_HORIZONTAL);
        externalProjectText.setLayoutData(gd);

        Button button = new Button(container, SWT.PUSH);
        button.setText("Browse...");
        button.addSelectionListener(new SelectionAdapter() {
            public void widgetSelected(SelectionEvent e) {
                handleBrowseExternalProject();
            }
        });
        
        label = new Label(container, SWT.NULL);
        label.setText("&Project name:");

        projectNameText = new Text(container, SWT.BORDER | SWT.SINGLE);
        gd = new GridData(GridData.FILL_HORIZONTAL);
        projectNameText.setLayoutData(gd);
        
        setControl(container);
    }
    
    private void handleBrowseExternalProject() {
        FileDialog dialog = new FileDialog(getShell(), SWT.OPEN);
        dialog.setFilterExtensions(new String[] {"*.zip", "*.tar", "*.jar"});
        
        String result = dialog.open();
        if (result != null) {
            externalProjectText.setText(result);
            
            try {
                String name = new ProjectCreation(getShell()).getMas2jFileNameInArchiveFile(result);
                if (name.endsWith(MAS2JHandler.MAS2J_EXT)) {
                    name = name.replace(MAS2JHandler.MAS2J_EXT, "");
                }
                projectNameText.setText(name);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    
    public String getExternalProjectArchiveFilePath() {
        return externalProjectText.getText();
    }
    
    public String getProjectName() {
        return projectNameText.getText();
    }
}
