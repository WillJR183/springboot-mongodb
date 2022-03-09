package com.willianmarques.sbmongodb.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.willianmarques.sbmongodb.domain.User;
import com.willianmarques.sbmongodb.repositories.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner {
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public void run(String... args) throws Exception {
		userRepository.deleteAll();
		User u1 = new User(null, "Will", "will@gmail.com");
		User u2 = new User(null, "Luis", "luis@gmail.com");
		User u3 = new User(null, "Guilherme", "gui@gmail.com");
		userRepository.saveAll(Arrays.asList(u1, u2, u3));
	}

}
