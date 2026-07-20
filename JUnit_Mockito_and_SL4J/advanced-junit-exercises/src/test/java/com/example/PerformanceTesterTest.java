package com.example;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertTimeout;
import org.junit.jupiter.api.Test;

public class PerformanceTesterTest {

    @Test
    public void testMethodCompletesWithinTimeout() {
        PerformanceTester tester = new PerformanceTester();
        
        // Asserting that the task completes within 100 milliseconds
        assertTimeout(Duration.ofMillis(100), () -> {
            tester.performTask();
        });
    }
}