package com.example.lesson9.model;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
public class WeatherForecast {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Date dateForecast;
    private Integer temperatureC;
    private Integer temperatureF;

    public WeatherForecast() {
    }

    public WeatherForecast(Date dateForecast, Integer temperatureC) {
        this.dateForecast = dateForecast;
        this.temperatureC = temperatureC;
    }
}
