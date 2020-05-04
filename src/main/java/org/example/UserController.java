package org.example;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import org.example.componentClasses.*;
import org.example.logicAndClasses.Checker;
import org.example.logicAndClasses.ComponentCollection;

import java.io.IOException;
import java.util.ArrayList;

public class UserController {

	private static ComponentCollection componentCollection = App.getComponentCollection();
	//



	//

	//* Populating ComboBox-Logic *//

	/*
	private ObservableList<String> cabinetList = displayComponentList(ComponentCollection.filter("Type","Cabinet"));
	private ObservableList<String> cpuList = displayComponentList(componentCollection.getComponentByType("CPU"));
	private ObservableList<String> fanList = displayComponentList(componentCollection.getComponentByType("Fan"));
	private ObservableList<String> gpuList = displayComponentList(componentCollection.getComponentByType("GraphicCard"));
	private ObservableList<String> mbList = displayComponentList(componentCollection.getComponentByType("Motherboard"));
	private ObservableList<String> psuList = displayComponentList(componentCollection.getComponentByType("PowerSupply"));
	private ObservableList<String> ramList = displayComponentList(componentCollection.getComponentByType("RAM"));
	private ObservableList<String> storageList = displayComponentList(componentCollection.getComponentByType("Storage"));


	 */
	//
	private ObservableList<String> testList = test();
	//**//

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
	private Label lblAnalyze;

	@FXML
	private Label lblOrdre;

	@FXML
	void loadOrder(ActionEvent event) {

	}

	@FXML
	void loginAdmin(ActionEvent event) throws IOException {

		App.setRoot("admin", 600, 500, "Admin");

		/*

		THIS CHANGES THE VIEW TO 'admin.fxml', BUT REQUIRES
		A LOGON TO DO SO.

		FOR THE HAND-IN, WE WILL THEN HAVE TO PROIVDE SENSOR WITH
		THIS INFORMATION.


		 */

	}
	@FXML
	void analyzeOrder(ActionEvent event){
		ObservableList<Component> listOfSelected = FXCollections.observableArrayList();

		txtPreview.setText("");
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

		try {
			Cabinet selectedCab = componentCollection.getComponentByDisplayString(cab);
			Motherboard selectedMb = componentCollection.getComponentByDisplayString(mb);
			result += Checker.checkMotherboardAndCabinet(selectedMb,selectedCab);
		} catch (Exception e){}
		try {
			Motherboard selectedMb = componentCollection.getComponentByDisplayString(mb);
			RAM selectedRAM1 = componentCollection.getComponentByDisplayString(ram1);
			result += Checker.checkMotherboardAndRAM(selectedMb, selectedRAM1);
		} catch (Exception e){}
		try {
			Motherboard selectedMB = componentCollection.getComponentByDisplayString(mb);
			RAM selectedRAM2 = componentCollection.getComponentByDisplayString(ram2);
			result += Checker.checkMotherboardAndRAM(selectedMB, selectedRAM2);
		} catch (Exception e){}
		try {
			Motherboard selectedMB = componentCollection.getComponentByDisplayString(mb);
			CPU selectedCPU = componentCollection.getComponentByDisplayString(cpu);
			result += Checker.checkMotherboardAndCPU(selectedMB, selectedCPU);
		} catch (Exception e){}

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
		//Checking voltage for main build
		double wattsUsed = Checker.summarizeWatts(listOfSelected);
		try{
			double wattsDelivered = componentCollection.getComponentByDisplayString(psu).getWattsRequired();
			if(wattsUsed > wattsDelivered){
				result += "\nNot enough power for selected components: "
						+ "\nPSU-watts: " + wattsDelivered + "\nWatts used in total: " + wattsUsed;
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

		double totalPrice = Checker.summarizePrice(listOfSelected);


		result += ("\n--------------------\nWatts used: " + wattsUsed + "\nTotal Price: " + totalPrice + " NOK");
		//}

		txtPreview.setText(result);
	}

	@FXML
	void placeOrder(ActionEvent event) {

	}

	@FXML
	void saveOrder(ActionEvent event) {

	}

	@FXML
	void showAbout(ActionEvent event) {

	}
	public void populateComboBoxes(){
		//componentCollection = App.getComponentCollection();

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

	/*
	 AN OLD SAFER VERSION
	public void populateComboBoxes(){
		componentCollection = App.getComponentCollection();



		cbCabinet.getItems().clear();
		cbMotherboard.getItems().clear();
		cbCPU.getItems().clear();
		cbGPU1.getItems().clear();
		cbGPU2.getItems().clear();
		cbRAM1.getItems().clear();
		cbRAM2.getItems().clear();
		cbStorage1.getItems().clear();
		cbStorage2.getItems().clear();
		cbPSU.getItems().clear();
		cbFan1.getItems().clear();
		cbFan2.getItems().clear();
		cbExtra1.getItems().clear();
		cbExtra2.getItems().clear();
		cbExtra3.getItems().clear();
		cbExtra4.getItems().clear();

		cbCabinet.setItems(displayComponentList(componentCollection.filter("Type","Cabinet")));
		cbMotherboard.setItems(displayComponentList(componentCollection.filter("Type","Motherboard")));
		cbCPU.setItems(displayComponentList(componentCollection.filter("Type","CPU")));
		cbGPU1.setItems(displayComponentList(componentCollection.filter("Type","GraphicCard")));
		cbGPU2.setItems(displayComponentList(componentCollection.filter("Type","GraphicCard")));
		cbRAM1.setItems(displayComponentList(componentCollection.filter("Type","RAM")));
		cbRAM2.setItems(displayComponentList(componentCollection.filter("Type","RAM")));
		cbStorage1.setItems(displayComponentList(componentCollection.filter("Type","Storage")));
		cbStorage2.setItems(displayComponentList(componentCollection.filter("Type","Storage")));
		cbPSU.setItems(displayComponentList(componentCollection.filter("Type","PowerSupply")));
		cbFan1.setItems(displayComponentList(componentCollection.filter("Type","Fan")));
		cbFan2.setItems(displayComponentList(componentCollection.filter("Type","Fan")));
		cbExtra1.setItems(displayComponentList(componentCollection.getComponentList()));
		cbExtra2.setItems(displayComponentList(componentCollection.getComponentList()));
		cbExtra3.setItems(displayComponentList(componentCollection.getComponentList()));
		cbExtra4.setItems(displayComponentList(componentCollection.getComponentList()));

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
	 */

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

	// TEST STUFF
	public static ObservableList<String> test(){
		ObservableList<String> outlist = FXCollections.observableArrayList();
		outlist.add("Linje Nummer 1");
		outlist.add("Linje NUmmer 2");
		outlist.add("LINJE TREEEE");
		return outlist;
	}

}