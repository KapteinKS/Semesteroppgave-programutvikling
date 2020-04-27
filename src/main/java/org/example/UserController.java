package org.example;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import org.example.componentClasses.Component;
import org.example.logicAndClasses.ComponentCollection;

import java.io.IOException;
import java.util.ArrayList;

public class UserController {

	private static ComponentCollection componentCollection = new ComponentCollection();
	//* Populating ComboBox-Logic *//
	ObservableList<String> cabinetList = displayComponentList(componentCollection.getComponentByType("Cabinet"));
	ObservableList<Component> cpuList = componentCollection.getComponentByType("CPU");
	ObservableList<Component> fanList = componentCollection.getComponentByType("Fan");
	ObservableList<Component> gpuList = componentCollection.getComponentByType("GraphicCard");
	ObservableList<Component> mbList = componentCollection.getComponentByType("Motherboard");
	ObservableList<Component> psuList = componentCollection.getComponentByType("PowerSupply");
	ObservableList<Component> ramList = componentCollection.getComponentByType("RAM");
	ObservableList<Component> storageList = componentCollection.getComponentByType("Storage");




	//**//

	@FXML
	private ComboBox<?> cbCabinet;

	@FXML
	private ComboBox<?> cbMotherboard;

	@FXML
	private ComboBox<?> cbCPU;

	@FXML
	private ComboBox<?> cbGPU1;

	@FXML
	private ComboBox<?> cbGPU2;

	@FXML
	private ComboBox<?> cbRAM1;

	@FXML
	private ComboBox<?> cbRAM2;

	@FXML
	private ComboBox<?> cbStorage1;

	@FXML
	private ComboBox<?> cbStorage2;

	@FXML
	private ComboBox<?> cbPSU;

	@FXML
	private ComboBox<?> cbFan1;

	@FXML
	private ComboBox<?> cbFan2;

	@FXML
	private ComboBox<?> cbExtra1;

	@FXML
	private ComboBox<?> cbExtra2;

	@FXML
	private ComboBox<Component> cbExtra3;

	@FXML
	private ComboBox<?> cbExtra4;

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

		cbCabinet.setItems(cabinetList);
		cbMotherboard.setItems(mbList);
		cbCPU.setItems(cpuList);
		cbGPU1.setItems(gpuList);
		cbGPU2.setItems(gpuList);
		cbRAM1.setItems(ramList);
		cbRAM2.setItems(ramList);
		cbStorage1.setItems(storageList);
		cbStorage2.setItems(storageList);
		cbPSU.setItems(psuList);
		cbFan1.setItems(fanList);
		cbFan2.setItems(fanList);
		cbExtra1.setItems(componentCollection.getComponentList());
		cbExtra2.setItems(componentCollection.getComponentList());
		cbExtra3.setItems(componentCollection.getComponentList());
		cbExtra4.setItems(componentCollection.getComponentList());

	}

	public ObservableList<String> displayComponentList(ObservableList<Component> inputList){
		ObservableList<String> outList = FXCollections.observableArrayList();
		for (Component entry : inputList){
			outList.add(entry.displayComponent());
		}
		return outList;
	}
}