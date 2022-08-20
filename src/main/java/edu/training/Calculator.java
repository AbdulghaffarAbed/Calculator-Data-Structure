package edu.training;

import java.io.IOException;
import java.util.Stack;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;


/**
 * Calculator class describe standard calculator containing the basic operations
 * such as: Addition, Subtraction, Multiplication and Division
 * operations executed for two entered numbers by the user
 * if unknown operation entered program throw an exception with Error message
 */


public class Calculator {

    // Define logger to help in debugging process
    Logger logger = Logger.getLogger(Calculator.class.getName());

    public static void main(String[] args) throws Exception {

        String userEquation;            // To store user entered equation
        double equationResult;             // To store equation result after calculate it


        // Create Object from Calculator class to call its none static methods
        Calculator calculator = new Calculator();

        // Create object from UserInputOutput to call its method
        UserInputOutput userInputOutput = new UserInputOutput();

        // Create stackOperations object to access priority and reverseStackOrder methods
        StackOperations stackOperations = new StackOperations();

        // Create Stack to store equation elements with addition and subtraction only
        Stack<String> equationStack = new Stack<>();

        // Add file handler to the Logger
        calculator.AddFileHandler();

        // Get mathematical equation from the user
        userEquation = userInputOutput.getInputs();

        // Split equation into elements of numbers and operations using regex
        calculator.logger.warning("Line 48: Regex used to split user equation to digits and operations");
        String[] splitEquation = userEquation.split("(?<=[\\d.])(?=[^\\d.])|(?<=[^\\d.])(?=[\\d.])");

        // Call method that maintain division and multiplication in user equation
        equationStack = calculator.convertToPostfix(equationStack, splitEquation);

        // Reverse stack to make it suitable for calculations because stack is LIFO
        equationStack = stackOperations.reverseStackOrder(equationStack);

        // Receive equation result after calculate it
        equationResult = calculator.calculateResult(equationStack);
        // Show equation result
        userInputOutput.showResult(userEquation, equationResult);
    }

    /**
     * method to convert equation from infix to postfix which is simplified equation calculations
     *
     * @param equationStack reference to the stack that used to store separated user equation element
     * @param splitEquation array contains user equation elements
     * @return return stack containing numbers, addition and subtraction operations
     */


    public Stack<String> convertToPostfix(Stack<String> equationStack, String[] splitEquation) {

        // Used to store equation operations
        Stack<String> operationStack = new Stack<>();
        // Create object of StackOperations class to use priority method
        StackOperations stackOperations = new StackOperations();
        /**
         * This loop used to convert equation from infex to postfix
         * it based on the priority of mathematical operations
         * where operand pushed directly to the postfix stack
         */


        for (String i : splitEquation) {

            // If the parameter is a digit not operation then add it directly to the output postfix Stack
            if (!i.equals("+") && !i.equals("-") && !i.equals("*") && !i.equals("/") && !i.equals("(") && !i.equals(")")) {
                // add digit to the main stack ( the postfix stack )
                equationStack.push(i);
            }   // First case, if stack element is "open parenthesis" then push operand directly
            else if (i.equals("(")) {
                operationStack.push(i);
            } else if (i.equals(")")) {
                // Pop all stack operations until reach "(" or stack become empty.
                while (!operationStack.isEmpty() && !"(".equals(operationStack.peek())) {
                    equationStack.push(operationStack.pop());
                }
                // Delete open parenthesis sign from the operation stack where its job done
                if (!operationStack.isEmpty())
                    operationStack.pop();
            } else {

                // The last case based on the priority if element priority greater than
                // top priority then append it to the operation stack
                // If the element priority less than top priority then pop all operation stack
                // into output postfix stack until this condition change
                while (!operationStack.isEmpty() && stackOperations.priority(i) <= stackOperations.priority(operationStack.peek())) {
                    equationStack.push(operationStack.pop());
                }
                // when the previous condition change then add operation to operation stack
                operationStack.push(i);
            }

        }

        /*
         * If there are elements still stored in operation stack then Pop them all
         * to the equation stack
         */
        logger.info("To make sure that equation stack is empty");
        if (operationStack.isEmpty() == false) {
            while (!operationStack.isEmpty()) {
                equationStack.push(operationStack.pop());
            }
        }

        // return stack containing numbers, addition and subtraction operations
        return equationStack;
    }


    /**
     * Method used to calculate the postfix equation that given in stack
     *
     * @param equationStack reference to stack contains numbers, addition and subtraction operations
     * @return the result for the complete user equation
     */


    public double calculateResult(Stack<String> equationStack) {

        // Define stack that will include numbers from the postfix equation
        Stack<Double> numbersStack = new Stack<Double>();
        // Create object that used to call arithmetic operations
        ArithmeticOperations arithmeticOperations = new ArithmeticOperations();

        /**
         * This loop used to iterate over the postfix equation elements
         * then check if the parameter is operation or digit
         * if it's digit then push it inside the numbers stack
         * if it's an operation then calculate theresult of this operation and append it to the numbers stack
         */


        while (equationStack.size() != 0) {

            // If the element is a digit
            if (!equationStack.peek().equals("+") && !equationStack.peek().equals("-")
                    && !equationStack.peek().equals("*") && !equationStack.peek().equals("/")) {
                // add digit to the numbers stack
                numbersStack.push(Double.parseDouble(equationStack.pop()));
            } else {
                // if the element is an operation
                // Pop first and second number from numbers stack to apply the operation using them
                double secondNumber = numbersStack.pop();
                double firstNumber = numbersStack.pop();

                // Display sentence to make the operation clear
                logger.info("### first number:  " + firstNumber + "  second number:  " + secondNumber + "  operation:  " + equationStack.peek());

                // apply the operation using Arithmetic operation class methods
                if (equationStack.peek().equals("+")) {
                    equationStack.pop();    // remove operation from the original stack
                    numbersStack.push(arithmeticOperations.addition(firstNumber, secondNumber));
                } else if (equationStack.peek().equals("-")) {
                    equationStack.pop();    // remove operation from the original stack
                    numbersStack.push(arithmeticOperations.subtraction(firstNumber, secondNumber));
                } else if (equationStack.peek().equals("*")) {
                    equationStack.pop();    // remove operation from the original stack
                    numbersStack.push(arithmeticOperations.multiplication(firstNumber, secondNumber));
                } else {
                    equationStack.pop();    // remove operation from the original stack
                    numbersStack.push(arithmeticOperations.division(firstNumber, secondNumber));
                }
            }
        }
        // return the equation result which is the top of numbers Stack
        logger.info("Line 189: Equation result after convert it to postfix"+numbersStack.peek());
        return numbersStack.pop();
    }

    /**
     * Add handler file to logger to print logger messages inside it
     * @throws IOException an exception for create file handler because of dealing with outer file
     */


    public void AddFileHandler() throws IOException {
        // Define file handler to print logger levels inside it
        FileHandler fileHandler = new FileHandler("C:\\Users\\AbdulghaffarA\\Intellij\\" +
                "SummerTrainingCourse\\loggerFile.log");

        // Add log handler to receive logging message
        logger.addHandler(fileHandler);
        SimpleFormatter formatter = new SimpleFormatter();
        fileHandler.setFormatter(formatter);

    }

}
