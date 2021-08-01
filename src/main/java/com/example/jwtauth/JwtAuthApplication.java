package com.example.jwtauth;

import com.example.jwtauth.model.Role;
import com.example.jwtauth.model.User;
import com.example.jwtauth.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;

@SpringBootApplication
public class JwtAuthApplication {

	public static void main(String[] args) {
		SpringApplication.run(JwtAuthApplication.class, args);
	}

	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	CommandLineRunner run(UserService userService) {
		return args -> {
			userService.saveRole(new Role(null, "ROLE_USER"));
			userService.saveRole(new Role(null, "ROLE_MANAGER"));
			userService.saveRole(new Role(null, "ROLE_ADMIN"));
			userService.saveRole(new Role(null, "ROLE_SUPER_ADMIN"));

			userService.saveUser(new User(null, "Cheikh Omar SOW", "cosinus", "1234", new ArrayList<>()));
			userService.saveUser(new User(null, "Abdoulaye BA", "mbeur", "1234", new ArrayList<>()));
			userService.saveUser(new User(null, "Mamadou SOW", "fouta", "1234", new ArrayList<>()));
			userService.saveUser(new User(null, "Rassoul SOW", "rassoul", "1234", new ArrayList<>()));

			userService.addRoleToUser("cosinus", "ROLE_USER");
			userService.addRoleToUser("mbeur", "ROLE_MANAGER");
			userService.addRoleToUser("fouta", "ROLE_ADMIN");
			userService.addRoleToUser("rassoul", "ROLE_USER");
			userService.addRoleToUser("rassoul", "ROLE_MANAGER");
			userService.addRoleToUser("rassoul", "ROLE_ADMIN");
			userService.addRoleToUser("rassoul", "ROLE_SUPER_ADMIN");
		};
	}

}
