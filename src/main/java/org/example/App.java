package org.example;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import org.example.componentClasses.*;
import org.example.logicAndClasses.ComponentCollection;
import org.example.logicAndClasses.Initializer;
import org.example.componentClasses.*;

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

    @Override
    public void start(Stage stage) throws IOException, ClassNotFoundException {

        //*  SOME COMPONENTS  *//
/*
        componentCollection.add(new Cabinet("BigBoyCab 3010","Corsair",900.00,"ATX",400,150,600,10.00));
        componentCollection.add(new Cabinet("Sleek 11","Asus",660.00,"M-ATX",300,150,300,4.25));
        componentCollection.add(new GraphicCard ("Geforce RTX 2060","ASUS",100,5499.00,8,"DDR6",1605));
        componentCollection.add(new GraphicCard("Radeon RX 5500","Sapphire",200,3299.00,8,"DDR6",1300));
        componentCollection.add(new CPU("Core i7","Intel",100,5199.99,8,3.60, "LGA-1151"));
        componentCollection.add(new CPU("Core i5","Intel",100,3299.00, 8, 3.20, "LGA-1151"));
        componentCollection.add(new CPU("Ryzen 9 3900X", "AMD", 105,5190.00,24,3.80, "AM4"));
        componentCollection.add(new Fan("MasterFan SF242","Cooler Master", 499.99,120,59.25,30));
        componentCollection.add(new Fan("QuietMaster29", "BeQuiet", 799.00,140,32.5,20));
        componentCollection.add(new Motherboard("GigaZap 2000k","ASUS",500.00,1299.99,"ATX","LGA-1151","DDR3"));
        componentCollection.add(new Motherboard("MiniGigaZap 1500k", "ASUS", 350.00, 1099.99,"M-ATX","LGA-1151","DDR3"));
        componentCollection.add(new Motherboard("ZWXtreme 4242k","AMD",400.00,1100.00,"ATX","AM4","DDR4"));
        componentCollection.add(new PowerSupply("Focus GX 750","Seasonic",750.00,1499.00, 20, 20));
        componentCollection.add(new PowerSupply("RM650x","Corsair",650.00,1399.00, 20, 20));
        componentCollection.add(new PowerSupply("ZXZ1500", "Asus", 1500.00, 1799.00, 20, 20));
        componentCollection.add(new RAM("ValueRam","Kingston",635.00,8,"DDR3",1));
        componentCollection.add(new RAM("Vengance LPX", "Corsair", 1260.00, 16,"DDR4",2));
        componentCollection.add(new Storage("KC2000","Kingston",882.00,"SSD",250,"GB"));
        componentCollection.add(new Storage("Mobile Black", "WD",807.00,"HDD",1,"TB"));
*/

        componentCollection = Initializer.readComponents();

        App.stage = stage;
        Initializer.initialize();
        scene = new Scene(loadFXML("start"));
        System.out.print(".");
        stage.getIcons().add(new Image("https://img.favpng.com/20/8/14/computer-cases-housings-cooler-master-power-supply-unit-atx-computex-taipei-png-favpng-2nqwuytRyJwBmVhkN7a2HyTsF.jpg"));
        stage.setScene(scene);
        stage.setTitle("Start");
        stage.show();
        System.out.print(".");
        System.out.print("\n\n---------------\n\n");

        /* Old version of start(), for user-GUI
        FXMLLoader loader = new FXMLLoader(getClass().getResource("user.fxml"));
        Parent root = loader.load();

        UserController userController = loader.getController();
        userController.populateComboBoxes();


        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
         */

    }

    public static void newWindow(String fxml, String title) throws IOException{
        stage2 = new Stage();
        scene2 = new Scene(loadFXML(fxml));
        stage2.getIcons().add(new Image("https://img.favpng.com/20/8/14/computer-cases-housings-cooler-master-power-supply-unit-atx-computex-taipei-png-favpng-2nqwuytRyJwBmVhkN7a2HyTsF.jpg"));
        stage2.setScene(scene2);
        stage2.setTitle(title);
        stage2.show();
    }

    public static void changeSecondaryWindow(String fxml, double width, double height, String title) throws IOException{
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

    // This is something funky, I just added it to remove errors, see Admin @ line 120
    public static ComponentCollection getList2(){
        return componentCollection;
    }
    //

    public static ComponentCollection getComponentCollection(){
        return componentCollection;
    }

    public static void closeWindow(){
        stage2.close();
    }
    public static void setRoot(String fxml, double width, double height, String title) throws IOException {
        //if user, comboBoxes must be populated!
        if (fxml.equals("user")){
            FXMLLoader loader = new FXMLLoader(App.class.getResource("user.fxml"));
            Parent userRoot = loader.load();

            UserController userController = loader.getController();
            userController.populateComboBoxes();

            scene.setRoot(userRoot);
            stage.setHeight(height);
            stage.setWidth(width);
            stage.setTitle(title);

        }
        else {
            scene.setRoot(loadFXML(fxml));
            stage.setHeight(height);
            stage.setWidth(width);
            stage.setTitle(title);
        }
    }

    /* Never used?
    public static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }
     */

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        launch();
    }

}