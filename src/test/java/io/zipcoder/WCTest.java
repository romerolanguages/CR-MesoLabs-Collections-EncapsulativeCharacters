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

        // When
        wc.addWordsToLinkedHashMap();
        String actualFirstWord = wc.getLinkedHashMap().entrySet().iterator().next().getKey();
        // Then
        Assert.assertEquals(expectedFirstWord, actualFirstWord);
    }

    @Test
    public void addWordsToLinkedHashMapTest() {
        // Given
        int expectedCountOfString = 2;
        String string = "first first third fourth";
        // When
        // Then

    }


}