package io.zipcoder;

import java.util.Arrays;
import java.util.EnumSet;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.*;

// ASSESS1 - JPMC QUESTION 1

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
        String incorrectFirstCharStringPattern = "^[)}\\]>]";
        Pattern incorrectFirstCharPattern = Pattern.compile(incorrectFirstCharStringPattern);
        Matcher firstCharMatcher = incorrectFirstCharPattern.matcher(input);

        if (firstCharMatcher.find()) {
            isFirstCharCorrect = false;
        }
        return isFirstCharCorrect;
    }

    public boolean isLastCharCorrect(String input) {
        boolean isLastCharCorrect = true;
        String incorrectLastCharStringPattern = "[({\\[<]$";

        Pattern incorrectLastCharPattern = Pattern.compile(incorrectLastCharStringPattern);
        Matcher lastCharMatcher = incorrectLastCharPattern.matcher(input);

        if (lastCharMatcher.find()) {
            isLastCharCorrect = false;
        }
        return isLastCharCorrect;
    }

    // before adding correct parens to stack, delete all ":)" and ":("
    public void addOnlyParenStringsToStack(String input) {
        String[] inputStringArray = input.split("");

        String correctStrings = "[():]";
//        String correctStrings = "[(){}\\[\\]<>\"\']";
        Pattern correctStringsPattern = Pattern.compile(correctStrings);
//        System.out.println("String entering addOnlyParenStringsToStack: ");
//        System.out.println(input);

        for (String string : inputStringArray) {
            Matcher correctStringsMatcher = correctStringsPattern.matcher(string);
            if (correctStringsMatcher.find()) {
                stack.add(string);
            }
        }
//        System.out.println("Stack leaving addOnlyParenStringsToStack: ");
//        System.out.println(this.getStackElementsAsString());
    }

    public boolean areAllParensPaired(String input) {
        boolean areAllParensPaired = true;

        this.addOnlyParenStringsToStack(input);
        String cleanedInput = this.getStackElementsAsString();
        if (! (this.isFirstCharCorrect(cleanedInput) && this.isLastCharCorrect(cleanedInput)) ) {
            areAllParensPaired = false;
            return areAllParensPaired;
        }
//        System.out.println("Stack inside areAllParensPaired: ");
//        System.out.println(this.getStackElementsAsString());

        for (int i = 0; i < stack.size() - 1; i++) {

            // SQUIGGLY CHECK
//            if (stack.get(i).equals("{")) {
//                if (stack.get(i + 1).equals("}")) {
//                    stack.remove(i);
//                    stack.remove(i);
//                    if (i == 0) i--;
//                    else i -= 2;
//                    continue;
//                }
//                if ( stack.get(i + 1).equals("]") || stack.get(i + 1).equals(")")
//                     || stack.get(i + 1).equals(">") ) {
//                    break;
//                }
//            }

            // PARENTHESIS CHECK
            if (stack.get(i).equals("(")) {
                if (stack.get(i + 1).equals(")")) {
                    stack.remove(i);
                    stack.remove(i);
                    if (i == 0) i--;
                    else i -= 2;
                    continue;
                }
                if ( stack.get(i + 1).equals("}") || stack.get(i + 1).equals("]")
                     || stack.get(i + 1).equals(">") ) {
                    break;
                }
            }

            // DOUBLE_QUOTE CHECK
            if (stack.get(i).equals("\"")) {
                if (stack.get(i + 1).equals("\"")) {
                    stack.remove(i);
                    stack.remove(i);
                    if (i == 0) i--;
                    else i -= 2;
                    continue;
                }
                if ( stack.get(i + 1).equals("}") || stack.get(i + 1).equals("]")
                     || stack.get(i + 1).equals(")") || stack.get(i + 1).equals(">") ) {
                    break;
                }
            }

        } // end of for loop

        if (stack.size() != 0) {
            areAllParensPaired = false;
        }
        return areAllParensPaired;
    }

    public String getStackElementsAsString() {
        StringBuilder sb = new StringBuilder();
        for (String string : stack) {
            sb.append(string);
        }
        return sb.toString();
    }

    public boolean isFinalStackSizeZero() {
        boolean isFinalStackSizeZero = false;
        if (stack.size() == 0) {
            isFinalStackSizeZero = true;
        }
        return isFinalStackSizeZero;
    }

    public void makeStackSizeZero() {
        stack.clear();
    }

    public static void main(String[] args){
        ParenChecker parenChecker = new ParenChecker();

        String inputExpression = "i am sick today (:(()())";
        parenChecker.addOnlyParenStringsToStack(inputExpression);
        String cleanedInput = parenChecker.getStackElementsAsString();
        parenChecker.makeStackSizeZero();

        System.out.println("FINAL RESULT");
        System.out.println("Are parens paired?: " + parenChecker.areAllParensPaired(inputExpression));
        System.out.println("Original String: " + inputExpression);
        System.out.println("Final Stack:     " + parenChecker.getStackElementsAsString());
        System.out.println();

        System.out.println("REQUIREMENTS (should all be true)");
        System.out.println("Cleaned String:  " + cleanedInput);
        System.out.println("Is Cleaned String even?:  " + parenChecker.isInputLengthEven(cleanedInput));
        System.out.println("Is first String correct?: " + parenChecker.isFirstCharCorrect(cleanedInput));
        System.out.println("Is last String correct?:  " + parenChecker.isLastCharCorrect(cleanedInput));
        System.out.println("Is Final Stack size = 0?: " + parenChecker.isFinalStackSizeZero());
        System.out.println();


    }
}
