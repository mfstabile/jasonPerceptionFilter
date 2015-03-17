package owl2mas.util;

import java.io.File;
import java.net.URI;

public class OWL2MASCommon {
    /**
     * Now works for both linux and windows
     * @param suffix
     * @return
     */
    public static URI getRelativeLocalURI(String suffix){
        return URI.create("file:///" + getCurrentDir().replace("\\", "/") + "/" + suffix);
    }
    
    
    public static String getCurrentDir() {
        File dir1 = new File(".");
        String strCurrentDir = "";
        try {
            strCurrentDir = dir1.getCanonicalPath();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return strCurrentDir;
    }
}
