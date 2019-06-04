package com.test.springboot.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.io.Serializable;

public class Input implements Serializable {

	private static final long serialVersionUID = 1L;

	@NotNull(message = "phrase cannot be null")
	@Pattern(regexp = "^[A-Za-z\\s]*$", message = "phrase should contain alphabetical characters only")
	@Size(min = 1, max = 1024, message = "phrase must be of length ranging from 1 to 1024 characters")
	private String phrase;

	public String getPhrase() {
		return phrase;
	}

	public void setPhrase(String phrase) {
		this.phrase = phrase;
	}

}
