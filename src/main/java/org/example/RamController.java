package org.example;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import org.example.componentClasses.RAM;
import org.example.exceptions.ExceptionHandler;
import org.example.exceptions.IllegalPriceException;
import org.example.exceptions.IllegalRAMException;
import org.example.io.WriteComponentsToFile;

import java.io.IOException;

public class RamController {
    ExceptionHandler exHan = new ExceptionHandler();

    @FXML
    private TextField inManufac;

    @FXML
    private TextField inName;

    @FXML
    private TextField inPrice;

    @FXML
    private TextField inSize;

    @FXML
    private TextField inType;

    @FXML
    private TextField inAmount;

    @FXML
    private Button regButton;

    @FXML
    private Button cancelButton;

    @FXML
    void cancelRegistration(ActionEvent event) {
        App.closeWindow();
    }

    @FXML
    void registerRAM(ActionEvent event) throws IOException {
        if (!inName.getText().isEmpty() && !inManufac.getText().isEmpty() && !inType.getText().isEmpty()){
            String name = inName.getText(), manufacturer = inManufac.getText(), type = inType.getText();

            try {
                double price = exHan.priceCheck(Double.parseDouble(inPrice.getText()));
                int size = exHan.checkRAM(Integer.parseInt(inSize.getText()));
                int amount = exHan.checkRAMPieces(Integer.parseInt(inAmount.getText()));

                RAM ram = new RAM(name, manufacturer, price, size, type, amount);

                App.saveToCollection(ram);
                WriteComponentsToFile.save(App.getList2().getArrayList());
                App.closeWindow();

            } catch (IllegalRAMException | IllegalPriceException e){
                DialogueBoxes.alert("Feil", e.getMessage());
            } catch (NumberFormatException n) {
                DialogueBoxes.alert("Feil", "Tallfelt kan ikke være tomme");
            }
        } else {
            DialogueBoxes.alert("Feil", "Ett eller flere påkrevde tekstfelt er tomme");
        }
    }

}
