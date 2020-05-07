package org.example.io;

import org.example.logicAndClasses.Order;
import org.example.logicAndClasses.OrderCollection;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class ReadOrderFromFile extends Reader{
    public static void openOrder(String orderString, Path orderFilePath){
        orderString = "";
        try (BufferedReader bufferedReader = Files.newBufferedReader(orderFilePath)){
            String line;
            while ((line = bufferedReader.readLine()) != null){
                orderString = parseOrder(line);
            }
        }catch (IOException ioe){
            ioe.printStackTrace();
        }
    }

    private static String parseOrder(String line) throws IOException{
        String [] split = line.split(",");
        String customerID = split[0];
        String orderID = split[1];
        String date = split[2];

        String out = "CustomerID: " + customerID
                + "\nOrderID: " + orderID
                + "\n" + "Dato: " + date
                + "\n" + "Komponenter bestilt:" + "\n";
        try{
            for(int i = 3; i < split.length; i++){
                out += split[i] + "\n";
            }

            return out;
        }catch(IllegalArgumentException iae){
            throw new IllegalArgumentException(iae.getMessage());
        }
    }
}