package org.example;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.WorkerStateEvent;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import org.example.componentClasses.*;
import org.example.io.ThreadHandler;
import org.example.io.WriteOrderToFile;
import org.example.logicAndClasses.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;

public class UserController {

	private static ComponentCollection componentCollection = App.getComponentCollection();
	private static OrderCollection orderCollection = App.getOrderCollection();
	private static UserCollection userCollection = App.getUserCollection();
	private static User currentUser = App.getCurrentUser();
	private ObservableList<Component> currentSelectedList;
	private double totalPrice;
	private boolean buildIsCompatible;
	private ThreadHandler task;


	@FXML
	public ComboBox<String> cbCabinet;

	@FXML
	public ComboBox<String> cbMotherboard;

	@FXML
	public ComboBox<String> cbCPU;

	@FXML
	public ComboBox<String> cbGPU1;

	@FXML
	public ComboBox<String> cbGPU2;

	@FXML
	public ComboBox<String> cbRAM1;

	@FXML
	public ComboBox<String> cbRAM2;

	@FXML
	public ComboBox<String> cbStorage1;

	@FXML
	public ComboBox<String> cbStorage2;

	@FXML
	public ComboBox<String> cbPSU;

	@FXML
	public ComboBox<String> cbFan1;

	@FXML
	public ComboBox<String> cbFan2;

	@FXML
	public ComboBox<String> cbMonitor;

	@FXML
	public ComboBox<String> cbTastatur;

	@FXML
	public ComboBox<String> cbMus;

	@FXML
	private TextArea txtPreview;

	@FXML
	private Button btnPlaceOrder;

	@FXML
	private Button btnAnalyzeOrder;


	@FXML
	void loginAdmin(ActionEvent event) throws IOException {

		if(!(App.getCurrentUser() instanceof AdminUser)){
			DialogueBoxes.information("Access denied", "Admin access required", "You are trying to access a restricted feature. " +
					"Please provide admin login credentials");
			App.newWindow("userLoginPrompt", "Login");
		} else {
			App.setRoot("admin", 625, 525, "Admin");
		}
	}
	@FXML
	ObservableList<Component> analyzeOrder(ActionEvent event){

		ObservableList<Component> listOfSelected = FXCollections.observableArrayList();
		buildIsCompatible = false;
		txtPreview.setText("");

		//We build a string 'result', that adds all error-messages together
		String result = "";
		String cab = cbCabinet.getSelectionModel().getSelectedItem(),
				mb = cbMotherboard.getSelectionModel().getSelectedItem(),
				cpu = cbCPU.getSelectionModel().getSelectedItem(),
				gpu1 = cbGPU1.getSelectionModel().getSelectedItem(),
				gpu2 = cbGPU2.getSelectionModel().getSelectedItem(),
				ram1 = cbRAM1.getSelectionModel().getSelectedItem(),
				ram2 = cbRAM2.getSelectionModel().getSelectedItem(),
				strg1 = cbStorage1.getSelectionModel().getSelectedItem(),
				strg2 = cbStorage2.getSelectionModel().getSelectedItem(),
				psu = cbPSU.getSelectionModel().getSelectedItem(),
				fan1 = cbFan1.getSelectionModel().getSelectedItem(),
				fan2 = cbFan2.getSelectionModel().getSelectedItem(),
				monitor = cbMonitor.getSelectionModel().getSelectedItem(),
				tastatur = cbTastatur.getSelectionModel().getSelectedItem(),
				mus = cbMus.getSelectionModel().getSelectedItem();

		//These try-blocks attempt to check compatibility between (some) components
		try {
			result += Checker.checkMotherboardAndCabinet(componentCollection.getComponentByDisplayString(mb),componentCollection.getComponentByDisplayString(cab));
		} catch (Exception e){}
		try {
			result += Checker.checkMotherboardAndRAM(componentCollection.getComponentByDisplayString(mb), componentCollection.getComponentByDisplayString(ram1));
		} catch (Exception e){}
		try {
			result += Checker.checkMotherboardAndRAM(componentCollection.getComponentByDisplayString(mb), componentCollection.getComponentByDisplayString(ram2));
		} catch (Exception e){}
		try {
			result += Checker.checkMotherboardAndCPU(componentCollection.getComponentByDisplayString(mb), componentCollection.getComponentByDisplayString(cpu));
		} catch (Exception e){}

		// These if-blocks add components if they are selected.
		if (!(cab.equals("---"))){
			listOfSelected.add(componentCollection.getComponentByDisplayString(cab));
		}
		if (!(mb.equals("---"))){
			listOfSelected.add(componentCollection.getComponentByDisplayString(mb));
		}
		if (!(ram1.equals("---"))){
			listOfSelected.add(componentCollection.getComponentByDisplayString(ram1));
		}
		if (!(ram2.equals("---"))){
			listOfSelected.add(componentCollection.getComponentByDisplayString(ram2));
		}
		if (!(cpu.equals("---"))){
			listOfSelected.add(componentCollection.getComponentByDisplayString(cpu));
		}
		if (!(gpu1.equals("---"))){
			listOfSelected.add(componentCollection.getComponentByDisplayString(gpu1));
		}
		if (!(gpu2.equals("---"))){
			listOfSelected.add(componentCollection.getComponentByDisplayString(gpu2));
		}
		if (!(strg1.equals("---"))){
			listOfSelected.add(componentCollection.getComponentByDisplayString(strg1));
		}
		if (!(strg2.equals("---"))){
			listOfSelected.add(componentCollection.getComponentByDisplayString(strg2));
		}
		if (!(psu.equals("---"))){
			listOfSelected.add(componentCollection.getComponentByDisplayString(psu));
		}
		if (!(fan1.equals("---"))){
			listOfSelected.add(componentCollection.getComponentByDisplayString(fan1));
		}
		if (!(fan2.equals("---"))){
			listOfSelected.add(componentCollection.getComponentByDisplayString(fan2));
		}

		//Checking voltage for main build (meaning extra-components are ignored)
		double wattsUsed = Checker.summarizeWatts(listOfSelected);
		try{
			double wattsDelivered = componentCollection.getComponentByDisplayString(psu).getWattsRequired();
			if(wattsUsed > wattsDelivered){
				result += "Not enough power for selected components: "
						+ "\nPSU-watts: " + wattsDelivered + "\nWatts used in total: " + wattsUsed
						+ "\n--------------------\n";
			}
		}catch (Exception e) {}

		//Extras don't count to voltage
		if (!(monitor.equals("---"))){
			listOfSelected.add(componentCollection.getComponentByDisplayString(cbMonitor.getSelectionModel().getSelectedItem()));
		}
		if (!(tastatur.equals("---"))){
			listOfSelected.add(componentCollection.getComponentByDisplayString(cbTastatur.getSelectionModel().getSelectedItem()));
		}
		if (!(mus.equals("---"))){
			listOfSelected.add(componentCollection.getComponentByDisplayString(cbMus.getSelectionModel().getSelectedItem()));
		}

		totalPrice = Checker.summarizePrice(listOfSelected);

		// We use the built 'result' String as a way to check if there are no incompatibilities,
		// if it's empty, that means there were no incompatibilities.
		if (result.equals("")){
			result += "Build is compatible!" + "\n--------------------\n";
			buildIsCompatible = true;
		}

		result += "Watts used: " + wattsUsed + "\nTotal Price: " + String.format("%.2f", totalPrice) + " NOK";

		txtPreview.setText(result);
		return listOfSelected;
	}

	@FXML
	void placeOrder(ActionEvent event) throws IOException {
		currentSelectedList = analyzeOrder(event);
		int size;
		try{
			size = currentSelectedList.size();
		}catch (Exception e){
			size = 0;
			txtPreview.setText("");
		}
		if(size == 0){
			DialogueBoxes.information("Error!","Empty order!","You cannot place an empty order!\nBuy something, will ya?");

		}
		else{
			boolean bufferBuildIsCompatible = false;
			String promptTitle = "ERROR";
			String promptHeader = "ERROR";
			String promptText = "ERROR";

			if (txtPreview.getText().equals("") || buildIsCompatible){ // I think the error is here.
				analyzeOrder(event);
				bufferBuildIsCompatible = buildIsCompatible;
			}

			if (bufferBuildIsCompatible) {
				promptTitle = "Success!";
				promptHeader = "Build is compatible!";
				promptText = "Place order?";
			}
			else{
				promptTitle = "Warning!";
				promptHeader = "WARNING!\nBuild has incompabilities, things might not add together!";
				promptText = "Do you still wish to place the order?";
			}

			if (DialogueBoxes.confirm(promptTitle, promptHeader, promptText)){
				//SAVE ORDER METHOD; ORDER PLACE LOGIC

				String userID = currentUser.getUserID();
				String orderID = String.format("%06d", orderCollection.size()); //Formating the int.

				ArrayList<String> myList= new ArrayList<>();
				for(Component component : currentSelectedList){
					myList.add(component.displayComponent());
				}

				Order order = new Order(userID, orderID, "" + Calendar.getInstance().getTime(),
						myList, totalPrice);

				orderCollection.addOrder(order);
				WriteOrderToFile.save(orderCollection);

				//  App update
				App.setOrderCollection(orderCollection);


				DialogueBoxes.information("Success!",
						"Order has been placed!\nThank you for your purchase!\nOrder info below:",
						"" + order.printOrder());
				resetSelection(event);
			}
			txtPreview.setText("");
		}
	}

	@FXML
	void resetSelection(ActionEvent event) {
		cbCabinet.getSelectionModel().selectLast();
		cbMotherboard.getSelectionModel().selectLast();
		cbCPU.getSelectionModel().selectLast();
		cbGPU1.getSelectionModel().selectLast();
		cbGPU2.getSelectionModel().selectLast();
		cbRAM1.getSelectionModel().selectLast();
		cbRAM2.getSelectionModel().selectLast();
		cbStorage1.getSelectionModel().selectLast();
		cbStorage2.getSelectionModel().selectLast();
		cbPSU.getSelectionModel().selectLast();
		cbFan1.getSelectionModel().selectLast();
		cbFan2.getSelectionModel().selectLast();
		cbMonitor.getSelectionModel().selectLast();
		cbTastatur.getSelectionModel().selectLast();
		cbMus.getSelectionModel().selectLast();
	}

	@FXML
	void showAbout(ActionEvent event) {
		DialogueBoxes.about("This GUI allows customers to configure a custom PC, and place orders",
				"Choose components from the drop downs and choose \"Analyser Build\" to see" +
						" compatibility and price of the computer.\n" +
						"You can also switch to the Admin GUI by clicking \"Help\" -> \"Admin\".");
	}
	public void populateComboBoxes(){

		populateSingleComboBox(cbCabinet,"Cabinet", componentCollection);
		populateSingleComboBox(cbMotherboard,"Motherboard", componentCollection);
		populateSingleComboBox(cbCPU, "CPU", componentCollection);
		populateSingleComboBox(cbGPU1, "GraphicCard", componentCollection);
		populateSingleComboBox(cbGPU2, "GraphicCard", componentCollection);
		populateSingleComboBox(cbRAM1, "RAM", componentCollection);
		populateSingleComboBox(cbRAM2, "RAM", componentCollection);
		populateSingleComboBox(cbStorage1, "Storage", componentCollection);
		populateSingleComboBox(cbStorage2, "Storage", componentCollection);
		populateSingleComboBox(cbPSU, "PowerSupply", componentCollection);
		populateSingleComboBox(cbFan1, "Fan", componentCollection);
		populateSingleComboBox(cbFan2, "Fan", componentCollection);
		populateSingleComboBox(cbMonitor, "Monitor", componentCollection);
		populateSingleComboBox(cbTastatur, "Keyboard", componentCollection);
		populateSingleComboBox(cbMus, "Mouse", componentCollection);

	}

	//Method for populating a selected comboBox (only used here)
	private void populateSingleComboBox(ComboBox<String> comboBox, String filterInput, ComponentCollection componentCollection){
		comboBox.getItems().clear();
		if(filterInput.equals("None")){
			comboBox.setItems(displayComponentList(componentCollection.getComponentList()));
		}
		else{
			comboBox.setItems(displayComponentList(componentCollection.filter("Type", filterInput)));
		}
		comboBox.getSelectionModel().selectLast();

	}

	//Method for displaying a component.
	private ObservableList<String> displayComponentList(ObservableList<Component> inputList){
		ObservableList<String> outList = FXCollections.observableArrayList();
		for (Component entry : inputList){
			outList.add(entry.displayComponent());
		}
		outList.add("---");
		return outList;
	}

	@FXML
	void previousOrders(ActionEvent event) throws IOException{
		App.setRoot("orders", 625, 525, "Previous Orders");
	}

	private void threadSucceeded(WorkerStateEvent workerStateEvent) {
		btnAnalyzeOrder.setDisable(false);
		btnPlaceOrder.setDisable(false);
		System.out.println("\nUser saved.\n");
	}
	private void threadFailed(WorkerStateEvent workerStateEvent) {
		btnAnalyzeOrder.setDisable(false);
		btnPlaceOrder.setDisable(false);
		System.out.println("\nERROR something went wrong!\nUser NOT saved.\n");
	}

}