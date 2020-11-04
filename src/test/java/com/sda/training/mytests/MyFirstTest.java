package com.sda.training.mytests;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;

public class MyFirstTest {

    public MyFirstTest() {
        System.out.println("We are in constructor right now !!!!!!!");
    }

    @Test
    public void myFirstTestMethod() {
        System.out.println("We are in FIRST TEST right now !!!!!!!");
    }

    @Test
    public void mySecondTestMethod() {
        System.out.println("We are in SECOND TEST right now !!!!!!!");
        String actualText = "This is actual text";
        String expectedText = "THIS IS EXPECTED TEXT";
        assertThat("Expected text should be the same as actual: " + actualText + " but expected text is: " + expectedText, expectedText.equalsIgnoreCase(actualText));
    }
}
