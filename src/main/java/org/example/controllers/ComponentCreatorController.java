package org.example.controllers;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import org.example.App;

import java.io.IOException;

public class ComponentCreatorController {

	@FXML
	void cancelComponentCreator(ActionEvent event) throws IOException {

		App.setRoot("admin");

		/*

		THIS METHOD DISCARDS THE NEWLY GENERATED COMPONENT,
		AND REVERTS BACK TO 'admin.fxml'

		 */

	}

	@FXML
	void registerNewComponent(ActionEvent event) throws IOException {

		App.setRoot("admin");
		/*

		THIS SAVES THE NEW REGISTERED COMPONENT,
		AND CHANGES BACK THE VIEW TO 'admin.fxml'

		 */

	}

	@FXML
	void startComponentCreator(ActionEvent event) {

		/*

		THIS STARTS A SERIES OF PROMPTS, WHERE THE ADMIN
		ASSIGNS VALUES TO EACH OF THE COMPONENTS ATTRIBUTES.

		I BELIEVE USING PROMPTS INSTEAD OF HAVING THE ASSIGNATION
		WITHIN THE ORIGINAL WINDOW IS A BETTER SOLUTION,
		BECAUSE THE DIFFERENT TYPES OF COMPONENTS ALL HAVE DIFFERENT
		AMOUNT OF ATTRIBUTES.

		FOR A MOTHERBOARD, YOU WOULD GET, SAY 5 PROMTS,
		WHERAS FOR A GPU YOU MIGHT GET 7 PROMPTS.

		SINCE JAVAFX IS NOT DYNAMIC VIS-A-VIS GUI,
		I THINK THIS MIGHT BE THE SIMPLEST SOLUTION.

		 */

	}

}
