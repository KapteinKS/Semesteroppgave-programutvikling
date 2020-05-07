package org.example;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import org.example.componentClasses.Monitor;
import org.example.exceptions.*;

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
    private Button regButton;

    @FXML
    private Button cancelButton;

    @FXML
    void cancel(ActionEvent event) {
        App.closeWindow();
    }

    @FXML
    void registerMonitor(ActionEvent event) {
        if (!inName.getText().isEmpty() && !inManufac.getText().isEmpty() && !inType.getText().isEmpty()){
            String name = inName.getText(), manufacturer = inManufac.getText(), screenType = inType.getText();

            try{
                double price = exHand.priceCheck(Double.parseDouble(inPrice.getText())),
                        size = exHand.checkSize(Double.parseDouble(inSize.getText()));
                int refreshRate = exHand.checkRefreshRate(Integer.parseInt(inRefresh.getText())),
                        responseTime = exHand.checkResponseTime(Integer.parseInt(inResponse.getText()));

                Monitor monitor = new Monitor(name, manufacturer, 0, price,size, refreshRate, responseTime, screenType);

                App.saveToCollection(monitor);
                App.closeWindow();

            } catch (IllegalPriceException | IllegalScreenSizeException | IllegalRefreshRateException | IllegalResponseTimeException e){
                System.err.println(e.getMessage());
            } catch (NumberFormatException n){
                System.err.println("Tallfelt kan ikke være tomme");
            }
        } else {
            System.err.println("Ett eller flere påkrevde tekstfelt er tomme");
        }
    }

}
