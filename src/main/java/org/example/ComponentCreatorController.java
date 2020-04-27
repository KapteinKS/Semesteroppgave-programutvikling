package org.example;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import org.example.logicAndClasses.ComponentCollection;

import java.io.IOException;

public class ComponentCreatorController {

	@FXML
	private ComboBox<?> componentChooser;

	@FXML
	void cancelComponentCreator(ActionEvent event) throws IOException {

		App.closeWindow();


		/*

		THIS METHOD DISCARDS THE NEWLY GENERATED COMPONENT,
		AND REVERTS BACK TO 'admin.fxml'

		 */

	}

	@FXML
	void registerNewComponent(ActionEvent event) throws IOException {

		App.closeWindow();

		/*

		THIS SAVES THE NEW REGISTERED COMPONENT,
		AND CHANGES BACK THE VIEW TO 'admin.fxml'

		 */

	}

	@FXML
	void startComponentCreator(ActionEvent event) throws IOException {

		switch ((String) componentChooser.getValue()){
			case "Cabinet":
				App.changeSecondaryWindow("cabinet", 365, 310, "Cabinet Registration");
				break;
			case "CPU":
				App.changeSecondaryWindow("cpu", 365, 250, "CPU Registration");
				break;
			case "Fan":
				App.changeSecondaryWindow("fan", 365, 280, "Fan Registration");
				break;
			case "GraphicCard":
				App.changeSecondaryWindow("graphiccard", 365, 280, "Graphic Card Registration");
				break;
			case "Motherboard":
				App.changeSecondaryWindow("motherboard", 365, 280,"Motherboard Registration");
				break;
			case "PowerSupply":
				App.changeSecondaryWindow("powersupply", 365, 280,"Power Supply Registration");
				break;
			case "Storage":
				App.changeSecondaryWindow("storage", 365, 280,"Storage Registration");
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
