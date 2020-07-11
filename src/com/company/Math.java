package com.company;

import com.company.math.*;

import java.io.BufferedReader;
        import java.io.IOException;
        import java.io.InputStreamReader;


public class Math {
    private Interface currentOperation;

    public void start(){
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String numbersAndOperation = "";
        int resultNumber;

        while (true) {  //повтор ввода
            try {
                System.out.println("Input:");
                numbersAndOperation = reader.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (Basis.isCorrectStringForArab(numbersAndOperation)) {
                numbersAndOperation = numbersAndOperation.replaceAll(" ", "");
                String[] num1Andnum2 = numbersAndOperation.split("[-+/*]");
                int numb1 = Integer.parseInt(num1Andnum2[0]);
                int numb2 = Integer.parseInt(num1Andnum2[1]);
                currentOperation = getMathOperation(numbersAndOperation);
                System.out.println("Output:");
                resultNumber = result(currentOperation, numb1, numb2);
                System.out.println(resultNumber);
            } else if (Basis.isCorrectStringForRoman(numbersAndOperation)) {
                numbersAndOperation = numbersAndOperation.replaceAll(" ", "");
                String[] num1Andnum2 = numbersAndOperation.split("[-+/*]");
                currentOperation = getMathOperation(numbersAndOperation);
                resultNumber = result(currentOperation, Rom.letterToNumber(num1Andnum2[0]), Rom.letterToNumber(num1Andnum2[1]));
                System.out.println("Output:");
                if(Basis.isNegativeNumberForRoman(resultNumber)){ //как то так
                    System.out.println("-"+Rom.toRoman(java.lang.Math.abs(resultNumber)));// убираем знак
                } else {
                    System.out.println(Rom.toRoman(resultNumber));
                }
            } else {
                throw new RuntimeException();

            }
        }

    }

    public int result(Interface operation, int numberOne, int numberTwo){
        return operation.execute(numberOne,numberTwo);
    }

    public Interface getMathOperation(String inputOp){
        if (inputOp.contains("-")) {
            return   new Subtraction();
        } else if (inputOp.contains("+")) {
            return   new Addition();
        } else if (inputOp.contains("*")) {
            return new Multiplication();
        } else if (inputOp.contains("/")) {
            return new Division();
        }
        return null;
    }

}

