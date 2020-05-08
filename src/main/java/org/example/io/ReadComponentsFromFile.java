package org.example.io;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.example.componentClasses.*;
import org.example.logicAndClasses.ComponentCollection;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;


public class ReadComponentsFromFile extends Reader {
    Path path = Paths.get("components.jobj");

    public ComponentCollection open() throws IOException, ClassNotFoundException {
        try(InputStream in = Files.newInputStream(path);
            ObjectInputStream oin = new ObjectInputStream(in)){
            List<Component> components = (ArrayList<Component>) oin.readObject();

            ComponentCollection inComponents = new ComponentCollection();

            for(Component c : components){
                inComponents.add(c);
            }
            return inComponents;
        }
        catch (IOException ioe){
            throw new IOException("Something wrong with reading from file!");
        }
        catch (ClassNotFoundException cnfe){
            throw new ClassNotFoundException("File reader couldn't find class for object");
        }
    }
}
