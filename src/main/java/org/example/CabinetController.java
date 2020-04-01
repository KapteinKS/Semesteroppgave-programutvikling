package org.example;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import org.example.components.Cabinet;
import org.example.components.PowerSupply;

import java.io.IOException;

public class CabinetController {

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
    private TextField inWeght;

    @FXML
    private Button regButton;

    @FXML
    private Button cancelButten;

    @FXML
    void registerCabinet(ActionEvent event) throws IOException {


        // Get all parameters.
        String name = inName.getText();
        String manufacturer = inManufac.getText();
        String priceString = inPrice.getText();

        // try - Catch, input validation here!
        double price = Double.parseDouble(priceString);


        String heightString = inHeight.getText();
        int height = Integer.parseInt(heightString);

        String widthString = inWidth.getText();
        int width = Integer.parseInt(widthString);

        String depthString = inDepth.getText();
        int depth = Integer.parseInt(depthString);

        String weightString = inWeght.getText();
        double weight = Double.parseDouble(weightString);



        //Create new object
        Cabinet cab = new Cabinet(name, manufacturer, price, height, width, depth, weight);



        App.setRoot("componentCreator", 460, 360, "Component Creator");

    }

    @FXML
    void cancelRegistration(ActionEvent event) throws IOException {
        App.setRoot("componentCreator", 460, 360, "Component Creator");

    }
}
