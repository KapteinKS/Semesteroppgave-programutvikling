package org.example;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.TextFieldTableCell;
import org.example.io.WriteComponentsToFile;
import org.example.logicAndClasses.ComponentCollection;
import org.example.exceptions.ExceptionHandler;
import org.example.componentClasses.*;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class AdminController implements Initializable {
	//errrrrr
	private ComponentCollection collection = App.getList2();
	//
	private ExceptionHandler.DoubleStringConverter doubleStringConverter
			= new ExceptionHandler.DoubleStringConverter();

	@FXML
	private TextArea txtOutput;

	@FXML
	private Label lblOutput;

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
		collection.attachTableView(tableView);
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
	void loadOrder(ActionEvent event) {

	}

	@FXML
	void changeToUser(ActionEvent event) throws IOException {
		App.setRoot("user", 700, 640, "End User");
	}

	@FXML
	void saveOrder(ActionEvent event) throws IOException {
		WriteComponentsToFile.save(collection.getArrayList());
	}

	@FXML
	void showAbout(ActionEvent event) {
		DialogueBoxes.about("This GUI allows you to see all created components\nand create new ones",
				"Press \"Registrer komponent\" and choose a type of component to start the creation tool.\n" +
				"Some attributes of each component are also editable, such as name, price and manufacturer.\n" +
				"You can also switch to the End User GUI by clicking \"Help\" -> \"User View\".");
	}

	@FXML
	void showComponents(ActionEvent event) {

		//funky, see App @ line 125
		collection = App.getList2();
		//

		String lorem = "\"Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.\"\n" + "\n" + "Section 1.10.32 of \"de Finibus Bonorum et Malorum\", written by Cicero in 45 BC\n" + "\"Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam, eaque ipsa quae ab illo inventore veritatis et quasi architecto beatae vitae dicta sunt explicabo. Nemo enim ipsam voluptatem quia voluptas sit aspernatur aut odit aut fugit, sed quia consequuntur magni dolores eos qui ratione voluptatem sequi nesciunt. Neque porro quisquam est, qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit, sed quia non numquam eius modi tempora incidunt ut labore et dolore magnam aliquam quaerat voluptatem. Ut enim ad minima veniam, quis nostrum exercitationem ullam corporis suscipit laboriosam, nisi ut aliquid ex ea commodi consequatur? Quis autem vel eum iure reprehenderit qui in ea voluptate velit esse quam nihil molestiae consequatur, vel illum qui dolorem eum fugiat quo voluptas nulla pariatur?\"\n" + "\n" + "1914 translation by H. Rackham\n" + "\"But I must explain to you how all this mistaken idea of denouncing pleasure and praising pain was born and I will give you a complete account of the system, and expound the actual teachings of the great explorer of the truth, the master-builder of human happiness. No one rejects, dislikes, or avoids pleasure itself, because it is pleasure, but because those who do not know how to pursue pleasure rationally encounter consequences that are extremely painful. Nor again is there anyone who loves or pursues or desires to obtain pain of itself, because it is pain, but because occasionally circumstances occur in which toil and pain can procure him some great pleasure. To take a trivial example, which of us ever undertakes laborious physical exercise, except to obtain some advantage from it? But who has any right to find fault with a man who chooses to enjoy a pleasure that has no annoying consequences, or one who avoids a pain that produces no resultant pleasure?\"\n" + "\n" + "Section 1.10.33 of \"de Finibus Bonorum et Malorum\", written by Cicero in 45 BC\n" + "\"At vero eos et accusamus et iusto odio dignissimos ducimus qui blanditiis praesentium voluptatum deleniti atque corrupti quos dolores et quas molestias excepturi sint occaecati cupiditate non provident, similique sunt in culpa qui officia deserunt mollitia animi, id est laborum et dolorum fuga. Et harum quidem rerum facilis est et expedita distinctio. Nam libero tempore, cum soluta nobis est eligendi optio cumque nihil impedit quo minus id quod maxime placeat facere possimus, omnis voluptas assumenda est, omnis dolor repellendus. Temporibus autem quibusdam et aut officiis debitis aut rerum necessitatibus saepe eveniet ut et voluptates repudiandae sint et molestiae non recusandae. Itaque earum rerum hic tenetur a sapiente delectus, ut aut reiciendis voluptatibus maiores alias consequatur aut perferendis doloribus asperiores repellat.\"\n" + "\n" + "1914 translation by H. Rackham\n" + "\"On the other hand, we denounce with righteous indignation and dislike men who are so beguiled and demoralized by the charms of pleasure of the moment, so blinded by desire, that they cannot foresee the pain and trouble that are bound to ensue; and equal blame belongs to those who fail in their duty through weakness of will, which is the same as saying through shrinking from toil and pain. These cases are perfectly simple and easy to distinguish. In a free hour, when our power of choice is untrammelled and when nothing prevents our being able to do what we like best, every pleasure is to be welcomed and every pain avoided. But in certain circumstances and owing to the claims of duty or the obligations of business it will frequently occur that pleasures have to be repudiated and annoyances accepted. The wise man therefore always holds in these matters to this principle of selection: he rejects pleasures to secure other greater pleasures, or else he endures pains to avoid worse pains.\"";
		lblOutput.setText("ALL COMPONENTS: ");
		txtOutput.setText("THIS IS A TEST" + lorem + "THIS IS A TEST");



	}

	@FXML
	void showOrders(ActionEvent event) {

		String lorem = "\"Lorem ipsum dolor sit amet,  adipiscing elit, sed do eiusmod tempor  ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.\"\n" + "\n" + "Section 1.10.32 of \"de Finibus Bonorum et Malorum\", written by Cicero in 45 BC\n" + "\"Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam, eaque ipsa quae ab illo inventore veritatis et quasi architecto beatae vitae dicta sunt explicabo. Nemo enim ipsam voluptatem quia voluptas sit aspernatur aut odit aut fugit, sed quia consequuntur magni dolores eos qui ratione voluptatem sequi nesciunt. Neque porro quisquam est, qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit, sed quia non numquam eius modi tempora incidunt ut labore et dolore magnam aliquam quaerat voluptatem. Ut enim ad minima veniam, quis nostrum exercitationem ullam corporis suscipit laboriosam, nisi ut aliquid ex ea commodi consequatur? Quis autem vel eum iure reprehenderit qui in ea voluptate velit esse quam nihil molestiae consequatur, vel illum qui dolorem eum fugiat quo voluptas nulla pariatur?\"\n" + "\n" + "1914 translation by H. Rackham\n" + "\"But I must explain to you how all this mistaken idea of denouncing pleasure and praising pain was born and I will give you a complete account of the system, and expound the actual teachings of the great explorer of the truth, the master-builder of human happiness. No one rejects, dislikes, or avoids pleasure itself, because it is pleasure, but because those who do not know how to pursue pleasure rationally encounter consequences that are extremely painful. Nor again is there anyone who loves or pursues or desires to obtain pain of itself, because it is pain, but because occasionally circumstances occur in which toil and pain can procure him some great pleasure. To take a trivial example, which of us ever undertakes laborious physical exercise, except to obtain some advantage from it? But who has any right to find fault with a man who chooses to enjoy a pleasure that has no annoying consequences, or one who avoids a pain that produces no resultant pleasure?\"\n" + "\n" + "Section 1.10.33 of \"de Finibus Bonorum et Malorum\", written by Cicero in 45 BC\n" + "\"At vero eos et accusamus et iusto odio dignissimos ducimus qui blanditiis praesentium voluptatum deleniti atque corrupti quos dolores et quas molestias excepturi sint occaecati cupiditate non provident, similique sunt in culpa qui officia deserunt mollitia animi, id est laborum et dolorum fuga. Et harum quidem rerum facilis est et expedita distinctio. Nam libero tempore, cum soluta nobis est eligendi optio cumque nihil impedit quo minus id quod maxime placeat facere possimus, omnis voluptas assumenda est, omnis dolor repellendus. Temporibus autem quibusdam et aut officiis debitis aut rerum necessitatibus saepe eveniet ut et voluptates repudiandae sint et molestiae non recusandae. Itaque earum rerum hic tenetur a sapiente delectus, ut aut reiciendis voluptatibus maiores alias consequatur aut perferendis doloribus asperiores repellat.\"\n" + "\n" + "1914 translation by H. Rackham\n" + "\"On the other hand, we denounce with righteous indignation and dislike men who are so beguiled and demoralized by the charms of pleasure of the moment, so blinded by desire, that they cannot foresee the pain and trouble that are bound to ensue; and equal blame belongs to those who fail in their duty through weakness of will, which is the same as saying through shrinking from toil and pain. These cases are perfectly simple and easy to distinguish. In a free hour, when our power of choice is untrammelled and when nothing prevents our being able to do what we like best, every pleasure is to be welcomed and every pain avoided. But in certain circumstances and owing to the claims of duty or the obligations of business it will frequently occur that pleasures have to be repudiated and annoyances accepted. The wise man therefore always holds in these matters to this principle of selection: he rejects pleasures to secure other greater pleasures, or else he endures pains to avoid worse pains.\"";
		lblOutput.setText("ALL ORDERS: ");
		txtOutput.setText("THIS IS ANOTHER TEST" + lorem + "THIS IS ANOTHER TEST");

	}

	@FXML
	void filter(ActionEvent event) {
		String choiceBoxValue = (String) filterBox.getValue();
		String filterInput = filterArea.getText();

		if(!filterInput.isEmpty()){
			ObservableList<Component> newList = ComponentCollection.filter(choiceBoxValue, filterInput);

			tableView.setItems(newList);
		} else {
			tableView.setItems(collection.getComponentList());
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
}
