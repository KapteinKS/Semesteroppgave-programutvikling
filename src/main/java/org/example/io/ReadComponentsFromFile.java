package org.example.io;

import org.example.logicAndClasses.ComponentCollection;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


public class ReadComponentsFromFile extends Reader {
    Path path = Paths.get("components.jobj");

    public ReadComponentsFromFile() throws IOException, ClassNotFoundException {
        try(InputStream in = Files.newInputStream(path);
            ObjectInputStream oin = new ObjectInputStream(in)){
            ComponentCollection inComponents = (ComponentCollection) oin.readObject();
        }
        catch (IOException ioe){
            throw new IOException("Something wrong with reading from file!");
        }
        catch (ClassNotFoundException cnfe){
            throw new ClassNotFoundException("File reader couldn't find class for object");
        }
    }
}
