package org.example.exceptions;

public class IllegalRefreshRateException extends NumberFormatException{
    public IllegalRefreshRateException(String msg){
        super(msg);
    }
}
