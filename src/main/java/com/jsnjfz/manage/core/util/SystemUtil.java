package com.jsnjfz.manage.core.util;

/**
 * @author wang
 * @date 2024/2/3 17:21
 */
public class SystemUtil {

    private static String getOsName() {
        return System.getProperty("os.name");
    }

    public static boolean isWindows() {
        return getOsName().startsWith("Windows");
    }
}
