package com.wendymantilla.nasa.apinasa;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;

import java.util.List;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ApinasaApplicationTests {


    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    void planetsTests() {
        List<String> planets = this.restTemplate
                .getForObject("http://localhost:" + port + "/planets", List.class);
        Assertions.assertTrue(planets.contains("Tierra"));

    }

    @Test
    void contextLoads() {
    }


}
