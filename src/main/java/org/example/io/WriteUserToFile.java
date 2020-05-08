package org.example.io;

import org.example.logicAndClasses.UserCollection;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

//Saves CUSTOMERS (.txt)

public class WriteCustomerToFile extends Writer {

    public static void save(UserCollection userCollection, Path path) throws IOException {
        Files.write(path, userCollection.toString().getBytes());
    }
}