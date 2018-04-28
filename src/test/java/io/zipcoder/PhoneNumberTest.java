package io.zipcoder;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class PhoneNumberTest {


    private PhoneNumber pn;
    private String input =   "4158239";
    private String output0 = "g1jtadw";

    @Before
    public void setup() {
        pn = new PhoneNumber();
    }

    @Test
    public void initializeMapTest() {
        // Given
        char key = '2';
        char expectedValue = 'a';
        // When
        char actualValue = pn.getMap().get(key)[0];
        // Then
        Assert.assertEquals(expectedValue, actualValue);
    }

    @Test
    public void getCombosTest() {
        // Given
        String expectedOutput = input;
        // When
        pn.getCombos().add(input);
        String actualOutput = pn.getCombos().get(0);
        // Then
        Assert.assertEquals(expectedOutput, actualOutput);
    }

    @Test
    public void addIndexZeroOfEachCharArrayToCombosTest() {
        // Given
        String expectedOutput = output0;
        // When
        pn.addIndexZeroOfEachCharArrayToCombos(input);
        String actualOutput = pn.getCombos().get(0);
        // Then
        Assert.assertEquals(expectedOutput, actualOutput);
    }

//    @Test
//    public void replaceCharsWithRecursionTest() {
//        // Given
//        int startingIndex = 0;
//        String expectedOutput = output0;
//        // When
//        String actualOutput = pn.replaceCharsWithRecursion(input, startingIndex);
//        // Then
//        Assert.assertEquals(expectedOutput, actualOutput);
//    }

}
