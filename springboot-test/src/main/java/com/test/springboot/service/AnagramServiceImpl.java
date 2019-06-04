package com.test.springboot.service;

import com.test.springboot.util.FailedAnagramServiceInitException;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Random;

@Service("anagramService")
public class AnagramServiceImpl implements AnagramService {

	private static Map<String, List<String>> stringListHashMap;
	private Random random = new Random();

	static {
		populateCache();
	}

	private static void populateCache() throws RuntimeException {
		stringListHashMap = new HashMap<String, List<String>>();
		String currentLine;
		try (InputStreamReader fileReader = new InputStreamReader(new ClassPathResource("words_alpha.txt").getInputStream()); BufferedReader bufferedReader = new BufferedReader(fileReader)) {
			while ((currentLine = bufferedReader.readLine()) != null) {
				char[] charArray = currentLine.trim().toCharArray();
				Arrays.sort(charArray);
				stringListHashMap.computeIfAbsent(String.valueOf(charArray), k -> new ArrayList<String>()).add(currentLine.trim());
			}
		} catch (IOException ioException) {
			throw new FailedAnagramServiceInitException("Failed to initialize Anagram service. "+ioException.getMessage(), ioException);
		}
	}

	public String findAnagram(String string) {
		char[] charArray = string.toCharArray();
		Arrays.sort(charArray);
		List<String> anagrams = stringListHashMap.get(String.valueOf(charArray));
		return anagrams.get(random.nextInt(anagrams.size()));
	}

	public String findAnagram(String... strings) {
		StringBuilder stringBuilder = new StringBuilder();
		for(String string: strings)
			stringBuilder.append(findAnagram(string)).append(' ');
		return stringBuilder.toString().trim();
	}

}
