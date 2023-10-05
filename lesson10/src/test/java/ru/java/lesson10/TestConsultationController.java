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
import ru.java.lesson10.controller.ConsultationController;
import ru.java.lesson10.models.Consultation;
import ru.java.lesson10.service.ConsultationService;
import java.util.Date;
import java.util.List;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Класс для тестирования контроллера консультаций
 * Тесты - CRUD
 * В процессе тестирования запускается сервер, и на сервер отправляются CRUD запросы на контроллер,
 * запросы проходят через контроллер и отправляются в сервис
 */

@WebMvcTest(controllers = ConsultationController.class)
@AutoConfigureMockMvc(addFilters = false)
@ExtendWith(MockitoExtension.class)
public class TestConsultationController {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private ConsultationService consultationService;
    @Autowired
    private ObjectMapper objectMapper;

    private Consultation consultation;
    private List<Consultation> consultations;

    @BeforeEach
    public void init() {
        consultation = new Consultation(1, 1, 1, new Date(), "DSDADSADADA");
        Consultation consultation1 = new Consultation(2, 2, 2, new Date(), "sadwaw");
        Consultation consultation2 = new Consultation(3, 3, 3, new Date(), "dasdDSADADA");
        Consultation consultation3 = new Consultation();
        consultations = List.of(consultation1, consultation2, consultation3);

    }

    @Test
    public void testGetAllConsultation() throws Exception {

        when(consultationService.showAllConsultations()).thenReturn(consultations);

        ResultActions response = mockMvc.perform(get("/cons/all")
                .contentType(MediaType.APPLICATION_JSON));

        response.andExpect(status().isOk())
                .andExpect(jsonPath("$.size()", CoreMatchers.is(consultations.size())));
    }

    @Test
    void testCreateConsultation() throws Exception {
        Consultation consultationCreate = new Consultation(4, 3, 3, new Date(), "CreateNew");
        mockMvc.perform(post("/cons/create")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(consultationCreate)))
                .andExpect(status().isOk())
                .andDo(print());
    }

    @Test
    void testConsFindById() throws Exception {
        Integer id = 1;

        when(consultationService.showById(id)).thenReturn(consultation);
        mockMvc.perform(get("/cons/{id}", id)).andExpect(status().isOk())
                .andExpect(jsonPath("$.consultationId").value(id))
                .andExpect(jsonPath("$.clientId").value(consultation.getClientId()))
                .andExpect(jsonPath("$.petId").value(consultation.getPetId()))
                .andExpect(jsonPath("$.consultationDate").value(consultation.getConsultationDate()))
                .andExpect(jsonPath("$.description").value(consultation.getDescription()))
                .andDo(print());
    }

    @Test
    void testConsUpdate() throws Exception {
        Integer id = 1;

        Consultation consultationUpdate = new Consultation(1, 5, 5, new Date(), "Updated");

        when(consultationService.showById(id)).thenReturn(consultation);
        doNothing().when(consultationService).update(consultationUpdate, id);
        when(consultationService.showById(id)).thenReturn(consultationUpdate);

        mockMvc.perform(put("/cons/{id}/update", id).contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(consultationUpdate)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.consultationId").value(id))
                .andExpect(jsonPath("$.clientId").value(consultationUpdate.getClientId()))
                .andExpect(jsonPath("$.petId").value(consultationUpdate.getPetId()))
                .andExpect(jsonPath("$.consultationDate").value(consultationUpdate.getConsultationDate()))
                .andExpect(jsonPath("$.description").value(consultationUpdate.getDescription()))
                .andDo(print());
    }

    @Test
    void testDeleteCons() throws Exception {
        Integer id = 1;

        doNothing().when(consultationService).delete(id);
        mockMvc.perform(delete("/cons/{id}/delete", id))
                .andExpect(status().isOk())
                .andDo(print());
    }

}
