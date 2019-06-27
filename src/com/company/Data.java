package com.company;

/**
 *  Класс извлекает данные из входящей строки и обрабатывает их в представлении арабских чисел
 */
public class Data {

    String firstNumber;
    String secondNumber;
    private char operator = ' ';

    Data(String inputString) throws CalculatorException{

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

    /**
     * Возвращает первое число в Integer
     */
    protected int firstNumber() throws CalculatorException {
        if (checkInt(firstNumber)) {
            throw new CalculatorException("Введены неверные данные!");
        }
        return Integer.parseInt(firstNumber);
    }

    /**
     * Возвращает второе число в Integer
     */
    protected int secondNumber() throws CalculatorException{
        if (checkInt(secondNumber)) {
            throw new CalculatorException("Введены неверные данные!");
        }
        return Integer.parseInt(secondNumber);
    }

    /**
     * Возвращает символ оператора
     */
    char operator(){
        return this.operator;
    }

    /**
     * Возвращает строчное представление числа
     */
    protected String displayData(int result) {
        return String.valueOf(result);
    }

    /**
     * Разделяет исходную строку на строки с числами
     */
    private String[] parseData(String string) throws CalculatorException{
        String[] str = string.split("[+-/*]");

        if (str.length != 2) throw new CalculatorException("Неверные данные!");

        return str;
    }

    /**
     * Проверяет строку на возможность конвертации в число (для Integer.parseInt)
     */
    private boolean checkInt(String string){
            for(char ch: string.toCharArray()){
                if(Character.isLetter(ch)){
                    return true;
                }
            }

        return false;
    }

}
