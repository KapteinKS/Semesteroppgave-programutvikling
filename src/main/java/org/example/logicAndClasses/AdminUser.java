package org.example.logicAndClasses;

public class AdminUser extends User {
    public AdminUser(String customerID, String firstName, String lastName, String address, String postalCode, String postalArea, String phoneNumber, String email, String password) {
        super(customerID, firstName, lastName, address, postalCode, postalArea, phoneNumber, email, password);
    }
}
