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
public class Consultation {
    private Integer consultationId;
    private Integer clientId;
    private Integer petId;
    private Date consultationDate;
    private String description;
}
