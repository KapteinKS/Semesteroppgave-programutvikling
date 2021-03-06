package org.example;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import org.example.componentClasses.Monitor;
import org.example.exceptions.*;
import org.example.logicAndClasses.DialogueBoxes;

import java.io.IOException;

public class MonitorController {
    private ExceptionHandler exHand = new ExceptionHandler();

    @FXML
    private TextField inManufac;

    @FXML
    private TextField inName;

    @FXML
    private TextField inPrice;

    @FXML
    private TextField inSize;

    @FXML
    private TextField inRefresh;

    @FXML
    private TextField inResponse;

    @FXML
    private TextField inType;

    @FXML
    void cancel(ActionEvent event) {
        App.closeWindow();
    }

    @FXML
    void registerMonitor(ActionEvent event) throws IOException {
        //  Checking that text inputs are not empty, number inputs validated within try block
        //  A component cannot be registered with any empty fields
        if (!inName.getText().isEmpty() && !inManufac.getText().isEmpty() && !inType.getText().isEmpty()){
            String name = inName.getText(), manufacturer = inManufac.getText(), screenType = inType.getText();
            //  Input validation
            try{
                double price = exHand.checkPrice(Double.parseDouble(inPrice.getText())),
                        size = exHand.checkSize(Double.parseDouble(inSize.getText()));
                int refreshRate = exHand.checkRefreshRate(Integer.parseInt(inRefresh.getText())),
                        responseTime = exHand.checkResponseTime(Integer.parseInt(inResponse.getText()));
                //  Storing the new component, & exiting
                Monitor monitor = new Monitor(name, manufacturer, 0, price,size, refreshRate, responseTime, screenType);
                App.saveToCollection(monitor);
                App.closeWindow();
            } catch (IllegalPriceException | IllegalScreenSizeException | IllegalRefreshRateException | IllegalResponseTimeException e){
                DialogueBoxes.alert("Feil", e.getMessage());
            } catch (NumberFormatException n) {
                DialogueBoxes.alert("Feil", "Tallfelt kan ikke være tomme");
            }
        } else {
            DialogueBoxes.alert("Feil", "Ett eller flere påkrevde tekstfelt er tomme");
        }
    }
}
