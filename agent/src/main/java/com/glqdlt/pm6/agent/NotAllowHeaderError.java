package com.glqdlt.pm6.agent;

/**
 * Date 2019-11-23
 *
 * @author glqdlt
 */
public class NotAllowHeaderError extends RuntimeException {
    public NotAllowHeaderError(String requestUrl, String remoteAddress) {
        super(String.format("Security Header is not matched. {REQUEST : %s, IP : %s}", requestUrl, remoteAddress));
    }
}
