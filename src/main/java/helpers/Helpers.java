package helpers;

import java.io.File;

public class Helpers {
    public static String getCurrentDir() {
        String current = System.getProperty("user.dir") + "/";
        return current;
    }

    public static String getCurrentDir2() {
        String current = System.getProperty("user.dir") + File.separator;
        return current;
    }
}
