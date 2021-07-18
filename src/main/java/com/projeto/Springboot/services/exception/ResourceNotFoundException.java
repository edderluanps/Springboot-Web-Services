package com.projeto.Springboot.services.exception;

public class ResourceNotFoundException  extends RuntimeException{
    
    private static final long serialVersionUID = 1L;
    
    public ResourceNotFoundException(Object idException){
        super("Resource not found. Id " + idException);
    }
    
}
