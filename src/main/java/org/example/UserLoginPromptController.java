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
		txtEmail.setStyle("");
		txtPassword.setStyle("");
		User user;
		//  Check Stored List of Person
		if ((userCollection.checkForUser(txtEmail.getText())) && (userCollection.checkPassword(txtEmail.getText(),txtPassword.getText()))) {
			//  We check by email, we use this as an identifier of the user.
			user = userCollection.getUser(txtEmail.getText());
			if (user instanceof EndUser){
				App.setCurrentUser(user);
				App.setRoot("user", 700, 640, "End User");
				App.closeWindow();
				App.setCurrentUser(user);
			} else if (user instanceof AdminUser){
				App.setCurrentUser(user);
				App.setRoot("admin", 625, 525, "Admin");
				App.closeWindow();
				App.setCurrentUser(user);
			}
		} else {
			//  If we can't find the user, we indicate an error by changing the input-border to be red
			txtEmail.setStyle("-fx-text-box-border: #ff0000");
			txtPassword.setStyle("-fx-text-box-border: #ff0000");
		}
	}

	@FXML
	void registerNewCustomer(ActionEvent event) throws IOException {
		App.setRoot("userRegistration", 313, 468, "End User");
	}
}
