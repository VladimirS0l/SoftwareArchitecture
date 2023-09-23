package com.example.lesson9.repository;

import com.example.lesson9.model.WeatherForecast;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Date;
import java.util.List;

@Repository
public interface WeatherRepository extends JpaRepository<WeatherForecast, Integer> {
    List<WeatherForecast> findAllByDateForecastBetweenOrderByDateForecast(Date dateForecast, Date dateForecast2);
}
