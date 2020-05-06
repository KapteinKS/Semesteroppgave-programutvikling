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

import java.io.IOException;

public class CpuController {

    ExceptionHandler exHan = new ExceptionHandler();

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
        App.closeWindow();
    }

    @FXML
    void registerCPU(ActionEvent event) throws IOException {
        if (!inName.getText().isEmpty() && !inManufac.getText().isEmpty()) {
            String name = inName.getText(), manufacturer = inManufac.getText();

            try {
                double price = exHan.priceCheck(Double.parseDouble(inPrice.getText()));
                int threads = exHan.checkThreads(Integer.parseInt(inThreads.getText()));
                double clockspeed = exHan.chechClockSpeed(Double.parseDouble(inClockSpeed.getText()));

                CPU cpu = new CPU(name, manufacturer, price, threads, clockspeed);
                App.saveToCollection(cpu);
                App.closeWindow();
            } catch (IllegalClockSpeedException | IllegalPriceException | IllegalThreadsException e) {
                System.err.println(e.getMessage());
            } catch (NumberFormatException n){
                System.err.println("Tallfelt kan ikke være tomme");

            }

        }
    }
}