package org.example;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import org.example.componentClasses.CPU;
import org.example.componentClasses.RAM;

import java.io.IOException;

public class RamController {

	@FXML
	private TextField inName;

	@FXML
	private TextField inManufac;

	@FXML
	private TextField inSize;

	@FXML
	private TextField inType;

	@FXML
	private TextField inSticks;

	@FXML
	private Button regButton;

	@FXML
	private Button cancelButton;

	@FXML
	private TextField inPrice;

	@FXML
	void cancelRegistration(ActionEvent event) throws IOException {
		App.changeSecondaryWindow("componentCreator", 460, 360, "Component Creator");
	}

	@FXML
	void registerCPU(ActionEvent event) throws IOException {
		String name = inName.getText();
		String manufacturer = inManufac.getText();
		String size = inSize.getText();
		String memoryType = inType.getText();

		try{
			double price = Double.parseDouble(inPrice.getText());
			int amountsOfRAMPieces = Integer.parseInt(inSticks.getText());
			RAM ram = new RAM(name, manufacturer, price, size, memoryType, amountsOfRAMPieces);
			App.saveToCollection(ram);

		} catch (Exception e){
			System.err.println(e.getMessage());
		}

		App.changeSecondaryWindow("componentCreator", 460, 360, "Component Creator");

	}

}
