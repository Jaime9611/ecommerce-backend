package com.example.ecommerce.validations.responses;

public class DataResponse<T> extends Response {
    private T data;

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
