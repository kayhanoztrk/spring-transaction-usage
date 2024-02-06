package com.example.transactionusage.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.ZonedDateTime;

/**
 * @author Kayhan Öztürk
 * @version 0.1
 * @since 0.1
 */
@RestControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {

    public ResponseEntity<Object> handlePostNotFoundException(PostNotFoundException e){
        ApiException apiException = new ApiException();
        apiException.setMessage(e.getMessage());
        apiException.setThrowable(e);
        apiException.setZonedDateTime(ZonedDateTime.now());

        return new ResponseEntity<>(apiException, HttpStatus.NOT_FOUND);
    }
}
