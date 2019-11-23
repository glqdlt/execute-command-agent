package com.glqdlt.pm6.security.matcher;

import com.glqdlt.pm6.security.key.AlgistmAccessSecurityKey;

import javax.crypto.spec.SecretKeySpec;

/**
 * Date 2019-11-23
 *
 * @author glqdlt
 */
public interface AlgositmSecurityTokenMatcher<K extends AlgistmAccessSecurityKey> extends SecurityTokenMatcher<K> {

    SecretKeySpec getKeySpec();
}
