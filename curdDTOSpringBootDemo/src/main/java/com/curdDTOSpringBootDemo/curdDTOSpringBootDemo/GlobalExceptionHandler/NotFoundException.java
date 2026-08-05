package com.curdDTOSpringBootDemo.curdDTOSpringBootDemo.GlobalExceptionHandler;

public class NotFoundException extends RuntimeException{

    public NotFoundException(String message) {
    super(message);
    }
}
