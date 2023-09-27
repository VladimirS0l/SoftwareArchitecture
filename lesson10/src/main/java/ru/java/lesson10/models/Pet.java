package ru.java.lesson10.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.xml.crypto.Data;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Pet {
    private Integer petId;
    private Integer clientId;
    private String name;
    private Date birthday;
}
