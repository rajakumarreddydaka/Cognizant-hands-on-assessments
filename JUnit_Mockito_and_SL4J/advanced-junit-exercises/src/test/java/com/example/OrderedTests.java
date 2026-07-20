package com.example;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class OrderedTests {

    @Test
    @Order(1)
    public void firstTest() {
        System.out.println("This test runs first.");
    }

    @Test
    @Order(2)
    public void secondTest() {
        System.out.println("This test runs second.");
    }
    
    @Test
    @Order(3)
    public void thirdTest() {
        System.out.println("This test runs third.");
    }
}