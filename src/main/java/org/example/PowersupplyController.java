package org.example;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import org.example.components.CPU;
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
    private Button cancelButten;

    @FXML
    void cancelRegistration(ActionEvent event) throws IOException {
        App.setRoot("componentCreator", 460, 360);

    }

    @FXML
    void registerPowerSupply(ActionEvent event) throws IOException {

        // Get all parameters.
        String name = inName.getText();
        String manufacturer = inManufac.getText();
        String priceString = inPrice.getText();

        // try - Catch, input validation here!
        double price = Double.parseDouble(priceString);


        String energyString = inEnergy.getText();
        int energy = Integer.parseInt(energyString);
        String voltageInString = inVoltageIn.getText();
        int voltageIn = Integer.parseInt(voltageInString);
        String voltageOutString = inVoltageOut.getText();
        int voltageOut = Integer.parseInt(voltageOutString);



        //Create new object
        PowerSupply psu = new PowerSupply(name, manufacturer, price, energy, voltageIn, voltageOut);

        App.setRoot("componentCreator", 460, 360);

    }

}
