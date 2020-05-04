package org.example;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import org.example.components.Cabinet;
import org.example.Exceptions.*;

import java.io.IOException;

public class CabinetController {

    private ExceptionHandler exHand = new ExceptionHandler();

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
    private TextField inWeight;

    @FXML
    private Button regButton;

    @FXML
    private Button cancelButton;

    @FXML
    void registerCabinet(ActionEvent event) throws IOException {

        if(!inName.getText().isEmpty() && !inManufac.getText().isEmpty()) {
            String name = inName.getText(), manufacturer = inManufac.getText();

            try {
                double price = exHand.priceCheck(Double.parseDouble(inPrice.getText()));
                int height = exHand.checkHeight(Integer.parseInt(inHeight.getText()));
                int width = exHand.checkWidth(Integer.parseInt(inWidth.getText()));
                int depth = exHand.checkDepth(Integer.parseInt(inDepth.getText()));
                int weight = exHand.checkWeight(Integer.parseInt(inWeight.getText()));
                Cabinet cabinet = new Cabinet(name, manufacturer, price, height, width, depth, weight);
                App.saveToCollection(cabinet);
                App.closeWindow();
            } catch (IllegalWeightException | IllegalDimensionsException | IllegalPriceException e) {
                System.err.println(e.getMessage());
            } catch (NumberFormatException n) {
                System.err.println("Tallfelt kan ikke være tomme");
            }
        }
    }

    @FXML
    void cancelRegistration(ActionEvent event)  {
        App.closeWindow();
    }
}
