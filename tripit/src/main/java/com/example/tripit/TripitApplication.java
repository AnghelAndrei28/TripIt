package com.example.tripit;

import com.example.tripit.persistance.Role;
import com.example.tripit.persistance.RoleRepository;
import com.example.tripit.persistance.User;
import com.example.tripit.persistance.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class TripitApplication {

	public static void main(String[] args) {
		SpringApplication.run(TripitApplication.class, args);
	}
}
