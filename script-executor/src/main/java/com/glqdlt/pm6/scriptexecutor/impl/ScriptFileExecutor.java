package com.glqdlt.pm6.scriptexecutor.impl;

import java.io.File;

/**
 * Date 2019-11-23
 *
 * @author glqdlt
 */
public abstract class ScriptFileExecutor extends CommandExecutor {
    /**
     * @return script File Path
     * * example ) "c:/Users/some_script.bat"
     */
    public abstract String getScriptPath();

    @Override
    final protected String getCommand() {
        File file = new File(getScriptPath());
        return file.getAbsolutePath();
    }

}
