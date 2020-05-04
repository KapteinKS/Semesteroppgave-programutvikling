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
		//Cabinet selectedCab = componentCollection.getComponentByDisplayString(cbCabinet.getSelectionModel().getSelectedItem());
		Motherboard selectedMB = componentCollection.getComponentByDisplayString(cbMotherboard.getSelectionModel().getSelectedItem());
		CPU selectedCPU = componentCollection.getComponentByDisplayString(cbCPU.getSelectionModel().getSelectedItem());
		//GraphicCard selectedGPU1 = componentCollection.getComponentByDisplayString(cbGPU1.getSelectionModel().getSelectedItem());
		//GraphicCard selectedGPU2 = componentCollection.getComponentByDisplayString(cbGPU2.getSelectionModel().getSelectedItem());
		//RAM selectedRAM1 = componentCollection.getComponentByDisplayString(cbRAM1.getSelectionModel().getSelectedItem());
		//RAM selectedRAM2 = componentCollection.getComponentByDisplayString(cbRAM2.getSelectionModel().getSelectedItem());
		//Storage selectedStrg1 = componentCollection.getComponentByDisplayString(cbStorage1.getSelectionModel().getSelectedItem());
		//Storage selectedStrg2 = componentCollection.getComponentByDisplayString(cbStorage1.getSelectionModel().getSelectedItem());
		//PowerSupply selectedPSU = componentCollection.getComponentByDisplayString(cbPSU.getSelectionModel().getSelectedItem());
		//Fan selectedFan1 = componentCollection.getComponentByDisplayString(cbFan1.getSelectionModel().getSelectedItem());
		//Fan selectedFan2 = componentCollection.getComponentByDisplayString(cbFan2.getSelectionModel().getSelectedItem());

		String result = Checker.checkMotherboardxCPU(selectedMB,selectedCPU);

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