package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("Введите данные:");

        // Считывание строки
        String str = in.nextLine();

        try{
            // Подготовка данных
            Calculator calculator = new Calculator(str);

            //Вывод результата
            calculator.showResult();

        }catch (CalculatorException e){
            System.out.println(e.getMessage());
            System.exit(0);
        }

    }
}
