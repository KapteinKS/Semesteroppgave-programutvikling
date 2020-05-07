package org.example;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import org.example.componentClasses.Keyboard;
import org.example.exceptions.ExceptionHandler;
import org.example.exceptions.IllegalPriceException;

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
    private Button regButton;

    @FXML
    private Button cancelButton;

    @FXML
    void cancel(ActionEvent event) {
        App.closeWindow();
    }

    @FXML
    void registerKeyboard(ActionEvent event) {
        if(!inName.getText().isEmpty() && !inManufac.getText().isEmpty() && !inSwitches.getText().isEmpty()
            && !inLanguage.getText().isEmpty() && !inConnection.getText().isEmpty()) {
            String name = inName.getText(), manufacturer = inManufac.getText(),
            switches = inSwitches.getText(), language = inLanguage.getText(),
            connectionType = inConnection.getText();

            try {
                Double price = exHand.priceCheck(Double.parseDouble(inPrice.getText()));

                Keyboard keyboard = new Keyboard(name, manufacturer, 0, price, switches, language, connectionType);

                App.saveToCollection(keyboard);
                App.closeWindow();

            } catch (IllegalPriceException e){
                System.err.println(e.getMessage());
            } catch (NumberFormatException n){
                System.err.println("Tallfelt kan ikke være tomme");
            }
        } else {
            System.err.println("Ett eller flere påkrevde tekstfelt er tomme");
        }
    }

}
