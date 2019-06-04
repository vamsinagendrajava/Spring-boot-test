package com.test.api.client;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.Objects;
import java.util.Scanner;

public class ApiClient {

	public static void main(String[] args) {
		ApiClient.run();
	}

	public static void run() {
		RestTemplate restTemplate = new RestTemplate();
		int retryCount = 1;
		try (Scanner scanner = new Scanner(System.in)) {
			System.out.println("Enter your string: ");
			String userInput = scanner.nextLine();
			if (userInput.trim().length() > 0) {
				while (true) {
					HttpHeaders headers = new HttpHeaders();
					headers.setContentType(MediaType.APPLICATION_JSON);
					ResponseEntity<Result> response = restTemplate.exchange("http://" + System.getProperty("spring-boot-app-host-ip") + ":3000/anagram", HttpMethod.POST, new HttpEntity<Input>(new Input(userInput), headers), Result.class);
					if (userInput.equals(Objects.requireNonNull(response.getBody()).getAnagram()))
						break;
					else
						retryCount++;
				}
				System.out.println("retryCount: " + retryCount);
			}
		}
	}

}
