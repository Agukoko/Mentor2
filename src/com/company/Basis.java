package com.company;

public class Basis {

    public static boolean isCorrectStringForArab(String input){
        return input.matches("(^\\d0?)([\\s])*[-+/*]([\\s])*(\\d0?$)");
    }

    public static boolean isCorrectStringForRoman(String input){
        return input.matches("^(I|II|III|IV|V|VI|VII|VIII|IX|X)([\\s])*[-+/*]([\\s])*(I|II|III|IV|V|VI|VII|VIII|IX|X$)");
    }

    public static boolean isNegativeNumberForRoman(int number){
        if(number < 0){
            return true;
        }
        return false;
    }

}
