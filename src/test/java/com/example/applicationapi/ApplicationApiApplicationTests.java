package com.example.applicationapi;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
class ApplicationApiApplicationTests {
    @Autowired
    private MockMvc mockMvc;

    @Test
    void returnsApplicationUsingContractFields() throws Exception {
        mockMvc.perform(get("/api/applications/101"))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.id").value(101))
            .andExpect(jsonPath("$.applicantName").value("Sanjay"))
            .andExpect(jsonPath("$.applicationType").value("Student"))
            .andExpect(jsonPath("$.status").value("APPROVED"));
    }

    @Test
    void returns404ForUnknownApplication() throws Exception {
        mockMvc.perform(get("/api/applications/999"))
            .andExpect(status().isNotFound())
            .andExpect(jsonPath("$.error").value("APPLICATION_NOT_FOUND"));
    }
}
