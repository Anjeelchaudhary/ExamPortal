package com.exam;

import com.exam.models.Role;
import com.exam.models.User;
import com.exam.models.UserRole;
import com.exam.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashSet;
import java.util.Set;

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
		user.setEmail("abc@gmail.com");

		Role rol1 = new Role();
		rol1.setRoleId(44L);
		rol1.setRoleName("ADMIN");

		Set<UserRole> userRolesSet = new HashSet<>();
		UserRole userRole = new UserRole();
		userRole.setRole(rol1);
		userRole.setUser(user);

		userRolesSet.add(userRole);

		User user1 = this.userService.createUser(user,userRolesSet);
		System.out.println(user1.getUsername());
	}
}
