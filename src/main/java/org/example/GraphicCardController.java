package org.example;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import org.example.components.Cabinet;
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
    private Button cancelButton;

    @FXML
    void cancelRegistration(ActionEvent event) throws IOException {
        App.changeSecondaryWindow("componentCreator", 460, 360, "Component Creator");

    }

    @FXML
    void registerGraphicCard(ActionEvent event) throws IOException {

        String name = inName.getText(), manufacturer = inManufac.getText(),
            ramType = inType.getText(), clockspeed = inHertz.getText();
        try{
            double price = Double.parseDouble(inPrice.getText());
            int ram = Integer.parseInt(inRAM.getText());
            GraphicCard graphicCard = new GraphicCard(name, manufacturer, price, ram, ramType, clockspeed);
            App.saveToCollection(graphicCard);
        } catch (Exception e){
            System.err.println(e.getMessage());
        }

        App.changeSecondaryWindow("componentCreator", 460, 360, "Component Creator");

    }

}
