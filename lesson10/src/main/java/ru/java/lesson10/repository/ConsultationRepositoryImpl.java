package ru.java.lesson10.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import ru.java.lesson10.exception.NotFoundModelException;
import ru.java.lesson10.models.Consultation;
import ru.java.lesson10.repository.impl.ConsultationRepository;

import java.util.List;

@Repository
public class ConsultationRepositoryImpl implements ConsultationRepository {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public ConsultationRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Consultation> findAll() {
        return jdbcTemplate.query("SELECT * FROM consultation", new BeanPropertyRowMapper<>(Consultation.class));
    }

    @Override
    public Consultation findById(Integer id) {
        return jdbcTemplate.query("SELECT * FROM consultation WHERE consultation_id=?", new Object[]{id},
                        new BeanPropertyRowMapper<>(Consultation.class)).stream()
                .filter((c) -> c.getConsultationId() == id)
                .findFirst().orElseThrow(()-> new NotFoundModelException("Consultation not found by ID"));
    }

    @Override
    public void save(Consultation consultation) {
        jdbcTemplate.update("INSERT INTO consultation(client_id, pet_id, consultation_date, description) " +
                        "VALUES (?,?,?,?)", consultation.getClientId(), consultation.getPetId(),
                consultation.getConsultationDate(), consultation.getDescription());
    }

    @Override
    public void update(Consultation consultation, Integer id) {
        jdbcTemplate.update("UPDATE consultation SET client_id=?, pet_id=?, consultation_date=?, description=? " +
                        "WHERE consultation_id=?", consultation.getClientId(), consultation.getPetId(),
                consultation.getConsultationDate(), consultation.getDescription(), id);
    }

    @Override
    public void delete(Integer id) {
        jdbcTemplate.update("DELETE FROM consultation WHERE consultation_id=?", id);
    }
}
