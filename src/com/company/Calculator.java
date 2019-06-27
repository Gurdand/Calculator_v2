package com.company;

/**
 *  Класс получает данные, производит вычисления, и выводит результат
 */
class Calculator {

    private Data data;
    private int result;

    Calculator(String string) throws CalculatorException{

        String inputString = trimAll(string); //Подготовка строки

        if (Character.isLetter(inputString.charAt(0))) {
            this.data = new DataRoman(inputString);
        } else {
            this.data = new Data(inputString);
        }

        result = calculate(data.firstNumber(), data.secondNumber(), data.operator());
    }

    /**
     * Возвращает результат вычислений в соответствии с представлением исходных чисел
     */
    void showResult(){
        System.out.println(data.displayData(result));
    }

    /**
     * Проверяет на диапозон допустимых значений, и производит вычисления
     */
    private int calculate(int firstNumber, int secondNumber, char operator) throws CalculatorException{

        if (firstNumber <= 0 || firstNumber > 10) throw new CalculatorException("Неверные данные!");
        if (secondNumber <= 0 || secondNumber > 10) throw new CalculatorException("Неверные данные!");

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

    /**
     * Убирает все пробелы из строки
     */
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
