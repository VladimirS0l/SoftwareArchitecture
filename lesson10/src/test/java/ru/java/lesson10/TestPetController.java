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
import ru.java.lesson10.controller.PetController;
import ru.java.lesson10.models.Client;
import ru.java.lesson10.models.Pet;
import ru.java.lesson10.service.ClientService;
import ru.java.lesson10.service.PetService;

import java.util.Date;
import java.util.List;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Класс для тестирования контроллера домашний питомцев
 * Тесты - CRUD
 * В процессе тестирования запускается сервер, и на сервер отправляются CRUD запросы,
 * запросы проходят через контроллер и отправляются в сервис
 */

@WebMvcTest(controllers = PetController.class)
@AutoConfigureMockMvc(addFilters = false)
@ExtendWith(MockitoExtension.class)
public class TestPetController {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private PetService petService;
    @Autowired
    private ObjectMapper objectMapper;

    private Pet pet;
    private List<Pet> pets;

    @BeforeEach
    public void init() {
        pet = new Pet(1, 7, "Bobik", new Date());
        Pet pet1 = new Pet(2, 4, "Persik", new Date());
        Pet pet2 = new Pet(3, 5, "Vasya", new Date());
        Pet pet3 = new Pet();
        pets = List.of(pet1, pet2, pet3);

    }

    @Test
    public void testGetAllPets() throws Exception {

        when(petService.showAllPets()).thenReturn(pets);

        ResultActions response = mockMvc.perform(get("/pet/all")
                .contentType(MediaType.APPLICATION_JSON));

        response.andExpect(status().isOk())
                .andExpect(jsonPath("$.size()", CoreMatchers.is(pets.size())));
    }

    @Test
    void testCreatePet() throws Exception {
        Pet petCreate = new Pet(3, 5, "NewPet", new Date());
        mockMvc.perform(post("/pet/create")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(petCreate)))
                .andExpect(status().isOk())
                .andDo(print());
    }

    @Test
    void testPetFindById() throws Exception {
        Integer id = 1;

        when(petService.showById(id)).thenReturn(pet);
        mockMvc.perform(get("/pet/{id}", id)).andExpect(status().isOk())
                .andExpect(jsonPath("$.petId").value(id))
                .andExpect(jsonPath("$.clientId").value(pet.getClientId()))
                .andExpect(jsonPath("$.name").value(pet.getName()))
                .andExpect(jsonPath("$.birthday").value(pet.getBirthday()))
                .andDo(print());
    }

    @Test
    void testPetUpdate() throws Exception {
        Integer id = 1;

        Pet petUpdate = new Pet(1, 4, "UpdatePet", new Date());

        when(petService.showById(id)).thenReturn(pet);
        doNothing().when(petService).update(petUpdate, id);
        when(petService.showById(id)).thenReturn(petUpdate);

        mockMvc.perform(put("/pet/{id}/update", id).contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(petUpdate)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.petId").value(id))
                .andExpect(jsonPath("$.clientId").value(petUpdate.getClientId()))
                .andExpect(jsonPath("$.name").value(petUpdate.getName()))
                .andExpect(jsonPath("$.birthday").value(petUpdate.getBirthday()))
                .andDo(print());
    }

    @Test
    void testDeletePet() throws Exception {
        Integer id = 1;

        doNothing().when(petService).delete(id);
        mockMvc.perform(delete("/pet/{id}/delete", id))
                .andExpect(status().isOk())
                .andDo(print());
    }

}
