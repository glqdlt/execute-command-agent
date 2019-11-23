package com.glqdlt.pm6.agent;

import java.util.concurrent.TimeUnit;

/**
 * Date 2019-11-23
 *
 * @author glqdlt
 */
public abstract class ShutdownCommand implements ShellCommand {
    public abstract String getShutdownCommand();

    public abstract String getShutdownCommand(TimeUnit unit, Integer time);

    public static ShutdownCommand builder() {
        if (OSChecker.checkWindow()) {
            return new ShutdownWindow();
        } else {
            return new ShutdownLinux();
        }
    }

    private static class ShutdownLinux extends ShutdownCommand {

        public String getShellCommand() {
            return getShutdownCommand();
        }

        public String getShutdownCommand() {
            return getShutdownCommand(TimeUnit.SECONDS, 20);
        }

        public String getShutdownCommand(TimeUnit unit, Integer time) {
            return "shutdown -P " + unit.toSeconds(time);
        }

        public OS getOsType() {
            return OSEnum.LINUX;
        }
    }

    private static class ShutdownWindow extends ShutdownCommand {

        public String getShellCommand() {
            return getShutdownCommand();
        }

        public String getShutdownCommand() {
            return getShutdownCommand(TimeUnit.SECONDS, 20);
        }

        public String getShutdownCommand(TimeUnit unit, Integer time) {
            return "shutdown -s -t " + unit.toSeconds(time);
        }

        public OS getOsType() {
            return OSEnum.LINUX;
        }
    }

}
