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
public class PlacesService {

    private final RestTemplate restTemplate;
    private final String apiKey;
    private final String baseUrl;

    public PlacesService(RestTemplate restTemplate,
                          @Value("${google.places.api.key}") String apiKey,
                          @Value("${google.places.api.base-url}") String baseUrl) {
        this.restTemplate = restTemplate;
        this.apiKey = apiKey;
        this.baseUrl = baseUrl;
    }

    public JsonNode autocomplete(String input) {
        URI uri = UriComponentsBuilder.fromHttpUrl(baseUrl + "/autocomplete/json")
                .queryParam("input", input)
                .queryParam("types", "(cities)")
                .queryParam("key", apiKey)
                .build()
                .toUri();

        try {
            return restTemplate.getForObject(uri, JsonNode.class);
        } catch (HttpStatusCodeException ex) {
            throw new UpstreamApiException(ex.getStatusCode(), ex.getStatusText());
        }
    }
}
