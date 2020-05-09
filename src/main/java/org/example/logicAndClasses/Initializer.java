package org.example.logicAndClasses;

import org.example.App;
import org.example.io.ReadComponentsFromFile;
import org.example.io.ReadOrderFromFile;
import org.example.io.ReadUserFromFile;

import java.io.IOException;

public class Initializer {

	public static void initialize() throws IOException, ClassNotFoundException {
		System.out.print("\ninitializing.");
		App.setUserCollection(readCustomers());
		App.setComponentCollection(readComponents());
		App.setOrderCollection(readOrders());


	}

	public static ComponentCollection readComponents() throws IOException, ClassNotFoundException {
		ReadComponentsFromFile rff = new ReadComponentsFromFile();

		return rff.open();	//must return a list
	}
	public static UserCollection readCustomers() throws IOException, ClassNotFoundException {
		return ReadUserFromFile.open();
	}

	public static OrderCollection readOrders() throws IOException {

		return (OrderCollection) ReadOrderFromFile.openOrder(); //casting, maybe change in ReadOrderFromFile.java
	}

}
