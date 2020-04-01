package org.example;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import org.example.components.CPU;
import org.example.components.GraphicCard;

import java.io.IOException;

public class CpuController {

    @FXML
    private TextField inName;

    @FXML
    private TextField inManufac;

    @FXML
    private TextField inPrice;

    @FXML
    private TextField inThreads;

    @FXML
    private TextField inClockSpeed;

    @FXML
    private Button regButton;

    @FXML
    private Button cancelButten;

    @FXML
    void cancelRegistration(ActionEvent event) throws IOException {
        App.setRoot("componentCreator", 460, 360, "Component Creator");
    }

    @FXML
    void registerCPU(ActionEvent event) throws IOException {

        // Get all parameters.
        String name = inName.getText();
        String manufacturer = inManufac.getText();
        String priceString = inPrice.getText();

        // try - Catch, input validation here!
        double price = Double.parseDouble(priceString);

        String threadsString = inThreads.getText();
        int threads = Integer.parseInt(threadsString);

        String clockSpeedString = inClockSpeed.getText();
        double clockSpeed = Double.parseDouble(clockSpeedString);

        //Create new object
        CPU cpu = new CPU(name, manufacturer, price, threads, clockSpeed);

        //Save new object to our register.
        //  CODE  HERE  //

        App.setRoot("componentCreator", 460, 360, "Component Creator");

    }
}