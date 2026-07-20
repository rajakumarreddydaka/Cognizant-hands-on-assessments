package com.example;

import org.junit.Test;
import static org.junit.Assert.*;

public class AssertionsTest {

    @Test
    public void testAssertions() {
        // Assert equals[cite: 1]
        assertEquals(5, 2 + 3);
        
        // Assert true[cite: 1]
        assertTrue(5 > 3);
        
        // Assert false[cite: 1]
        assertFalse(5 < 3);
        
        // Assert null[cite: 1]
        assertNull(null);
        
        // Assert not null[cite: 1]
        assertNotNull(new Object());
    }
}