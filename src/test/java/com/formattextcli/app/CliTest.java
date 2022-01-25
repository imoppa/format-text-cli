package com.formattextcli.app;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CliTest {
    private final ByteArrayOutputStream out = new ByteArrayOutputStream();
    private final ByteArrayOutputStream err = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private final PrintStream originalErr = System.err;

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
}
