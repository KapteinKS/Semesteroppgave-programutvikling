package org.example;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import org.example.Exceptions.ExceptionHandler;
import org.example.Exceptions.IllegalCapacityException;
import org.example.Exceptions.IllegalPriceException;
import org.example.components.Storage;

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
    private Button regButton;

    @FXML
    private Button cancelButton;

    @FXML
    private RadioButton radioHDD;

    @FXML
    private RadioButton radioSSD;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        final ToggleGroup CapacityGroup = new ToggleGroup();
        radioTB.setToggleGroup(CapacityGroup);
        radioGB.setToggleGroup(CapacityGroup);
        final ToggleGroup TypeGroup = new ToggleGroup();
        radioHDD.setToggleGroup(TypeGroup);
        radioSSD.setToggleGroup(TypeGroup);
    }

    @FXML
    void cancelRegistration(ActionEvent event) throws IOException {
        App.closeWindow();
    }

    @FXML
    void regStorage(ActionEvent event) throws IOException {
        if (!inName.getText().isEmpty() && !inManufac.getText().isEmpty()) {
            String name = inName.getText(), manufacturer = inManufac.getText(), type = "", capacityType = "";
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
            try {
                double price = exHan.priceCheck(Double.parseDouble(inPrice.getText()));
                int capacity = exHan.checkStorage(Integer.parseInt(inCapacity.getText()), capacityType);
                Storage storage = new Storage(name, manufacturer, price, type, capacity, capacityType);
                App.saveToCollection(storage);
                App.closeWindow();
            } catch (NumberFormatException n){
                System.err.println("Tallfelt kan ikke være tomme");
            } catch (IllegalPriceException | IllegalCapacityException e) {
                System.err.println(e.getMessage());
            }
        }

    }
}
