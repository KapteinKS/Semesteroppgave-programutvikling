package org.example.io;


// This handles .txt files.

import org.example.logicAndClasses.EndUser;
import org.example.logicAndClasses.User;
import org.example.logicAndClasses.UserCollection;
import org.example.exceptions.InvalidCustomerException;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class ReadCustomerFromFile extends Reader {

	public static void open(UserCollection userCollection, Path customerFilePath) throws IOException {
		userCollection.removeAll();
		try (BufferedReader bufferedReader = Files.newBufferedReader(customerFilePath)) {
			String line;
			while ((line = bufferedReader.readLine()) != null) {
				userCollection.addCustomer(parseCustomer(line));
			}
		} catch (InvalidCustomerException e) {
			e.printStackTrace();
		}
	}

	private static User parseCustomer(String line) throws InvalidCustomerException {
		String[] split = line.split(",");
		if (split.length != 9) {
			throw new InvalidCustomerException("ERROR! Values not separated by ',' !!");
		}

		//We could do some checks on some of these, but we should keep them as Strings, as we're not calculating ever.
		String customerId = split[0];
		String firstName = split[1];
		String lastName = split[2];
		String address = split[3];
		String postalCode = split[4];
		String postalArea = split[5];
		String phoneNumber = split[6];
		String email = split[7];
		String password = split[8];

		try {
			return new EndUser(customerId, firstName, lastName, address, postalCode, postalArea, phoneNumber, email, password);
		} catch (IllegalArgumentException e) {
			throw new InvalidCustomerException(e.getMessage());
		}
	}
}
