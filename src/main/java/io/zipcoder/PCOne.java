package io.zipcoder;

import java.util.Arrays;
import java.util.EnumSet;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.*;

// ASSESS1 - JPMC QUESTION 1

public class PCOne {

    private String inputExpression;

    public PCOne() {
    }

    public PCOne(String inputExpression) {
        this.inputExpression = inputExpression;
    }

    public boolean isStringEmpty(String string) {
        boolean isStringEmpty = false;
        if (string.length() == 0) {
            isStringEmpty = true;
        }
        return isStringEmpty;
    }

    public boolean containsOnlyAThruZSpaceColon(String string) {
        boolean contains = true;
        String containsRegEx = "[^a-z :]";
        Pattern containsPattern = Pattern.compile(containsRegEx);
        Matcher containsMatcher = containsPattern.matcher(string);
        if (containsMatcher.find()) {
            contains = false;
        }
        return contains;
    }

    public boolean isFirstCharCorrect(String input) {
        boolean isFirstCharCorrect = true;
        String incorrectFirstCharStringPattern = "^[)]";
        Pattern incorrectFirstCharPattern = Pattern.compile(incorrectFirstCharStringPattern);
        Matcher firstCharMatcher = incorrectFirstCharPattern.matcher(input);

        if (firstCharMatcher.find()) {
            isFirstCharCorrect = false;
        }
        return isFirstCharCorrect;
    }

    public boolean isLastCharCorrect(String input) {
        boolean isLastCharCorrect = true;
        String incorrectLastCharStringPattern = "[(]$";

        Pattern incorrectLastCharPattern = Pattern.compile(incorrectLastCharStringPattern);
        Matcher lastCharMatcher = incorrectLastCharPattern.matcher(input);

        if (lastCharMatcher.find()) {
            isLastCharCorrect = false;
        }
        return isLastCharCorrect;
    }

    public boolean areSmileysBalanced(String string) {
        boolean areSmileysBalanced = false;

        if (isStringEmpty(string) || containsOnlyAThruZSpaceColon(string)) {
            areSmileysBalanced = true;
            return areSmileysBalanced;
        }

        if (! (isFirstCharCorrect(string) || isLastCharCorrect(string)) ) {
            return areSmileysBalanced;
        }

        if (string.charAt(0) == '(' && string.charAt(string.length() - 1) == ')') {
            if (containsOnlyAThruZSpaceColon(string.substring(1, string.length() - 1))) {
                areSmileysBalanced = true;
                return areSmileysBalanced;
            }
        }

        int openParenthesis = 0;
        char[] inputString = string.toCharArray();

        for (int i = 0; i < inputString.length; i++) {
            if (inputString[i] == '(') {
                if (i == 0 || inputString[i - 1] != ':') {
                    openParenthesis++;
                }
            }
            else if (inputString[i] == ')') {
                if (i == 0 || inputString[i - 1] != ':') {
                    openParenthesis--;

                    if (openParenthesis < 0) {
                        break;
                    }
                }
            }
        }
        return openParenthesis == 0;
    }

    public static void main(String[] args){
        PCOne parenChecker = new PCOne();

        String input1 = ":((";
        System.out.println(parenChecker.areSmileysBalanced(input1)); // false
        String input2 = "i am sick today (:()";
        System.out.println(parenChecker.areSmileysBalanced(input2)); // true
        String input3 = "(:)";
        System.out.println(parenChecker.areSmileysBalanced(input3)); // true
        String input4 = "hacker cup: started :):)";
        System.out.println(parenChecker.areSmileysBalanced(input4)); // true
        String input5 = ")(";
        System.out.println(parenChecker.areSmileysBalanced(input5)); // false
        System.out.println();
        String input6 = "";
        System.out.println(parenChecker.areSmileysBalanced(input6)); // true
    }
}
