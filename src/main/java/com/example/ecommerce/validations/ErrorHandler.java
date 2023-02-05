package com.example.ecommerce.validations;

import com.example.ecommerce.validations.exceptions.EntityNotFoundException;
import com.example.ecommerce.validations.responses.SingleErrorResponse;
import com.example.ecommerce.validations.responses.ValidationErrorModelResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import java.util.stream.Collectors;

@ControllerAdvice
public class ErrorHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ValidationErrorModelResponse> handleNotValidArguments(MethodArgumentNotValidException exception) {
        int statusCode = HttpStatus.NOT_FOUND.value();
        ValidationErrorModelResponse response = new ValidationErrorModelResponse();
        response.setStatus(statusCode);
        response.setMessage("Fail");
        response.setErrors(exception.getAllErrors().stream().map(exc -> exc.getDefaultMessage()).collect(Collectors.toList()));

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<SingleErrorResponse> handleEntityNotFound(EntityNotFoundException exception) {
        SingleErrorResponse response = new SingleErrorResponse();
        response.setStatus(HttpStatus.NOT_FOUND.value());
        response.setMessage("Fail");
        response.setError(exception.getMessage());

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }
}
