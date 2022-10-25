package helpers;

import java.io.File;

public class Helpers {
    public static String getCurrentDir() {
        String current = System.getProperty("user.dir") + "/";
        return current;
    }

    // File.separator là ký tự phân cách thư mục máy tính
    public static String getCurrentDir2() {
        String current = System.getProperty("user.dir") + File.separator;
        return current;
    }
}
