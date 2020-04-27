package org.example;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import org.example.Deeper.ComponentCollection;
import org.example.Deeper.Initializer;
import org.example.components.*;

import java.io.IOException;
import java.util.Collection;

/**
 * JavaFX App
 */
public class App extends Application {


    private static Scene scene;
    private static Stage stage;
    private static Scene scene2;
    private static Stage stage2;
    private static ComponentCollection collection = new ComponentCollection();

    @Override
    public void start(Stage stage) throws IOException {
        //This initializer reads data, and sets up GUI.
        this.stage = stage;
        Initializer.initialize();
        scene = new Scene(loadFXML("start"));
        System.out.print(".");
        stage.getIcons().add(new Image("https://icon2.cleanpng.com/20180501/wzq/kisspng-twitch-emote-pogchamp-trihex-video-game-5ae91c86178d89.3374632415252266300965.jpg"));
        stage.setScene(scene);
        stage.setTitle("Start");
        stage.show();
        System.out.print(".");
        System.out.print("\n\n---------------\n\n");

    }

    public static void newWindow(String fxml) throws IOException{
        stage2 = new Stage();
        scene2 = new Scene(loadFXML(fxml));
        stage2.setScene(scene2);
        stage2.setTitle("Hællæ");
        stage2.show();
    }

    /*
    public static void changeSecondaryWindow(String fxml, double width, double height, String title) throws IOException {
        scene2.setRoot(loadFXML(fxml));
        stage2.setHeight(height);
        stage2.setWidth(width);
        stage2.setTitle(title);
    }

     */

    public static void saveToCollection(Component component){
        collection.add(component);
    }

    public static ComponentCollection getList(){
        return collection;
    }

    public static void closeWindow(){
        stage2.close();
    }
    public static void setRoot(String fxml, double width, double height, String title) throws IOException {
        scene.setRoot(loadFXML(fxml));
        stage.setHeight(height);
        stage.setWidth(width);
        stage.setTitle(title);
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