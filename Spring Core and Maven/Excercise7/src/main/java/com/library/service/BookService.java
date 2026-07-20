package com.library.service;

import com.library.repository.BookRepository;

public class BookService {
    
    private BookRepository bookRepository;
    private String injectionMethod;

    // Default Constructor (Required for Setter Injection)
    public BookService() {
    }

    // 1. Constructor Injection
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
        this.injectionMethod = "Constructor Injection";
    }

    // 2. Setter Injection
    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
        this.injectionMethod = "Setter Injection";
    }

    public void manageBooks() {
        System.out.println("BookService: Managing books...");
        bookRepository.display(this.injectionMethod);
    }
}