package org.example;

import javafx.collections.ObservableList;
import javafx.concurrent.WorkerStateEvent;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.TextFieldTableCell;
import org.example.exceptions.IllegalDimensionsException;
import org.example.exceptions.IllegalPriceException;
import org.example.exceptions.IllegalWeightException;
import org.example.io.WriteComponentsToFile;
import org.example.logicAndClasses.ComponentCollection;
import org.example.exceptions.ExceptionHandler;
import org.example.componentClasses.*;
import org.example.logicAndClasses.DialogueBoxes;
import org.example.logicAndClasses.SecondaryWindowThread;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class AdminController implements Initializable {
	private ComponentCollection componentCollection = App.getComponentCollection();
	private ExceptionHandler.DoubleStringConverter doubleStringConverter
			= new ExceptionHandler.DoubleStringConverter();
	private SecondaryWindowThread task;


	@FXML
	private MenuBar menuBar;

	@FXML
	private TextField filterArea;

	@FXML
	private ChoiceBox<?> filterBox;

	@FXML
	private Button filterBtn;

	@FXML
	private TableView<Component> tableView;

	@FXML
	private TableColumn<TableView<Component>, String> tvType;

	@FXML
	private TableColumn<TableView<Component>, String> tvName;

	@FXML
	private TableColumn<TableView<Component>, String> tvManufacturer;

	@FXML
	private TableColumn<TableView<Component>, Double> tvPrice;

	@FXML
	private TableColumn<TableView<Component>, String> tvInfo;

	@FXML
	void createCPU(ActionEvent event) throws IOException {
		App.newWindow("cpu", "Register CPU");
		disableGUI();
	}

	@FXML
	void createCabinet(ActionEvent event) throws IOException {
		App.newWindow("cabinet", "Register Cabinet");
		disableGUI();
	}

	@FXML
	void createFan(ActionEvent event) throws IOException {
		App.newWindow("fan", "Register Fan");
		disableGUI();
	}

	@FXML
	void createGraphicCard(ActionEvent event) throws IOException {
		App.newWindow("graphiccard", "Register Graphic Card");
		disableGUI();
	}

	@FXML
	void createMotherboard(ActionEvent event) throws IOException {
		App.newWindow("motherboard", "Register Motherboard");
		disableGUI();
	}

	@FXML
	void createPowerSupply(ActionEvent event) throws IOException {
		App.newWindow("powersupply", "Register Power Supply");
		disableGUI();
	}

	@FXML
	void createStorage(ActionEvent event) throws IOException {
		App.newWindow("storage", "Register Storage");
		disableGUI();
	}

	@FXML
	void createKeyboard(ActionEvent event) throws IOException {
		App.newWindow("keyboard", "Register Keyboard");
		disableGUI();
	}

	@FXML
	void createMouse(ActionEvent event) throws IOException {
		App.newWindow("mouse", "Register Mouse");
		disableGUI();
	}

	@FXML
	void createMonitor(ActionEvent event) throws IOException {
		App.newWindow("monitor", "Register Monitor");
		disableGUI();
	}

	@FXML
	void createRAM(ActionEvent event) throws IOException {
		App.newWindow("ram", "Register RAM");
		disableGUI();
	}
	//  Methods for editing component-data
	@FXML
	public void editName(TableColumn.CellEditEvent<Component, String> event) throws IOException {
		event.getRowValue().setName(event.getNewValue());
		WriteComponentsToFile.save(App.getComponentCollection().getArrayList());
	}

	@FXML
	public void editManufacturer(TableColumn.CellEditEvent<Component, String> event) throws IOException {
		event.getRowValue().setManufacturer(event.getNewValue());
		WriteComponentsToFile.save(App.getComponentCollection().getArrayList());
	}

	@FXML
	public void editPrice(TableColumn.CellEditEvent<Component, Double> event) throws IOException {
		try {
			if (doubleStringConverter.wasSuccessful()) {
				event.getRowValue().setPrice(event.getNewValue());
				WriteComponentsToFile.save(App.getComponentCollection().getArrayList());
			}
		} catch (NumberFormatException | IllegalPriceException e){
			DialogueBoxes.alert("Feil", "Du må skrive inn et positivt tall!");
		} catch (IllegalArgumentException e){
			DialogueBoxes.alert("Ugyldig input: ", e.getMessage());
		}
		tableView.refresh();
	}
	//  Method for editing 'info', meaning non-universal attributes (like CPU.clockSpeed, for instance)
	@FXML
	void editInfo(TableColumn.CellEditEvent<Component, String> event) {
		try {
			if(event.getRowValue().setInfo(event.getNewValue())){
				WriteComponentsToFile.save(App.getComponentCollection().getArrayList());
			}
		} catch (IOException ioe){
			DialogueBoxes.alert("Feil i redigering", ioe.getMessage());
		}
		unWidenColumns();
		tableView.refresh();
	}
	//  Filtering the list of components
	@FXML
	void filter(ActionEvent event) {
		String choiceBoxValue = (String) filterBox.getValue();
		String filterInput = filterArea.getText();

		if(!filterInput.isEmpty()){
			ObservableList<Component> newList = ComponentCollection.filter(choiceBoxValue, filterInput);
			tableView.setItems(newList);
		} else {
			tableView.setItems(componentCollection.getComponentList());
		}
	}
	//  Deleting row (deleting a component)
	@FXML
	void deleteRow(ActionEvent event) throws IOException {
		Component c = tableView.getSelectionModel().getSelectedItem();

		if(DialogueBoxes.confirm("Fjerne komponent?",
				"Advarsel, denne handlingen vil permanent fjerne en komponent, fortsette?")){
			App.removeComponent(c);
			WriteComponentsToFile.save(App.getComponentCollection().getArrayList());
		}
	}

	@FXML
	void widenColumn(TableColumn.CellEditEvent<TableView<Component>, String> event) {
		widenColumns();
	}

	@FXML
	void unwidenColumn(TableColumn.CellEditEvent<TableView<Component>, String> event) {
		unWidenColumns();
	}

	@FXML
	void changeToUser(ActionEvent event) throws IOException {
		App.setRoot("user", 700, 640, "End User");
	}

	@FXML
	void saveCollection(ActionEvent event) throws IOException {
		WriteComponentsToFile.save(componentCollection.getArrayList());
	}

	@FXML
	void resetList(ActionEvent event) throws IOException{
		App.resetLists();
	}

	@FXML
	void showAbout(ActionEvent event) {
		DialogueBoxes.about("This GUI allows you to see all created components\nand create new ones",
				"Press \"Registrer komponent\" and choose a type of component to start the creation tool.\n" +
						"Some attributes of each component are also editable, such as name, price and manufacturer.\n" +
						"You can also switch to the End User GUI by clicking \"Help\" -> \"User View\".");
	}

	public void initialize(URL url, ResourceBundle resourceBundle){
		componentCollection.attachTableView(tableView);
		tvPrice.setCellFactory(TextFieldTableCell.forTableColumn(doubleStringConverter));
	}

	void widenColumns(){
		tvInfo.setPrefWidth(500.0);
		tvPrice.setPrefWidth(0);
		tvManufacturer.setPrefWidth(0);
		tvName.setPrefWidth(0);
	}
	void unWidenColumns(){
		tvManufacturer.setPrefWidth(126);
		tvName.setPrefWidth(104);
		tvPrice.setPrefWidth(71);
		tvInfo.setPrefWidth(190.0);
	}

	void enableGUI(){
		menuBar.setDisable(false);
		tableView.setDisable(false);
		filterBtn.setDisable(false);
		filterBox.setDisable(false);
		filterArea.setDisable(false);
	}
	void disableGUI(){
		this.task = new SecondaryWindowThread();
		this.task.setOnSucceeded(this::threadSucceeded);
		this.task.setOnFailed(this::threadFailed);

		menuBar.setDisable(true);
		tableView.setDisable(true);
		filterBtn.setDisable(true);
		filterBox.setDisable(true);
		filterArea.setDisable(true);

		Thread th = new Thread(task);
		th.start();
	}

	private void threadFailed(WorkerStateEvent workerStateEvent) {
		enableGUI();
	}
	private void threadSucceeded(WorkerStateEvent workerStateEvent) {
		enableGUI();
	}
}
