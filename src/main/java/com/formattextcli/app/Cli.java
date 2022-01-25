package com.formattextcli.app;

import java.io.*;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
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
        try {
            URI uri = filePath.toUri();
            ArrayList<Line> formattedLines = new ArrayList();

            File inputFile = new File(uri);
            InputStream inputFileStream = new BufferedInputStream(new FileInputStream(inputFile));
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputFileStream));

//            BufferedReader reader = FileHelper.read(filePath);
            String line = "";

            while (line != null) {
                line = reader.readLine();

                if (line != null) {
                    line = line.replaceAll("( +)", " ").trim();

                    // if the file read line is empty, that means it is a line break here
                    if (line.isEmpty()) {
                        // previous line has length, then add an empty line
                        Line currentLine = formattedLines.get(formattedLines.size()-1);
                        if (currentLine.lineText.length() != 0) {
                            Line newLine = new Line(true);
                            newLine.addText("");
                            formattedLines.add(newLine);
                        }
                    } else {
                        if (formattedLines.size() == 0) {
                            formattedLines.add(new Line());
                        }
                        Arrays.stream(line.split(" ")).forEach(s -> {
                            Line currentLine = formattedLines.get(formattedLines.size()-1);
                            if (currentLine.checkAddCapacity(s)) {
                                currentLine.addText(s);
                                formattedLines.set(formattedLines.size()-1, currentLine);
                            } else {
                                Line newLine = new Line();
                                newLine.addText(s);
                                formattedLines.add(newLine);
                            }
                        });
                    }
                }
            }

            for (int j = 0; j < formattedLines.size(); j++) {
                Line l = formattedLines.get(j);
                l.printLine();
            }
        } catch (Exception e) {
            System.err.println("Something went wrong!");
            System.err.println(e);
        }
    }
}