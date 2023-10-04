package ru.java.lesson10.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import ru.java.lesson10.exception.NotFoundModelException;
import ru.java.lesson10.models.Client;
import ru.java.lesson10.models.Pet;
import ru.java.lesson10.repository.impl.PetRepository;

import java.util.List;

@Repository
public class PetRepositoryImpl implements PetRepository {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public PetRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Pet> findAll() {
        return jdbcTemplate.query("SELECT * FROM pet", new BeanPropertyRowMapper<>(Pet.class));
    }

    @Override
    public Pet findById(Integer id) {
        return jdbcTemplate.query("SELECT * FROM pet WHERE pet_id=?", new Object[]{id},
                        new BeanPropertyRowMapper<>(Pet.class)).stream()
                .filter((c) -> c.getPetId() == id)
                .findFirst().orElseThrow(()-> new NotFoundModelException("Pet not found by ID"));
    }

    @Override
    public void save(Pet pet) {
        jdbcTemplate.update("INSERT INTO pet(client_id, name, birthday) " +
                        "VALUES (?,?,?)", pet.getClientId(), pet.getName(), pet.getBirthday());
    }

    @Override
    public void update(Pet updatePet, Integer id) {
        jdbcTemplate.update("UPDATE pet SET client_id=?, name=?, birthday=?" +
                        "WHERE pet_id=?", updatePet.getClientId(), updatePet.getName(),
                updatePet.getBirthday(), id);
    }

    @Override
    public void delete(Integer id) {
        jdbcTemplate.update("DELETE FROM pet WHERE pet_id=?", id);
    }
}
