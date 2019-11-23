package com.glqdlt.pm6.scriptexecutor.impl;

import com.glqdlt.pm6.scriptexecutor.api.CheckSystemOSName;
import com.glqdlt.pm6.scriptexecutor.api.ProcessExecutor;
import com.glqdlt.pm6.scriptexecutor.impl.ScriptFileExecutor;
import org.junit.Assert;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URL;

public class ScriptFileExecutorTest {
    private final CheckSystemOSName checkSystemOSName = () -> System.getProperty("os.name");
    private final boolean checkWindow = checkSystemOSName.isWindow();

    @Test
    public void simpleExecuteScript() throws IOException {
        try (final OutputStream outputStream = new ByteArrayOutputStream(1024)) {
            ProcessExecutor executor = new ScriptFileExecutor() {
                @Override
                public String getScriptPath() {
                    final String scriptName;
                    if (checkWindow) {
                        scriptName = "test_script.bat";
                    } else {
                        scriptName = "test_script.sh";
                    }
                    final URL script = ClassLoader.getSystemResource(scriptName);
                    return new File(script.getPath()).getAbsolutePath();
                }

                @Override
                public OutputStream getOutputStream() {
                    return outputStream;
                }
            };
            executor.execute();
            String consoleOutput = outputStream.toString();
            if (checkWindow) {
                Assert.assertTrue(consoleOutput.contains("Active code page: 65001"));
            }
            Assert.assertTrue(consoleOutput.contains("echo \"hello\""));
        }
    }

}