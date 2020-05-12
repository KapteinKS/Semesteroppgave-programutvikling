package org.example.logicAndClasses;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
//  Admin-user class
public class AdminUser extends User {
    public AdminUser(String adminID, String firstName, String lastName, String address, String postalCode, String postalArea, String phoneNumber, String email, String password) {
        super(adminID, firstName, lastName, address, postalCode, postalArea, phoneNumber, email, password);
    }

    private void writeObject(ObjectOutputStream s) throws IOException {
        s.defaultWriteObject();
    }

    private void readObject(ObjectInputStream s) throws IOException, ClassNotFoundException{
        s.defaultReadObject();
    }
}
