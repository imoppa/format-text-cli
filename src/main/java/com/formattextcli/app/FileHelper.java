package com.formattextcli.app;

import java.io.*;
import java.net.URI;
import java.nio.file.Path;

public class FileHelper {
    private File _file;

    public FileHelper(String fileDir) {
        Path filePath = Path.of(fileDir);
        this._file = filePath.toFile();
    }

    public boolean exists() {
        return this._file.exists();
    }

    public BufferedReader read() throws FileNotFoundException {
        InputStream inputFileStream = new BufferedInputStream(new FileInputStream(this._file));
        return new BufferedReader(new InputStreamReader(inputFileStream));
    }
}