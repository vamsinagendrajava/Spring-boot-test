package com.test.springboot.controller;

import com.test.springboot.model.Input;
import com.test.springboot.model.Result;
import com.test.springboot.service.AnagramService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/anagram")
public class RestApiController {

	@Autowired
	private AnagramService anagramService;

	@RequestMapping(method = {RequestMethod.GET, RequestMethod.POST}, consumes = "application/json", produces = "application/json")
	public ResponseEntity<Result> findAnagram(@Validated @RequestBody Input input) {
		Result result = new Result();
		result.setAnagram(anagramService.findAnagram(input.getPhrase().split("\\s+")));
		return new ResponseEntity<Result>(result, HttpStatus.OK);
	}

}
