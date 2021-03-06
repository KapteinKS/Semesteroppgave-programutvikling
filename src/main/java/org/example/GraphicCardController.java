package org.example;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import org.example.exceptions.*;
import org.example.componentClasses.GraphicCard;
import org.example.logicAndClasses.DialogueBoxes;

import java.io.IOException;

public class GraphicCardController {
    ExceptionHandler exHan = new ExceptionHandler();

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
    private TextField inWatts;

    @FXML
    void cancelRegistration(ActionEvent event) throws IOException {
        App.closeWindow();
    }

    @FXML
    void registerGraphicCard(ActionEvent event) throws IOException {
        //  Checking that text inputs are not empty, number inputs validated within try block
        //  A component cannot be registered with any empty fields
        if (!inName.getText().isEmpty() && !inManufac.getText().isEmpty() && !inType.getText().isEmpty()) {
            String name = inName.getText(),
                    manufacturer = inManufac.getText(),
                    ramType = inType.getText();
            //  Input validation
            try {
                double wattsRequired = exHan.checkWatts(Double.parseDouble(inWatts.getText()));
                double price = exHan.checkPrice(Double.parseDouble(inPrice.getText()));
                int ram = exHan.checkRAM(Integer.parseInt(inRAM.getText()));
                double clockspeed = exHan.checkClockSpeed(Double.parseDouble(inHertz.getText()));
                //  Storing the new component, & exiting
                GraphicCard graphicCard = new GraphicCard(name, manufacturer, wattsRequired, price, ram, ramType, clockspeed);
                App.saveToCollection(graphicCard);
                App.closeWindow();
            } catch(IllegalRAMException | IllegalPriceException | IllegalWattsException | IllegalClockSpeedException e){
                DialogueBoxes.alert("Feil", e.getMessage());
            } catch (NumberFormatException n) {
                DialogueBoxes.alert("Feil", "Tallfelt kan ikke være tomme");
            }
        } else {
            DialogueBoxes.alert("Feil", "Ett eller flere påkrevde tekstfelt er tomme");
        }
    }
}
