package com.example;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class MultiReturnServiceTest {
    @Test
    public void testServiceWithMultipleReturnValues() {
        // Create a mock object using Mockito[cite: 4].
        Repository mockRepository = mock(Repository.class);
        
        // Stub the method to return different values on consecutive calls[cite: 4].
        when(mockRepository.getData())
            .thenReturn("First Mock Data")
            .thenReturn("Second Mock Data");
            
        Service service = new Service(mockRepository);
        
        // Write a test to verify the service logic using the mocked object[cite: 4].
        String firstResult = service.processData();
        String secondResult = service.processData();
        
        assertEquals("Processed First Mock Data", firstResult);
        assertEquals("Processed Second Mock Data", secondResult);
    }
}