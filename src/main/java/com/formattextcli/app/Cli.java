package com.formattextcli.app;

import java.io.*;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;

public class Cli {
    // TODO: read this from config file
    private String _version = "1.0.0";

    public Cli() { }

    public void start(String[] _args) {
        List<String> args = Arrays.asList(_args);

        if (args.isEmpty()) {
            System.out.println("Do you need some help to learn how to use this CLI tool?");
            return;
        }

        while (!args.isEmpty()) {
            String firstCommand = args.get(0).toLowerCase();

            switch (firstCommand) {
                case "-v":
                case "-version": {
                    this._handleVersionCommand();
                    return;
                }
                default: {
                    Path filePath = Path.of(firstCommand);
                    if (Files.exists(filePath)) {
                        this._handleDefaultCommand(filePath);
                        return;
                    }

                    System.out.println("It seems that it is an incorrect file path");
                    return;
                }
            }
        }
    }

    private void _handleVersionCommand() {
        System.out.println("Version: " + this._version);
    }

    private void _handleDefaultCommand(Path filePath) {
        URI uri = filePath.toUri();

        try {
            File inputFile = new File(uri);
            InputStream inputFileStream = new BufferedInputStream(new FileInputStream(inputFile));
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputFileStream));

            String line = reader.readLine();

            long linesWritten = 0;
            while (line != null) {
                line = reader.readLine();
                System.out.println(line);
                linesWritten++;
            }
        } catch (Exception e) {
            System.err.println("Something went wrong!");
        }
    }
}