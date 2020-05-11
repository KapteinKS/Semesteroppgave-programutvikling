package org.example;

import javafx.concurrent.Task;
import org.example.componentClasses.Component;
import org.example.io.ReadOrderFromFile;
import org.example.logicAndClasses.ComponentCollection;
import org.example.logicAndClasses.User;
import org.example.logicAndClasses.UserCollection;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class ThreadHandler extends Task<String> {
    public ThreadHandler(){

    }
    protected String call() throws Exception {
       try {
           System.out.println("Thread going to sleep");
           Thread.sleep(3000);
           System.out.println("Thread awake");
           App.setUserCollection(openUsers());
           App.setComponentCollection(openComponents());
           App.setOrderCollection(ReadOrderFromFile.openOrder());
       } catch (InterruptedException ie){

       }
       return "";
    }
    public ComponentCollection openComponents() throws IOException, ClassNotFoundException {
        Path path = Paths.get("components.jobj");
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
    public static UserCollection openUsers() throws IOException, ClassNotFoundException {
        Path path = Paths.get("users.jobj");
        try (InputStream in = Files.newInputStream(path);
             ObjectInputStream oin = new ObjectInputStream(in)){
            List<User> users = (ArrayList<User>) oin.readObject();

            UserCollection userCollection = new UserCollection();

            for(User u : users){
                userCollection.addUser(u);
            }
            return userCollection;
        } catch (IOException ioe){
            throw new IOException("Something went wrong reading from file");
        } catch (ClassNotFoundException c){
            throw new ClassNotFoundException("File reader couldn't find a class");
        }
    }
}
