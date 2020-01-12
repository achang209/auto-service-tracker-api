package com.example.autoservicetrackerapi;

import com.example.autoservicetrackerapi.services.StorageProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties({StorageProperties.class})
public class AutoServiceTrackerApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(AutoServiceTrackerApiApplication.class, args);
	}

}
