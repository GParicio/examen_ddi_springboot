package com.gparicio.recuperacion;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.gparicio.recuperacion.*")
public class RecuperacionApplication {

	public static void main(String[] args) {
		SpringApplication.run(RecuperacionApplication.class, args);
	}

}
