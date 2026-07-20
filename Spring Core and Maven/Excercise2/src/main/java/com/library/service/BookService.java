package com.library.service;

import com.library.repository.BookRepository;

public class BookService {
    
    // The dependency
    private BookRepository bookRepository;

    // Setter method used by Spring for Dependency Injection
    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    // Method to test if the injection worked
    public void manageBooks() {
        System.out.println("BookService: Managing books...");
        // Calling the injected repository's method
        bookRepository.display();
    }
}