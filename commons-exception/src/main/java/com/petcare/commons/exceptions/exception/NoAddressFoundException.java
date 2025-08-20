package com.petcare.commons.exceptions.exception;

public class NoAddressFoundException extends RuntimeException{

    public NoAddressFoundException (String message){
        super(message);
    }
}
