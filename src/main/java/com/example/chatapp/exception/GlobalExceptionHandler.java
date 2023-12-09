package com.example.chatapp.exception;

import com.example.chatapp.dto.ExceptionResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler({UserNotFoundException.class})
    public ResponseEntity<ExceptionResponse> handleUserNotFoundException(UserNotFoundException exception){
        ExceptionResponse exceptionResponse = new ExceptionResponse();
        exceptionResponse.setMessage(exceptionResponse.getMessage());
        exceptionResponse.setPath(exception.getMessage());
        exceptionResponse.setStatus(404);
        return new ResponseEntity<>(exceptionResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler({UserAlreadyExistsException.class})
    public ResponseEntity<ExceptionResponse> handleUserAlreadyExistsException(UserAlreadyExistsException exception){
        ExceptionResponse exceptionResponse = new ExceptionResponse();
        exceptionResponse.setMessage(exceptionResponse.getMessage());
        exceptionResponse.setStatus(404);
        return new ResponseEntity<>(exceptionResponse, HttpStatus.NOT_FOUND);
    }



}
