package io.zipcoder;

import java.util.Arrays;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.*;

public class ParenChecker {

    private String inputExpression;
    private Stack<String> stack;

    public ParenChecker() {
        this.stack = new Stack<String>();
    }

    public ParenChecker(String inputExpression) {
        this.inputExpression = inputExpression;
        this.stack = new Stack<String>();
    }

    public Stack<String> getStack() {
        return stack;
    }

    public boolean isInputLengthEven(String input) {
        boolean isInputLengthEven = true;
        if (input.length() % 2 != 0) {
            isInputLengthEven = false;
        }
        return isInputLengthEven;
    }

    public boolean isFirstCharCorrect(String input) {
        boolean isFirstCharCorrect = true;
        String incorrectFirstCharStringPattern = "^[)}\\]]";
        Pattern incorrectFirstCharPattern = Pattern.compile(incorrectFirstCharStringPattern);
        Matcher firstCharMatcher = incorrectFirstCharPattern.matcher(input);

        if (firstCharMatcher.find()) {
            isFirstCharCorrect = false;
        }
        return isFirstCharCorrect;
    }

    public boolean isLastCharCorrect(String input) {
        boolean isLastCharCorrect = true;
        String incorrectLastCharStringPattern = "[({\\[]$";

        Pattern incorrectLastCharPattern = Pattern.compile(incorrectLastCharStringPattern);
        Matcher lastCharMatcher = incorrectLastCharPattern.matcher(input);

        if (lastCharMatcher.find()) {
            isLastCharCorrect = false;
        }
        return isLastCharCorrect;
    }

    public boolean areAllParensPaired(String input) {
        boolean areAllParensPaired = true;

        String[] inputStringArray = input.split("");
        this.stack.addAll(Arrays.asList(inputStringArray));

        for (int i = 0; i < stack.size() - 1; i++) {
            if (stack.get(i).equals("{")) {
                if (stack.get(i + 1).equals("[") || stack.get(i + 1).equals("(")) {
                    continue;
                }
                if (stack.get(i + 1).equals("}")) {
                    stack.remove(i);
                    stack.remove(i);
                    if (i == 0) i--;
                    else i -= 2;
                    continue;
                }
                if (stack.get(i + 1).equals("]") || stack.get(i + 1).equals(")")) {
                    break;
                }
                // Removing any other characters doesn't work right now.
//                else {
//                    stack.remove(i + 1);
//                    i--;
//                    continue;
//                }
            }

            if (stack.get(i).equals("[")) {
                if (stack.get(i + 1).equals("{") || stack.get(i + 1).equals("(")) {
                    continue;
                }
                if (stack.get(i + 1).equals("]")) {
                    stack.remove(i);
                    stack.remove(i);
                    if (i == 0) i--;
                    else i -= 2;
                    continue;
                }
                if (stack.get(i + 1).equals("}") || stack.get(i + 1).equals(")")) {
                    break;
                }
            }

            if (stack.get(i).equals("(")) {
                if (stack.get(i + 1).equals("{") || stack.get(i + 1).equals("[")) {
                    continue;
                }
                if (stack.get(i + 1).equals(")")) {
                    stack.remove(i);
                    stack.remove(i);
                    if (i == 0) i--;
                    else i -= 2;
                    continue;
                }
                if (stack.get(i + 1).equals("}") || stack.get(i + 1).equals("]")) {
                    break;
                }
            }
        }

        if (stack.size() != 0) {
            areAllParensPaired = false;
        }
        return areAllParensPaired;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (String string : stack) {
            sb.append(string);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        ParenChecker parenChecker = new ParenChecker();

        String inputExpression = "{}{}{}{{}}";
        System.out.println("isInputLengthEven: " + parenChecker.isInputLengthEven(inputExpression));
        System.out.println("isFirstCharCorrect: " + parenChecker.isFirstCharCorrect(inputExpression));
        System.out.println("isLastCharCorrect: " + parenChecker.isLastCharCorrect(inputExpression));
        System.out.println();
        System.out.printf("%25s", "areAllParensPaired: " + parenChecker.areAllParensPaired(inputExpression));
        System.out.println();
        System.out.printf("%20s", "original string: ");
        System.out.println(inputExpression);
        System.out.printf("%23s", "final string: " + parenChecker.toString());

    }
}