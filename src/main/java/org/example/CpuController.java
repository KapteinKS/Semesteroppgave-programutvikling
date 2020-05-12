package org.example;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import org.example.exceptions.ExceptionHandler;
import org.example.exceptions.IllegalClockSpeedException;
import org.example.exceptions.IllegalPriceException;
import org.example.exceptions.IllegalThreadsException;
import org.example.componentClasses.CPU;
import org.example.logicAndClasses.DialogueBoxes;

import java.io.IOException;

public class CpuController {

    ExceptionHandler exHan = new ExceptionHandler();

    @FXML
    private TextField inName;

    @FXML
    private TextField inManufac;

    @FXML
    private TextField inWatts;

    @FXML
    private TextField inPrice;

    @FXML
    private TextField inThreads;

    @FXML
    private TextField inClockSpeed;

    @FXML
    private TextField inSocket;

    @FXML
    private Button regButton;

    @FXML
    private Button cancelButton;

    @FXML
    void cancelRegistration(ActionEvent event) throws IOException {
        App.closeWindow();
    }

    @FXML
    void registerCPU(ActionEvent event) throws IOException {
        if (!inName.getText().isEmpty() && !inManufac.getText().isEmpty() && !inSocket.getText().isEmpty()) {
            String name = inName.getText(), manufacturer = inManufac.getText(), socket = inSocket.getText();;

            try {
                //New
                double wattsRequired = Double.parseDouble(inWatts.getText());

                double price = exHan.priceCheck(Double.parseDouble(inPrice.getText()));
                int threads = exHan.checkThreads(Integer.parseInt(inThreads.getText()));
                double clockspeed = exHan.checkClockSpeed(Double.parseDouble(inClockSpeed.getText()));

                CPU cpu = new CPU(name, manufacturer, wattsRequired, price, threads, clockspeed, socket);
                App.saveToCollection(cpu);

                App.closeWindow();

            } catch (IllegalClockSpeedException | IllegalPriceException | IllegalThreadsException e) {
                DialogueBoxes.alert("Feil", e.getMessage());
            } catch (NumberFormatException n) {
                DialogueBoxes.alert("Feil", "Tallfelt kan ikke være tomme");
            }
        } else {
            DialogueBoxes.alert("Feil", "Ett eller flere påkrevde tekstfelt er tomme");
        }
    }
}