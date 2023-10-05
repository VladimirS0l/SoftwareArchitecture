package ru.java.lesson10;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import ru.java.lesson10.controller.ClientController;
import ru.java.lesson10.models.Client;
import ru.java.lesson10.repository.ClientRepositoryImpl;
import ru.java.lesson10.service.ClientService;

import java.util.Date;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@WebMvcTest(ClientController.class)
class Lesson10ApplicationTests {

    @Autowired
    private MockMvc mvc;

    @Test
    public void showAllClients() throws Exception {
        mvc.perform(MockMvcRequestBuilders
                        .get("/client/all")
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.client").exists())
                .andExpect(MockMvcResultMatchers.jsonPath("$.client[*].clientId").isNotEmpty());
    }

    @Test
    public void createClient() throws Exception
    {
        mvc.perform( MockMvcRequestBuilders
                        .post("/client/create")
                        .content(asJsonString(new Client(1, "214424234", "surname",
                                "lastName", new Date())))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated())
                .andExpect(MockMvcResultMatchers.jsonPath("$.clientId").exists());
    }

    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
