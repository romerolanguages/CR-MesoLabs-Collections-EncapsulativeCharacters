package io.zipcoder;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class PCOneTest {

    PCOne pco;

    @Before
    public void setup() {
        this.pco = new PCOne();
    }

    @Test
    public void isStringEmptyTest() {
        // Given
        String empty = "";
        boolean expected = true;
        // When
        boolean actual = pco.isStringEmpty(empty);
        // Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void containsOnlyAThruZSpaceColonTest() {
        // Given
        String string = "asdfa  ::";
        boolean expected = true;
        // When
        boolean actual = pco.containsOnlyAThruZSpaceColon(string);
        // Then
        Assert.assertEquals(expected, actual);
    }

}
