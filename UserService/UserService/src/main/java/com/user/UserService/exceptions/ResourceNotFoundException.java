package com.user.UserService.exceptions;

public class ResourceNotFoundException extends RuntimeException {

    public ResourceNotFoundException() {
        super("Resource not found on the server");
    }

    public ResourceNotFoundException(String exception){
        super(exception);
    }
}
