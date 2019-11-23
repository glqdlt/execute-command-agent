package com.glqdlt.pm6.scriptexecutor;

import org.apache.commons.exec.CommandLine;
import org.apache.commons.exec.DefaultExecutor;
import org.apache.commons.exec.Executor;
import org.apache.commons.exec.PumpStreamHandler;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;

/**
 * Date 2019-11-23
 *
 * @author glqdlt
 */
public abstract class ScriptExecutor {

    /**
     *
     * @return
     * script File Path
     *      * example ) "c:/Users/some_script.bat"
     */
    public abstract String getScriptPath();

    /**
     *
     * @return
     * script output console out stream.
     */
    public abstract OutputStream getOutputStream();

    public void execute() throws IOException {
        File file = new File(getScriptPath());
        CommandLine command = CommandLine.parse(file.getAbsolutePath());
        Executor executor = new DefaultExecutor();
        PumpStreamHandler pumpStreamHandler = new PumpStreamHandler(getOutputStream());
        executor.setStreamHandler(pumpStreamHandler);
        executor.execute(command);
    }
}
