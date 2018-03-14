package io.zipcoder;

import java.util.Arrays;
import java.util.EnumSet;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.*;

public class ParenChecker {

    private String inputExpression;
    private Stack<String> stack;
    private EnumSet<ParenStrings> parenStrings;


    public ParenChecker() {
        this.stack = new Stack<String>();
        this.parenStrings = EnumSet.allOf(ParenStrings.class);
    }

    public ParenChecker(String inputExpression) {
        this.inputExpression = inputExpression;
        this.stack = new Stack<String>();
        this.parenStrings = EnumSet.allOf(ParenStrings.class);
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

    public void addOnlyParenStringsToStack(String input) {
        String[] inputStringArray = input.split("");

//        String correctStrings = "[(){}\\[\\]<>\"\']$";
        String correctStrings = "[(){}\\[\\]<>]$";
        Pattern correctStringsPattern = Pattern.compile(correctStrings);
        System.out.println("String entering addOnlyParenStringsToStack: ");
        System.out.println(input);

        for (String string : inputStringArray) {
            Matcher correctStringsMatcher = correctStringsPattern.matcher(string);
            if (correctStringsMatcher.find()) {
                stack.add(string);
            }
        }
        System.out.println("Stack leaving addOnlyParenStringsToStack: ");
        System.out.println(this.toString());
    }

    public boolean areAllParensPaired(String input) {
        boolean areAllParensPaired = true;
//        if (! (this.isFirstCharCorrect(input) && this.isLastCharCorrect(input)) ) {
//            areAllParensPaired = false;
//            return areAllParensPaired;
//        }

        this.addOnlyParenStringsToStack(input);


        System.out.println("Stack inside areAllParensPaired: ");
        System.out.println(this.toString());

        for (int i = 0; i < stack.size() - 1; i++) {

            // SQUIGGLY CHECK
            if (stack.get(i).equals("{")) {
                if (stack.get(i + 1).equals("}")) {
                    stack.remove(i);
                    stack.remove(i);
                    if (i == 0) i--;
                    else i -= 2;
                    continue;
                }
//                if (stack.get(i + 1).equals("[") || stack.get(i + 1).equals("(")) {
//                    continue;
//                }
                if ( stack.get(i + 1).equals("]") || stack.get(i + 1).equals(")")
                     || stack.get(i + 1).equals(">") ) {
                    break;
                }
            }

            // BRACKET CHECK
            if (stack.get(i).equals("[")) {
                if (stack.get(i + 1).equals("]")) {
                    stack.remove(i);
                    stack.remove(i);
                    if (i == 0) i--;
                    else i -= 2;
                    continue;
                }
//                if (stack.get(i + 1).equals("{") || stack.get(i + 1).equals("(")) {
//                    continue;
//                }
                if ( stack.get(i + 1).equals("}") || stack.get(i + 1).equals(")")
                     || stack.get(i + 1).equals(">") ) {
                    break;
                }
            }

            // PARENTHESIS CHECK
            if (stack.get(i).equals("(")) {
                if (stack.get(i + 1).equals(")")) {
                    stack.remove(i);
                    stack.remove(i);
                    if (i == 0) i--;
                    else i -= 2;
                    continue;
                }
//                if (stack.get(i + 1).equals("{") || stack.get(i + 1).equals("[")) {
//                    continue;
//                }
                if ( stack.get(i + 1).equals("}") || stack.get(i + 1).equals("]")
                     || stack.get(i + 1).equals(">") ) {
                    break;
                }
            }

            // DIAMONDS CHECK
            if (stack.get(i).equals("<")) {
                if (stack.get(i + 1).equals(">")) {
                    stack.remove(i);
                    stack.remove(i);
                    if (i == 0) i--;
                    else i -= 2;
                    continue;
                }
                if ( stack.get(i + 1).equals("}") || stack.get(i + 1).equals("]")
                     || stack.get(i + 1).equals(")") ) {
                    break;
                }
            }

        } // end of for loop

        if (stack.size() != 0) {
            areAllParensPaired = false;
        }
        return areAllParensPaired;

    }

    public boolean checkStack() {
        return false;
    }

    @Override
    public String toString () {
        StringBuilder sb = new StringBuilder();
        for (String string : stack) {
            sb.append(string);
        }
        return sb.toString();
    }

    public static void main(String[] args){
        ParenChecker parenChecker = new ParenChecker();

        String inputExpression = "<aaáaaaaa>{{}}{}{}{}{}";
        System.out.println("isInputLengthEven: " + parenChecker.isInputLengthEven(inputExpression));
        System.out.println("isFirstCharCorrect: " + parenChecker.isFirstCharCorrect(inputExpression));
        System.out.println("isLastCharCorrect: " + parenChecker.isLastCharCorrect(inputExpression));
        System.out.println();
        System.out.println("areAllParensPaired: " + parenChecker.areAllParensPaired(inputExpression));
        System.out.println("original String: " + inputExpression);
        System.out.println("final Stack:     " + parenChecker.toString());

    }
}
