package MainItems;

/**
 * This is the place for the program to storage info
 */
public class Info {
    private static String version;
    private static String gppPath;
    public static String getVersion(){
        return version;
    }
    public static void setVersion(String nversion){
        version = nversion;
    }
    public static String getGppPath(){
        return gppPath;
    }
    public static void setGppPath(String nversion){
        gppPath = nversion;
    }
}
