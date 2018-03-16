package io.zipcoder;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class WCTest {

    private WC wc;

    @Before
    public void setupConstructorIteratorTest() {
        // Given
        String expectedFirstWord = "first";
        String wordsAsString = "first second third fourth";
        String[] wordsArray = wordsAsString.split("[a-zA-Z0-9]+");
        List<String> wordsArrayList = new ArrayList<String>(Arrays.asList(wordsArray));
        Iterator<String> wordsArrayListIterator = wordsArrayList.iterator();
        wc = new WC(wordsArrayListIterator);
        // When
        String actualFirstWord = "hold";
        // Then
    }

    @Test
    public void createWordsArrayTest() {

    }


}