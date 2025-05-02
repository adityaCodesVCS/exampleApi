package com.exampleApi.exception;

public class ResourceNotFound extends RuntimeException {
    //Here I should create this constructor with 'super' keyword so that "message" goes to POSTMAN.
    public ResourceNotFound(String message) {
        super(message);
    }
}
