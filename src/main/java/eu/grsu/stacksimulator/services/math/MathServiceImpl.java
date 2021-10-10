package eu.grsu.stacksimulator.services.math;

import eu.grsu.stacksimulator.model.Stack;
import org.springframework.stereotype.Component;

@Component
public class MathServiceImpl implements MathService {
    @Override
    public boolean bracketsBalanced(String expression) {
        Stack<Character> brackets = new Stack<>();

        for (Character character : expression.toCharArray()) {
            if (character == '(' || character == '[' || character == '{') {
                brackets.push(character);
            } else if (character == ')' || character == ']' || character == '}') {
                if (isOppositeBrackets(brackets.peek(), character)) {
                    brackets.pop();
                } else {
                    return false;
                }
            }
        }

        return brackets.empty();
    }

    @Override
    public double solveExpressions(String expression) {
        String postfixForm = getPostfixForm(expression);
        Stack<Double> stack = new Stack<>();
        StringBuilder complexNumber;

        for (int i = 0; i < postfixForm.length(); i++) {
            char character = postfixForm.charAt(i);

            if (character == '{') {
                complexNumber = new StringBuilder();
                i++;
                while (postfixForm.charAt(i) != '}') {
                    complexNumber.append(postfixForm.charAt(i++));
                }
                stack.push(Double.valueOf(complexNumber.toString()));
            } else {
                double secondOperand = stack.pop();
                stack.push(performOperation(stack.pop(), secondOperand, character));
            }
        }

        return stack.peek();
    }

    private double performOperation(Double firstOperand, Double secondOperand, Character operation) {
        double result = 0;
        switch (operation) {
            case '+':
                result = firstOperand + secondOperand;
                break;
            case '-':
                result = firstOperand - secondOperand;
                break;
            case '*':
                result = firstOperand * secondOperand;
                break;
            case '/':
                result = firstOperand / secondOperand;
                break;
            case '^':
                result = Math.pow(firstOperand, secondOperand);
                break;
        }
        return result;
    }

    private boolean isOppositeBrackets(Character openingBracket, Character closingBracket) {
        return openingBracket == '(' && closingBracket == ')' ||
                openingBracket == '[' && closingBracket == ']' ||
                openingBracket == '{' && closingBracket == '}';
    }

    private String getPostfixForm(String expression) {
        Stack<Character> stack = new Stack<>();
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < expression.length(); i++) {
            char character = expression.charAt(i);

            if (Character.isDigit(character) || character == '.') {
                result.append('{');
                while (i < expression.length() &&
                        (Character.isDigit(expression.charAt(i)) || expression.charAt(i) == '.')) {
                    result.append(expression.charAt(i++));
                }
                result.append('}');
                i--;
            } else if (character == ')') {
                while (!isOppositeBrackets(stack.peek(), character)) {
                    result.append(stack.pop());
                }
                stack.pop();
            } else {
                while (!stack.empty() &&
                        getElementPriority(stack.peek()) >= getElementPriority(character) &&
                        stack.peek() != '(') {
                    result.append(stack.pop());
                }
                stack.push(character);
            }
        }

        while (!stack.empty()) {
            result.append(stack.pop());
        }

        return result.toString();
    }

    private int getElementPriority(Character element) {
        if (element == '+' || element == '-') {
            return 1;
        } else if (element == '*' || element == '/') {
            return 2;
        } else if (element == '^') {
            return 3;
        } else if (element == '(') {
            return 4;
        }
        return 0;
    }
}
