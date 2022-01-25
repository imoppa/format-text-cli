package com.formattextcli.app;

import java.util.Arrays;
import java.util.List;

/**
 * FORMAT TEXT CLI APP Class
 *
 */
public class App
{
    public static void main( String[] args )
    {
        Cli cli = new Cli();
        cli.start(args);
    }
}