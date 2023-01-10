package com.example.demo;

import java.util.Arrays;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class AdFullstackProjectApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext configurableApplicationContext = SpringApplication.run(AdFullstackProjectApplication.class, args);
		
		UserTypeRepository userTypeRepository = configurableApplicationContext.getBean(UserTypeRepository.class);
		
		UserType userType = new UserType("Developer");
		User user1 = new User("Didier", "Anthony", "tony@test.fr", userType);
		List<User> users = Arrays.asList(user1);
		userType.setUsers(users);
		userTypeRepository.save(userType);
	}

}
