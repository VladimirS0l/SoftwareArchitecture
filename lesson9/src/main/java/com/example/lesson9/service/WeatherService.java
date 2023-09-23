package com.example.lesson9.service;

import com.example.lesson9.dto.WeatherForecastDto;
import com.example.lesson9.model.WeatherForecast;
import java.util.Date;
import java.util.List;

public interface WeatherService {
    List<WeatherForecast> showAll();
    List<WeatherForecast> showAllByDate(Date start, Date end);
    WeatherForecast showOne(Integer id);
    void addForecast(WeatherForecastDto forecast);
    void editForecast(WeatherForecastDto editForecast, Integer id);
    void deleteForecast(Integer id);
}
