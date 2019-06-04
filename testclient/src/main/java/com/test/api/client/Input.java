package com.test.api.client;

import java.io.Serializable;

public class Input implements Serializable {

	private static final long serialVersionUID = 1L;

	private String phrase;

	public Input(String phrase) {
		this.phrase = phrase;
	}

	public String getPhrase() {
		return phrase;
	}

}
