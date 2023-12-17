package com.pizzamanagementsystem.exception;

public class PizzaOrderNotFoundException extends RuntimeException {
	public PizzaOrderNotFoundException(String msg) {
		super(msg);
	}
}
