package com.github.VitorMarczewski.Converters;

import com.github.VitorMarczewski.Exception.UnsupportedMathOperationException;

public class NumberConverter {
    public static boolean isNumeric(String strNumber) throws IllegalArgumentException{
        if(strNumber == null || strNumber.isEmpty()) throw new UnsupportedMathOperationException("please set a numeric number!!!");
        String number = strNumber.replace(",",".");
        return number.matches("[-+]?[0-9]*\\.?[0-9]+");
    }

    public static double convertToDouble(String strNumber) throws IllegalArgumentException{
        if(strNumber == null || strNumber.isEmpty()) throw new UnsupportedMathOperationException("please set a numeric number!!!");
        String number = strNumber.replace(",",".");
        return Double.parseDouble(number);

    }
}
