package org.example.io;

import org.example.componentClasses.Component;
import org.example.logicAndClasses.OrderCollection;
import org.example.logicAndClasses.User;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

//  Class containing methods for saving the three data-sets to files.
public class Writer {
	//  Method for saving components to a .jobj file
	public static void saveComponents(List<Component> objects) throws IOException {
		Path path = Paths.get("components.jobj");
		try (OutputStream os = Files.newOutputStream(path);
			 ObjectOutputStream out = new ObjectOutputStream(os)){
			out.writeObject(new ArrayList<>(objects));
		}
	}
	//  Method for saving users to a .jobj file
	public static void saveUsers(List<User> users) throws IOException {
		Path path = Paths.get("users.jobj");
		try(OutputStream os = Files.newOutputStream(path);
			ObjectOutputStream out = new ObjectOutputStream(os)){
			out.writeObject(new ArrayList<>(users));
		}
	}
	//  Method for saving orders to a .csv file
	public static void saveOrders(OrderCollection orderCollection) throws IOException {
		Files.write(Paths.get("orders.csv"),orderCollection.toString().getBytes());
	}
}
