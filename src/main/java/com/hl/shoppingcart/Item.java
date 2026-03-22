package com.hl.shoppingcart;

public class Item {

	private double price = 0;
	private int quantity = 0;

	
	public Item(double price, int quantity) {
		this.price = price;
		this.quantity = quantity;
		
	}
	
	public double getItemTotal() {
		return price * quantity;
	}
}
