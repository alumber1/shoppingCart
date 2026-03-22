package com.hl.shoppingcart;

import java.util.List;

public class ShoppingCart {
	
	private final List<Item> items;

	public ShoppingCart(List<Item> items) {
		// TODO Auto-generated constructor stub
		this.items = items;
	}

	public double getTotal() {
		// TODO Auto-generated method stub
		if(items.isEmpty())
			return 0.0;
		return items.get(0).getPrice();
	}

}
