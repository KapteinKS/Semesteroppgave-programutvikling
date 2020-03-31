package org.example;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import java.io.IOException;

public class StartController {


    @FXML
    void switchToAdmin(ActionEvent event) throws IOException {
        App.setRoot("admin", 500, 450);
    }

    @FXML
    void switchToCustomer(ActionEvent event) throws IOException {
        App.setRoot("user");
    }

}
