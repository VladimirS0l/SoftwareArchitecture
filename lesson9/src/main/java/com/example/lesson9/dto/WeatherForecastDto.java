package com.example.lesson9.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class WeatherForecastDto {
    private Date dateForecast;
    private Integer temperatureC;
}
