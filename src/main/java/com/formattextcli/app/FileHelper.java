package com.formattextcli.app;

import java.io.*;
import java.net.URI;
import java.nio.file.Path;

public class FileHelper {
    public static BufferedReader read(Path filePath) throws IOException {
        URI uri = filePath.toUri();
        File inputFile = new File(uri);
        InputStream inputFileStream = new BufferedInputStream(new FileInputStream(inputFile));
        return new BufferedReader(new InputStreamReader(inputFileStream));
    }
}