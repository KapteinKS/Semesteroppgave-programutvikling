package org.example;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import org.example.Exceptions.ExceptionHandler;
import org.example.Exceptions.IllegalPriceException;
import org.example.Exceptions.IllegalVoltageException;
import org.example.Exceptions.IllegalWattsException;
import org.example.components.PowerSupply;

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
    private Button regButton;

    @FXML
    private Button cancelButton;

    @FXML
    void cancelRegistration(ActionEvent event) throws IOException {
        App.closeWindow();
    }

    @FXML
    void registerPowerSupply(ActionEvent event) throws IOException {
        if (!inName.getText().isEmpty() && !inManufac.getText().isEmpty()) {
            String name = inName.getText(), manufacturer = inManufac.getText();
            try {
                double price = exHan.priceCheck(Double.parseDouble(inPrice.getText()));
                int energy = exHan.checkWatts(Integer.parseInt(inEnergy.getText()));
                int voltageIn = exHan.checkVoltageIn(Integer.parseInt(inVoltageIn.getText()));
                int voltageOut = exHan.checkVoltageout(Integer.parseInt(inVoltageOut.getText()));
                PowerSupply powerSupply = new PowerSupply(name, manufacturer, price, energy, voltageIn, voltageOut);
                App.saveToCollection(powerSupply);
                App.closeWindow();
            } catch (NumberFormatException n){
                System.err.println("Tallfelt kan ikke være tomme");
            } catch (IllegalPriceException | IllegalWattsException | IllegalVoltageException e){
                System.err.println(e.getMessage());
            }

        }
    }
}
