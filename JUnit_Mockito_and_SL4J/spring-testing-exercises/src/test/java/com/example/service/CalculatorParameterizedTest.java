package com.example.service;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorParameterizedTest {

    private final CalculatorService calculatorService = new CalculatorService();

    // Exercise 9: Parameterized Test with JUnit[cite: 5]
    @ParameterizedTest
    @CsvSource({
            "1, 2, 3",
            "5, 5, 10",
            "10, -2, 8",
            "0, 0, 0"
    })
    public void testAddMultipleInputs(int a, int b, int expectedResult) {
        assertEquals(expectedResult, calculatorService.add(a, b));
    }
}