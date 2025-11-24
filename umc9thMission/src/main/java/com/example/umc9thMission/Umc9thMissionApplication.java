package com.example.umc9thMission;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class Umc9thMissionApplication {

	public static void main(String[] args) {
		SpringApplication.run(Umc9thMissionApplication.class, args);
	}

}
