package org.example;

import javafx.application.Application;
import javafx.collections.ObservableArray;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import org.example.componentClasses.Cabinet;
import org.example.logicAndClasses.ComponentCollection;
import org.example.logicAndClasses.Initializer;
import org.example.componentClasses.Component;

import java.io.IOException;

/**
 * JavaFX App
 */
public class App extends Application {


    private static Scene scene;
    private static Stage stage;
    private static Scene scene2;
    private static Stage stage2;

    private static ComponentCollection componentCollection = new ComponentCollection();
    private static Initializer init = new Initializer();    //By making a new Initializer-object, ...
            // ... we can keep our collections in memory, when the app is refreshed (I THINK)

    @Override
    public void start(Stage stage) throws IOException {

        //* COMBOBOX POPULATION *//

        // FXMLLoader loader = new FXMLLoader(getClass().getResource("user.fxml"));
        // UserController userController = loader.getController();
        // userController.populateComboBox();

        //**//

        //This initializer reads data, and sets up GUI.
        this.stage = stage;
        //
        init.initialize();
        //ComponentCollection componentCollection = init.readComponents();


        scene = new Scene(loadFXML("start"));
        System.out.print(".");
        stage.getIcons().add(new Image("https://icon2.cleanpng.com/20180501/wzq/kisspng-twitch-emote-pogchamp-trihex-video-game-5ae91c86178d89.3374632415252266300965.jpg"));
        stage.setScene(scene);

        stage.setTitle("Start");
        stage.show();
        System.out.print(".");
        System.out.print("\n\n---------------\n\n");

    }

    public void populateBoxes(){

    }

    public static void newWindow(String fxml) throws IOException{
        stage2 = new Stage();
        scene2 = new Scene(loadFXML(fxml));
        stage2.setScene(scene2);
        stage2.setTitle("Hællæ");
        stage2.show();
    }

    public static void changeSecondaryWindow(String fxml, double width, double height, String title) throws IOException {
        scene2.setRoot(loadFXML(fxml));
        stage2.setHeight(height);
        stage2.setWidth(width);
        stage2.setTitle(title);
    }

    public static void saveToCollection(Component component){
        componentCollection.add(component);
    }
    public static ObservableList<Component> getList(){
        return componentCollection.getComponentList();
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