package com.laflenory.dormitory.handler;

import com.laflenory.dormitory.web.ApplicationResponse;
import com.laflenory.dormitory.web.exception.EntityExistsException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(EntityExistsException.class)
    public ResponseEntity<ApplicationResponse<?>> catchEntityExistsException(Exception error) {
        return new ResponseEntity<>(
                new ApplicationResponse<>(error.getMessage(), null),
                HttpStatus.BAD_REQUEST
        );
    }
}
