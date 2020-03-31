package org.example.Filemanagement;


// This handles TXT.

import org.example.Deeper.Customer;
import org.example.Deeper.CustomerCollection;
import org.example.Exceptions.InvalidCustomerException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.nio.file.Files;
import java.nio.file.Path;

public class ReadCustomerFromFile extends Reader {

	public void open(CustomerCollection customerCollection, Path customerFilePath) throws IOException {
		customerCollection.removeAll();
		try (BufferedReader bufferedReader = Files.newBufferedReader(customerFilePath)){
			String line;
			while ((line = bufferedReader.readLine()) != null){
				customerCollection.addCustomer(parseCustomer(line));
			}
		}
		}


		public Customer parseCustomer(String line) throws InvalidCustomerException {
		String[] split = line.split(",");
		if (split.length != 5){
			throw new InvalidCustomerException("ERROR! Values not separated by ,");
		}
		String name = split[0];
		String email = split[3];
		String phone = split[4];

		};
}
