package com.example;

import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;

public class ExceptionThrowerTest {

    @Test
    public void testExceptionIsThrown() {
        ExceptionThrower thrower = new ExceptionThrower();
        
        assertThrows(IllegalArgumentException.class, () -> {
            thrower.throwException();
        });
    }
}