package com.game.orangeblood;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class OrangebloodApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrangebloodApplication.class, args);
	}

}
