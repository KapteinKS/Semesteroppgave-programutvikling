package org.example;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import org.example.components.PowerSupply;

import java.io.IOException;

public class PowersupplyController {

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
        App.changeSecondaryWindow("componentCreator", 460, 360, "Component Creator");

    }

    @FXML
    void registerPowerSupply(ActionEvent event) throws IOException {
        String name = inName.getText(), manufacturer = inManufac.getText();
        try {
            double price = Double.parseDouble(inPrice.getText());
            int energy = Integer.parseInt(inEnergy.getText());
            int voltageIn = Integer.parseInt(inVoltageIn.getText());
            int voltageOut = Integer.parseInt(inVoltageOut.getText());
            PowerSupply powerSupply = new PowerSupply(name, manufacturer, price, energy, voltageIn, voltageOut);
            App.saveToCollection(powerSupply);
        } catch (Exception e){
            System.err.println(e.getMessage());
        }
        App.changeSecondaryWindow("componentCreator", 460, 360, "Component Creator");

    }

}
