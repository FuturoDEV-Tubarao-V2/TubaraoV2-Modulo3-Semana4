package com.example.hellotubarao;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc // configura o MockMvc
class HelloControllerTest {

    @Autowired
    MockMvc mockMvc;
    // É uma ferramentado Spring para testes
    // Ele age com um Insomnia ou outro agente externo
    // Realiza chamadas de endpoints
    // Usado para testes de integração

    @Test
    void hello() throws Exception {

        mockMvc.perform(
                get("/hello")
        ).andExpect(status().isOk());
    }
}