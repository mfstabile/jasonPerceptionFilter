package net.sourceforge.jasonide.editors.cbg.prefs;

import net.sourceforge.jasonide.Activator;
import net.sourceforge.jasonide.editors.cbg.ColoringSourceViewerConfiguration;
import net.sourceforge.jasonide.editors.cbg.rules.ColorManager;

import org.eclipse.core.runtime.preferences.AbstractPreferenceInitializer;
import org.eclipse.jface.preference.IPreferenceStore;

public class PreferenceInitializer extends AbstractPreferenceInitializer {

    public PreferenceInitializer() {
        super();
    }

    public void initializeDefaultPreferences() {
        IPreferenceStore store = Activator.getDefault().getPreferenceStore();
        ColorManager.initDefaultColors(store);
        store.setDefault(ColoringSourceViewerConfiguration.SPACES_FOR_TABS, false);
        store.setDefault(ColoringSourceViewerConfiguration.PREFERENCE_TAB_WIDTH, 4);
    }

}
