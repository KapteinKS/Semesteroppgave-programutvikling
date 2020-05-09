package org.example.io;

import org.example.logicAndClasses.User;
import org.example.logicAndClasses.UserCollection;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class ReadUserFromFile extends Reader {
	public static UserCollection open() throws IOException, ClassNotFoundException {
		Path path = Paths.get("users.jobj");
		try (InputStream in = Files.newInputStream(path);
			 ObjectInputStream oin = new ObjectInputStream(in)){
			List<User> users = (ArrayList<User>) oin.readObject();

			UserCollection userCollection = new UserCollection();

			for(User u : users){
				userCollection.addUser(u);
			}
			return userCollection;
		} catch (IOException ioe){
			throw new IOException("Something went wrong reading from file");
		} catch (ClassNotFoundException c){
			throw new ClassNotFoundException("File reader couldn't find a class");
		}
	}
}
