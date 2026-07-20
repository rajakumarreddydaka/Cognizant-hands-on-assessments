package com.example;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ServiceTest {
    @Test
    public void testServiceWithMockRepository() {
        // Create a mock repository using Mockito[cite: 4].
        Repository mockRepository = mock(Repository.class);
        
        // Stub the repository methods to return predefined data[cite: 4].
        when(mockRepository.getData()).thenReturn("Mock Data");
        
        Service service = new Service(mockRepository);
        
        // Write a test to verify the service logic using the mocked repository[cite: 4].
        String result = service.processData();
        assertEquals("Processed Mock Data", result);
    }
}