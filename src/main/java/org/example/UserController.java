package org.example;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import org.example.componentClasses.*;
import org.example.logicAndClasses.Checker;
import org.example.logicAndClasses.ComponentCollection;
import org.example.logicAndClasses.Order;

import java.io.IOException;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Optional;

public class UserController {

	private static ComponentCollection componentCollection = App.getComponentCollection();
	private ObservableList<Component> currentSelectedList;
	private double totalPrice;
	private boolean buildIsCompatible;


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
	public ComboBox<String> cbExtra1;

	@FXML
	public ComboBox<String> cbExtra2;

	@FXML
	public ComboBox<String> cbExtra3;

	@FXML
	public ComboBox<String> cbExtra4;

	@FXML
	private TextArea txtPreview;


	@FXML
	void loadOrder(ActionEvent event) {

	}

	@FXML
	void loginAdmin(ActionEvent event) throws IOException {

		App.setRoot("admin", 625, 525, "Admin");

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
				extra1 = cbExtra1.getSelectionModel().getSelectedItem(),
				extra2 = cbExtra2.getSelectionModel().getSelectedItem(),
				extra3 = cbExtra3.getSelectionModel().getSelectedItem(),
				extra4 = cbExtra4.getSelectionModel().getSelectedItem();

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
		if (!(extra1.equals("---"))){
			listOfSelected.add(componentCollection.getComponentByDisplayString(cbExtra1.getSelectionModel().getSelectedItem()));
		}
		if (!(extra2.equals("---"))){
			listOfSelected.add(componentCollection.getComponentByDisplayString(cbExtra2.getSelectionModel().getSelectedItem()));
		}
		if (!(extra3.equals("---"))){
			listOfSelected.add(componentCollection.getComponentByDisplayString(cbExtra3.getSelectionModel().getSelectedItem()));
		}
		if (!(extra4.equals("---"))){
			listOfSelected.add(componentCollection.getComponentByDisplayString(cbExtra4.getSelectionModel().getSelectedItem()));
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
	void placeOrder(ActionEvent event) {
		currentSelectedList = analyzeOrder(event);
		int size;
		try{
			size = currentSelectedList.size();
		}catch (Exception e){
			size = 0;
			txtPreview.setText("");
		}
		if(size == 0){
			Alert emptyOrder = new Alert(Alert.AlertType.INFORMATION);
			emptyOrder.setTitle("Error!");
			emptyOrder.setHeaderText("Empty order!");
			emptyOrder.setContentText("You cannot place an empty order!\nBuy something, will ya?");
			emptyOrder.showAndWait();
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

			Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
			alert.setTitle(promptTitle);
			alert.setHeaderText(promptHeader);
			alert.setContentText(promptText);
			alert.setResizable(false);
			Optional<ButtonType> confirm = alert.showAndWait();
			ButtonType click = confirm.orElse(ButtonType.CANCEL);

			if (click == ButtonType.OK) {
				//SAVE ORDER METHOD; ORDER PLACE LOGIC

				Order order = new Order("0124124", "001", Calendar.getInstance().getTime(),
						currentSelectedList, totalPrice);

				//
				Alert orderPlacedAlert = new Alert(Alert.AlertType.INFORMATION);
				orderPlacedAlert.setTitle("Success!");
				orderPlacedAlert.setHeaderText("Order has been placed!");
				orderPlacedAlert.setContentText("Thank you for your purchase!");
				orderPlacedAlert.showAndWait();
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
		cbExtra1.getSelectionModel().selectLast();
		cbExtra2.getSelectionModel().selectLast();
		cbExtra3.getSelectionModel().selectLast();
		cbExtra4.getSelectionModel().selectLast();
	}

	@FXML
	void saveOrder(ActionEvent event) {

	}

	@FXML
	void showAbout(ActionEvent event) {

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
		populateSingleComboBox(cbExtra1, "None", componentCollection);
		populateSingleComboBox(cbExtra2, "None", componentCollection);
		populateSingleComboBox(cbExtra3, "None", componentCollection);
		populateSingleComboBox(cbExtra4, "None", componentCollection);

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
}