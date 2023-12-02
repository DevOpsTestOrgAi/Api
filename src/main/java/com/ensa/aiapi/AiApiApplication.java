package com.ensa.aiapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class AiApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(AiApiApplication.class, args);
	}

}
