package org.example.io;


// This handles .txt files.

import org.example.Deeper.Customer;
import org.example.Deeper.CustomerCollection;
import org.example.Exceptions.InvalidCustomerException;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class ReadCustomerFromFile extends Reader {

	public static void open(CustomerCollection customerCollection, Path customerFilePath) throws IOException {
		customerCollection.removeAll();
		try (BufferedReader bufferedReader = Files.newBufferedReader(customerFilePath)) {
			String line;
			while ((line = bufferedReader.readLine()) != null) {
				customerCollection.addCustomer(parseCustomer(line));
			}
		} catch (InvalidCustomerException e) {
			e.printStackTrace();
		}
	}

	private static Customer parseCustomer(String line) throws InvalidCustomerException {
		String[] split = line.split(",");
		if (split.length != 7) {
			throw new InvalidCustomerException("ERROR! Values not separated by ',' !!");
		}

		//We could do some checks on some of these, but we should keep them as Strings, as we're not calculating ever.
		String customerId = split[0];
		String name = split[1];
		String address = split[2];
		String postalCode = split[3];
		String postalArea = split[4];
		String phoneNumber = split[5];
		String email = split[6];

		try {
			return new Customer(customerId, name, address, postalCode, postalArea, phoneNumber, email);
		} catch (IllegalArgumentException e) {
			throw new InvalidCustomerException(e.getMessage());
		}
	}
}
