package org.example.exceptions;

public class IllegalResponseTimeException extends NumberFormatException{
    public IllegalResponseTimeException (String msg){
        super(msg);
    }
}
