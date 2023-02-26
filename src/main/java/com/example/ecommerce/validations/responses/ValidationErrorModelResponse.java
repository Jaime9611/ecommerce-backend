package com.example.ecommerce.validations.responses;

import java.util.List;

public class ValidationErrorModelResponse  extends Response{

    private List<String> errors;

    public List<String> getErrors() {
        return errors;
    }

    public void setErrors(List<String> errors) {
        this.errors = errors;
    }
}
