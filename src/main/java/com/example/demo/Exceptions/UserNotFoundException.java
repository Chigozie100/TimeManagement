package com.example.demo.Exceptions;


public class UserNotFoundException extends RuntimeException{
   public UserNotFoundException(String errorMessage){
        super(errorMessage);
    }
}