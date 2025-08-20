package com.petcare.commons.exceptions.exception;

public class DuplicateAddressException extends RuntimeException{

    public DuplicateAddressException(String message){
        super(message);
    }
}
