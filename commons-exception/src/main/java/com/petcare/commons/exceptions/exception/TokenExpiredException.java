package com.petcare.commons.exceptions.exception;

public class TokenExpiredException extends RuntimeException {

    public TokenExpiredException(String message){
        super(message);
    }

}
