package org.example;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import org.example.logicAndClasses.DialogueBoxes;
import org.example.logicAndClasses.Order;
import org.example.logicAndClasses.OrderCollection;

import java.io.IOException;

public class OrdersController {
    private ObservableList <OrderCollection> orders = FXCollections.observableArrayList();
    String out = "";

    @FXML
    private Label lblOrderList;

    @FXML
    void btnBackOrder(ActionEvent event) throws IOException {
        App.setRoot("user", 700, 640, "EndUser");
    }

    @FXML
    void btnOpenOrder(ActionEvent event) {
        String currentUserID = App.getCurrentUser().getUserID();
        for (OrderCollection order : orders) {
            out += order.printOrders(currentUserID);
        }
        if (out.equals("")) {
            DialogueBoxes.alert("Feil!", "Du har ingen tidligere ordre!");
        } else {
            lblOrderList.setText(out);
        }
    }

    @FXML
    void orderAbout(ActionEvent event) {
        DialogueBoxes.about("This GUI will show you your previous orders",
                "Press \"Open orders\" to open previous orders or press \"Back\" to go back to the ordering GUI");
    }

}

