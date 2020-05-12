package org.example;

import javafx.collections.ObservableList;
import javafx.concurrent.WorkerStateEvent;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.TextFieldTableCell;
import org.example.io.ThreadHandler;
import org.example.io.WriteComponentsToFile;
import org.example.logicAndClasses.ComponentCollection;
import org.example.exceptions.ExceptionHandler;
import org.example.componentClasses.*;
import org.example.logicAndClasses.DialogueBoxes;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class AdminController implements Initializable {
	//errrrrr
	private ComponentCollection componentCollection = App.getList2();
	//
	private ExceptionHandler.DoubleStringConverter doubleStringConverter
			= new ExceptionHandler.DoubleStringConverter();
	private ThreadHandler task;


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


	public void initialize(URL url, ResourceBundle resourceBundle){
		componentCollection.attachTableView(tableView);
		tvPrice.setCellFactory(TextFieldTableCell.forTableColumn(doubleStringConverter));
	}

	@FXML
	void createCPU(ActionEvent event) throws IOException {
		App.newWindow("cpu", "Register CPU");
	}

	@FXML
	void createCabinet(ActionEvent event) throws IOException {
		App.newWindow("cabinet", "Register Cabinet");
	}

	@FXML
	void createFan(ActionEvent event) throws IOException {
		App.newWindow("fan", "Register Fan");
	}

	@FXML
	void createGraphicCard(ActionEvent event) throws IOException {
		App.newWindow("graphiccard", "Register Graphic Card");
	}

	@FXML
	void createMotherboard(ActionEvent event) throws IOException {
		App.newWindow("motherboard", "Register Motherboard");
	}

	@FXML
	void createPowerSupply(ActionEvent event) throws IOException {
		App.newWindow("powersupply", "Register Power Supply");
	}

	@FXML
	void createStorage(ActionEvent event) throws IOException {
		App.newWindow("storage", "Register Storage");
	}

	@FXML
	void createKeyboard(ActionEvent event) throws IOException {
		App.newWindow("keyboard", "Register Keyboard");
	}

	@FXML
	void createMouse(ActionEvent event) throws IOException {
		App.newWindow("mouse", "Register Mouse");
	}

	@FXML
	void createMonitor(ActionEvent event) throws IOException {
		App.newWindow("monitor", "Register Monitor");
	}

	@FXML
	void createRAM(ActionEvent event) throws IOException {
		App.newWindow("ram", "Register RAM");
	}

	@FXML
	void changeToUser(ActionEvent event) throws IOException {
		App.setRoot("user", 700, 640, "End User");
	}

	@FXML
	void saveCollection(ActionEvent event) throws IOException {
<<<<<<< HEAD
<<<<<<< HEAD
		//reworked to be new thread.
		task = new ThreadHandler(true,"saveComponents", componentCollection,null,null);
		this.task.setOnSucceeded(this::threadSucceeded);
		this.task.setOnFailed(this::threadFailed);
		Thread td = new Thread(this.task);
		td.start();
		task.saveComponents(componentCollection.getArrayList());




=======
		WriteComponentsToFile.save(collection.getArrayList());
>>>>>>> parent of 60cf4b8... Working on saving threads!
	}

=======
		WriteComponentsToFile.save(collection.getArrayList());
	}

>>>>>>> parent of 60cf4b8... Working on saving threads!
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

	@FXML
	void deleteRow(ActionEvent event) throws IOException {
		Component c = tableView.getSelectionModel().getSelectedItem();
		if(DialogueBoxes.confirm("Remove component?", "Caution, this action will permanently remove a component, continue?")){
			App.removeComponent(c);
			WriteComponentsToFile.save(App.getList2().getArrayList());
		}
	}

	@FXML
	public void editName(TableColumn.CellEditEvent<Component, String> event) throws IOException {
		event.getRowValue().setName(event.getNewValue());
		WriteComponentsToFile.save(App.getList2().getArrayList());
	}

	@FXML
	public void editManufacturer(TableColumn.CellEditEvent<Component, String> event) throws IOException {
		event.getRowValue().setManufacturer(event.getNewValue());
		WriteComponentsToFile.save(App.getList2().getArrayList());
	}

	@FXML
	public void editPrice(TableColumn.CellEditEvent<Component, Double> event) throws IOException {
		try {
			if (doubleStringConverter.wasSuccessful())
				event.getRowValue().setPrice(event.getNewValue());
				WriteComponentsToFile.save(App.getList2().getArrayList());
		} catch (NumberFormatException e){
			System.out.println("Du må skrive inn et positivt tall!");
		} catch (IllegalArgumentException e){
			System.out.println("Ugyldig input: " + e.getMessage());
		}
	}

	@FXML
	void editInfo(TableColumn.CellEditEvent<Component, String> event) throws IOException{
		if(event.getRowValue().setInfo(event.getNewValue())){
			WriteComponentsToFile.save(App.getList2().getArrayList());
		}
		tvManufacturer.setPrefWidth(126);
		tvName.setPrefWidth(104);
		tvPrice.setPrefWidth(71);
		tvInfo.setPrefWidth(190.0);
	}

	@FXML
	void widenColumn(TableColumn.CellEditEvent<TableView<Component>, String> event) {
		tvInfo.setPrefWidth(500.0);
		tvPrice.setPrefWidth(0);
		tvManufacturer.setPrefWidth(0);
		tvName.setPrefWidth(0);
	}

	@FXML
	void unwidenColumn(TableColumn.CellEditEvent<TableView<Component>, String> event) {
		tvManufacturer.setPrefWidth(126);
		tvName.setPrefWidth(104);
		tvPrice.setPrefWidth(71);
		tvInfo.setPrefWidth(190.0);
	}


	private void threadSucceeded(WorkerStateEvent workerStateEvent) {
		System.out.println("\nSaved.\n");
	}
	private void threadFailed(WorkerStateEvent workerStateEvent) {
		System.out.println("\nERROR something went wrong!\nNOT saved.\n");
	}
}
