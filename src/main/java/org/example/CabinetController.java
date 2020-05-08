package org.example;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import org.example.componentClasses.Cabinet;
import org.example.exceptions.*;
import org.example.io.WriteComponentsToFile;

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


    //New
    @FXML
    private TextField inMbFormFactor;
    //

    @FXML
    private Button regButton;

    @FXML
    private Button cancelButton;

    @FXML
    void registerCabinet(ActionEvent event) throws IOException {

        if(!inName.getText().isEmpty() && !inManufac.getText().isEmpty() && !inMbFormFactor.getText().isEmpty()) {
            String name = inName.getText(), manufacturer = inManufac.getText(),
                    mbFormFactor = inMbFormFactor.getText(); //New

            try {
                double price = exHand.priceCheck(Double.parseDouble(inPrice.getText()));
                int height = exHand.checkHeight(Integer.parseInt(inHeight.getText()));
                int width = exHand.checkWidth(Integer.parseInt(inWidth.getText()));
                int depth = exHand.checkDepth(Integer.parseInt(inDepth.getText()));
                double weight = exHand.checkWeight(Double.parseDouble(inWeight.getText()));
                Cabinet cabinet = new Cabinet(name, manufacturer, price, mbFormFactor, height, width, depth, weight);
                App.saveToCollection(cabinet);
                WriteComponentsToFile.save(App.getList2().getArrayList());

                App.closeWindow();

            } catch (IllegalWeightException | IllegalDimensionsException | IllegalPriceException e) {
                DialogueBoxes.alert("Feil", e.getMessage());
            } catch (NumberFormatException n) {
                DialogueBoxes.alert("Feil", "Tallfelt kan ikke være tomme");
            }
        } else {
            DialogueBoxes.alert("Feil", "Ett eller flere påkrevde tekstfelt er tomme");
        }
    }

    @FXML
    void cancelRegistration(ActionEvent event)  {
        App.closeWindow();
    }
}
