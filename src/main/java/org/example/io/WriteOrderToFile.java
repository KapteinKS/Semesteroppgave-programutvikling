package org.example.io;

import org.example.Deeper.OrderCollection;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

//Saves ORDERCollection (.txt)

public class WriteOrderToFile extends Writer {

	public static void save(OrderCollection orderCollection, Path path) throws IOException {
		Files.write(path,orderCollection.toString().getBytes());
	}
}