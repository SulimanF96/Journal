package com.example.Journal.Advice;

import com.example.Journal.Exception.ErrorMessage;
import com.example.Journal.Exception.InputFieldException;
import com.example.Journal.Exception.NotAllowedForThisUserExeption;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class JournalControllerAdvice {

//    @ExceptionHandler(InputFieldException.class)
//    public ResponseEntity<ErrorMessage>  inputFieldNotFoundException(InputFieldException e){
//        return new ResponseEntity<ErrorMessage>(new ErrorMessage(e.getMessage()), HttpStatus.BAD_REQUEST);
//    }

    @ExceptionHandler(NotAllowedForThisUserExeption.class)
    public ResponseEntity<ErrorMessage>  notAllowedForThisUserExeption(NotAllowedForThisUserExeption e){
        return new ResponseEntity<ErrorMessage>(new ErrorMessage(e.getMessage()), HttpStatus.FORBIDDEN);
    }

//    @ExceptionHandler(Exception.class)
//    public ResponseEntity<ErrorMessage> ExceptionHandler(Exception e) {
//        return new ResponseEntity<ErrorMessage>(new ErrorMessage(e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
//    }

}
