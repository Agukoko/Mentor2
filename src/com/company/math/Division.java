package com.company.math;

public class Division implements Interface {
    public int execute(int numberOne, int numberTwo) {
        if(numberTwo==0){
            throw new ArithmeticException("На 0 делить нельзя!");
        }
        return numberOne / numberTwo;
    }
}
