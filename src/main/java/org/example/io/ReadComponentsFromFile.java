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

    public ComponentCollection ReadComponentsFromFile() throws IOException, ClassNotFoundException {
        try(InputStream in = Files.newInputStream(path);
            ObjectInputStream oin = new ObjectInputStream(in)){
            List<Component> components = (ArrayList<Component>) oin.readObject();

            ComponentCollection inComponents = new ComponentCollection();

            for(Component c : components){
                switch (c.getType()){
                    case "Cabinet":
                        Cabinet cabinet = (Cabinet) c;
                        inComponents.add(cabinet);
                        break;
                    case "CPU":
                        CPU cpu = (CPU) c;
                        inComponents.add(cpu);
                        break;
                    case "Fan":
                        Fan fan = (Fan) c;
                        inComponents.add(fan);
                        break;
                    case "GraphicCard":
                        GraphicCard graphicCard = (GraphicCard) c;
                        inComponents.add(graphicCard);
                        break;
                    case "Keyboard":
                        Keyboard keyboard = (Keyboard) c;
                        inComponents.add(keyboard);
                        break;
                    case "Monitor":
                        Monitor monitor = (Monitor) c;
                        inComponents.add(monitor);
                        break;
                    case "Mouse":
                        Mouse mouse = (Mouse) c;
                        inComponents.add(mouse);
                        break;
                    case "PowerSupply":
                        PowerSupply powerSupply = (PowerSupply) c;
                        inComponents.add(powerSupply);
                        break;
                    case "RAM":
                        RAM ram = (RAM) c;
                        inComponents.add(ram);
                        break;
                    case "Storage":
                        Storage storage = (Storage) c;
                        inComponents.add(storage);
                        break;
                }
                //inComponents.add(c);
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
