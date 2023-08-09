package com.onlinecourse.userservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * clase controller advice que maneja los dos tipos de excepciones tranajadas en el ms
 */
@RestControllerAdvice
public class ControllerAdvice {

    /**
     * metodo que maneja los RequestException
     * @param ex
     * @return
     */
    @ExceptionHandler(value = RequestException.class)
    public ResponseEntity<ErrorObject> requestExceptionHandler(RequestException ex){
        ErrorObject error =  ErrorObject.builder().code(ex.getCode()).message(ex.getMessage()).build();
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    /**
     * metodo que maneja los BusinessException
     * @param ex
     * @return
     */
    @ExceptionHandler(value = BusinessException.class)
    public ResponseEntity<ErrorObject> businessExceptionHandler(BusinessException ex){
        ErrorObject error =  ErrorObject.builder().code(ex.getCode()).message(ex.getMessage()).build();
        return new ResponseEntity<>(error, ex.getStatus());
    }

}
