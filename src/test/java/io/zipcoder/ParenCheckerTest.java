package io.zipcoder;

import org.junit.Assert;
import org.junit.Test;

import org.junit.Assert;
import org.junit.Test;

public class ParenCheckerTest {

    private ParenChecker pc;

    @Test
    public void isInputLengthEvenFalseTest() {
        // Given
        String oddLengthString = "(()";
        boolean expectedResponse = false;
        // When
        pc = new ParenChecker();
        boolean actualResponse = pc.isInputLengthEven(oddLengthString);
        // Then
        Assert.assertEquals(expectedResponse, actualResponse);
    }

    @Test
    public void isInputLengthEvenTrueTest() {
        // Given
        String evenLengthString = ")(()";
        boolean expectedResponse = true;
        // When
        pc = new ParenChecker();
        boolean actualResponse = pc.isInputLengthEven(evenLengthString);
        // Then
        Assert.assertEquals(expectedResponse, actualResponse);
    }

    @Test
    public void isFirstCharCorrectTrueTest() {
        // Given
        String input = "asdfasd(()";
        boolean expectedFirstCharTrueResponse = true;
        // When
        pc = new ParenChecker();
        boolean actualResponse = pc.isFirstCharCorrect(input);
        // Then
        Assert.assertEquals(expectedFirstCharTrueResponse, actualResponse);
    }

    @Test
    public void isFirstCharCorrectFalseTest() {
        // Given
        String input = "}(()";
        boolean expectedFirstCharFalseResponse = false;
        // When
        pc = new ParenChecker();
        boolean actualResponse = pc.isFirstCharCorrect(input);
        // Then
        Assert.assertEquals(expectedFirstCharFalseResponse, actualResponse);
    }

    @Test
    public void isLastCharCorrectTrueTest() {
        // Given
        String input = "(()}";
        boolean expectedLastCharTrueResponse = true;
        // When
        pc = new ParenChecker();
        boolean actualResponse = pc.isLastCharCorrect(input);
        // Then
        Assert.assertEquals(expectedLastCharTrueResponse, actualResponse);
    }

    @Test
    public void isLastCharCorrectFalseTest() {
        // Given
        String input = "}((){";
        boolean expectedLastCharFalseResponse = false;
        // When
        pc = new ParenChecker();
        boolean actualResponse = pc.isLastCharCorrect(input);
        // Then
        Assert.assertEquals(expectedLastCharFalseResponse, actualResponse);
    }

    @Test
    public void areAllParensPairedTrueTest() {
        // Given
        String input = "()()()";
        boolean expectedAreAllParensPairedTrue = true;
        // When
        pc = new ParenChecker();
        boolean actualAreAllParensPaired = pc.areAllParensPaired(input);
        // Then
        Assert.assertEquals(expectedAreAllParensPairedTrue, actualAreAllParensPaired);
    }

    @Test
    public void areAllParensPairedFalseTest() {
        // Given
        String input = "(((";
        boolean expectedAreAllParensPairedFalse = false;
        // When
        pc = new ParenChecker();
        boolean actualAreAllParensPaired = pc.areAllParensPaired(input);
        // Then
        Assert.assertEquals(expectedAreAllParensPairedFalse, actualAreAllParensPaired);
    }

}