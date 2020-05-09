package org.example;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import org.example.logicAndClasses.EndUser;
import org.example.logicAndClasses.UserCollection;

import java.io.IOException;

public class UserRegistrationController {
	UserCollection userCollection = App.getUserCollection();

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


		App.setRoot("userLoginPrompt", 290, 300, "Login");

	}

	@FXML
	void registerNewCustomer(ActionEvent event) throws IOException, InterruptedException {

		txtFirstName.setStyle("");
		txtLastName.setStyle("");
		txtAddress.setStyle("");
		txtPostCode.setStyle("");
		txtPostArea.setStyle("");
		txtPhoneNumber.setStyle("");
		txtEmail.setStyle("");
		txtPassword.setStyle("");
		txtPasswordConfirm.setStyle("");

		if(!(userCollection.checkForUser(txtEmail.getText()))) {
			boolean goodToGo = true;

			String firstName = txtFirstName.getText(),
					lastName = txtLastName.getText(),
					address = txtAddress.getText(),
					postCode = txtPostCode.getText(),
					postArea = txtPostArea.getText(),
					phoneNumber = txtPhoneNumber.getText(),
					email = txtEmail.getText();

			if (firstName.isEmpty() || !(firstName.matches("[A-ZÆØÅ][a-zæøå]*"))) {
				txtFirstName.setStyle("-fx-text-box-border: #ff0000");
				goodToGo = false;
			}
			if (lastName.isEmpty() || !(lastName.matches("[A-ZÆØÅ][a-zæøå]*"))) {
				txtLastName.setStyle("-fx-text-box-border: #ff0000");
				goodToGo = false;
			}
			if (address.isEmpty()) { //Address regex needed
				txtAddress.setStyle("-fx-text-box-border: #ff0000");
				goodToGo = false;
			}
			if (postCode.isEmpty() || !(postCode.matches("[0-9]{4}"))) {
				txtPostCode.setStyle("-fx-text-box-border: #ff0000");
				goodToGo = false;
			}
			if (postArea.isEmpty() || !(postArea.matches("[A-ZÆØÅ][a-zæøå]+"))) {
				txtPostArea.setStyle("-fx-text-box-border: #ff0000");
				goodToGo = false;
			}	//phone Regex is bad
			if (phoneNumber.isEmpty() || !(phoneNumber.matches("[+]?[0-9]?[0-9]?\\s*[0-9]\\s*[0-9]\\s*[0-9]\\s*[0-9]\\s*[0-9]\\s*[0-9]\\s*[0-9]\\s*[0-9]\\s*"))){
				txtPhoneNumber.setStyle("-fx-text-box-border: #ff0000");
				goodToGo = false;
			}
			if (email.isEmpty() || !(email.matches("^([a-zA-Z0-9_\\-\\.]+)@([a-zA-Z0-9_\\-\\.]+)\\.([a-zA-Z]{2,5})$"))){
				txtEmail.setStyle("-fx-text-box-border: #ff0000");
				goodToGo = false;
			}

			String password = txtPassword.getText();

			if (password.isEmpty() || !(password).equals(txtPasswordConfirm.getText())){
				txtPassword.setStyle("-fx-text-box-border: #ff0000");
				txtPasswordConfirm.setStyle("-fx-text-box-border: #ff0000");
				goodToGo = false;
			}

			if (goodToGo){
				App.saveToUserCollection(new EndUser((String.format("%05d",App.getNewUserID())),
						firstName, lastName, address, postCode, postArea, phoneNumber, email, password));
				App.setCurrentUserEmail(email);
				App.setRoot("user", 700, 640, "End User");
			}

		}
		else {
			txtEmail.setStyle("-fx-text-box-border: #ff00ff");
			lblResult.setText("Denne eposten fins allerede i databasen vår!");
		}
	}

}
