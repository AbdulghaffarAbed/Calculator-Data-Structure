package edu.training;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


/**
 * edu.training.ArithmeticOperationsTest contains test cases for the Arithmetic operations
 */


class ArithmeticOperationsTest {

    /**
     * Methods to test Addition operation
     */

    // Add 5 to 4 where expected output is 9
    @Test
    void fivePlusFourEqualNine() {
        ArithmeticOperations arithmeticOperations = new ArithmeticOperations();
        assertEquals(arithmeticOperations.addition(5, 4), 9);

    }

    // Add 7.4 to 2.9 where expected output is 10.3
    @Test
    void sevenPointFourPlusTwoPointNineEqualTenPointThree() {
        ArithmeticOperations arithmeticOperations = new ArithmeticOperations();
        assertEquals(arithmeticOperations.addition(7.4, 2.9), 10.3);
    }

    // Add -8 to 4 where expected output is -4
    @Test
    void minusAdditionResultTest() {
        ArithmeticOperations arithmeticOperations = new ArithmeticOperations();
        assertEquals(arithmeticOperations.addition(-8, 4), -4);
    }

    /**
     * Methods to test Subtraction operation
     */


    // subtract 3 from 7 where expected output is -4
    @Test
    void threeMinusSevenEqualMinusFour() {
        ArithmeticOperations arithmeticOperations = new ArithmeticOperations();
        assertEquals(arithmeticOperations.subtraction(3, 7), -4);
    }

    // subtract 3 from -3 where expected output is 6
    @Test
    void threeMinusMinusThreeEqualSix() {
        ArithmeticOperations arithmeticOperations = new ArithmeticOperations();
        assertEquals(arithmeticOperations.subtraction(3, -3), 6);
    }

    // subtract 3.4 from 2.1 where expected output is 1.3
    @Test
    void threePointFourMinusTwoPointOneEqualOnePointThree() {
        ArithmeticOperations arithmeticOperations = new ArithmeticOperations();
        assertEquals(arithmeticOperations.subtraction(3.4, 2.1), 1.3);
    }

    /**
     * Methods to test Multiplication operation
     */

    @Test
    void fiveMulZeroEqualZero() {
        ArithmeticOperations arithmeticOperations = new ArithmeticOperations();
        assertEquals(arithmeticOperations.multiplication(3, 0), 0);
    }

    @Test
    void oneMulMinusOneEqualMinusOne() {
        ArithmeticOperations arithmeticOperations = new ArithmeticOperations();
        assertNotEquals(arithmeticOperations.multiplication(1, -1), 1);
    }

    /**
     * Methods to test Division operation
     */

    @Test
    void nineDivThreeEqualThree() {
        ArithmeticOperations arithmeticOperations = new ArithmeticOperations();
        assertEquals(arithmeticOperations.division(9, 3), 3);
    }

    @Test
    void minusOneOnFourEqualMinusQuartor() {
        ArithmeticOperations arithmeticOperations = new ArithmeticOperations();
        assertEquals(arithmeticOperations.division(-1, 4), -0.25);
    }

    @Test
    void divisionOnZeroEqualException() {
        ArithmeticOperations arithmeticOperations = new ArithmeticOperations();
        assertThrows(Exception.class, () -> {
            arithmeticOperations.division(12.6, 0);
        });
    }
}