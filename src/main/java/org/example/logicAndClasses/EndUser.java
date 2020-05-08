package org.example.logicAndClasses;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class EndUser extends User {
    public EndUser(String customerID, String firstName, String lastName, String address, String postalCode, String postalArea, String phoneNumber, String email, String password) {
        super(customerID, firstName, lastName, address, postalCode, postalArea, phoneNumber, email, password);
    }

    private void writeObject(ObjectOutputStream s) throws IOException{
        s.defaultWriteObject();
    }

    private void readObject(ObjectInputStream s) throws IOException, ClassNotFoundException{
        s.defaultReadObject();
    }
}
