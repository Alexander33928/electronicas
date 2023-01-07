package com.urna.electronica;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class ElectronicaApplication {

	public static void main(String[] args) {
		SpringApplication.run(ElectronicaApplication.class, args);
	}

}
