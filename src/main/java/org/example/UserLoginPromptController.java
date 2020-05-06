package org.example;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.io.IOException;

public class UserLoginPromptController {

	@FXML
	private TextField txtEmail;

	@FXML
	private PasswordField txtPassword;

	@FXML
	void login(ActionEvent event) throws IOException {
		//Check Stored List of Persons
		App.setRoot("user", 700, 640, "End User");

	}

	@FXML
	void registerNewCustomer(ActionEvent event) throws IOException {
		App.setRoot("customerRegistrator", 313, 468, "End User");
	}

}
