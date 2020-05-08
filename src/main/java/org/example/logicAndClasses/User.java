package org.example.logicAndClasses;

public abstract class User {
    private String userID;
    private String firstName;
    private String lastName;
    private String address;
    private String postalCode;
    private String postalArea;
    private String phoneNumber;
    private String email;
    private String password;

    public User(String userID, String firstName, String lastName, String address, String postalCode, String postalArea, String phoneNumber, String email, String password) {
        this.userID = userID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.postalCode = postalCode;
        this.postalArea = postalArea;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.password = password;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getPostalArea() {
        return postalArea;
    }

    public void setPostalArea(String postalArea) {
        this.postalArea = postalArea;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString(){
        return String.format("%s,%s,%s,%s,%s,%s,%s,%s", userID, firstName,address,postalCode,postalArea,phoneNumber,email,password);
    }
}
