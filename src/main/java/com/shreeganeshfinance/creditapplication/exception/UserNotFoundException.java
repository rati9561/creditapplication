package com.shreeganeshfinance.creditapplication.exception;

public class UserNotFoundException extends RuntimeException {
    
    public UserNotFoundException(Long id){
        super("User ID '"+id+"' not found. Kindly check the user id before submitting the request.");
    }

    public UserNotFoundException(String message){
        super(message);
    }
}
