package org.example;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import org.example.Exceptions.*;
import org.example.components.Fan;

import java.io.IOException;

public class FanController {

    ExceptionHandler exHan = new ExceptionHandler();

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
        App.closeWindow();
    }

    @FXML
    void registerFan(ActionEvent event) throws IOException {
        if (!inName.getText().isEmpty() && !inManufacturer.getText().isEmpty()) {
            String name = inName.getText(), manufacturer = inManufacturer.getText();
            try {
                double price = exHan.priceCheck(Double.parseDouble(inPrice.getText()));
                int diameter = exHan.checkDiameter(Integer.parseInt(inDiameter.getText()));
                double airPressure = exHan.checkAirPressure(Double.parseDouble(inPressure.getText()));
                int maxNoiseVolume = exHan.checkNoise(Integer.parseInt(inNoiseVolume.getText()));
                Fan fan = new Fan(name, manufacturer, price, diameter, airPressure, maxNoiseVolume);
                App.saveToCollection(fan);
                App.closeWindow();
            } catch (IllegalPriceException | IllegalDimensionsException | IllegalPressureException | IllegalNoiseException e){
                System.err.println(e.getMessage());
            }

        }

    }

}
