package org.example;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.io.IOException;

public class CustomerRegistratorController {

	@FXML
	private TextField txtFirstName;

	@FXML
	private TextField txtLastName;

	@FXML
	private TextField txtAddress;

	@FXML
	private TextField txtPostCode;

	@FXML
	private TextField txtPostArea;

	@FXML
	private TextField txtPhoneNumber;

	@FXML
	private TextField txtEmail;

	@FXML
	private PasswordField txtPassword;

	@FXML
	private PasswordField txtPasswordConfirm;

	@FXML
	private Label lblResult;

	@FXML
	void cancel(ActionEvent event) throws IOException {
		App.setRoot("userLoginPrompt", 250, 290, "Login");

	}

	@FXML
	void registerNewCustomer(ActionEvent event) throws IOException {

		App.setRoot("user", 700, 640, "End User");
	}

}
