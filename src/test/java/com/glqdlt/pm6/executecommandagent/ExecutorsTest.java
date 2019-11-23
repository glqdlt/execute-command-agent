package com.glqdlt.pm6.executecommandagent;


import org.junit.Assert;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URL;

public class ExecutorsTest {
    private final CheckSystemOSName checkSystemOSName = () -> System.getProperty("os.name");
    private final boolean checkWindow = checkSystemOSName.isWindow();

    @Test
    public void simpleExecuteScript() throws IOException {
        try (final OutputStream outputStream = new ByteArrayOutputStream(1024)) {
            ScriptExecutor executor = new ScriptExecutor() {
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