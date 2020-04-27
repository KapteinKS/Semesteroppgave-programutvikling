package org.example;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;

import java.io.IOException;

public class UserController {

	@FXML
	private ChoiceBox<?> choiceBox0;

	@FXML
	private ChoiceBox<?> choiceBox1;

	@FXML
	private ChoiceBox<?> choiceBox2;

	@FXML
	private ChoiceBox<?> choiceBox3;

	@FXML
	private ChoiceBox<?> choiceBox4;

	@FXML
	private ChoiceBox<?> choiceBox5;

	@FXML
	private ChoiceBox<?> choiceBox6;

	@FXML
	private ChoiceBox<?> choiceBox7;

	@FXML
	private ChoiceBox<?> choiceBox8;

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

}
