package org.example.Exceptions;

//Throws exception if selected components is not compatible

public class ComponentCompatibilityException extends Exception {
    public ComponentCompatibilityException(String msg) {
        super(msg);
    }
}
