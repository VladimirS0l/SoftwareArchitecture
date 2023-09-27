package ru.java.lesson10.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.java.lesson10.models.Client;
import ru.java.lesson10.repository.impl.ClientRepository;

import java.util.List;

@Service
public class ClientService {

    private final ClientRepository clientRepository;

    @Autowired
    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public List<Client> showAllClient() {
        return clientRepository.findAll();
    }

    public Client showById(Integer id) {
        return clientRepository.findById(id);
    }

    public void create(Client client) {
        clientRepository.save(client);
    }

    public void update(Client client, Integer id) {
        clientRepository.update(client, id);
    }

    public void delete(Integer id) {
        clientRepository.delete(id);
    }
}
