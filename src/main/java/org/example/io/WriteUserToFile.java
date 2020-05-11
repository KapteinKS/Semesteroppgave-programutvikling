package org.example.io;

import org.example.logicAndClasses.User;
import org.example.logicAndClasses.UserCollection;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class WriteUserToFile extends Writer {

    public static void saveUsers(List<User> users) throws IOException {
        Path path = Paths.get("users.jobj");
        try(OutputStream os = Files.newOutputStream(path);
            ObjectOutputStream out = new ObjectOutputStream(os)){
            out.writeObject(new ArrayList<>(users));
        }
    }
}