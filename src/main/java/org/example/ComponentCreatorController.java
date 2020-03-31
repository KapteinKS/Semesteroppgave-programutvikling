package org.example;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import org.example.components.Component;

import java.io.IOException;

public class ComponentCreatorController {

	@FXML
	private ComboBox<?> componentChooser;

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
	void startComponentCreator(ActionEvent event) throws IOException {

		switch ((String) componentChooser.getValue()){
			case "Cabinet":
				App.setRoot("cabinet", 365,300);
				break;
			case "CPU":
				App.setRoot("cpu", 365, 240);
				break;
			case "Fan":
				App.setRoot("fan", 365, 270);
				break;
			case "GraphicCard":
				App.setRoot("graphiccard", 365, 270);
				break;
			case "Motherboard":
				App.setRoot("motherboard", 365, 240);
				break;
			case "PowerSupply":
				App.setRoot("powersupply", 365, 270);
				break;
			case "Storage":
				App.setRoot("storage", 365, 240);
				break;
			default:

		}
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
