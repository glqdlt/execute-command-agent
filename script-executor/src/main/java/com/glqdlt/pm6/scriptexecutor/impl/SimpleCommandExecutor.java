package com.glqdlt.pm6.scriptexecutor.impl;

import java.io.OutputStream;

/**
 * Date 2019-11-23
 *
 * @author glqdlt
 */
public class SimpleCommandExecutor extends CommandExecutor {
    private String command;
    private OutputStream outputStream;

    public SimpleCommandExecutor(String command, OutputStream outputStream) {
        this.command = command;
        this.outputStream = outputStream;
    }

    @Override
    public String getCommand() {
        return command;
    }

    @Override
    public OutputStream getOutputStream() {
        return outputStream;
    }

}
