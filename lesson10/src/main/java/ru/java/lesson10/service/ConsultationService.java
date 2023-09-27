package ru.java.lesson10.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.java.lesson10.models.Consultation;
import ru.java.lesson10.repository.impl.ConsultationRepository;

import java.util.List;

@Service
public class ConsultationService {

    private final ConsultationRepository consultationRepository;

    @Autowired
    public ConsultationService(ConsultationRepository consultationRepository) {
        this.consultationRepository = consultationRepository;
    }

    public List<Consultation> showAllConsultations() {
        return consultationRepository.findAll();
    }

    public Consultation showById(Integer id) {
        return consultationRepository.findById(id);
    }

    public void create(Consultation consultation) {
        consultationRepository.save(consultation);
    }

    public void update(Consultation consultation, Integer id) {
        consultationRepository.update(consultation, id);
    }

    public void delete(Integer id) {
        consultationRepository.delete(id);
    }
}
