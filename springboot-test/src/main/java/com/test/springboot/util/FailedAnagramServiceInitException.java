package com.test.springboot.util;

public class FailedAnagramServiceInitException extends RuntimeException {

	private static final long serialVersionUID = 5162710183389028792L;

	public FailedAnagramServiceInitException(String message, Throwable throwable) {
		super(message, throwable);
	}

	public FailedAnagramServiceInitException(Throwable throwable) {
		super(throwable);
	}

}
