package com.qa.opencart.pages;

import org.openqa.selenium.By;

public class CartPage {

	private By cart = By.id("cart");

	public void cart() {
		System.out.println("cart using" + cart);
	}
}
