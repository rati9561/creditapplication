package com.shreeganeshfinance.creditapplication;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.shreeganeshfinance.creditapplication.exception.UserAlreadyExistsException;
import com.shreeganeshfinance.creditapplication.exception.UserNotFoundException;
import com.shreeganeshfinance.creditapplication.pojo.ErrorMessage;

@ControllerAdvice
public class ApplicationExceptionHandler extends ResponseEntityExceptionHandler {
    
    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<Object> handleUserNotFoutException(UserNotFoundException ex){
        ErrorMessage error = new ErrorMessage(Arrays.asList(ex.getMessage()));
        return new ResponseEntity<>(error,HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(UserAlreadyExistsException.class)
    public ResponseEntity<Object> handleUserAlreadyFoutException(UserAlreadyExistsException ex){
        ErrorMessage error = new ErrorMessage(Arrays.asList(ex.getMessage()));
        return new ResponseEntity<>(error,HttpStatus.BAD_REQUEST);
    }

    @SuppressWarnings("null")
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        List<String> errors = new ArrayList<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> errors.add(error.getDefaultMessage()));
        return new ResponseEntity<>(new ErrorMessage(errors), HttpStatus.BAD_REQUEST);
   }

}
