package com.example.lesson9.service;

import com.example.lesson9.dto.WeatherForecastDto;
import com.example.lesson9.exception.ForecastNotFoundException;
import com.example.lesson9.model.WeatherForecast;
import com.example.lesson9.repository.WeatherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Date;
import java.util.List;

@Service
public class WeatherServiceImpl implements WeatherService{

    private WeatherRepository weatherRepository;

    @Autowired
    public WeatherServiceImpl(WeatherRepository weatherRepository) {
        this.weatherRepository = weatherRepository;
    }


    @Override
    public List<WeatherForecast> showAll() {
        return weatherRepository.findAll();
    }

    @Override
    public List<WeatherForecast> showAllByDate(Date start, Date end) {
        return weatherRepository.findAllByDateForecastBetweenOrderByDateForecast(start, end);
    }

    @Override
    public WeatherForecast showOne(Integer id) {
        return weatherRepository.findById(id).orElseThrow(()-> new ForecastNotFoundException("По этому ID значение не найдено"));
    }

    @Override
    public void addForecast(WeatherForecastDto forecastDto) {
        WeatherForecast forecast = new WeatherForecast();
        forecast.setDateForecast(forecastDto.getDateForecast());
        forecast.setTemperatureC(forecastDto.getTemperatureC());
        int temp = (int) ((forecast.getTemperatureC() / 0.5556) + 32);
        forecast.setTemperatureF(temp);
        weatherRepository.save(forecast);
    }

    @Override
    public void editForecast(WeatherForecastDto editForecast, Integer id) {
        WeatherForecast forecast = new WeatherForecast();
        forecast.setId(id);
        forecast.setDateForecast(editForecast.getDateForecast());
        forecast.setTemperatureC(editForecast.getTemperatureC());
        int temp = (int) ((forecast.getTemperatureC() / 0.5556) + 32);
        forecast.setTemperatureF(temp);
        weatherRepository.save(forecast);
    }

    @Override
    public void deleteForecast(Integer id) {
        weatherRepository.deleteById(id);
    }
}
