package com.company;

public class Data {

    protected String firstNumber;
    protected String secondNumber;
    protected char operator = ' ';

    public Data(String inputString) throws CalculatorException{

        firstNumber = parseData(inputString)[0];
        secondNumber = parseData(inputString)[1];

        // Извлечения знака оператора
        for(char ch: inputString.toCharArray()) {
            if(ch == '+'||ch == '-'||ch == '/'||ch == '*' ){
                this.operator = ch;
                break;
            }
        }
        if (operator == ' ') throw new CalculatorException("Недопустимый оператор!");
    }

    protected int firstNumber() {
        return Integer.parseInt(firstNumber);
    }

    protected int secondNumber(){
        return Integer.parseInt(secondNumber);
    }

    protected char operator(){
        return this.operator;
    }

    protected String displayData(int result) {
        return String.valueOf(result);
    }

    protected String[] parseData(String string) throws CalculatorException{
        String[] str = string.split("[+-/*]");

        if (str.length != 2) throw new CalculatorException("Неверные данные!");

        return str;
    }

    private boolean checkInt(String[] array){
        for(String str: array){
            for(char ch: str.toCharArray()){
                if(Character.isLetter(ch)){
                    return false;
                }
            }
        }
        return true;
    }

}
