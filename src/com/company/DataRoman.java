package com.company;

public class DataRoman extends Data {

    private enum Roman {

        I,
        II,
        III,
        IV,
        V,
        VI,
        VII,
        VIII,
        IX,
        X
    }

    public DataRoman(String string) throws CalculatorException {
        super(string);
    }

    @Override
    protected int firstNumber() {
        return romanToInt(firstNumber);
    }

    @Override
    protected int secondNumber(){
        return romanToInt(secondNumber);
    }

    @Override
    protected String displayData(int result) {
        return toRoman(result);
    }

    private int romanToInt(String str){
        int num;
        for (Roman i: Roman.values()) {
            if (i.toString().equals(str)) {
                num = i.ordinal() + 1;
                return num;
            }
        }
        return -1;
    }

    private String toRoman(int number) {
        if (number == 100) return "C";

        StringBuilder result = new StringBuilder();

        if (number < 0) {
            number = Math.abs(number);
            result.append("Отрицательное ");
        }

        if (number >= 90) {
            number -= 90;
            result.append("XC");
        }

        if (number >= 50) {
            number -= 50;
            result.append("L");
        }

        if (number >= 40) {
            number -= 40;
            result.append("XL");
        }

        for ( ; number >= 10; ) {
            number -= 10;
            result.append("X");
        }

        if (number > 0) result.append(Roman.values()[number-1]);

        if (number == 0 && result.length() == 0) return "Ноль";

        return result.toString();
    }

}
