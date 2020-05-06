package org.example.logicAndClasses;

public class Customer {
    private String customerID;
    private String name;
    private String address;
    private String postalCode;
    private String postalArea;
    private String phoneNumber;
    private String email;

    public Customer(String customerID, String name, String address, String postalCode, String postalArea, String phoneNumber, String email) {
        this.customerID = customerID;
        this.name = name;
        this.address = address;
        this.postalCode = postalCode;
        this.postalArea = postalArea;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public String getCustomerID() {
        return customerID;
    }

    public void setCustomerID(String customerID) {
        this.customerID = customerID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
    @Override
    public String toString(){
        return String.format("%s,%s,%s,%s,%s,%s,%s", customerID,name,address,postalCode,postalArea,phoneNumber,email);
    }
}
