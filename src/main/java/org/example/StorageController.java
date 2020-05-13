package org.example;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import org.example.exceptions.ExceptionHandler;
import org.example.exceptions.IllegalCapacityException;
import org.example.exceptions.IllegalPriceException;
import org.example.componentClasses.Storage;
import org.example.logicAndClasses.DialogueBoxes;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class StorageController implements Initializable {
    ExceptionHandler exHan = new ExceptionHandler();

    @FXML
    private TextField inName;

    @FXML
    private TextField inManufac;

    @FXML
    private TextField inPrice;

    @FXML
    private TextField inCapacity;

    @FXML
    private RadioButton radioGB;

    @FXML
    private RadioButton radioTB;

    @FXML
    private RadioButton radioHDD;

    @FXML
    private RadioButton radioSSD;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        final ToggleGroup CapacityGroup = new ToggleGroup();
        radioTB.setToggleGroup(CapacityGroup);
        radioGB.setToggleGroup(CapacityGroup);
        radioGB.setSelected(true);
        final ToggleGroup TypeGroup = new ToggleGroup();
        radioHDD.setToggleGroup(TypeGroup);
        radioSSD.setToggleGroup(TypeGroup);
        radioHDD.setSelected(true);
    }

    @FXML
    void cancelRegistration(ActionEvent event) throws IOException {
        App.closeWindow();
    }

    @FXML
    void regStorage(ActionEvent event) throws IOException {
        //  Checking that text inputs are not empty, number inputs validated within try block
        //  A component cannot be registered with any empty fields
        if (!inName.getText().isEmpty() && !inManufac.getText().isEmpty()) {
            String name = inName.getText(), manufacturer = inManufac.getText(), type = "", capacityType = "";
            //  Getting data from radio-selection (type and capacityType)
            if (radioSSD.isSelected()) {
                type = "SSD";
            } else if (radioHDD.isSelected()) {
                type = "HDD";
            }
            if (radioGB.isSelected()) {
                capacityType = "GB";
            } else if (radioTB.isSelected()) {
                capacityType = "TB";
            }
            //  Input validation
            try {
                double price = exHan.checkPrice(Double.parseDouble(inPrice.getText()));
                int capacity = exHan.checkStorage(Integer.parseInt(inCapacity.getText()), capacityType);
                //  Storing the new component, & exiting
                Storage storage = new Storage(name, manufacturer, price, type, capacity, capacityType);
                App.saveToCollection(storage);
                App.closeWindow();
            } catch (IllegalPriceException | IllegalCapacityException e) {
                DialogueBoxes.alert("Feil", e.getMessage());
            } catch (NumberFormatException n) {
                DialogueBoxes.alert("Feil", "Tallfelt kan ikke være tomme");
            }
        } else {
            DialogueBoxes.alert("Feil", "Ett eller flere påkrevde tekstfelt er tomme");
        }
    }
}
