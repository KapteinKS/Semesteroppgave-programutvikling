package org.example;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

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
        App.setRoot("componentCreator", 460, 360, "Component Creator");

    }

    @FXML
    void registerFan(ActionEvent event) throws IOException {
        App.setRoot("componentCreator", 460, 360, "Component Creator");

    }

}
