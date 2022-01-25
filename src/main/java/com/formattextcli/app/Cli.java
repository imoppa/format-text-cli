package com.formattextcli.app;

import java.util.Arrays;
import java.util.List;

public class Cli {
    // TODO: read this from config file
    private String _version = "1.0.0";

    public Cli() { }

    public void start(String[] _args) {
        List<String> args = Arrays.asList(_args);

        while (!args.isEmpty()) {
            String firstCommand = args.get(0);

            if (firstCommand.equals("-version") || firstCommand.equals("-v")) {
                System.out.println("Version: " + this._version);
                return;
            }

            return;
        }
    }
}