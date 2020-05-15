package org.example;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import org.example.logicAndClasses.DialogueBoxes;
import org.example.logicAndClasses.Order;
import org.example.logicAndClasses.OrderCollection;

import java.io.IOException;

public class OrdersController {
    private OrderCollection orders = App.getOrderCollection();
    String out = "";

    @FXML
    private TextArea lblOrderList;

    @FXML
    void btnBackOrder(ActionEvent event) throws IOException {
        App.setRoot("user", 700, 640, "EndUser");
    }

    @FXML
    void btnOpenOrder(ActionEvent event) {
        String currentUserID = App.getCurrentUser().getUserID();
        //  Displays the current user's previous orders
        out = orders.printOrders(currentUserID);
        if (out.equals("")) {
            DialogueBoxes.alert("Feil!", "Du har ingen tidligere ordre!");
        } else {
            lblOrderList.setText("Ordrene til kunde: " + currentUserID + "" + "\n----------------------\n");
            lblOrderList.setText(out);
        }
    }

    @FXML
    void orderAbout(ActionEvent event) {
        DialogueBoxes.about("Dette GUIet viser tidligere ordre til den aktive kunden",
                "Trykk \"Åpne ordre\" for å åpne tidligere ordre, eller trykk \"Tilbake\" " +
                        "for å gå tilbake til bestillings GUIet");
    }
}

