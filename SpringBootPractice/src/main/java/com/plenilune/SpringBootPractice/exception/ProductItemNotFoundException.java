package com.plenilune.SpringBootPractice.exception;

public class ProductItemNotFoundException extends ProductItemException{

    public ProductItemNotFoundException(String errorMessage) {
        super(errorMessage);
    }
}
