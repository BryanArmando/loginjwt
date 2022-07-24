package com.login.loginjwt;

import com.login.loginjwt.domain.Role;
import com.login.loginjwt.domain.User;
import com.login.loginjwt.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;

@SpringBootApplication
public class LoginjwtApplication {

	public static void main(String[] args) {
		SpringApplication.run(LoginjwtApplication.class, args);
	}


	@Bean
	PasswordEncoder passwordEncoder(){
		return new BCryptPasswordEncoder();
	}




	@Bean
	CommandLineRunner run(UserService userService){
		return  args -> {
			userService.saveRole(new Role(null, "ROLE_USER"));
			userService.saveRole(new Role(null, "ROLE_ADMIN"));

			userService.saveUser(new User(null, "Bryan", "Armand", "1234", new ArrayList<>()));
			userService.saveUser(new User(null, "Armando", "Br", "1234", new ArrayList<>()));

			userService.addRoleToUser("Armand", "ROLE_ADMIN");
			userService.addRoleToUser("Br", "ROLE_USER");
		};
	}



}
