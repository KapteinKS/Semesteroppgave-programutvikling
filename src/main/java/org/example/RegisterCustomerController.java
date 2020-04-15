package org.example;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class RegisterCustomerController {

	@FXML
	private TextField txtName;

	@FXML
	private TextField txtAddress;

	@FXML
	private TextField txtPostalCode;

	@FXML
	private TextField txtPostalArea;

	@FXML
	private TextField txtPhoneNumber;

	@FXML
	private TextField txtEmail;

	@FXML
	private Label lblCustomerInputError;

	@FXML
	void registerNewCustomer(ActionEvent event) {
		String name = txtName.getText();
		// Add a checker, if wrong, reset text, and set border red.

		String address = txtAddress.getText();
		String postalCode = txtPostalCode.getText();
		String phoneNumber = txtPhoneNumber.getText();
		String email = txtEmail.getText();

		// IF NOT ALREADY CUSTOMER (email-check)
		String customerID = "" + 9999; // This is a dummy value, must actually check last in customerRegistry, then +1

	}

}
