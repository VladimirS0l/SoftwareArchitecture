package ru.java.lesson10.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.java.lesson10.models.Consultation;
import ru.java.lesson10.models.Pet;
import ru.java.lesson10.repository.impl.ConsultationRepository;
import ru.java.lesson10.repository.impl.PetRepository;

import java.util.List;

@Service
public class PetService {
    private final PetRepository petRepository;

    @Autowired
    public PetService(PetRepository petRepository) {
        this.petRepository = petRepository;
    }

    public List<Pet> showAllPets() {
        return petRepository.findAll();
    }

    public Pet showById(Integer id) {
        return petRepository.findById(id);
    }

    public void create(Pet pet) {
        petRepository.save(pet);
    }

    public void update(Pet pet, Integer id) {
        petRepository.update(pet, id);
    }

    public void delete(Integer id) {
        petRepository.delete(id);
    }
}
