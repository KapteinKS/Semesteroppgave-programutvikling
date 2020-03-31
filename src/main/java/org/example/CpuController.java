package org.example;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

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
        App.setRoot("componentCreator", 460, 360);
    }

    @FXML
    void registerCPU(ActionEvent event) throws IOException {
        App.setRoot("componentCreator", 460, 360);

    }
}