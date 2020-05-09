package org.example.logicAndClasses;

import org.example.App;
import org.example.io.ReadComponentsFromFile;
import org.example.io.ReadUserFromFile;

import java.io.IOException;

public class Initializer {

	public static void initialize() throws IOException, ClassNotFoundException {
		App.setUserCollection(readCustomers());
		App.setComponentCollection(readComponents());


		System.out.print("\ninitializing.");


	}

	public static ComponentCollection readComponents() throws IOException, ClassNotFoundException {
		ReadComponentsFromFile rff = new ReadComponentsFromFile();

		return rff.open();	//must return a list
	}
	public static UserCollection readCustomers() throws IOException, ClassNotFoundException {
		return ReadUserFromFile.open();
	}

	public OrderCollection readOrders(){
		return null;	//must return a list
	}

}
