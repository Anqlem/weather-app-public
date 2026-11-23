package com.weatherapp.backend.controller;

import com.fasterxml.jackson.databind.JsonNode;
import com.weatherapp.backend.service.WeatherService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/weather")
public class WeatherController {

    private final WeatherService weatherService;

    public WeatherController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @GetMapping("/current")
    public ResponseEntity<JsonNode> getCurrentWeather(@RequestParam String city) {
        return ResponseEntity.ok(weatherService.getCurrentWeather(city));
    }

    @GetMapping("/forecast")
    public ResponseEntity<JsonNode> getForecast(@RequestParam String city) {
        return ResponseEntity.ok(weatherService.getForecast(city));
    }
}
