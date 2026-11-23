package com.example.NileMart.common;

public class OutOfStockException extends StoreException {
    public OutOfStockException(String message) {
        super(message);
    }

    @Override
    public int status() {
        return 409 ;
    }
}
