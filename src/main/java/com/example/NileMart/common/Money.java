package com.example.NileMart.common;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;

public final class Money {
    private Money() {}
 public final static  BigDecimal ZERO=new BigDecimal("0.00");
public static BigDecimal scale(BigDecimal amount){
    return amount.setScale(2, RoundingMode.HALF_UP);
}
    public static BigDecimal of(String value){
    return new BigDecimal(value);

    }

    public static String format(BigDecimal amount ){
        DecimalFormat formatter=new DecimalFormat("#,##0.00");
        /*   (انا اللى كاتبة ال COMMENT  مش ال AI)
           جبنا الفورمات ده ازاي او كل رمز بيمثل ايه
         ---(#)---	اعرض الرقم لو موجود ومش لازم تظهر صفر لو مفيش رقم
        ---(0)---	لازم يظهر رقم حتى لو قيمته صفر
        */ return formatter.format(amount);

    }


}
