package com.library.service;

import com.library.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {
    
    // Automatically injects the repository bean without needing a setter method
    @Autowired
    private BookRepository bookRepository;

    public void manageBooks() {
        System.out.println("BookService: Managing books via annotations...");
        bookRepository.display();
    }
}