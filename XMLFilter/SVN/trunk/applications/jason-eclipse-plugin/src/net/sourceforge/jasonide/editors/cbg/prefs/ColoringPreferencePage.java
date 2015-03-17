package net.sourceforge.jasonide.editors.cbg.prefs;

import net.sourceforge.jasonide.Activator;
import net.sourceforge.jasonide.editors.cbg.ColoringSourceViewerConfiguration;

import org.eclipse.jface.preference.BooleanFieldEditor;
import org.eclipse.jface.preference.FieldEditorPreferencePage;
import org.eclipse.jface.preference.IntegerFieldEditor;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;

public class ColoringPreferencePage extends FieldEditorPreferencePage implements IWorkbenchPreferencePage {

    public ColoringPreferencePage() {
        super(FieldEditorPreferencePage.GRID);
        setPreferenceStore(Activator.getDefault().getPreferenceStore());
    }

    protected void createFieldEditors() {
        Composite p = getFieldEditorParent();
        addField(new BooleanFieldEditor(ColoringSourceViewerConfiguration.SPACES_FOR_TABS, "&Insert spaces for tabs", p));
        addField(new IntegerFieldEditor(ColoringSourceViewerConfiguration.PREFERENCE_TAB_WIDTH, "&Number of spaces representing a tab:", p));
    }

    public void init(IWorkbench workbench) {
        if (workbench == null) {
            //ignore
        }
    }

}
