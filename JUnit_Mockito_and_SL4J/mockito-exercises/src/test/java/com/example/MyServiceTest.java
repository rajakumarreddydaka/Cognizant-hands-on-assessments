package com.example;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.Test;
import org.mockito.InOrder;
import org.mockito.Mockito;

public class MyServiceTest {

    // Exercise 1: Mocking and Stubbing[cite: 3]
    @Test
    public void testExternalApi() {
        ExternalApi mockApi = Mockito.mock(ExternalApi.class); // Create a mock object[cite: 3]
        when(mockApi.getData()).thenReturn("Mock Data"); // Stub the methods[cite: 3]
        
        MyService service = new MyService(mockApi);
        String result = service.fetchData(); // Write a test case[cite: 3]
        
        assertEquals("Mock Data", result);
    }

    // Exercise 2: Verifying Interactions[cite: 3]
    @Test
    public void testVerifyInteraction() {
        ExternalApi mockApi = Mockito.mock(ExternalApi.class); // Create a mock object[cite: 3]
        MyService service = new MyService(mockApi);
        
        service.fetchData(); // Call the method[cite: 3]
        
        verify(mockApi).getData(); // Verify the interaction[cite: 3]
    }

    // Exercise 3: Argument Matching[cite: 3]
    @Test
    public void testArgumentMatching() {
        ExternalApi mockApi = Mockito.mock(ExternalApi.class); // Create a mock object[cite: 3]
        MyService service = new MyService(mockApi);
        
        service.fetchSpecificData(42); // Call the method with specific arguments[cite: 3]
        
        // Use argument matchers to verify the interaction[cite: 3]
        verify(mockApi).getDataById(eq(42)); 
    }

    // Exercise 4: Handling Void Methods[cite: 3]
    @Test
    public void testVoidMethod() {
        ExternalApi mockApi = Mockito.mock(ExternalApi.class); // Create a mock object[cite: 3]
        
        // Stub the void method (Note: doNothing() is default for void, but here is explicit stubbing)[cite: 3]
        doNothing().when(mockApi).processData(anyString()); 
        
        MyService service = new MyService(mockApi);
        service.executeAction("Test Payload");
        
        // Verify the interaction[cite: 3]
        verify(mockApi).processData("Test Payload");
    }

    // Exercise 5: Mocking and Stubbing with Multiple Returns[cite: 3]
    @Test
    public void testMultipleReturns() {
        ExternalApi mockApi = Mockito.mock(ExternalApi.class); // Create a mock object[cite: 3]
        
        // Stub the methods to return different values on consecutive calls[cite: 3]
        when(mockApi.getData()).thenReturn("First Call").thenReturn("Second Call");
        
        MyService service = new MyService(mockApi);
        
        // Write a test case that uses the mock object[cite: 3]
        assertEquals("First Call", service.fetchData());
        assertEquals("Second Call", service.fetchData());
    }

    // Exercise 6: Verifying Interaction Order[cite: 3]
    @Test
    public void testInteractionOrder() {
        ExternalApi mockApi = Mockito.mock(ExternalApi.class); // Create a mock object[cite: 3]
        MyService service = new MyService(mockApi);
        
        service.runWorkflow(); // Call the methods in a specific order[cite: 3]
        
        // Verify the interaction order[cite: 3]
        InOrder inOrder = inOrder(mockApi);
        inOrder.verify(mockApi).startProcess();
        inOrder.verify(mockApi).endProcess();
    }

    // Exercise 7: Handling Void Methods with Exceptions[cite: 3]
    @Test
    public void testVoidMethodWithException() {
        ExternalApi mockApi = Mockito.mock(ExternalApi.class); // Create a mock object[cite: 3]
        
        // Stub the void method to throw an exception[cite: 3]
        doThrow(new RuntimeException("API Failure")).when(mockApi).processData(anyString());
        
        MyService service = new MyService(mockApi);
        
        // Verify the interaction by catching the expected throw[cite: 3]
        assertThrows(RuntimeException.class, () -> {
            service.executeAction("Failing Payload");
        });
    }
}