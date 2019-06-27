package com.company;

public class Calculator {

    private Data data;

    public Calculator(String string) throws CalculatorException{

        String inputString = trimAll(string); //Подготовка строки

        if (Character.isLetter(inputString.charAt(0))) {
            this.data = new DataRoman(inputString);
        } else {
            this.data = new Data(inputString);
        }
    }

    public void showResult(){

        int result = calculate(data.firstNumber(), data.secondNumber(), data.operator());

        System.out.println(data.displayData(result));

    }

    private int calculate(int firstNumber, int secondNumber, char operator){

        switch (operator){
            case '+':
                return firstNumber + secondNumber;
            case '-':
                return firstNumber - secondNumber;
            case '*':
                return firstNumber * secondNumber;
            case '/':
                return firstNumber / secondNumber;
        }
        return -1;
    }

    private String trimAll(String string){
        char[] charArray = string.toCharArray();
        StringBuilder str = new StringBuilder();
        for (char s: charArray){
            if (s == 32){
                continue;
            }
            str.append(s);
        }
        return str.toString();
    }

}
