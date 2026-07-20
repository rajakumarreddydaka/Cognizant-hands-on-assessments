package com.library.repository;

public class BookRepository {
    public void display(String injectionType) {
        System.out.println("BookRepository: Fetched books successfully using " + injectionType + ".");
    }
}