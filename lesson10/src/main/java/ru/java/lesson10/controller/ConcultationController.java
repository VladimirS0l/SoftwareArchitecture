package ru.java.lesson10.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.java.lesson10.models.Client;
import ru.java.lesson10.models.Consultation;
import ru.java.lesson10.repository.impl.ConsultationRepository;
import ru.java.lesson10.service.ConsultationService;

import java.util.List;

@RestController
@RequestMapping("/cons")
public class ConcultationController {

    private final ConsultationService consultationService;

    @Autowired
    public ConcultationController(ConsultationService consultationService) {
        this.consultationService = consultationService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Consultation>> showAll(){
        List<Consultation> consultations  = consultationService.showAllConsultations();
        return ResponseEntity.ok(consultations);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Consultation> showByID(@PathVariable("id") Integer id) {
        Consultation consultation = consultationService.showById(id);
        return ResponseEntity.ok(consultation);
    }

    @PostMapping("/create")
    public ResponseEntity<Consultation> create(@RequestBody Consultation consultation) {
        consultationService.create(consultation);
        return ResponseEntity.ok(consultation);
    }

    @PutMapping("/{id}/update")
    public ResponseEntity<Consultation> update(@RequestBody Consultation consultation, @PathVariable("id") Integer id) {
        consultationService.update(consultation, id);
        Consultation cl = consultationService.showById(id);
        return ResponseEntity.ok(cl);
    }

    @DeleteMapping("/{id}/delete")
    public ResponseEntity<Consultation> delete(@PathVariable("id") Integer id) {
        Consultation cl = consultationService.showById(id);
        consultationService.delete(id);
        return ResponseEntity.ok(cl);
    }
}
