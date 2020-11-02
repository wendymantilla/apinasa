package com.wendymantilla.nasa.apinasa.controllers;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class PlanetController {
    
    String [] planets = {"Tierra","Marte","Jupiter","Saturno","Pluton", "Mercurio", "Venus"};


    @GetMapping("/planets")
    public List<String> getPlanets(){
        return Arrays.asList(planets);
    }


}
