package com.wendymantilla.nasa.apinasa.controllers;


import com.wendymantilla.nasa.apinasa.domain.Apod;
import com.wendymantilla.nasa.apinasa.services.ApiNasaService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class PlanetController {

    private final static String[] planets = {"Tierra", "Marte", "Jupiter", "Saturno", "Pluton", "Mercurio", "Venus"};

    @Value("${apinasa.apikey}")
    private String apikey;

    private final ApiNasaService apiNasaService;

    @GetMapping("/apinasa")
    public ResponseEntity<Apod> getApod(@RequestParam String date) {
        Apod apod = apiNasaService.getApod(date, apikey);
        return ResponseEntity.ok(apod);
    }


    @GetMapping("/planets")
    public List<String> getPlanets() {
        return Arrays.asList(planets);
    }


}
