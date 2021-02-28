package com.example.ggd;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class GgdApplication {

	public static void main(String[] args) {
		SpringApplication.run(GgdApplication.class, args);
	}
}
