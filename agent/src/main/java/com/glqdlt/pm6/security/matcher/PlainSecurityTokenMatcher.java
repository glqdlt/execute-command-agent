package com.glqdlt.pm6.security.matcher;

import com.glqdlt.pm6.security.key.AccessSecurityKey;

/**
 * Date 2019-11-23
 *
 * @author glqdlt
 */
public class PlainSecurityTokenMatcher implements SecurityTokenMatcher {
    private final AccessSecurityKey accessSecurityKey;

    public PlainSecurityTokenMatcher(String simpleKey) {
        this.accessSecurityKey = new AccessSecurityKey() {
            @Override
            public String getSecretKey() {
                return simpleKey;
            }
        };
    }

    public PlainSecurityTokenMatcher(AccessSecurityKey accessSecurityKey) {
        this.accessSecurityKey = accessSecurityKey;
    }

    @Override
    public boolean match(String encryptString) {
        return encryptString.equals(getSecretKey().getSecretKey());
    }

    @Override
    public AccessSecurityKey getSecretKey() {
        return this.accessSecurityKey;
    }

}
