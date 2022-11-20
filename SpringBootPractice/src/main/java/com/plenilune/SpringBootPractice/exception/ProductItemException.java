package com.plenilune.SpringBootPractice.exception;

public class ProductItemException extends RuntimeException{

    private String errorMessage;

    public  String getErrorMessage() {
        return errorMessage;
    }

    public ProductItemException(String errorMessage) {
        super(errorMessage);
        this.errorMessage = errorMessage;
    }

    public ProductItemException() {
        super();
    }
}
