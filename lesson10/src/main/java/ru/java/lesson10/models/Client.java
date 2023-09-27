package ru.java.lesson10.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Client {
    private Integer clientId;
    private String document;
    private String surName;
    private String firstName;
    private Date birthday;
}
