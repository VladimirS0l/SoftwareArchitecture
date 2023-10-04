package ru.java.model;

import java.sql.Timestamp;
import java.util.Date;

public class Client {
    private Integer clientId;
    private String document;
    private String surName;
    private String firstName;
    private Date birthday;

    public Client(Integer clientId, String document, String surName, String firstName, Date birthday) {
        this.clientId = clientId;
        this.document = document;
        this.surName = surName;
        this.firstName = firstName;
        this.birthday = birthday;
    }

    public Client() {
    }

    public Integer getClientId() {
        return clientId;
    }

    public void setClientId(Integer clientId) {
        this.clientId = clientId;
    }

    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = document;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "Client{" +
                "clientId=" + clientId +
                ", document='" + document + '\'' +
                ", surName='" + surName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", birthday=" + birthday +
                '}';
    }
}
