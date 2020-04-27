package org.example.io;

import org.example.logicAndClasses.ComponentCollection;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

//Writes components to file using the .jobj format

public class WriteComponentsToFile extends Writer{
    ComponentCollection componentCollection = new ComponentCollection();
    Path path = Paths.get("components.jobj");

    public WriteComponentsToFile() throws IOException {
        try (OutputStream os = Files.newOutputStream(path);
            ObjectOutputStream out = new ObjectOutputStream(os))
        {
            out.writeObject(componentCollection);
        }
        catch(IOException ioe){
            throw new IOException("Something wrong with writing component to file!");
        }
    }
}