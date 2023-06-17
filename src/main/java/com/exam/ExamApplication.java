package com.exam;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class ExamApplication implements CommandLineRunner {

	public static void main(String[] args) {

		SpringApplication.run(ExamApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Starting");
//		Using generated security password: 03e58134-d897-4c4d-a6a7-e51b57c90297
	}
}
