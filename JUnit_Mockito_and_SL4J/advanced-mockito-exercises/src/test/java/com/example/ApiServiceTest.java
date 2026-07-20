package com.example;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ApiServiceTest {
    @Test
    public void testServiceWithMockRestClient() {
        // Create a mock REST client using Mockito[cite: 4].
        RestClient mockRestClient = mock(RestClient.class);
        
        // Stub the REST client methods to return predefined responses[cite: 4].
        when(mockRestClient.getResponse()).thenReturn("Mock Response");
        
        ApiService apiService = new ApiService(mockRestClient);
        
        // Write a test to verify the service logic using the mocked REST client[cite: 4].
        String result = apiService.fetchData();
        assertEquals("Fetched Mock Response", result);
    }
}