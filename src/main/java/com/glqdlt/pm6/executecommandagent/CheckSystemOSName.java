package com.glqdlt.pm6.executecommandagent;

/**
 * Date 2019-11-23
 *
 * @author glqdlt
 */
public interface CheckSystemOSName {
    String getOsName();

    default boolean isWindow() {
        String os = getOsName().toLowerCase();
        return os.startsWith("window");
    }
}
