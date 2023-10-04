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
import ru.java.lesson10.service.ClientService;

import java.util.List;

@RestController
@RequestMapping("/client")
@Api(
        tags="Клиенты",
        description = "Методы работы с клиентами")
public class ClientController {
    private final ClientService clientService;

    @Autowired
    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @Operation(
            summary = "Запрос на получение страницы с клиентами",
            responses = {
                    @ApiResponse(
                            description = "Успешный ответ", responseCode = "200",
                            content = @Content(schema = @Schema(implementation = Client.class))
                    ),
                    @ApiResponse(
                            description = "Ошибка", responseCode = "400",
                            content = @Content(schema = @Schema(implementation = AppError.class))
                    )
            }
    )
    @GetMapping("/all")
    public ResponseEntity<List<Client>> showAll(){
        List<Client> clients = clientService.showAllClient();
        return ResponseEntity.ok(clients);
    }

    @Operation(
            summary = "Запрос на получение страницы клиента",
            responses = {
                    @ApiResponse(
                            description = "Успешный ответ", responseCode = "200",
                            content = @Content(schema = @Schema(implementation = Client.class))
                    ),
                    @ApiResponse(
                            description = "Ошибка", responseCode = "400",
                            content = @Content(schema = @Schema(implementation = AppError.class))
                    )
            }
    )
    @GetMapping("/{id}")
    public ResponseEntity<Client> showByID(@PathVariable("id") Integer id) {
        Client client = clientService.showById(id);
        return ResponseEntity.ok(client);
    }

    @Operation(
            summary = "Создание нового клиента",
            responses = {
                    @ApiResponse(
                            description = "Успешный ответ", responseCode = "200",
                            content = @Content(schema = @Schema(implementation = Client.class))
                    ),
                    @ApiResponse(
                            description = "Ошибка", responseCode = "400",
                            content = @Content(schema = @Schema(implementation = AppError.class))
                    )
            }
    )
    @PostMapping("/create")
    public ResponseEntity<Client> create(@RequestBody Client client) {
        clientService.create(client);
        return ResponseEntity.ok(client);
    }

    @Operation(
            summary = "Обновить данные о клиенте",
            responses = {
                    @ApiResponse(
                            description = "Успешный ответ", responseCode = "200",
                            content = @Content(schema = @Schema(implementation = Client.class))
                    ),
                    @ApiResponse(
                            description = "Ошибка", responseCode = "400",
                            content = @Content(schema = @Schema(implementation = AppError.class))
                    )
            }
    )
    @PutMapping("/{id}/update")
    public ResponseEntity<Client> update(@RequestBody Client client, @PathVariable("id") Integer id) {
        clientService.update(client, id);
        Client cl = clientService.showById(id);
        return ResponseEntity.ok(cl);
    }

    @Operation(
            summary = "Удалить клиента по ID",
            responses = {
                    @ApiResponse(
                            description = "Успешный ответ", responseCode = "200",
                            content = @Content(schema = @Schema(implementation = Client.class))
                    ),
                    @ApiResponse(
                            description = "Ошибка", responseCode = "400",
                            content = @Content(schema = @Schema(implementation = AppError.class))
                    )
            }
    )
    @DeleteMapping("/{id}/delete")
    public ResponseEntity<Client> delete(@PathVariable("id") Integer id) {
        Client cl = clientService.showById(id);
        clientService.delete(id);
        return ResponseEntity.ok(cl);
    }
}
