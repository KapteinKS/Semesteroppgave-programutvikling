package org.example;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import org.example.componentClasses.Storage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class StorageController implements Initializable {

    @FXML
    private TextField inName;

    @FXML
    private TextField inManufac;

    @FXML
    private TextField inPrice;

    @FXML
    private TextField inType;

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

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        final ToggleGroup group = new ToggleGroup();
        radioTB.setToggleGroup(group);
        radioGB.setToggleGroup(group);
    }

    @FXML
    void cancelRegistration(ActionEvent event) throws IOException {
        App.changeSecondaryWindow("componentCreator", 460, 360, "Component Creator");
    }

    @FXML
    void regStorage(ActionEvent event) throws IOException {
        String name = inName.getText(), manufacturer = inManufac.getText(), type = inType.getText(), capacityType = "";
        if(radioGB.isSelected()){
            capacityType = "GB";
        }   else if (radioTB.isSelected()) {
            capacityType = "TB";
        }
            try {
                double price = Double.parseDouble(inPrice.getText());
                int capacity = Integer.parseInt(inCapacity.getText());
                Storage storage = new Storage(name, manufacturer, price, type, capacity, capacityType);
                App.saveToCollection(storage);
            } catch (Exception e){
                System.err.println(e.getMessage());
            }
        App.changeSecondaryWindow("componentCreator", 460, 360, "Component Creator");

    }
}
