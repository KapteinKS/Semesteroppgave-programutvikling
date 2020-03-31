package org.example.Filemanagement;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class WriteComponentsToFile {
    String filePath = "";
    public void save(List<?> objects, Path file) throws IOException {
        Files.write(Paths.get(filePath), objects.toString().getBytes());
    }
}