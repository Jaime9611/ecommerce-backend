package com.example.ecommerce.validations.responses;

public class SingleErrorResponse extends Response {
    private String error;

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}
