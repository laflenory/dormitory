package com.laflenory.dormitory.web.handler;

import com.laflenory.dormitory.web.ApplicationResponse;
import com.laflenory.dormitory.web.exception.*;
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

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<ApplicationResponse<?>> catchEntityNotFoundException(Exception error) {
        return new ResponseEntity<>(
                new ApplicationResponse<>(error.getMessage(), null),
                HttpStatus.NOT_FOUND
        );
    }

    @ExceptionHandler(EntityCreateException.class)
    public ResponseEntity<ApplicationResponse<?>> catchEntityCreateException(Exception error) {
        return new ResponseEntity<>(
                new ApplicationResponse<>(error.getMessage(), null),
                HttpStatus.BAD_REQUEST
        );
    }

    @ExceptionHandler(EntityUpdateException.class)
    public ResponseEntity<ApplicationResponse<?>> catchEntityUpdateException(Exception error) {
        return new ResponseEntity<>(
                new ApplicationResponse<>(error.getMessage(), null),
                HttpStatus.BAD_REQUEST
        );
    }

    @ExceptionHandler(EntityDeleteException.class)
    public ResponseEntity<ApplicationResponse<?>> catchEntityDeleteException(Exception error) {
        return new ResponseEntity<>(
                new ApplicationResponse<>(error.getMessage(), null),
                HttpStatus.BAD_REQUEST
        );
    }
}
