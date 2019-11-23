package com.glqdlt.pm6.security.matcher;

import com.glqdlt.pm6.security.key.AccessSecurityKey;

/**
 * Date 2019-11-23
 *
 * @author glqdlt
 */
public interface SecurityTokenMatcher<K extends AccessSecurityKey> {

    boolean match(String encryptString);

    K getSecretKey();

}
