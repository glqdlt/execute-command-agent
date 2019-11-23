package com.glqdlt.pm6.security.key;

import javax.crypto.spec.SecretKeySpec;

/**
 * Date 2019-11-23
 *
 * @author glqdlt
 */
public class AESAccessSecurityKey implements AlgistmAccessSecurityKey {
    private final SecretKeySpec secretKeySpec;
    private final String secretKey;

    public AESAccessSecurityKey(SecretKeySpec secretKeySpec, String secretKey) {
        this.secretKeySpec = secretKeySpec;
        this.secretKey = secretKey;
    }

    public AESAccessSecurityKey(String secretKey) {
        this.secretKey = secretKey;
        this.secretKeySpec = new SecretKeySpec(secretKey.getBytes(), "AES");
    }

    @Override
    final public SecretKeySpec getKeySpec() {
        return secretKeySpec;
    }

    @Override
    final public String getSecretKey() {
        return secretKey;
    }
}
