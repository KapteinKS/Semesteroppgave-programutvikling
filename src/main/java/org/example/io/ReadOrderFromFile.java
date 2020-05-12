package org.example.io;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import org.example.componentClasses.*;
import org.example.logicAndClasses.Order;
import org.example.logicAndClasses.OrderCollection;

import java.io.BufferedReader;
import java.io.IOException;
import java.lang.reflect.Array;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class ReadOrderFromFile extends Reader{
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

    private static Order parseOrder(String line) throws IOException{
        String[] split = line.split(",");
        String userID = split[0];
        String orderID = split[1];
        String date = split[2];
        String priceString = split[split.length-1];//the last value?
        ArrayList<String> componentsOrdered = new ArrayList<>();
        for (int i = 3; i < split.length; i++){
            componentsOrdered.add(split[i]);
        }

        return new Order(userID,orderID,date,componentsOrdered,Double.parseDouble(priceString));
    }
}