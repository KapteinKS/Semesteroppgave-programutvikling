package org.example;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import org.example.componentClasses.Mouse;
import org.example.exceptions.ExceptionHandler;
import org.example.exceptions.IllegalButtonsException;
import org.example.exceptions.IllegalDPIException;
import org.example.exceptions.IllegalPriceException;

public class MouseController {
    private ExceptionHandler exHand = new ExceptionHandler();

    @FXML
    private TextField inManufac;

    @FXML
    private TextField inName;

    @FXML
    private TextField inPrice;

    @FXML
    private TextField inDPI;

    @FXML
    private TextField inConnection;

    @FXML
    private TextField inProgrammable;

    @FXML
    private Button regButton;

    @FXML
    private Button cancelButton;

    @FXML
    void cancel(ActionEvent event) {
        App.closeWindow();
    }

    @FXML
    void registerMouse(ActionEvent event) {
        if (!inName.getText().isEmpty() && inManufac.getText().isEmpty()){
            String name = inName.getText(), manufacturer = inManufac.getText(), connectionType = inConnection.getText();

            try {
                double price = exHand.priceCheck(Double.parseDouble(inPrice.getText()));
                int dpi = exHand.checkDPI(Integer.parseInt(inDPI.getText())),
                    programmableButtons = exHand.checkButtons(Integer.parseInt(inProgrammable.getText()));

                Mouse mouse = new Mouse(name, manufacturer, 0, price, dpi, connectionType, programmableButtons);

                App.saveToCollection(mouse);
                App.closeWindow();

            } catch (IllegalPriceException | IllegalDPIException | IllegalButtonsException e){
                System.err.println(e.getMessage());
            } catch (NumberFormatException n){
                System.err.println("Tallfelt kan ikke være tomme");
            }
        }
    }
}