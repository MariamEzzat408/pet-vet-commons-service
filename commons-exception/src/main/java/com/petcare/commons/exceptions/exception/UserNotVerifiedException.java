package com.petcare.commons.exceptions.exception;

public class UserNotVerifiedException extends RuntimeException{
    public UserNotVerifiedException(String message){
        super(message);
    }
}
