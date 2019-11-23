package com.glqdlt.pm6.scriptexecutor.impl;

import com.glqdlt.pm6.scriptexecutor.api.ProcessExecutor;
import org.apache.commons.exec.CommandLine;
import org.apache.commons.exec.DefaultExecutor;
import org.apache.commons.exec.Executor;
import org.apache.commons.exec.PumpStreamHandler;

import java.io.IOException;

/**
 * Date 2019-11-23
 *
 * @author glqdlt
 */
public abstract class CommandExecutor implements ProcessExecutor {
    protected abstract String getCommand();

    public void execute() throws IOException {
        CommandLine command = CommandLine.parse(getCommand());
        Executor executor = new DefaultExecutor();
        PumpStreamHandler pumpStreamHandler = new PumpStreamHandler(getOutputStream());
        executor.setStreamHandler(pumpStreamHandler);
        executor.execute(command);
    }
}
