package com.example;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class NetworkServiceTest {
    @Test
    public void testServiceWithMockNetworkClient() {
        // Create a mock network client using Mockito[cite: 4].
        NetworkClient mockNetworkClient = mock(NetworkClient.class);
        
        // Stub the network client methods to simulate network interactions[cite: 4].
        when(mockNetworkClient.connect()).thenReturn("Mock Connection");
        
        NetworkService networkService = new NetworkService(mockNetworkClient);
        
        // Write a test to verify the service logic using the mocked network client[cite: 4].
        String result = networkService.connectToServer();
        assertEquals("Connected to Mock Connection", result);
    }
}