package org.example;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import org.example.components.CPU;
import org.example.components.Cabinet;

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
    private Button cancelButton;

    @FXML
    void cancelRegistration(ActionEvent event) throws IOException {
        App.changeSecondaryWindow("componentCreator", 460, 360, "Component Creator");
    }

    @FXML
    void registerCPU(ActionEvent event) throws IOException {String name = inName.getText(), manufacturer = inManufac.getText();

        try{
            double price = Double.parseDouble(inPrice.getText());
            int threads = Integer.parseInt(inThreads.getText());
            double clockspeed = Double.parseDouble(inClockSpeed.getText());
            CPU cpu = new CPU(name, manufacturer, price, threads, clockspeed);
            App.saveToCollection(cpu);

        } catch (Exception e){
            System.err.println(e.getMessage());
        }

        App.changeSecondaryWindow("componentCreator", 460, 360, "Component Creator");

    }
}