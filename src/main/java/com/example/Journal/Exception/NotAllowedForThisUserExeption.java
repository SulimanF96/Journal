package com.example.Journal.Exception;

public class NotAllowedForThisUserExeption extends RuntimeException {

    public NotAllowedForThisUserExeption( String message){
        super(message);
    }
}
