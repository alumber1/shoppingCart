package com.hl.shoppingcart;

import java.util.List;

public class ShoppingCart {
	
	private final List<Item> items;

	public ShoppingCart(List<Item> items) {
		// TODO Auto-generated constructor stub
		this.items = items;
	}

	public double getTotal() {
		return items.stream().mapToDouble(item -> item.getPrice()).sum();
	}

}
