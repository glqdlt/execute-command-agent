package com.glqdlt.pm6.scriptexecutor;

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
