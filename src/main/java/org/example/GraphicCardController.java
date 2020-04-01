package org.example;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import org.example.components.GraphicCard;

import java.io.IOException;

public class GraphicCardController {

    @FXML
    private TextField inName;

    @FXML
    private TextField inManufac;

    @FXML
    private TextField inPrice;

    @FXML
    private TextField inRAM;

    @FXML
    private TextField inType;

    @FXML
    private TextField inHertz;

    @FXML
    private Button regButton;

    @FXML
    private Button cancelButten;

    @FXML
    void cancelRegistration(ActionEvent event) throws IOException {
        App.setRoot("componentCreator", 460, 360, "Component Creator");
    }

    @FXML
    void registerGraphicCard(ActionEvent event) throws IOException {

        // Get all parameters.
        String name = inName.getText();
        String manufacturer = inManufac.getText();
        String priceString = inPrice.getText();

        // try - Catch, input validation here!
        Double price = Double.parseDouble(priceString);

        String ramString = inRAM.getText();
        int ram = Integer.parseInt(ramString);
        String type = inType.getText();
        String clockSpeed = inHertz.getText();

        //Create new object
        GraphicCard gc = new GraphicCard(name, manufacturer, price, ram, type, clockSpeed);


        //Save new object to our register.
            //  CODE  HERE  //

        // Should we have a running process, storing the Collection?
        // Otherwise, it's updated everytime we switch views?


        App.setRoot("componentCreator", 460, 360, "Component Creator");

    }

}
