package org.example.Filemanagement;

import javafx.scene.shape.Path;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

public class WriteComponentsToFile {

    public void save(List<?> objects, Path file) throws IOException {
        Files.write(filePath, objects.toString().getBytes());
    }
}