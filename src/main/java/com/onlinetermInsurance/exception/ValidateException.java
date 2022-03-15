package com.onlinetermInsurance.exception;

public class ValidateException extends RuntimeException {
	private static final long serialVersionUID = 4473007096654311014L;

	ValidateException(String message) {
		super(message);
	}
}