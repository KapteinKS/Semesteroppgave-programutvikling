package org.example;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import org.example.componentClasses.Motherboard;

import java.io.IOException;

public class MotherboardController {

    @FXML
    private TextField inName;

    @FXML
    private TextField inManufac;

    @FXML
    private TextField inPrice;

    @FXML
    private TextField inFormFactor;

    @FXML
    private TextField inSockets;

    @FXML
    private TextField inRamType;

    @FXML
    private TextField inWatts;

    @FXML
    private Button regButton;

    @FXML
    private Button cancelButton;

    @FXML
    void cancelRegistration(ActionEvent event) throws IOException {
        App.changeSecondaryWindow("componentCreator", 460, 360, "Component Creator");

    }

    @FXML
    void registerMotherboard(ActionEvent event) throws IOException {
        String name = inName.getText(), manufacturer = inManufac.getText(), socket = inSockets.getText(), ramType = inRamType.getText();

        String formFactor = inFormFactor.getText();  // This must have checks, tests round it.

        try {
            double price = Double.parseDouble(inPrice.getText());
            double wattsRequired = Double.parseDouble(inWatts.getText());
            Motherboard motherboard = new Motherboard(name, manufacturer, price, wattsRequired, formFactor, socket, ramType);
            App.saveToCollection(motherboard);
            } catch (Exception e){
            System.err.println(e.getMessage());
        }
        App.changeSecondaryWindow("componentCreator", 460, 360, "Component Creator");

    }

}
