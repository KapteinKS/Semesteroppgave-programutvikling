package org.example.io;

import org.example.Deeper.ComponentCollection;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;


public class WriteComponentsToFile extends Writer{
    public static void saveComponents(ComponentCollection compCol, Path path) throws IOException{
            Files.write(path,compCol.toString().getBytes());
    }
}