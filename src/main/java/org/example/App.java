package org.example;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.concurrent.WorkerStateEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import org.example.componentClasses.*;
import org.example.io.ThreadHandler;
import org.example.io.WriteComponentsToFile;
import org.example.io.WriteUserToFile;
import org.example.logicAndClasses.*;

import java.io.IOException;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;
    private static Stage stage;
    private static Scene scene2 = null;
    private static Stage stage2;

    private static ComponentCollection componentCollection = new ComponentCollection();
    private static UserCollection userCollection = new UserCollection();
    private static OrderCollection orderCollection = new OrderCollection();
    private static String currentUserEmail;
    private static User currentUser;
    private ThreadHandler task;

    @Override
    public void start(Stage stage) throws IOException, InterruptedException {
        this.task = new ThreadHandler();
        Thread th = new Thread(this.task);
        this.task.setOnSucceeded(this::threadSucceeded);
        this.task.setOnFailed(this::threadFailed);
        th.start();

/*

        ReadUserFromFile.open(customerRegistry, Paths.get("orders.csv"));

        currentUserEmail = "admin@root.com";
*/

        //**//

        th.join();
        App.stage = stage;
        scene = new Scene(loadFXML("userLoginPrompt"));
        stage.getIcons().add(new Image("https://img.favpng.com/20/8/14/computer-cases-housings-cooler-master-power-supply-unit-atx-computex-taipei-png-favpng-2nqwuytRyJwBmVhkN7a2HyTsF.jpg"));
        stage.setScene(scene);
        stage.setTitle("Login");
        System.out.print("\n\n---------------\n\n");
        //DialogueBoxes.about("Hei", "For forhåndlagde innloggingalternativer og adminbruker sjekk README.md");

        //TESTS
        System.out.println(orderCollection.toString());
        System.out.println(userCollection.toString());
        System.out.println(orderCollection.printOrders("00001"));


    }

    private void threadSucceeded(WorkerStateEvent workerStateEvent) {
        stage.show();
    }

    private void threadFailed(WorkerStateEvent workerStateEvent) {
        try {
            resetLists();
            DialogueBoxes.alert("Error in thread", "Resetting lists");
            stage.show();
        } catch (IOException e){
            DialogueBoxes.alert("Could not reset lists", "Program ending");
        }
    }

    public static void newWindow(String fxml, String title) throws IOException{
        stage2 = new Stage();
        scene2 = new Scene(loadFXML(fxml));
        stage2.getIcons().add(new Image("https://img.favpng.com/20/8/14/computer-cases-housings-cooler-master-power-supply-unit-atx-computex-taipei-png-favpng-2nqwuytRyJwBmVhkN7a2HyTsF.jpg"));
        stage2.setScene(scene2);
        stage2.setTitle(title);
        stage2.show();
    }

    public static void saveToCollection(Component component) throws IOException {
        componentCollection.add(component);
        WriteComponentsToFile.save(componentCollection.getArrayList());
    }

    public static ObservableList<Component> getList(){
        return componentCollection.getComponentList();
    }

    public static ComponentCollection getList2(){
        return componentCollection;
    }

    public static void closeWindow(){
        if(stage2 != null) {
            stage2.close();
        }
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
    public static UserCollection getUserCollection(){
        return userCollection;
    }

    public static void saveToUserCollection(User user) throws IOException {
        userCollection.addUser(user);
        WriteUserToFile.save(userCollection.getUsers());
    }

    public static int getNewUserID(){
        return userCollection.getSize();
    }

    public static void setCurrentUser(User user){
        currentUser = user;
    }
    public static User getCurrentUser(){
        return currentUser;
    }

    public static void setCurrentUserEmail(String email){
        currentUserEmail = email;
    }

    public static void setUserCollection(UserCollection uc){
        userCollection = uc;
    }

    public static void setComponentCollection(ComponentCollection cc){
        componentCollection = cc;
    }

    public static ComponentCollection getComponentCollection(){
        return componentCollection;
    }

    public static void setOrderCollection(OrderCollection oc){
        orderCollection = oc;
    }

    public static OrderCollection getOrderCollection(){
        return orderCollection;
    }


    public static void removeComponent(Component c){
        componentCollection.remove(c);
    }

    public static void resetLists() throws IOException {
        componentCollection.removeAll();
        userCollection.removeAll();
        userCollection.addUser(new AdminUser("00000","Admin","Admin","Root 42","0000", "Root","00000000","admin@root.com","admin"));
        userCollection.addUser(new EndUser("00001","Ola","Nordmann","Adresseveien 1","0001", "Oslo","51515151","ola.nordmann@gmail.no","Norge123"));
        userCollection.addUser(new EndUser("00002", "Jenny", "Nordmann","Adresseveien 1", "0001","Oslo","15151515","jenny.nordmann@gmail.no","Passord123"));
        componentCollection.add(new Cabinet("BigBoyCab 3010","Corsair",900.00,"ATX",40,15,60,10.00));
        componentCollection.add(new Cabinet("Sleek 11","Asus",660.00,"M-ATX",30,15,30,4.25));
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
        componentCollection.add(new Keyboard("Huntsman", "Razer", 0, 1100, "Mechanical Green", "Nordic", "USB-A" ));
        componentCollection.add(new Monitor("27`` 4k LCD", "Acer", 0, 2400, 27, 144, 2, "LCD"));
        componentCollection.add(new Mouse("Naga", "Razer", 0, 899, 1600, "USB-A", 16));
        WriteComponentsToFile.save(componentCollection.getArrayList());
        WriteUserToFile.save(userCollection.getUsers());
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        launch();
    }

}