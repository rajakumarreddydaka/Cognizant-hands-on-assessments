package com.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoggingExample {
    private static final Logger logger = LoggerFactory.getLogger(LoggingExample.class);

    public static void main(String[] args) {
        // Logging an error message[cite: 6]
        logger.error("This is an error message");
        
        // Logging a warning message[cite: 6]
        logger.warn("This is a warning message");
    }
}