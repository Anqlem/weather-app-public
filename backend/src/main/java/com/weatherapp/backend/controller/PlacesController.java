package com.weatherapp.backend.controller;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.weatherapp.backend.service.PlacesService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/places")
public class PlacesController {

    private final PlacesService placesService;
    private final ObjectMapper objectMapper;

    public PlacesController(PlacesService placesService, ObjectMapper objectMapper) {
        this.placesService = placesService;
        this.objectMapper = objectMapper;
    }

    @GetMapping("/autocomplete")
    public ResponseEntity<JsonNode> autocomplete(@RequestParam(required = false) String input) {
        if (input == null || input.isBlank()) {
            ObjectNode empty = objectMapper.createObjectNode();
            empty.putArray("predictions");
            return ResponseEntity.ok(empty);
        }
        return ResponseEntity.ok(placesService.autocomplete(input));
    }
}
