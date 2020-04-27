package org.example;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import org.example.componentClasses.Cabinet;

import java.io.IOException;

public class CabinetController {

    @FXML
    private TextField inName;

    @FXML
    private TextField inManufac;

    @FXML
    private TextField inPrice;

    @FXML
    private TextField inFormFactor;

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

        String name = inName.getText(), manufacturer = inManufac.getText();

        //This needs some tests around it
        String formFactor = inFormFactor.getText();
        //

        try{
            double price = Double.parseDouble(inPrice.getText());
            int height = Integer.parseInt(inHeight.getText());
            int width = Integer.parseInt(inWidth.getText());
            int depth = Integer.parseInt(inDepth.getText());
            int weight = Integer.parseInt(inDepth.getText());
            Cabinet cabinet = new Cabinet(name, manufacturer, price, formFactor, height, width, depth, weight);
            App.saveToCollection(cabinet);

        } catch (Exception e){
            System.err.println(e.getMessage());
        }


        App.changeSecondaryWindow("componentCreator", 460, 360, "Component Creator");

    }

    @FXML
    void cancelRegistration(ActionEvent event) throws IOException {
        App.changeSecondaryWindow("componentCreator", 460, 360, "Component Creator");

    }
}
