package org.example;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import org.example.exceptions.*;
import org.example.componentClasses.GraphicCard;

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
    private Button regButton;

    @FXML
    private Button cancelButton;

    @FXML
    void cancelRegistration(ActionEvent event) throws IOException {
        App.closeWindow();
    }

    @FXML
    void registerGraphicCard(ActionEvent event) throws IOException {
        if (!inName.getText().isEmpty() && !inManufac.getText().isEmpty() && !inType.getText().isEmpty()) {
            String name = inName.getText(),
                    manufacturer = inManufac.getText(),
                    ramType = inType.getText();
            try {

                double wattsRequired = exHan.checkWatts(Double.parseDouble(inWatts.getText()));
                double price = exHan.priceCheck(Double.parseDouble(inPrice.getText()));
                int ram = exHan.checkRAM(Integer.parseInt(inRAM.getText())),
                        clockspeed = exHan.checkClockSpeed(Integer.parseInt(inHertz.getText()));
                GraphicCard graphicCard = new GraphicCard(name, manufacturer, wattsRequired, price, ram, ramType, clockspeed);
                App.saveToCollection(graphicCard);

                App.closeWindow();

            } catch(IllegalRAMException | IllegalPriceException | IllegalWattsException | IllegalClockSpeedException e){
                System.err.println(e.getMessage());
            } catch (NumberFormatException n){
                System.err.println("Tallfelt kan ikke være tomme");
            }
        } else {
            System.err.println("Ett eller flere påkrevde tekstfelt er tomme");
        }
    }
}
