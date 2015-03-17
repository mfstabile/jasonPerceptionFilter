package net.sourceforge.jasonide;

import net.sourceforge.jasonide.core.JasonPluginConstants;
import net.sourceforge.jasonide.editors.cbg.ColoringEditorTools;
import net.sourceforge.jasonide.editors.cbg.rules.ColorManager;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.resource.ImageRegistry;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.editors.text.EditorsUI;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.eclipse.ui.texteditor.ChainedPreferenceStore;
import org.osgi.framework.BundleContext;

/**
 * The activator class controls the plug-in life cycle
 */
public class Activator extends AbstractUIPlugin {

    // The plug-in ID
    public static final String PLUGIN_ID = "net.sourceforge.jasonide";
    public static final String STATUS_CATEGORY_MODE = "net.sourceforge.jasonide.modeStatus";

    // The shared instance
    private static Activator plugin;
    
    // The @Jason configurations
    private static JasonPluginConstants jasonConfig = new JasonPluginConstants();
    
    private ColoringEditorTools editorTools;
    private ColorManager colorManager;
    private IPreferenceStore fCombinedPreferenceStore;
    
    /**
     * The constructor
     */
    public Activator() {
        plugin = this;
    }

    /*
     * (non-Javadoc)
     * @see org.eclipse.ui.plugin.AbstractUIPlugin#start(org.osgi.framework.BundleContext)
     */
    public void start(BundleContext context) throws Exception {
        super.start(context);
    }

    /*
     * (non-Javadoc)
     * @see org.eclipse.ui.plugin.AbstractUIPlugin#stop(org.osgi.framework.BundleContext)
     */
    public void stop(BundleContext context) throws Exception {
        plugin = null;
        super.stop(context);
    }

    /**
     * Returns the shared instance
     *
     * @return the shared instance
     */
    public static Activator getDefault() {
        return plugin;
    }

    /**
     * Returns an image descriptor for the image file at the given
     * plug-in relative path
     *
     * @param path the path
     * @return the image descriptor
     */
    public static ImageDescriptor getImageDescriptor(String path) {
        return imageDescriptorFromPlugin(PLUGIN_ID, path);
    }
    
    /**
     * Returns the Jason configuration.
     * @return JasonConfig
     */
    public static JasonPluginConstants getJasonConfig() {
        return jasonConfig; 
    }
    
    /**
     * Gets the plugin instance.
     * @return
     */
    public static Activator getPluginInstance() {
        return plugin;
    }
    
    public ColorManager getColorManager() {
        if (colorManager == null) {
            colorManager = new ColorManager(getPreferenceStore());
        }
        
        return colorManager;
    }
        
    public ColoringEditorTools getEditorTools() {
        if (editorTools == null) { 
            editorTools = new ColoringEditorTools();
        }
        
        return editorTools;
    }

    protected void initializeImageRegistry(ImageRegistry reg) {
        super.initializeImageRegistry(reg);
        reg.put("box", getImageDescriptor("boxIcon.gif").createImage());
    }

    public static Image getImage(String handle) {
        return getDefault().getImageRegistry().get(handle);
    }

    public static void log(String message, Throwable e) {
        getDefault().getLog().log(new Status(IStatus.ERROR, getPluginId(), IStatus.OK, message, e)); //$NON-NLS-1$
    }
    
    public static String getPluginId() {
        return PLUGIN_ID;
    }
    
    public IPreferenceStore getCombinedPreferenceStore() {
        if (fCombinedPreferenceStore == null) {
            IPreferenceStore generalTextStore= EditorsUI.getPreferenceStore(); 
            fCombinedPreferenceStore= new ChainedPreferenceStore(new IPreferenceStore[] { getPreferenceStore(), generalTextStore });
        }
        return fCombinedPreferenceStore;
    }
}
