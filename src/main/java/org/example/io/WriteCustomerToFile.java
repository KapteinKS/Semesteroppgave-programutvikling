package org.example.io;

import org.example.Deeper.CustomerCollection;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

//Writes CUSTOMERS (.txt)

public class WriteCustomerToFile extends Writer {

	public static void save(CustomerCollection customerCollection, Path path) throws IOException {
		Files.write(path,customerCollection.toString().getBytes());
	}
}
