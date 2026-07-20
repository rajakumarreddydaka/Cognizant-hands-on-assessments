package com.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AppenderExample {
    private static final Logger logger = LoggerFactory.getLogger(AppenderExample.class);

    public static void main(String[] args) {
        logger.trace("This is a TRACE message (might not show depending on root level)");
        logger.debug("This is a DEBUG message - System initializing...");
        logger.info("This is an INFO message - Application started successfully.");
        logger.warn("This is a WARN message - Resource usage is high.");
        logger.error("This is an ERROR message - Database connection failed.");
        
        System.out.println("\nCheck your project root directory. You should see an 'app.log' file created!");
    }
}