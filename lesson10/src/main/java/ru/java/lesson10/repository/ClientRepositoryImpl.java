package ru.java.lesson10.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import ru.java.lesson10.exception.NotFoundModelException;
import ru.java.lesson10.models.Client;
import ru.java.lesson10.repository.impl.ClientRepository;

import java.util.List;

@Repository
public class ClientRepositoryImpl implements ClientRepository {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public ClientRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Client> findAll() {
        return jdbcTemplate.query("SELECT * FROM client", new BeanPropertyRowMapper<>(Client.class));
    }

    @Override
    public Client findById(Integer clientId) {
        return jdbcTemplate.query("SELECT * FROM client WHERE client_id=?", new Object[]{clientId},
                new BeanPropertyRowMapper<>(Client.class)).stream()
                .filter((c) -> c.getClientId() == clientId)
                .findFirst().orElseThrow(()-> new NotFoundModelException("Client not found by ID"));
    }

    @Override
    public void save(Client client) {
        jdbcTemplate.update("INSERT INTO client(document, surname, firstname, birthday) " +
                "VALUES (?,?,?,?)", client.getDocument(), client.getSurName(),
                client.getFirstName(), client.getBirthday());
    }

    @Override
    public void update(Client updateClient, Integer clientId) {
        jdbcTemplate.update("UPDATE client SET document=?, surname=?, firstname=?, birthday=? " +
                "WHERE client_id=?", updateClient.getDocument(), updateClient.getSurName(),
                updateClient.getFirstName(), updateClient.getBirthday(), clientId);
    }

    @Override
    public void delete(Integer clientId) {
        jdbcTemplate.update("DELETE FROM client WHERE client_id=?", clientId);
    }
}
