package com.wendymantilla.nasa.apinasa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class ApinasaApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApinasaApplication.class, args);
	}

}
