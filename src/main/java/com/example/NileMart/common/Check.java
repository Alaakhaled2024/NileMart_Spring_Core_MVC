package com.example.NileMart.common;

import java.util.*;
import java.util.function.Supplier;

public final class Check {
    private Check(){}
    public static <T> T found (Optional<T> value, Supplier<? extends StoreException > error){
    if (value.isPresent()){
        return value.get() ;
    }
        throw error.get();
    }

}
