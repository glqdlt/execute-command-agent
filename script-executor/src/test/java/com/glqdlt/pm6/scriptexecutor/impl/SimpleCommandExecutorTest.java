package com.glqdlt.pm6.scriptexecutor.impl;

import com.glqdlt.pm6.scriptexecutor.api.ProcessExecutor;
import org.junit.Assert;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class SimpleCommandExecutorTest {
    @Test
    public void simpleCommand() throws IOException {
        try (OutputStream outputStream = new ByteArrayOutputStream(1024);) {
            ProcessExecutor processExecutor = new SimpleCommandExecutor("echo 123", outputStream);
            processExecutor.execute();
            Assert.assertTrue(outputStream.toString().startsWith("123"));
        }
    }
}