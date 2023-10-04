package ru.java.response;

import ru.java.model.Client;

import java.util.List;

public class ResponseClient {
    private List<Client> clients;

    public List<Client> getClients() {
        return clients;
    }

    public void setClients(List<Client> clients) {
        this.clients = clients;
    }

}
