package ru.java.lesson10.controller;

import io.swagger.annotations.Api;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.java.lesson10.exception.AppError;
import ru.java.lesson10.models.Client;
import ru.java.lesson10.models.Consultation;
import ru.java.lesson10.repository.impl.ConsultationRepository;
import ru.java.lesson10.service.ConsultationService;

import java.util.List;

@RestController
@RequestMapping("/cons")
@Api(
        tags="Консультации",
        description = "Методы работы с консультациями")
public class ConcultationController {

    private final ConsultationService consultationService;

    @Autowired
    public ConcultationController(ConsultationService consultationService) {
        this.consultationService = consultationService;
    }

    @Operation(
            summary = "Запрос на получение страницы с консультациями",
            responses = {
                    @ApiResponse(
                            description = "Успешный ответ", responseCode = "200",
                            content = @Content(schema = @Schema(implementation = Consultation.class))
                    ),
                    @ApiResponse(
                            description = "Ошибка", responseCode = "400",
                            content = @Content(schema = @Schema(implementation = AppError.class))
                    )
            }
    )
    @GetMapping("/all")
    public ResponseEntity<List<Consultation>> showAll(){
        List<Consultation> consultations  = consultationService.showAllConsultations();
        return ResponseEntity.ok(consultations);
    }

    @Operation(
            summary = "Запрос на получение страницы с консультацией",
            responses = {
                    @ApiResponse(
                            description = "Успешный ответ", responseCode = "200",
                            content = @Content(schema = @Schema(implementation = Consultation.class))
                    ),
                    @ApiResponse(
                            description = "Ошибка", responseCode = "400",
                            content = @Content(schema = @Schema(implementation = AppError.class))
                    )
            }
    )
    @GetMapping("/{id}")
    public ResponseEntity<Consultation> showByID(@PathVariable("id") Integer id) {
        Consultation consultation = consultationService.showById(id);
        return ResponseEntity.ok(consultation);
    }

    @Operation(
            summary = "Создание новой записи на консультацию",
            responses = {
                    @ApiResponse(
                            description = "Успешный ответ", responseCode = "200",
                            content = @Content(schema = @Schema(implementation = Consultation.class))
                    ),
                    @ApiResponse(
                            description = "Ошибка", responseCode = "400",
                            content = @Content(schema = @Schema(implementation = AppError.class))
                    )
            }
    )
    @PostMapping("/create")
    public ResponseEntity<Consultation> create(@RequestBody Consultation consultation) {
        consultationService.create(consultation);
        return ResponseEntity.ok(consultation);
    }

    @Operation(
            summary = "Обновление записи на консультацию",
            responses = {
                    @ApiResponse(
                            description = "Успешный ответ", responseCode = "200",
                            content = @Content(schema = @Schema(implementation = Consultation.class))
                    ),
                    @ApiResponse(
                            description = "Ошибка", responseCode = "400",
                            content = @Content(schema = @Schema(implementation = AppError.class))
                    )
            }
    )
    @PutMapping("/{id}/update")
    public ResponseEntity<Consultation> update(@RequestBody Consultation consultation, @PathVariable("id") Integer id) {
        consultationService.update(consultation, id);
        Consultation cl = consultationService.showById(id);
        return ResponseEntity.ok(cl);
    }

    @Operation(
            summary = "Удаление записи на консультацию",
            responses = {
                    @ApiResponse(
                            description = "Успешный ответ", responseCode = "200",
                            content = @Content(schema = @Schema(implementation = Consultation.class))
                    ),
                    @ApiResponse(
                            description = "Ошибка", responseCode = "400",
                            content = @Content(schema = @Schema(implementation = AppError.class))
                    )
            }
    )
    @DeleteMapping("/{id}/delete")
    public ResponseEntity<Consultation> delete(@PathVariable("id") Integer id) {
        Consultation cl = consultationService.showById(id);
        consultationService.delete(id);
        return ResponseEntity.ok(cl);
    }
}
