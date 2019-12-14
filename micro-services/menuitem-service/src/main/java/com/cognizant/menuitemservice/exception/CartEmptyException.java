package com.cognizant.menuitemservice.exception;

public class CartEmptyException extends Exception {
	public CartEmptyException() {
		super("\nCart is Empty");
	}
}
