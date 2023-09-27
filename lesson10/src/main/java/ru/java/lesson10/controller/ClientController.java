package ru.java.lesson10.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.java.lesson10.models.Client;
import ru.java.lesson10.service.ClientService;

import java.util.List;

@RestController
@RequestMapping("/client")
public class ClientController {
    private final ClientService clientService;

    @Autowired
    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Client>> showAll(){
        List<Client> clients = clientService.showAllClient();
        return ResponseEntity.ok(clients);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Client> showByID(@PathVariable("id") Integer id) {
        Client client = clientService.showById(id);
        return ResponseEntity.ok(client);
    }

    @PostMapping("/create")
    public ResponseEntity<Client> create(@RequestBody Client client) {
        clientService.create(client);
        return ResponseEntity.ok(client);
    }

    @PutMapping("/{id}/update")
    public ResponseEntity<Client> update(@RequestBody Client client, @PathVariable("id") Integer id) {
        clientService.update(client, id);
        Client cl = clientService.showById(id);
        return ResponseEntity.ok(cl);
    }

    @DeleteMapping("/{id}/delete")
    public ResponseEntity<Client> delete(@PathVariable("id") Integer id) {
        Client cl = clientService.showById(id);
        clientService.delete(id);
        return ResponseEntity.ok(cl);
    }
}
