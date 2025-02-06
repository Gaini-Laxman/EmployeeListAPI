package com.javafullstackguru.exception;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class GlobalException {

    @ExceptionHandler(EmployeeAlreadyExistException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public ResponseEntity<String> handleEmployeeAlreadyExistException(EmployeeAlreadyExistException employeeAlreadyExistException){
        return new ResponseEntity<>(employeeAlreadyExistException.getMessage(), HttpStatus.CONFLICT);
    }

    @ExceptionHandler(EmployeeNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<String> handleEmployeeNotFoundException(EmployeeNotFoundException employeeNotFoundException){
        return new ResponseEntity<>(employeeNotFoundException.getMessage(), HttpStatus.NOT_FOUND);
    }

}
