package org.example;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import org.example.logicAndClasses.AdminUser;
import org.example.logicAndClasses.CustomerCollection;
import org.example.logicAndClasses.EndUser;
import org.example.logicAndClasses.User;

import java.io.IOException;

public class UserLoginPromptController {
	CustomerCollection customerCollection = App.getCustomerRegistry();

	@FXML
	private TextField txtEmail;

	@FXML
	private PasswordField txtPassword;

	@FXML
	void login(ActionEvent event) throws IOException {
		boolean weGood = false;
		//Check Stored List of Person
		txtEmail.setStyle("");
		txtPassword.setStyle("");
		User user = null;

		if ((customerCollection.checkForCustomer(txtEmail.getText())) && (customerCollection.checkPassword(txtEmail.getText(),txtPassword.getText()))) {
			weGood = true;
			user = customerCollection.getUser(txtEmail.getText());
		} else {
			txtEmail.setStyle("-fx-text-box-border: #ff0000");
			txtPassword.setStyle("-fx-text-box-border: #ff0000");
		}
/*
		if (!(customerCollection.checkPassword(txtEmail.getText(),txtPassword.getText()))){
			weGood = false;
		}
*/
		if (weGood && user instanceof EndUser){
			App.setCurrentUserEmail(txtEmail.getText());
			App.setRoot("user", 700, 640, "End User");
		} else if (weGood && user instanceof AdminUser){
			App.setCurrentUserEmail(txtEmail.getText());
			App.setRoot("admin", 625, 525, "Admin");
		}


	}

	@FXML
	void registerNewCustomer(ActionEvent event) throws IOException {
		App.setRoot("customerRegistrator", 313, 468, "End User");
	}

}
