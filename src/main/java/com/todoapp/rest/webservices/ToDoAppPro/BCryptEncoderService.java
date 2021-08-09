package com.todoapp.rest.webservices.ToDoAppPro;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class BCryptEncoderService {

	public static void main(String[] args) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

		
			String encodedString = 
					encoder.encode("123");
			System.out.println(encodedString);

	}
}
