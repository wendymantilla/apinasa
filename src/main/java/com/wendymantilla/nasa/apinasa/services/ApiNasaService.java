package com.wendymantilla.nasa.apinasa.services;

import com.wendymantilla.nasa.apinasa.domain.Apod;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Api Nasa REST Service
 */
@FeignClient(value = "apinasa", url = "https://api.nasa.gov")
public interface ApiNasaService {

    @RequestMapping(method = RequestMethod.GET, value = "/planetary/apod")
    Apod getApod(@RequestParam("date") String date, @RequestParam("api_key") String apiKey);
}
