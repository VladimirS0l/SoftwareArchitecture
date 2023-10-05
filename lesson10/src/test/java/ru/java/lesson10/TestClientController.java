package ru.java.lesson10;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import ru.java.lesson10.controller.ClientController;
import ru.java.lesson10.models.Client;
import ru.java.lesson10.service.ClientService;
import java.util.Date;
import java.util.List;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Класс для тестирования контроллера клиентов
 * Тесты - CRUD
 * В процессе тестирования запускается сервер, и на сервер отправляются CRUD запросы,
 * запросы проходят через контроллер и отправляются в сервис
 */

@WebMvcTest(controllers = ClientController.class)
@AutoConfigureMockMvc(addFilters = false)
@ExtendWith(MockitoExtension.class)
public class TestClientController {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private ClientService clientService;
    @Autowired
    private ObjectMapper objectMapper;

    private Client client;
    private List<Client> clients;

    @BeforeEach
    public void init() {
        client = new Client(1, "231232133", "SDASDA", "SADSAD", new Date());
        Client client1 = new Client(1, "23234234", "UDSandjadn", "GdsaSta", new Date());
        Client client2 = new Client(1, "23234234", "SADAWDFSA", "aDSASDsad", new Date());
        Client client3 = new Client();
        clients = List.of(client1, client2, client3);

    }

    @Test
    public void testGetAllClient() throws Exception {

        when(clientService.showAllClient()).thenReturn(clients);

        ResultActions response = mockMvc.perform(get("/client/all")
                .contentType(MediaType.APPLICATION_JSON));

        response.andExpect(status().isOk())
                .andExpect(jsonPath("$.size()", CoreMatchers.is(clients.size())));
    }

    @Test
    void testCreateClient() throws Exception {
        Client client1 = new Client();
        client1.setDocument("3424234423");
        client1.setSurName("dasasdsd");
        client1.setFirstName("sdsdasdsda");
        client1.setBirthday(new Date());
        mockMvc.perform(post("/client/create")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(client1)))
                .andExpect(status().isOk())
                .andDo(print());
    }

    @Test
    void testClientFindById() throws Exception {
        Integer id = 1;

        when(clientService.showById(id)).thenReturn(client);
        mockMvc.perform(get("/client/{id}", id)).andExpect(status().isOk())
                .andExpect(jsonPath("$.clientId").value(id))
                .andExpect(jsonPath("$.document").value(client.getDocument()))
                .andExpect(jsonPath("$.surName").value(client.getSurName()))
                .andExpect(jsonPath("$.firstName").value(client.getFirstName()))
                .andExpect(jsonPath("$.birthday").value(client.getBirthday()))
                .andDo(print());
    }

    @Test
    void testClientUpdate() throws Exception {
        Integer id = 1;

        Client updatedClient = new Client(id, "0000000", "Updated", "Updated", new Date());

        when(clientService.showById(id)).thenReturn(client);
        doNothing().when(clientService).update(updatedClient, id);
        when(clientService.showById(id)).thenReturn(updatedClient);

        mockMvc.perform(put("/client/{id}/update", id).contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(updatedClient)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.clientId").value(id))
                .andExpect(jsonPath("$.document").value(updatedClient.getDocument()))
                .andExpect(jsonPath("$.surName").value(updatedClient.getSurName()))
                .andExpect(jsonPath("$.firstName").value(updatedClient.getFirstName()))
                .andExpect(jsonPath("$.birthday").value(updatedClient.getBirthday()))
                .andDo(print());
    }

    @Test
    void testDeleteClient() throws Exception {
        Integer id = 1;

        doNothing().when(clientService).delete(id);
        mockMvc.perform(delete("/client/{id}/delete", id))
                .andExpect(status().isOk())
                .andDo(print());
    }

}
