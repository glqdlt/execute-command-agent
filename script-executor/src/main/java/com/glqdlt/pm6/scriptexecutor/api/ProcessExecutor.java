package com.glqdlt.pm6.scriptexecutor.api;

import java.io.IOException;
import java.io.OutputStream;

/**
 * Date 2019-11-23
 *
 * @author glqdlt
 */
public interface ProcessExecutor {
    /**
     * @return script output console out stream.
     */
    OutputStream getOutputStream();

    void execute() throws IOException;
}