package com.formattextcli.app;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CliTest {
    private final ByteArrayOutputStream out = new ByteArrayOutputStream();
    private final ByteArrayOutputStream err = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private final PrintStream originalErr = System.err;

    @TempDir
    Path tempDir;

    Cli cli;

    @BeforeEach
    public void setStreams() {
        System.setOut(new PrintStream(out));
        System.setErr(new PrintStream(err));
    }

    @AfterEach
    public void restoreInitialStreams() {
        System.setOut(originalOut);
        System.setErr(originalErr);
    }

    @BeforeEach
    void setUpCli() {
        cli = new Cli();
    }

    @Test
    void applicationStarts() {
        cli.start(new String[] {});
        String banner = "\n" +
                "\n" +
                " ______                         _     _______        _      _____ _ _ \n" +
                "|  ____|                       | |   |__   __|      | |    / ____| (_)\n" +
                "| |__ ___  _ __ _ __ ___   __ _| |_     | | _____  _| |_  | |    | |_ \n" +
                "|  __/ _ \\| '__| '_ ` _ \\ / _` | __|    | |/ _ \\ \\/ / __| | |    | | |\n" +
                "| | | (_) | |  | | | | | | (_| | |_     | |  __/>  <| |_  | |____| | |\n" +
                "|_|  \\___/|_|  |_| |_| |_|\\__,_|\\__|    |_|\\___/_/\\_\\\\__|  \\_____|_|_|\n" +
                "                                                                      \n" +
                "                                                                      \n";

        assertEquals(banner.trim(), out.toString().trim());
    }

    @Test
    void runsVersionCommand() {
        cli.start(new String[] { "-version" });
        assertEquals("Version: 1.0.0", out.toString().trim());
    }

    @Test
    void runsVersionCommandShortened() {
        cli.start(new String[] { "-v" });
        assertEquals("Version: 1.0.0", out.toString().trim());
    }

    @Test
    void runsDefaultCommandToParseFileIntoLines() throws IOException {
        final Path tempFile = Files.createFile(tempDir.resolve("myfile.txt"));
        Files.writeString(tempFile, "some        stringaerawerawrfasdfsafsdafdsafwemroqweroiqwerniowen weoirqoweijr reqwirojewor qweorijq\n        nreally long\n\n\n\n\n\n\n\n\nntext");
        cli.start(new String[] { tempFile.toString() });
        assertEquals("some stringaerawerawrfasdfsafsdafdsafwemroqweroiqwerniowen weoirqoweijr\nreqwirojewor qweorijq nreally long\n\nntext", out.toString().trim());
    }

    @Test
    void runsDefaultCommandsToParseFileIntoLinesError() throws IOException {
        final Path tempFile = Files.createFile(tempDir.resolve("myfile.txt"));
        Files.writeString(tempFile, "        \n \n \n \n                \n \n \n \n         \n  \n \n \n");
        cli.start(new String[] { tempFile.toString() });
        assertEquals("", out.toString().trim());
    }
}
