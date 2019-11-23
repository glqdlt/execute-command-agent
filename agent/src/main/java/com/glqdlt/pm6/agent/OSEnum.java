package com.glqdlt.pm6.agent;

/**
 * Date 2019-11-23
 *
 * @author glqdlt
 */
public enum OSEnum implements OS{
    WINDOW,
    LINUX;

    public String getOSName() {
        return name();
    }

    public Integer getOSCode() {
        return ordinal();
    }
}
