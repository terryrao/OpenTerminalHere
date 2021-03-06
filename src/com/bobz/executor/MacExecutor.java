package com.bobz.executor;

/**
 * Author: BobZhao
 * Date:   12/2/15 18:42
 * Description: command executor for Mac Platform
 */
public class MacExecutor extends CommandExecutor {

    private static final String MAC_TERMINAL = "/Applications/Utilities/Terminal.app/Contents/MacOS/Terminal";
    private static final String ITERM        = "/Applications/iTerm.app/Contents/MacOS/iTerm";

    public MacExecutor(String targetPath) {
        setTargetPath(targetPath);
    }

    @Override
    public String getTerminalPath() {

        if (isTerminalInstalled(ITERM)) {
            return ITERM;
        }

        return MAC_TERMINAL;
    }

    @Override
    Command buildCommand() {
        String terminalPath = this.getTerminalPath();
        String[] cmdArr = {terminalPath, getTargetPath()};

        return new Command(cmdArr);
    }




}
