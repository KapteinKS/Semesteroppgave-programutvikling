package org.example;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.example.Deeper.Initializer;

import java.io.IOException;

/**
 * JavaFX App
 */
public class App extends Application {


    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
        //This initializer reads data, and sets up GUI.
        Initializer.initialize();
        scene = new Scene(loadFXML("start"));
        System.out.print(".");
        stage.setScene(scene);
        stage.show();
        System.out.print(".");
        System.out.print("\n\n---------------\n\n");

    }

    public static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        launch();
    }

}