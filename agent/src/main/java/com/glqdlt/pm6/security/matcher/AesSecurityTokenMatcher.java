package com.glqdlt.pm6.security.matcher;

import com.glqdlt.pm6.security.key.AESAccessSecurityKey;

import javax.crypto.spec.SecretKeySpec;

/**
 * Date 2019-11-23
 *
 * @author glqdlt
 */
public class AesSecurityTokenMatcher implements AlgositmSecurityTokenMatcher<AESAccessSecurityKey> {

    private final SecretKeySpec keySpec;
    private final AESAccessSecurityKey accessSecurityKey;

    public AesSecurityTokenMatcher(AESAccessSecurityKey accessSecurityKey) {
        this.accessSecurityKey = accessSecurityKey;
        this.keySpec = new SecretKeySpec(getSecretKey().getSecretKey().getBytes(), "AES");
    }

    @Override
    public boolean match(String encryptString) {
//        FIXME fill body
        return false;
    }

    @Override
    public AESAccessSecurityKey getSecretKey() {
        return this.accessSecurityKey;
    }

    @Override
    public SecretKeySpec getKeySpec() {
        return this.keySpec;
    }
}
