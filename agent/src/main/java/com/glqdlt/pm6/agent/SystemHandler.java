package com.glqdlt.pm6.agent;

import java.io.IOException;
import java.io.OutputStream;

/**
 * Date 2019-11-23
 *
 * @author glqdlt
 */
public interface SystemHandler {
    void shutdown(Integer second, OutputStream outputStream) throws IOException;
}
