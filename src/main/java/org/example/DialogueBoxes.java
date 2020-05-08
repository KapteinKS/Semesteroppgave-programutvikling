package org.example;

import javafx.scene.control.Alert;

public class DialogueBoxes {
    public static void about(String header, String content){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("About");
        alert.setHeaderText(header);
        alert.setContentText(content);
        alert.setResizable(false);
        alert.showAndWait();
    }

    public static void alert(String header, String msg){
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Warning");
        alert.setHeaderText(header);
        alert.setContentText(msg);
        alert.setResizable(false);
        alert.showAndWait();
    }
}

