package com.example.exception;

/**
 * Created by ozgen on 06.04.2017.
 */
public class ValidateException extends RuntimeException{
    public ValidateException(Long id) {
        super("Bulunamadi. ID:"+ id.toString());
    }
}
