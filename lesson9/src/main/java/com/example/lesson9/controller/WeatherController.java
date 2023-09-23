package com.example.lesson9.controller;

import com.example.lesson9.dto.WeatherForecastDto;
import com.example.lesson9.model.WeatherForecast;
import com.example.lesson9.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/weather")
public class WeatherController {

    private WeatherService weatherService;

    @Autowired
    public WeatherController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<WeatherForecast>> getAllWeather() {
        return new ResponseEntity<>(weatherService.showAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<WeatherForecast> getOneForecast(@PathVariable("id") Integer id) {
        return new ResponseEntity<>(weatherService.showOne(id), HttpStatus.OK);
    }

    @GetMapping("/get")
    public ResponseEntity<List<WeatherForecast>> getAllByDate(@RequestParam("start") Date start,
                                                              @RequestParam("end") Date end) {
        return new ResponseEntity<>(weatherService.showAllByDate(start, end), HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<HttpStatus> addForecast(@RequestBody WeatherForecastDto weatherForecast) {
        weatherService.addForecast(weatherForecast);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/{id}/edit")
    public ResponseEntity<HttpStatus> editForecast(@PathVariable("id") Integer id,
                                                   @RequestBody WeatherForecastDto editForecast) {
        weatherService.editForecast(editForecast, id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}/delete")
    public ResponseEntity<HttpStatus> editForecast(@PathVariable("id") Integer id) {
        weatherService.deleteForecast(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
