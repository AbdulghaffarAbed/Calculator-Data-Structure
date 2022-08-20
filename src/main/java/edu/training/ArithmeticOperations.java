package edu.training;

import java.text.DecimalFormat;

/**
 * Class contains basic calculator operations
 * Addition, Subtraction, Multiplication and Division
 */


public class ArithmeticOperations {

    // DecimalFormat class used to round results to two digits
    // This is important for subtraction operation because it returns non-exact value
    // for example 3.4-3.1 = 0.29999999998 so, DecimalFormat class solve this problem and return the exact result 0.3
    private static final DecimalFormat decimalFormat = new DecimalFormat("0.00");

    /**
     * Describe the addition operation of two given numbers
     * @param firstNumber first equation number
     * @param secondNumber second equation number
     * @return the summation of the two given numbers
     */


    public double addition(double firstNumber, double secondNumber) {

        return Double.parseDouble(decimalFormat.format(firstNumber + secondNumber));
    }

    /**
     * Describe the subtraction operation of two given numbers
     * @param firstNumber first equation number
     * @param secondNumber second equation number
     * @return the subtraction of the two given numbers
     */


    public double subtraction(double firstNumber, double secondNumber) {

        return Double.parseDouble(decimalFormat.format(firstNumber - secondNumber)) ;
    }

    /**
     * Describe the multiplication operation of two given numbers
     * @param firstNumber first equation number
     * @param secondNumber second equation number
     * @return the multiplication of the two given numbers
     */


    public double multiplication(double firstNumber, double secondNumber) {

        return Double.parseDouble(decimalFormat.format(firstNumber * secondNumber));
    }

    /**
     * Describe the division operation of two given numbers
     * In addition, check if the second number which is the denominator equal to zero then throw exception
     * because it's not possible for the denominational to be zero
     * @param firstNumber first equation number
     * @param secondNumber second equation number
     * @return the division of the two given numbers
     */


    public double division(double firstNumber, double secondNumber) {

        if (secondNumber == 0)
            throw new ArithmeticException("Division by zero");
        else
            return Double.parseDouble(decimalFormat.format(firstNumber / secondNumber));
    }
}
