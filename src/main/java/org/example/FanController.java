package org.example;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import org.example.exceptions.*;
import org.example.componentClasses.Fan;
import org.example.logicAndClasses.DialogueBoxes;

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
    void cancelRegistration(ActionEvent event) throws IOException {
        App.closeWindow();
    }

    @FXML
    void registerFan(ActionEvent event) throws IOException {
        //  Checking that text inputs are not empty, number inputs validated within try block
        //  A component cannot be registered with any empty fields
        if (!inName.getText().isEmpty() && !inManufacturer.getText().isEmpty()) {
            String name = inName.getText(), manufacturer = inManufacturer.getText();
            //  Input validation
            try {
                double price = exHan.checkPrice(Double.parseDouble(inPrice.getText()));
                int diameter = exHan.checkDiameter(Integer.parseInt(inDiameter.getText()));
                double airPressure = exHan.checkAirPressure(Double.parseDouble(inPressure.getText()));
                int maxNoiseVolume = exHan.checkNoise(Integer.parseInt(inNoiseVolume.getText()));
                //  Storing the new component, & exiting
                Fan fan = new Fan(name, manufacturer, price, diameter, airPressure, maxNoiseVolume);
                App.saveToCollection(fan);
                App.closeWindow();
            } catch (IllegalPriceException | IllegalDimensionsException | IllegalPressureException | IllegalNoiseException e){
                DialogueBoxes.alert("Feil", e.getMessage());
            } catch (NumberFormatException n) {
                DialogueBoxes.alert("Feil", "Tallfelt kan ikke være tomme");
            }
        } else {
            DialogueBoxes.alert("Feil", "Ett eller flere påkrevde tekstfelt er tomme");
        }
    }
}
