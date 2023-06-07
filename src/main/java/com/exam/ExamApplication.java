package com.exam;

import com.exam.models.User;
import com.exam.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ExamApplication implements CommandLineRunner {

	@Autowired
	private UserService userService;
	public static void main(String[] args) {

		SpringApplication.run(ExamApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Starting");
		User user = new User();
		user.setFirstName("Anjeel");
		user.setLastName("Chaudhary");
		user.setUsername("Anjeel123");
		user.setPassword("");
	}
}
