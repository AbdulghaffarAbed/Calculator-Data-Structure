package edu.training;

import java.util.Scanner;

/**
 * UserInputOutput class used to deal with user
 * ask them to enter the arithmetic equation
 * Display equation result on the console
 */


public class UserInputOutput {

    /**
     * Ask user to enter the arithmetic operation using a message
     * Get the equation using Scanner class and return it
     *
     * @return user entered arithmetic equation
     */


    public String getInputs() {

        String userEquation;
        // Use Scanner to get inputs from the user
        Scanner scanner = new Scanner(System.in);
        // Show message to ask user to enter his equation
        System.out.println("Please enter your equation to be calculate: ");
        // Receive equation from the user
        userEquation = scanner.next();

        return userEquation;
    }

    /**
     * Method to show user equation result
     *
     * @param userEquation   describe the user equation
     * @param equationResult describe result of the user equation
     */


    public void showResult(String userEquation, double equationResult) {

        // Display equation result on the console
        System.out.println("\n"+userEquation + " = " + equationResult);
    }

}

