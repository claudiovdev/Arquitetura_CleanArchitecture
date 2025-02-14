package br.com.cleanarchitecture.infrastructure.api.controller;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.net.URI;


@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
class CustomerControllerTest {

    @Autowired
    private MockMvc mockMvc;


    @Test
    void shouldCreateCustomer() throws Exception {
        URI uri = new URI("/customer");

        String json = "{\"name\":\"Vinicius\",\"adress\":{\"street\":\"Rua XPTO\",\"city\":\"São Paulo\",\"number\":123,\"zip\":\"01010-000\"}}";

        mockMvc.perform(MockMvcRequestBuilders.post(uri)
                .content(json)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers
                        .status()
                        .is(200))
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").isNotEmpty())
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value("Vinicius"));

    }

    @Test
    void shouldThrownAnErrorWhenNameIsMissing() throws Exception{
        URI uri = new URI("/customer");
        String json = "{\"name\":\"\",\"adress\":{\"street\":\"Rua XPTO\",\"city\":\"São Paulo\",\"number\":123,\"zip\":\"01010-000\"}}";

        mockMvc.perform(MockMvcRequestBuilders.post(uri)
                .content(json)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().is(500));
    }

    @Test
    @Sql(scripts = "classpath:data.sql", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
    void shoulListCustomer() throws Exception{
        URI uri = new URI("/customer/list");

        mockMvc.perform(MockMvcRequestBuilders.get(uri)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().is(200));
    }
}