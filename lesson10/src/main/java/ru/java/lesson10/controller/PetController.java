package ru.java.lesson10.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.java.lesson10.models.Client;
import ru.java.lesson10.models.Pet;
import ru.java.lesson10.service.PetService;

import java.util.List;

@RestController
@RequestMapping("/pet")
public class PetController {
    private final PetService petService;

    @Autowired
    public PetController(PetService petService) {
        this.petService = petService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Pet>> showAll(){
        List<Pet> pets = petService.showAllPets();
        return ResponseEntity.ok(pets);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pet> showByID(@PathVariable("id") Integer id) {
        Pet pet = petService.showById(id);
        return ResponseEntity.ok(pet);
    }

    @PostMapping("/create")
    public ResponseEntity<Pet> create(@RequestBody Pet pet) {
        petService.create(pet);
        return ResponseEntity.ok(pet);
    }

    @PutMapping("/{id}/update")
    public ResponseEntity<Pet> update(@RequestBody Pet pet, @PathVariable("id") Integer id) {
        petService.update(pet, id);
        Pet upPet = petService.showById(id);
        return ResponseEntity.ok(upPet);
    }

    @DeleteMapping("/{id}/delete")
    public ResponseEntity<Pet> delete(@PathVariable("id") Integer id) {
        Pet delPet = petService.showById(id);
        petService.delete(id);
        return ResponseEntity.ok(delPet);
    }
}
