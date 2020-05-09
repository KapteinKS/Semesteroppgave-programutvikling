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
    public static List<Order> openOrder() throws IOException{
        Path orderFilePath = Paths.get("orders.txt");
        ArrayList<Order> listOfOrders= new ArrayList<>();
        try (BufferedReader bufferedReader = Files.newBufferedReader(orderFilePath)){
            String line;
            while ((line = bufferedReader.readLine()) != null){
                listOfOrders.add(parseOrder(line));
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
        String[] split = line.split(";");
        String userID = split[0];
        String orderID = split[1];
        String date = split[2];
        String priceString = split[split.length-1]; //the last value?
        ObservableList<Component> componentsOrdered = FXCollections.observableArrayList();


        /*
        String out = "CustomerID: " + customerID
                + "\nOrderID: " + orderID
                + "\n" + "Dato: " + dateString
                + "\n" + "Komponenter bestilt:" + "\n";
        */

        try{
            for(int i = 3; i < split.length; i++){

                String componentOrderedString = split[i];
                String[] componentSplit = componentOrderedString.split(",");
                String componentType = componentSplit[0];
                switch (componentType) {
                    case "Cabinet":
                        componentsOrdered.add(new Cabinet(
                                componentSplit[1], //Name
                                componentSplit[2], //Manufactorer
                                Double.parseDouble(componentSplit[4]), //Price
                                componentSplit[5], //MB formfactor
                                Double.parseDouble(componentSplit[6]), //Height
                                Double.parseDouble(componentSplit[7]), //widht
                                Double.parseDouble(componentSplit[8]), //Depth
                                Double.parseDouble(componentSplit[9]))); //Weight
                        break;
                    case "CPU":
                        componentsOrdered.add(new CPU(
                                componentSplit[1], //Name
                                componentSplit[2], //Manf
                                Double.parseDouble(componentSplit[3]), //Watts
                                Double.parseDouble(componentSplit[4]), //price
                                Integer.parseInt(componentSplit[5]), //Threads
                                Double.parseDouble(componentSplit[6]), //Speed
                                componentSplit[7] //Socket
                        ));
                        break;
                    case "Fan":
                        componentsOrdered.add(new Fan(
                                componentSplit[1], //name
                                componentSplit[2], //manf
                                Double.parseDouble(componentSplit[4]), //price
                                Integer.parseInt(componentSplit[5]), //diameter
                                Double.parseDouble(componentSplit[6]), //airpressure
                                Integer.parseInt(componentSplit[7]) //maxNoise
                        ));
                        break;
                    case "GraphicCard":
                        componentsOrdered.add(new GraphicCard(
                                componentSplit[1], //Name
                                componentSplit[2], //Manf
                                Double.parseDouble(componentSplit[3]), //Watts
                                Double.parseDouble(componentSplit[4]), //price
                                Integer.parseInt(componentSplit[5]), //Ram
                                componentSplit[6], //Ramtype
                                Double.parseDouble(componentSplit[7]) //clockspeed
                        ));
                        break;
                    case "Keyboard":
                        componentsOrdered.add(new Keyboard(
                                componentSplit[1], //Name
                                componentSplit[2], //Manf
                                Double.parseDouble(componentSplit[3]), //Watts
                                Double.parseDouble(componentSplit[4]), //price
                                componentSplit[5], //switches
                                componentSplit[6], //language
                                componentSplit[7] //connectionType
                        ));
                        break;
                    case "Monitor":
                        componentsOrdered.add(new Monitor(
                                componentSplit[1], //Name
                                componentSplit[2], //Manf
                                Double.parseDouble(componentSplit[3]), //Watts
                                Double.parseDouble(componentSplit[4]), //price
                                Double.parseDouble(componentSplit[5]), //size
                                Integer.parseInt(componentSplit[6]), //refreshRate
                                Integer.parseInt(componentSplit[7]), //responseTIme
                                componentSplit[8] //ScreenType
                        ));
                        break;
                    case "Motherboard":
                        componentsOrdered.add(new Motherboard(
                                componentSplit[1], //Name
                                componentSplit[2], //Manf
                                Double.parseDouble(componentSplit[3]), //Watts
                                Double.parseDouble(componentSplit[4]), //price
                                componentSplit[5], //FormFactor
                                componentSplit[6], //socket
                                componentSplit[7] //ramType
                        ));
                        break;
                    case "Mouse":
                        componentsOrdered.add(new Mouse(
                                componentSplit[1], //Name
                                componentSplit[2], //Manf
                                Double.parseDouble(componentSplit[3]), //Watts
                                Double.parseDouble(componentSplit[4]), //price
                                Integer.parseInt(componentSplit[5]), //DPI
                                componentSplit[6], //ConnectionType
                                Integer.parseInt(componentSplit[7]) //mouseProgrammableButtons
                        ));
                        break;
                    case "PowerSupply":
                        componentsOrdered.add(new PowerSupply(
                                componentSplit[1], //Name
                                componentSplit[2], //Manf
                                Double.parseDouble(componentSplit[3]), //Watts
                                Double.parseDouble(componentSplit[4]), //price
                                Integer.parseInt(componentSplit[5]), //inVoltage
                                Integer.parseInt(componentSplit[6]) //outVoltage
                        ));
                        break;
                    case "RAM":
                        componentsOrdered.add(new RAM(
                                componentSplit[1], //Name
                                componentSplit[2], //Manf
                                Double.parseDouble(componentSplit[4]), //price
                                Integer.parseInt(componentSplit[5]), //size
                                componentSplit[6], //memoryType
                                Integer.parseInt(componentSplit[6]) //amountOfRamTypes
                        ));
                        break;
                    case "Storage":
                        componentsOrdered.add(new Storage(
                                componentSplit[1], //Name
                                componentSplit[2], //Manf
                                Double.parseDouble(componentSplit[4]), //price
                                componentSplit[5], //storageType
                                Integer.parseInt(componentSplit[6]), //capacity
                                componentSplit[6] //capacityType
                        ));
                        break;
                    default:
                        componentsOrdered.add(new Fan(
                                "Error reading order from File", //name
                                "ERROR!", //manf
                                0.0, //price
                                0, //diameter
                                0.0, //airpressure
                                0 //maxNoise
                        ));
                }

            }
        }catch(IllegalArgumentException iae){
            throw new IllegalArgumentException(iae.getMessage());
        }

        System.out.println(userID + ", " + orderID + ", " + componentsOrdered.toString() + ", " + priceString);
        return new Order(userID,orderID,date,componentsOrdered,Double.parseDouble(priceString));
    }
}