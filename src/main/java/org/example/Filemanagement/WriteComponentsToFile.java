package org.example.Filemanagement;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class WriteComponentsToFile {

    public void save(List<?> objects, Path file) throws IOException {
        Files.write(filePath, objects.toString().getBytes());
    }
}