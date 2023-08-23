package com.example.test_1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = {"http://192.168.49.2:31390", "http://localhost:8081", "http://localhost:8080"})
@SpringBootApplication
@EnableJpaAuditing
public class Test1Application {
	public static void main(String[] args) {
		SpringApplication.run(Test1Application.class, args);
	}

}
