package com.pizzamanagementsystem.exception;

public class PizzaNotFoundException extends RuntimeException {
	public PizzaNotFoundException(String msg) {
		super(msg);
	}
}
