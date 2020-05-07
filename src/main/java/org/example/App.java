package org.example;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import org.example.componentClasses.*;
import org.example.io.ReadCustomerFromFile;
import org.example.io.WriteCustomerToFile;
import org.example.logicAndClasses.ComponentCollection;
import org.example.logicAndClasses.Customer;
import org.example.logicAndClasses.CustomerCollection;
import org.example.logicAndClasses.Initializer;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * JavaFX App
 */
public class App extends Application {


    private static Scene scene;
    private static Stage stage;
    private static Scene scene2;
    private static Stage stage2;

    private static ComponentCollection componentCollection = new ComponentCollection(); //These must be filled
    private static CustomerCollection customerRegistry = new CustomerCollection(); //These must be filled
    private static String currentUserEmail;

    @Override
    public void start(Stage stage) throws IOException {

        //*  SOME COMPONENTS  *//
        Cabinet cab1 = new Cabinet("BigBoyCab 3010","Corsair",900.00,"ATX",400,150,600,10.00);
        Cabinet cab2 = new Cabinet("Sleek 11","Asus",660.00,"M-ATX",300,150,300,4.25);
        GraphicCard gpu1 = new GraphicCard ("Geforce RTX 2060","ASUS",100,5499.00,8,"DDR6","1605");
        GraphicCard gpu2 = new GraphicCard("Radeon RX 5500","Sapphire",200,3299.00,8,"DDR6","1300");
        CPU cpu1 = new CPU("Core i7","Intel",100,5199.99,8,3.60, "LGA-1151");
        CPU cpu2 = new CPU("Core i5","Intel",100,3299.00, 8, 3.20, "LGA-1151");
        CPU cpu3 = new CPU("Ryzen 9 3900X", "AMD", 105,5190.00,24,3.80, "AM4");
        Fan fan1 = new Fan("MasterFan SF242","Cooler Master", 499.99,120,59.25,30);
        Fan fan2 = new Fan("QuietMaster29", "BeQuiet", 799.00,140,32.5,20);
        Motherboard mb1 = new Motherboard("GigaZap 2000k","ASUS",500.00,1299.99,"ATX","LGA-1151","DDR3");
        Motherboard mb2 = new Motherboard("MiniGigaZap 1500k", "ASUS", 350.00, 1099.99,"M-ATX","LGA-1151","DDR3");
        Motherboard mb3 = new Motherboard("ZWXtreme 4242k","AMD",400.00,1100.00,"ATX","AM4","DDR4");
        PowerSupply psu1 = new PowerSupply("Focus GX 750","Seasonic",750.00,1499.00, 20, 20);
        PowerSupply psu2 = new PowerSupply("RM650x","Corsair",650.00,1399.00, 20, 20);
        PowerSupply psu3 = new PowerSupply("ZXZ1500", "Asus", 1500.00, 1799.00, 20, 20);
        RAM ram1 = new RAM("ValueRam","Kingston",635.00,"8 GB","DDR3",1);
        RAM ram2 = new RAM("Vengance LPX", "Corsair", 1260.00, "16 GB","DDR4",2);
        Storage stg1 = new Storage("KC2000","Kingston",882.00,"SSD",250,"GB");
        Storage stg2 = new Storage("Mobile Black", "WD",807.00,"HDD",1,"TB");

        componentCollection.add(cab1);
        componentCollection.add(cab2);
        componentCollection.add(gpu1);
        componentCollection.add(gpu2);
        componentCollection.add(cpu1);
        componentCollection.add(cpu2);
        componentCollection.add(cpu3);
        componentCollection.add(fan1);
        componentCollection.add(fan2);
        componentCollection.add(mb1);
        componentCollection.add(mb2);
        componentCollection.add(mb3);
        componentCollection.add(psu1);
        componentCollection.add(psu2);
        componentCollection.add(psu3);
        componentCollection.add(ram1);
        componentCollection.add(ram2);
        componentCollection.add(stg1);
        componentCollection.add(stg2);

        //**//

        // We need to read data from files here.
        // We must remember to do file-management in new task

        //ReadCustomerFromFile.open(customerRegistry, Paths.get("customers.txt"));
        customerRegistry.addCustomer(new Customer("00000","Admin","Admin","Root 42","0000", "Root","00000000","admin@root.com","hex92"));
        customerRegistry.addCustomer(new Customer("00001","Ola","Nordmann","Adresseveien 1","0001", "Oslo","51515151","ola.nordmann@gmail.no","Norge123"));

        //WriteCustomerToFile.save(customerRegistry, Paths.get("customers.txt"));

        currentUserEmail = "admin@root.com";


        //**//

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

    //CustomerCollection stuff
    public static CustomerCollection getCustomerRegistry(){
        return customerRegistry;
    }

    public static void saveToCustomerCollection(Customer customer){
        customerRegistry.addCustomer(customer);
    }

    public static int getNewCustomerID(){
        return customerRegistry.getSize();
    }

    public static void setCurrentUserEmail(String email){
        currentUserEmail = email;
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