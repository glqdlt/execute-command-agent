package com.glqdlt.pm6.agent;

import com.glqdlt.pm6.scriptexecutor.api.CheckSystemOSName;

/**
 * Date 2019-11-23
 *
 * @author glqdlt
 */
public class OSChecker implements CheckSystemOSName {
    private static final OSChecker INS = new OSChecker();

    public static boolean checkWindow() {
        return INS.isWindow();
    }

    @Override
    public String getOsName() {
        return System.getProperty("os.name");
    }
}
