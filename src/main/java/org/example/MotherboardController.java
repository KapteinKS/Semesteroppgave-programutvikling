package org.example;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import org.example.components.CPU;
import org.example.components.Motherboard;

import java.io.IOException;

public class MotherboardController {

    @FXML
    private TextField inName;

    @FXML
    private TextField inManufac;

    @FXML
    private TextField inPrice;

    // WE NEED RAM-TYPE FIELD
    // AND SOCKET-FIELD

    @FXML
    private TextField inPorts;

    @FXML
    private TextField inWatts;

    @FXML
    private Button regButton;

    @FXML
    private Button cancelButten;

    @FXML
    void cancelRegistration(ActionEvent event) throws IOException {
        App.setRoot("componentCreator", 460, 360, "Component Creator");

    }

    @FXML
    void registerMotherboard(ActionEvent event) throws IOException {

        // Get all parameters.
        String name = inName.getText();
        String manufacturer = inManufac.getText();
        String priceString = inPrice.getText();

        // try - Catch, input validation here!
        double price = Double.parseDouble(priceString);

        String portsString = inPorts.getText();
        int ports = Integer.parseInt(portsString);
        String wattsString = inWatts.getText();
        double watts = Double.parseDouble(wattsString);

        //

        //Create new object
        // THIS IS ERRONIOUS!!
        Motherboard mb = new Motherboard(name, manufacturer, price, "MISSING", "MISSING", watts);

        App.setRoot("componentCreator", 460, 360, "Component Creator");

    }

}
