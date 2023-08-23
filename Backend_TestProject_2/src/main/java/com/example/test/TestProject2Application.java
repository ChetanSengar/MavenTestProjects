package com.example.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@SpringBootApplication
public class TestProject2Application {

	public static void main(String[] args) {
		SpringApplication.run(TestProject2Application.class, args);
	}
	@Bean
	public ExecutorService executorService() {
		return Executors.newFixedThreadPool(10);
	}
}
