package org.example.logicAndClasses;

import javafx.beans.property.SimpleStringProperty;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
//  Superclass User, containing all attributes & methods for users, sub classes used for access controll
public abstract class User implements Serializable {
    private transient SimpleStringProperty userID;
    private transient SimpleStringProperty firstName;
    private transient SimpleStringProperty lastName;
    private transient SimpleStringProperty address;
    private transient SimpleStringProperty postalCode;
    private transient SimpleStringProperty postalArea;
    private transient SimpleStringProperty phoneNumber;
    private transient SimpleStringProperty email;
    private transient SimpleStringProperty password;

    public User(String userID, String firstName, String lastName, String address, String postalCode, String postalArea, String phoneNumber, String email, String password) {
        this.userID = new SimpleStringProperty(userID);
        this.firstName = new SimpleStringProperty(firstName);
        this.lastName = new SimpleStringProperty(lastName);
        this.address = new SimpleStringProperty(address);
        this.postalCode = new SimpleStringProperty(postalCode);
        this.postalArea = new SimpleStringProperty(postalArea);
        this.phoneNumber = new SimpleStringProperty(phoneNumber);
        this.email = new SimpleStringProperty(email);
        this.password = new SimpleStringProperty(password);
    }

    public User(){}

    public String getUserID() {
        return userID.getValue();
    }

    public void setUserID(String userID) {
        this.userID.set(userID);
    }

    public String getFirstName() {
        return firstName.getValue();
    }

    public void setFirstName(String firstName) {
        this.firstName.set(firstName);
    }

    public String getLastName() {
        return lastName.getValue();
    }

    public void setLastName(String lastName) {
        this.lastName.set(lastName);
    }

    public String getAddress() {
        return address.getValue();
    }

    public void setAddress(String address) {
        this.address.set(address);
    }

    public String getPostalCode() {
        return postalCode.getValue();
    }

    public void setPostalCode(String postalCode) {
        this.postalCode.set(postalCode);
    }

    public String getPostalArea() {
        return postalArea.getValue();
    }

    public void setPostalArea(String postalArea) {
        this.postalArea.set(postalArea);
    }

    public String getPhoneNumber() {
        return phoneNumber.getValue();
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber.set(phoneNumber);
    }

    public String getEmail() {
        return email.getValue();
    }

    public void setEmail(String email) {
        this.email.set(email);
    }

    public String getPassword() {
        return password.getValue();
    }

    public void setPassword(String password) {
        this.password.set(password);
    }

    @Override
    public String toString(){
        return "UserID:" + getUserID() + "\nName:" + getFirstName() + " " + getLastName() +"\nAdress: " + getAddress() + ", " + getPostalCode() + " " +getPostalArea()
                + "\nPhone: " + getPhoneNumber() + "\nEmail: " + getEmail() + "\nPassword: " + getPassword() + "\n-----------------------\n";
    }
    //  Method for saving as an object
    private void writeObject(ObjectOutputStream s) throws IOException{
        s.writeUTF(userID.getValue());
        s.writeUTF(firstName.getValue());
        s.writeUTF(lastName.getValue());
        s.writeUTF(address.getValue());
        s.writeUTF(postalCode.getValue());
        s.writeUTF(postalArea.getValue());
        s.writeUTF(phoneNumber.getValue());
        s.writeUTF(email.getValue());
        s.writeUTF(password.getValue());
    }
    //  Method for loading an object
    private void readObject(ObjectInputStream s) throws IOException{
        this.userID = new SimpleStringProperty(s.readUTF());
        this.firstName = new SimpleStringProperty(s.readUTF());
        this.lastName = new SimpleStringProperty(s.readUTF());
        this.address = new SimpleStringProperty(s.readUTF());
        this.postalCode = new SimpleStringProperty(s.readUTF());
        this.postalArea = new SimpleStringProperty(s.readUTF());
        this.phoneNumber = new SimpleStringProperty(s.readUTF());
        this.email = new SimpleStringProperty(s.readUTF());
        this.password = new SimpleStringProperty(s.readUTF());
    }
}
