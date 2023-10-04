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
import ru.java.lesson10.models.Pet;
import ru.java.lesson10.service.PetService;

import java.util.List;

@RestController
@RequestMapping("/pet")
@Api(
        tags="Домашние животные",
        description = "Методы работы с домашними животными")
public class PetController {
    private final PetService petService;

    @Autowired
    public PetController(PetService petService) {
        this.petService = petService;
    }

    @Operation(
            summary = "Запрос на получение страницы с домашними животными",
            responses = {
                    @ApiResponse(
                            description = "Успешный ответ", responseCode = "200",
                            content = @Content(schema = @Schema(implementation = Pet.class))
                    ),
                    @ApiResponse(
                            description = "Ошибка", responseCode = "400",
                            content = @Content(schema = @Schema(implementation = AppError.class))
                    )
            }
    )
    @GetMapping("/all")
    public ResponseEntity<List<Pet>> showAll(){
        List<Pet> pets = petService.showAllPets();
        return ResponseEntity.ok(pets);
    }

    @Operation(
            summary = "Запрос на получение страницы с домашним животным",
            responses = {
                    @ApiResponse(
                            description = "Успешный ответ", responseCode = "200",
                            content = @Content(schema = @Schema(implementation = Pet.class))
                    ),
                    @ApiResponse(
                            description = "Ошибка", responseCode = "400",
                            content = @Content(schema = @Schema(implementation = AppError.class))
                    )
            }
    )
    @GetMapping("/{id}")
    public ResponseEntity<Pet> showByID(@PathVariable("id") Integer id) {
        Pet pet = petService.showById(id);
        return ResponseEntity.ok(pet);
    }

    @Operation(
            summary = "Регистрация нового домашнего животного",
            responses = {
                    @ApiResponse(
                            description = "Успешный ответ", responseCode = "200",
                            content = @Content(schema = @Schema(implementation = Pet.class))
                    ),
                    @ApiResponse(
                            description = "Ошибка", responseCode = "400",
                            content = @Content(schema = @Schema(implementation = AppError.class))
                    )
            }
    )
    @PostMapping("/create")
    public ResponseEntity<Pet> create(@RequestBody Pet pet) {
        petService.create(pet);
        return ResponseEntity.ok(pet);
    }

    @Operation(
            summary = "Обновление данных о домашнем животном",
            responses = {
                    @ApiResponse(
                            description = "Успешный ответ", responseCode = "200",
                            content = @Content(schema = @Schema(implementation = Pet.class))
                    ),
                    @ApiResponse(
                            description = "Ошибка", responseCode = "400",
                            content = @Content(schema = @Schema(implementation = AppError.class))
                    )
            }
    )
    @PutMapping("/{id}/update")
    public ResponseEntity<Pet> update(@RequestBody Pet pet, @PathVariable("id") Integer id) {
        petService.update(pet, id);
        Pet upPet = petService.showById(id);
        return ResponseEntity.ok(upPet);
    }

    @Operation(
            summary = "Удаление домашнего животного",
            responses = {
                    @ApiResponse(
                            description = "Успешный ответ", responseCode = "200",
                            content = @Content(schema = @Schema(implementation = Pet.class))
                    ),
                    @ApiResponse(
                            description = "Ошибка", responseCode = "400",
                            content = @Content(schema = @Schema(implementation = AppError.class))
                    )
            }
    )
    @DeleteMapping("/{id}/delete")
    public ResponseEntity<Pet> delete(@PathVariable("id") Integer id) {
        Pet delPet = petService.showById(id);
        petService.delete(id);
        return ResponseEntity.ok(delPet);
    }
}
