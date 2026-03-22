package com.hl.shoppingcart;

public class Item {

	private double price = 0;
	private int quantity = 0;


	public Item(double price, int quantity) {

		if (price < 0) {
			throw new IllegalArgumentException("Price cannot be negative");
		}

		if (quantity <= 0) {
			throw new IllegalArgumentException("Quantity cannot be negative");
		}

		this.price = price;
		this.quantity = quantity;

	}

	public double getItemTotal() {
		return price * quantity;
	}
}
