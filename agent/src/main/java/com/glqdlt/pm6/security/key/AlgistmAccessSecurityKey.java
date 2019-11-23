package com.glqdlt.pm6.security.key;

import com.glqdlt.pm6.security.key.AccessSecurityKey;

import javax.crypto.spec.SecretKeySpec;

/**
 * Date 2019-11-23
 *
 * @author glqdlt
 */
public interface AlgistmAccessSecurityKey extends AccessSecurityKey {
    SecretKeySpec getKeySpec();
}
