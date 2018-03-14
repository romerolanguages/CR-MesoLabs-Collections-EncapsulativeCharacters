package io.zipcoder;

public enum ParenStrings {

    PARENTHESES("(", ")"),
    BRACKETS("[", "]"),
    SQUIGGLIES("{", "}"),
    DIAMONDS("<", ">"),
    DOUBLE_QUOTES("\"", "\""),
    SINGLE_QUOTES("\'", "\'");

    private final String openingString;
    private final String closingString;

    ParenStrings(String openingString, String closingString) {
        this.openingString = openingString;
        this.closingString = closingString;
    }

    public String getOpeningString() {
        return openingString;
    }

    public String getClosingString() {
        return closingString;
    }

    public String getOppositeString(String input) {
        String oppositeString = "";
        if (input.equals(openingString)) {
            oppositeString = closingString;
        } else if (input.equals(closingString)) {
            oppositeString = openingString;
        }
        return oppositeString;
    }
}
