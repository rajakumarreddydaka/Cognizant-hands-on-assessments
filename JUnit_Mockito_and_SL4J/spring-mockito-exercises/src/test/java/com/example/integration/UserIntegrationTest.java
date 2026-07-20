package com.example.integration;

import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.when;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.example.entity.User;
import com.example.service.UserService;

// Hint: Use @SpringBootTest, @AutoConfigureMockMvc[cite: 5]
@SpringBootTest
@AutoConfigureMockMvc
public class UserIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    // Task: Write an integration test for a Spring Boot application that mocks a service dependency using Mockito[cite: 5]
    @MockBean
    private UserService userService;

    @Test
    public void testIntegrationGetUser() throws Exception {
        User mockUser = new User(3L, "Charlie");
        when(userService.getUserById(3L)).thenReturn(mockUser);

        mockMvc.perform(get("/users/3"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("Charlie"))
                .andExpect(jsonPath("$.id").value(3));
    }
}