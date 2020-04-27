package org.example.logicAndClasses;

import org.example.io.ReadComponentsFromFile;
import org.example.io.ReadCustomerFromFile;

import java.nio.file.Path;
import java.util.List;

public class Initializer {

	public void initialize() {

		// This function populates the Component-ComboBoxes in the User GUI
		// Meaning; this function reads from the .jobj file containing all
		// our components.

		// When a new component is added by admin, the program thusly needs
		// to be rebooted, in order to display the changes.
		//

		System.out.print("\ninitializing.");
		readComponents();
		readCustomers();		// these don't work, but this
		readOrders();
		//** Maybe surround the following logic in a new thread (Logic that reads data into an ObservableArrayList)


		//**

	}

	public ComponentCollection readComponents(){
		return null;	//must return a list
	}
	public CustomerCollection readCustomers(){
		return null;	//must return a list
	}
	public OrderCollection readOrders(){
		return null;	//must return a list
	}

}
