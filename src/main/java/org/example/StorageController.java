package org.example;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import org.example.components.PowerSupply;
import org.example.components.Storage;

import java.io.IOException;

public class StorageController {

    @FXML
    private TextField inName;

    @FXML
    private TextField inManufac;

    @FXML
    private TextField inPrice;

    @FXML
    private TextField inType;

    @FXML
    private TextField inCapacity;

    @FXML
    private Button regButton;

    @FXML
    private Button cancelButton;

    @FXML
    void cancelRegistration(ActionEvent event) throws IOException {
        App.setRoot("componentCreator", 460, 360);
    }

    @FXML
    void regStorage(ActionEvent event) throws IOException {

        // Get all parameters.
        String name = inName.getText();
        String manufacturer = inManufac.getText();
        String priceString = inPrice.getText();

        // try - Catch, input validation here!
        double price = Double.parseDouble(priceString);

        String type = inType.getText();
        String capacity = inCapacity.getText();

        //Create new object
        Storage strg = new Storage(name, manufacturer, price, type, capacity);


        App.setRoot("componentCreator", 460, 360);

    }

}
