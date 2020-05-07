package org.example;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import org.example.logicAndClasses.CustomerCollection;

import java.io.IOException;

public class UserLoginPromptController {
	CustomerCollection customerCollection = App.getCustomerRegistry();

	@FXML
	private TextField txtEmail;

	@FXML
	private PasswordField txtPassword;

	@FXML
	void login(ActionEvent event) throws IOException {
		boolean weGood = true;
		//Check Stored List of Person
		txtEmail.setStyle("");
		txtPassword.setStyle("");

		if (!(customerCollection.checkForCustomer(txtEmail.getText()))) {
			txtEmail.setStyle("-fx-text-box-border: #ff0000");
			weGood = false;
		}

		if (!(customerCollection.checkPassword(txtEmail.getText(),txtPassword.getText()))){
			txtPassword.setStyle("-fx-text-box-border: #ff0000");
			weGood = false;
		}

		if (weGood){
			App.setCurrentUserEmail(txtEmail.getText());
			App.setRoot("user", 700, 640, "End User");
		}


	}

	@FXML
	void registerNewCustomer(ActionEvent event) throws IOException {
		App.setRoot("customerRegistrator", 313, 468, "End User");
	}

}
