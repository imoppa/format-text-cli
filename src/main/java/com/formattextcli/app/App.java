package com.formattextcli.app;

import java.util.Arrays;
import java.util.List;

/**
 * FORMAT TEXT CLI APP Class
 *
 */
public class App
{
    // TODO: read this from config file
    private static String version = "1.0.0";

    public static void main( String[] _args )
    {
        List<String> args = Arrays.asList(_args);

        while (!args.isEmpty()) {
            String firstCommand = args.get(0);

            if (firstCommand.equals("-version")) {
                System.out.println("Version: " + version);
                return;
            }

            return;
        }
    }
}
