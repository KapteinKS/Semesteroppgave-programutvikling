package org.example.logicAndClasses;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

import java.util.Optional;
//  Container-class for all dialog-boxes / prompts
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

    public static boolean confirm(String header, String msg){
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Caution");
        alert.setHeaderText(header);
        alert.setContentText(msg);
        alert.setResizable(false);
        Optional<ButtonType> confirm = alert.showAndWait();
        ButtonType click = confirm.orElse(ButtonType.CANCEL);
        if (click == ButtonType.OK) {
            return true;
        }
        return false;
    }
    public static boolean confirm(String title, String header, String msg){
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle(title);
        alert.setHeaderText(header);
        alert.setContentText(msg);
        alert.setResizable(false);
        Optional<ButtonType> confirm = alert.showAndWait();
        ButtonType click = confirm.orElse(ButtonType.CANCEL);
        if (click == ButtonType.OK) {
            return true;
        }
        return false;
    }
    public static void information(String title, String header, String text){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(header);
        alert.setContentText(text);
        alert.showAndWait();
    }
}

