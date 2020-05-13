package org.example;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import org.example.exceptions.ExceptionHandler;
import org.example.exceptions.IllegalPriceException;
import org.example.exceptions.IllegalVoltageException;
import org.example.exceptions.IllegalWattsException;
import org.example.componentClasses.PowerSupply;
import org.example.logicAndClasses.DialogueBoxes;

import java.io.IOException;

public class PowersupplyController {
    ExceptionHandler exHan = new ExceptionHandler();

    @FXML
    private TextField inName;

    @FXML
    private TextField inManufac;

    @FXML
    private TextField inPrice;

    @FXML
    private TextField inEnergy;

    @FXML
    private TextField inVoltageIn;

    @FXML
    private TextField inVoltageOut;

    @FXML
    void cancelRegistration(ActionEvent event) throws IOException {
        App.closeWindow();
    }

    @FXML
    void registerPowerSupply(ActionEvent event) throws IOException {
        //  Checking that text inputs are not empty, number inputs validated within try block
        //  A component cannot be registered with any empty fields
        if (!inName.getText().isEmpty() && !inManufac.getText().isEmpty()) {
            String name = inName.getText(), manufacturer = inManufac.getText();
            //  Input validation
            try {
                double price = exHan.checkPrice(Double.parseDouble(inPrice.getText()));
                int energy = exHan.checkWatts(Integer.parseInt(inEnergy.getText()));
                int voltageIn = exHan.checkVoltageIn(Integer.parseInt(inVoltageIn.getText()));
                int voltageOut = exHan.checkVoltageout(Integer.parseInt(inVoltageOut.getText()));
                //  Storing the new component, & exiting
                PowerSupply powerSupply = new PowerSupply(name, manufacturer, price, energy, voltageIn, voltageOut);
                App.saveToCollection(powerSupply);
                App.closeWindow();
            } catch (IllegalPriceException | IllegalWattsException | IllegalVoltageException e){
                DialogueBoxes.alert("Feil", e.getMessage());
            } catch (NumberFormatException n) {
                DialogueBoxes.alert("Feil", "Tallfelt kan ikke være tomme");
            }
        } else {
            DialogueBoxes.alert("Feil", "Ett eller flere påkrevde tekstfelt er tomme");
        }
    }
}
