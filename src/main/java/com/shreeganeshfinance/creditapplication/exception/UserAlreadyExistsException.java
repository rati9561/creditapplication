package com.shreeganeshfinance.creditapplication.exception;

public class UserAlreadyExistsException extends RuntimeException{
    
    public UserAlreadyExistsException(String username){
        super("User with username "+username+" already exists. Kindly choose the another username!");
    }
}
