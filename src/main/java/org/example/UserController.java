package org.example;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import org.example.componentClasses.*;
import org.example.io.ThreadHandler;
import org.example.io.Writer;
import org.example.logicAndClasses.*;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.ResourceBundle;

public class UserController implements Initializable {

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
			DialogueBoxes.information("Tilgang nektet", "Krever admin-tilgang",
					"Du prøver å benytte deg av restrikterte funksjoner. " +
					"Vennligst logg inn som Administrator");
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
				result += "Ikke nok kraft for valgte komponenter: "
						+ "\nKraftforsyningens kraft: " + wattsDelivered + " W\nKraft krevd: " + wattsUsed
						+ " W\n--------------------\n";
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
			result += "Ordren er kompatibel!" + "\n--------------------\n";
			buildIsCompatible = true;
		}

		result += "Watts brukt: " + wattsUsed + "\nTotal Pris: " + String.format("%.2f", totalPrice) + " NOK";

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
			DialogueBoxes.information("Feil!","Tom ordre!","Du kan ikke bestille ingenting!\nKjøp noe, da vel!");

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
				promptTitle = "Suksess!";
				promptHeader = "Utvalget er kompatibelt!";
				promptText = "Plassere ordre?";
			}
			else{
				promptTitle = "Advarsel!";
				promptHeader = "Advarsel!\nNoen deler er inkoblatible med hverandre, det kan være deler ikke passer sammen!";
				promptText = "Ønsker du fremdeles å plassere ordre?";
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
				Writer.saveOrders(orderCollection);

				//  App update
				App.setOrderCollection(orderCollection);


				DialogueBoxes.information("Suksess!",
						"Ordre har blitt plassert!\nTakk for handelen!\nOrdreinfo under:",
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
		DialogueBoxes.about("Dette GUIet lar kunder sette sammen en datamaskin, og plassere en ordre",
				"Velg komponenter fra Drop-down menyene, og trykk \"Analyser Ordre\" for å se" +
						" kompabiliteten og prisen på maskinen din.\n" +
						"Du kan også endre til Admin-kontroller ved å trykke \"Hjelp\" -> \"Admin\".");
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

	@Override
	public void initialize(URL url, ResourceBundle resourceBundle) {
		currentUser = App.getCurrentUser();
	}
}