package org.example.io;

import javafx.concurrent.Task;
import org.example.App;
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
<<<<<<< HEAD:src/main/java/org/example/io/ThreadHandler.java
<<<<<<< HEAD:src/main/java/org/example/io/ThreadHandler.java
    private boolean condition;
    private String operation;
    private ComponentCollection componentCollection;
    private UserCollection userCollection;
    private OrderCollection orderCollection;



    public ThreadHandler(boolean condition, String operation, ComponentCollection componentCollection,
                         UserCollection userCollection, OrderCollection orderCollection){
        this.condition = condition;
        this.operation = operation;
        this.componentCollection = componentCollection;
        this.userCollection = userCollection;
        this.orderCollection = orderCollection;
=======
    public ThreadHandler(){

>>>>>>> parent of 60cf4b8... Working on saving threads!:src/main/java/org/example/ThreadHandler.java
    }
    protected String call() throws Exception {
<<<<<<< HEAD:src/main/java/org/example/io/ThreadHandler.java
        if(!condition) { //Loading operations
            try {
                System.out.println("Thread starting\nLoading");
                Thread.sleep(500);
                App.setUserCollection(openUsers());
                App.setComponentCollection(openComponents());
                //App.setOrderCollection(openOrder());
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
                    saveUsers(userCollection.getUsers());
                }
                else if (operation.equals("saveComponents")){
                    saveComponents(componentCollection.getArrayList());

                }
                else if (operation.equals("saveOrders")){
                    saveOrders(orderCollection);
                }
                //App.setUserCollection(openUsers());
                //App.setComponentCollection(openComponents());
                //App.setOrderCollection(ReadOrderFromFile.openOrder());
                System.out.println("Thread finished");
            } catch (InterruptedException ie){

            }
            return "";

        }
=======
=======
    public ThreadHandler(){

    }
    protected String call() throws Exception {
>>>>>>> parent of 60cf4b8... Working on saving threads!:src/main/java/org/example/ThreadHandler.java
       try {
           System.out.println("Thread starting");
           Thread.sleep(3000);
           App.setUserCollection(openUsers());
           App.setComponentCollection(openComponents());
           App.setOrderCollection(ReadOrderFromFile.openOrder());
           System.out.println("Thread finished");
       } catch (InterruptedException ie){

       }
       return "";
<<<<<<< HEAD:src/main/java/org/example/io/ThreadHandler.java
>>>>>>> parent of 60cf4b8... Working on saving threads!:src/main/java/org/example/ThreadHandler.java
=======
>>>>>>> parent of 60cf4b8... Working on saving threads!:src/main/java/org/example/ThreadHandler.java
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
<<<<<<< HEAD:src/main/java/org/example/io/ThreadHandler.java
<<<<<<< HEAD:src/main/java/org/example/io/ThreadHandler.java
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
    public static void saveOrders(OrderCollection orderCollection) throws IOException {
        Files.write(Paths.get("orders.csv"),orderCollection.toString().getBytes());
    }

    //  Method for saving components
    public static void saveComponents(List<Component> objects) throws IOException {
        Path path = Paths.get("components.jobj");
        try (OutputStream os = Files.newOutputStream(path);
             ObjectOutputStream out = new ObjectOutputStream(os)){
            out.writeObject(new ArrayList<>(objects));
        }
    }
    
=======
>>>>>>> parent of 60cf4b8... Working on saving threads!:src/main/java/org/example/ThreadHandler.java
=======
>>>>>>> parent of 60cf4b8... Working on saving threads!:src/main/java/org/example/ThreadHandler.java
}
