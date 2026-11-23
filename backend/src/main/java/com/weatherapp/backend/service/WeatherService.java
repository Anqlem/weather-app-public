package com.weatherapp.backend.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.weatherapp.backend.exception.UpstreamApiException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@Service
public class WeatherService {

    private final RestTemplate restTemplate;
    private final String apiKey;
    private final String baseUrl;

    public WeatherService(RestTemplate restTemplate,
                           @Value("${openweather.api.key}") String apiKey,
                           @Value("${openweather.api.base-url}") String baseUrl) {
        this.restTemplate = restTemplate;
        this.apiKey = apiKey;
        this.baseUrl = baseUrl;
    }

    public JsonNode getCurrentWeather(String city) {
        URI uri = buildUri("/weather", city);
        return fetch(uri);
    }

    public JsonNode getForecast(String city) {
        URI uri = buildUri("/forecast", city);
        return fetch(uri);
    }

    private URI buildUri(String path, String city) {
        return UriComponentsBuilder.fromHttpUrl(baseUrl + path)
                .queryParam("q", city)
                .queryParam("appid", apiKey)
                .queryParam("units", "metric")
                .build()
                .toUri();
    }

    private JsonNode fetch(URI uri) {
        try {
            return restTemplate.getForObject(uri, JsonNode.class);
        } catch (HttpStatusCodeException ex) {
            throw new UpstreamApiException(ex.getStatusCode(), ex.getStatusText());
        }
    }
}
