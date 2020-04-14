package org.example;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import org.example.components.Fan;

import java.io.IOException;

public class FanController {

    @FXML
    private TextField inName;

    @FXML
    private TextField inManufacturer;

    @FXML
    private TextField inPrice;

    @FXML
    private TextField inDiameter;

    @FXML
    private TextField inPressure;

    @FXML
    private TextField inNoiseVolume;

    @FXML
    private Button regButton;

    @FXML
    private Button cancelButton;

    @FXML
    void cancelRegistration(ActionEvent event) throws IOException {
        App.changeSecondaryWindow("componentCreator", 460, 360, "Component Creator");

    }

    @FXML
    void registerFan(ActionEvent event) throws IOException {
        String name = inName.getText(), manufacturer = inManufacturer.getText();
        try{
            double price = Double.parseDouble(inPrice.getText());
            int diameter = Integer.parseInt(inDiameter.getText());
            double airPressure = Double.parseDouble(inPressure.getText());
            int maxNoiseVolume = Integer.parseInt(inNoiseVolume.getText());
            Fan fan = new Fan(name, manufacturer, price, diameter, airPressure, maxNoiseVolume);
            App.saveToCollection(fan);
        } catch (Exception e){
            System.err.println(e.getMessage());
        }

        App.changeSecondaryWindow("componentCreator", 460, 360, "Component Creator");

    }

}
