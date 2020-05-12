package org.example;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import org.example.exceptions.ExceptionHandler;
import org.example.exceptions.IllegalPriceException;
import org.example.exceptions.IllegalWattsException;
import org.example.componentClasses.Motherboard;
import org.example.logicAndClasses.DialogueBoxes;

import java.io.IOException;

public class MotherboardController {
    ExceptionHandler exHan = new ExceptionHandler();

    @FXML
    private TextField inMbFormFactor;

    @FXML
    private TextField inName;

    @FXML
    private TextField inManufac;

    @FXML
    private TextField inPrice;

    @FXML
    private TextField inSockets;

    @FXML
    private TextField inRamType;

    @FXML
    private TextField inWatts;

    @FXML
    void cancelRegistration(ActionEvent event) throws IOException {
        App.closeWindow();
    }

    @FXML
    void registerMotherboard(ActionEvent event) throws IOException {
        //  Checking that input is not empty
        if (!inName.getText().isEmpty() && !inManufac.getText().isEmpty() && !inSockets.getText().isEmpty()
            && !inMbFormFactor.getText().isEmpty() && !inRamType.getText().isEmpty()) {
            String name = inName.getText(),
                    manufacturer = inManufac.getText(),
                    socket = inSockets.getText(),
                    ramType = inRamType.getText(),
                    mbFormFactor = inMbFormFactor.getText();
            //  Input validation
            try {
                double price = exHan.checkPrice(Double.parseDouble(inPrice.getText()));
                double wattsRequired = exHan.checkWatts(Double.parseDouble(inWatts.getText()));
                //  Storing the new component, & exiting
                Motherboard motherboard = new Motherboard(name, manufacturer, wattsRequired, price, mbFormFactor, socket, ramType);
                App.saveToCollection(motherboard);
                App.closeWindow();
            } catch (IllegalPriceException | IllegalWattsException e){
                DialogueBoxes.alert("Feil", e.getMessage());
            } catch (NumberFormatException n) {
                DialogueBoxes.alert("Feil", "Tallfelt kan ikke være tomme");
            }
        } else {
            DialogueBoxes.alert("Feil", "Ett eller flere påkrevde tekstfelt er tomme");
        }
    }
}
