package org.example;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import org.example.logicAndClasses.DialogueBoxes;

import java.io.IOException;

public class OrdersController {

    @FXML
    private Label lblOrderList;

    @FXML
    void btnBackOrder(ActionEvent event) throws IOException {
        App.setRoot("user", 700, 640, "EndUser");
    }

    @FXML
    void btnOpenOrder(ActionEvent event) {

    }

    @FXML
    void orderAbout(ActionEvent event) {
        DialogueBoxes.about("This GUI will show you your previous orders",
                "Press \"Open orders\" to open previous orders or press \"Back\" to go back to the ordering GUI");
    }

}

