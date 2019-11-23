package com.glqdlt.pm6.agent;

import com.glqdlt.pm6.scriptexecutor.impl.CommandExecutor;
import com.glqdlt.pm6.scriptexecutor.impl.SimpleCommandExecutor;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.OutputStream;
import java.util.concurrent.TimeUnit;

/**
 * Date 2019-11-23
 *
 * @author glqdlt
 */
@Service
public class SimpleSystemHandler implements SystemHandler {
    public void shutdown(Integer second, OutputStream outputStream) throws IOException {
        ShutdownCommand shutdownCommand = ShutdownCommand.builder();
        String command = shutdownCommand.getShutdownCommand(TimeUnit.SECONDS, second);
        CommandExecutor commandExecutor = new SimpleCommandExecutor(command, outputStream);
        commandExecutor.execute();
    }
}
