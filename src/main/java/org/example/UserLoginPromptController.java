package org.example;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import org.example.logicAndClasses.AdminUser;
import org.example.logicAndClasses.UserCollection;
import org.example.logicAndClasses.EndUser;
import org.example.logicAndClasses.User;

import java.io.IOException;

public class UserLoginPromptController {
	UserCollection userCollection = App.getUserCollection();

	@FXML
	private TextField txtEmail;

	@FXML
	private PasswordField txtPassword;

	@FXML
	void login(ActionEvent event) throws IOException {

		//Check Stored List of Person
		txtEmail.setStyle("");
		txtPassword.setStyle("");
		User user;

		if ((userCollection.checkForUser(txtEmail.getText())) && (userCollection.checkPassword(txtEmail.getText(),txtPassword.getText()))) {
			user = userCollection.getUser(txtEmail.getText());
			if (user instanceof EndUser){
				App.setCurrentUserEmail(txtEmail.getText());
				App.setRoot("user", 700, 640, "End User");
				App.closeWindow();
				App.setCurrentUser(user);
			} else if (user instanceof AdminUser){
				App.setCurrentUserEmail(txtEmail.getText());
				App.setRoot("admin", 625, 525, "Admin");
				App.closeWindow();
				App.setCurrentUser(user);
			}
		} else {
			txtEmail.setStyle("-fx-text-box-border: #ff0000");
			txtPassword.setStyle("-fx-text-box-border: #ff0000");
		}
	}

	@FXML
	void registerNewCustomer(ActionEvent event) throws IOException {
		App.setRoot("userRegistration", 313, 468, "End User");
	}

}
