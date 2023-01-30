package com.example.ecommerce.validations;

import com.example.ecommerce.exceptions.EntityNotFoundException;
import com.example.ecommerce.responses.ValidationErrorModelResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ErrorHandler {
    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<ValidationErrorModelResponse> handleEntityNotFound(EntityNotFoundException exception) {
        ValidationErrorModelResponse response = new ValidationErrorModelResponse();
        response.setMessage(exception.getMessage());

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }
}
