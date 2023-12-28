//package com.ironhack.CarbonFootprintCalculator.Controllers;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.ironhack.CarbonFootprintCalculator.Services.UserService;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.http.MediaType;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.setup.MockMvcBuilders;
//
//import java.util.Collections;
//
//import static org.mockito.Mockito.when;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
//
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
//
//
//
//
//@WebMvcTest(UserController.class)
//public class UserControllerTest {
//
//    @Mock
//    private UserService userService;
//
//    @InjectMocks
//    private UserController userController;
//
//    @Autowired
//    private MockMvc mockMvc;
//
//    @Autowired
//    private ObjectMapper objectMapper;
//
//    @BeforeEach
//    void setUp() {
//        mockMvc = MockMvcBuilders.standaloneSetup(userController).build();
//        objectMapper = new ObjectMapper();
//    }
//
//    @Test
//    void getAllUsers() throws Exception {
//        when(userService.findAll()).thenReturn(Collections.emptyList());
//
//        mockMvc.perform(get("/users"))
//                .andExpect(status().isOk())
//                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
//                .andExpect(jsonPath("$").isArray())
//                .andExpect(jsonPath("$").isEmpty());
//    }
//}
//
