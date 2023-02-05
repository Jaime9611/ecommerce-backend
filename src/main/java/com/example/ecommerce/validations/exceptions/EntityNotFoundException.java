package com.example.ecommerce.validations.exceptions;

import java.util.UUID;

public class EntityNotFoundException extends RuntimeException {
    public EntityNotFoundException(String entityType, UUID id){
        super(String.format("%s with id: %s not found", entityType, id));
    }

    public EntityNotFoundException(String entityType){
        super(String.format("%s with id: %s not found", entityType));
    }
}
