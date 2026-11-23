package com.example.NileMart.model;

public enum Zone {

    //   fixed Erorr here as i used  new double instade of new Double
    //note that double is a premative type
    GREATER_CAIRO(new Double("50.00")),
    ALEX_DELTA(new Double("65.00")),
    UPPER_EGYPT(new Double("85.00")),
    REMOTE(new Double("120.00")),
    CANAL(new Double("70"));

    private final Double fee;

    Zone(Double fee) {
        this.fee = fee;
    }
}
