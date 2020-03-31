package org.example;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.io.IOException;

public class CabinetController {

    @FXML
    private TextField inName;

    @FXML
    private TextField inManufac;

    @FXML
    private TextField inPrice;

    @FXML
    private TextField inHeight;

    @FXML
    private TextField inWidth;

    @FXML
    private TextField inDepth;

    @FXML
    private TextField inWeght;

    @FXML
    private Button regButton;

    @FXML
    private Button cancelButten;

    @FXML
    void registerCabinet(ActionEvent event) throws IOException {
        App.setRoot("componentCreator", 460, 360, "Component Creator");

    }

    @FXML
    void cancelRegistration(ActionEvent event) throws IOException {
        App.setRoot("componentCreator", 460, 360, "Component Creator");

    }
}
