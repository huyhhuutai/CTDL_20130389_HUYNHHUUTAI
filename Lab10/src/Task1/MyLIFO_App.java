package Task1;

import java.util.Arrays;
import java.util.Stack;

public class MyLIFO_App {

    // This method reserves the given array
    public static <E> void reserve(E[] array) {
        Stack<E> stack = new Stack<>();
        for (E element : array) {
            stack.push(element);
        }

        for (int i = 0; i < array.length; i++) {
            array[i] = stack.pop();
        }
    }

    // This method checks the correctness of the given input
    // i.e. ()(())[]{(())} ==> true, ){[]}() ==> false
    public static boolean isCorrect(String input) {
        Stack<Character> stack = new Stack<>();
        for (char ch : input.toCharArray()) {
            if (ch == '(' || ch == '[' || ch == '{') {
                stack.push(ch);
            } else if (ch == ')' && !stack.isEmpty() && stack.peek() == '(') {
                stack.pop();
            } else if (ch == ']' && !stack.isEmpty() && stack.peek() == '[') {
                stack.pop();
            } else if (ch == '}' && !stack.isEmpty() && stack.peek() == '{') {
                stack.pop();
            } else if (ch == ')' || ch == ']' || ch == '}') {
                return false; // Unmatched closing bracket
            }
        }
        return stack.isEmpty();
    }

    // This method evaluates the value of an expression
    // i.e. 51 + (54 *(3+2)) = 321
    public static int evaluateExpression(String expression) {
        Stack<Integer> stack = new Stack<>();
        for (char ch : expression.toCharArray()) {
            if (Character.isDigit(ch)) {
                stack.push(Character.getNumericValue(ch));
            } else if (ch == '+') {
                int operand2 = stack.pop();
                int operand1 = stack.pop();
                stack.push(operand1 + operand2);
            } else if (ch == '*') {
                int operand2 = stack.pop();
                int operand1 = stack.pop();
                stack.push(operand1 * operand2);
            }
            // Ignore other characters for simplicity
        }
        return stack.pop();
    }

    public static void main(String[] args) {
        // Testing reserve method
        Integer[] arrayToReverse = {1, 2, 3, 4, 5};
		System.out.println("Original array: " + Arrays.toString(arrayToReverse));
        reserve(arrayToReverse);
        System.out.println("Reversed array: " + Arrays.toString(arrayToReverse));

        // Testing isCorrect method
        String correctInput = "()(())[]{(())}";
        String incorrectInput = "){[]}()";
        System.out.println("Is correct: " + isCorrect(correctInput)); // Should print true
        System.out.println("Is correct: " + isCorrect(incorrectInput)); // Should print false

        // Testing evaluateExpression method
        String expression = "51+(54*(3+2))";
        System.out.println("Expression result: " + evaluateExpression(expression)); // Should print 321
    }
}
