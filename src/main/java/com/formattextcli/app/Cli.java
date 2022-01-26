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
                    this._handleDefaultCommand(firstCommand);
                    return;
                }
            }
        }
    }

    private void _handleVersionCommand() {
        System.out.println("Version: " + this._version);
    }

    private void _handleDefaultCommand(String filePath) {
        try {
            FileHelper fileHelper = new FileHelper(filePath);
            if (!fileHelper.exists()) {
                return;
            }

            ArrayList<Line> formattedLines = new ArrayList();
            BufferedReader reader = fileHelper.read();
            String lineFromFile = "";

            while (lineFromFile != null) {
                lineFromFile = reader.readLine();
                if (lineFromFile != null) {
                    // get rid of all the noise in the string
                    lineFromFile = lineFromFile.replaceAll("( +)", " ").trim();
                    this._formatLines(formattedLines, lineFromFile);
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

    private void _formatLines(ArrayList<Line> formattedLines, String lineFromFile) {
        if (lineFromFile.isEmpty()) {
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
            Arrays.stream(lineFromFile.split(" ")).forEach(s -> {
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