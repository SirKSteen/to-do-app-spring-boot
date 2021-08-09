package com.todoapp.rest.webservices.ToDoAppPro;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.todoapp.rest.webservices.ToDoAppPro.toDo.ToDoJPARepository;

@SpringBootApplication
@EnableJpaRepositories(basePackageClasses = ToDoJPARepository.class)
public class ToDoAppProApplication {

	public static void main(String[] args) {
		SpringApplication.run(ToDoAppProApplication.class, args);
	}

}
