package com.test.springboot.service;

public interface AnagramService {

	String findAnagram(String string);

	String findAnagram(String... string);

}
