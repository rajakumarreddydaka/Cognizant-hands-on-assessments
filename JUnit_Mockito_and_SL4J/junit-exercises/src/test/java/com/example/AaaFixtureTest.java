package com.example;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class AaaFixtureTest {

    private List<String> testList;

    // Setup method run before each test[cite: 1]
    @Before
    public void setUp() {
        testList = new ArrayList<>();
        System.out.println("Setup: Initialized the testList.");
    }

    // Teardown method run after each test[cite: 1]
    @After
    public void tearDown() {
        testList.clear();
        testList = null;
        System.out.println("Teardown: Cleared and nulled the testList.");
    }

    @Test
    public void testListAdditionUsingAAAPattern() {
        // ARRANGE: Set up the specific conditions for this test[cite: 1]
        String itemToAdd = "JUnit";

        // ACT: Perform the action you are testing[cite: 1]
        testList.add(itemToAdd);

        // ASSERT: Verify the result[cite: 1]
        assertEquals(1, testList.size());
        assertTrue(testList.contains("JUnit"));
    }
}