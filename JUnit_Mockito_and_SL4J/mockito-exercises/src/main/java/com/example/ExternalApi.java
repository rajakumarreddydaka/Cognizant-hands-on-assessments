package com.example;

public interface ExternalApi {
    // For Exercises 1, 2, and 5
    String getData();
    
    // For Exercise 3
    String getDataById(int id);
    
    // For Exercises 4 and 7
    void processData(String data);
    
    // For Exercise 6
    void startProcess();
    void endProcess();
}