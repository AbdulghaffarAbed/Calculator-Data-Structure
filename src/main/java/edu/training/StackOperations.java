package edu.training;

import java.util.Stack;

/**
 * This class include operations used for stack
 */


public class StackOperations {


    /**
     * This method used to give priority for operands as follow:
     * multiplication and division have the highest and equivalent priority
     * addition and subtraction have equivalent priority which comes after multiplication and division
     * open parenthesis have the lowest priority because it must contain all operation inside it
     *
     * @param operator express equation mathematical operation
     * @return priority to the given operation
     */


    int priority(String operator) {
        if (operator.equals("*") || operator.equals("/")) {
            return 3;
        } else if (operator.equals("+") || operator.equals("-")) {
            return 2;
        } else {          // open parenthesis case "(" which must have the least priority to add all operations after it
            return 1;
        }
    }

    /**
     * Method used to revers stack using another stack to make it suitable for calculations
     * @param stack reference to the stack that contains elements to be reversed
     * @return return stack in reverse order
     */


    public Stack<String> reverseStackOrder(Stack<String> stack) {
        //create temporary stack
        Stack<String> temporaryStack = new Stack<>();

        //copy all the elements from given stack to temporary stack
        while (stack.size() > 0) {
            temporaryStack.push(stack.pop());
        }
        return temporaryStack;
    }
}
