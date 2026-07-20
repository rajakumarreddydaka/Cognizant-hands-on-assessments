package com.example.service;

import com.example.entity.User;
import com.example.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;

    // Exercise 2: Mocking a Repository
    @Test
    public void testGetUserById() {
        User user = new User(1L, "Alice");
        when(userRepository.findById(1L)).thenReturn(Optional.of(user));

        User result = userService.getUserById(1L);

        assertNotNull(result);
        assertEquals("Alice", result.getName());
    }

    // Exercise 6: Test Service Exception Handling[cite: 5]
    @Test
    public void testGetUserById_ThrowsExceptionWhenNotFound() {
        when(userRepository.findById(2L)).thenReturn(Optional.empty());

        assertThrows(NoSuchElementException.class, () -> {
            userService.getUserById(2L);
        });
    }

    // Exercise 7: Test Custom Repository Query[cite: 5]
    @Test
    public void testFindByNameCustomQuery() {
        User user = new User(1L, "Bob");
        when(userRepository.findByName("Bob")).thenReturn(Collections.singletonList(user));

        List<User> result = userRepository.findByName("Bob");

        assertEquals(1, result.size());
        assertEquals("Bob", result.get(0).getName());
    }
}