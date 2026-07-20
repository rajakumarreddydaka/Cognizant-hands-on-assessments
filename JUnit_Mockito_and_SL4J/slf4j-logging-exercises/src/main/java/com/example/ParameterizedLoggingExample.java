package com.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ParameterizedLoggingExample {
    private static final Logger logger = LoggerFactory.getLogger(ParameterizedLoggingExample.class);

    public static void main(String[] args) {
        String user = "admin";
        int failedAttempts = 3;

        // Parameterized logging using {} placeholders
        logger.info("User '{}' successfully logged in.", user);
        logger.warn("User '{}' had {} failed login attempts.", user, failedAttempts);
    }
}