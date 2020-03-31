package org.example;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import org.example.components.Fan;
import org.example.components.GraphicCard;
import org.example.components.Motherboard;

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
        App.setRoot("componentCreator", 460, 360);

    }

    @FXML
    void registerFan(ActionEvent event) throws IOException {

        // Get all parameters.
        String name = inName.getText();
        String manufacturer = inManufacturer.getText();
        String priceString = inPrice.getText();

        // try - Catch, input validation here!
        Double price = Double.parseDouble(priceString);

        String dmString = inDiameter.getText();
        int dm = Integer.parseInt(dmString);

        String pressureString = inPressure.getText();
        int pressure = Integer.parseInt(pressureString);

        String noiseString = inNoiseVolume.getText();
        int noise = Integer.parseInt(noiseString);

        // Create new Object
        Fan fn = new Fan(name, manufacturer, price, dm, pressure, noise);


        //Save new object to our register.
        //  CODE  HERE  //


        App.setRoot("componentCreator", 460, 360);

    }

}
