package org.example.logicAndClasses;

public class AdminUser extends User {
    public AdminUser(String adminID, String firstName, String lastName, String address, String postalCode, String postalArea, String phoneNumber, String email, String password) {
        super(adminID, firstName, lastName, address, postalCode, postalArea, phoneNumber, email, password);
    }
}
