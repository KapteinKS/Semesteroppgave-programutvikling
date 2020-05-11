package org.example;

import javafx.concurrent.Task;
import org.example.componentClasses.Component;
//import org.example.io.ReadOrderFromFile;
import org.example.logicAndClasses.*;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class ThreadHandler extends Task<String> {
    private boolean condition;
    private String operation;

    public ThreadHandler(boolean condition, String operation){
        this.condition = condition;
        this.operation = operation;
    }

    protected String call() throws Exception {
        if(!condition) { //Loading operations
            try {
                System.out.println("Thread starting\nLoading");
                Thread.sleep(1000);
                App.setUserCollection(openUsers());
                App.setComponentCollection(openComponents());
                App.setOrderCollection(openOrder());
                System.out.println("Thread finished");
            } catch (InterruptedException ie) {
            }
            return "";
        }
        else{ //Saving operations
            try{
                System.out.println("Thread starting\nSaving");
                Thread.sleep(1000);
                if (operation.equals("saveUsers")){

                }
                if (operation.equals("saveComponents")){

                }
                if (operation.equals("saveOrders")){

                }
                //App.setUserCollection(openUsers());
                //App.setComponentCollection(openComponents());
                //App.setOrderCollection(ReadOrderFromFile.openOrder());
                System.out.println("Thread finished");
            } catch (InterruptedException ie){

            }
            return "";

        }
    }
    //  Method for loading components from .jobj file
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
    //  Method for loading users form .jobj file
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
    //  Method for loading orders from .csv file
    public static OrderCollection openOrder() throws IOException{
        Path orderFilePath = Paths.get("orders.csv");
        //ArrayList<Order> listOfOrders= new ArrayList<>();
        OrderCollection listOfOrders = new OrderCollection();
        try (BufferedReader bufferedReader = Files.newBufferedReader(orderFilePath)){
            String line;
            while ((line = bufferedReader.readLine()) != null){
                listOfOrders.addOrder(parseOrder(line));
            }
        }catch (IOException ioe){
            ioe.printStackTrace();
        }
        if (listOfOrders.size()==0){
            throw new IOException("Fil er tom.");
        }
        return listOfOrders;
    }
    //  Submethod for openOrder()
    private static Order parseOrder(String line) throws IOException{
        String[] split = line.split(";");
        String userID = split[0];
        String orderID = split[1];
        String date = split[2];
        String priceString = split[split.length-1]; //the last value?
        ArrayList<String> componentsOrdered = new ArrayList<>();
        for (int i = 3; i < split.length; i++){
            componentsOrdered.add(split[i]);
        }
        return new Order(userID,orderID,date,componentsOrdered,Double.parseDouble(priceString));
    }

    //  Method for saving users
    public static void saveUsers(List<User> users) throws IOException {
        Path path = Paths.get("users.jobj");
        try(OutputStream os = Files.newOutputStream(path);
            ObjectOutputStream out = new ObjectOutputStream(os)){
            out.writeObject(new ArrayList<>(users));
        }
    }

    //  Method for saving orders
    public static void saveOrders(OrderCollection orderCollection, Path path) throws IOException {
        Files.write(path,orderCollection.toString().getBytes());
    }

    //  Method for saving components
    public static void saveComponents(List<Component> objects) throws IOException {
        Path path = Paths.get("components.jobj");
        try (OutputStream os = Files.newOutputStream(path);
             ObjectOutputStream out = new ObjectOutputStream(os)){
            out.writeObject(new ArrayList<>(objects));
        }
    }
    
}
