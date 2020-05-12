package org.example.io;

import org.example.logicAndClasses.OrderCollection;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

//Saves ORDERCollection (.txt)

public class WriteOrderToFile extends Writer {

	public static void save(OrderCollection orderCollection) throws IOException {
		Files.write(Paths.get("orders.csv"),orderCollection.toString().getBytes());
	}
}