package org.example;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import org.example.componentClasses.Keyboard;
import org.example.exceptions.ExceptionHandler;
import org.example.exceptions.IllegalPriceException;
import org.example.logicAndClasses.DialogueBoxes;

import java.io.IOException;

public class KeyboardController {
    private ExceptionHandler exHand = new ExceptionHandler();

    @FXML
    private TextField inManufac;

    @FXML
    private TextField inName;

    @FXML
    private TextField inPrice;

    @FXML
    private TextField inSwitches;

    @FXML
    private TextField inLanguage;

    @FXML
    private TextField inConnection;

    @FXML
    void cancel(ActionEvent event) {
        App.closeWindow();
    }

    @FXML
    void registerKeyboard(ActionEvent event) throws IOException {
        //  Checking that input is not empty
        if(!inName.getText().isEmpty() && !inManufac.getText().isEmpty() && !inSwitches.getText().isEmpty()
            && !inLanguage.getText().isEmpty() && !inConnection.getText().isEmpty()) {
            String name = inName.getText(), manufacturer = inManufac.getText(),
            switches = inSwitches.getText(), language = inLanguage.getText(),
            connectionType = inConnection.getText();
            //  Input validation
            try {
                double price = exHand.checkPrice(Double.parseDouble(inPrice.getText()));
                //  Storing the new component, & exiting
                Keyboard keyboard = new Keyboard(name, manufacturer, 0, price, switches, language, connectionType);
                App.saveToCollection(keyboard);
                App.closeWindow();
            } catch (IllegalPriceException e){
                DialogueBoxes.alert("Feil", e.getMessage());
            } catch (NumberFormatException n) {
                DialogueBoxes.alert("Feil", "Tallfelt kan ikke være tomme");
            }
        } else {
            DialogueBoxes.alert("Feil", "Ett eller flere påkrevde tekstfelt er tomme");
        }
    }
}
