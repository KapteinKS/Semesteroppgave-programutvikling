package org.example;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import org.example.componentClasses.Cabinet;
import org.example.componentClasses.Component;
import org.example.logicAndClasses.ComponentCollection;

import java.io.IOException;
import java.util.ArrayList;

public class UserController {

	private static ComponentCollection componentCollection;
	//



	//

	//* Populating ComboBox-Logic *//
	private ObservableList<String> cabinetList = displayComponentList(componentCollection.getComponentByType("Cabinet"));
	private ObservableList<String> cpuList = displayComponentList(componentCollection.getComponentByType("CPU"));
	private ObservableList<String> fanList = displayComponentList(componentCollection.getComponentByType("Fan"));
	private ObservableList<String> gpuList = displayComponentList(componentCollection.getComponentByType("GraphicCard"));
	private ObservableList<String> mbList = displayComponentList(componentCollection.getComponentByType("Motherboard"));
	private ObservableList<String> psuList = displayComponentList(componentCollection.getComponentByType("PowerSupply"));
	private ObservableList<String> ramList = displayComponentList(componentCollection.getComponentByType("RAM"));
	private ObservableList<String> storageList = displayComponentList(componentCollection.getComponentByType("Storage"));

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
	void placeOrder(ActionEvent event) {

	}

	@FXML
	void saveOrder(ActionEvent event) {

	}

	@FXML
	void showAbout(ActionEvent event) {

	}

	public void populateComboBox(){
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

		cbCabinet.setItems(testList);


		cbCabinet.setItems(testList);
		cbMotherboard.setItems(mbList);
		cbCPU.setItems(cpuList);
		cbGPU1.setItems(testList);
		cbGPU2.setItems(gpuList);
		cbRAM1.setItems(ramList);
		cbRAM2.setItems(ramList);
		cbStorage1.setItems(storageList);
		cbStorage2.setItems(storageList);
		cbPSU.setItems(psuList);
		cbFan1.setItems(fanList);
		cbFan2.setItems(fanList);
		cbExtra1.setItems(displayComponentList(componentCollection.getComponentList()));
		cbExtra2.setItems(displayComponentList(componentCollection.getComponentList()));
		cbExtra3.setItems(displayComponentList(componentCollection.getComponentList()));
		cbExtra4.setItems(displayComponentList(componentCollection.getComponentList()));

	}

	public ObservableList<String> displayComponentList(ObservableList<Component> inputList){
		ObservableList<String> outList = FXCollections.observableArrayList();
		for (Component entry : inputList){
			outList.add(entry.displayComponent());
		}
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