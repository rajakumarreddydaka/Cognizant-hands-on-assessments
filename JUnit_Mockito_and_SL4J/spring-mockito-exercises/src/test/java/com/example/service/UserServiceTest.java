package com.example.service;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.when;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.entity.User;
import com.example.repository.UserRepository;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

    // Task: Mock the repository dependency using Mockito[cite: 5]
    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;

    @Test
    public void testGetUserById() {
        User mockUser = new User(2L, "Bob");
        when(userRepository.findById(2L)).thenReturn(Optional.of(mockUser));

        User result = userService.getUserById(2L);

        assertNotNull(result);
        assertEquals("Bob", result.getName());
    }
}